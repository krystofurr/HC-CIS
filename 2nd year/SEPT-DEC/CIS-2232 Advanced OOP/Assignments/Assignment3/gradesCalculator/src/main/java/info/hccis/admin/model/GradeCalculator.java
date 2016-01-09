/*
 * ========= CIS 2232 Advanced Object Oriented Programming PWC ==========
 * NAME: Christopher Sigouin
 * DATE: 8-Nov-2015
 * PURPOSE: 
 */
package info.hccis.admin.model;

import java.util.ArrayList;

/**
 *
 * @author krystofurr
 */
public class GradeCalculator {
    
    private ArrayList<Deliverable> deliverables;
    private int[] testInts = new int[3];

    
    @Override
    public String toString() {
        return "GradeCalculator{" + "deliverables=" + deliverables + '}';
    }

    
    public ArrayList<Deliverable> getDeliverables() {
        return deliverables;
    }

    public void setDeliverables(ArrayList<Deliverable> deliverables) {
        this.deliverables = deliverables;
    }

    public int[] getTestInts() {
        return testInts;
    }

    public void setTestInts(int[] testInts) {
        this.testInts = testInts;
    }
    
    
    
    
    
}
