/*
 * ========= CIS 1232 Intermediate Object Oriented Programming PWC ==========
 * NAME: Christopher Sigouin
 * DATE: 24-Apr-2015
 * PURPOSE: Assignment 8
 */

import exception.RoomExistException;
import exception.RoomReleaseException;
import exception.RoomReservationException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This main method will invoke functionality for booking college rooms.
 *
 * Detailed description:
 * https://docs.google.com/document/d/1jyrvSJHXS6BZuXKVswYkmt2muBmPI71OxXTLQxerDVU/edit
 *
 * @author cis1232 (including Roger)
 * 
 * UPDATED##################
 * This class has been modified by Ryan Forrester to work with the new classes that have
 * been added.
 */
public class RoomMain {

    private static final int ROOM_DOES_NOT_EXIST = -1;
    private static ArrayList<Room> rooms = new ArrayList();
    private static int roomNum;

    /**
     * Main method controls program and user interface.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String menu = "Choose an option:\n"
                + "1) Add Room\n"
                + "2) Reserve Room\n"
                + "3) Release Room\n"
                + "4) Show Rooms\n"
                + "5) Room Count\n"
                + "6) Room Search\n"
                + "7) Exit\n"
                + "====> ";
        int selection = 0;


        while (selection != 7) {
            System.out.print(menu);
            
            /*
                04-24-2015 | CJS | Assignment 8 Modification

                Added
                    Try-Catch surrounding the input for the main menu.
                    Will default to -1 so that it goes to the default
                    value of the switch case.
            */
            try {
                selection = input.nextInt();
            } catch( InputMismatchException e) {
                input.nextLine();
                selection = -1;
            }
            switch (selection) {
                case 1:
                    addRoom();
                    break;
                case 2:
                    try {
                        reserveRoom();
                    } 
                    catch(RoomReservationException | RoomExistException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        releaseRoom();
                    }
                    catch(RoomReleaseException | RoomExistException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    showRooms();
                    break;
                case 5:
                    RoomUtility.roomCount(rooms);
                    break;
                case 6:
                    RoomUtility.roomSearch(rooms);
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }

    }

