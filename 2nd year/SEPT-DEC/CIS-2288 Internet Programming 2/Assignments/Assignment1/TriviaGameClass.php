<?php

/**

    Program name:       Trivia Game
    Logical name:       trivia.php
    Author:             Christopher Sigouin
    Version:            1.0
    Description:        Displays a trivia question and provides a form with a textbox for the user
                        to type their guess at the answer.  Will display a table once all questions are
                        completed to display results.
    Dependencies:       myStyle.css
    Database file:      n/a
    Change History:     2015.09.22 Original version by CJS

*/

class TriviaGameClass {

    const FILE_NAME = "QUESTIONS.TXT";
    private $questionArray, $answerArray, $userAnswerArray; # Using parallel arrays
    private $currentQuestionCount; # Holds the question position for arrays ( requires -1 )
    private $currentQuestion; # Holds the current question being asked
    private $endGame; # Flag to use when the questions are answered and game is completed


    // Constructor
    function __construct() {

        // Loads the questions from the file
        $this->loadQuestions(self::FILE_NAME);
        $this->userAnswerArray = [];

    }

    /**
     * GETTER AND SETTER
     *
     * @param $name
     * @return mixed
     */
    function __get($name){

        return $this->$name;
    }

    function __set($name,$value) {

        $this->$name = $value;
    }

    /**
     *  initGame
     *
     *  Sets needed starting values for the game
     *
     */
    function initGame() {

        // Start on 'Question 1'
        $this->currentQuestionCount = 1;
        $this->currentQuestion = $this->questionArray[$this->currentQuestionCount - 1];

        // Game is started so 'endGame' is false until function 'changeQuestion' decides that it is true
        $this->endGame = false;
    }

    /**
     *  loadQuestions
     *
     *  Loads the specified file defined with the constant 'FILE_NAME'
     *
     */

    function loadQuestions($fileName) {

        if(file_exists($fileName)) {
            if (filesize($fileName) != 0) {
                $fileSize = filesize($fileName);

                @ $fp = fopen($fileName, 'rb');
                $isLocked = flock($fp, LOCK_SH); # Reading - Share
                if (!$isLocked) {
                    echo "<p>Could not lock the file!</p>";
                    exit;
                }

                //Friendly error for FOPEN
                if (!$fp) {
                    echo "<p>Could not open the file!</p>";
                    exit;
                }

                $i = 0;
                while(!feof($fp)) {
                    $triviaQuestion = fgetcsv($fp, $fileSize, "\t");

                    // Make sure the very last NULL records are not added
                    if($triviaQuestion != null) {
                        $this->questionArray[$i] = $triviaQuestion[0];
                        $this->answerArray[$i] = $triviaQuestion[1];
                        ++$i;
                    }

                } // END: While
            } // END: If
        } // END: If
    } // END: loadQuestions

    /**
     * endGame
     *
     * Calls cleanup on the session and removes any unwanted items.  Also redirects to start the game over again
     *
     */
    function endGame() {

        // Destroy the session
        session_destroy();

        /**
         *  COPIED FROM SESSION PRACTICE EXAMPLE.
         *
         *  this part gets rid of the session cookie that php puts on the users machine
         */
        if (ini_get("session.use_cookies")) {
            $params = session_get_cookie_params();
            setcookie(session_name(), '', time() - 42000,
                $params["path"], $params["domain"],
                $params["secure"], $params["httponly"]
            );
        }

        // Redirect to itself after session is destroyed
        header('Location: trivia.php');
    }

