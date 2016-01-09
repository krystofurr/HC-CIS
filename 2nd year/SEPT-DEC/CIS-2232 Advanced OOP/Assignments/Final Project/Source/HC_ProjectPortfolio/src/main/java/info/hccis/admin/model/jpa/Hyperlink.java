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
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author krystofurr
 */
@Entity
@Table(name = "Hyperlinks")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hyperlink.findAll", query = "SELECT h FROM Hyperlink h")})
public class Hyperlink implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "hypID")
    private Integer hypID;
    @Size(max = 100)
    @Column(name = "link")
    private String link;
    @Size(max = 500)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "projID", referencedColumnName = "projID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Project projID;

    public Hyperlink() {
    }

    public Hyperlink(Integer hypID) {
        this.hypID = hypID;
    }

    public Integer getHypID() {
        return hypID;
    }

    public void setHypID(Integer hypID) {
        this.hypID = hypID;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Project getProjID() {
        return projID;
    }

    public void setProjID(Project projID) {
        this.projID = projID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hypID != null ? hypID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hyperlink)) {
            return false;
        }
        Hyperlink other = (Hyperlink) object;
        if ((this.hypID == null && other.hypID != null) || (this.hypID != null && !this.hypID.equals(other.hypID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "info.hccis.admin.model.jpa.Hyperlink[ hypID=" + hypID + " ]";
    }
    
}
