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
public class Room {
    
    /*
        04-24-2015 | CJS | Assignment 8 Modification

        Added
            Constant for the default value of numberOfSeats
            to be used for exception handling
    */
    public final static int EXCEPTION_DEFAULT_NUMBER_OF_SEATS = 1;
    
    Scanner input = new Scanner(System.in);
    private int roomNumber;
    private int numberOfSeats;
    private String reservedBy = "";
    private boolean reserved;
    private boolean hasSmartBoard;
    
    /**
     * Get the attribute values from the user.
     */
    
    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        
    }

    
    public void getRoomDetailsFromUser() {
        
        System.out.print("Enter number of seats: ");
        /*
            04-24-2015 | CJS | Assignment 8 Modification

            Added
                Try-Catch surrounding the input for menu requesting
                a valid number of seats.  This assumes a room must have
                at least 1 seat.
        */
        try {
            numberOfSeats = input.nextInt();
            if( numberOfSeats < EXCEPTION_DEFAULT_NUMBER_OF_SEATS )
                throw new Exception("ERROR: You cannot have a negative number of seats.  Defaulted to " + EXCEPTION_DEFAULT_NUMBER_OF_SEATS);
        } 
        catch(InputMismatchException e) {
            System.out.println("ERROR: Invalid number of seats. Defaulted to " + EXCEPTION_DEFAULT_NUMBER_OF_SEATS);
            numberOfSeats = EXCEPTION_DEFAULT_NUMBER_OF_SEATS;
            
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            numberOfSeats = EXCEPTION_DEFAULT_NUMBER_OF_SEATS;
        }
        input.nextLine(); // Burn the line
        
        System.out.print("Does this classroom have a smart board? (Y/N)");
        hasSmartBoard = input.nextLine().equalsIgnoreCase("y");

        
        
    }

    public boolean isHasSmartBoard() {
        return hasSmartBoard;
    }

    public void setHasSmartBoard(boolean hasSmartBoard) {
        this.hasSmartBoard = hasSmartBoard;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getReservedBy() {
        return reservedBy;
    }

    public void setReservedBy(String reservedBy) {
        this.reservedBy = reservedBy;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }
    
    
    public int getRoomNumber() {
        return roomNumber;
    }
    
    /**
     * Update the room to reserved and get the reserved by.
     */
  
    public void reserveThisRoom(){
        this.reserved = true;
        System.out.println("Enter the name of the person reserving this room: ");
        reservedBy = input.nextLine();
    }

     /**
     * Update the room to not reserved and clear the reserved by.
     */

    public void releaseThisRoom(){
        this.reserved = false;
        reservedBy = "";
        System.out.println("Room has been released\n");
        
        
    }
    
    public String toString() {
        String output = "\n\n******************************"
                + "\nRoom Number: " + roomNumber
                + "\nNumber of Seats: " + numberOfSeats
                + "\nReserved By: " + reservedBy
                + "\nReserved: " + reserved
                + "\nSmart Board: "+ hasSmartBoard;
        return output;
    }
}
