/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Food;
import entity.Fooddetail;
import entity.Ingredient;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 *
 * @author vinso
 */
public class addFood extends HttpServlet {
@PersistenceContext EntityManager em;
    @Resource UserTransaction utx;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet addFood</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addFood at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         //generate ID
     List<Food> foodList = em.createNamedQuery("Food.findAll").getResultList();
     int foodSize = foodList.size() + 1;
     String foodID = "F" + String.format("%05d", foodSize);
     
     List<Ingredient> ingreAll = em.createNamedQuery("Ingredient.findAll").getResultList();
     
     String[] ingre = request.getParameterValues("ingredientSelect");
                
      List<Food> foodValidate = em.createNamedQuery("Food.findAll").getResultList();
      int check = 0;
      int checker = 0;
      int grams = 0;
     String foodName = request.getParameter("foodName");
     double foodPrice = Double.parseDouble(request.getParameter("foodPrice"));
     int foodCalories = Integer.parseInt(request.getParameter("foodCalories"));
     String foodImg = request.getParameter("foodImg");
     String foodDescription = request.getParameter("description");
     String foodStatus = request.getParameter("foodStatus");
     String foodType = request.getParameter("foodType");
     
 
     
        for(int i = 0; i < foodValidate.size();i++){
         if(foodName.equalsIgnoreCase(foodValidate.get(i).getFoodname())){
              check = 1;
         }
        
        }
        int checkIngre = 0;
        if(ingre == null){
         checkIngre = 1;
            
        }
        
        int checkImg = 0;
        for(int x = 0; x < foodValidate.size(); x++){
        if(foodImg.equals(foodValidate.get(x).getFoodimg())){
          checkImg = 1;
        }
        
        }
        
        if(checkImg == 1){
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<script>");
            out.println("alert('Same Image being used')");
            out.println("location='Admin/addFoodIngredient.jsp';");
            
           out.println("</script>"); 
            }
        
        }
        if(checkIngre == 1){
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<script>");
            out.println("alert('No ingredient added')");
            out.println("location='Admin/addFoodIngredient.jsp';");
            
           out.println("</script>"); 
            }
        
        }
        
        
      if(check == 1){
         try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<script>");
            out.println("alert('Same Food name being used ')");
            out.println("location='Admin/addFoodIngredient.jsp';");
            
           out.println("</script>"); 
            }
      }
        if(check == 0 && checkImg == 0 && checkIngre == 0){
        Food food = new Food(foodID,foodName,foodPrice,foodCalories,foodImg,foodDescription,foodStatus,foodType);
     
   
     
       try {
            utx.begin();
            
            em.persist(food);
            
            utx.commit();
             
          
       }catch(IllegalStateException ex){
       
       }catch(NotSupportedException ex){
       
       }catch(RollbackException ex){
       
       }catch(HeuristicMixedException ex){
       
       }catch(SystemException ex){
       
       }catch(HeuristicRollbackException ex){
       
       }
            
    
        
     List listing = Arrays.asList(ingre);
     String ingreID = "";
     for(int i = 0; i < listing.size(); i++){
       for(int j = 0; j < ingreAll.size(); j++){
         if(listing.get(i).equals(ingreAll.get(j).getIngredientid())){
           grams = Integer.parseInt(request.getParameter(ingreAll.get(j).getIngredientid()));
           ingreID = ingreAll.get(j).getIngredientid();
             Fooddetail fd = new Fooddetail(foodID, ingreID);
             fd.setIngredientgram(grams);
            try {
            utx.begin();
            
            em.persist(fd);
            
            utx.commit();
             
            
            //redirect user to StaffPage page
            
              try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<script>");
            out.println("alert('Your Food Have been succesfully Added')");
            out.println("location='Admin/addFoodIngredient.jsp';");
            
           out.println("</script>"); 
              }
       }catch(IllegalStateException ex){
       
       }catch(NotSupportedException ex){
       
       }catch(RollbackException ex){
       
       }catch(HeuristicMixedException ex){
       
       }catch(SystemException ex){
       
       }catch(HeuristicRollbackException ex){
       
       }
         }
       
       
       }
     
     }
         }
     
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
