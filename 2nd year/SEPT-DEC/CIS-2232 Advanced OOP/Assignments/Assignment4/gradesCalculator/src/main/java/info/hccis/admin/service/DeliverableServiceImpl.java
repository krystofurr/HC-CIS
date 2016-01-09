package info.hccis.admin.service;

import info.hccis.admin.dao.DeliverableDAO;
import info.hccis.admin.data.springdatajpa.DeliverableRepository;
import info.hccis.admin.model.DatabaseConnection;
import info.hccis.admin.model.jpa.Deliverable;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

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
    
    // Define the repository
    private final DeliverableRepository deliverableRepository;

    
    // Inject the repository
    @Autowired
    public DeliverableServiceImpl(DeliverableRepository deliverableRepository){
        this.deliverableRepository = deliverableRepository;
    }
    
    @Override
    public ArrayList<Deliverable> getDeliverables() {
        return (ArrayList<Deliverable>) deliverableRepository.findAll();
    }

    @Override
    public DeliverableRepository getDeliverableRepository() {
        return deliverableRepository;
    }

    @Override
    public void saveDeliverable(Deliverable deliverable) {
        deliverableRepository.save(deliverable);
    }

    @Override
    public void deleteDeliverable(Deliverable deliverable) {
        deliverableRepository.delete(deliverable);
    }

    @Override
    public Deliverable getDeliverable(int id) {
        return deliverableRepository.findOne(id);
    }
    
    @Override
    public void purgeDeliverables() {
        deliverableRepository.deleteAll();
    }
    
}




