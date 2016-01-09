/*
 * ========= CIS 1232 Intermediate Object Oriented Programming PWC ==========
 * NAME: Christopher Sigouin
 * DATE: 24-Apr-2015
 * PURPOSE: Assignment 8
 */

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author bjmaclean
 */
public class ComputerRoom extends Room {

    /*
        04-24-2015 | CJS | Assignment 8 Modification

        Added
            Constant for the default value of numberOfComputers
            to be used for exception handling
    */
    public final static int EXCEPTION_DEFAULT_NUMBER_OF_COMPUTERS = 1;
    int numberOfComputers;

    public ComputerRoom(int roomNumber) {
        super(roomNumber);
    }

    /**
     * Get the details from the user about this class. This will invoke the super method to get the
     * base class attributes.
     */
    public void getRoomDetailsFromUser() {
        super.getRoomDetailsFromUser();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of computers: ");
        /*
            04-24-2015 | CJS | Assignment 8 Modification

            Added
                Try-Catch surrounding the input for menu requesting
                a valid number of computers.  This assumes a that a room
                must have at least one computer. If invalid, numberOfComputers
                will be defaulted to 1 computer.
        */
        try {
            numberOfComputers = input.nextInt();
            if( numberOfComputers < EXCEPTION_DEFAULT_NUMBER_OF_COMPUTERS)
                throw new Exception("ERROR: Cannot have a negative value of computers.  Defaulted to " + EXCEPTION_DEFAULT_NUMBER_OF_COMPUTERS );
        } 
        catch( InputMismatchException e ) {
            System.out.println("ERROR: Invalid number of computers.  Defaulted to " + EXCEPTION_DEFAULT_NUMBER_OF_COMPUTERS );
            numberOfComputers = EXCEPTION_DEFAULT_NUMBER_OF_COMPUTERS;
        }
        catch( Exception e) {
            System.out.println(e.getMessage());
            numberOfComputers = EXCEPTION_DEFAULT_NUMBER_OF_COMPUTERS;
        }
        input.nextLine();
    }

    public int getNumberOfComputer() {
        return numberOfComputers;
    }

    public void setNumberOfComputer(int numberOfComputer) {
        this.numberOfComputers = numberOfComputer;
    }

    public String toString() {
        return super.toString() + "\nNumber of Computers" + numberOfComputers;
    }
}
