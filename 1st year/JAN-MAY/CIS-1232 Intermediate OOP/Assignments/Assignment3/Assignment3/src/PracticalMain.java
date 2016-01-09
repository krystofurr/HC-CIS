import java.util.ArrayList;
import java.util.Scanner;
/*
 *  *** CIS-1232 Intermediate OOP ***
 * 
 * NAME: Christopher Sigouin
 * DATE: 17-Feb-2015
 * PROJECT NAME: Assignment 3
 * DEPENDENCIES: Theatre.java, Row.java, Seat.java
 */

/**
 * This is the main method for the program. It will invoke the theatre
 * functionality as required.
 *
 * @author BJ
 * @since 2014-01-26
 */
public class PracticalMain {

        
    public static void main(String[] args) {
        
        //boolean to indicate when the user is finished.
        boolean finished = false;
        //Scanner for input from the user.
        Scanner input = new Scanner(System.in);
        //Instance of Theatre class
        Theatre theatre = new Theatre("City Cinema");
                
        //Prompt to be used for the menu.
        String prompt = "\nEnter menu choice:"
                + "\nR) Reserve a seat"
                + "\nS) Show seat reservations"
                + "\nT) Total revenue from sold seats"
                + "\nX) Exit";
        //String to hold user's choice
        String userChoice;
        //while the user is not finished, continue to prompt them with the menu.
        do {
            System.out.println(prompt);
            userChoice = input.nextLine().toUpperCase();
            
            switch (userChoice){
                case "X":
                    finished = true;
                    break;
                case "R":
                    theatre.reserveSeat();
                    break;
                case "S":
                    showTheatre(theatre);
                    break;
                case "T":
                    theatre.showTotalValue();
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
        }

        } while (finished == false);
        
        
        
    }
    
    public static void showTheatre(Theatre theatre){
        System.out.println("Show the theatre info here.");
        char[][] grid = new char[Theatre.NUMBER_ROWS][Theatre.NUMBER_OF_SEATS_IN_ROW];
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[i].length; j++){
                grid[i][j] = 'O';
            }
        }
         
        for (Row row : theatre.getRows()){
            for (Seat seat: row.getSeats()){
                grid[row.getRowNumber()-1][seat.getSeatNumber()-1] = 'X';
            }
        }
        for (int i=0; i<grid.length; i++){
            System.out.println("");
            for (int j=0; j<grid[i].length; j++){
                System.out.print(grid[i][j]);
            }
        }

    }
}
