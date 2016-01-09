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

# Can check to see if this file has been included
if(isset($includedAdminModals) && $includedAdminModals)
    require_once('constants.php');
else
    require_once('../constants.php');

require(CONTROLLER_VERIFY_USER);

?>


<!-- Delete Modal -->
<div id="delete" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="text-center modal-title">Delete Comment in GuestBook</h4>
            </div>
            <div class="modal-body">
                <form method="POST" class="form-horizontal" role="form" action="controller/redirect.php">
                    <div class="form-group">
                        <?php

                        $userComments = GuestBook::getUserComments($user);
                        if(is_array($userComments)) {
                            // The value of 'userComment' will be the comment ID
                            echo '<div class="form-group"><select id="deleteSelect" class="form-control" name="userComment" onchange="verifySelection(this)">';
                            echo '<option value="">--- SELECT A COMMENT ---</option>';
                            for($i = 0; $i < count($userComments); ++$i) {
                                // If ADMIN is logged in, store the username for their listing of comments
                                $username = (isset($_SESSION['adminLoggedIn'])) ? $userComments[$i]['user_Username'].' | ' : '';
                                echo '<option value="'.$userComments[$i]['comm_ID'].'">'.$userComments[$i]['comm_Title'].' | '.$username.date("F j, Y, g:i a", $userComments[$i]['comm_Date_Posted']).'</option>';                            }
                            echo '</select></div>';
                            ?>
                            <div class="text-center form-group">
                                <button type="submit" class="btn btn-danger" name="delete" id="deleteButton" disabled>Delete Comment</button>
                                <button type="submit" class="btn btn-info" name="cancel"  data-dismiss="modal">Cancel</button>
                            </div>
                            <?php
                        } else {
                            echo '<p class="text-center">'.$userComments.'</p>';
                        }

                        ?>
                    </div>

                </form>
            </div>
        </div>

    </div>
</div>