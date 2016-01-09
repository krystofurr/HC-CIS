/*
 *     NAME: Christopher Sigouin
 *     DATE: 13-Nov-2014
 *     PURPOSE: Assignment 5
 *     DEPENDENCIES: PickerTest.java, Menu.java
 *     
 *     This code is copyright by Christopher Sigouin.  
 *     If you use it, be prepared to lose it! Mwahahahah ;)
 */

import javax.swing.JOptionPane;

/**
 *
 * Picker class.  An object of a 'Picker' or person who picks 
 * blueberries.  Holds various attributes for that person and some
 * that are universal for all pickers.
 * 
 */
public class Picker {

    public final static String BUSINESS_NAME = "Ham's Blueberry Patch";
    public final static String MENU_PICKER_NAME = "What is your name?( Enter 'X' to Exit ): ";
    public final static String MENU_NUMBER_OF_BOXES = "How many boxes did you pick?( 1 - 50 ): ";
    public final static String MENU_QUIT_VALUE = "x"; // Menu or Program quit value. Can be Upper or Lower
    public final static int MAX_NUMBER_OF_BOXES = 50; // Max number of boxes able to be entered
    public final static int MIN_NUMBER_OF_BOXES = 1; // Min number of boxes able to be entered

    private String pickerName; // The pickers name
    private int numberOfBoxes; // The number of boxes picked
    
    // Should only be one instance of these for all objects created
    private static int totalNumberOfBoxes; // Total number of all boxes picked
    private static int totalNumberOfPickers; // Total number of all pickers entered
    private static int largestNumberOfBoxes; // Holds the value of the largest number of boxes picked
    private static float averageNumberOfBoxes; // Holds the average value of boxes ( Total Boxes / Pickers )
    private static String mostProductivePicker; // Holds the name of the picker with the most boxes
    
    // Should only be one instance of the menu for all objects created
    static Menu aPickerNameMenu = new Menu(MENU_PICKER_NAME); // Input menu for the picker name
    static Menu aBoxNumberMenu = new Menu(MENU_NUMBER_OF_BOXES); // Input meny for the number of boxes
    
    /**
     * 
     * Picker Constructor.  When an object is instantiated it first runs
     * the menu to get the Picker's name.  Utility method 'checkPickerName'
     * checks to see if the user entered an 'x' to quit the program. 
     * 
     * If... 'x' is entered it will skip the next two methods
     * Else...the menu is provided to get the number of boxes that the user
     * picked. Utility method 'checkNumberOfBoxes' checks the value of the amount
     * entered and determines if the value is valid or not. Next 'processNewPicker'
     * is called and takes both attributes of 'pickerName' and 'numberOfBoxes'.
     *
     */
    public Picker() {
        pickerName = checkPickerName(aPickerNameMenu.runSimpleGuiMenu());
        
        // If the user didn't enter an 'x' to quit the program do the following...
        if(!pickerName.equalsIgnoreCase(MENU_QUIT_VALUE)) {
            checkNumberOfBoxes(Integer.parseInt(aBoxNumberMenu.runSimpleGuiMenu()));
            processNewPicker(pickerName, numberOfBoxes); // this is addNewPicker()
        }
    }
    
    @Override
    public String toString() {
        return "";
        
    }
    
    /**
     * 
     * Utility method is used to display the values of the object formatted in this manner
     * 
     */
    private void displayPickerReport() {
        String output = BUSINESS_NAME + System.lineSeparator() +
                        "Daily Summary" + System.lineSeparator() + System.lineSeparator() +
                        "Number of Pickers: " + totalNumberOfPickers + System.lineSeparator() +
                        "Total Boxes: " + totalNumberOfBoxes + System.lineSeparator() +
                        "Most productive picker: " + mostProductivePicker + System.lineSeparator() +
                        "Average boxes picked: " + averageNumberOfBoxes;
        
        JOptionPane.showMessageDialog(null, output);
    }
    
    /**
     * 
     * Utility method.  This method checks the value returned by the menu object and
     * checks to see if the user entered 'x' to quit the program.  If the user entered 
     * anything but an 'x' it is assigned to the attribute 'pickerName'
     * 
     * @param pickerName
     * @return 
     */
    private String checkPickerName(String pickerName) {
        
        if(pickerName.equalsIgnoreCase(MENU_QUIT_VALUE)){
            this.pickerName = MENU_QUIT_VALUE;
            displayPickerReport();
            return pickerName;
        } else {
            this.pickerName = pickerName;
            return pickerName;
        }
        
    }
    /**
     * 
     * Utility method. Checks the value in the attribute ' numberOfBoxes ' to ensure the value is 
     * between 1 and 50.  If not valid it will call itself and run again.  If it is valid it will 
     * assign the number of boxes to the attribute ' numberOfBoxes ' for that picker entry
     * 
     * @param numberOfBoxes
     *  
     */
    private void checkNumberOfBoxes(int numberOfBoxes) {

        if( numberOfBoxes < MIN_NUMBER_OF_BOXES || numberOfBoxes > MAX_NUMBER_OF_BOXES ) {
            checkNumberOfBoxes(Integer.parseInt(aBoxNumberMenu.runSimpleGuiMenu()));
        } else {
            this.numberOfBoxes = numberOfBoxes;
        }
    
    }
    
    /**
     * 
     * Method calculates values and stores them in the appropriate attributes.
     * 
     * The program will track number of pickers for the day.
     * The program will track the total number of boxes picked for the day.
     * The program will track the picker that picks the most boxes for the day.
     * The program will provide the average number of boxes for the day.
     * 
     * @param pickerName
     * @param numberOfBoxes 
     */
    private void processNewPicker(String pickerName, int numberOfBoxes) {

            // The program will track number of pickers for the day.
            ++totalNumberOfPickers;

            // The program will track the total number of boxes picked for the day.

            totalNumberOfBoxes += numberOfBoxes;
            /*
                The program will track the picker that picks the most boxes for the day
                Also adds an additional picker name if there is a tie
            */
            if( largestNumberOfBoxes < numberOfBoxes ) {
                largestNumberOfBoxes = numberOfBoxes;
                mostProductivePicker = pickerName;
            } else if ( largestNumberOfBoxes == numberOfBoxes ) {
                mostProductivePicker += " and " + pickerName;
            } else
                // Nothing else to do
                
            // The program will provide the average number of boxes for the day.

            averageNumberOfBoxes = totalNumberOfBoxes / totalNumberOfPickers;
      
    }

    /**
     * 
     * Accessor Method. Gets the attribute value of 'pickerName'.
     * 
     * @return 
     */
    public String getPickerName() {
        return pickerName;
    }
    
    
}
