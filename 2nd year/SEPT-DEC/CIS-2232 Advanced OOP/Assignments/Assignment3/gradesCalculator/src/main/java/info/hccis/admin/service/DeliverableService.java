/*
 * ========= CIS 2232 Advanced Object Oriented Programming PWC ==========
 * NAME: Christopher Sigouin
 * DATE: 29-Oct-2015
 * PURPOSE: 
 */

package info.hccis.admin.service;

import info.hccis.admin.model.DatabaseConnection;
import info.hccis.admin.model.Deliverable;
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
    public abstract ArrayList<Deliverable> getDeliverables(DatabaseConnection databaseConnection);
    
}
