
package info.hccis.admin.model;


/**
 * 
 * Deliverable POJO
 * 
 * @author krystofurr
 */
public class Deliverable {
    

    public static final int MAX_WEIGHT = 100;

    private Integer id;
    private String name;
    private int weight;
    private String stringGrade;

    @Override
    public String toString() {
        return "Deliverable { name=" + name + ", weight=" + weight + " }";
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

    public String getStringGrade() {
        return stringGrade;
    }

    public void setStringGrade(String stringGrade) {
        this.stringGrade = stringGrade;
    }

    
    
}
