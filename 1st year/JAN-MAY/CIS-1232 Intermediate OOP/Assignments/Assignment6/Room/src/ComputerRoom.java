
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
public class ComputerRoom extends Room {

    int numberOfComputers;

    public ComputerRoom(int roomNumber) {
        super(roomNumber);
        roomType = Room.RoomTypes.ROOM_COMPUTER;
    }

    /**
     * Get the details from the user about this class. This will invoke the super method to get the
     * base class attributes.
     */
    public void getRoomDetailsFromUser() {
        super.getRoomDetailsFromUser();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of computers: ");
        numberOfComputers = input.nextInt();
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
