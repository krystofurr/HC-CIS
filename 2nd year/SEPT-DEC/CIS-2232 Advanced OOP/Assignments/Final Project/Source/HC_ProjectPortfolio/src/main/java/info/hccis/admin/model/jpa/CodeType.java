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
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author krystofurr
 */
@Entity
@Table(name = "CodeType")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CodeType.findAll", query = "SELECT c FROM CodeType c")})
public class CodeType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codeTypeId")
    private Integer codeTypeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "englishDescription")
    private String englishDescription;
    @Size(max = 100)
    @Column(name = "frenchDescription")
    private String frenchDescription;
    @Column(name = "createdDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDateTime;
    @Size(max = 20)
    @Column(name = "createdUserId")
    private String createdUserId;
    @Column(name = "updatedDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDateTime;
    @Size(max = 20)
    @Column(name = "updatedUserId")
    private String updatedUserId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codeTypeId")
    private Collection<CodeValue> codeValueCollection;

    public CodeType() {
    }

    public CodeType(Integer codeTypeId) {
        this.codeTypeId = codeTypeId;
    }

    public CodeType(Integer codeTypeId, String englishDescription) {
        this.codeTypeId = codeTypeId;
        this.englishDescription = englishDescription;
    }

    public Integer getCodeTypeId() {
        return codeTypeId;
    }

    public void setCodeTypeId(Integer codeTypeId) {
        this.codeTypeId = codeTypeId;
    }

    public String getEnglishDescription() {
        return englishDescription;
    }

    public void setEnglishDescription(String englishDescription) {
        this.englishDescription = englishDescription;
    }

    public String getFrenchDescription() {
        return frenchDescription;
    }

    public void setFrenchDescription(String frenchDescription) {
        this.frenchDescription = frenchDescription;
    }

    public Date getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(Date createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public String getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(String createdUserId) {
        this.createdUserId = createdUserId;
    }

    public Date getUpdatedDateTime() {
        return updatedDateTime;
    }

    public void setUpdatedDateTime(Date updatedDateTime) {
        this.updatedDateTime = updatedDateTime;
    }

    public String getUpdatedUserId() {
        return updatedUserId;
    }

    public void setUpdatedUserId(String updatedUserId) {
        this.updatedUserId = updatedUserId;
    }

    @XmlTransient
    public Collection<CodeValue> getCodeValueCollection() {
        return codeValueCollection;
    }

    public void setCodeValueCollection(Collection<CodeValue> codeValueCollection) {
        this.codeValueCollection = codeValueCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeTypeId != null ? codeTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CodeType)) {
            return false;
        }
        CodeType other = (CodeType) object;
        if ((this.codeTypeId == null && other.codeTypeId != null) || (this.codeTypeId != null && !this.codeTypeId.equals(other.codeTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "info.hccis.admin.model.jpa.CodeType[ codeTypeId=" + codeTypeId + " ]";
    }
    
}
