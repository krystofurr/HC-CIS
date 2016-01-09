/*
 * NAME: Christopher Sigouin
 * DATE: Dec 9, 2014
 * PURPOSE: Assignment 7
 * DEPENDENCIES: TestVehicle.java
 * 
 * This code is copyright by Christopher Sigouin.
 * If you use it, be prepared to lose it! Mwahahahah ;)
 */
package assignment7;

import java.text.DecimalFormat;

/**
 *
 *      Vehicle class represents a Vehicle object
 * 
 * @since 12052014
 * @author Christopher Sigouin
 */
public class Vehicle {
    
    public final static int MILEAGE_BRACKET_60K = 60000;
    public final static int MILEAGE_BRACKET_100K = 100000;
    public final static int MILEAGE_BRACKET_200K = 200000;
    public final static double VEHICLE_VALUE_MILAGE_30 = .30;
    public final static double VEHICLE_VALUE_MILAGE_35 = .35;
    public final static double VEHICLE_VALUE_MILAGE_40 = .40;
    public final static double VEHICLE_VALUE_MILAGE_50 = .50;
    private final static double VEHICLE_VALUE_TRANSMISSION_5 = 0.05;
    private final static double VEHICLE_VALUE_SUNROOF_10 = .10;
    private double origPrice, newPrice;
    private int mileage;
    private char transmission, sunroof;
    DecimalFormat twoDecimalPlaces = new DecimalFormat("$#,###.00"); // Formatting for Large Pricing
    DecimalFormat mileageFormat = new DecimalFormat("#,###km"); // Formatting for Mileage
    
    /**
     * 
     * Vehicle constructor will set all main attribute values to default values
     * 
     * @since 12052014
     * @author Christopher Sigouin
     */
    public Vehicle() {
        
        // Set Defaults
        setOrigPrice(0);
        setMileage(0);
        setTransmission('m');
        setSunroof('n');
        
    }

    /* ============================== START: SETTERS =================================== */
    public void setOrigPrice(double origPrice) {
        this.origPrice = origPrice;
        calculateVehicleValue();
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
        calculateVehicleValue();
    }

    public void setTransmission(char transmission) {
        this.transmission = transmission;
        calculateVehicleValue();
    }

    public void setSunroof(char sunroof) {
        this.sunroof = sunroof;
        calculateVehicleValue();
    }
    /* ============================== END: SETTERS =================================== */
    
    /**
     * 
     * Will return a String containing main attributes from the vehicle class
     * 
     * @since 12092014
     * @author Christopher Sigouin
     * @return 
     */
    public String toString() {
    
        return "VEHICLE PRICING: " + System.lineSeparator() +
               "Vehicle Original Price: " + twoDecimalPlaces.format(origPrice) + System.lineSeparator() +
               "Mileage: " + mileageFormat.format(mileage) + System.lineSeparator() +
               "Transmission Choice: " + displayTransmissionType() + System.lineSeparator() +
               "Sunroof Choice: " + sunroof + System.lineSeparator() +
               "NEW PRICE TOTAL: " + twoDecimalPlaces.format(newPrice);
    }
    
    /**
     * 
     * Will calculate the new price of a vehicle based on choices made by the user
     * 
     * @since 12092014
     * @author Christopher Sigouin
     * 
     */
    private void calculateVehicleValue() {
    
        double costChange;
        
        //Calculate for Mileage Choice
        if( mileage < MILEAGE_BRACKET_60K ) {
            costChange = origPrice * VEHICLE_VALUE_MILAGE_30;
 
        }else if ( mileage >= MILEAGE_BRACKET_60K && mileage < MILEAGE_BRACKET_100K ) {
            costChange = origPrice * VEHICLE_VALUE_MILAGE_35;
            
        } else if ( mileage >= MILEAGE_BRACKET_100K && mileage < MILEAGE_BRACKET_200K ) {
            costChange = origPrice * VEHICLE_VALUE_MILAGE_40;
            
        } else { // If it's equal to 200K or more!
            costChange = origPrice * VEHICLE_VALUE_MILAGE_50;
            
        }
        
        System.out.println("After : " + costChange);
        
        //Calculate for Transmission Choice
        if( transmission == 'a' )
            costChange -= origPrice * VEHICLE_VALUE_TRANSMISSION_5; // Remove the value from the costChange ( will be subtracted at end )
        else // 
            costChange += origPrice * VEHICLE_VALUE_TRANSMISSION_5; // Add the value to the costChange ( will be subtracted at end )
        
        System.out.println("After Transmission: " + costChange);
        
        //Calculate for Sunroof Choice
        if( sunroof == 'y')
            costChange -= origPrice * VEHICLE_VALUE_SUNROOF_10; // Remove the value from the costChange ( will be subtracted at end )
        
        System.out.println("After Sunroof: " + costChange);
        
        newPrice = origPrice - costChange;
        System.out.println("Old Price: " + origPrice);
        System.out.println("New Price: " + newPrice);
        System.out.printf("New Price: %.2f", newPrice);
                
        
    } // END: calculateVehicleValue
    
    /**
     * 
     * Will return a string based on the value of the attribute 'transmission'
     * ' a - returns Automatic '
     * ' m - returns Manual '
     * 
     * @author Christopher Sigouin
     * @since 12092014
     * @return 
     */
    private String displayTransmissionType() {
        String returnString;
        if( transmission == 'a' )
            returnString = "Automatic";
        else
            returnString = "Manual";
        
        return returnString;
            
    }
    
}
