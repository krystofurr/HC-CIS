
import static java.lang.Float.parseFloat;
import javax.swing.JOptionPane;

/*
    Filename   Dollars.java
    Written by Christopher Sigouin
    Written on 09/15/2014

*/

/**
 *
 * @author krys
 */

public class Dollars {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
        // INPUT BOX REQUESTS INPUT. WILL EXCEPT FLOAT DATATYPE VALUE
        float amount = parseFloat(JOptionPane.showInputDialog(null, "Enter a dollar amount to convert (eg. 56.78)"));
        
        // TAKE FLOAT VALUE AND CAST TO (INT) AND SAVE TO INT VARIABLE TYPE
        int twenties = (int)(amount/20);
        int tens = (int)(amount/10);
        int fives = (int)amount/5;
        int ones = (int)amount/1;

        // STRING OUTPUT WITH THE VARIABLES FOR THE MESSAGEBOX
        String output = " You entered " + amount + " so there are " + "\n" +
                        "--- " + twenties + " ---    20s " + "\n" +
                        "--- " + tens + " ---    10s " + "\n" +
                        "--- " + fives + " ---    5s " + "\n" +
                        "--- " + ones + " ---    1s " + "\n";
                        
        // DISPLAY THE OUTPUT IN THE MESSAGEBOX
        JOptionPane.showMessageDialog(null, output );
        
    }
    
}


