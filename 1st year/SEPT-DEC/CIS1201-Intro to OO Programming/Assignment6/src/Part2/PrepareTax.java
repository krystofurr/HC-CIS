/*
 * NAME: Christopher Sigouin
 * DATE: Dec 3, 2014
 * PURPOSE: Assignment 6 - Part 2
 * DEPENDENCIES: TaxReturn.java, Menu.java
 * 
 * This code is copyright by Christopher Sigouin.
 * If you use it, be prepared to lose it! Mwahahahah ;)
 */

package Part2;

import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * PrepareTax class tests the TaxReturn class.  Also holds all menu functionality
 * allowing for user input.
 * 
 * @since 12042014
 * @author Christopher Sigouin
 */
public class PrepareTax {

    public final static int VALID_SIN_CHECK = 11; // Number of items to check in the value
    public final static int VALID_ZIPCODE_CHECK = 6; // Number of items to check in the value
    public static String[] menuOptions = { "Sin", "Annual Income", "Last Name", "First Name", "Street Address", "City", "State", "Zip Code", "Marital Status"};
    public static Menu mainMenu;
    
    private static StringBuilder taxData = new StringBuilder("#Sin,#Annual Income,#Last Name,#First Name,#Street Address,#City,#State,#Zip Code,#Marital Status");
        
    public static void main(String[] args) {
        
        mainMenu = new Menu(1,"TAX RETURN MENU:",menuOptions,"string");
        String menuChoice;
        
        do {
            
            // From the main menu, the option is returned as a string to menuChoice
            menuChoice = mainMenu.runMenu();
            getTaxReturnData(menuChoice);
 
        } while( !isAllDataEntered() );
        
        // Create a tokenizer to break up the data from the String
        StringTokenizer taxDataToken = new StringTokenizer(taxData.toString(), ",");
        // Create the TaxReturn Object after all validation is complete
        TaxReturn aNewReturn = new TaxReturn(taxDataToken.nextToken(),Double.parseDouble(taxDataToken.nextToken()), 
                                             taxDataToken.nextToken(),taxDataToken.nextToken(),taxDataToken.nextToken(),taxDataToken.nextToken(), 
                                             taxDataToken.nextToken(),taxDataToken.nextToken(),taxDataToken.nextToken());
       
        // Display the TaxReturn object
        JOptionPane.showMessageDialog(null, aNewReturn);
        
        
 
    }
    
    /**
     * 
     * Takes the choice entered by the user from the menu.  Uses it to validate input and enter
     * data into a StringBuilder object.  
     * Once data is entered into the StringBuilder object, the method will update the Menu display and
     * show *COMPLETED*.  Will also prevent further updates once the value is entered.
     * 
     * @param choice 
     * @since 12042014
     * @author Christopher Sigouin
     */
    public static void getTaxReturnData(String choice) {
        
        String temp, valueChoice;
        
            // If there is a slot to enter the data AND the data is valid ( checking for Marital Status, Zip Code...etc
            if( taxData.toString().contains("#"+choice) ){
                // Get the value for the choice from user
                valueChoice = JOptionPane.showInputDialog("Enter value for (" + choice + "): ");
                // If the data entered is valid...
                if( isDataValid(choice, valueChoice) ) {
                    // Replace the value from the user with the right spot in the string
                    temp = taxData.toString().replace("#"+choice, valueChoice);
                    // Delete the string
                    taxData.delete(0, taxData.length());
                    // Recreate it with the change
                    taxData.append(temp);

                    // Change the menu to display completed for each section
                    for( int i = 0; i < menuOptions.length; ++i ) {
                        if( menuOptions[i].equals(choice) )
                            menuOptions[i] = menuOptions[i].replace(choice, "*COMPLETED* " + choice);
                    }
                } // END: if( isDataValid(valueChoice) ) { .....

            } else {

                    JOptionPane.showMessageDialog(null, "You have already entered for that option. Please choose again");
            }

            //System.out.println(taxData);
            
    } // END: getTaxReturnData 
    
    
    
