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

var MAX_TITLE_LENGTH = 50;
var MAX_COMMENT_LENGTH = 500;

// Execute anything here after the page is fully loaded
$(document).ready(function()
{

    // ATTEMPT TO PUT A LIMIT ON THE NUMBER OF CHARACTERS A USER CAN TYPE

    $('#commentMsg').html(MAX_COMMENT_LENGTH + ' characters remaining');
    // REF: CKEditor Documentation
    // The "change" event is fired whenever a change is made in the editor.
    editor.on( 'change', function( evt ) {
        // getData() returns CKEditor's HTML content.

        var text_length = evt.editor.getData().length;
        var text_remaining = MAX_COMMENT_LENGTH - text_length;

        $('#commentMsg').html(text_remaining + ' characters remaining');

        if(text_length > MAX_COMMENT_LENGTH) {

            //editor.setData('test');

        }
    });

    //editor2.on( 'change', function( evt ) {
    //
    //    var text_length = evt.editor2.getData().length;
    //    var text_remaining = MAX_COMMENT_LENGTH - text_length;
    //
    //    $('#commentMsg').html(text_remaining + ' characters remaining');
    //
    //    if(text_length > MAX_COMMENT_LENGTH) {
    //
    //        // Can't figure out how to remove characters from CKEDITOR here!
    //
    //    }
    //});

});

/**
 * Used for both the 'Edit' and 'Delete' select boxes.  The option
 * named 'SELECT A COMMENT' will disable the button.  Any valid
 * comment listed will enable the comment button.
 *
 */
function verifySelection(selectBoxType) {

    // Get the correct selectBox object ( Edit or Delete ) based on id
    var selectBox = document.getElementById(selectBoxType.id);
    // Get the value
    var selectedValue = selectBox.options[selectBox.selectedIndex].value;
    // Set the right button to disable
    var button = ( selectBoxType.id === "editSelect") ? 'editButton' : 'deleteButton';

    // Check for the empty string and disable buttons
    if(selectedValue.toString() === "") {
        document.getElementById(button).disabled = true;

    } else {
        document.getElementById(button).disabled = false;
    }
}

/**
 * Used to clear the text fields with the ' Add Comment ' modal box
 *
 */
function clearTextFields() {
    document.getElementById("title").value = "";
    CKEDITOR.instances['comment'].setData('');
}
