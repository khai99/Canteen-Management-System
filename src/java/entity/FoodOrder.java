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
public class FoodOrder {
    private String foodID;
    private String foodName;
    private double foodprice;
    private int foodquantity;

    public FoodOrder(String foodID, String foodName, double foodprice, int foodquantity) {
        this.foodID = foodID;
        this.foodName = foodName;
        this.foodprice = foodprice;
        this.foodquantity = foodquantity;
    }

    public int getFoodquantity() {
        return foodquantity;
    }

    public void setFoodquantity(int foodquantity) {
        this.foodquantity = foodquantity;
    }
    

 
    public String getFoodID() {
        return foodID;
    }

    public void setFoodID(String foodID) {
        this.foodID = foodID;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public double getFoodprice() {
        return foodprice;
    }

    public void setFoodprice(double foodprice) {
        this.foodprice = foodprice;
    }
    
    
    
    
    
    
}