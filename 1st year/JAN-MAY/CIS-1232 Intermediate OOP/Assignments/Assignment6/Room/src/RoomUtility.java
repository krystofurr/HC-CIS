
import java.util.ArrayList;
import java.util.Scanner;

/*
 * ========= CIS 1232 Intermediate Object Oriented Programming PWC ==========
 * NAME: Christopher Sigouin
 * DATE: 27-Mar-2015
 * PURPOSE: Assignment 6
 */

/**
 *  RoomUtility class
 * 
 * @author krystofurr
 */
public class RoomUtility {
    
    public static final String TAB = "\t", NEWLINE = "\n";
    static Scanner input = new Scanner(System.in);
    
    
    /**
     * Allows a user to enter a room type and number of seats to display all created rooms that match the search criteria
     * 
     * @param rooms
     * @return 
     */
    public static String searchForRoom(ArrayList<Room> rooms) {
        String roomTypeChoice = "", menu = "", output = "";
        int roomSeatChoice = 0;
        
        // Offer choice of roomType
        System.out.print("What type of room\n"
                        + "1) Room\n"
                        + "2) Computer Lab\n"
                        + "3) Board Room\n"
                        + "4) Biology lab\n"
                        + "5) Special Board Room\n"
                        + "Choice: ");
        roomTypeChoice = input.nextLine();
        // Offer choice for seats
        System.out.print("How many seats does this room have?: ");
        roomSeatChoice = Integer.parseInt(input.nextLine());
        
        // Check for any rooms that match the criteria
        for(int i = 0; i < rooms.size(); ++i) {
            switch(roomTypeChoice) {
                case "1":
                    if(rooms.get(i) instanceof Room){
                        if(rooms.get(i).getNumberOfSeats() == roomSeatChoice){
                            output += NEWLINE + "Room #" + rooms.get(i).getRoomNumber() + " Seats: " + rooms.get(i).getNumberOfSeats() + NEWLINE;
                        }
                    }
                    break;
                case "2":
                    if(rooms.get(i) instanceof ComputerRoom){
                        if(rooms.get(i).getNumberOfSeats() == roomSeatChoice){
                            output += NEWLINE + "Computer Room #" + rooms.get(i).getRoomNumber() + " Seats: " + rooms.get(i).getNumberOfSeats() + NEWLINE;
                        }
                    }
                    break;
                case "3":
                     if(rooms.get(i) instanceof BoardRoom){
                        if(rooms.get(i).getNumberOfSeats() == roomSeatChoice){
                            output += NEWLINE + "Board Room #" + rooms.get(i).getRoomNumber() + " Seats: " + rooms.get(i).getNumberOfSeats() + NEWLINE;
                        }
                    }
                    break;
                case "4":
                    if(rooms.get(i) instanceof BiologyLab){
                        if(rooms.get(i).getNumberOfSeats() == roomSeatChoice){
                            output += NEWLINE + "Biology Lab #" + rooms.get(i).getRoomNumber() + " Seats: " + rooms.get(i).getNumberOfSeats() + NEWLINE;
                        }
                    }
                    break;
                case "5":
                    if(rooms.get(i) instanceof SpecialBoardRoom){
                        if(rooms.get(i).getNumberOfSeats() == roomSeatChoice){
                            output += NEWLINE + "Special Board Room #" + rooms.get(i).getRoomNumber() + " Seats: " + rooms.get(i).getNumberOfSeats() + NEWLINE;
                        }
                    }
                    break;
                default:
                    break;
            }
        }
        
        // If there are no rooms to search for...
        if(output.isEmpty()) {
            output = NEWLINE + "There are no rooms that matched your criteria" + NEWLINE;
        }
        
        // Display all rooms that meet the criteria
        return "FOUND THESE ROOMS: " + NEWLINE + output;
        
    }
    
    
    /**
     * Displays a report based on the different types of rooms and the largest room based on number of seats
     * 
     * @param rooms
     * @return 
     */
    public static String roomReport(ArrayList<Room> rooms) {
 
        int roomCount = 0, computerRoomCount = 0, boardRoomCount = 0, biologyLabCount = 0, 
            specialBoardRoomCount = 0, largestNumberOfSeats = 0;
        String largestRoom = "", output = "";
        
        // Loop through the ArrayList of rooms to build a count
        for(int i = 0; i < rooms.size(); ++i) {
            
            // Count the room based on it's type
            roomCount += (rooms.get(i).getRoomType() == Room.RoomTypes.ROOM) ? 1 : 0;
            computerRoomCount += (rooms.get(i).getRoomType() == Room.RoomTypes.ROOM_COMPUTER) ? 1 : 0;
            boardRoomCount += (rooms.get(i).getRoomType() == Room.RoomTypes.ROOM_BOARD) ? 1 : 0;
            biologyLabCount += (rooms.get(i).getRoomType() == Room.RoomTypes.ROOM_BIOLOGY_LAB) ? 1 : 0;
            specialBoardRoomCount += (rooms.get(i).getRoomType() == Room.RoomTypes.ROOM_SPECIAL_BOARD) ? 1 : 0;
            
            // Find the largest number of seats in a given room and assign it 
            if(rooms.get(i).getNumberOfSeats() > largestNumberOfSeats ){
                largestNumberOfSeats = rooms.get(i).getNumberOfSeats();
                largestRoom = "Largest Room(s):  Room#" + rooms.get(i).getRoomNumber() + " with " + 
                               rooms.get(i).getNumberOfSeats() + " seats" + NEWLINE;
            // If it's a tie append it to the output
            } else if(rooms.get(i).getNumberOfSeats() == largestNumberOfSeats ){
                largestNumberOfSeats = rooms.get(i).getNumberOfSeats();
                largestRoom += "Largest Room(s):  Room#" + rooms.get(i).getRoomNumber() + " with " + 
                               rooms.get(i).getNumberOfSeats() + " seats" + NEWLINE;
            }
        }
        
        output = NEWLINE +
                 "Room Count Details Report" + NEWLINE +
                 "Room: " + TAB + TAB + roomCount + NEWLINE +
                 "Computer Room:" + TAB + computerRoomCount + NEWLINE +
                 "Biology Lab:" + TAB + biologyLabCount + NEWLINE +
                 "Board Room:" + TAB + boardRoomCount + NEWLINE + 
                 "S. Board Room:" + TAB + specialBoardRoomCount + NEWLINE + 
                 NEWLINE +
                 largestRoom + NEWLINE;
        
        return output;
    } // END: roomReport()
    
   
    
}
