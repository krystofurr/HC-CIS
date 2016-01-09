/*
 * ========= CIS 2232 Advanced Object Oriented Programming PWC ==========
 * NAME: Christopher Sigouin
 * DATE: 16-Dec-2015
 * PURPOSE: 
 */
package info.hccis.admin.web.services;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author krystofurr
 */
@WebService(serviceName = "NewWebService")
public class NewWebService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "test") String txt) {
        return "Hello " + txt + " !";
    }
}
