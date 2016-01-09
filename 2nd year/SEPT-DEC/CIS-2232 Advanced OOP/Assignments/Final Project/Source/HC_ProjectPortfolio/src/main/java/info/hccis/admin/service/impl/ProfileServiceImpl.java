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
package info.hccis.admin.service.impl;

import info.hccis.admin.data.springdatajpa.ProfileRepository;
import info.hccis.admin.model.jpa.Profile;
import info.hccis.admin.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author krystofurr
 */
@Service
public class ProfileServiceImpl implements ProfileService {

    public final ProfileRepository profileRepo;

        
    @Autowired
    public ProfileServiceImpl( ProfileRepository profileRepo ) {
        this.profileRepo = profileRepo;

    }
    
    @Override
    public Profile getUserProfile(int userID) {
        return profileRepo.findOne(userID);
    }
    
    
    
}
