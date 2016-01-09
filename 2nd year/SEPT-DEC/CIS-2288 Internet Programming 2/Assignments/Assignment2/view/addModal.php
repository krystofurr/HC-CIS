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

/*
 *  The file path to constants.php will be different depending on if it is accessed directly
 *  or if it is included ( included means the path is relative to the page it is included into !!! )
 *
 *  If the addModel file is accessed directly, constants.php is located at [ ../constants.php ]
 *      - $includedAddModel should not be true, meaning not included.
 *  If the addModel file is accessed indirectly ( required through loginNavBar.php ) constants.php
 *  is located at [ constants.php ]
 *      - $includedAddModel should be true, meaning it was included
 *
 *  This will allow for the constant 'CONTROLLER_VERIFY_USER' to be defined
 *
 */

# Can check to see if this file has been included
if(isset($includedAdminModals) && $includedAdminModals)
    require_once('constants.php');
else
    require_once('../constants.php');

require(CONTROLLER_VERIFY_USER);

    ?>

    <!-- Add Modal -->
    <div id="add" class="modal fade" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="text-center modal-title">Add Comment to GuestBook</h4>
                </div>
                <div class="modal-body">
                    <form method="POST" class="form-horizontal" role="form" action="controller/redirect.php">
                        <div class="form-group">
                            <label for="title">Title</label>
                            <input type="text" class="form-control" name="title" id="title" placeholder="Title"
                                   maxlength="<?php echo MAX_TITLE_LENGTH ?>">
                        </div>
                        <div class="form-group">
                            <label for="comment">Comment</label>
                            <textarea class="form-control" rows="8" name="comment" id="comment"
                                      maxlength="<?php echo MAX_COMMENT_LENGTH ?>"></textarea>

                            <p id="commentMsg"></p>
                        </div>
                        <!-- CKEDITOR REQUIREMENT -->
                        <script type="text/javascript">
                            var editor = CKEDITOR.replace('comment');
                        </script>
                        <!-- CKEDITOR REQUIREMENT -->
                        <div class="text-center form-group">
                            <button type="submit" class="btn btn-primary" name="add">Add Comment</button>
                        </div>

                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal" onclick="clearTextFields()">
                        Close
                    </button>
                </div>
            </div>

        </div>
    </div>

