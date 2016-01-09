/*
 *  *** CIS-1232 Intermediate OOP ***
 * 
 * NAME: Christopher Sigouin
 * DATE: 29-Jan-2015
 * PROJECT NAME: Assignment 2
 * DEPENDENCIES: Util.java
 *
 */

import java.util.Scanner;


/**
 * Player class holds the information ( names ) for all Players of the BowlingGame
 * 
 * @since 01292015
 * @author Christopher Sigouin
 */
public class Player {

        public final static int NUMBER_OF_PLAYERS = 2;
	private String[] playerNames;
	private static Scanner input;

        /**
         * Player Constructor 
         *      Instantiates the playerNames array
         *      creates an instance of the Scanner object
         * 
         * @since 01292015
         * @author Christopher Sigouin
         */
        public Player() {
            playerNames = new String[NUMBER_OF_PLAYERS];
            input = new Scanner(System.in);
        }
        
        /**
         * Will retrieve a single player name based on the integer based
         * argument passed into it
         * 
         * @since 01292015
         * @author Christopher Sigouin
         * @param subscript
         * @return 
         */
        public String getPlayerName(int subscript) {
            return this.playerNames[subscript];
        }
        
	public String[] getPlayerNames() {
		return this.playerNames;
	}

	/**
	 * 
	 * @param playerNames
	 */
	public void setPlayerNames(String[] playerNames) {
		this.playerNames = playerNames;
	}

        /**
         * Requests input from the user for each player and stores it in the 
         * playerNames array.  The number of times it iterates is based on
         * the constant value of " NUMBER_OF_PLAYERS "
         * 
         * @since 01292015
         * @author Christopher Sigouin
         */
	public void inputPlayerNames() {
            
            for(int currentPlayer = 0; currentPlayer < NUMBER_OF_PLAYERS; ++currentPlayer) {
                System.out.print("Enter player#" + (currentPlayer + 1) + " name:");
                playerNames[currentPlayer] = input.nextLine();
                if( Util.debugging )
                    System.out.println(playerNames[currentPlayer]);
            
            }
            
            
 
	}

}