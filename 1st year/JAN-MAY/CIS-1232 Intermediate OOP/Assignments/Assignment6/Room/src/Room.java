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
public class Room {   
    
    Scanner input = new Scanner(System.in);
    // Enumerated Room Types
    public static enum RoomTypes { ROOM, ROOM_SPECIAL_BOARD, ROOM_COMPUTER, ROOM_BOARD, ROOM_BIOLOGY_LAB };
    private int roomNumber;
    private int numberOfSeats;
    private String reservedBy = "";
    private boolean reserved;
    private boolean hasSmartBoard;
    protected RoomTypes roomType; // Holds the type of room based on enumeration
    
    /**
     * Get the attribute values from the user.
     */
    
    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        roomType = RoomTypes.ROOM;
  
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

    public RoomTypes getRoomType() {
        return roomType;
    }
    
    
}
