import java.util.Scanner;
/*
 * ========= CIS 1232 Intermediate Object Oriented Programming PWC ==========
 * NAME: Christopher Sigouin
 * DATE: 8-Apr-2015
 * PURPOSE: Assignment 7
 */

/**
 *
 * @author bjmaclean
 */

/*
    April 8, 2015 - CS -  Assignment 7 Modification
    CHANGE DESCRIPTION:

    Changed class Room to implement Comparable for future comparisons
*/
public class Room extends RoomBase implements Comparable<Room>, Bookable{
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
        numberOfSeats = input.nextInt();
        input.nextLine();
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

    /*
        April 8, 2015 - CS -  Assignment 7 Modification
        CHANGE DESCRIPTION:

        Abstract method added due to interface Comparable.
        Will allow sorting by the number of seats and returns
        1 = Greater, 0 = Equal, -1 = Less
    */
    @Override
    public int compareTo(Room r) {

        return this.roomNumber - r.roomNumber;
    }
}
