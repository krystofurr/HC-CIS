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

// Load dependencies
require_once('constants.php');
// Required to use GuestBook static functions
require_once(MODEL_GUEST_BOOK);
// Required for use with user object and must be called prior to session_start()
require_once(MODEL_USER);

// Start a session
session_start();
// Set timezone
date_default_timezone_set('America/Halifax');

?>


<!DOCTYPE html>
<head>
    <title>Assignment 2 - Guest Book</title>

     <!-- JQUERY -->
    <script src="vendor/components/jquery/jquery.min.js"></script>

    <!-- BOOTSTRAP -->
    <link rel="stylesheet" type="text/css" href="vendor/twitter/bootstrap/dist/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="vendor/twitter/bootstrap/dist/css/bootstrap-theme.min.css">
    <script src="vendor/twitter/bootstrap/dist/js/bootstrap.min.js"></script>

    <!-- CKEDITOR -->
    <script type="text/javascript" src="vendor/ckeditor/ckeditor/ckeditor.js"></script>

    <!-- CUSTOM STYLES : Declared after Bootstrap so that any similiar classes can override -->
    <link rel="stylesheet" type="text/css" href="css/styles.css">

    <!-- CUSTOM JAVASCRIPT -->
    <script src="js/myJS.js"></script>

</head>
<body>
    <?php

    require(VIEW_LOGIN);

    // Display a message to the user for an event
    if(isset($_SESSION['userMessage'])) {
        echo '<h2 class="text-center">'.$_SESSION['userMessage'].'</h2>';
        unset($_SESSION['userMessage']);
    }

    // Display any error messages needed
    if(isset($_SESSION['errorMessage'])) {
        echo '<h2 class="text-center">'.$_SESSION['errorMessage'].'</h2>';
        unset($_SESSION['errorMessage']);
    }

    // If 'User_Registered' is set in the session, display a message accordingly
    if(isset($_SESSION['User_Registered'])) {
        if($_SESSION['User_Registered']) {
            echo '<h2 class="text-center">Thanks for registering!  Please login to Guest Book.</h2>';
            unset($_SESSION['User_Registered']);
        } else {
            echo '<h2 class="text-center">Your username exists.  Please choose a different username. </h2>';
            unset($_SESSION['User_Registered']);
        }
    }

    // Check to see if the user is editing a comment
    if(isset($_SESSION['editComment'])) {
        $comment = $_SESSION['editComment'];

        // Show the comment in editable fields for the user to resubmit
        ?>
        <form method="POST" class="commentForm form-horizontal" role="form" action="controller/redirect.php">
            <div class="form-group">
                <label for="title">Title</label>
                <input type="text" class="form-control" name="alterTitle" value="<?php echo $comment['comm_Title'] ?>" />
            </div>
            <div class="form-group">
                <label for="comment">Comment</label>
                <textarea class="form-control" rows="8" name="alterComment" id="comment"><?php echo $comment['comm_Body'] ?></textarea>
                <p id="commentMsg"></p>
                <!-- CKEDITOR REQUIREMENT -->
                <script type="text/javascript">
                    var editor2 = CKEDITOR.replace( 'alterComment' );
                </script>
                <!-- CKEDITOR REQUIREMENT -->
            </div>

            <div class="text-center form-group">
                <button type="submit" class="btn btn-primary" name="edit">Submit Changes</button>
                <button type="submit" class="btn btn-primary" name="cancel">Cancel</button>
            </div>
        </form>
        <?php
    } else {
        showAllComments();
    }


    ?>

</body>
</html>


<?php

/**
 *  Used to display all comments in the database.  This function is only to tidy up
 *  the source code.
 *
 */
function showAllComments() {
    // Show comments if there is any present. '$comments' will be 2-D [int][assoc]
    $comments = GuestBook::getComments();

    if(is_array($comments)) {
        for($i = 0; $i < count($comments); ++$i) {
            ?>
            <div class="commentBox">
                <p class="commentTitle text-center"><?php echo $comments[$i]['comm_Title']; ?></p>
                <p><?php echo $comments[$i]['comm_Body']; ?></p>
                <p>User Posted: <?php echo $comments[$i]['user_Username']; ?></p>
                <p class="text-center">Date Posted: <?php echo date("F j, Y, g:i a", $comments[$i]['comm_Date_Posted']); ?></p>
            </div>
            <?php
        }
    } else {

        ?>
        <div>
            <p class="text-center commentBox"><?php echo $comments ?></p>
        </div>
        <?php
    }
}

?>