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
@Table(name = "FOODDETAIL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fooddetail.findAll", query = "SELECT f FROM Fooddetail f")
    , @NamedQuery(name = "Fooddetail.findByFoodid", query = "SELECT f FROM Fooddetail f WHERE f.fooddetailPK.foodid = :foodid")
    , @NamedQuery(name = "Fooddetail.findByIngredientid", query = "SELECT f FROM Fooddetail f WHERE f.fooddetailPK.ingredientid = :ingredientid")
    , @NamedQuery(name = "Fooddetail.findByIngredientgram", query = "SELECT f FROM Fooddetail f WHERE f.ingredientgram = :ingredientgram")})
public class Fooddetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FooddetailPK fooddetailPK;
    @Column(name = "INGREDIENTGRAM")
    private Integer ingredientgram;
    @JoinColumn(name = "FOODID", referencedColumnName = "FOODID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Food food;
    @JoinColumn(name = "INGREDIENTID", referencedColumnName = "INGREDIENTID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ingredient ingredient;

    public Fooddetail() {
    }

    public Fooddetail(FooddetailPK fooddetailPK) {
        this.fooddetailPK = fooddetailPK;
    }

    public Fooddetail(String foodid, String ingredientid) {
        this.fooddetailPK = new FooddetailPK(foodid, ingredientid);
    }

    public FooddetailPK getFooddetailPK() {
        return fooddetailPK;
    }

    public void setFooddetailPK(FooddetailPK fooddetailPK) {
        this.fooddetailPK = fooddetailPK;
    }

    public Integer getIngredientgram() {
        return ingredientgram;
    }

    public void setIngredientgram(Integer ingredientgram) {
        this.ingredientgram = ingredientgram;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fooddetailPK != null ? fooddetailPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fooddetail)) {
            return false;
        }
        Fooddetail other = (Fooddetail) object;
        if ((this.fooddetailPK == null && other.fooddetailPK != null) || (this.fooddetailPK != null && !this.fooddetailPK.equals(other.fooddetailPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Fooddetail[ fooddetailPK=" + fooddetailPK + " ]";
    }
    
}
