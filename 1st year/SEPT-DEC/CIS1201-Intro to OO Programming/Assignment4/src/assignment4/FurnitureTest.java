/*
 *     NAME: Christopher Sigouin
 *     DATE: 1-Nov-2014
 *     PURPOSE: Assignment 4
 *     DEPENDENCIES: Order.java
 *     
 *     This code is copyright by Christopher Sigouin.  
 *     If you use it, be prepared to lose it! Mwahahahah ;)
 */

package assignment4;

import javax.swing.JOptionPane;

/**
 * 
 * Holds constant for text of the main menu.  Also has methods to run the main 
 * menu and show an object of 'Order' datatype
 * 
 * @since 11012014
 * @author krystofurr
 */
public class FurnitureTest {
    
    // Main Menu Text
    public final static String MENU = "Please choose an option" + System.lineSeparator() +
                                      "(1) Pine Table " + System.lineSeparator() +
                                      "(2) Oak Table " + System.lineSeparator() +
                                      "(3) Mahogany Table";
    
    /**
     * 
     * Main Method.  Runs the method 'runMenu'
     * 
     * @param args the command line arguments
     * @author Christopher Sigouin
     * @since 30-Oct-2014
     */
    public static void main(String[] args) {
    
        runMenu();
        
    }

    /**
     * 
     * This method displays the initial menu and allows the user to enter a choice.
     * Based on the choice a switch/case takes the value and determines which option
     * to choose.  If there is an invalid option the default will be used.
     * 
     * @since 11012014
     * @author Christopher Sigouin
     */
    public static void runMenu() {
        
       Order aNewOrder;
       
       switch(Integer.parseInt(JOptionPane.showInputDialog(null, MENU))) {
           
           case 1:
               aNewOrder = new Order("Pine");
               aNewOrder.setPriceNewOrder();
               showOrder(aNewOrder);
               break;
           case 2:
               aNewOrder = new Order("Oak");
               aNewOrder.setPriceNewOrder();
               showOrder(aNewOrder);
               break;
           case 3:
               aNewOrder = new Order("Mahogany");
               aNewOrder.setPriceNewOrder();
               showOrder(aNewOrder);
               break;
           default:
               aNewOrder = new Order("Invalid Wood Type Chosen");
               showOrder(aNewOrder);
               break;
       }
    }
     
    /**
     * 
     * Shows the toString method of an Order type object by GUI
     * 
     * @param aNewOrder
     * @since 11012014
     * @author Christopher Sigouin
     */
    public static void showOrder(Order aNewOrder) {
        JOptionPane.showMessageDialog(null, aNewOrder);
    }

}
