/*
 * ========= CIS 2232 Advanced Object Oriented Programming PWC ==========
 * NAME: Christopher Sigouin
 * DATE: 31-Oct-2015
 * PURPOSE: 
 */
package info.hccis.admin.web;

import info.hccis.admin.model.DatabaseConnection;
import info.hccis.admin.model.jpa.Deliverable;
import info.hccis.admin.model.GradeCalculator;
import info.hccis.admin.service.DeliverableService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author krystofurr
 */

@Controller
public class ProcessInputController {
    
//    private final DeliverableRepository deliverableRepository;
    private final DeliverableService deliverableService;
    
    @Autowired
    public ProcessInputController(DeliverableService deliverableService) {

//        this.deliverableRepository = deliverableRepository;
        this.deliverableService = deliverableService;
    }
    
    /**
     * PROCESS ADDING DELIVERABLES
     * 
     * @param model
     * @param request
     * @param deliverable
     * @param <error>
     * @param result
     * 
     * @return 
     */
    @RequestMapping("/process/addDeliverables")
    public String addDeliverables(Model model, HttpServletRequest request, @Valid @ModelAttribute("deliverable") Deliverable deliverable, BindingResult result) {
        System.out.println("addDeliverables() => Attempting to add deliverables to database...");
        
        
        
        // Check for any errors from the addDeliverables.html view...
        if (result.hasErrors()) {
            System.out.println("Error in validation of deliverable.");
            return "/menuItems/addDeliverables";
        }

        System.out.println("Weight ===> " + deliverable.getWeight());
        // Convert the weight back to an integer
//        deliverable.setWeight(Integer.parseInt(deliverable.getStringWeight()));
        
        int weightCounter = 0;
        
        // Get the database connection from the session
        DatabaseConnection dbConnection = (DatabaseConnection) request.getSession().getAttribute("db");       
        
        
        /*
            ++++++++++ ASSIGNMENT 4 - CHANGE +++++++++
        
            11/15/2015 - CJS
        
            Removed DAO method and added JPA method to pull all deliverables
        
        */
        ArrayList<Deliverable> deliverables = deliverableService.getDeliverables();
        
        // Total the weights that are stored in the database
        for(Deliverable singleDeliverable : deliverables) {
            weightCounter += singleDeliverable.getWeight();
        }
        
        System.out.println("addDeliverables() => Total Weight + New Deliverable: " + (weightCounter + deliverable.getWeight()));
        if( (weightCounter + deliverable.getWeight()) > Deliverable.MAX_WEIGHT ) {
            // User cannot add any further deliverables to the database
            
            // Provide indicator to the view on the status of the deliverable
            boolean isDeliverableAdded = false;
            model.addAttribute("isDeliverableAdded", isDeliverableAdded );
            
        } else {
            // Allow the user to add the deliverable
            
            // Insert the deliverable into the database
            //DeliverableDAO.insertDeliverable(dbConnection, deliverable);
           deliverableService.saveDeliverable(deliverable);
            
            // Provide indicator to the view on the status of the deliverable
            boolean isDeliverableAdded = true;
            model.addAttribute("isDeliverableAdded", isDeliverableAdded );
 
        }
        
        // Set a variable as well to state that there was an attempt to add a deliverable for the view
        boolean deliverableAttemptToAdd = true;
        model.addAttribute("deliverableAttemptToAdd", deliverableAttemptToAdd );
        

        model.addAttribute("deliverable", deliverable);

        return "menuItems/addDeliverables";
    }
    
    /**
     * PROCESS CALCULATING GRADES
     * 
     * @param model
     * @param request
     * @param grades
     * @return String
     */
    @RequestMapping("/process/inputGrades")
    public String calculateGrades(Model model, HttpServletRequest request, GradeCalculator grades ) {
        
 
        // Validate 'stringGrades' in the ArrayList here...
        for(int i = 0; i < grades.getDeliverables().size(); ++i) {
            
            String grade = grades.getDeliverables().get(i).getStringGrade();
            
            // Check if it's empty
            if(grade.isEmpty()) {
                System.out.println("calculateGrades() => EMPTY GRADE...PROCESSING...");
                initializeGradeError(model, grades, "Empty Field(s)");
                return "/menuItems/inputGrades";
            } 
            
            // Check to see if it's a number
            try {
                Double.parseDouble(grade);
            } catch ( NumberFormatException e ) {
                initializeGradeError(model, grades, "Must be numeric!");
                return "/menuItems/inputGrades";
            }
            
            // Check if it's within range
            if(Integer.parseInt(grade) < 1 || Integer.parseInt(grade) > 100) {
                System.out.println("calculateGrades() => GRADE RANGE ISSUE...PROCESSING...");
                initializeGradeError(model, grades, "Grades between 1 to 100");
                return "/menuItems/inputGrades";
            } 
            
            
        }
        
  
        // Set other values to a non null value so that they validate
//        for(Deliverable deliverable : grades.getDeliverables()) {
//            deliverable.setName(" ");
//            deliverable.setWeight(-1);
//        }
        /*
        // Check for any errors from the addDeliverables.html view...
        if (result.hasErrors()) {
            System.out.println("Error in validation of deliverable.");
            initializeGradeError(model, grades, "blah");
            return "/menuItems/inputGrades";
        }*/

        System.out.println("calculateGrades() => Attempting to calculate grades...");
        System.out.println(grades.toString());
        
        
        
        // Get the deliverables for the name and weight
        List<Deliverable> deliverables = deliverableService.getDeliverables();
        
        double decimalGrade, deliverableWeight, totalGrades;
        decimalGrade = deliverableWeight = totalGrades = 0;

        // Loop through each deliverable and request the grades
        for( int i = 0; i < grades.getDeliverables().size(); ++i ) {

            // Convert grades to decimal
            try {
                decimalGrade = Double.parseDouble(grades.getDeliverables().get(i).getStringGrade()) / 100;
            } catch ( NumberFormatException e ) {
                System.out.println("SECOND CATCH");
                
            }

            // Multiply grades by weight and tally
            deliverableWeight = deliverables.get(i).getWeight();
            totalGrades += decimalGrade * (deliverableWeight / 100);

        }

        // One decimal place shows for output and add a percent symbol
        System.out.printf("%s%.1f%s%n%n", "AVERAGE: ", totalGrades * 100, " %");

        // Calculate the average and add to the model for the view
        double average = totalGrades * 100;
        model.addAttribute("average", average );
        boolean isGradesCalculated = true;
        model.addAttribute("isGradesCalculated", true );
            

        
        return "menuItems/inputGrades";
//        return "utility/test";
    }
    
