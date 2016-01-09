

package info.hccis.admin.web;



import info.hccis.admin.model.DatabaseConnection;
import info.hccis.admin.model.GradeCalculator;
import info.hccis.admin.model.jpa.Deliverable;
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
        
        // CHANGED
        ArrayList<Deliverable> deliverables = deliverableService.getDeliverables();
        model.addAttribute("deliverables", deliverables);

        return "main";
    }

    @RequestMapping("/main")
    public String showHome(Model model, HttpServletRequest request ) {

        System.out.println("returning to 'Main Menu'...");

        // Pull the deliverable list each time incase it was updated
        
        // CHANGED
        ArrayList<Deliverable> deliverables = deliverableService.getDeliverables();
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

        // Pull the deliverable list each time incase it was updated
        
        //CHANGED
        ArrayList<Deliverable> deliverables = deliverableService.getDeliverables();
        model.addAttribute("deliverables", deliverables);

        return "menuItems/showDeliverables";

    }

    @RequestMapping("/menuItems/inputGrades")
    public String menuItemInputGrades(Model model, HttpSession session ) {

        System.out.println("processing inputGrades view...");

        // Pull deliverables. Store a copy in GradeCalculator object array list
        GradeCalculator gradeCalculator = new GradeCalculator();
        
        //CHANGED
        ArrayList<Deliverable> deliverables = deliverableService.getDeliverables();
        gradeCalculator.setDeliverables(deliverables);
        
        // Store the deliverables in the session for other methods to use
        session.setAttribute("deliverables", deliverables);
        
        // Pass the gradesCalculator object to the view ( contains the deliverables array list )
        model.addAttribute("grades", gradeCalculator);

        return "menuItems/inputGrades";

    }
    
    @RequestMapping("/processItems/editDeliverable")
    public String editDeliverables(Model model, HttpServletRequest request ) {

        System.out.println("DeliverableController => editDeliverable() => Displaying 'EDIT' view...");

        
        // Get the id from the request
        int id = Integer.parseInt(request.getParameter("id"));
        //CHANGED
        Deliverable targetDeliverable = deliverableService.getDeliverable(id);

        model.addAttribute("targetDeliverableEdit", targetDeliverable);
        return "processItems/editDeliverable";

    }
    
    @RequestMapping("/processItems/deleteDeliverable")
    public String deleteDeliverables(Model model, HttpServletRequest request ) {

        System.out.println("DeliverableController => deleteDeliverable() => Displaying 'DELETE' view...");

        // Get the id from the request
        int id = Integer.parseInt(request.getParameter("id"));
        // CHANGED
        Deliverable targetDeliverable = (Deliverable) deliverableService.getDeliverable(id);
        model.addAttribute("targetDeliverableDelete", targetDeliverable);
        return "processItems/deleteDeliverable";

    }
    
    

}
