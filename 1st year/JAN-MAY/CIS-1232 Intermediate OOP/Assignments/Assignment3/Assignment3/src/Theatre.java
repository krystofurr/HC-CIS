import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

/*
 *  *** CIS-1232 Intermediate OOP ***
 * 
 * NAME: Christopher Sigouin
 * DATE: 17-Feb-2015
 * PROJECT NAME: Assignment 3
 * DEPENDENCIES: Row.java, Seat.java
 */

/**
 * This class will hold attributes/functionality for a theatre.
 * @author BJ
 * @since 2014-01-27
 */
public class Theatre {

    //Number of rows in the theatre
    public static final int NUMBER_ROWS = 10;
    //Number of seats that are in each row
    public static final int NUMBER_OF_SEATS_IN_ROW = 15;
    private Seat[][] seat = new Seat[NUMBER_ROWS][NUMBER_OF_SEATS_IN_ROW];
    
    private ArrayList<Row> rows = new ArrayList<>();
    private boolean isRowValid = false; 
    private boolean isSeatValid = false;
    
    private String theatreName; // Store the parameter " City Cinema "
    NumberFormat currencyFormat; // Used for currency formatting
    

    public Theatre(String theatreName){
        this.theatreName = theatreName;
        
        for(int x=0;x<seat.length;x++){
            for(int y=0;y<seat[x].length;y++){
                seat[x][y] = new Seat(1);
                
                if(x<5){ // If row is less than 5, set price of seat to 100
                    seat[x][y].setPrice(100);
                }else{ // If row is not less than 5, set price to 70
                    seat[x][y].setPrice(70);
                }
            }
        }
    }
    /**
     * This method prompts for row and seat number and reserves it under a name if it is not already reserved
     */
    public void reserveSeat(){
        
        // Reset these everytime an attempt is made to reserve
        isRowValid = false;
        isSeatValid = false;
        Scanner input = new Scanner(System.in);
        int row;
        int seat;
        //Gathering row number with validation
        do{
            System.out.print("Please select row: ");
            row = input.nextInt();
            row--;
        }while(row<0||row>=NUMBER_ROWS);
        //Gathering seat number with validation
        do{
            System.out.print("Please select seat: ");
            seat = input.nextInt();
            seat--;
        }while(seat<0||seat>=NUMBER_OF_SEATS_IN_ROW);
        
        ++row; // Change back to row number requested
        ++seat; // Change back to seat number requested
        
        /*
        
            Check on both the row and the seat entered
        
        */
        
        // Check to see if the row number exists in the list
        for(int i = 0; i < rows.size(); ++i ) {
            if( row == (rows.get(i).getRowNumber()) ) {
                // Found the row
                isRowValid = true;
                
                // Since the row is valid, check for the seat...
                for(int j = 0; j < rows.get(i).getSeats().size(); ++j ) {
                    if( seat == rows.get(i).getSeatNumber(j) ) {
                        // Found the row
                        isSeatValid = true;
                    }
                }
            }
        }
        
        // If Row exists...
        if( isRowValid ) {

            // If Seat exists...
            if( isSeatValid ) {
                
                if( getRowByNumber(row).getSeatByNumber(seat).isSold() )
                    System.out.println("The seat is sold! Sorry");
                else {
                    /*
                        Only time the program will reach this decision branch is if the seat
                        was already created prior and the seat was " unreserved ". Functionality
                        isn't implemented yet
                    
                    */
                    requestName(row, seat, input);
                }
            // No Seat exists. Have to create it...
            } else {
                getRowByNumber(row).addSeat(seat);
                requestName(row, seat, input);
            }
        
        // No Row exists. Have to create it...
        } else {
            
            /*
                We don't know what row will be chosen.  So to add a seat to the row that is
                created we will use the last row that was added to the ArrayList 'rows'
            */
            
            // Add the new row 
            rows.add(new Row(row));
            // No row existed, so no seat existed.  Create a seat in the new row.  Last row created
            rows.get(rows.size() - 1).addSeat(seat);
            
            System.out.format("The price of the seat is: $%.2f%n", rows.get(rows.size() - 1).getSeatPrice());
            System.out.print("Please enter your name to reserve seat: ");
            // If the row is newly created, there will be no seats yet
            rows.get(rows.size() - 1).getSeatByNumber(seat).setReservedBy(input.next());
            rows.get(rows.size() - 1).getSeatByNumber(seat).setSold(true);
        }
    }
    
    
    /**
     * This method displays all the seats and gives a visual representation of which seats are reserved
     */
    public void showReservations(){
        String output = "";
        for(int x=0;x<seat.length;x++){
            for(int y=0;y<seat[x].length;y++){
                if(seat[x][y].isSold()){ // If seat is sold, append "x"
                    output += "x ";
                }else{ // If seat is not sold, append "o"
                    output += "o ";
                }
            }
            output += "Row "+(x+1)+"\n"; // Append newline character when row is complete
        }
        System.out.println(output);
    }
    
    /**
     * This method calculates the total value of seats sold and displays it
     */
    public void showTotalValue(){
        double totalValue = 0;
        // Loop through each row
        for(int x=0;x<rows.size();x++){
            // Loop through each seat
            for(int y = 0; y < rows.get(x).getSeats().size(); ++y){
                if( rows.get(x).getSeats().get(y).isSold() ){
                    // Add the row pricing to the total
                    totalValue += rows.get(x).getSeatPrice();
                }
             }
        }
        System.out.format("The total value of seats sold is $%.2f%n", totalValue);
    }
    
    /**
     * Returns the specified row object by the row number
     * 
     * @param rowNumber
     * @return 
     */
    public Row getRowByNumber(int rowNumber) {
        int index = 0;
        
        for(Row item : rows) {
            if( item.getRowNumber() == rowNumber ) {
                break;
            }
            ++index; 
        }
        
        return rows.get(index);
    }

    /**
     * GETTER for ArrayList<Row>
     * @return 
     */
    public ArrayList<Row> getRows() {
        return rows;
    }
    
    /**
     * Utility method to prevent duplication in decision structure.  Requests
     * name and updates seat status.
     * 
     */
    private void requestName(int row, int seat, Scanner input) {
        System.out.format("The price of the seat is: $%.2f%n", getRowByNumber(row).getSeatPrice());     
        System.out.print("Please enter your name to reserve seat: ");
        getRowByNumber(row).getSeatByNumber(seat).setReservedBy(input.next());
        getRowByNumber(row).getSeatByNumber(seat).setSold(true);
 
    }
    
    
}
