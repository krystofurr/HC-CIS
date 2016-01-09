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
require_once(MODEL_USER);

/**
 * Class GuestBook
 *
 * Static
 *      Handles all actions that the GuestBook will be able to complete with the DB.
 *      Does not require to be instantiated.
 */
class GuestBook
{

    // Holds the PDO object
    private static $DB;



    public static function addComment($comment) {
        // Get DB Connection
        self::$DB = DBConnection::getConnection();

        // Prepare for Write-Access. Prevents SQL injection as well
        $STH = self::$DB->prepare("INSERT INTO Comments (comm_Title, comm_Body, comm_Date_Posted, user_ID) values (?, ?, ?, ?)");
        // Store information in an array
        $data = array($comment->title, $comment->body, $comment->datePosted, $comment->userPosted);
        // Execute the query with array data
        $STH->execute($data);

        // Nullify the DB object
        $DB = null;
    }

    /**
     * Returns either an associative array of all users comments or a string advising that
     * there are no comments.
     *
     * @param $user
     * @return array|string
     */
    public static function getUserComments($user) {
        // Get DB Connection
        self::$DB = DBConnection::getConnection();

        if($user->username === "admin") {
            // Query for Read-Only. No user ID limit for ADMIN
            $result = self::$DB->query("SELECT Comments.*, Users.user_Username FROM Comments, Users WHERE Comments.user_ID = Users.user_ID ORDER BY comm_Date_Posted DESC");
        } else {
            // Query for Read-Only. Order by comment date posted
            $result = self::$DB->query("SELECT * FROM Comments WHERE user_ID = '$user->id' ORDER BY comm_Date_Posted DESC");
        }

        // Array to return to view
        if($result->rowCount() === 0) {
            $userComments = "No comments at this time";
        } else {
            $userComments = [];
            // Store the comments to return to the web view
            while($row = $result->fetch(PDO::FETCH_ASSOC)) {

                // Title, Message, Logged-In Username and Date-Time stamp
                $userComments[] = $row;
            }
        }

        // Nullify the DB object
        $DB = null;

        // Return the string or associative array
        return $userComments;

    }

    public static function editComment($comment) {
        // Get DB Connection
        self::$DB = DBConnection::getConnection();

        // Prepare for Write-Access. Prevents SQL injection as well
        $STH = self::$DB->prepare("UPDATE Comments SET comm_Title=?, comm_Body=?, comm_Date_Posted=? WHERE comm_ID = ?");

        // Execute the query
        $data = array($comment->title, $comment->body, $comment->datePosted, $comment->id );
        $STH->execute($data);

        // Nullify the DB object
        $DB = null;

    }

    public static function deleteComment($comment) {
        // Get DB Connection
        self::$DB = DBConnection::getConnection();

        $comm_ID = $comment['comm_ID'];

        // Query for Read-Only. Order by comment date posted
        $result = self::$DB->query("DELETE FROM Comments WHERE comm_ID = '$comm_ID'");

        // Nullify the DB object
        $DB = null;

    }

    /**
     * Will return a single comment based the comment ID as an associative array
     *
     * @param $comm_ID
     * @return mixed
     */
    public static function getComment($comm_ID) {
        // Get DB Connection
        self::$DB = DBConnection::getConnection();

        // Query for Read-Only. Order by comment date posted
        $result = self::$DB->query("SELECT * FROM Comments WHERE comm_ID = '$comm_ID'");
        // Only single comment retrieved
        $row = $result->fetch(PDO::FETCH_ASSOC);

        // Nullify the DB object
        $DB = null;

        return $row;
        
    }

    /**
     * Will return one of the following:
     *
     *  2-D array of all comments from all users contained the 'Comments' table
     *  OR
     *  A string advising there are no comments in the 'Comments' table
     *
     * @return array|string
     */
    public static function getComments() {

        // Get DB Connection
        self::$DB = DBConnection::getConnection();

        // Query for Read-Only. Order by comment date posted
        $result = self::$DB->query("SELECT Comments.comm_Title, Comments.comm_Body, Comments.comm_Date_Posted, Users.user_Username FROM Comments INNER JOIN Users ON Comments.user_ID = Users.user_ID ORDER BY comm_Date_Posted DESC");

        // Array to return to view

        if($result->rowCount() === 0) {
            $comments = "No comments at this time";
        } else {
            $comments = [];
            // Store the comments to return to the web view
            while($row = $result->fetch(PDO::FETCH_ASSOC)) {

                // Title, Message, Logged-In Username and Date-Time stamp
                $comments[] = $row;

            }
        }

        // Nullify the DB object
        $DB = null;

        return $comments;
    }


}

?>