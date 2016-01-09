/*
 * NAME: Christopher Sigouin
 * DATE: Dec 9, 2014
 * PURPOSE: Assignment 7
 * DEPENDENCIES: Vehicle.java, Menu.java
 * 
 * This code is copyright by Christopher Sigouin.
 * If you use it, be prepared to lose it! Mwahahahah ;)
 */

package assignment7;

import javax.swing.JOptionPane;

/**
 *
 *      TestVehicle class tests the Vehicle class
 * 
 * @since 12092014
 * @author Christopher Sigouin
 */
public class TestVehicle {

    public final static int MENU_OPTION_VEHICLE_PRICE = 1;
    public final static int MENU_OPTION_MILAGE = 2;
    public final static int MENU_OPTION_TRANSMISSION = 3;
    public final static int MENU_OPTION_SUNROOF = 4;
    private static String[] menuOptions = { "Vehicle Price", "Milage on Vehicle", "Transmission Options", "Sunroof Options"  };
    private static Menu aMenu;
    private static Vehicle aVehicle;
    private static int completedOptions;
    
    public static void main(String[] args) {
        
        aVehicle = new Vehicle(); // Create an instance of a Vehicle
        aMenu = new Menu(1,"VEHICLE MENU: ", menuOptions, "int");
        do {
        
            processMenuOption(Integer.parseInt(aMenu.runMenu()));
            
        } while ( isAnotherVehicleNeeded() );
    }
    
    
    /**
     * 
     *  Processes all menu inputs from the user.  Also keeps track of all entries through the use of a counter.  If 
     *  the counter is equal to the number of options, then it will show the instance with the assigned values. 
     * 
     * @author Christopher Sigouin
     * @since 12092014
     * @param menuChoice 
     */
    public static void processMenuOption(int menuChoice) {
        String tempChoice; // To help convert choice to 'char' primitive value
        int menuOptionItemIndex = menuChoice - 1; // Represents the menuOption index value in the array
        
        
        switch(menuChoice) {
            case MENU_OPTION_VEHICLE_PRICE: 
                if( !menuOptions[menuOptionItemIndex].contains("*") ) {
                    aVehicle.setOrigPrice(Double.parseDouble(JOptionPane.showInputDialog("Enter Vehicle Value: ")));
                    menuOptions[menuOptionItemIndex] += " * ";
                    ++completedOptions;
                } else {
                    JOptionPane.showMessageDialog(null, "You've already entered a vehicle price");
                }
                break;
            case MENU_OPTION_MILAGE:
                if( !menuOptions[menuOptionItemIndex].contains("*") ) {
                    aVehicle.setMileage(Integer.parseInt(JOptionPane.showInputDialog("Enter Milage: ")));
                    menuOptions[menuOptionItemIndex] += " * ";
                    ++completedOptions;
                } else {
                    JOptionPane.showMessageDialog(null, "You've already entered mileage");
                }
                break;
            case MENU_OPTION_TRANSMISSION:
                if( !menuOptions[menuOptionItemIndex].contains("*") ) {
                    tempChoice = JOptionPane.showInputDialog("Enter Transmission Type ( a-auto / m-manual ): ");
                    aVehicle.setTransmission(tempChoice.toLowerCase().charAt(0));
                    menuOptions[menuOptionItemIndex] += " * ";
                    ++completedOptions;
                } else {
                    JOptionPane.showMessageDialog(null, "You've already entered the transmission type");
                }
                break;
            case MENU_OPTION_SUNROOF:
                if( !menuOptions[menuOptionItemIndex].contains("*") ) {
                    tempChoice = JOptionPane.showInputDialog("Do you want a Sunroof? (y/n): ");
                    aVehicle.setSunroof(tempChoice.toLowerCase().charAt(0));
                    menuOptions[menuOptionItemIndex] += " * ";
                    ++completedOptions;
                } else {
                    JOptionPane.showMessageDialog(null, "You've already entered the sunroof option");
                }
                break;
        } // END: switch
        
        showVehiclePricing();
        
    } // END: processMenuOption()
    
    /**
     * 
     * Will call the toString method from the vehicle class inside a JOptionPane dialog box
     * 
     * @author Christopher Sigouin
     * @since 12092014
     */
    public static void showVehiclePricing() {
        if( completedOptions == menuOptions.length )
            JOptionPane.showMessageDialog(null, aVehicle);
        
    }
    
    /**
     * 
     *   Keeps the loop going if user wishes to enter a new set of values.  If user chooses 'no' the loop quits
     * 
     * @since 12092014
     * @author Christopher Sigouin
     * @return 
     */
    public static boolean isAnotherVehicleNeeded() {
        boolean valid = true;
        
        if( completedOptions == menuOptions.length ) {
            String choice = JOptionPane.showInputDialog("Do you want to enter in information for another vehicle? (y/n): ");
            valid = choice.charAt(0) == 'y'; // Set the boolean value to return for the loop condition
            resetMenuOptions(); // Reset the menuOptions
            aVehicle = new Vehicle(); // Create a new instance of a vehicle
        }
        return valid;
    }
    
    /**
     * 
     * Resets 'menuOptions' array to the initial values and the counter 'completedOptions' to 0
     * 
     * @since 12092014
     * @author Christopher Sigouin
     * 
     */
    private static void resetMenuOptions() {
        for( int i = 0; i < menuOptions.length; ++i ) {
            menuOptions[i] = menuOptions[i].replace("*",""); // Remove all asterisks to indicate completed items
            completedOptions = 0; // Nothing is completed.  Reset the counter
        }
    }
    
}
