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
package info.hccis.admin.model.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author krystofurr
 */
@Entity
@Table(name = "Technologies")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Technology.findAll", query = "SELECT t FROM Technology t")})
public class Technology implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "techID")
    private Integer techID;
    @Size(max = 50)
    @Column(name = "shortDescription")
    private String shortDescription;
    @Size(max = 100)
    @Column(name = "longDescription")
    private String longDescription;
    // Non-owning side
    
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "technologyList")
    
    private List<Profile> profileList;
    // Non-owning side
    
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "technologyList")
    private List<Project> projectList;

    public Technology() {
    }

    public Technology(Integer techID) {
        this.techID = techID;
    }

    public Integer getTechID() {
        return techID;
    }

    public void setTechID(Integer techID) {
        this.techID = techID;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    @XmlTransient
    public List<Profile> getProfileList() {
        return profileList;
    }
    
    public void setProfileList(List<Profile> profileList) {
        this.profileList = profileList;
    }

    @XmlTransient
    
    public List<Project> getProjectList() {
        return projectList;
    }

    
    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (techID != null ? techID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Technology)) {
            return false;
        }
        Technology other = (Technology) object;
        if ((this.techID == null && other.techID != null) || (this.techID != null && !this.techID.equals(other.techID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "info.hccis.admin.model.jpa.Technology[ techID=" + techID + " ]";
    }
    
}
