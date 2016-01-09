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
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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

/**
 *
 * @author krystofurr
 */
@Entity
@Table(name = "techused")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TechUsed.findAll", query = "SELECT t FROM TechUsed t")})
public class TechUsed implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "techID")
    private Integer techID;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "projID")
    private Integer projID;

    public Integer getProjID() {
        return projID;
    }

    public void setProjID(Integer projID) {
        this.projID = projID;
    }
    public TechUsed() {
    }

    public TechUsed(Integer techID) {
        this.techID = techID;
    }

    public Integer getTechID() {
        return techID;
    }

    public void setTechID(Integer techID) {
        this.techID = techID;
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
        if ((this.techID == null && other.getTechID() != null) || (this.techID != null && !this.techID.equals(other.getTechID()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "info.hccis.admin.model.jpa.Technology[ techID=" + techID + " ]";
    }
    
}
