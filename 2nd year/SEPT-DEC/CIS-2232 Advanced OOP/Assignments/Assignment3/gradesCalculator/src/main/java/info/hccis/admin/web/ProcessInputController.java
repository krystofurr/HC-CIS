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
package info.hccis.admin.web;

import info.hccis.admin.dao.DeliverableDAO;
import info.hccis.admin.model.DatabaseConnection;
import info.hccis.admin.model.Deliverable;
import info.hccis.admin.model.GradeCalculator;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author krystofurr
 */

@Controller
public class ProcessInputController {
    
    /**
     * PROCESS ADDING DELIVERABLES
     * 
     * @param model
     * @param request
     * @param deliverable
     * @return 
     */
    @RequestMapping("/process/addDeliverables")
    public String addDeliverables(Model model, HttpServletRequest request, Deliverable deliverable ) {
        System.out.println("addDeliverables() => Attempting to add deliverables to database...");
        
        // Pull the POST array parameters and store in the deliverable object
//        Deliverable deliverable = new Deliverable();
//        deliverable.setName(request.getParameter("name"));
//        deliverable.setWeight(Integer.parseInt(request.getParameter("weight")));
        
        // Convert the weight back to an integer
        deliverable.setWeight(Integer.parseInt(deliverable.getStringWeight()));
        
        int weightCounter = 0;
        
        // Get the database connection from the session
        DatabaseConnection dbConnection = (DatabaseConnection) request.getSession().getAttribute("db");       
        // Pull the deliverables
        ArrayList<Deliverable> deliverables = DeliverableDAO.loadDeliverables(dbConnection);
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
            DeliverableDAO.insertDeliverable(dbConnection, deliverable);
            
            // Provide indicator to the view on the status of the deliverable
            boolean isDeliverableAdded = true;
            model.addAttribute("isDeliverableAdded", isDeliverableAdded );
 
        }
        
        // Set a variable as well to state that there was an attempt to add a deliverable for the view
        boolean deliverableAttemptToAdd = true;
        model.addAttribute("deliverableAttemptToAdd", deliverableAttemptToAdd );
        
        // To clear the values in the form due to resubmitting the same page
        deliverable.setName("");
        deliverable.setStringWeight("");
        model.addAttribute("deliverable", deliverable);

        return "menuItems/addDeliverables";
    }
    
    /**
     * PROCESS CALCULATING GRADES
     * 
     * @param model
     * @param request
     * @param deliverable
     * @return String
     */
    @RequestMapping("/process/inputGrades")
    public String calculateGrades(Model model, HttpServletRequest request, GradeCalculator gradeCalculator) {
        
        System.out.println(gradeCalculator.toString());
        
        
        System.out.println("calculateGrades() => Attempting to calculate grades...");

        ArrayList<Deliverable> deliverables = (ArrayList<Deliverable>) request.getSession().getAttribute("deliverables");

        double decimalGrade, deliverableWeight, totalGrades;
        decimalGrade = deliverableWeight = totalGrades = 0;

        // Loop through each deliverable and request the grade
        for( int i = 0; i < gradeCalculator.getDeliverables().size(); ++i ) {

            // Convert grade to decimal
            decimalGrade = Double.parseDouble(gradeCalculator.getDeliverables().get(i).getStringGrade()) / 100;

            // Multiply grade by weight and tally
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
        DeliverableDAO.purgeDeliverables(dbConnection);
        
        return "main";
 
    }
    
    /**
     * EDIT DELIVERABLE
     * 
     * @param model
     * @param request
     * @return 
     */
    @RequestMapping("/process/editDeliverable")
    public String editDeliverable(Model model, HttpServletRequest request, Deliverable deliverable) {
        
        System.out.println("editDeliverable() => Editing a single deliverable...");
        
        // Get the database connection from the session
        DatabaseConnection dbConnection = (DatabaseConnection) request.getSession().getAttribute("db");
        // Edit the deliverable
        DeliverableDAO.editDeliverable(dbConnection, deliverable);
        
        // Get the array list to display in showDeliverables after editing
        ArrayList<Deliverable> deliverables = DeliverableDAO.loadDeliverables(dbConnection);
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
        
        // Get a database connection so that we can get a fresh view of the deliverables
        DatabaseConnection dbConnection = (DatabaseConnection) request.getSession().getAttribute("db");
         
        // Call the DAO class to delete
        DeliverableDAO.deleteDeliverable(dbConnection, deliverable);
        
        // Add to the model for the showDeliverables view
        ArrayList<Deliverable> deliverables = DeliverableDAO.loadDeliverables(dbConnection);
        model.addAttribute("deliverables", deliverables);
        
        // Return to showDeliverables for user to review
        return "menuItems/showDeliverables";
    }
    
}
