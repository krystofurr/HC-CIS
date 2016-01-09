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


define('MAX_TITLE_LENGTH', 50);
define('MAX_COMMENT_LENGTH', 500);

/*
 *  These define all constants to various source files for the
 *  application.  Incase file directory structure is required to change,
 *  this will allow for ease of editing for the application.
 *
 */
define('SECURIMAGE', dirname(__FILE__).'/securimage/securimage.php');

define('CONTROLLER_REDIRECT', dirname(__FILE__).'/controller/redirect.php');
define('CONTROLLER_VERIFY_USER', dirname(__FILE__).'/controller/verifyUser.php');

define('MODEL_USER', dirname(__FILE__).'/model/User.php');
define('MODEL_GUEST_BOOK', dirname(__FILE__).'/model/GuestBook.php');
define('MODEL_COMMENT', dirname(__FILE__).'/model/Comment.php');

define('UTIL_DB_CONN', dirname(__FILE__).'/util/DBConnection.php');
define('UTIL_DB_CREDS', dirname(__FILE__).'/util/dbCreds.php');

define('VIEW_INDEX', dirname(__FILE__).'/view/index.php');
define('VIEW_LOGIN', dirname(__FILE__).'/view/loginNavBar.php');
define('VIEW_REGISTER_MODAL', dirname(__FILE__).'/view/registerModal.php');
define('VIEW_ADD_MODAL', dirname(__FILE__).'/view/addModal.php');
define('VIEW_EDIT_MODAL', dirname(__FILE__).'/view/editModal.php');
define('VIEW_DELETE_MODAL', dirname(__FILE__).'/view/deleteModal.php');

