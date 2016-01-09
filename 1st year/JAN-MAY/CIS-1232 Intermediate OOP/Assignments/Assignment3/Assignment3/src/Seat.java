/*
 *  *** CIS-1232 Intermediate OOP ***
 * 
 * NAME: Christopher Sigouin
 * DATE: 17-Feb-2015
 * PROJECT NAME: Assignment 3
 * DEPENDENCIES: None
 */

/**
 * This class will hold information about a seat.  
 * 
 * @author BJ
 * @since 2014-01-27
 */

public class Seat {

    public final static int SEATS_HIGH_COST = 100; // First 5 Rows
    public final static int SEATS_LOW_COST = 70; // Any rows past 5
    
    private String reservedBy;
    private double price;
    private boolean sold = false;
    
    private int seatNumber;

    public Seat(int seatNumber) {
        this.seatNumber = seatNumber;
    }
    
    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getReservedBy() {
        return reservedBy;
    }

    public void setReservedBy(String reservedBy) {
        this.reservedBy = reservedBy;
    }

    public int getSeatNumber() {
        return seatNumber;
    }
    
    
}
