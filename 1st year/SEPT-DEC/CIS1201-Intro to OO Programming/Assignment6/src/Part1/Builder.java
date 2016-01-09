/*
 * NAME: Christopher Sigouin
 * DATE: Dec 3, 2014
 * PURPOSE: Assignment 6 - Part 1
 * DEPENDENCIES: Name.java
 * 
 * This code is copyright by Christopher Sigouin.
 * If you use it, be prepared to lose it! Mwahahahah ;)
 */

package Part1;

/**
 * 
 *  Builder Class is used to test the Name class
 * 
 * @author krystofurr
 * @since 12032014
 */
public class Builder {

    /**
     * This main method should work with your Name class that is created in part 1 of assignment 6.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Name personOne = new Name("Bruce","John","MacLean");
        Name personTwo = new Name("Joey","Julien","Kitson");
        Name personThree = new Name("Santa","Joe","Claus");
        
        System.out.println(personOne);
        System.out.println(personTwo);
        System.out.println(personThree);
        
        personTwo.setFirstName("Chris");
        System.out.println(personTwo);
     
        /*
        Example output for person 1 above.
        
        First name:  Bruce
        Middle name:  John
        Last name: MacLean
        Entire name:  Bruce John MacLean
        Last First:  MacLean, Bruce
        Signature:  Bruce J. MacLean
        
        */
        
        
    }
    
}
