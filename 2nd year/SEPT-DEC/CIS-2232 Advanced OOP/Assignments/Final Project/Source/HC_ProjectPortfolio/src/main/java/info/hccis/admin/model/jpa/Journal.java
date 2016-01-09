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
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author krystofurr
 */
@Entity
@Table(name = "Journals")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Journal.findAll", query = "SELECT j FROM Journal j")})
public class Journal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "jourID")
    private Integer jourID;
    @Size(max = 45)
    @Column(name = "title")
    private String title;
    @Size(max = 2000)
    @Column(name = "body")
    private String body;
    @Column(name = "entryDate")
    private Integer entryDate;
    @JoinColumn(name = "mileID", referencedColumnName = "mileID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Milestone mileID;

    public Journal() {
    }

    public Journal(Integer jourID) {
        this.jourID = jourID;
    }

    public Integer getJourID() {
        return jourID;
    }

    public void setJourID(Integer jourID) {
        this.jourID = jourID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Integer getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Integer entryDate) {
        this.entryDate = entryDate;
    }

    public Milestone getMileID() {
        return mileID;
    }

    public void setMileID(Milestone mileID) {
        this.mileID = mileID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jourID != null ? jourID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Journal)) {
            return false;
        }
        Journal other = (Journal) object;
        if ((this.jourID == null && other.jourID != null) || (this.jourID != null && !this.jourID.equals(other.jourID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "info.hccis.admin.model.jpa.Journal[ jourID=" + jourID + " ]";
    }
    
}
