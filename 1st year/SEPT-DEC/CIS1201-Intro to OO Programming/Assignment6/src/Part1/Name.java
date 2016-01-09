/*
 * NAME: Christopher Sigouin
 * DATE: Dec 3, 2014
 * PURPOSE: Assignment 6 - Part 1
 * DEPENDENCIES: Builder.java
 * 
 * This code is copyright by Christopher Sigouin.
 * If you use it, be prepared to lose it! Mwahahahah ;)
 */

package Part1;

/**
 * 
 * Name class represents an object with name attributes
 * 
 * @author krystofurr
 * @since 12032014
 */
public class Name {
    
    /*
            firstName: holds reference for first name input
            lastName: holds reference for last name input
            middleName: holds reference for middle name input
            entireName: refers to your three names, separated by spaces
            lastFirst: refers to your last name, a comma, a space, and your first name, in that order
            signature: refers to your first name, a space, your middle initial (not the entire name), 
                       a period, a space, and your last name
    */
    StringBuilder firstName, lastName, middleName, entireName, lastFirst, signature;

    /**
     * 
     * Constructor of the Name class.  Takes three arguments and uses them in the setter methods
     * 
     * @param firstName
     * @param middleName
     * @param lastName
     * @since 12042014
     * @author Christopher Sigouin
     */
    public Name(String firstName, String middleName, String lastName) {
    
        setFirstName(firstName);
        setMiddleName(middleName);
        setLastName(lastName);

    }

    /**
     * 
     * toString method used to display all attributes of the Name class
     * 
     * @since 12042014
     * @author Christopher Sigouin
     */
    @Override
    public String toString() {
        
        /*First name:  Bruce
        Middle name:  John
        Last name: MacLean
        Entire name:  Bruce John MacLean
        Last First:  MacLean, Bruce
        Signature:  Bruce J. MacLean*/
                
        return "First Name: " + firstName.toString() + System.lineSeparator() +
               "Middle Name: " + middleName.toString() + System.lineSeparator() +
               "Last Name: " + lastName.toString() + System.lineSeparator() + 
               "Entire Name: " + entireName.toString() + System.lineSeparator() +
               "Last First: " + lastFirst.toString() + System.lineSeparator() +
               "Signature: " + signature.toString() + System.lineSeparator();
                
    }

    /**
     * 
     * Used to set the 'firstName' attribute.  Also calls 'setNameAttributes' method to set three other 
     * attributes ( entireName, lastFirst and signature )
     * 
     * @since 12042014
     * @author Christopher Sigouin
     */
    public void setFirstName(String firstName) {
         this.firstName  = new StringBuilder(firstName);
        
        // Sets entireName, lastFirst and signature
        setNameAttributes();
     }

    /**
     * 
     * Used to set the 'lastName' attribute.  Also calls 'setNameAttributes' method to set three other 
     * attributes ( entireName, lastFirst and signature )
     * 
     * @since 12042014
     * @author Christopher Sigouin
     */
    public void setLastName(String lastName) {
        this.lastName = new StringBuilder(lastName);
        
        // Sets entireName, lastFirst and signature
        setNameAttributes();
    }

    /**
     * 
     * Used to set the 'middleName' attribute.  Also calls 'setNameAttributes' method to set three other 
     * attributes ( entireName, lastFirst and signature )
     * 
     * @since 12042014
     * @author Christopher Sigouin
     */
    public void setMiddleName(String middleName) {
        this.middleName = new StringBuilder(middleName);
        
        // Sets entireName, lastFirst and signature
        setNameAttributes();
    }

    /**
     * 
     * Used to set the attributes entireName, lastFirst and signature.  Ensures that if the
     * values of any of the attributes it sets is 'null' it will not update the name until 
     * there is a valid firstName, middleName or lastName.
     * 
     * @since 12042014
     * @author Christopher Sigouin
     */
    private void setNameAttributes() {

        // As long as none of the attributes are equal to 'null'...go ahead with building the name
        if( firstName != null && middleName != null && lastName != null ){
       
            entireName = new StringBuilder();
            entireName.append(firstName.toString()).append(" ").append(middleName.toString()).append(" ").append(lastName.toString());
            lastFirst = new StringBuilder();
            lastFirst.append(lastName.toString()).append(" ").append(firstName.toString());
            signature = new StringBuilder();
            signature.append(firstName.toString()).append(" ").append(middleName.toString().charAt(0)).append(". ").append(lastName.toString());
            
        }
    }
}
