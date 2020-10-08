/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author vinso
 */
@Embeddable
public class OrderdetailPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "ORDERID")
    private String orderid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "FOODID")
    private String foodid;

    public OrderdetailPK() {
    }

    public OrderdetailPK(String orderid, String foodid) {
        this.orderid = orderid;
        this.foodid = foodid;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getFoodid() {
        return foodid;
    }

    public void setFoodid(String foodid) {
        this.foodid = foodid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderid != null ? orderid.hashCode() : 0);
        hash += (foodid != null ? foodid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderdetailPK)) {
            return false;
        }
        OrderdetailPK other = (OrderdetailPK) object;
        if ((this.orderid == null && other.orderid != null) || (this.orderid != null && !this.orderid.equals(other.orderid))) {
            return false;
        }
        if ((this.foodid == null && other.foodid != null) || (this.foodid != null && !this.foodid.equals(other.foodid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.OrderdetailPK[ orderid=" + orderid + ", foodid=" + foodid + " ]";
    }
    
}
