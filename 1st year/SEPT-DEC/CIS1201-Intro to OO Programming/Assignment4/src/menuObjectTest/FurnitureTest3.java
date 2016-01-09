/*
 *     NAME: Christopher Sigouin
 *     DATE: 30-Oct-2014
 *     PURPOSE: Assignment 4
 *     DEPENDENCIES: Order2.java 
 *     
 *     This code is copyright by Christopher Sigouin.  
 *     If you use it, be prepared to lose it! Mwahahahah ;)
 */

package menuObjectTest;

import javax.swing.JOptionPane;


public class FurnitureTest3 {

    public final static String MENU_HEADING = "Please choose an option";
    public final static String[] MENU_OPTIONS = { "Pine Table ", "Oak Table ","Mahogany Table" };
    public final static String[] MENU_RETURN_VALUES = { "Pine", "Oak", "Mahogany" };

    /**
     * @param args the command line arguments
     * @author Christopher Sigouin
     * @since 30-Oct-2014
     */
    public static void main(String[] args) {
    
        // Create a new Menu and provide the menu arguments
        Menu aNewMenu = new Menu(MENU_HEADING, MENU_OPTIONS, MENU_RETURN_VALUES);
        // Create a new order and use the return value of the menu as the argument
        Order2 aNewOrder = new Order2(aNewMenu.runMenu());
        // Set the price on the new order
        aNewOrder.setPriceNewOrder();
        // Show the order
        showOrder(aNewOrder);

    }

    /**
     * 
     * Shows the toString method of an Order type object by GUI
     * 
     * @param aNewOrder
     * @since 11012014
     * @author Christopher Sigouin
     */
    public static void showOrder(Order2 aNewOrder) {
        JOptionPane.showMessageDialog(null, aNewOrder);
    }

}
