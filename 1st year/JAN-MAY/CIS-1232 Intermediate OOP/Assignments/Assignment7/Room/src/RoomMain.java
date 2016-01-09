/*
 * ========= CIS 1232 Intermediate Object Oriented Programming PWC ==========
 * NAME: Christopher Sigouin
 * DATE: 8-Apr-2015
 * PURPOSE: Assignment 7
 */
import java.util.ArrayList;
import java.util.Collections;
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

    public static final String NEWLINE = System.lineSeparator();
    
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
        String menu = NEWLINE + "Choose an option:" + NEWLINE
                + "1) Add Room"+NEWLINE
                + "2) Reserve Room"+NEWLINE
                + "3) Release Room"+NEWLINE
                + "4) Show Rooms"+NEWLINE
                + "5) Room Count"+NEWLINE
                + "6) Room Search"+NEWLINE
                + "7) Exit"+NEWLINE
                + "CHOICE ===> ";
        int selection = 0;


        while (selection != 7) {
            System.out.print(menu);
            selection = Integer.parseInt(input.nextLine());
            switch (selection) {
                case 1:
                    System.out.println(NEWLINE);
                    addRoom();
                    break;
                case 2:
                    System.out.println(NEWLINE);
                    reserveRoom();
                    break;
                case 3:
                    System.out.println(NEWLINE);
                    releaseRoom();
                    break;
                case 4:
                    System.out.println(NEWLINE);
                    showRooms();
                    break;
                case 5:
                    System.out.println(NEWLINE);
                    RoomUtility.roomCount(rooms);
                    break;
                case 6:
                    System.out.println(NEWLINE);
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
        roomNum = Integer.parseInt(input.nextLine());
        
        

        //***********************************************************
        //Check to see if the room already exists
        //***********************************************************

        int roomNumberIndex = getRoomNumberIfExists(roomNum);

        //If the room does not already exist.
        if (roomNumberIndex == ROOM_DOES_NOT_EXIST) {
            roomNumberIndex = rooms.size();
            boolean finished = false;
            do {
                System.out.print("What type of room is this?" + NEWLINE
                        + "1) General Room" + NEWLINE
                        + "2) Computer Lab" + NEWLINE
                        + "3) Board Room" + NEWLINE
                        + "4) Biology lab" + NEWLINE
                        + "5) Fancy Board Room" + NEWLINE
                        + "Choice ===> ");
                String choice = input.nextLine();


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

        } else {
            String choice = "";
            System.out.print("Room already exists. Do you want to continue? (Y/N): ");
            choice = input.nextLine();
            
            //If the user wants to continue, invoke the method to change the value of attributes in 
            //the room
            if (choice.equalsIgnoreCase("y")) {
                rooms.get(roomNumberIndex).getRoomDetailsFromUser();
            }
        }
    }

    
    
    /**
     * This method will allow the user to reserve a room.  
     */
    
    public static void reserveRoom() {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the room number you would like to book: ");
        int roomNumber = input.nextInt();
        input.nextLine();
        
        //Check to see if the room exists.
        int roomNumberIndex = getRoomNumberIfExists(roomNumber);
        if (roomNumberIndex < 0) {
            System.out.println("This room does not exist");
        } else {
            //Put the room from the ArrayList into a local variable.
            Room room = rooms.get(roomNumberIndex);
            if (!room.isReserved()) {
                room.reserveThisRoom();
            } else {
                System.out.println("This room is already booked!");
            }
        }
    }

    public static void releaseRoom() {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the room number you would like to release: ");
        int roomNumber = input.nextInt();
        input.nextLine();
        
        //Check if the room exists.  
        int roomNumberIndex = getRoomNumberIfExists(roomNumber);
        
        if (roomNumberIndex < 0) {
            System.out.println("This room does not exist");
        } else {
            //Put the room from the ArrayList into a local variable.
            Room room = rooms.get(roomNumberIndex);
            //If the room is reserved, allow them to release.
            if (room.isReserved()) {
                room.releaseThisRoom();
            } else {
                System.out.println("This room is not booked!");
            }
        }
    }

    /**
     * Show the details for each room
     */
    public static void showRooms() {
        
        /*
            April 8, 2015 - CS -  Assignment 7 Modification
            CHANGE DESCRIPTION:

            Menu to allow user choice of sorting and switch case
            implemented to provide proper sort based on user
            choice.
        */
        int choice;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the sort option:" + NEWLINE +
                           "1)  Sort by number of seats ascending" + NEWLINE +
                           "2)  Sort by room number ascending" + NEWLINE +
                           "3)  Show all rooms ( No Sort Implemented )" + NEWLINE +
                           "CHOICE ===> ");
        choice = Integer.parseInt(input.nextLine());
        
        switch(choice) {
            
            case 1:
                // Using Comparator
                Collections.sort(rooms, new RoomComparatorSeats());
                break;
            case 2:
                // Using Comparable
                Collections.sort(rooms);
                break;
            case 3:
                // Using nothing. Display all rooms with no sort
                break;
            default:
                break;
        }
        
        // Display the rooms
        for (int i = 0; i < rooms.size(); i++) {
            System.out.println(rooms.get(i));
        }
    }
}
