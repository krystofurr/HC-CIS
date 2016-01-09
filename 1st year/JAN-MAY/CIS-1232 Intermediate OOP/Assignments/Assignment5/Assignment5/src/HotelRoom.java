/*
 * ========= CIS 1232 Intermediate Object Oriented Programming PWC ==========
 * NAME: Christopher Sigouin
 * DATE: 22-Mar-2015
 * PURPOSE: Assignment 5 
 *
 */

/**
 *
 * PARENT CLASS - HOTEL ROOM
 * 
 * @author krystofurr
 */
public class HotelRoom {

    public final static double RATE_LOW = 69.95; // Appplies to Room 299 and below
    public final static double RATE_HIGH = 89.95; // Applies to any room above Room 299
    public final static int RATE_BOUNDS = 299; // Boundry between low and high rates
    private int roomNumber;
    private double rentalRate;

    
    public HotelRoom(int roomNumber) {
        this.roomNumber = roomNumber;
        verifyRoomRate(roomNumber);
    }

    @Override
    public String toString() {
        
        return "{" + "roomNumber=" + roomNumber + ", rentalRate=" + rentalRate + '}';
    }

    /**
     * HELPER METHOD
     * 
     * Based on the room number provided, this method will set the appropriate rate
     * 
     * @param roomNumber 
     */
    private void verifyRoomRate(int roomNumber) {
        // Any room that is #299 and below has a low rate.  Anything else has the high rate
         rentalRate = ( roomNumber <= RATE_BOUNDS ) ? RATE_LOW : RATE_HIGH;
    }
    
    // GETTERS AND SETTERS

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }

    
    
    
    
    
}