    /**
     * Loop through the rooms to check if the room already exists.
     *
     * @param roomNumber
     * @return the index of the room number
     */
    public static int getRoomNumberIfExists(int roomNumber) {
        int index = -1;
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getRoomNumber() == roomNumber) {
                index = i;
            }
        }
        return index;
    }

    /**
     * This method will allow the user to add a new room to the collection of rooms.
     *
     */
    public static void addRoom() {

        //***********************************************************
        //Ask which room number the user wants to add
        //***********************************************************
        Room room = null;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter room number: ");
        
        /*
            04-24-2015 | CJS | Assignment 8 Modification

            Added
                Try-Catch surrounding the input for menu requesting
                a room number. Assumed that a room must have a number
                above 0.  If not a valid room number, then an exception
                is thrown.  Also throws an exception if a string
                is entered.
        */
        try {
            roomNum = Integer.parseInt(input.nextLine());
            if( roomNum < 1 )
                throw new Exception("ERROR: Room number not valid.  Back to MAIN MENU");
        } 
        catch(NumberFormatException e) {
            System.out.println("ERROR: Room number not valid.  Back to MAIN MENU");
            roomNum = 0;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            roomNum = 0;
        }


        //***********************************************************
        //Check to see if the room already exists
        //***********************************************************

        int roomNumberIndex = getRoomNumberIfExists(roomNum);

        // If a valid room number
        if(roomNum >= 1) {
            //If the room does not already exist.
            if (roomNumberIndex == ROOM_DOES_NOT_EXIST ) {
                roomNumberIndex = rooms.size();
                boolean finished = false;
                String choice;
                
                do {
                    System.out.print("What type of room is this?\n" + "1) Add Room\n"
                            + "2) Computer Lab\n"
                            + "3) Board Room\n"
                            + "4) Biology lab\n"
                            + "5) Fancy Board Room\n"
                            + "CHOICE ===> ");
                     /*
                        04-24-2015 | CJS | Assignment 8 Modification

                        Added
                            Try-Catch surrounding the input for menu requesting
                            a room type.
                            Will default to 6 so that the switch case handles
                            it as the default option which in this case
                            is invalid and allows the user can attempt again.
                            If not within range of the menu options the switch
                            will handle the invalid entry as default.
                    */
                    try {
                        choice = input.nextLine();
                       
                    } catch ( InputMismatchException e) {
                        System.out.println("ERROR: Chosen room is not valid");
                        // Defaults the choice to 6 that will go to the default option of the switch case.
                        choice = "6";
                    }


                    //***********************************************************
                    //Based on the user input, create the correct type of room.  
                    //***********************************************************

                    switch (choice) {
                        case "1":

                            room = new Room(roomNum);
                            finished = true;
                            break;
                        case "2":
                            room = new ComputerRoom(roomNum);
                            finished = true;
                            break;
                        case "3":
                            room = new BoardRoom(roomNum);
                            finished = true;
                            break;
                        case "4":
                            room = new BiologyLab(roomNum);
                            finished = true;
                            break;
                        case "5":
                            room = new BoardRoomPro(roomNum);
                            finished = true;
                            break;
                        default:
                            System.out.println("Invalid option");

                    }
                } while (!finished);

                //Set the details for the room


                //Note the correct method will be invoked based on which type of room was created above.
                room.getRoomDetailsFromUser();

                //Add the room to the collection of rooms.  Note that as long as an object 'is a' Room 
                //(all of the types of rooms above are rooms), then it can be added to the collection of 
                //rooms.
                rooms.add(room);
                System.out.println("*** Room added ***");


            } else {
                String choice = "";
                System.out.println("Room already exists. Do you want to continue? (Y/N)");
                 /*
                    04-24-2015 | CJS | Assignment 8 Modification

                    Added
                        Try-Catch surrounding the input for menu requesting
                        a Y/N response to a room already existing
                        Will default to N.  
                */
                try {
                    choice = input.nextLine();
                    System.out.println("choice --->" + choice);
                    if( !choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n") )
                        throw new Exception("ERROR: Invalid choice.  Defaulted to N");
                } catch( Exception e) {
                    System.out.println(e.getMessage());
                    choice = "n";
                }

                //If the user wants to continue, invoke the method to change the value of attributes in 
                //the room
                if (choice.equalsIgnoreCase("y")) {
                    rooms.get(roomNumberIndex).getRoomDetailsFromUser();
                }
            }
        } // END: if(roomNum >= 1 )
    }

    
    
    /**
     * This method will allow the user to reserve a room.  
     * @throws exception.RoomReservationException
     * @throws exception.RoomExistException
     */
    
    public static void reserveRoom() throws RoomReservationException, RoomExistException {
        int roomNumber = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the room number you would like to book");
        try {
            roomNumber = input.nextInt();
        } catch( InputMismatchException e ) {
            System.out.println("ERROR: Enter a valid number for a room");
            roomNumber = 0;
        }
        input.nextLine();
        
        //Check to see if the room exists.
        int roomNumberIndex = getRoomNumberIfExists(roomNumber);
        if (roomNumberIndex < 0) {
            /*
                04-24-2015 | CJS | Assignment 8 Modification

                Removed
                    System.out.println("This room does not exist");
                Added
                    If a room does not exist, an exception is thrown
                    of type RoomExistException.
            */
            throw new RoomExistException("ERROR: The room does not exist! Sorry");
            
        } else {
            //Put the room from the ArrayList into a local variable.
            Room room = rooms.get(roomNumberIndex);
            if (!room.isReserved()) {
                room.reserveThisRoom();
            } else {
                /*
                    04-24-2015 | CJS | Assignment 8 Modification
                
                    Removed
                        System.out.println("This room is already booked!");
                    Added
                        If a room is already booked, an exception is thrown
                        of type RoomReservationException.
                */
                
                throw new RoomReservationException("ERROR: The room is already reserved! Sorry");
                
            }
        }
    }

    public static void releaseRoom() throws RoomReleaseException, RoomExistException {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the room number you would like to release");
        int roomNumber = input.nextInt();
        input.nextLine();
        
        //Check if the room exists.  
        int roomNumberIndex = getRoomNumberIfExists(roomNumber);
        
        if (roomNumberIndex < 0) {
            /*
                04-24-2015 | CJS | Assignment 8 Modification

                Removed
                    System.out.println("This room does not exist");
                Added
                    If a room does not exist, an exception is thrown
                    of type RoomExistException.
            */
            throw new RoomExistException("ERROR: The room does not exist! Sorry");
            
        } else {
            //Put the room from the ArrayList into a local variable.
            Room room = rooms.get(roomNumberIndex);
            //If the room is reserved, allow them to release.
            if (room.isReserved()) {
                room.releaseThisRoom();
            } else {
                /*
                    04-24-2015 | CJS | Assignment 8 Modification

                    Removed
                        System.out.println("This room is not booked!");
                    Added
                        If a room is already available, an exception is thrown
                        of type RoomReleaseException.
                */
                throw new RoomReleaseException("ERROR: The room is already released! Sorry");
            }
        }
    }

    /**
     * Show the details for each room
     */
    public static void showRooms() {
        for (int i = 0; i < rooms.size(); i++) {
            System.out.println(rooms.get(i));
        }
    }
}
