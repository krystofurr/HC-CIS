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

import info.hccis.admin.model.jpa.Deliverable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author krystofurr
 */
public class GradeCalculator {
    
    private List<Deliverable> deliverables;

    
    @Override
    public String toString() {
        return "GradeCalculator{" + "deliverables=" + deliverables + '}';
    }

    
    public  List<Deliverable> getDeliverables() {
        return deliverables;
    }

    public void setDeliverables(List<Deliverable> deliverables) {
        this.deliverables = deliverables;
    }

    
    
    
    
}
