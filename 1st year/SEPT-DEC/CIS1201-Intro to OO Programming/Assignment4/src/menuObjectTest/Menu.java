/*
 *     NAME: Christopher Sigouin
 *     DATE: 1-Nov-2014
 *     PURPOSE: EXTRA PRACTICE. Not part of Assignment 4.  I just wanted to make
                                the menu an object as well.
 *     DEPENDENCIES: FurnitureTest3.java, Order.java
 *     
 *     This code is copyright by Christopher Sigouin.  
 *     If you use it, be prepared to lose it! Mwahahahah ;)
 */

package menuObjectTest;

import assignment4.*;
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
    private String[] menuReturnValues; // The array that holds the return values of the options
    

    /**
    * 
    * Creates a Menu object taking into account the following:
    *   Menu Heading - Single String
    *   Menu Options - Array of Strings ( Order is important for 'menuReturnValues' )
    *   Menu Return Values - Array of Strings ( Order is important for 'menuReturnValues' )
    *
    * @param menuDisplayText
    * @author Christopher Sigouin
    * @since 1-Nov-2014
    */
    public Menu(String menuHeading, String[] menuOptions, String[] menuReturnValues) {
        this.menuHeading = menuHeading;
        this.numberOfOptions = menuOptions.length;
        setMenuOptions(menuOptions);
        setMenuReturnValues(menuReturnValues);
        
    }

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
            menuText += "(" + (i+1) + ")-" + menuOptions[i] + System.lineSeparator();
        }
        
        return menuText;
    }
    
    /**
     * 
     * Generates a GUI Menu based on the attribute values provided in the object
     * created
     *  
     * @since 11012014
     * @author Christopher Sigouin
     */
    public String runMenu() {
     
        int choice = Integer.parseInt(JOptionPane.showInputDialog(createMenu()));
 
        return menuReturnValues[(choice-1)];
     
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
