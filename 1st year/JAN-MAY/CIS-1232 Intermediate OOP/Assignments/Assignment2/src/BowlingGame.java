/*
 *  *** CIS-1232 Intermediate OOP ***
 * 
 * NAME: Christopher Sigouin
 * DATE: 29-Jan-2015
 * PROJECT NAME: Assignment 2
 * DEPENDENCIES: Player.java, Util.java
 *
 */

import java.util.Scanner;

/**
 * BowlingGame class is an instance of a Bowling Game. Contains an
 * object of Player to use with the game.
 * 
 * @since 01292015
 * @author Christopher Sigouin 
 */
public class BowlingGame {

        public static int NUMBER_OF_ENDS = 10;
	private int[][] playerScores;
        private Player newPlayers;
	private Scanner input;
        

    /**
     * Constructor will:
     *      initialize a Scanner
     *      create an instance of the Player class
     *      get the players name for the name
     *      request the scores for each player
     * 
     * @since 01292015
     * @author Christopher Sigouin 
     */    
    public BowlingGame() {
        input = new Scanner(System.in);
        newPlayers = new Player();
        newPlayers.inputPlayerNames();
        inputPlayerScores();

    }
    
    /**
     * Requests input for each player and what they scored in each " End ".  Will iternate until
     * there are no longer any " Ends " left to loop through.
     * 
     * @since 01292015
     * @author Christopher Sigouin 
     */
    public void inputPlayerScores() {
            int currentEnd = 0;
            int currentPlayer;

            initalizeScores();

            while( currentEnd < NUMBER_OF_ENDS ) {
                for(currentPlayer = 0; currentPlayer < Player.NUMBER_OF_PLAYERS; ++currentPlayer) {
                    System.out.print("Enter score for " + newPlayers.getPlayerName(currentPlayer) + ": ");
                    playerScores[currentPlayer][currentEnd] = input.nextInt();
                    displayCurrentSummary();

                    if(Util.debugging) {
                        System.out.println("currentPlayer: " + currentPlayer + "currentEnd: " + currentEnd);
                        System.out.println("Score for " + newPlayers.getPlayerName(currentPlayer) + ": " + 
                                           playerScores[currentPlayer][currentEnd]);
                    }
                }
                ++currentEnd;
            }

    }

    /**
     * Displays the current summary of all scores entered for each player
     * 
     * @since 01292015
     * @author Christopher Sigouin 
     */
    public void displayCurrentSummary() {
        int currentEnd;
        int currentPlayer = 0;
        String output;

        while( currentPlayer < Player.NUMBER_OF_PLAYERS ) {
            
            // Add the current player name to the output
            output = newPlayers.getPlayerName(currentPlayer) + " - ";
            // Run a loop to display all the scores for the current player
            for( currentEnd = 0; currentEnd < NUMBER_OF_ENDS; ++currentEnd) {
                // Check for null entries and break if required
                if( playerScores[currentPlayer][currentEnd] == -1 )
                    break;
                else
                    // Add the score to the output
                    output += "|" + playerScores[currentPlayer][currentEnd] + "|";
            }
            // Display the output
            System.out.println(output);
            // Next Player...
            ++currentPlayer;
        }

    }
 
    /**
     * Enters -1 for each element in the 2D array " playerScores ". Because it may be
     * possible a score will be "0". Used so that the loop iterations will be optimized
     * in other functions of the class.  Int arrays will start with 0, so it needed to 
     * change.
     * 
     * @since 01292015
     * @author Christopher Sigouin
     */
    public void initalizeScores() {

        playerScores = new int[Player.NUMBER_OF_PLAYERS][NUMBER_OF_ENDS];

        for(int currentPlayer = 0; currentPlayer < Player.NUMBER_OF_PLAYERS; ++currentPlayer ){
            for(int currentEnd = 0; currentEnd < NUMBER_OF_ENDS; ++currentEnd) {
                playerScores[currentPlayer][currentEnd] = -1;
                if(Util.debugging)
                    System.out.println("|" + playerScores[currentPlayer][currentEnd]);
            }
        }
    }

    /**
     *  Determines the winner of the game based on adding each score for
     * the specific player and comparing to the current winning Score based on 
     * if it's higher or not.  Also adds the winner's name to the "Congradulations" 
     * string.  If there is a tie it will concatenate the next winner as well.
     *  
     *  
     * @since 01292015
     * @author Christopher Sigouin
     */
    public void getGameWinner() {
        String winner = "";
        int currentEnd;
        int currentPlayer = 0;
        int totalScore = 0;
        int winningScore = -1; // Holds value to compare

        // Loop through each player...
        while( currentPlayer < Player.NUMBER_OF_PLAYERS ) {

            // Loop through the currentPlayer's scores
            for( currentEnd = 0; currentEnd < NUMBER_OF_ENDS; ++currentEnd) {
                // Check for null entries and break if required
                if( playerScores[currentPlayer][currentEnd] == -1 )
                    break;
                else {
                   // Add the score to the totalScore
                   totalScore += playerScores[currentPlayer][currentEnd];


                }
            } // END: For Loop 

            // Is the totalScore bigger than the current winning score?
            if( winningScore < totalScore) {
                if(Util.debugging) {
                       System.out.println("getGameWinner(): totalScore: " + totalScore);
                }
                winningScore = totalScore;
                winner = newPlayers.getPlayerName(currentPlayer);

            } else if( winningScore == totalScore ){
                // Add the winner's name because of tie
                winner += " & " + newPlayers.getPlayerName(currentPlayer);
            } else {
                // Nothing
            }

            totalScore = 0;
            ++currentPlayer;

        } // END: While Loop

        System.out.println("Congratulations " + winner);
    }

	

}