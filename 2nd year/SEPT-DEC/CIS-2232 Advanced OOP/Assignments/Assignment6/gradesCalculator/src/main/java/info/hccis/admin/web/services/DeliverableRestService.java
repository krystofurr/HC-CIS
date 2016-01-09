package info.hccis.admin.web.services;

import info.hccis.admin.model.jpa.Deliverable;
import info.hccis.admin.service.DeliverableService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;

//issues here...
//http://www.scriptscoop.net/t/ba4553fde8ca/spring-autowired-classes-are-null-in-jersey-rest.html

/**
 * 
 *  USAGE: http://localhost:8080/cisadmin/rest/deliverables/get
 *  USAGE: http://localhost:8080/cisadmin/rest/deliverables/average/<ENCODED JSON STRING>
 * 
 * @author krystofurr
 */
@Component
@Path("/deliverables")
@Scope("request") // THIS WILL CAUSE SERVLET TO CRASH IF COMMENTED
@Produces("application/json")
public class DeliverableRestService {

    @Resource
    private final DeliverableService ds;


    
    public DeliverableRestService(@Context ServletContext servletContext) {
        ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        this.ds = applicationContext.getBean(DeliverableService .class);
    }
    
    @GET
    @Path("/get")
    // This will automatically call the Jackson JSON dependency when this method is called
    @Produces(MediaType.APPLICATION_JSON)
    public List<Deliverable> getDeliverables() {
    
        System.out.println("DELIVERABLE REST SERVICE: Getting all deliverables...");
        List<Deliverable> deliverables = ds.getDeliverables();
        
        return deliverables;

    }
    
    @POST
    @Path("/average")
    // This will automatically call the Jackson JSON dependency when this method is called
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getMsg(ArrayList<Deliverable> deliverables) {

        System.out.println("DELIVERABLE REST SERVICE: Calculating average... ");
        String output = ds.calculateAverage(deliverables);
 
        return Response.status(200).entity(output).build();

    }
    

}
