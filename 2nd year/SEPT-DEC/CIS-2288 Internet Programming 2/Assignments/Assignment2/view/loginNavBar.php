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

if(isset($_SESSION['user'])) {
    // Unserialize the user object to use
    $user = $_SESSION['user'];
}

// All modals required for GuestBook
require_once(VIEW_REGISTER_MODAL);

// If either a user or the admin is authenticated, include the modals to use
if(isset($_SESSION['IsLoggedIn']) || isset($_SESSION['adminLoggedIn'])) {
    $includedAdminModals = true;
    require_once(VIEW_ADD_MODAL);
    require_once(VIEW_EDIT_MODAL);
    require_once(VIEW_DELETE_MODAL);
} else {
    $includedAdminModals = false;
}

?>


<!-- START OF NAV BAR -->
<div class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#navbar-main">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <!-- Put the date of the registered user inside the navbar just for some extra information -->
            <div class="visible-xs navbar-brand"><?php echo (isset($user) && !isset($_SESSION['adminLoggedIn'])) ? 'Total Comments: '.$user->totalComments : 'Welcome to GuestBook';?></div>
            <div class="hidden-xs navbar-brand"><?php echo (isset($user) && !isset($_SESSION['adminLoggedIn'])) ? 'Registration Date: '.date("F j, Y, g:i a", $user->registerDate).' | Total Comments: '.$user->totalComments : 'Welcome to GuestBook'; ?></div>
        </div>
        <div class="text-center navbar-collapse collapse" id="navbar-main">

            <?php


            // Check for ADMIN
            if(isset($_SESSION['adminLoggedIn'])) { ?>

                <form method="POST" class="navbar-form navbar-right" role="search" action="controller/redirect.php">
                    <div class="form-group">
                        <button type="button" class="btn btn-info" data-toggle="modal" data-target="#add" name="add">(ADMIN) Add Comment</button>
                    </div>
                    <div class="form-group">
                        <button type="button" class="btn btn-info" data-toggle="modal" data-target="#edit" name="adminEdit">(ADMIN) Edit Comment</button>
                    </div>
                    <div class="form-group">
                        <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#delete" name="adminDelete">(ADMIN) Delete Comment</button>
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary" name="logout">Logout <?php echo ' '.$user->username ; ?></button>
                    </div>
                </form>

            <?php
            // Check for ANY USER
            } elseif(isset($_SESSION['IsLoggedIn'])) {
                ?>


                <form method="POST" class="navbar-form navbar-right" role="search" action="controller/redirect.php">
                    <div class="form-group">
                        <button type="button" class="btn btn-info" data-toggle="modal" data-target="#add" name="add">Add Comment</button>
                    </div>
                    <div class="form-group">
                        <button type="button" class="btn btn-info" data-toggle="modal" data-target="#edit" name="edit">Edit Comment</button>
                    </div>
                    <div class="form-group">
                        <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#delete" name="delete">Delete Comment</button>
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary" name="logout">Logout <?php echo ' '.$user->username ; ?></button>
                    </div>
                </form>
                <?php

            // No ADMIN or USER. Display login form.
            } else {
            ?>

                <form id="navbar-main" method="POST" class="navbar-form navbar-right" action="controller/redirect.php">
                    <div class="form-group">
                        <input type="text" class="form-control" name="username" placeholder="Username">
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" name="password" placeholder="Password">
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary" name="login">Sign In</button>
                    </div>
                    <div class="form-group">
                        <button type="button" class="btn btn-info" data-toggle="modal" data-target="#register" name="register">Register</button>
                    </div>
                </form>

            <?php
            }
            ?>
        </div>
    </div>
</div>

<!-- BANNER ON THE SIDE -->
<img class="banner" src="img/banner.png" />

















