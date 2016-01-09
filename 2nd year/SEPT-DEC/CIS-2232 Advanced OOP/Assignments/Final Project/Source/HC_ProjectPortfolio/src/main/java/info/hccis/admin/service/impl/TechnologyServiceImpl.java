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

import info.hccis.admin.data.springdatajpa.TechnologyRepository;
import info.hccis.admin.model.jpa.Technology;
import info.hccis.admin.service.TechnologyService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * 
 */
@Service
public class TechnologyServiceImpl implements TechnologyService {

    public final TechnologyRepository technologyRepository;
    
    @Autowired
    public TechnologyServiceImpl(TechnologyRepository technologyRepository) {
        this.technologyRepository = technologyRepository;
    }

    @Override
    public ArrayList<Technology> getTechnologies() {
        return (ArrayList<Technology>) technologyRepository.findAll();
    }

    @Override
    public Technology getTechnology(int techID) {
        return technologyRepository.findOne(techID);
    }
    
}
