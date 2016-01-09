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
public class BiologyLab extends Room{
    
    /*
        04-24-2015 | CJS | Assignment 8 Modification

        Added
            Constant for the default value of numberOfMicroscopes
            to be used for exception handling
    */
    public final static int EXCEPTION_DEFAULT_NUMBER_OF_MICROSCOPES = 1;
    private int numberOfMicroscopes;
    private boolean hasFumeHood;
    private boolean hasBunsonBurners;

    public BiologyLab(int roomNumber) {
        super(roomNumber);
    }

    public int getNumberOfMicroscopes() {
        return numberOfMicroscopes;
    }

    public void setNumberOfMicroscopes(int numberOfMicroscopes) {
        this.numberOfMicroscopes = numberOfMicroscopes;
    }

    public boolean isHasFumeHood() {
        return hasFumeHood;
    }

    public void setHasFumeHood(boolean hasFumeHood) {
        this.hasFumeHood = hasFumeHood;
    }

    public boolean isHasBunsonBurners() {
        return hasBunsonBurners;
    }

    public void setHasBunsonBurners(boolean hasBunsonBurners) {
        this.hasBunsonBurners = hasBunsonBurners;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nNumber of microscopes: " + numberOfMicroscopes+"\nHas fumehood: "+ hasFumeHood+ "\nHas Bunson burners: "+hasBunsonBurners;
    }
    
    /**
     * Get the details from the user about this class.  This will invoke the super method to get the 
     * base class attributes.
     */
    @Override
    public void getRoomDetailsFromUser() {
        super.getRoomDetailsFromUser();
        Scanner input = new Scanner(System.in);
        System.out.print("How many microscopes does this room have? ");
        
        /*
            04-24-2015 | CJS | Assignment 8 Modification

            Added
                Try-Catch surrounding the input for menu requesting
                a valid number of microscopes.  This assumes a room has to
                have at least 1 microscope. A value below 1 is not permitted
                and will be defaulted to 1.
        */
        try {
            numberOfMicroscopes = input.nextInt();
            if( numberOfMicroscopes < EXCEPTION_DEFAULT_NUMBER_OF_MICROSCOPES )
                throw new Exception("ERROR: You cannot have a negative value of microscopes.  Defaulted to " + EXCEPTION_DEFAULT_NUMBER_OF_MICROSCOPES);
        } 
        catch( InputMismatchException e ) {
            System.out.println("ERROR: Invalid number of microscopes.  Defaulted to " + EXCEPTION_DEFAULT_NUMBER_OF_MICROSCOPES);
            numberOfMicroscopes = EXCEPTION_DEFAULT_NUMBER_OF_MICROSCOPES;
        }
        catch( Exception e ) {
            System.out.println(e.getMessage());
            numberOfMicroscopes = EXCEPTION_DEFAULT_NUMBER_OF_MICROSCOPES;
        }
        input.nextLine();
        
        System.out.print("Does this lab have a fume hood? ");
        hasFumeHood = input.nextLine().equalsIgnoreCase("y");
        System.out.print("Does this lab have bunson burners? ");
        hasBunsonBurners = input.nextLine().equalsIgnoreCase("y");
    }
}
