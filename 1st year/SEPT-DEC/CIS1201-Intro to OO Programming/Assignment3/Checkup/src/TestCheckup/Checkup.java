/*
 * NAME: Christopher Sigouin
 * DATE: 10-01-2014
 * PURPOSE: Assignment 3 ( Due Oct 13 / 2014 )
 * DEPENDENCIES: TestCheckup.java
 */

package TestCheckup;

import static java.lang.Integer.parseInt;


public class Checkup {

    /*
    *
    *   ATTRIBUTES
    *
    */
    
    
    int patientNumber; // Patient Number
    int systolic, diastolic; // Blood Pressure values ( NOT FRACTIONAL VALUES )
    int ldl, hdl; // Cholesterol values ( NOT FRACTIONAL VALUES )
    
    /**
     * 
     * Calculates the result of attribute ldl and divides by hdl.  Returns the
     * casted value of " float " to keep the decimal value and returns it
     * 
     * @return
     * @author: Christopher Sigouin
     * @since: 20141001
     */
    public float computeRatio() {
        // Divides Ldl and Hdl.  Casts value to " Float " then returns it
        return (float)ldl / hdl;
    }
    
    /**
     * 
     * Returns a literal string stating the following:
     * "HDL is known as "good cholesterol" and that a ratio of 3.5 or lower is is considered optimum"
     * 
     * @author: Christopher Sigouin
     * @return 
     * @since: 20141001  
     */
    public String explainRatio() {
        
        String output = "HDL is known as \"good cholesterol\" and that a ratio of 3.5" +
                        " or lower is is considered optimum";
        
        return output;
    }
    
    /*
    *
    * GETTER AND SETTER METHODS LISTED BELOW
    *
    */
    public int getPatientNumber() { 
        return patientNumber;
    }

    public void setPatientNumber(String patientNumber) {
        this.patientNumber = parseInt(patientNumber);
    }

    public int getSystolic() {
        return systolic;
    }

    public void setSystolic(String systolic) {
        this.systolic = parseInt(systolic);
    }

    public int getDiastolic() {
        return diastolic;
    }

    public void setDiastolic(String diastolic) {
        this.diastolic = parseInt(diastolic);
    }

    public int getLdl() {
        return ldl;
    }

    public void setLdl(String ldl) {
        this.ldl = parseInt(ldl);
    }

    public int getHdl() {
        return hdl;
    }

    public void setHdl(String hdl) {
        this.hdl = parseInt(hdl);
    }
}
