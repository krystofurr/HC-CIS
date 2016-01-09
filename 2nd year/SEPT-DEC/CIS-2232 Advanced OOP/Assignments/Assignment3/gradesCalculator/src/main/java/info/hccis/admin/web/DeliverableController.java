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



import info.hccis.admin.model.DatabaseConnection;
import info.hccis.admin.model.GradeCalculator;
import info.hccis.admin.model.Deliverable;
import info.hccis.admin.service.DeliverableService;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DeliverableController {

    private final DeliverableService deliverableService;


    @Autowired
    public DeliverableController(DeliverableService deliverableService) {
        this.deliverableService = deliverableService;
    }

    /**
     *  Initial page that Spring will load upon running the application
     *
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/")
    public String initializeHome(Model model, HttpSession session) {

        System.out.println("in controller for /");
        //setup the databaseConnection object in the model.  This will be used on the
        //view.
        DatabaseConnection databaseConnection = new DatabaseConnection();
        model.addAttribute("db", databaseConnection);
        session.setAttribute("db", databaseConnection);
        ArrayList<Deliverable> deliverables = deliverableService.getDeliverables(databaseConnection);
        model.addAttribute("deliverables", deliverables);

        return "main";
    }

    @RequestMapping("/main")
    public String showHome(Model model, HttpServletRequest request ) {

        System.out.println("returning to 'Main Menu'...");
        // Get the database connection from the session
        DatabaseConnection dbConnection = (DatabaseConnection) request.getSession().getAttribute("db");
        // Pull the deliverable list each time incase it was updated
        ArrayList<Deliverable> deliverables = deliverableService.getDeliverables(dbConnection);
        model.addAttribute("deliverables", deliverables);
        
        return "main";

    }

    @RequestMapping("/menuItems/addDeliverables")
    public String menuItemAddDeliverables(Model model) {

        System.out.println("menuItemAddDeliverables() => Displaying View...");
        // Define a new deliverable object to use in the form on this view
        Deliverable deliverable = new Deliverable();
        model.addAttribute("deliverable", deliverable);

        return "menuItems/addDeliverables";

    }

    @RequestMapping("/menuItems/showDeliverables")
    public String menuItemShowDeliverables(Model model, HttpServletRequest request ) {

        System.out.println("menuItemShowDeliverables() => Displaying View...");
        // Get the database connection from the session
        DatabaseConnection dbConnection = (DatabaseConnection) request.getSession().getAttribute("db");
        // Pull the deliverable list each time incase it was updated
        ArrayList<Deliverable> deliverables = deliverableService.getDeliverables(dbConnection);
        model.addAttribute("deliverables", deliverables);

        return "menuItems/showDeliverables";

    }

    @RequestMapping("/menuItems/inputGrades")
    public String menuItemInputGrades(Model model, HttpSession session, HttpServletRequest request ) {

        System.out.println("processing inputGrades view...");
        
        // Get the database connection from the session
        DatabaseConnection dbConnection = (DatabaseConnection) request.getSession().getAttribute("db");
        
        // Pull deliverables. Store a copy in GradeCalculator object array list
        GradeCalculator gradeCalculator = new GradeCalculator();
        ArrayList<Deliverable> deliverables = deliverableService.getDeliverables(dbConnection);
        
        // Store in the session and set the deliverables object in GradeCalculator
        session.setAttribute("deliverables", deliverables);
        gradeCalculator.setDeliverables(deliverables);
        
        
//        gradeCalculator.getDeliverables().get(0).setStringGrade("test1");
//        gradeCalculator.getDeliverables().get(1).setStringGrade("test2");
//        gradeCalculator.getDeliverables().get(2).setStringGrade("test3");
        
        // Pass the gradesCalculator object to the view ( contains the deliverables array list )
        model.addAttribute("grades", gradeCalculator);
        
        
        

//        // HAPPENS ONCE: Store a counter in the session to keep track of the deliverable entries
//        if (session.getAttribute("deliverableCounter") == null) {
//            int deliverableCounter = 0;
//            session.setAttribute("deliverableCounter", deliverableCounter ); 
//            
//            // Pull deliverables only once and store in the session for repeat use
//            ArrayList<Deliverable> deliverables = deliverableService.getDeliverables(dbConnection);
//            session.setAttribute("deliverables", deliverables);
//        }
//        
//        // Get the deliverable counter value from the session
//        int deliverableCounter = (Integer) request.getSession().getAttribute("deliverableCounter");
//        // Get the deliverable list from the session
//        ArrayList<Deliverable> deliverables = (ArrayList<Deliverable>) request.getSession().getAttribute("deliverables");
//        
//
//        // Pass deliverable to the model for the view
//        model.addAttribute("deliverable", deliverables.get(deliverableCounter));
        
        
        return "menuItems/inputGrades";

    }
    
    @RequestMapping("/processItems/editDeliverable")
    public String editDeliverables(Model model, HttpSession session, HttpServletRequest request ) {

        Deliverable targetDeliverable = null;
        
        System.out.println("DeliverableController => editDeliverable() => Displaying 'EDIT' view...");
        // Get the database connection from the session
        DatabaseConnection dbConnection = (DatabaseConnection) request.getSession().getAttribute("db");
        // Pull the deliverable list
        ArrayList<Deliverable> deliverables = deliverableService.getDeliverables(dbConnection);
        // Get the id from the request
        String id = request.getParameter("id");
        
        // Find the deliverable with that id
        for(Deliverable deliverable : deliverables) {
            if( deliverable.getId().equalsIgnoreCase(id)) {
                targetDeliverable = deliverable;
            }
        }
        
        
        model.addAttribute("targetDeliverableEdit", targetDeliverable);

        
        return "processItems/editDeliverable";

    }
    
    @RequestMapping("/processItems/deleteDeliverable")
    public String deleteDeliverables(Model model, HttpSession session, HttpServletRequest request ) {

        Deliverable targetDeliverable = null;
        
        System.out.println("DeliverableController => deleteDeliverable() => Displaying 'DELETE' view...");
        // Get the database connection from the session
        DatabaseConnection dbConnection = (DatabaseConnection) request.getSession().getAttribute("db");
        // Pull the deliverable list
        ArrayList<Deliverable> deliverables = deliverableService.getDeliverables(dbConnection);
        // Get the id from the request
        String id = request.getParameter("id");
        
        // Find the deliverable with that id
        for(Deliverable deliverable : deliverables) {
            if( deliverable.getId().equalsIgnoreCase(id)) {
                targetDeliverable = deliverable;
            }
        }
        
        
        model.addAttribute("targetDeliverableDelete", targetDeliverable);

        
        return "processItems/deleteDeliverable";

    }
    
    

}
