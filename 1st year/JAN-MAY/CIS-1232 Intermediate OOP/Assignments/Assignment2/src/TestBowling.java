/*
 *  *** CIS-1232 Intermediate OOP ***
 * 
 * NAME: Christopher Sigouin
 * DATE: 29-Jan-2015
 * PROJECT NAME: Assignment 2
 * DEPENDENCIES: Players.java, BowlingGame.java, Util.java
 *
 */

/**
 * TestBowling class is the main application
 * 
 *      Creates an instance of the game
 *      Displays the Game Summary
 *      Calculates the winner and displays
 * 
 * @since 01292015
 * @author Christopher Sigouin
 */
public class TestBowling {

	public static void main(String[] args) {
	
            BowlingGame newGame = new BowlingGame();
            
            System.out.println("***** Game Summary *****");
            newGame.displayCurrentSummary();
            newGame.getGameWinner();
		
	}

}