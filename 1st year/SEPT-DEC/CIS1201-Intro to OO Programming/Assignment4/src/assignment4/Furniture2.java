/*
 *     NAME: Christopher Sigouin
 *     DATE: 30-Oct-2014
 *     PURPOSE: Assignment 4
 *     DEPENDENCIES: Order.java
 *     
 *     This code is copyright by Christopher Sigouin.  
 *     If you use it, be prepared to lose it! Mwahahahah ;)
 */

package assignment4;

import javax.swing.JOptionPane;


public class Furniture2 {
    
    // Main Menu Text
    public final static String MENU = "Please choose an option" + System.lineSeparator() +
                                      "(1) Pine Table " + System.lineSeparator() +
                                      "(2) Oak Table " + System.lineSeparator() +
                                      "(3) Mahogany Table";
     
    // Sub Menu Text
    public final static String SUB_MENU = "What size of table?" + System.lineSeparator() +
                                          "(1) Large Table " + System.lineSeparator() +
                                          "(2) Small Table ";
    
    /**
     * 
     * Main runs only one method.  The 'runOrderMenu' method
     * 
     * @param args the command line arguments
     * @author Christopher Sigouin
     * @since 30-Oct-2014
     */
    public static void main(String[] args) {
    
        runOrderMenu();
        
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
    public static void runOrderMenu() {
        
       Order aNewOrder;
       
       switch(Integer.parseInt(JOptionPane.showInputDialog(null, MENU))) {
           
           case 1:
               aNewOrder = new Order("Pine");
               subOrderMenu(aNewOrder);
               aNewOrder.setPriceNewOrder();
               showOrder(aNewOrder);
               break;
           case 2:
               aNewOrder = new Order("Oak");
               subOrderMenu(aNewOrder);
               aNewOrder.setPriceNewOrder();
               showOrder(aNewOrder);
               break;
           case 3:
               aNewOrder = new Order("Mahogany");
               subOrderMenu(aNewOrder);
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
     * A subMenu used by 'runOrderMethod'. Takes the order method initially created
     * by the 'runOrderMethod' and validates it from the users choice. 
     * 
     * @param aNewOrder 
     * @since 11012014
     * @author Christopher Sigouin
     */
    public static void subOrderMenu(Order aNewOrder) {
        
        switch(Integer.parseInt(JOptionPane.showInputDialog(null, SUB_MENU))) {
            
            case 1:
                aNewOrder.setSize("large");
                break;
            case 2:
                aNewOrder.setSize("small"); 
                break;
            default:
                aNewOrder.setSize("Invalid Size");
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
