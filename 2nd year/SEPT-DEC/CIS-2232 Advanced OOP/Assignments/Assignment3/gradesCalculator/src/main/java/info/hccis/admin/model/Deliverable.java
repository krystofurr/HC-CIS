/*
    _            _                                  _     _____ 
   / \   ___ ___(_) __ _ _ __  _ __ ___   ___ _ __ | |_  |___ / 
  / _ \ / __/ __| |/ _` | '_ \| '_ ` _ \ / _ \ '_ \| __|   |_ \ 
 / ___ \\__ \__ \ | (_| | | | | | | | | |  __/ | | | |_   ___) |
/_/   \_\___/___/_|\__, |_| |_|_| |_| |_|\___|_| |_|\__| |____/ 
                   |___/ 

========= CIS 2232 Advanced Object Oriented Programming PWC ==========
NAME: Christopher Sigouin
DATE: 30-Oct-2015
PURPOSE: Assignment 3

*/

package info.hccis.admin.model;

public class Deliverable {
 
    public final static int MAX_WEIGHT = 100;
    
    private String id;
    private String name; // Name of the deliverable
    private int weight; // Percentage for the deliverable
    private String stringWeight;  // String version of the weight ( Used for view input fields )
    private String stringGrade; // String version of the grade ( Used for view input fields )
 

    // Default Constructor
    public Deliverable() {}
    
    // Custom Constructor
    public Deliverable(String id, String name, int weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }
    
    // Customer Constructor.  Used to create the .csv file
    public Deliverable(String[] parts) {
        this(parts[0], parts[1],Integer.parseInt(parts[2]));
    }

    @Override
    public String toString() {
        return "Deliverable{" + "id=" + id + ", name=" + name + ", weight=" + weight + ", stringWeight=" + stringWeight + ", stringGrade=" + stringGrade + '}';
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStringWeight() {
        return stringWeight;
    }

    public void setStringWeight(String stringWeight) {
        this.stringWeight = stringWeight;
    }

    public String getStringGrade() {
        return stringGrade;
    }

    public void setStringGrade(String stringGrade) {
        this.stringGrade = stringGrade;
    }


    

    
    
    
    
    

    
    
    
    
    
}