    /**
     * 
     * Verifies the validity on the string argument 'valueChoice' by different methods
     * for four of the attributes required ( SIN, ANNUAL INCOME, ZIP CODE & MARITAL STATUS )
     * Based on 'menuChoice' valueChoice is checked to ensure these attributes meet the criteria
     * required.
     * 
     * @param menuChoice
     * @param valueChoice
     * @return 
     * @author Christopher Sigouin
     * @since 12032014
     */
    public static boolean isDataValid(String menuChoice, String valueChoice) {
        
        boolean valid;
        
        // ****************** SIN ************************
        if( menuChoice.equalsIgnoreCase("sin")) {
//            The Social Security number is not in the correct format, with digits and dashes
//            in the appropriate positions; for example, 999-99-9999.
            int validCheck = 0;
            for( int i = 0; i < valueChoice.length(); ++i ){
                
                // Check all digits that are not the dash position
                if( i != 3 && i != 6 ){
                    if( Character.isDigit(valueChoice.charAt(i)) ){
                        //System.out.println("Digit checked. It's good");
                        ++validCheck;
                     }else{
                        //System.out.println("digit not good");
                        --validCheck;
                    }
                }else{
                    // Check the dash positions
                    if( valueChoice.charAt(i) == '-'){
                        //System.out.println("There is a dash in the right spot");
                        ++validCheck;
                     }else{
                        //System.out.println("dash not good");
                        --validCheck;
                    }
     
                } // END:   if( i != 3 && i != 6 ){ .....     
          
            } // END:   for( int i = 0; i < valueChoice.length(); ++i ){ .....
            
            if( validCheck == VALID_SIN_CHECK )
                valid = true;
            else {
                JOptionPane.showMessageDialog(null, menuChoice + " is not valid. Please re-enter");
                valid = false;
            }

        // ****************** MARITAL STATUS ************************    
        } else if( menuChoice.equalsIgnoreCase("marital status")) {
            
//            The marital status does not begin with one of the following: “S”, “s”, “M”, or “m”.
            
            //System.out.println("statuschoice " + valueChoice.charAt(0));
            valueChoice = valueChoice.toLowerCase();
            if( valueChoice.charAt(0) != 'm' && valueChoice.charAt(0) != 's' ){
                //System.out.println("marital status is false");
                valid = false;
            
            } else {
                //System.out.println("marital status is true.");
                valid = true;
                
            }
            
        // ****************** ANNUAL INCOME ************************
        } else if( menuChoice.equalsIgnoreCase("annual Income")) {
            
            //            The annual income is negative.
            if( Integer.parseInt(valueChoice) < 0 ){
                JOptionPane.showMessageDialog(null, menuChoice + " is not valid. Please re-enter");
                valid = false;
            } else {
                valid = true;
            }
            
        // ****************** ZIP CODE ************************  
        } else if( menuChoice.equalsIgnoreCase("zip code") ){
            int validCheck = 0;
//            The zip code is not five digits.
            // If the user entry is equal to 5 characters...
            if( valueChoice.length() == 5){
                //System.out.println("zip code passed 5 character check");
                // Loop through the choice to check and ensure each one is a digit
                for( int i = 0; i < valueChoice.length(); ++i ){
                    if( Character.isDigit(valueChoice.charAt(i)) ){
                        ++validCheck;
                    } else
                        --validCheck;
                }
                // Is false if it didn't pass the digit loop check
                ++validCheck;
            } else {
                        // False if it didn't pass the 5 character check
                        --validCheck;
            }
            
            // If the counter equals all of the checked items...
            if( validCheck == VALID_ZIPCODE_CHECK )
                valid = true;
            else {
                JOptionPane.showMessageDialog(null, menuChoice + " is not valid. Please re-enter");
                valid = false;
            }
         
        // ****************** ANYTHING ELSE GOES THROUGH ************************
        } else {
            // Anything other than the above can go through and be entered as tax data
            valid = true;
        }

      return valid;
    }
    
    /**
     * 
     * Will verify all positions in the StringBuilder object 'taxData'.  If all sections
     * are found to be verified and entered it will return a boolean flag to terminate the
     * loop that repeats the main menu and allow the TaxReturn object to be created.
     * 
     * @author Christopher Sigouin
     * @since 12032014 
     */
    public static boolean isAllDataEntered() {
        
      boolean valid; 
      
        if( taxData.toString().contains("#") ){
            //System.out.println("data not valid. keep loop going");
            valid = false;
        }else{
            //System.out.println("data valid. stop loop");
            valid = true;
        }
        
      return valid;
    }
    
}
