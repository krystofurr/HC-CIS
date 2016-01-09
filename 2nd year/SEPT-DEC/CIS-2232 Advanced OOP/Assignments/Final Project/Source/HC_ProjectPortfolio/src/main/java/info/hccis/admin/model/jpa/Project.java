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
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author krystofurr
 */
@Entity
@Table(name = "Projects")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Project.findAll", query = "SELECT p FROM Project p")
    
})
public class Project implements Serializable {
    
    
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "projID")
    private Integer projID;
    @Size(max = 50)
    @Column(name = "name")
    private String name;
    @Size(max = 200)
    @Column(name = "description")
    private String description;
    @Size(max = 50)
    @Column(name = "position")
    private String position;
    @Column(name = "totalContributers")
    private Integer totalContributers;
    @JoinTable(name = "TechUsed", joinColumns = {
        @JoinColumn(name = "projID", referencedColumnName = "projID")}, inverseJoinColumns = {
        @JoinColumn(name = "techID", referencedColumnName = "techID")})
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Technology> technologyList;
    @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL, mappedBy = "projID")
    private List<Milestone> milestoneList;
    @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL, mappedBy = "projID")
    private List<Hyperlink> hyperlinkList;
    @JoinColumn(name = "profID", referencedColumnName = "profID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Profile profID;
    @JoinColumn(name = "statID", referencedColumnName = "statID")
    @ManyToOne(fetch = FetchType.LAZY)
    private ProjectStatus statID;

    public Project() {
    }

    public Project(Integer projID) {
        this.projID = projID;
    }

    public Integer getProjID() {
        return projID;
    }

    public void setProjID(Integer projID) {
        this.projID = projID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getTotalContributers() {
        return totalContributers;
    }

    public void setTotalContributers(Integer totalContributers) {
        this.totalContributers = totalContributers;
    }

    @XmlTransient
    public List<Technology> getTechnologyList() {
        return technologyList;
    }

    public void setTechnologyList(List<Technology> technologyList) {
        this.technologyList = technologyList;
    }

    @XmlTransient
    public List<Milestone> getMilestoneList() {
        return milestoneList;
    }

    public void setMilestoneList(List<Milestone> milestoneList) {
        this.milestoneList = milestoneList;
    }

    @XmlTransient
    public List<Hyperlink> getHyperlinkList() {
        return hyperlinkList;
    }

    public void setHyperlinkList(List<Hyperlink> hyperlinkList) {
        this.hyperlinkList = hyperlinkList;
    }

    public Profile getProfID() {
        return profID;
    }

    public void setProfID(Profile profID) {
        this.profID = profID;
    }

    public ProjectStatus getStatID() {
        return statID;
    }

    public void setStatID(ProjectStatus statID) {
        this.statID = statID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projID != null ? projID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Project)) {
            return false;
        }
        Project other = (Project) object;
        if ((this.projID == null && other.projID != null) || (this.projID != null && !this.projID.equals(other.projID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "info.hccis.admin.model.jpa.Project[ projID=" + projID + " ]";
    }
    
}
