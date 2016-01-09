/*

========= CIS 2232 Advanced Object Oriented Programming PWC ==========
 ____            _           _     ____            _    __       _ _       
|  _ \ _ __ ___ (_) ___  ___| |_  |  _ \ ___  _ __| |_ / _| ___ | (_) ___  
| |_) | '__/ _ \| |/ _ \/ __| __| | |_) / _ \| '__| __| |_ / _ \| | |/ _ \ 
|  __/| | | (_) | |  __/ (__| |_  |  __/ (_) | |  | |_|  _| (_) | | | (_) |
|_|   |_|  \___// |\___|\___|\__| |_|   \___/|_|   \__|_|  \___/|_|_|\___/ 
              |__/                                                         

Project Members: Christopher Sigouin & Matthew Hutchinson

Date: November, 29 2015
Purpose: Final Project

*/
package info.hccis.admin.web;

import info.hccis.admin.model.jpa.Project;
import info.hccis.admin.model.jpa.ProjectStatus;
import info.hccis.admin.model.jpa.Technology;
import info.hccis.admin.model.jpa.UserAccess;
import info.hccis.admin.service.HyperlinkService;
import info.hccis.admin.service.MilestoneService;
import info.hccis.admin.service.ProjectService;
import info.hccis.admin.service.ProjectStatusService;
import info.hccis.admin.service.TechUsedService;
import info.hccis.admin.service.TechnologyService;
import info.hccis.admin.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *
 * @author krystofurr
 */

@Controller
@RequestMapping("/dashboard")
public class DashboardController {
    
    // Types of views in the dashboard
    public static enum ViewTypes { DefaultView, SingleView, MultiView, ProjectWizard, UserProfile, AboutUs };
    
    public final ProjectStatusService projectStatusService;
    private final ProjectService projectService;
    private final TechnologyService technologyService;
    private final MilestoneService milestoneService;
    private final TechUsedService techUsedService;
    private final HyperlinkService hyperlinkService;

    @Autowired
    public DashboardController(ProjectService projectService, TechnologyService technologyService, 
            ProjectStatusService projectStatusService, MilestoneService milestoneService, TechUsedService techUsedService, HyperlinkService hyperlinkService) 
    {
        this.projectStatusService = projectStatusService;
        this.projectService = projectService;
        this.technologyService = technologyService;
        this.milestoneService = milestoneService;
        this.techUsedService = techUsedService;
        this.hyperlinkService = hyperlinkService;
        
    }
    
    @RequestMapping(value = "/default")
    public String showSingleProjectView(Model model, HttpSession session) {
    
        model.addAttribute("viewType", ViewTypes.DefaultView.toString());
        return "dashboard";
    }


