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

package info.hccis.admin.data.springdatajpa;

import info.hccis.admin.model.jpa.Project;
import info.hccis.admin.model.jpa.TechUsed;
import info.hccis.admin.model.jpa.Technology;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author krystofurr
 */
@Repository
public interface TechUsedRepository extends CrudRepository<TechUsed, Integer>{

    @Query("SELECT t FROM TechUsed AS t WHERE t.projID = :projID")
    public abstract List<TechUsed> findTechUsedByProjID(@Param("projID") int projID);
}