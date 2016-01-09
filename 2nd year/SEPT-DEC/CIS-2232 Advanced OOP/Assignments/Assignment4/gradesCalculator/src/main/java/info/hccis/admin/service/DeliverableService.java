/*
 * ========= CIS 2232 Advanced Object Oriented Programming PWC ==========
 * NAME: Christopher Sigouin
 * DATE: 29-Oct-2015
 * PURPOSE: 
 */

package info.hccis.admin.service;

import info.hccis.admin.data.springdatajpa.DeliverableRepository;
import info.hccis.admin.model.DatabaseConnection;
import info.hccis.admin.model.jpa.Deliverable;
import java.util.ArrayList;

/**
 *
 * @author krystofurr
 */
public interface DeliverableService {
    
    /**
     * Returns an ArrayList of ' Deliverable ' objects
     * 
     * @param databaseConnection
     * @return 
     */
//    public abstract ArrayList<Deliverable> getDeliverables(DatabaseConnection databaseConnection);
    
    public abstract DeliverableRepository getDeliverableRepository();
    
    public abstract void saveDeliverable(Deliverable deliverable);
    public abstract void deleteDeliverable(Deliverable deliverable);
    public abstract Deliverable getDeliverable(int id);
    public abstract void purgeDeliverables();
    public ArrayList<Deliverable> getDeliverables();
    

    
}
