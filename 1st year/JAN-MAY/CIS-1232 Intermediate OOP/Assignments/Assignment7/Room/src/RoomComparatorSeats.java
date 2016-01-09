
import java.util.Comparator;

/*
 * ========= CIS 1232 Intermediate Object Oriented Programming PWC ==========
 * NAME: Christopher Sigouin
 * DATE: 8-Apr-2015
 * PURPOSE: Assignment 7
 */

/**
 
    RoomComparatorSeats Class

    Compares two rooms together and based on their seat
    numbers returns the following values:

    positive – o1 is greater than o2
    0 – o1 equals to o2
    negative – o1 is less than o2
 
*/
public class RoomComparatorSeats implements Comparator<Room> {
    

    
    @Override
    public int compare(Room r1, Room r2) {
 
        // Ascending order
        return r1.getNumberOfSeats() - r2.getNumberOfSeats();
        
        
    }

    
}
