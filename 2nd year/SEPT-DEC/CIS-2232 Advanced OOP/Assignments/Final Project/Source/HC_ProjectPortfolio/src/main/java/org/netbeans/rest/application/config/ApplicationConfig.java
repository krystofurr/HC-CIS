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
package org.netbeans.rest.application.config;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author krystofurr
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(info.hccis.admin.web.services.ProjectPortfolioRestService.class);
        resources.add(org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider.class);
        resources.add(org.codehaus.jackson.jaxrs.JacksonJsonProvider.class);
        resources.add(org.codehaus.jackson.jaxrs.JsonMappingExceptionMapper.class);
        resources.add(org.codehaus.jackson.jaxrs.JsonParseExceptionMapper.class);
    }
    
}
