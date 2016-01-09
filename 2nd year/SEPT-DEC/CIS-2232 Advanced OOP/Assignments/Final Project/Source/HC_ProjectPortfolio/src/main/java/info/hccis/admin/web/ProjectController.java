/*

 ========= CIS 2232 Advanced Object Oriented Programming PWC ==========
 ____            _           _     ____            _    __       _ _       
 |  _ \ _ __ ___ (_) ___  ___| |_  |  _ \ ___  _ __| |_ / _| ___ | (_) ___  
 | |_) | '__/ _ \| |/ _ \/ __| __| | |_) / _ \| '__| __| |_ / _ \| | |/ _ \ 
 |  __/| | | (_) | |  __/ (__| |_  |  __/ (_) | |  | |_|  _| (_) | | | (_) |
 |_|   |_|  \___// |\___|\___|\__| |_|   \___/|_|   \__|_|  \___/|_|_|\___/ 
 |__/                                                         

 Project Members: Christopher Sigouin & Matthew Hutchinson

 Date: 13-Dec-2015
 Purpose: Final Project

 */
package info.hccis.admin.web;

import info.hccis.admin.model.jpa.Hyperlink;
import info.hccis.admin.model.jpa.Milestone;
import info.hccis.admin.model.jpa.Profile;
import info.hccis.admin.model.jpa.Project;
import info.hccis.admin.model.jpa.ProjectStatus;
import info.hccis.admin.model.jpa.Technology;
import info.hccis.admin.service.ProjectService;
import info.hccis.admin.service.TechnologyService;
import info.hccis.admin.util.ErrorLogUtility;
import info.hccis.admin.util.HibernateUtil;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author krystofurr
 */
@Controller
@RequestMapping("/project")
public class ProjectController {
    
    private final TechnologyService technologyService;
    private final ProjectService projectService;


    @Autowired
    public ProjectController(ProjectService projectService, TechnologyService technologyService) 
    {
        this.technologyService = technologyService;
        this.projectService = projectService;
  
    }
    /**
     *  Adds a project to the system
     *  
     * 
     * 
     * @param model
     * @param session
     * @param request
     * @param project
     * @return 
     */    
    @RequestMapping(value = "/add", method = RequestMethod.GET )
    public String addProject(Model model, HttpSession session, HttpServletRequest request, Project project) {
   
        // Date objects for start and end points
        Date startDateObject, endDateObject;
        startDateObject = endDateObject = null;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        // Objects to utilize through the transaction
        Technology technology = null;
        Milestone m = null;
        Hyperlink h = null;
        ProjectStatus ps = new ProjectStatus();
        // Preset from session and request parameters from view
        Profile pr = (Profile)session.getAttribute("userProfile");
        // Initialize an error log file for the application
        try {
            ps.setStatID(Integer.parseInt(request.getParameter("status")));
        } catch (Exception ex) {
            ErrorLogUtility.log(ex, Level.SEVERE, "[ProjectController]:Incorrect Project Status Type");
        }
        
 
        // Initialize needed lists for multi values
        ArrayList<Project> projectList = new ArrayList<>();
        ArrayList<Technology> technologyList = new ArrayList<>();
        ArrayList<Milestone> milestoneList = new ArrayList<>();
        ArrayList<Hyperlink> hyperlinkList = new ArrayList<>();
 
        // Start Hibernate
        Session hibernateSession = HibernateUtil.getSessionFactory().getCurrentSession();
        hibernateSession.beginTransaction();
        
        
        /* SET MILESTONE LIST ( @OneToMany ) */
        String[] milestones = request.getParameterValues("milestones");
        String[] startDate = request.getParameterValues("startDate");
        String[] endDate = request.getParameterValues("endDate");
        long unixStampStartDate, unixStampEndDate;
        unixStampStartDate = unixStampEndDate = 0;
        int index = 0;
        for(String milestone : milestones) {
 
            // Convert the parameter dates into unix timestamps
            try {
                startDateObject = dateFormat.parse(startDate[index]);
                endDateObject = dateFormat.parse(endDate[index]);
                unixStampStartDate = startDateObject.getTime() / 1000;
                unixStampEndDate = endDateObject.getTime() / 1000;
            } catch (ParseException ex) {
                ErrorLogUtility.log(ex, Level.SEVERE, "[ProjectController]:Error processing milestone start and/or end dates");
            }
            ++index;
            
            // Create a milestone
            m = new Milestone();
            // Set the description, start time and end time
            m.setDescription(milestone);
            m.setStartDate(unixStampStartDate);
            m.setEndDate(unixStampEndDate);
            // Assign the project to the milestone ( Required for Hibernate )
            m.setProjID(project);
            // Add the milestone to its list
            milestoneList.add(m);

        }  
        
        /* SET HYPERLINK LIST ( @OneToMany ) */
        String[] hyperlinks = request.getParameterValues("hyperlinks");
        String[] hyperlinkDescriptions = request.getParameterValues("hyperlinkDescription");
        index = 0;
        for(String hyperlink : hyperlinks) {
            // Create a hyperlink
            h = new Hyperlink();
            // Set the link and description 
            h.setLink(hyperlink);
            h.setDescription(hyperlinkDescriptions[index]);
            ++index;
            // Assign the project
            h.setProjID(project);
            // Store the hyperlink in its list
            hyperlinkList.add(h);
        }
        
        /* SET TECHNOLOGY TYPES ( @ManyToMany ) */ 
        String[] technologies = request.getParameterValues("technologies");
        for(String t : technologies) {
            
            int num = 0;
            try {
                num = Integer.parseInt(t);
            } catch (NumberFormatException numberFormatException) {
                ErrorLogUtility.log(numberFormatException, Level.SEVERE, "[ProjectController]:Error retrieving technology types");
            }
            
          
            technology = new Technology();
            technology.setTechID(num);
            technologyList.add(technology);
        }
        
        // Add items to the project ( Any items that are not set are bound by Thymeleaf )
        project.setMilestoneList(milestoneList);
        project.setHyperlinkList(hyperlinkList);
        project.setStatID(ps);
        project.setProfID(pr);
        
        
        
        // Technology is a bit different.  Need to add 'projectList' back to the associated table to link.
        project.setTechnologyList(technologyList);
        projectList.add(project);
        technology.setProjectList(projectList);
        
        // Save the project ( Hiberate will insert into the associated tables )
        hibernateSession.save(project);
        hibernateSession.getTransaction().commit();
        
        // Return to the view
        String status = "You have successfully added a project";
        model.addAttribute("status", status);
        model.addAttribute("viewType", DashboardController.ViewTypes.DefaultView.toString());
        return "dashboard";
    }
    
    @RequestMapping(value = "/edit", method = RequestMethod.GET )
    public String editProject(Model model, Project project) {
    
        String status = "You have successfully edited your project";
        model.addAttribute("status", status);
        model.addAttribute("viewType", DashboardController.ViewTypes.DefaultView.toString());
        
        return "dashboard";
    }
    
}
