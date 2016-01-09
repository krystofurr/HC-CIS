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

import info.hccis.admin.model.jpa.Profile;
import info.hccis.admin.model.jpa.UserAccess;
import info.hccis.admin.service.ProfileService;
import info.hccis.admin.service.UserAccessService;
import info.hccis.admin.util.ErrorLogUtility;
import info.hccis.admin.util.Utility;
import java.util.ResourceBundle;
import java.util.logging.Level;
import javax.servlet.http.HttpSession;
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
@RequestMapping("/login")
public class LoginController {
    
    public final static String CISADMIN_URL_LOGIN = "http://localhost:8080/cisadmin/rest/useraccess/";
    private final UserAccessService userAccessService;
    private final ProfileService profileService;
    
    
    @Autowired
    public LoginController(UserAccessService userAccessService, ProfileService profileService) {

        this.userAccessService = userAccessService;
        this.profileService = profileService;
    }
    
    /**
     * 
     * Authentication check for the login page
     * 
     * @param model
     * @param session
     * @param login
     * @param result
     * @return 
     */
    @RequestMapping(value = "/auth", method = RequestMethod.POST )
    public String authenticationCheck(Model model, HttpSession session, UserAccess login) {
        
//        // Get the database name for the URL from the data-access.properties file
//        String propFileName = "spring.data-access";
//        ResourceBundle rb = ResourceBundle.getBundle(propFileName);
//        String hostName = rb.getString("jdbc.dbname");
//        
//        /*
//        Hit the web service to see if valid credentials.
//        */
//        String urlString = CISADMIN_URL_LOGIN + hostName + "," + login.getUsername() + "," + login.getPassword();
//        System.out.println("url for validate=" + urlString);
//        
//        String result;
//        try {
//            result = Utility.getResponseFromRest(urlString);
//        } catch(Exception ex) {
//            ErrorLogUtility.log(ex, Level.SEVERE, "[LoginController]: Issue with REST service. Is CISADMIN running?");
//            return "login";
//        }
//
//        /*
//        if successful add token and return to welcome.  Otherwise back to the login.  
//        */
//        
//        System.out.println("USERNAME: " + login.getUsername());
//        System.out.println("PASSWORD: " + login.getPassword());
//        
//        
//  
//        if (!result.equals("0")) {
//            
//            // Store the user details
//            UserAccess user = userAccessService.getUser(login.getUsername());
//
//            // Get the profile data and store it
//            Profile userProfile = profileService.getUserProfile(user.getUserAccessId());
//            session.setAttribute("userProfile", userProfile);
//        
//            model.addAttribute("user", user);
//            session.setAttribute("userToken", user);
//            model.addAttribute("viewType", DashboardController.ViewTypes.DefaultView);            
//            return "dashboard";
//            
//        } else {
//            
//            model.addAttribute("message","Login failed");
//            return "login";
//        }
        
        return skipCisadminLogin(model, session, login);

    } // END: authenticationCheck
    
    
    
    private String skipCisadminLogin(Model model, HttpSession session, UserAccess login) {
        
        // Store the user details
        UserAccess user = new UserAccess();
        user.setUserAccessId(1);
        user.setUsername("Cisadmin Bypass");
        
        // Get the profile data and store it
        Profile userProfile = profileService.getUserProfile(user.getUserAccessId());
        session.setAttribute("userProfile", userProfile);
        
        
        model.addAttribute("user", user);
        session.setAttribute("userToken", user);
        model.addAttribute("viewType", DashboardController.ViewTypes.DefaultView);            
        return "dashboard";
        
    }
    
}
