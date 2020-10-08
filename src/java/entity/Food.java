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
@Table(name = "FOOD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Food.findAll", query = "SELECT f FROM Food f")
    , @NamedQuery(name = "Food.findByFoodid", query = "SELECT f FROM Food f WHERE f.foodid = :foodid")
    , @NamedQuery(name = "Food.findByFoodname", query = "SELECT f FROM Food f WHERE f.foodname = :foodname")
    , @NamedQuery(name = "Food.findByFoodprice", query = "SELECT f FROM Food f WHERE f.foodprice = :foodprice")
    , @NamedQuery(name = "Food.findByFooddesc", query = "SELECT f FROM Food f WHERE f.fooddesc = :fooddesc")
    , @NamedQuery(name = "Food.findByFoodtype", query = "SELECT f FROM Food f WHERE f.foodtype = :foodtype")
    , @NamedQuery(name = "Food.findByFoodcalories", query = "SELECT f FROM Food f WHERE f.foodcalories = :foodcalories")
    , @NamedQuery(name = "Food.findByFoodimg", query = "SELECT f FROM Food f WHERE f.foodimg = :foodimg")
    , @NamedQuery(name = "Food.findByFoodstatus", query = "SELECT f FROM Food f WHERE f.foodstatus = :foodstatus")})
public class Food implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "FOODID")
    private String foodid;
    @Size(max = 30)
    @Column(name = "FOODNAME")
    private String foodname;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "FOODPRICE")
    private Double foodprice;
    @Size(max = 300)
    @Column(name = "FOODDESC")
    private String fooddesc;
    @Size(max = 15)
    @Column(name = "FOODTYPE")
    private String foodtype;
    @Column(name = "FOODCALORIES")
    private Integer foodcalories;
    @Size(max = 300)
    @Column(name = "FOODIMG")
    private String foodimg;
    @Size(max = 15)
    @Column(name = "FOODSTATUS")
    private String foodstatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "food")
    private List<Fooddetail> fooddetailList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "food")
    private List<Orderdetail> orderdetailList;

    public Food() {
    }

    public Food(String foodid, String foodname, double foodprice, int foodcalories,String foodimg, String fooddesc, String foodstatus, String foodtype ){
    this.foodid = foodid;
    this.foodname = foodname;
    this.foodprice = foodprice;
    this.foodcalories= foodcalories;
    this.foodimg = foodimg;
    this.fooddesc = fooddesc;
    this.foodstatus=foodstatus;
    this.foodtype=foodtype;
    }
    
    public Food(String foodid) {
        this.foodid = foodid;
    }

    public String getFoodid() {
        return foodid;
    }

    public void setFoodid(String foodid) {
        this.foodid = foodid;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public Double getFoodprice() {
        return foodprice;
    }

    public void setFoodprice(Double foodprice) {
        this.foodprice = foodprice;
    }

    public String getFooddesc() {
        return fooddesc;
    }

    public void setFooddesc(String fooddesc) {
        this.fooddesc = fooddesc;
    }

    public String getFoodtype() {
        return foodtype;
    }

    public void setFoodtype(String foodtype) {
        this.foodtype = foodtype;
    }

    public Integer getFoodcalories() {
        return foodcalories;
    }

    public void setFoodcalories(Integer foodcalories) {
        this.foodcalories = foodcalories;
    }

    public String getFoodimg() {
        return foodimg;
    }

    public void setFoodimg(String foodimg) {
        this.foodimg = foodimg;
    }

    public String getFoodstatus() {
        return foodstatus;
    }

    public void setFoodstatus(String foodstatus) {
        this.foodstatus = foodstatus;
    }

    @XmlTransient
    public List<Fooddetail> getFooddetailList() {
        return fooddetailList;
    }

    public void setFooddetailList(List<Fooddetail> fooddetailList) {
        this.fooddetailList = fooddetailList;
    }

    @XmlTransient
    public List<Orderdetail> getOrderdetailList() {
        return orderdetailList;
    }

    public void setOrderdetailList(List<Orderdetail> orderdetailList) {
        this.orderdetailList = orderdetailList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (foodid != null ? foodid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Food)) {
            return false;
        }
        Food other = (Food) object;
        if ((this.foodid == null && other.foodid != null) || (this.foodid != null && !this.foodid.equals(other.foodid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Food[ foodid=" + foodid + " ]";
    }
    
}
