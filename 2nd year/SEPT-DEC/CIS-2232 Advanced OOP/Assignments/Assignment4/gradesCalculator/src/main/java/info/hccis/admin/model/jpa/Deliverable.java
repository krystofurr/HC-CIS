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

package info.hccis.admin.model.jpa;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="Deliverables")
public class Deliverable implements Serializable {
 
    public final static int MAX_WEIGHT = 100;
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO )
    @Column( name = "id")
    private int id;

    
    @Column( name = "name")
    @NotEmpty(message = "Required")
    @Pattern(regexp = "^\\b[A-Za-z].*$", message = "Must begin with a letter") // Don't include start and end of regex pattern
    private String name; // Name of the deliverable
  
    @Column( name = "weight")
    @NotNull(message ="Invalid Weight")
    @Min(1)
    @Max(100)
    private int weight; // Percentage for the deliverable

    @Transient
    private String stringGrade;
    
    // Default Constructor
    public Deliverable() {}
    
    // Custom Constructor
    public Deliverable( String name, int weight) {
     
        this.name = name;
        this.weight = weight;
    }
    
//    // Customer Constructor.  Used to create the .csv file
//    public Deliverable(String[] parts) {
//        this(parts[0], parts[1],Integer.parseInt(parts[2]));
//    }

    
    @Override
    public String toString() {
        return "Deliverable{" + "id=" + id + ", name=" + name + ", weight=" + weight + ", stringGrade=" + stringGrade + '}';
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStringGrade() {
        return stringGrade;
    }

    public void setStringGrade(String stringGrade) {
        this.stringGrade = stringGrade;
    }


    
    

    
    
    
    
    

    
    
    
    
    
}
