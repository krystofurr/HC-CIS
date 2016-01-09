<?php

/**

d888b  db    db d88888b .d8888. d888888b   d8888b.  .d88b.   .d88b.  db   dD
88' Y8b 88    88 88'     88'  YP `~~88~~'   88  `8D .8P  Y8. .8P  Y8. 88 ,8P'
88      88    88 88ooooo `8bo.      88      88oooY' 88    88 88    88 88,8P
88  ooo 88    88 88~~~~~   `Y8b.    88      88~~~b. 88    88 88    88 88`8b
88. ~8~ 88b  d88 88.     db   8D    88      88   8D `8b  d8' `8b  d8' 88 `88.
Y888P  ~Y8888P' Y88888P `8888Y'    YP      Y8888P'  `Y88P'   `Y88P'  YP   YD


Program name:       Assignment 2 - Guest Book
Author:             Christopher Sigouin
Version:            1.0
Description:        A guest book  web application with user registration and authentication
Dependencies:       See README
Database file:      db/database.sql
Change History:     2015.10.03 Original version by CJS

 */

require('../constants.php');
define('INDEX_REDIRECT', '../index.php');


//            db       .d88b.   d888b  d888888b d8b   db
//            88      .8P  Y8. 88' Y8b   `88'   888o  88
//            88      88    88 88         88    88V8o 88
//            88      88    88 88  ooo    88    88 V8o88
//            88booo. `8b  d8' 88. ~8~   .88.   88  V888
//            Y88888P  `Y88P'   Y888P  Y888888P VP   V8P

