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

require_once(UTIL_DB_CONN);
require_once(MODEL_GUEST_BOOK);

/**
 * Class User
 *
 * Represents a model of a 'User' for the GuestBook web application
 *
 */
class User
{

    public $totalComments;
    public $id, $username, $passwordHash, $registerDate;

    /**
     * CONSTRUCTOR
     *
     * @param $id
     * @param $username
     * @param $passwordHash
     * @param $registerDate
     */
    function __construct($id, $username, $passwordHash, $registerDate) {

        $this->id = $id;
        $this->username = $username;
        $this->passwordHash = $passwordHash;
        $this->registerDate = $registerDate;

        // When a user is first created, tally their comments
        $this->countUserComments();
    }

    // GETTERS AND SETTERS
    function __get($name){

        return $this->$name;
    }

    function __set($name,$value) {

        $this->$name = $value;
    }

    public function countUserComments() {
        $userComments = GuestBook::getUserComments($this);
        if(is_array($userComments)) {
            $this->totalComments = count($userComments);
        } else {
            $this->totalComments = 0;
        }
    }

    /**
     * Will update the users account with the new password hash.  Soley used
     * for updating a hash if the current algorithm has been updated in
     * PHP.  Accepts a user object as a parameter.
     *
     * @param $user
     */
    public function saveUserPasswordHash($user) {

        // Get DB connection
        $DB = DBConnection::getConnection();

        // Prepare for Write-Access. Prevents SQL injection as well
        $STH = $DB->prepare("UPDATE Users SET user_Password=? WHERE user_ID = $user->id");
        // Store information in an array
        $data = array($this->passwordHash);
        // Execute the query
        $STH->execute($data);

        // Nullify the DB object
        $DB = null;

    }

    /**
     * Used to submit a user's information into the database so that
     * credentials can be used to authenticate.  Will return a boolean
     * value of true or false depending on the success of the registration
     *
     * @param $username
     * @param $passwordHash
     * @return bool
     */
    public static function registerUser($username, $passwordHash) {

        // Get DB connection
        $DB = DBConnection::getConnection();

        // If the user is not found
        if( is_bool(self::findUser($username)) ) {

            // Prepare for Write-Access. Prevents SQL injection as well
            $STH = $DB->prepare("INSERT INTO Users (user_Username, user_Password, user_Date_Registered) values (?, ?, UNIX_TIMESTAMP(NOW()))");
            // Store information in an array
            $data = array($username, $passwordHash);
            // Execute the query
            $STH->execute($data);

            $userRegistered = true;

        // If the user is found
        } else {

            $userRegistered = false;

        }

        return $userRegistered;

    }

    /**
     * Used to verify if a user exists in the DB.  Returns a boolean value
     * based on results.
     *
     * @param $username
     * @param $password
     * @return bool
     */
    public static function verifyUser($username, $password) {
        // Get DB connection
        $DB = DBConnection::getConnection();

        // Query for Read-Only
        $result = $DB->query("SELECT * FROM Users WHERE user_Username = '$username'");

        if( $result->rowCount() === 0 ) {
            $userFound = false;
        } else {

            $userFound = true;
        }

        return $userFound;


    }

    /**
     *  Will return either an object of 'User' and data pertaining to that user
     *  or it will return 'false' indicating a user was not found
     *
     *
     * @param $username
     * @return bool|User
     *
     */
    public static function findUser($username) {

        // Get DB connection
        $DB = DBConnection::getConnection();

        // Query for Read-Only
        $result = $DB->query("SELECT * FROM Users WHERE user_Username = '$username'");

        if( $result->rowCount() === 0 ) {
            $userFound = false;
        } else {
            $result->setFetchMode(PDO::FETCH_ASSOC);
            $row = $result->fetch();
            $userFound = new User($row['user_ID'], $row['user_Username'], $row['user_Password'], $row['user_Date_Registered']);
        }

        return $userFound;

    }


}


?>