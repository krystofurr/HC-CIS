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
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "UserAccess")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserAccess.findAll", query = "SELECT u FROM UserAccess u")})
public class UserAccess implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "userAccessId")
    private Integer userAccessId;
    @Basic(optional = false)
    @NotNull
//    @NotEmpty(message="Please enter a username!")
    @Size(min = 1, max = 100)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
//    @NotEmpty(message="Please enter a password!")
    @Size(min = 1, max = 128)
    @Column(name = "password")
    private String password;
    @Column(name = "createdDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDateTime;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userAccessId")
    private List<Profile> profileList;
    @JoinColumn(name = "userTypeCode", referencedColumnName = "codeValueSequence")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private CodeValue userTypeCode;

    public UserAccess() {
    }

    public UserAccess(Integer userAccessId) {
        this.userAccessId = userAccessId;
    }

    public UserAccess(Integer userAccessId, String username, String password) {
        this.userAccessId = userAccessId;
        this.username = username;
        this.password = password;
    }

    public Integer getUserAccessId() {
        return userAccessId;
    }

    public void setUserAccessId(Integer userAccessId) {
        this.userAccessId = userAccessId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(Date createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    @XmlTransient
    public List<Profile> getProfileList() {
        return profileList;
    }

    public void setProfileList(List<Profile> profileList) {
        this.profileList = profileList;
    }

    public CodeValue getUserTypeCode() {
        return userTypeCode;
    }

    public void setUserTypeCode(CodeValue userTypeCode) {
        this.userTypeCode = userTypeCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userAccessId != null ? userAccessId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserAccess)) {
            return false;
        }
        UserAccess other = (UserAccess) object;
        if ((this.userAccessId == null && other.userAccessId != null) || (this.userAccessId != null && !this.userAccessId.equals(other.userAccessId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "info.hccis.admin.model.jpa.UserAccess[ userAccessId=" + userAccessId + " ]";
    }
    
}
