
package info.hccis.admin.service;

import info.hccis.admin.data.springdatajpa.DeliverableRepository;
import info.hccis.admin.model.jpa.Deliverable;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author krystofuimport java.util.ArrayList;
rr
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
    public abstract int getDeliverableCount();
    
    // Used for RESTful services and web application

    public abstract String calculateAverage(List<Deliverable> deliverables);
    

    
}
