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

/**
 * Class Comment
 *
 * Represents the model of a 'Comment' for use with the application
 */
class Comment
{
    public $id, $title, $body, $datePosted, $userPosted;

    /**
     * Comment constructor.
     * @param $id
     * @param $title
     * @param $body
     * @param $datePosted
     * @param $userPosted
     */
    public function __construct($id, $title, $body, $datePosted, $userPosted)
    {
        $this->id = $id;
        $this->title = $title;
        $this->body = $body;
        $this->datePosted = $datePosted;
        $this->userPosted = $userPosted;
    }

    // GETTERS AND SETTERS
    function __get($name){

        return $this->$name;
    }

    function __set($name,$value) {

        $this->$name = $value;
    }

}

?>