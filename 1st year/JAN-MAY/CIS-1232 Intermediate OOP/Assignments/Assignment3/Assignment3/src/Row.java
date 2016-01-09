
import java.util.ArrayList;

/*
 *  *** CIS-1232 Intermediate OOP ***
 * 
 * NAME: Christopher Sigouin
 * DATE: 17-Feb-2015
 * PROJECT NAME: Assignment 3
 * DEPENDENCIES: Seat.java
 */

/**
 *
 *  Row holds information regarding seats that are available in a row
 *
 * @author Christopher Sigouin
 * @since 17-Feb-2015
 */
public class Row {
    
    
    private int rowNumber;
    private int rowPricing;
    private ArrayList<Seat> seats = new ArrayList(); // Specified for Seat type
    
    /**
     * 
     * When a row is created the row number is set and the price of the 
     * seats in the row are set as well based on the row number
     * 
     * @param rowNumber 
     */
    public Row(int rowNumber) {
    
        this.rowNumber = rowNumber;
        
        // Rows 1 - 5 are $100
        if( rowNumber > 5 )
            rowPricing = Seat.SEATS_LOW_COST;
        // Rows above 5 are $70
        else
            rowPricing = Seat.SEATS_HIGH_COST;
        
    }
    
    /**
     * 
     * Returns true or false based on if the seat has been sold or not
     * 
     * @param seatNumber
     * @return 
     */
  
    public double getSeatPrice() {
        // Seat pricing is now based on the particular row
        return rowPricing;
    }
   
    public ArrayList<Seat> getSeats() {
        return seats;
    }
    
    public int getRowNumber() {
        return rowNumber;
    }
    
    public int getSeatNumber(int index) {
        return seats.get(index).getSeatNumber();
    }
    
    /**
     * 
     * Adds a new Seat to the ArrayList and sets it's seat number
     * 
     * @param seatNumber 
     */
    public void addSeat(int seatNumber) {
        seats.add(new Seat(seatNumber));
    }
    /**
     * Returns the seat object specified by it's seat number
     * 
     * @param seatNumber
     * @return 
     */
    public Seat getSeatByNumber(int seatNumber) {
        int index = 0;
        
        for(Seat item : seats) {
            if( item.getSeatNumber() == seatNumber ) {
                break;
            }
            ++index; 
        }
        
        return seats.get(index);
    }
    
    

    
    

    

}
