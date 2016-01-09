package info.hccis.admin.service;

import info.hccis.admin.data.springdatajpa.DeliverableRepository;
import info.hccis.admin.model.jpa.Deliverable;
import java.util.ArrayList;
import java.util.List;
//import org.codehaus.jackson.JsonFactory;
//import org.codehaus.jackson.JsonParser;
//import org.codehaus.jackson.JsonToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * Deliverable Service Implementation
 * 
 */

@Service
public class DeliverableServiceImpl implements DeliverableService {
    

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

    @Override
    public int getDeliverableCount() {
        return (int)deliverableRepository.count();
    }
    
  


    @Override
    public String calculateAverage(List<Deliverable> deliverables) {
        
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




