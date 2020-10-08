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
@Table(name = "INGREDIENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ingredient.findAll", query = "SELECT i FROM Ingredient i")
    , @NamedQuery(name = "Ingredient.findByIngredientid", query = "SELECT i FROM Ingredient i WHERE i.ingredientid = :ingredientid")
    , @NamedQuery(name = "Ingredient.findByIngredientname", query = "SELECT i FROM Ingredient i WHERE i.ingredientname = :ingredientname")})
public class Ingredient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "INGREDIENTID")
    private String ingredientid;
    @Size(max = 30)
    @Column(name = "INGREDIENTNAME")
    private String ingredientname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ingredient")
    private List<Fooddetail> fooddetailList;

    public Ingredient() {
    }

     public Ingredient(String ingredientid, String ingredientname){
    this.ingredientid=ingredientid;
    this.ingredientname=ingredientname;
  
    }

    
    public Ingredient(String ingredientid) {
        this.ingredientid = ingredientid;
    }

    public String getIngredientid() {
        return ingredientid;
    }

    public void setIngredientid(String ingredientid) {
        this.ingredientid = ingredientid;
    }

    public String getIngredientname() {
        return ingredientname;
    }

    public void setIngredientname(String ingredientname) {
        this.ingredientname = ingredientname;
    }

    @XmlTransient
    public List<Fooddetail> getFooddetailList() {
        return fooddetailList;
    }

    public void setFooddetailList(List<Fooddetail> fooddetailList) {
        this.fooddetailList = fooddetailList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ingredientid != null ? ingredientid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ingredient)) {
            return false;
        }
        Ingredient other = (Ingredient) object;
        if ((this.ingredientid == null && other.ingredientid != null) || (this.ingredientid != null && !this.ingredientid.equals(other.ingredientid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Ingredient[ ingredientid=" + ingredientid + " ]";
    }
    
}
