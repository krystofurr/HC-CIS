
import java.util.Scanner;

/*
 * ========= CIS 1232 Intermediate Object Oriented Programming PWC ==========
 * NAME: Christopher Sigouin
 * DATE: 27-Mar-2015
 * PURPOSE: Assignment 6
 */

/**
 *
 * @author bjmaclean
 */
public class BiologyLab extends Room{
    private int numberOfMicroscopes;
    private boolean hasFumeHood;
    private boolean hasBunsonBurners;

    public BiologyLab(int roomNumber) {
        super(roomNumber);
        roomType = Room.RoomTypes.ROOM_BIOLOGY_LAB;
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
        numberOfMicroscopes = input.nextInt();
        input.nextLine();
        System.out.print("Does this lab have a fume hood? ");
        hasFumeHood = input.nextLine().equalsIgnoreCase("y");
        System.out.print("Does this lab have bunson burners? ");
        hasBunsonBurners = input.nextLine().equalsIgnoreCase("y");
    }
}
