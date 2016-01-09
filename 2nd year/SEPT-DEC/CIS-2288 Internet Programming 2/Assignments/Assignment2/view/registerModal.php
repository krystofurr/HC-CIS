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

?>


<!-- Register Modal -->
<div id="register" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="text-center modal-title">Register User</h4>
            </div>
            <div class="modal-body">
                <form method="POST" class="form-horizontal" role="form" action="controller/redirect.php">

                    <div class="form-group">
                        <label for="username">Desired Username: </label>
                        <input type="text" class="form-control" name="username" placeholder="Username">
                    </div>
                    <div class="form-group">
                        <label for="password">Desired Password: </label>
                        <input type="text" class="form-control" name="password" placeholder="Password">
                    </div>

                    <div class="form-group">
                        <!-- CAPTCHA CODE -->
                        <img id="captcha" src="vendor/dapphp/securimage/securimage_show.php" alt="CAPTCHA Image" />
                        <input type="text" name="captcha_code" size="10" maxlength="6" />
                        <a href="#" onclick="document.getElementById('captcha').src = 'vendor/dapphp/securimage/securimage_show.php?' + Math.random(); return false">[ Different Image ]</a>
                        <!-- CAPTCHA CODE -->
                    </div>

                    <div class="text-center form-group">
                        <button type="submit" class="btn btn-primary" name="register">Register</button>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>

    </div>
</div>
