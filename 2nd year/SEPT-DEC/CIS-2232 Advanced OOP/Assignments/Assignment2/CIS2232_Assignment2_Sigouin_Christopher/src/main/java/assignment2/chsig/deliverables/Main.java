package assignment2.chsig.deliverables;

/*
 * ========= CIS 2232 Advanced Object Oriented Programming PWC ==========
 * NAME: Christopher Sigouin
 * DATE: 03-10-2015
 * PURPOSE: Topic 2 Assignment 2
 */

import assignment2.chsig.deliverables.dao.DeliverableDAO;
import assignment2.chsig.deliverables.model.Deliverable;
import assignment2.chsig.deliverables.util.Utility;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * MAIN CLASS
 * 
 * @since 20151003
 * @author Christopher Sigouin
 */
public class Main {

    public final static int MAX_DELIVERABLE_WEIGHT = 100; // Max weight is 100%
     
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
        
        
        try {
            // Load deliverables
            deliverables = DeliverableDAO.loadDeliverables();
            // Tally deliverable weights
            countDeliverableWeights();
 
            // Menu
            do {

                System.out.print(MENU);
                choice = Utility.getInput().nextLine().toUpperCase().charAt(0);
                
                switch( choice )
                {
                    case 'L':
                        System.out.println(" === LOAD DELIVERABLES === " + System.lineSeparator());
                        System.out.println("Deliverables can total 100%" + System.lineSeparator());
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
        
        catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    }
    
    /** CHANGED
     * 
     * Method uses a switch to ensure that either an 'Insert' or 'Update' choice is properly handled.
     * 
     * INSERTING:
     *  Will continuously loop and request for input as long as the maximum weight limit has
     *  not been reached.  It will not allow a user to enter any further records if the weight limit
     *  is reached as well
     * 
     * UPDATING:
     *  Will allow a user to update any of the records.  If the weight entered happens to push the total 
     *  weight of all deliverables outside of the maximum weight limit, the application will inform the 
     *  user and will not update the database.
     * 
     * DOES NOT HANDLE:
     *  This method will not handle the following:
     *      - Checking to see if the record exists already in the database
     * 
     * @since 20151003
     * @author Christopher Sigouin
     * 
     */
    private static void addDeliverables() {
        
        Deliverable deliverable;
 
            System.out.println("Would you like to (I)nsert or (U)pdate a deliverable?: ");
            char choice = Utility.getInput().nextLine().toUpperCase().charAt(0);

            switch(choice) {

                // INSERTING
                case 'I':

                    if ( deliverableWeights >= MAX_DELIVERABLE_WEIGHT ) {
                        System.out.println("You cannot add any further deliverables at this time");
                    } else {

                        // Loop until the weight maximum has been reached
                    
                        do {

                            // Create a new deliverable object
                            deliverable = new Deliverable();

                            System.out.print("Enter a name for the deliverable: ");
                            deliverable.setName(Utility.getInput().nextLine());

                            // Check to be sure that the weight entered does not breach the max weight limit
                            System.out.print("Enter a weight for the deliverable( eg. 30 for 30% ): ");
                            int weight = Integer.parseInt(Utility.getInput().nextLine());
                            if( (deliverableWeights + weight) > MAX_DELIVERABLE_WEIGHT ) {

                                System.out.println("You cannot use this deliverable weight.  Exceeds max weight of " + MAX_DELIVERABLE_WEIGHT);

                            } else {

                                deliverable.setWeight(weight);
                                deliverables.add(deliverable);

                                // Tally the deliverable weights to end the loop
                                deliverableWeights += deliverable.getWeight();

                                // Update the database based on user choice
                                try {

                                    DeliverableDAO.update(deliverable, choice);

                                } catch (Exception ex) {
                                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }

                        } while ( deliverableWeights < MAX_DELIVERABLE_WEIGHT );    
                    }
                    break;

                // UPDATING
                case 'U':

                    // If there are no objects in the ArrayList, there is nothing to update
                    if( deliverables.isEmpty() ) {
                        System.out.println("No entries exist yet.  Please submit an entry");
                    } else {

                        // Create a new deliverable object to send for updating
                        deliverable = new Deliverable();

                        // Show the current list
                        showDeliverables();

                        System.out.print("Enter the name of the deliverable: ");
                        deliverable.setName(Utility.getInput().nextLine());

                        System.out.print("Enter the weight of the deliverable( eg. 30 for 30% ): ");
                        deliverable.setWeight(Integer.parseInt(Utility.getInput().nextLine()));

                        // Loop through the applications ArrayList to verify the weight entered
                        int countDeliverableWeights = 0;
                        for(Deliverable aDeliverable : deliverables) {
                            // Add up the weights of every deliverable except for the one chosen
                            if( !aDeliverable.getName().equalsIgnoreCase(deliverable.getName()) ) {
                                countDeliverableWeights += aDeliverable.getWeight();
                            }
                        }

                        if( (countDeliverableWeights + deliverable.getWeight()) > MAX_DELIVERABLE_WEIGHT ) {
                            System.out.println("The deliverable cannot be updated to that weight.  Exceeds max weight of " + MAX_DELIVERABLE_WEIGHT);
                        } else {

                            // Update the database based on user choice
                            try {

                                DeliverableDAO.update(deliverable, choice);
                                // User is updating, so reload the ArrayList and deliverableWeights
                                deliverables = DeliverableDAO.loadDeliverables();
                                countDeliverableWeights();
                            } catch (Exception ex) {
                                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                    break;
            } // END: switch
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
            decimalGrade = Integer.parseInt(Utility.getInput().nextLine());
            decimalGrade = decimalGrade / 100;
            // Multiply grade by weight and tally
            deliverableWeight = deliverables.get(i).getWeight();
            totalGrades += decimalGrade * (deliverableWeight / 100);

        }
        System.out.print(System.lineSeparator());
        // One decimal place shows for output and add a percent symbol
        System.out.printf("%s%.1f%s%n%n", "AVERAGE: ", totalGrades * 100, " %");
        
    }

    // SETTER
    public static void setDeliverableWeights(int deliverableWeights) {
        Main.deliverableWeights += deliverableWeights;
    }

    // GETTER
    public static int getDeliverableWeights() {
        return deliverableWeights;
    }
    
    /**
     * 
     * Completes a count of all weights in the applications ArrayList
     * 
     * @since 20151003
     * @return 
     */
    public static void countDeliverableWeights() {

        // Reset deliverableWeights before adding to it again
        deliverableWeights = 0;
        
        for(Deliverable aDeliverable : deliverables) {
            deliverableWeights += aDeliverable.getWeight();
        }

    }
    
    
}
