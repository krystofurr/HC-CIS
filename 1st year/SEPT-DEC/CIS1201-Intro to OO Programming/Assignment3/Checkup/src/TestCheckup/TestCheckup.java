/*
 * NAME: Christopher Sigouin
 * DATE: 10-01-2014
 * PURPOSE: Assignment 3 ( Due Oct 13 / 2014 )
 * DEPENDENCIES: Checkup.java
 */

package TestCheckup;

import javax.swing.JOptionPane;



public class TestCheckup {
    
    public static final String NEW_LINE = "\n";
    
    /**
     * 
     * A Checkup object is passed into the method. Using the set methods listed
     * in the class, it will ask the user for each attribute / value in the Checkup 
     * class and set the value accordingly parsing the value if necessary
     * 
     * 
     * @return
     * @author: Christopher Sigouin
     * @since: 20141001
     */
    public static Checkup getData() {
        
        // Create a new Checkup object and create an instance of it to use
        Checkup currentCheckup = new Checkup();
        // Get data for each field in the Checkup object and return it
        currentCheckup.setPatientNumber(JOptionPane.showInputDialog(null, "Enter Patient #: "));
        currentCheckup.setSystolic(JOptionPane.showInputDialog(null, "Enter Systolic value: "));
        currentCheckup.setDiastolic(JOptionPane.showInputDialog(null, "Enter Diastolic value: "));
        currentCheckup.setLdl(JOptionPane.showInputDialog(null, "Enter LDL value: "));
        currentCheckup.setHdl(JOptionPane.showInputDialog(null, "Enter HDL value: "));
        return currentCheckup;
    }
    
    /**
     * 
     * Displays the values of the Checkup object that is passed as an argument
     * 
     * @param showCheckup
     * @author: Christopher Sigouin
     * @since: 20141001
     */
    public static void showValues(Checkup showCheckup) {
        
        String output = "Blood Pressure: " + showCheckup.getSystolic() + "/" + showCheckup.getDiastolic() + NEW_LINE + 
                        "Cholesterol: " + showCheckup.getLdl() + " and " + showCheckup.getHdl() + NEW_LINE +
                        "Cholesterol Ratio: " + showCheckup.computeRatio() + NEW_LINE +
                        NEW_LINE +
                        showCheckup.explainRatio();

        JOptionPane.showMessageDialog(null, output );
    }
    
    public static void main(String[] args) {
        
        // Create two objects of Checkup class
        Checkup aCheckup;
        Checkup aSecondCheckup;

        // Call getData() and assign to aCheckup.
        aCheckup = getData();
        // Show values for aCheckup
        showValues(aCheckup);
        // Call getData() and assign to aSecdondCheckup
        aSecondCheckup = getData();
        // Show values for aSecondCheckup
        showValues(aSecondCheckup);

        
    }

}
