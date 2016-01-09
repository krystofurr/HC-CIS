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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "CodeValue")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CodeValue.findAll", query = "SELECT c FROM CodeValue c")})
public class CodeValue implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codeValueSequence")
    private Integer codeValueSequence;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "englishDescription")
    private String englishDescription;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "englishDescriptionShort")
    private String englishDescriptionShort;
    @Size(max = 100)
    @Column(name = "frenchDescription")
    private String frenchDescription;
    @Size(max = 20)
    @Column(name = "frenchDescriptionShort")
    private String frenchDescriptionShort;
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
    @JoinColumn(name = "codeTypeId", referencedColumnName = "codeTypeId")
    @ManyToOne(optional = false)
    private CodeType codeTypeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userTypeCode")
    private Collection<UserAccess> userAccessCollection;

    public CodeValue() {
    }

    public CodeValue(Integer codeValueSequence) {
        this.codeValueSequence = codeValueSequence;
    }

    public CodeValue(Integer codeValueSequence, String englishDescription, String englishDescriptionShort) {
        this.codeValueSequence = codeValueSequence;
        this.englishDescription = englishDescription;
        this.englishDescriptionShort = englishDescriptionShort;
    }

    public Integer getCodeValueSequence() {
        return codeValueSequence;
    }

    public void setCodeValueSequence(Integer codeValueSequence) {
        this.codeValueSequence = codeValueSequence;
    }

    public String getEnglishDescription() {
        return englishDescription;
    }

    public void setEnglishDescription(String englishDescription) {
        this.englishDescription = englishDescription;
    }

    public String getEnglishDescriptionShort() {
        return englishDescriptionShort;
    }

    public void setEnglishDescriptionShort(String englishDescriptionShort) {
        this.englishDescriptionShort = englishDescriptionShort;
    }

    public String getFrenchDescription() {
        return frenchDescription;
    }

    public void setFrenchDescription(String frenchDescription) {
        this.frenchDescription = frenchDescription;
    }

    public String getFrenchDescriptionShort() {
        return frenchDescriptionShort;
    }

    public void setFrenchDescriptionShort(String frenchDescriptionShort) {
        this.frenchDescriptionShort = frenchDescriptionShort;
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

    public CodeType getCodeTypeId() {
        return codeTypeId;
    }

    public void setCodeTypeId(CodeType codeTypeId) {
        this.codeTypeId = codeTypeId;
    }

    @XmlTransient
    public Collection<UserAccess> getUserAccessCollection() {
        return userAccessCollection;
    }

    public void setUserAccessCollection(Collection<UserAccess> userAccessCollection) {
        this.userAccessCollection = userAccessCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeValueSequence != null ? codeValueSequence.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CodeValue)) {
            return false;
        }
        CodeValue other = (CodeValue) object;
        if ((this.codeValueSequence == null && other.codeValueSequence != null) || (this.codeValueSequence != null && !this.codeValueSequence.equals(other.codeValueSequence))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "info.hccis.admin.model.jpa.CodeValue[ codeValueSequence=" + codeValueSequence + " ]";
    }
    
}
