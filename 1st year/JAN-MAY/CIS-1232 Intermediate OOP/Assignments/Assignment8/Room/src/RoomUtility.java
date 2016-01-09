/*
 * ========= CIS 1232 Intermediate Object Oriented Programming PWC ==========
 * NAME: Christopher Sigouin
 * DATE: 24-Apr-2015
 * PURPOSE: Assignment 8
 */

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Ryan
 * @since March 23, 2014
 * 
 * This class is used for counting the rooms as well as searching for a room that 
 * suits the users need.
 */
public class RoomUtility {

    public static void roomCount(ArrayList<Room> rooms) {
        int numOfRoom = 0;
        int numOfComputerRoom = 0;
        int numOfBoardRoom = 0;
        int numOfBoardRoomPro = 0;
        int numOfBiologyRoom = 0;
        int largestRoom = 0;
        int largestNumOfRooms = 0;
        for (int i = 0; i < rooms.size(); i++) {

            System.out.println("This room is a: " + rooms.get(i).getClass().toString());
            if (rooms.get(i).getClass().toString().equals("class Room")) {
                numOfRoom += 1;
            }
            if (rooms.get(i).getClass().toString().equals("class ComputerRoom")) {
                numOfComputerRoom += 1;
            }
            if (rooms.get(i).getClass().toString().equals("class BoardRoom")) {
                numOfBoardRoom += 1;
            }
            if (rooms.get(i).getClass().toString().equals("class BiologyLab")) {
                numOfBiologyRoom += 1;
            }
            if (rooms.get(i).getClass().toString().equals("class BoardRoomPro")) {
                numOfBoardRoomPro += 1;
            }

            if (rooms.get(i).getNumberOfSeats() > largestNumOfRooms) {//Determine largest room
                largestNumOfRooms = rooms.get(i).getNumberOfSeats();
                largestRoom = rooms.get(i).getRoomNumber();
            }
        }
        //Display the results of counting 
        System.out.println("Room Count Details Report"
                + "\nRooms: " + numOfRoom
                + "\nComputer Rooms: " + numOfComputerRoom
                + "\nBiology Labs: " + numOfBiologyRoom
                + "\nBoard Rooms: " + numOfBoardRoom
                + "\nFancy Board Rooms: " + numOfBoardRoomPro
                + "\n\nLargest Room is #" + largestRoom + " with " + largestNumOfRooms + "seats");
    }

    public static void roomSearch(ArrayList<Room> rooms) {
        
        boolean invalidEntry = true;
        Scanner input = new Scanner(System.in);
        int roomTypeNum = 0;
        do {
            System.out.println("1) Room\n"
                    + "2) Computer Lab\n"
                    + "3) Board Room\n"
                    + "4) Biology lab\n"
                    + "5) Fancy Board Room");
            
            /*
                04-24-2015 | CJS | Assignment 8 Modification

                Added
                    Try-Catch surrounding the input for menu requesting
                    a valid menu option.  If invalid, roomNumType is
                    set to 0. Added a boolean value " invalidEntry to hold
                    the value of (roomTypeNum < 1 || roomTypeNum > 5). If
                    not valid the rest of the method is aborted.  Ensures
                    that the value is within range and is numeric.
            */
            try {
                roomTypeNum = input.nextInt();
                invalidEntry = (roomTypeNum < 1 || roomTypeNum > 5);
                if(invalidEntry) {
                    throw new Exception("ERROR: You selected an invalid option. Please choose a valid option");
                }
            }
            catch( InputMismatchException e) {
                System.out.println("ERROR: You selected an invalid option. Please choose a valid option");
                roomTypeNum = 0;
            }
            catch( Exception e) {
                System.out.println(e.getMessage());
                roomTypeNum = 0; // Probably don't have to, but good to set to 0
            }
            input.nextLine();
            
        } while (invalidEntry);
        
        String roomTypeString = "";

        if (roomTypeNum == 1) {
            roomTypeString = "class Room";
        }
        if (roomTypeNum == 2) {
            roomTypeString = "class ComputerRoom";
        }
        if (roomTypeNum == 3) {
            roomTypeString = "class BoardRoom";
        }
        if (roomTypeNum == 4) {
            roomTypeString = "class BiologyLab";
        }
        if (roomTypeNum == 5) {
            roomTypeString = "class BoardRoomPro";
        }

        if(!invalidEntry) {
            System.out.println("How many seats do you need?");
            
            /*
                04-24-2015 | CJS | Assignment 8 Modification

                Added
                    Try-Catch surrounding the input for menu requesting
                    a valid number of seats. Assumed that you can enter
                    0 seats as a valid search due to the default
                    value allowed for creating rooms.
            */
            int numOfSeats = 0;
            try {
                numOfSeats = input.nextInt();
                if( numOfSeats < 0 )
                    throw new Exception("ERROR: You selected an invalid number of seats. Defaulted to 0");
            }
            catch( InputMismatchException e) {
                System.out.println("ERROR: You selected an invalid number of seats. Defaulted to 0");
                numOfSeats = 0;
            }
            catch( Exception e) {
                System.out.println(e.getMessage());
                numOfSeats = 0;
            }
            input.nextLine();
            
            System.out.println("STARTING ROOM SEARCH...");
            for (int i = 0; i < rooms.size(); i++) {
                if (rooms.get(i).getClass().toString().equals(roomTypeString)) {//If it is the right type of room..
                    if (!rooms.get(i).isReserved()) {                           //<--and the room is not reserved.. 
                        if (rooms.get(i).getNumberOfSeats() >= numOfSeats) {    //<-- and it also has the right number of seats or more.
                            System.out.println("\n\n******************************"
                                    + "\nRoom Number: " + rooms.get(i).getRoomNumber()
                                    + "\nNumber of Seats: " + rooms.get(i).getNumberOfSeats()
                                    + "\nSmart Board: " + rooms.get(i).isHasSmartBoard());
                        } 
                    }
                }

            }
            System.out.println("FINISHED ROOM SEARCH");
        } // END: if(!invalidEntry) {

    }

}
