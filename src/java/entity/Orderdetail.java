/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vinso
 */
@Entity
@Table(name = "ORDERDETAIL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orderdetail.findAll", query = "SELECT o FROM Orderdetail o")
    , @NamedQuery(name = "Orderdetail.findByOrderid", query = "SELECT o FROM Orderdetail o WHERE o.orderdetailPK.orderid = :orderid")
    , @NamedQuery(name = "Orderdetail.findByFoodid", query = "SELECT o FROM Orderdetail o WHERE o.orderdetailPK.foodid = :foodid")
    , @NamedQuery(name = "Orderdetail.findByQuantity", query = "SELECT o FROM Orderdetail o WHERE o.quantity = :quantity")})
public class Orderdetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrderdetailPK orderdetailPK;
    @Column(name = "QUANTITY")
    private Integer quantity;
    @JoinColumn(name = "FOODID", referencedColumnName = "FOODID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Food food;
    @JoinColumn(name = "ORDERID", referencedColumnName = "ORDERID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Orders orders;

    public Orderdetail() {
    }

    public Orderdetail(OrderdetailPK orderdetailPK) {
        this.orderdetailPK = orderdetailPK;
    }

    public Orderdetail(String orderid, String foodid) {
        this.orderdetailPK = new OrderdetailPK(orderid, foodid);
    }

    public OrderdetailPK getOrderdetailPK() {
        return orderdetailPK;
    }

    public void setOrderdetailPK(OrderdetailPK orderdetailPK) {
        this.orderdetailPK = orderdetailPK;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderdetailPK != null ? orderdetailPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orderdetail)) {
            return false;
        }
        Orderdetail other = (Orderdetail) object;
        if ((this.orderdetailPK == null && other.orderdetailPK != null) || (this.orderdetailPK != null && !this.orderdetailPK.equals(other.orderdetailPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Orderdetail[ orderdetailPK=" + orderdetailPK + " ]";
    }
    
}
