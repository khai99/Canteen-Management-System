/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author vinso
 */
public class orderFood {
  private String ingredientID;
  private String ingredientName;
  private int totalGram;

    public orderFood(String ingredientID, String ingredientName, int totalGram) {
        this.ingredientID = ingredientID;
        this.ingredientName = ingredientName;
        this.totalGram = totalGram;
    }

    
    
    
    public String getIngredientID() {
        return ingredientID;
    }

    public void setIngredientID(String ingredientID) {
        this.ingredientID = ingredientID;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public int getTotalGram() {
        return totalGram;
    }

    public void setTotalGram(int totalGram) {
        this.totalGram = totalGram;
    }
}
