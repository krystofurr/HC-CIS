/*
 * ========= CIS 2232 Advanced Object Oriented Programming PWC ==========
 * NAME: Christopher Sigouin
 * DATE: 20-Nov-2015
 * PURPOSE: 
 */
package info.hccis.admin.model.jpa;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
//import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author krystofurr
 */
@Entity
@Table(name = "Deliverables")

public class Deliverable implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public static final int MAX_WEIGHT = 100;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    @Pattern(regexp = "^\\b[A-Za-z].*$", message = "Must begin with a letter")
    private String name;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "weight")
    private int weight;

    
    @Transient
    private String stringGrade;
    
    // Must have this for Jersey / JSON integration
    public Deliverable() {
    }

    public Deliverable(Integer id) {
        this.id = id;
    }

    public Deliverable(Integer id, String name, int weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Deliverable)) {
            return false;
        }
        Deliverable other = (Deliverable) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Deliverable{" + "id=" + id + ", name=" + name + ", weight=" + weight + ", stringGrade=" + stringGrade + '}';
    }
    
    

//    @Override
//    public String toString() {
//        ObjectMapper mapper = new ObjectMapper();
//        String jsonInString = "";
//        try {
//            jsonInString = mapper.writeValueAsString(this);
//        } catch (IOException ex) {
//            return "Error in toString()";
//        }
//        
//        return jsonInString;
//    }

    public String getStringGrade() {
        return stringGrade;
    }

    public void setStringGrade(String stringGrade) {
        this.stringGrade = stringGrade;
    }
    
    public static String calculateAverage(List<Deliverable> deliverables) {
        
        double decimalGrade, deliverableWeight, totalGrades;
        decimalGrade = deliverableWeight = totalGrades = 0;

        // Loop through each deliverable and request the grades
        for( int i = 0; i < deliverables.size(); ++i ) {

            // Convert grades to decimal
            try {
                decimalGrade = Double.parseDouble(deliverables.get(i).getStringGrade()) / 100;
            } catch ( Exception ex ) {
                System.out.println("SECOND CATCH " + ex.getMessage());
                
            }

            // Multiply grades by weight and tally
            deliverableWeight = deliverables.get(i).getWeight();
            totalGrades += decimalGrade * (deliverableWeight / 100);

        }

        // One decimal place shows for output and add a percent symbol
        System.out.printf("%s%.1f%s%n%n", "AVERAGE: ", totalGrades * 100, " %");

        // Calculate the average and add to the model for the view
        Double average = totalGrades * 100;
        
        return average.toString();
        
    }
    
    
    
}
