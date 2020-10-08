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
public class FooddetailPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "FOODID")
    private String foodid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "INGREDIENTID")
    private String ingredientid;

    public FooddetailPK() {
    }

    public FooddetailPK(String foodid, String ingredientid) {
        this.foodid = foodid;
        this.ingredientid = ingredientid;
    }

    public String getFoodid() {
        return foodid;
    }

    public void setFoodid(String foodid) {
        this.foodid = foodid;
    }

    public String getIngredientid() {
        return ingredientid;
    }

    public void setIngredientid(String ingredientid) {
        this.ingredientid = ingredientid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (foodid != null ? foodid.hashCode() : 0);
        hash += (ingredientid != null ? ingredientid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FooddetailPK)) {
            return false;
        }
        FooddetailPK other = (FooddetailPK) object;
        if ((this.foodid == null && other.foodid != null) || (this.foodid != null && !this.foodid.equals(other.foodid))) {
            return false;
        }
        if ((this.ingredientid == null && other.ingredientid != null) || (this.ingredientid != null && !this.ingredientid.equals(other.ingredientid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.FooddetailPK[ foodid=" + foodid + ", ingredientid=" + ingredientid + " ]";
    }
    
}
