
import java.util.ArrayList;

/*
 * ========= CIS 1232 Intermediate Object Oriented Programming PWC ==========
 * NAME: Christopher Sigouin
 * DATE: 22-Mar-2015
 * PURPOSE: Assignment 5 
 *
 */

/**
 *
 * Application - UseHotelRoom
 * 
 * 
 * @author krystofurr
 */
public class UseHotelRoom {

    public static ArrayList<HotelRoom> roomList = new ArrayList();
    /**
     * 
     * MAIN
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Add the rooms to the list using various room numbers for testing
        roomList.add(new HotelRoom(100));
        roomList.add(new HotelRoom(300));
        roomList.add(new Suite(100));
        roomList.add(new Suite(300));

        // Display all instances in the list, noting what type of instance it is
        for(HotelRoom value : roomList) {
            if(value instanceof HotelRoom && !(value instanceof Suite) )
                System.out.print("HOTELROOM INSTANCE: ");
            if( value instanceof Suite )
                System.out.print("SUITE INSTANCE: ");
            System.out.println(value.toString());
        }
       
    }
    
}
