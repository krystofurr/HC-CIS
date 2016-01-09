/*

 ========= CIS 2232 Advanced Object Oriented Programming PWC ==========
  ____            _           _     ____            _    __       _ _       
 |  _ \ _ __ ___ (_) ___  ___| |_  |  _ \ ___  _ __| |_ / _| ___ | (_) ___  
 | |_) | '__/ _ \| |/ _ \/ __| __| | |_) / _ \| '__| __| |_ / _ \| | |/ _ \ 
 |  __/| | | (_) | |  __/ (__| |_  |  __/ (_) | |  | |_|  _| (_) | | | (_) |
 |_|   |_|  \___// |\___|\___|\__| |_|   \___/|_|   \__|_|  \___/|_|_|\___/ 
                |__/                                                         

 Project Members: Christopher Sigouin & Matthew Hutchinson

 Date: 30-Nov-2015
 Purpose: Final Project

 */
package info.hccis.admin.web.services;

import info.hccis.admin.model.jpa.Project;
import info.hccis.admin.service.ProjectService;
import info.hccis.admin.service.UserAccessService;
import java.util.List;
import javax.annotation.Resource;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 *
 * @author krystofurr
 */
@Component
@Path("/projects")
@Scope("request") // THIS WILL CAUSE SERVLET TO CRASH IF COMMENTED
@Produces("application/json")
public class ProjectPortfolioRestService {

    @Resource
    private final UserAccessService userAccessService;
    private final ProjectService projectService;


    
    public ProjectPortfolioRestService(@Context ServletContext servletContext) {
        ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        
        this.projectService = applicationContext.getBean(ProjectService .class);
        this.userAccessService = applicationContext.getBean(UserAccessService .class);
    }
    
    @GET
    @Path("/get/{param}")
    // This will automatically call the Jackson JSON dependency when this method is called
    @Produces(MediaType.APPLICATION_JSON)
    public List<Project> getProjects(@PathParam("param") String username ) {
    
          return projectService.getProjects(username);
//        System.out.println("DELIVERABLE REST SERVICE: Getting all deliverables...");
//        List<Deliverable> deliverables = ds.getDeliverables();
//        
//        return deliverables;

    }
    
//    @POST
//    @Path("/average")
//    // This will automatically call the Jackson JSON dependency when this method is called
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response getMsg(ArrayList<Deliverable> deliverables) {
//
//        System.out.println("DELIVERABLE REST SERVICE: Calculating average... ");
//        String output = ds.calculateAverage(deliverables);
// 
//        return Response.status(200).entity(output).build();
//
//    }
    
}
