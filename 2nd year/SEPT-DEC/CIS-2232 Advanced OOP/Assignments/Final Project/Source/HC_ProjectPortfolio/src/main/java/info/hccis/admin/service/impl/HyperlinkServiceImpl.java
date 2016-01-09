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

import info.hccis.admin.data.springdatajpa.HyperlinkRepository;
import info.hccis.admin.model.jpa.Hyperlink;
import info.hccis.admin.service.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author krystofurr
 */
@Service
public class HyperlinkServiceImpl implements HyperlinkService {

    public final HyperlinkRepository hyperlinkRepo;
    
    @Autowired
    public HyperlinkServiceImpl( HyperlinkRepository hyperlinkRepo ) {
        this.hyperlinkRepo = hyperlinkRepo;

    }
    @Override
    public List<Hyperlink> getHyperlinks() {
        return (List<Hyperlink>) hyperlinkRepo.findAll();
    }
    
}
