/*
 * ========= CIS 1232 Intermediate Object Oriented Programming PWC ==========
 * NAME: Christopher Sigouin
 * DATE: 22-Mar-2015
 * PURPOSE: Assignment 5 
 *
 */

/**
 * 
 * CHILD CLASS - SUITE
 *
 * @author krystofurr
 */
public class Suite extends HotelRoom {

    public final static double RATE_SURCHARGE = 40; // Adds $40 to the regular room rate based on the room number chosen
    
    public Suite(int roomNumber) {
        super(roomNumber);
        setRentalRate(getRentalRate() + RATE_SURCHARGE); // Sets the room rate with the surcharge
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
    
    
    
    
}