    /**
     * drawGameScreen
     *
     * Will draw either the trivia game display itself or the table view depending on
     * how many questions the user has answered
     *
     */
    function drawGameScreen() {
        $selected = isset($_COOKIE['themeColor']) ? $_COOKIE['themeColor'] : 0;
        // ======================= QUESTION DISPLAY =======================

        // If there are still questions available we can display them
        if( count($this->userAnswerArray) != count($this->questionArray)) {

            ?>
            <!--  Always display a drop down box for changing the background/foreground of the screen -->

                <form method="POST" action="trivia.php">
                    <label for="themeColor">Theme Color:</label>
                    <select name="themeColor" onchange="change_color(this);" >
                        <option value="0" <?php echo ($selected == 0 ? "selected":""); ?>>Background Color</option>
                        <option value="1" <?php echo ($selected == 1 ? "selected":""); ?>>White on Black</option>
                        <option value="2" <?php echo ($selected == 2 ? "selected":""); ?>>Yellow on Purple</option>
                        <option value="3" <?php echo ($selected == 3 ? "selected":""); ?>>Blue on Yellow</option>
                    </select>
                    <br/><br/>
                    <div class="gameBorder">

                        <p class="centerText">Question <?php echo $this->currentQuestionCount ?> of <?php echo count($this->questionArray) ?></p>
                        <p class="centerText"><?php echo $this->currentQuestion ?></p>

                        <input type="text" name="answer"/>
                        <br/>
                        <input type="submit" name="submit"/>
                    </div>
                </form>
            <?php

        // ======================= TABLE DISPLAY ======================

        // Display the results table
        } else {

           ?>
           <table class="tableResults">
               <tr>
                   <th>Question Number</th>
                   <th>Question Text</th>
                   <th>Correct Answer</th>
                   <th>User Answer</th>
               </tr>
               <?php

           $eoq = 0; # eoq is 'End of questions'
           while( count($this->questionArray) != $eoq) {
               ?>
               <tr class="centerText <?php echo ($this->answerArray[$eoq] == $this->userAnswerArray[$eoq] ? "green":"red"); ?>">
                   <td><?php echo $eoq + 1; ?></td>
                   <td><?php echo $this->questionArray[$eoq] ?></td>
                   <td><?php echo $this->answerArray[$eoq] ?></td>
                   <td><?php echo $this->userAnswerArray[$eoq] ?></td>
               </tr>
               <?php

               ++$eoq;
           } // END: While Loop

           ?>
           <tr>
               <td class="centerText" colspan="4">
                   PERCENTAGE CORRECT: <?php echo $this->calculateResults() ?>
               </td>
           </tr>
           </table>
           <?php
        } // END: If

        ?><br/><div class="centerText"><a href="trivia.php">Restart</a></div><?php
    } // END: drawGameScreen

    /**
     * processAnswer
     *
     * Function should check the users answer.  It should also handle changing the question and increase
     * the question progress indicator.  'currentQuestionCount' will control the changing of questions by
     * incrementing it's value.
     *
     * @param $answer
     */
    function processAnswer($answer) {

        // Store the answer if it's wrong or right for the table display
        $this->userAnswerArray[$this->currentQuestionCount - 1] = $answer;

        $this->changeQuestion(true);

    } // END: isAnswerCorrect

    /**
     * changeQuestion
     *
     * Helper function to change the question while the user is submitting.  Used with function 'isAnswerCorrect'
     *
     * @param $change
     *
     */
    function changeQuestion($change) {

        // Increment for next question.
        ++$this->currentQuestionCount;

        // Check to make sure there are still questions to ask before changing. ( OFFSET errors )
        if( $this->currentQuestionCount <= count($this->questionArray)) {

            $this->currentQuestion = $this->questionArray[$this->currentQuestionCount - 1];

        } else {

            $this->endGame = $change;
        }
    }

    /**
     * calculateResults
     *
     * Calculates the percentage of correct answers vs. incorrect answers
     *
     */
    function calculateResults() {
        $correct = 0;

        // Loop through the array to check user answers
        for($i = 0; $i < count($this->questionArray); ++$i) {
            if($this->userAnswerArray[$i] == $this->answerArray[$i]) {
                ++$correct;
            }
        }

        // Calculate the percentage
        $returnValue = ( $correct / count($this->questionArray) * 100);
        // Format the value
        $returnValue = number_format($returnValue, 1);
        return $returnValue.' %';
    }

} // END: TriviaGameClass