/*
 *     NAME: Christopher Sigouin
 *     DATE: 13-Nov-2014
 *     PURPOSE: Assignment 5
 *     DEPENDENCIES: PickerTest.java, Picker.java
 *     
 *     This code is copyright by Christopher Sigouin.  
 *     If you use it, be prepared to lose it! Mwahahahah ;)
 */


import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * Class to generate a GUI based menu.  Each option entered will be provided a
 * integer value starting at '1' so all choices are integer based only.
 * Once the option is picked by the user, the class
 * can determine what the return value is by the menuReturnValues. 
 * 
 * @author Christopher Sigouin
 * @since 1-Nov-2014
 */
public class Menu {

    /*
           ==========   ATTRIBUTES / FIELDS   ==========
    */
    private String menuHeading; // Menu Heading or Title
    private int numberOfOptions; // The number of options in the menu
    
    private String[] menuOptions; // The array that holds the options in String format
    private String menuOption; // To be used for a single option menu
    
    private String[] menuReturnValues; // The array that holds the return values of the options
    private int[] menuReturnValueInt;
    private boolean returnValueChoice; // " TRUE " means return values are Strings. " FALSE " means return values are Int
    

    /**
    * 
    * Creates a Menu object taking into account the following:
    *   Menu Heading - Single String
    *   Menu Options - Array of Strings ( Order is important for 'menuReturnValues' )
    *   Menu Return Values - Same as the menu options
    *
    * @param menuDisplayText
    * @author Christopher Sigouin
    * @since 1-Nov-2014
    */
    public Menu(String menuHeading, String[] menuOptions) {
        this.menuHeading = menuHeading; // Set the Menu Heading
        this.numberOfOptions = menuOptions.length; // Set the number of menu options
        setMenuOptions(menuOptions); // Set the options into the menu
        setMenuReturnValues(menuOptions);
        
    }
    
    /**
     * 
     *  Single option menu.
     * 
     * @param menuHeading
     * @param menuOption 
     */
    public Menu(String menuOption) {
        this.menuOption = menuOption;
    }
   
//    public Menu(String menuHeading, String[] menuOptions) {
//        this.menuHeading = menuHeading; // Set the Menu Heading
//        this.numberOfOptions = menuOptions.length; // Set the number of menu options
//        setMenuOptions(menuOptions); // Set the options into the menu
//        setMenuReturnValuesInt(menuOptions);
//        
//    }
    /*
            ==========   METHODS   ==========
    */

    /**
     * 
     * Puts together a menu based on the attribute values and returns a string for
     * the menu output to use.
     *   
     * @since 11012014
     * @author Christopher Sigouin
     */
    public String createMenu() {
        
        String menuText = menuHeading + System.lineSeparator();
        
        for(int i = 0; i < numberOfOptions; i++) {
            menuText += "(" + (i+1) + ") - " + menuOptions[i] + System.lineSeparator();
        }
        
        return menuText;
    }
    
    /**
     * 
     * Generates a GUI Menu based on the attribute values provided in the object
     * created
     *  
     * @return 
     * @since 11012014
     * @author Christopher Sigouin
     */
    public String runConsoleMenu() {
        
        Scanner input = new Scanner(System.in);
        System.out.print(createMenu() + System.lineSeparator() + "Your choice?: ");
        int choice = input.nextInt();
        
        return menuReturnValues[(choice-1)];
               
    }
    
    public String runGuiMenu() {
     
        int choice = Integer.parseInt(JOptionPane.showInputDialog(createMenu()));
 
        return menuReturnValues[(choice-1)];
     
    }
    
    /**
     * 
     *  Method is currently only usable if the following constructor is used to 
     *  develop a menu.
     * 
     *  Menu(String menuOption)
     * 
     * @return 
     */
    public String runSimpleGuiMenu() {
        String choice = JOptionPane.showInputDialog(menuOption);
        
        return choice;
    }
        
    public String getMenuHeading() {
        return menuHeading;
    }

    public void setMenuHeading(String menuHeading) {
        this.menuHeading = menuHeading;
    }

    public int getNumberOfOptions() {
        return numberOfOptions;
    }

    public void setNumberOfOptions(int numberOfOptions) {
        this.numberOfOptions = numberOfOptions;
    }

    public String[] getMenuOptions() {
        return menuOptions;
    }

    public void setMenuOptions(String[] menuOptions) {
        this.menuOptions = menuOptions;
    }

    public String[] getMenuReturnValues() {
        return menuReturnValues;
    }

    public void setMenuReturnValues(String[] menuReturnValues) {
   
            this.menuReturnValues = menuReturnValues;
    
    }
    
}
