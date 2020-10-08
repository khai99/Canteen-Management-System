/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vinso
 */
@Entity
@Table(name = "CANTEENSTAFF")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Canteenstaff.findAll", query = "SELECT c FROM Canteenstaff c")
    , @NamedQuery(name = "Canteenstaff.findByStaffid", query = "SELECT c FROM Canteenstaff c WHERE c.staffid = :staffid")
    , @NamedQuery(name = "Canteenstaff.findByStaffpassword", query = "SELECT c FROM Canteenstaff c WHERE c.staffpassword = :staffpassword")
    , @NamedQuery(name = "Canteenstaff.findByStaffname", query = "SELECT c FROM Canteenstaff c WHERE c.staffname = :staffname")
    , @NamedQuery(name = "Canteenstaff.findByStaffphoneno", query = "SELECT c FROM Canteenstaff c WHERE c.staffphoneno = :staffphoneno")
    , @NamedQuery(name = "Canteenstaff.findByStaffpost", query = "SELECT c FROM Canteenstaff c WHERE c.staffpost = :staffpost")
    , @NamedQuery(name = "Canteenstaff.findByStaffic", query = "SELECT c FROM Canteenstaff c WHERE c.staffic = :staffic")
    , @NamedQuery(name = "Canteenstaff.findByStaffgender", query = "SELECT c FROM Canteenstaff c WHERE c.staffgender = :staffgender")
    , @NamedQuery(name = "Canteenstaff.findByStaffage", query = "SELECT c FROM Canteenstaff c WHERE c.staffage = :staffage")})
public class Canteenstaff implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "STAFFID")
    private String staffid;
    @Size(max = 20)
    @Column(name = "STAFFPASSWORD")
    private String staffpassword;
    @Size(max = 50)
    @Column(name = "STAFFNAME")
    private String staffname;
    @Size(max = 12)
    @Column(name = "STAFFPHONENO")
    private String staffphoneno;
    @Size(max = 10)
    @Column(name = "STAFFPOST")
    private String staffpost;
    @Size(max = 12)
    @Column(name = "STAFFIC")
    private String staffic;
    @Column(name = "STAFFGENDER")
    private Character staffgender;
    @Column(name = "STAFFAGE")
    private Integer staffage;

    public Canteenstaff() {
    }

    public Canteenstaff(String staffid) {
        this.staffid = staffid;
    }

    public String getStaffid() {
        return staffid;
    }

    public void setStaffid(String staffid) {
        this.staffid = staffid;
    }

    public String getStaffpassword() {
        return staffpassword;
    }

    public void setStaffpassword(String staffpassword) {
        this.staffpassword = staffpassword;
    }

    public String getStaffname() {
        return staffname;
    }

    public void setStaffname(String staffname) {
        this.staffname = staffname;
    }

    public String getStaffphoneno() {
        return staffphoneno;
    }

    public void setStaffphoneno(String staffphoneno) {
        this.staffphoneno = staffphoneno;
    }

    public String getStaffpost() {
        return staffpost;
    }

    public void setStaffpost(String staffpost) {
        this.staffpost = staffpost;
    }

    public String getStaffic() {
        return staffic;
    }

    public void setStaffic(String staffic) {
        this.staffic = staffic;
    }

    public Character getStaffgender() {
        return staffgender;
    }

    public void setStaffgender(Character staffgender) {
        this.staffgender = staffgender;
    }

    public Integer getStaffage() {
        return staffage;
    }

    public void setStaffage(Integer staffage) {
        this.staffage = staffage;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (staffid != null ? staffid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Canteenstaff)) {
            return false;
        }
        Canteenstaff other = (Canteenstaff) object;
        if ((this.staffid == null && other.staffid != null) || (this.staffid != null && !this.staffid.equals(other.staffid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Canteenstaff[ staffid=" + staffid + " ]";
    }
    
}
