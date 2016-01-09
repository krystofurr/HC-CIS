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
@Table(name = "Milestones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Milestone.findAll", query = "SELECT m FROM Milestone m")})
public class Milestone implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mileID")
    private Integer mileID;
    @Size(max = 500)
    @Column(name = "description")
    private String description;
    @Column(name = "startDate")
    private Long startDate;
    @Column(name = "endDate")
    private Long endDate;
    @JoinColumn(name = "projID", referencedColumnName = "projID")
    @ManyToOne(fetch=FetchType.LAZY)
    private Project projID;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "mileID")
    private List<Journal> journalList;

    public Milestone() {
    }

    public Milestone(Integer mileID) {
        this.mileID = mileID;
    }

    public Integer getMileID() {
        return mileID;
    }

    public void setMileID(Integer mileID) {
        this.mileID = mileID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getStartDate() {
        return startDate;
    }

    public void setStartDate(Long startDate) {
        this.startDate = startDate;
    }

    public Long getEndDate() {
        return endDate;
    }

    public void setEndDate(Long endDate) {
        this.endDate = endDate;
    }

    public Project getProjID() {
        return projID;
    }

    public void setProjID(Project projID) {
        this.projID = projID;
    }

    @XmlTransient
    public List<Journal> getJournalList() {
        return journalList;
    }

    public void setJournalList(List<Journal> journalList) {
        this.journalList = journalList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mileID != null ? mileID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Milestone)) {
            return false;
        }
        Milestone other = (Milestone) object;
        if ((this.mileID == null && other.mileID != null) || (this.mileID != null && !this.mileID.equals(other.mileID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "info.hccis.admin.model.jpa.Milestone[ mileID=" + mileID + " ]";
    }
    
}