    /**
     * PURGE / DELETE ALL DELIVERABLES
     * 
     * @param model
     * @param request
     * @return 
     */
    @RequestMapping("/process/purgeDeliverables")
    public String purgeDeliverables(HttpServletRequest request) {
        System.out.println("purgeDeliverables() => Clearing the database...");
        
        DatabaseConnection dbConnection = (DatabaseConnection) request.getSession().getAttribute("db");
        
        /*
            ++++++++++ ASSIGNMENT 4 - CHANGE +++++++++
        
            11/15/2015 - CJS
        
            Removed DAO method and added JPA method to delete all deliverables
        
        */
        deliverableService.purgeDeliverables();
//        DeliverableDAO.purgeDeliverables(dbConnection);
        
        return "main";
 
    }
    
    /**
     * EDIT DELIVERABLE
     * 
     * @param model
     * @param request
     * @return 
     */
    @Transactional
    @RequestMapping("/process/editDeliverable")
    public String editDeliverable(Model model, HttpServletRequest request, Deliverable deliverable) {
        
        System.out.println("editDeliverable() => Editing a single deliverable...");
        
        // Get the database connection from the session
        DatabaseConnection dbConnection = (DatabaseConnection) request.getSession().getAttribute("db");
        // Edit the deliverable
        System.out.println("Deliverable ID: " + deliverable.getId());
         System.out.println("Deliverable ID: " + deliverable.getName());
          System.out.println("Deliverable ID: " + deliverable.getWeight());
          
        /*
            ++++++++++ ASSIGNMENT 4 - CHANGE +++++++++
        
            11/15/2015 - CJS
        
            Removed DAO method and added JPA method to update all deliverables
        
        */  
        deliverableService.saveDeliverable(deliverable);
//        DeliverableDAO.editDeliverable(dbConnection, deliverable);
        
        // Get the array list to display in showDeliverables after editing
        
        /*
            ++++++++++ ASSIGNMENT 4 - CHANGE +++++++++
        
            11/15/2015 - CJS
        
            Removed DAO method and added JPA method to pull all deliverables
        
        */
        ArrayList<Deliverable> deliverables = deliverableService.getDeliverables();
        // Add to the model to redisplay the deliverables
        model.addAttribute("deliverables", deliverables);
        return "menuItems/showDeliverables";
    }
    
    /**
     * DELETE A SINGLE DELIVERABLE
     * 
     * @param model
     * @param request
     * @return 
     */
    @RequestMapping("/process/deleteDeliverable")
    public String deleteDeliverable(Model model, HttpServletRequest request, Deliverable deliverable) {
        
        System.out.println("deleteDeliverable() => Deleting a single deliverable...");
        
//        // Get a database connection so that we can get a fresh view of the deliverables
//        DatabaseConnection dbConnection = (DatabaseConnection) request.getSession().getAttribute("db");
         
        /*
            ++++++++++ ASSIGNMENT 4 - CHANGE +++++++++
        
            11/15/2015 - CJS
        
            Removed DAO method and added JPA method to delete a deliverable
        
        */
        deliverableService.deleteDeliverable(deliverable);
        
        // Add to the model for the showDeliverables view
        
        /*
            ++++++++++ ASSIGNMENT 4 - CHANGE +++++++++
        
            11/15/2015 - CJS
        
            Removed DAO method and added JPA method to pull all deliverables
        
        */
        ArrayList<Deliverable> deliverables = deliverableService.getDeliverables();
        model.addAttribute("deliverables", deliverables);
        
        // Return to showDeliverables for user to review
        return "menuItems/showDeliverables";
    }
    
    /**
     * REF: http://www.coderanch.com/t/405258/java/java/String-IsNumeric
     * 
     * @param str
     * @return 
     */
    public static boolean isNumeric(String str)
  {
        try
        {
          double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
          return false;
        }
        return true;
    }
    
    public void initializeGradeError(Model model, GradeCalculator grades, String errorMessage) {
        
        grades.setDeliverables(deliverableService.getDeliverables());
        model.addAttribute("errorMessage", errorMessage);
        model.addAttribute("grades", grades);

    }
    
}
