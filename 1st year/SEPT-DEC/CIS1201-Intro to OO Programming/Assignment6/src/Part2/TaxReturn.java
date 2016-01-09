/*
 * NAME: Christopher Sigouin
 * DATE: Dec 3, 2014
 * PURPOSE: Assignment 6 - Part 2
 * DEPENDENCIES: PrepareTax.java
 * 
 * This code is copyright by Christopher Sigouin.
 * If you use it, be prepared to lose it! Mwahahahah ;)
 */
package Part2;

import java.text.DecimalFormat;

/**
 *
 * TaxReturn class represents an object of a TaxReturn
 * 
 * @since 12042014
 * @author Christopher Sigouin
 */
public class TaxReturn {
    
    public final static String MARITAL_STATUS_SINGLE = "single";
    public final static String MARITAL_STATUS_MARRIED = "married";
    public final static int INCOME_TAX_BRACKET_20K = 20000;
    public final static int INCOME_TAX_BRACKET_50K = 50000;
    public final static double PERCENTAGE_SINGLE_0_TO_20k = .15; // 15%
    public final static double PERCENTAGE_SINGLE_20k_TO_50k = .22; // 22%
    public final static double PERCENTAGE_SINGLE_50k_PLUS = .30; // 30%
    public final static double PERCENTAGE_MARRIED_0_TO_20k = .14; // 14%
    public final static double PERCENTAGE_MARRIED_20k_TO_50k = .20; // 20%
    public final static double PERCENTAGE_MARRIED_50k_PLUS = .28; // 28%
    
    

    private double annualIncome, taxLiability;
    String sin, lastName, firstName, streetAddress, city, state, zipCode, maritalStatus;
    
    DecimalFormat twoDecimalPlaces = new DecimalFormat("#.00");
    
    /**
     * 
     * Constructor for the TaxReturn class.  Takes all attributes as arguments except for
     * taxLiability
     * 
     * @param sin
     * @param annualIncome
     * @param lastName
     * @param firstName
     * @param streetAddress
     * @param city
     * @param state
     * @param zipCode
     * @param maritalStatus 
     * @since 12042014
     * @author Christopher Sigouin
     */
    public TaxReturn(String sin, double annualIncome, String lastName, String firstName, String streetAddress,
                     String city, String state, String zipCode, String maritalStatus ) {
        
        // Constructor that requires arguments that provide values for all the fields other than the tax liability
        this.sin = sin;
        this.annualIncome = annualIncome;
        this.lastName = lastName;
        this.firstName = firstName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.maritalStatus = maritalStatus;
        
        //  Constructor calculates the tax liability based on annual income and the percentages
        calculateTaxLiability(); 
    
    }

    /**
     * 
     * toString method display a TaxReturn object
     * 
     * @return 
     * @since 12042014
     * @author Christopher Sigouin
     */
    @Override
    public String toString() {
        return "YOUR TAX RETURN: " + System.lineSeparator() + System.lineSeparator() +
               "SIN: " + sin + System.lineSeparator() +
               "ANNUAL INCOME: $" + twoDecimalPlaces.format(annualIncome) + System.lineSeparator() +
               "TAX LIABILITY: " + taxLiability + System.lineSeparator() +
               "LAST NAME: " + lastName + System.lineSeparator() +
               "FIRST NAME: " + firstName + System.lineSeparator() +
               "STREET ADDRESS: " + streetAddress + System.lineSeparator() +
               "CITY: " + city + System.lineSeparator() +
               "STATE: " + state + System.lineSeparator() +
               "ZIP CODE: " + zipCode + System.lineSeparator() +
               "MARITAL STATUS: " + maritalStatus + System.lineSeparator() +
               "TAX LIABILITY: $" + twoDecimalPlaces.format(taxLiability);
        
    }
    
    
    /**
     * 
     *      Calculates the tax liability based on annual income and the percentages
     * 
     * @author Christopher Sigouin
     * @since 12032014
     */
    private void calculateTaxLiability() {
        
        if( annualIncome <= INCOME_TAX_BRACKET_20K ){
            if( maritalStatus.equalsIgnoreCase(MARITAL_STATUS_SINGLE))
                taxLiability = annualIncome * PERCENTAGE_SINGLE_0_TO_20k;
            if( maritalStatus.equalsIgnoreCase(MARITAL_STATUS_MARRIED))
                taxLiability = annualIncome * PERCENTAGE_MARRIED_0_TO_20k;
        } else if ( annualIncome > INCOME_TAX_BRACKET_20K && annualIncome <= INCOME_TAX_BRACKET_50K ){
            if( maritalStatus.equalsIgnoreCase(MARITAL_STATUS_SINGLE))
                taxLiability = annualIncome * PERCENTAGE_SINGLE_20k_TO_50k;
            if( maritalStatus.equalsIgnoreCase(MARITAL_STATUS_MARRIED))
                taxLiability = annualIncome * PERCENTAGE_MARRIED_20k_TO_50k;
        } else {
            if( maritalStatus.equalsIgnoreCase(MARITAL_STATUS_SINGLE))
                taxLiability = annualIncome * PERCENTAGE_SINGLE_50k_PLUS;
            if( maritalStatus.equalsIgnoreCase(MARITAL_STATUS_MARRIED))
                taxLiability = annualIncome * PERCENTAGE_MARRIED_50k_PLUS;
        }
    } // END: calculateTaxLiability()
}// END: TaxReturn class