    @RequestMapping(value = "/singleView")
    public String showSingleProjectView(Model model, HttpSession session, HttpServletRequest request) {
        String id = request.getParameter("id");
        UserAccess user = (UserAccess)session.getAttribute("userToken");
        


        ArrayList<Project> projects = (ArrayList<Project>) projectService.getProjects(user.getUserAccessId());
        Project choice = new Project();
        for(Project project : projects){
            if(project.getProjID() == Integer.parseInt(id)){
                choice = project;
            }
        }
        
//        ArrayList<ProjectStatus> statusList = (ArrayList<ProjectStatus>) projectStatusService.getProjectStatuses();
//        ProjectStatus projectStatus =new ProjectStatus();
//        for(ProjectStatus status : statusList){
//            
//            if(status.getStatID() == choice.getStatID()){
//                projectStatus = status;
//            }
//        }
//        System.out.println("STATUS LIST 1: "+statusList.get(0).getDescription());
//        System.out.println("STATUS"+projectStatus.getDescription());
        
//        ArrayList<Hyperlink> linkList = (ArrayList<Hyperlink>) hyperlinkService.getHyperlinks();
//        ArrayList<Hyperlink> usedLinks =new ArrayList<Hyperlink>();
//        for(Hyperlink link : linkList){
//            if(link.getProjID().getProjID() == choice.getProjID()){
//                usedLinks.add(link);
//            }
//        }
        
        //ArrayList<Milestone> milestoneList = (ArrayList<Milestone>) milestoneService.findMilestonesByProjID(choice.getProjID());
        
       
        //THIS BE BUSTED
        //ArrayList<Milestone> milestones = (ArrayList<Milestone>) milestoneService.findMilestonesByProjID(choice.getProjID());
        
        
//        ArrayList<TechUsed> techUsed = (ArrayList<TechUsed>) techUsedService.getTechUsed(choice.getProjID());
//        ArrayList<Technology> technology = (ArrayList<Technology>)technologyService.getTechnologies();
//        ArrayList<Technology> projectTech = new ArrayList<Technology>();
//        
//        for(int x = 0; x < technology.size(); x++){
//            System.out.println(technology.get(x).getTechID());
//            
//            for(int y =0; y < techUsed.size(); y++){              
//                if(techUsed.get(y).getTechID() == technology.get(x).getTechID()){
//                projectTech.add(technology.get(x));
//                System.out.println(techUsed.get(y).getTechID());
//                System.out.println("NEW PROJECT TECH");
//            }
//            }           
//        }
//        System.out.println(projectTech.get(0).getLongDescription());
        
        
        //ADD THIS WHEN YOU FIX THE MILESTONE STUFF
        
        
        // Open a session with Hibernate and collect the values for the given project
        Session hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Project projectLazyLoaded = (Project) hibernateSession.load(Project.class, choice.getProjID());
        
        // Add all the values to the model
        model.addAttribute("tech",projectLazyLoaded.getTechnologyList());
        model.addAttribute("status", projectLazyLoaded.getStatID());
        model.addAttribute("project", choice);
        model.addAttribute("links", projectLazyLoaded.getHyperlinkList());
        model.addAttribute("milestones", projectLazyLoaded.getMilestoneList());
        model.addAttribute("viewType", ViewTypes.SingleView.toString());
        
        return "dashboard";
        
    }
    
    @RequestMapping(value = "/multiView")
    public String showMultiProjectView(Model model, HttpSession session) {
    
        UserAccess user = (UserAccess)session.getAttribute("userToken");
        
        List<Project> projects = projectService.getProjects(user.getUserAccessId());
        model.addAttribute("userProjects", projects);
        model.addAttribute("viewType", ViewTypes.MultiView.toString());
        model.addAttribute("isActive", true);

        return "dashboard";
    }
    
    @RequestMapping(value = "/externalView")
    public String showExternalProjectView(Model model, HttpSession session) {
        
        return "externalView";
    }

    @RequestMapping(value = "/userProfile")
    public String showUserProfileView(Model model, HttpSession session) {
    
        
        
        // Displays the fragment within the display area
        model.addAttribute("viewType", ViewTypes.UserProfile.toString());
        model.addAttribute("isActive", true);
        
        return "dashboard";
    }
    
    @RequestMapping(value = "/aboutUs")
    public String showAboutUsView(Model model, HttpSession session) {
    
        // Displays the fragment within the display area
        model.addAttribute("viewType", ViewTypes.AboutUs.toString());

        return "dashboard";
    }
    
    
    @RequestMapping(value = "/projectWizard")
    public String showProjectWizardView(Model model, HttpSession session) {
    
        // List of Technologies
        List<Technology> technologies = technologyService.getTechnologies();
        model.addAttribute("technologyList", technologies);
        // List of Project Statuses
        List<ProjectStatus> projectStatuses = projectStatusService.getProjectStatuses();
        model.addAttribute("projectStatusList", projectStatuses);
        // Add a new project to the model so Thymeleaf has a reference to it
        model.addAttribute("project", new Project());
        
        
        // Displays the fragment within the display area
        model.addAttribute("viewType", ViewTypes.ProjectWizard.toString());
        
        
 
        return "dashboard";
    }
    
    
    
}
