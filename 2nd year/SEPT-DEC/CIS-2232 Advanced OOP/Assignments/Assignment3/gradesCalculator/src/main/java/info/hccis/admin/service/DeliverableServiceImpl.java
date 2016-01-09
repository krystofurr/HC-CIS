package info.hccis.admin.service;

import info.hccis.admin.dao.DeliverableDAO;
import info.hccis.admin.model.DatabaseConnection;
import info.hccis.admin.model.Deliverable;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

/*
 * ========= CIS 2232 Advanced Object Oriented Programming PWC ==========
 * NAME: Christopher Sigouin
 * DATE: 29-Oct-2015
 * PURPOSE: 
 */

/**
 *
 * @author krystofurr
 */

@Service
public class DeliverableServiceImpl implements DeliverableService {
    
    public ArrayList<Deliverable> getDeliverables(DatabaseConnection databaseConnection) {
        System.out.println("returning deliverables...from DeliverableServiceImpl");
        return DeliverableDAO.loadDeliverables(databaseConnection);
    }
    
}
