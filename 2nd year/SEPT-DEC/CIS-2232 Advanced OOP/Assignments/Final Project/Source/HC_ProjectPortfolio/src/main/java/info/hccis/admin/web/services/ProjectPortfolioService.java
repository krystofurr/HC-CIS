/*
 * ========= CIS 2232 Advanced Object Oriented Programming PWC ==========
 * NAME: Christopher Sigouin
 * DATE: 17-Nov-2015
 * PURPOSE: 
 */
package info.hccis.admin.web.services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import org.springframework.stereotype.Service;

/**
 *
 * @author krystofurr
 */
@Service
@WebService(serviceName="ProjectPortfolioService")
public class ProjectPortfolioService {
    
    @WebMethod(operationName="hello")
    public String hello(@WebParam(name="name") String txt ) {
        
        return txt;
    }
    
}
