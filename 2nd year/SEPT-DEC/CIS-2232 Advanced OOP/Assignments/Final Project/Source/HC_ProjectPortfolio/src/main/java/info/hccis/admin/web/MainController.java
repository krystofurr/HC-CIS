
package info.hccis.admin.web;

import info.hccis.admin.model.jpa.UserAccess;
import info.hccis.admin.util.ErrorLogUtility;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author krystofurr
 */
@Controller
public class MainController {
    
    // Used for console messages
    public final static String LOG_NAME = "[ MAIN CONTROLLER ]:";

    
    /**
     *  
     * STARTING POINT OF THE APPLICATION HERE
     * 
     * 
     * @param model
     * @param request
     * @param session
     * @return 
     */
    @RequestMapping("/")
    public String showHome(Model model, HttpServletRequest request, HttpSession session) {
        
        System.out.println( LOG_NAME + " Entry point for HC_ProjectPortfolio");
        
        
        
        
        // Check for a user session and remove it
        if( session.getAttribute("userToken") != null ) {
            System.out.println( LOG_NAME + " Session for " + 
                    session.getAttribute("userToken").toString() + " has been removed");
            request.getSession().removeAttribute("userToken");

        }

        model.addAttribute("login", new UserAccess());
       
        
        return "login";
    }

    
}
