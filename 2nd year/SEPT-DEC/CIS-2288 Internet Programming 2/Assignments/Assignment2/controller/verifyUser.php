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

// Starts a session to check for authentication if pages are directly accessed.  It's possible the
// session will already be started and cause a warning.  Check will prevent this
if(session_status() == PHP_SESSION_NONE) {
    session_start();
}

// If either the user or the admin is not logged in, then redirect
if(isset($_SESSION['IsLoggedIn']) || isset($_SESSION['adminLoggedIn'])) {
    // User will be allowed to proceed as normal
} else {
    // Redirect the user accessing the page directly to the main page ( index.php )
    header('Location: ../index.php');
}

?>
