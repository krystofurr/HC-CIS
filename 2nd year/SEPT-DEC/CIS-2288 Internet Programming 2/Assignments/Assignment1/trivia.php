<?php

/**

    Program name:       Trivia Game
    Logical name:       trivia.php
    Author:             Christopher Sigouin
    Version:            1.0
    Description:        Displays a trivia question and provides a form with a textbox for the user
                        to type their guess at the answer.  Will display a table once all questions are
                        completed to display results.
    Dependencies:       myStyle.css, TriviaGameClass.php
    Database file:      n/a
    Change History:     2015.09.22 Original version by CJS

*/

// Class is used to manage the mechanics of the game.  It is stored in a session variable
require_once('TriviaGameClass.php');

session_start();

// This will set the cookie for the theme color and the global array to use in the script
if( isset($_POST['themeColor'])) {
    // Set the cookie to keep the theme
    setcookie("themeColor", $_POST['themeColor'],time() + 60*60*24);
    // Set the global array to use now and bypass the delay
    $_COOKIE['themeColor'] = $_POST['themeColor'];
}

?>
<html>
<head>
    <title>TRIVIA GAME - ASSIGNMENT 1</title>
    <link rel="stylesheet" type="text/css" href="myStyle.css">

    <script>

        //  Will load each time the page loads to keep the same color based on the $_COOKIE['themeColor'] value
        window.onload = function() {

            switch (parseInt(<?php echo isset($_COOKIE['themeColor']) ? $_COOKIE['themeColor'] : 0; ?>)) {

                case 1:
                    // White on Black
                    document.body.style.backgroundColor = 'Black';
                    document.body.style.color = 'White';
                    document.getElementsByTagName("a")[0].style.color = 'White';
                    break;
                case 2:
                    // Yellow on Purple
                    document.body.style.backgroundColor = 'Purple';
                    document.body.style.color = 'Yellow';
                    document.getElementsByTagName("a")[0].style.color = 'Yellow';
                    break;
                case 3:
                    // Blue on Yellow
                    document.body.style.backgroundColor = 'Yellow';
                    document.body.style.color = 'Blue';
                    document.getElementsByTagName("a")[0].style.color = 'Blue';
                    break;
                default:
                    // White on Black
                    document.body.style.backgroundColor = 'White';
                    document.body.style.color = 'Black';
                    document.getElementsByTagName("a")[0].style.color = 'Black';
                    break;
            }
        };

        // Will change the color on the page when the user selects it on the dropdown
        function change_color(select) {

            var color = select.options[select.selectedIndex].value;

            switch (parseInt(color)) {

                case 1:
                    // White on Black

                    document.body.style.backgroundColor = 'Black';
                    document.body.style.color = 'White';
                    document.getElementsByTagName("a")[0].style.color = 'White';
                    break;
                case 2:
                    // Yellow on Purple
                    document.body.style.backgroundColor = 'Purple';
                    document.body.style.color = 'Yellow';
                    document.getElementsByTagName("a")[0].style.color = 'Yellow';
                    break;
                case 3:
                    // Blue on Yellow
                    document.body.style.backgroundColor = 'Yellow';
                    document.body.style.color = 'Blue';
                    document.getElementsByTagName("a")[0].style.color = 'Blue';
                    break;
                default:
                    // White on Black
                    document.body.style.backgroundColor = 'White';
                    document.body.style.color = 'Black';
                    document.getElementsByTagName("a")[0].style.color = 'Black';
                    break;
            }
        } // END: change_color()
    </script>
</head>
<body>
<?php


if( !isset($_SESSION['triviaGame'])) { # No 'triviaGame' session variable

    if( !isset($_POST['submit'])) { # No 'submit' POST variable | No 'triviaGame' session variable

        // Start a new game
        $triviaGame = new TriviaGameClass();
        $triviaGame->initGame();
        $triviaGame->drawGameScreen();

        // The game is saved in the current session. PHP will serialize and unserialize the class automatically
        $_SESSION['triviaGame'] = $triviaGame;

    }

} else { # There is a 'triviaGame' session

    if( !isset($_POST['submit'])) { # No 'submit' POST variable | 'triviaGame' variable does exist

        // Reset the game
        $triviaGame = $_SESSION['triviaGame'];
        $triviaGame->endGame();

    } else { # 'submit' exists | 'triviaGame' exists

        $triviaGame = $_SESSION['triviaGame'];

        // Process the users answer and change question accordingly
        if (!empty($_POST['answer']) && !$triviaGame->endGame) {
            $triviaGame->processAnswer(trim($_POST['answer']));
        }

        // Show the game screen
        $triviaGame->drawGameScreen();
    }
}
?>

</body>
</html>


