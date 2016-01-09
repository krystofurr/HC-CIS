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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author krystofurr
 */
@Entity
@Table(name = "Profiles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profile.findAll", query = "SELECT p FROM Profile p")})
public class Profile implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "profID")
    private Integer profID;
    @Size(max = 50)
    @Column(name = "name")
    private String name;
    @Size(max = 1000)
    @Column(name = "biography")
    private String biography;
    @Column(name = "totalProjectsCompleted")
    private Integer totalProjectsCompleted;
    @Column(name = "totalProjectsInProgress")
    private Integer totalProjectsInProgress;
    @JoinTable(name = "TechLearned", joinColumns = {
        @JoinColumn(name = "profID", referencedColumnName = "profID")}, inverseJoinColumns = {
        @JoinColumn(name = "techID", referencedColumnName = "techID")})
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL) 
    private List<Technology> technologyList;
    @JoinColumn(name = "userAccessId", referencedColumnName = "userAccessId")
    @ManyToOne(fetch = FetchType.LAZY)
    private UserAccess userAccessId;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "profID")
    private List<Project> projectList;

    public Profile() {
    }

    public Profile(Integer profID) {
        this.profID = profID;
    }

    public Integer getProfID() {
        return profID;
    }

    public void setProfID(Integer profID) {
        this.profID = profID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public Integer getTotalProjectsCompleted() {
        return totalProjectsCompleted;
    }

    public void setTotalProjectsCompleted(Integer totalProjectsCompleted) {
        this.totalProjectsCompleted = totalProjectsCompleted;
    }

    public Integer getTotalProjectsInProgress() {
        return totalProjectsInProgress;
    }

    public void setTotalProjectsInProgress(Integer totalProjectsInProgress) {
        this.totalProjectsInProgress = totalProjectsInProgress;
    }

    @XmlTransient
    public List<Technology> getTechnologyList() {
        return technologyList;
    }

    public void setTechnologyList(List<Technology> technologyList) {
        this.technologyList = technologyList;
    }

    public UserAccess getUserAccessId() {
        return userAccessId;
    }

    public void setUserAccessId(UserAccess userAccessId) {
        this.userAccessId = userAccessId;
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
        hash += (profID != null ? profID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profile)) {
            return false;
        }
        Profile other = (Profile) object;
        if ((this.profID == null && other.profID != null) || (this.profID != null && !this.profID.equals(other.profID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "info.hccis.admin.model.jpa.Profile[ profID=" + profID + " ]";
    }
    
}
