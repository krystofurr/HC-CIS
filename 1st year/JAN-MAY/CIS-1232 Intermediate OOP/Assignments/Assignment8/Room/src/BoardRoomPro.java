/*
 * ========= CIS 1232 Intermediate Object Oriented Programming PWC ==========
 * NAME: Christopher Sigouin
 * DATE: 24-Apr-2015
 * PURPOSE: Assignment 8
 */

import java.util.InputMismatchException;
import java.util.Scanner;


/**
 *
 * @author Ryan
 * @since March 23, 2014
 * 
 * This class extends the board room class by adding a few new features such as a 
 * coffee maker and a lazy boy option.
 */
public class BoardRoomPro extends BoardRoom{
    
    /*
        04-24-2015 | CJS | Assignment 8 Modification

        Added
            Constant for the default value of numOfLazyBoy
            to be used for exception handling
    */
    public final static int EXCEPTION_DEFAULT_NUMBER_OF_LAZY_BOY = 0;
    private boolean hasLazyBoy;
    private int numOfLazyBoy = 0;
    private boolean hasCoffee;
    public BoardRoomPro(int roomNumber) {
        super(roomNumber);
    }
    public String toString() {
        return super.toString() + "\nNumber of Recliners: " + numOfLazyBoy +
                "\nHas a coffee maker: " + hasCoffee;
    }
    
     /**
     * Get the details from the user about this class.  This will invoke the super method to get the 
     * base class attributes.
     */

    public void getRoomDetailsFromUser() {
        super.getRoomDetailsFromUser();
        Scanner input = new Scanner(System.in);
        System.out.println("does this room have a coffe maker? (y/n)");
        hasCoffee = input.nextLine().equalsIgnoreCase("y");
        System.out.print("Does this room have a lazy boy recliner? (y/n) ");
        hasLazyBoy = input.nextLine().equalsIgnoreCase("y");
        if(hasLazyBoy){
           System.out.println("How many Lazy Boy Recliners does it have?");
           
           /*
                04-24-2015 | CJS | Assignment 8 Modification

                Added
                    Try-Catch surrounding the input for menu requesting
                    a valid number of lazy boy recliners.  This assumes a room can
                    have 0 lazy boy recliners. A value below 0 is not permitted
                    and will be defaulted to 0.
            */
           try {
                numOfLazyBoy = input.nextInt();
                if( numOfLazyBoy < EXCEPTION_DEFAULT_NUMBER_OF_LAZY_BOY )
                    throw new Exception("ERROR: You cannot have a negative value of Lazy Boy Recliners. Defaulted to " + EXCEPTION_DEFAULT_NUMBER_OF_LAZY_BOY);
           } 
           catch(InputMismatchException e) {
                System.out.println("ERROR: Invalid number of Lazy Boy Recliners. Defaulted to " + EXCEPTION_DEFAULT_NUMBER_OF_LAZY_BOY);
                numOfLazyBoy = EXCEPTION_DEFAULT_NUMBER_OF_LAZY_BOY;
           }
           catch(Exception e) {
                System.out.println(e.getMessage());
                numOfLazyBoy = EXCEPTION_DEFAULT_NUMBER_OF_LAZY_BOY;
           }
        }
        
    }
    
}
