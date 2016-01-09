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
package info.hccis.admin.service;

import info.hccis.admin.model.jpa.Project;
import info.hccis.admin.model.jpa.UserAccess;
import java.util.List;

/**
 *
 * @author krystofurr
 */

public interface ProjectService {
    
    // Get projects by user ID
    public abstract List<Project> getProjects(int userID);
    // Get projects by username ( Used for REST service )
    public abstract List<Project> getProjects(String username);
    
    public abstract void saveProject(Project project);
    
}
