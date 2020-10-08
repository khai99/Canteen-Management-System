/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author vinso
 */
@Entity
@Table(name = "CUSTOMER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c")
    , @NamedQuery(name = "Customer.findByCustid", query = "SELECT c FROM Customer c WHERE c.custid = :custid")
    , @NamedQuery(name = "Customer.findByCustpassword", query = "SELECT c FROM Customer c WHERE c.custpassword = :custpassword")
    , @NamedQuery(name = "Customer.findByCustemail", query = "SELECT c FROM Customer c WHERE c.custemail = :custemail")
    , @NamedQuery(name = "Customer.findByCustname", query = "SELECT c FROM Customer c WHERE c.custname = :custname")
    , @NamedQuery(name = "Customer.findByCusttype", query = "SELECT c FROM Customer c WHERE c.custtype = :custtype")
    , @NamedQuery(name = "Customer.findByCustic", query = "SELECT c FROM Customer c WHERE c.custic = :custic")
    , @NamedQuery(name = "Customer.findByCustgender", query = "SELECT c FROM Customer c WHERE c.custgender = :custgender")
    , @NamedQuery(name = "Customer.findByCustage", query = "SELECT c FROM Customer c WHERE c.custage = :custage")
    , @NamedQuery(name = "Customer.findByCustphoneno", query = "SELECT c FROM Customer c WHERE c.custphoneno = :custphoneno")
    , @NamedQuery(name = "Customer.findByCreditpoint", query = "SELECT c FROM Customer c WHERE c.creditpoint = :creditpoint")})
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "CUSTID")
    private String custid;
    @Size(max = 20)
    @Column(name = "CUSTPASSWORD")
    private String custpassword;
    @Size(max = 40)
    @Column(name = "CUSTEMAIL")
    private String custemail;
    @Size(max = 50)
    @Column(name = "CUSTNAME")
    private String custname;
    @Size(max = 8)
    @Column(name = "CUSTTYPE")
    private String custtype;
    @Size(max = 12)
    @Column(name = "CUSTIC")
    private String custic;
    @Column(name = "CUSTGENDER")
    private Character custgender;
    @Column(name = "CUSTAGE")
    private Integer custage;
    @Size(max = 12)
    @Column(name = "CUSTPHONENO")
    private String custphoneno;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CREDITPOINT")
    private Double creditpoint;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "custid")
    private List<Orders> ordersList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "custid")
    private List<Topuppayment> topuppaymentList;

    public Customer(String custid, String custpassword, String custemail, String custname, String custtype, String custic, Character custgender, Integer custage, Double creditpoint) {
        this.custid = custid;
        this.custpassword = custpassword;
        this.custemail = custemail;
        this.custname = custname;
        this.custtype = custtype;
        this.custic = custic;
        this.custgender = custgender;
        this.custage = custage;
        this.creditpoint = creditpoint;
    }

    
    
    public Customer() {
    }

    public Customer(String custid) {
        this.custid = custid;
    }

    public String getCustid() {
        return custid;
    }

    public void setCustid(String custid) {
        this.custid = custid;
    }

    public String getCustpassword() {
        return custpassword;
    }

    public void setCustpassword(String custpassword) {
        this.custpassword = custpassword;
    }

    public String getCustemail() {
        return custemail;
    }

    public void setCustemail(String custemail) {
        this.custemail = custemail;
    }

    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname;
    }

    public String getCusttype() {
        return custtype;
    }

    public void setCusttype(String custtype) {
        this.custtype = custtype;
    }

    public String getCustic() {
        return custic;
    }

    public void setCustic(String custic) {
        this.custic = custic;
    }

    public Character getCustgender() {
        return custgender;
    }

    public void setCustgender(Character custgender) {
        this.custgender = custgender;
    }

    public Integer getCustage() {
        return custage;
    }

    public void setCustage(Integer custage) {
        this.custage = custage;
    }

    public String getCustphoneno() {
        return custphoneno;
    }

    public void setCustphoneno(String custphoneno) {
        this.custphoneno = custphoneno;
    }

    public Double getCreditpoint() {
        return creditpoint;
    }

    public void setCreditpoint(Double creditpoint) {
        this.creditpoint = creditpoint;
    }

    @XmlTransient
    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }

    @XmlTransient
    public List<Topuppayment> getTopuppaymentList() {
        return topuppaymentList;
    }

    public void setTopuppaymentList(List<Topuppayment> topuppaymentList) {
        this.topuppaymentList = topuppaymentList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (custid != null ? custid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.custid == null && other.custid != null) || (this.custid != null && !this.custid.equals(other.custid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Customer[ custid=" + custid + " ]";
    }
    
}