if(isset($_POST['login'])) {

    require_once(MODEL_USER);

    session_start();

    try {
        // Sanitize
        $username = trim(filter_input(INPUT_POST, 'username', FILTER_SANITIZE_STRING));
        if (!$username) {
            throw new Exception('Invalid Username');
        }
        $password = trim(filter_input(INPUT_POST, 'password', FILTER_SANITIZE_STRING));
        if (!$password) {
            throw new Exception('Invalid Password');
        }

        // Search for user in DB and return either 'false' or 'User object'
        $user = User::findUser($username);

        // If the function returned an object ( meaning a user was found )
        if( is_object($user) ) {
            if( password_verify($password, $user->passwordHash) ) {
                // For ADMIN
                if($user->username === "admin") {
                    $_SESSION['adminLoggedIn'] = true;
                // For any other user
                } else {
                    // Password was verified.  The session will set 'IsLoggedIn' to true
                    $_SESSION['IsLoggedIn'] = true;
                }
                // Session variables to use in web views
                $_SESSION['user'] = $user;
            } else {
                // Password Invalid
                throw new Exception('Username and/or Password Incorrect.  Please re-enter');
            }

            // Re-hash password if necessary
            $currentHashAlgorithm = PASSWORD_DEFAULT;
            $currentHashOptions = array('cost' => 12);
            $passwordNeedsRehash = password_needs_rehash( $user->passwordHash, $currentHashAlgorithm, $currentHashOptions);
            if( $passwordNeedsRehash === true ) {
                $user->$passwordHash = password_hash($password, $currentHashAlgorithm, $currentHashOptions);
                // Will update the user credentials into the DB
                $user->saveUserPasswordHash($user);
            }
        // No user found.  Provide error message
        } else {
            throw new Exception('Username and/or Password Incorrect.  Please re-enter');
        }

        // Redirect back to index.php
        header('HTTP/1.1 302 Redirect');
        header('Location: '.INDEX_REDIRECT);

    } catch ( Exception $e ) {
        // Store error message in the session to view on the index page
        $_SESSION['errorMessage'] = $e->getMessage();
        header('HTTP/1.1 302 Redirect');
        header('Location: '.INDEX_REDIRECT);
    }




//            db       .d88b.   d888b     .d88b.  db    db d888888b
//            88      .8P  Y8. 88' Y8b   .8P  Y8. 88    88 `~~88~~'
//            88      88    88 88        88    88 88    88    88
//            88      88    88 88  ooo   88    88 88    88    88
//            88booo. `8b  d8' 88. ~8~   `8b  d8' 88b  d88    88
//            Y88888P  `Y88P'   Y888P     `Y88P'  ~Y8888P'    YP

} else if(isset($_POST['logout'])) {

    session_start();
    session_destroy();

    // Redirect back to index.php
    header('HTTP/1.1 302 Redirect');
    header('Location: '.INDEX_REDIRECT);

//            d8888b. d88888b  d888b  d888888b .d8888. d888888b d88888b d8888b.
//            88  `8D 88'     88' Y8b   `88'   88'  YP `~~88~~' 88'     88  `8D
//            88oobY' 88ooooo 88         88    `8bo.      88    88ooooo 88oobY'
//            88`8b   88~~~~~ 88  ooo    88      `Y8b.    88    88~~~~~ 88`8b
//            88 `88. 88.     88. ~8~   .88.   db   8D    88    88.     88 `88.
//            88   YD Y88888P  Y888P  Y888888P `8888Y'    YP    Y88888P 88   YD

} else if(isset($_POST['register'])) {

    require_once(MODEL_USER);

    session_start();

    try {

        // CAPTCHA CODE
        require_once(SECURIMAGE);
        $securimage = new Securimage();

        if ($securimage->check($_POST['captcha_code']) == false) {
            throw new Exception('Invalid CAPTCHA.  Please try again');
        }
        // CAPTCHA CODE

        // Sanitize
        $username = trim(filter_input(INPUT_POST, 'username', FILTER_SANITIZE_STRING));
        if (!$username) {
            throw new Exception('Invalid Username');
        }

        $password = trim(filter_input(INPUT_POST, 'password', FILTER_SANITIZE_STRING));
        if (!$password) {
            throw new Exception('Invalid Password');
        }

        // Create password hash ( Using 'bcrypt' by PASSWORD_DEFAULT )
        $passwordHash = password_hash($password, PASSWORD_DEFAULT, ['cost' => 12]);
        if ($passwordHash === false) {
            throw New Exception('Password hash failed');
        }

        // Attempt to register the user into the DB
        $_SESSION['User_Registered'] = User::registerUser($username, $passwordHash);

        // Redirect
        header('HTTP/1.1 302 Redirect');
        header('Location: ' . INDEX_REDIRECT);

    } catch ( Exception $e ) {

        // Store error message in the session to view on the index page
        $_SESSION['errorMessage'] = $e->getMessage();
        header('HTTP/1.1 302 Redirect');
        header('Location: '.INDEX_REDIRECT);

    }


//            .d8b.  d8888b. d8888b.    .o88b.  .d88b.  .88b  d88. .88b  d88. d88888b d8b   db d888888b
//            d8' `8b 88  `8D 88  `8D   d8P  Y8 .8P  Y8. 88'YbdP`88 88'YbdP`88 88'     888o  88 `~~88~~'
//            88ooo88 88   88 88   88   8P      88    88 88  88  88 88  88  88 88ooooo 88V8o 88    88
//            88~~~88 88   88 88   88   8b      88    88 88  88  88 88  88  88 88~~~~~ 88 V8o88    88
//            88   88 88  .8D 88  .8D   Y8b  d8 `8b  d8' 88  88  88 88  88  88 88.     88  V888    88
//            YP   YP Y8888D' Y8888D'    `Y88P'  `Y88P'  YP  YP  YP YP  YP  YP Y88888P VP   V8P    YP

} else if(isset($_POST['add'])) {

    require_once(MODEL_COMMENT);
    require_once(MODEL_USER);
    require_once(MODEL_GUEST_BOOK);

    session_start();
    // Get the user object
    $user = $_SESSION['user'];

    try {
        // SANITIZE
        $title = trim(filter_input(INPUT_POST, 'title', FILTER_SANITIZE_STRING));
        if (!$title) {
            throw new Exception('Invalid Title. Please resubmit.');
        }


        $body = $_POST['comment']; # CKEDITOR escapes it's own input data

//        $body = trim(filter_input(INPUT_POST, 'comment', FILTER_SANITIZE_STRING));
//        if (!$body) {
//            throw new Exception('Invalid Comment. Please resubmit.');
//        }

        // VALIDATE
        if( strlen($title) > MAX_TITLE_LENGTH){
            throw new Exception('Title is larger than the maximum length allowed.  Please shorten it.');
        }
        if( strlen($body) > MAX_COMMENT_LENGTH){
            throw new Exception('Comment is larger than the maximum length allowed.  Please shorten it.');
        }

        // Create a 'Comment' object and set the username for the post
        $commentObject = new Comment("", $title, $body, time(), $user->id);

        // Add the comment to the DB
        GuestBook::addComment($commentObject);
        // Count user comments for view and store back into the session
        $user->countUserComments();
        $_SESSION['user'] = $user;

        // Provide the user a message
        $_SESSION['userMessage'] = "Your comment has been added!";

        header('HTTP/1.1 302 Redirect');
        header('Location: '.INDEX_REDIRECT);

    } catch ( Exception $e ) {

        // Store error message in the session to view on the index page
        $_SESSION['errorMessage'] = $e->getMessage();
        header('HTTP/1.1 302 Redirect');
        header('Location: '.INDEX_REDIRECT);
    }

//            d88888b d8888b. d888888b d888888b    .o88b.  .d88b.  .88b  d88. .88b  d88. d88888b d8b   db d888888b
//            88'     88  `8D   `88'   `~~88~~'   d8P  Y8 .8P  Y8. 88'YbdP`88 88'YbdP`88 88'     888o  88 `~~88~~'
//            88ooooo 88   88    88       88      8P      88    88 88  88  88 88  88  88 88ooooo 88V8o 88    88
//            88~~~~~ 88   88    88       88      8b      88    88 88  88  88 88  88  88 88~~~~~ 88 V8o88    88
//            88.     88  .8D   .88.      88      Y8b  d8 `8b  d8' 88  88  88 88  88  88 88.     88  V888    88
//            Y88888P Y8888D' Y888888P    YP       `Y88P'  `Y88P'  YP  YP  YP YP  YP  YP Y88888P VP   V8P    YP

} else if(isset($_POST['edit'])) {

    require_once(MODEL_COMMENT);
    require_once(MODEL_USER);
    require_once(MODEL_GUEST_BOOK);

    session_start();
    // Get the user object
    $user = $_SESSION['user'];

    try {

        // Check to see if the user has submitted to alter a comment
        if(isset($_POST['alterTitle']) && isset($_POST['alterComment'])) {
            // Sanitize - Title
            $title = trim(filter_input(INPUT_POST, 'alterTitle', FILTER_SANITIZE_STRING));
            if (!$title) {
                throw new Exception('Invalid Title. Please resubmit.');
            }

            $body = $_POST['alterComment']; # CKEDITOR escapes it's own input data

//            // Sanitize - Comment
//            $body = trim(filter_input(INPUT_POST, 'alterComment', FILTER_SANITIZE_STRING));
//            if (!$body) {
//                throw new Exception('Invalid Comment. Please resubmit.');
//            }

            // Get the ID of the comment to edit and then clear the session value
            $comment = $_SESSION['editComment'];
            unset($_SESSION['editComment']);

            // Create a 'Comment' object and set the username for the post
            $commentObject = new Comment($comment['comm_ID'], $title, $body, time(), $user->id );
            // Update the comment in the DB.  Do not have to recount comments for editing
            GuestBook::editComment($commentObject);

            // Provide the user a message
            $_SESSION['userMessage'] = "Your comment has been edited!";

        // User has chosen a comment to edit and clicked on submit
        } else {

                $comm_ID = $_POST['userComment'];
                $_SESSION['editComment'] = GuestBook::getComment($comm_ID);

        }

        header('HTTP/1.1 302 Redirect');
        header('Location: ' . INDEX_REDIRECT);

    } catch (Exception $e) {

        // Store error message in the session to view on the index page
        $_SESSION['errorMessage'] = $e->getMessage();
        header('HTTP/1.1 302 Redirect');
        header('Location: ' . INDEX_REDIRECT);
    }

//            d8888b. d88888b db      d88888b d888888b d88888b    .o88b.  .d88b.  .88b  d88. .88b  d88. d88888b d8b   db d888888b
//            88  `8D 88'     88      88'     `~~88~~' 88'       d8P  Y8 .8P  Y8. 88'YbdP`88 88'YbdP`88 88'     888o  88 `~~88~~'
//            88   88 88ooooo 88      88ooooo    88    88ooooo   8P      88    88 88  88  88 88  88  88 88ooooo 88V8o 88    88
//            88   88 88~~~~~ 88      88~~~~~    88    88~~~~~   8b      88    88 88  88  88 88  88  88 88~~~~~ 88 V8o88    88
//            88  .8D 88.     88booo. 88.        88    88.       Y8b  d8 `8b  d8' 88  88  88 88  88  88 88.     88  V888    88
//            Y8888D' Y88888P Y88888P Y88888P    YP    Y88888P    `Y88P'  `Y88P'  YP  YP  YP YP  YP  YP Y88888P VP   V8P    YP

} else if(isset($_POST['delete'])) {

    require_once(MODEL_GUEST_BOOK);
    require_once(MODEL_USER);

    session_start();
    // Get the user object
    $user = $_SESSION['user'];

    // Store the comment ID
    $comm_ID = $_POST['userComment'];
    // Get the comment and store it in a variable ( Will be an associative array )
    $comment = GuestBook::getComment($comm_ID);

    GuestBook::deleteComment($comment);
    // Count user comments for view and store it back into the session
    $user->countUserComments();
    $_SESSION['user'] = $user;

    // Provide the user a message
    $_SESSION['userMessage'] = "Your comment has been deleted!";

    header('HTTP/1.1 302 Redirect');
    header('Location: '.INDEX_REDIRECT);

} elseif(isset($_POST['cancel'])) {

    session_start();

    // Unset the session to change the view
    if(isset($_SESSION['editComment'])) {
        unset($_SESSION['editComment']);
    }

    // User cancelled an action so refresh the page
    header('HTTP/1.1 302 Redirect');
    header('Location: '.INDEX_REDIRECT);
} else {

    // Always redirect to the homepage if this page is accessed
    header('HTTP/1.1 302 Redirect');
    header('Location: '.INDEX_REDIRECT);
}


?>