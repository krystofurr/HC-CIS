/*
 *     NAME: Christopher Sigouin
 *     DATE: 13-Nov-2014
 *     PURPOSE: Assignment 5
 *     DEPENDENCIES: Picker.java, Menu.java
 *     
 *     This code is copyright by Christopher Sigouin.  
 *     If you use it, be prepared to lose it! Mwahahahah ;)
 */

/**
 * 
 * Assignment5 class holds 'main' to run the application
 * 
 * @author krystofurr
 */
public class PickerTest {

    /**
     * 
     * The main method
     * 
     * @param args 
     */
    public static void main(String[] args) {
       
        startPickerProgram(); // Starts the Picker Program
        
    }
    
    /**
     * 
     * Runs the Picker Program.  Holds the program in a loop until the user enters
     * an 'x' or 'X' into the picker name menu.  Menu will always run at least once.
     * 
     */
    public static void startPickerProgram() {
        Picker aPicker;
        
        do {
    
            aPicker = new Picker();

        } while (!aPicker.getPickerName().equalsIgnoreCase(Picker.MENU_QUIT_VALUE));
    }
    
}



