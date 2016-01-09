/*
 * ========= CIS 2232 Advanced Object Oriented Programming PWC ==========
 * NAME: Christopher Sigouin
 * DATE: 20-Sep-2015
 * PURPOSE: Topic 1 Assignment 1
 */

/**
 *      DELIVERABLE CLASS - Represents a single deliverable
 */
public class Deliverable {
 
    private String name; // Name of the deliverable
    private int weight; // Percentage for the deliverable

    // Default Constructor
    public Deliverable() {}
    
    // Custom Constructor
    public Deliverable(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }
    
    // Customer Constructor.  Used to create the .csv file
    public Deliverable(String[] parts) {
        this(parts[0],Integer.parseInt(parts[1]));
    }
    
    @Override
    public String toString() {
        return "Deliverable{" + "name=" + name + ", weight=" + weight + '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    
    
    
    
}
