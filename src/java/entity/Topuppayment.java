/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vinso
 */
@Entity
@Table(name = "TOPUPPAYMENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Topuppayment.findAll", query = "SELECT t FROM Topuppayment t")
    , @NamedQuery(name = "Topuppayment.findByTopupid", query = "SELECT t FROM Topuppayment t WHERE t.topupid = :topupid")
    , @NamedQuery(name = "Topuppayment.findByTopupamount", query = "SELECT t FROM Topuppayment t WHERE t.topupamount = :topupamount")
    , @NamedQuery(name = "Topuppayment.findByTopupdate", query = "SELECT t FROM Topuppayment t WHERE t.topupdate = :topupdate")})
public class Topuppayment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "TOPUPID")
    private String topupid;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TOPUPAMOUNT")
    private Double topupamount;
    @Column(name = "TOPUPDATE")
    @Temporal(TemporalType.DATE)
    private Date topupdate;
    @JoinColumn(name = "CUSTID", referencedColumnName = "CUSTID")
    @ManyToOne(optional = false)
    private Customer custid;

    public Topuppayment() {
    }

    public Topuppayment(String topupid, Double amount,Date date , Customer custID){
        this.topupid = topupid;
        this.topupamount=amount;
        this.topupdate = date;
        this.custid = custID;
    
    }

    
    public Topuppayment(String topupid) {
        this.topupid = topupid;
    }

    public String getTopupid() {
        return topupid;
    }

    public void setTopupid(String topupid) {
        this.topupid = topupid;
    }

    public Double getTopupamount() {
        return topupamount;
    }

    public void setTopupamount(Double topupamount) {
        this.topupamount = topupamount;
    }

    public Date getTopupdate() {
        return topupdate;
    }

    public void setTopupdate(Date topupdate) {
        this.topupdate = topupdate;
    }

    public Customer getCustid() {
        return custid;
    }

    public void setCustid(Customer custid) {
        this.custid = custid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (topupid != null ? topupid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Topuppayment)) {
            return false;
        }
        Topuppayment other = (Topuppayment) object;
        if ((this.topupid == null && other.topupid != null) || (this.topupid != null && !this.topupid.equals(other.topupid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Topuppayment[ topupid=" + topupid + " ]";
    }
    
}
