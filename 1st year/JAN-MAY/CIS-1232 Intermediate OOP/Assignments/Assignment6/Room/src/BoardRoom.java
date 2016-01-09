
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
public class BoardRoom extends Room{
    private boolean hasTeleconferencing;

    public BoardRoom(int roomNumber) {
        super(roomNumber);
        roomType = Room.RoomTypes.ROOM_BOARD;
    }

    public boolean isHasTeleconferencing() {
        return hasTeleconferencing;
    }

    public void setHasTeleconferencing(boolean hasTeleconferencing) {
        this.hasTeleconferencing = hasTeleconferencing;
    }
    
    public String toString() {
        return super.toString() + "\nHas teleconferencing: " + hasTeleconferencing;
    }
    
     /**
     * Get the details from the user about this class.  This will invoke the super method to get the 
     * base class attributes.
     */

    public void getRoomDetailsFromUser() {
        super.getRoomDetailsFromUser();
        Scanner input = new Scanner(System.in);
        System.out.print("Does this room have teleconferencing (y/n) ");
        hasTeleconferencing = input.nextLine().equalsIgnoreCase("y");
        ;
    }
}
