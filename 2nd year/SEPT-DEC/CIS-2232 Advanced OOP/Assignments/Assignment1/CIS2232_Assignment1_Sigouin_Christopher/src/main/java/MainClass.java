/*
 * ========= CIS 2232 Advanced Object Oriented Programming PWC ==========
 * NAME: Christopher Sigouin
 * DATE: 20-Sep-2015
 * PURPOSE: Topic 1 Assignment 1
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * MAIN CLASS
 * 
 * @since 20151003
 * @author Christopher Sigouin
 */
public class MainClass {

    private final static String FILE_PATH = "/cis2232/deliverables.csv";
    private final static int MAX_DELIVERABLE_WEIGHT = 100; // Max weight is 100%
     
    private static char choice; // Menu choice
    private static int deliverableWeights = 0; // Tally variable for deliverable weights
    private static ArrayList<Deliverable> deliverables = new ArrayList(); // Deliverable list
    
    private static final String MENU = " === MENU === " + System.lineSeparator() +
                                       "(L) Load Deliverables" + System.lineSeparator() +
                                       "(S) Show Deliverables" + System.lineSeparator() +
                                       "(G) Input Grades" + System.lineSeparator() +
                                       "(Q) Quit" + System.lineSeparator() +
                                       System.lineSeparator() +
                                       "Choice --->";
    /**
     *      MAIN
     */
    public static void main(String[] args) {
        
        
        // Load deliverables from file if it exists
        loadDeliverables();
        
        // Menu
        do {
            
            System.out.print(MENU);
            choice = FileUtility.getInput().nextLine().toUpperCase().charAt(0);
            
            switch( choice )
            {
                case 'L':
                    System.out.println(" === LOAD DELIVERABLES === " + System.lineSeparator());
                    System.out.println("Please enter deliverables that total 100%" + System.lineSeparator());
                    addDeliverables();
                    break;
                case 'S':
                    System.out.println(" === SHOW DELIVERABLES === " + System.lineSeparator());
                    showDeliverables();
                    break;
                case 'G':
                    System.out.println(" === INPUT GRADES === " + System.lineSeparator());
                    System.out.println("Please enter your grades for each deliverable" + System.lineSeparator());
                    calculateGrades();
                    break;
            }      
            
        } while( choice != 'Q');
  
    } // END: MAIN
    
    /**
     * Adds deliverables to the ArrayList
     * 
     * @since 20151003
     * @author Christopher Sigouin
     * 
     */
    private static void addDeliverables() {
    
        if( deliverableWeights < MAX_DELIVERABLE_WEIGHT ) {
            do {

                // Create a new deliverable object
                Deliverable deliverable = new Deliverable();

                System.out.print("Enter a name for the deliverable: ");
                deliverable.setName(FileUtility.getInput().nextLine());

                System.out.print("Enter a weight for the deliverable( eg. 30 for 30% ): ");
                deliverable.setWeight(Integer.parseInt(FileUtility.getInput().nextLine()));

                // Add the deliverable to the list
                deliverables.add(deliverable);

                // Tally the deliverable weights to end the loop
                deliverableWeights += deliverable.getWeight();

            } while ( deliverableWeights < MAX_DELIVERABLE_WEIGHT );
            
            // Load the deliverables to a file called "deliverables.csv"
            storeDeliverables();
            
        } else {
            System.out.println("You've entered the maximum deliverable weight. Back to MENU");
        }
        
    }
    
    /**
     * Loads all deliverables from the .csv file into the application
     * 
     * @since 20151003
     * @author Christopher Sigouin
     */
    private static void loadDeliverables() {
        
        String s = "";
        
        // Make sure file is created
        try {
            FileUtility.createFile(FILE_PATH);
        } catch (IOException ex) {
            Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error creating file. loadDeliverables()");
        } 
        
        BufferedReader myReader = FileUtility.getBufferedReader(FILE_PATH);
        
        // Reads a line
        s = FileUtility.readLine(myReader);
        // Used for adding weights
        int i = 0; 
        // Loop through each line and add it to the ArrayList
        while(s != null)
        {
            System.out.println(s);
            // Adds the deliverable object to the deliverables ArrayList with the data from the .csv file
            deliverables.add(new Deliverable(s.split(",")));
            // Reads a new line
            s = FileUtility.readLine(myReader);
            // Add the weights to the tally variable so that you can't add more to any existing in the file
            deliverableWeights += deliverables.get(i).getWeight();
            ++i;
        }
            
        System.out.println("Finished loading!");
        
        // Close the reader
        try {
            myReader.close();
        } catch (IOException ex) {
            Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /**
     * Writes the deliverables stored in the ArrayList to the file
     * 
     * @since 20151003
     * @author Christopher Sigouin
     */
    private static void storeDeliverables() {
        
        // Make sure file is created
        try {
            FileUtility.createFile(FILE_PATH);
        } catch (IOException ex) {
            Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error creating file. loadDeliverables()");
        }
        
        // Get the BufferedWriter to write to the file
        BufferedWriter myWriter = FileUtility.getBufferedWriter(FILE_PATH);
  
        // Load the data into the file
        for( int i = 0; i < deliverables.size(); ++i ) {
            try {
                myWriter.write(deliverables.get(i).getName() + "," + deliverables.get(i).getWeight() + System.lineSeparator());
                myWriter.flush();
            } catch (IOException iOException) {
                System.out.println("Error writing to the file!");
            }
        }
        
        // Close the writer
        try {
            myWriter.close();
        } catch (IOException iOException) {
            System.out.println("Error closing the BufferedWriter. storeDeliverables()");
        }
    }
 
    
    /**
     * Outputs all deliverables to the console that are loaded into the ArrayList
     * 
     * @since 20151003
     * @author Christopher Sigouin
     */
    private static void showDeliverables() {
        
        for(Deliverable list : deliverables) {
            System.out.println(list.toString());
        }
    }
    
    /**
     *  Allows a user to enter their grades per deliverable.  Once entered it will
     * calculate and show their average
     * 
     * TO FIND AVERAGE:
     *      EXAMPLE
     *          Deliverable Weights ( 30% Assignments, 30% Midterm, 40% Final )
     *          Grades ( 90% Assignments, 80% Midterm, 85% Final )
     *          Multiply each  .30 * .90 | .30 * .80 | .40 * .85 
     *          Add together   .27 + .24 + .34
     *          Average  .85 or 85%
     * 
     * @since 20151003
     * @author Christopher Sigouin
     */
    private static void calculateGrades() {
        double decimalGrade, deliverableWeight, totalGrades;
        decimalGrade = deliverableWeight = totalGrades = 0;
        
        // Loop through each deliverable and request the grade
        for( int i = 0; i < deliverables.size(); ++i ) {
            System.out.println(deliverables.get(i).toString());
            System.out.print("Please enter your grade for this deliverable( eg. 80 for 80% ): ");
            
            // Convert grade to decimal
            decimalGrade = Integer.parseInt(FileUtility.getInput().nextLine());
            decimalGrade = decimalGrade / 100;
            // Multiply grade by weight and tally
            deliverableWeight = deliverables.get(i).getWeight();
            totalGrades += decimalGrade * (deliverableWeight / 100);

        }
        System.out.print(System.lineSeparator());
        // One decimal place shows for output and add a percent symbol
        System.out.printf("%s%.1f%s%n%n", "AVERAGE: ", totalGrades * 100, " %");
        
    }
    
    
    
}
