/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Food;
import entity.Fooddetail;
import entity.FooddetailPK;
import entity.Ingredient;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
public class confirmUpdateFood extends HttpServlet {
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
            out.println("<title>Servlet confirmUpdateFood</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet confirmUpdateFood at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
     
        //String[] ingreUpdate = request.getParameterValues("ingredientCheck");
       
       
        String[] ingre = request.getParameterValues("ingredientCheck");
        List<Food> foodValidate = em.createNamedQuery("Food.findAll").getResultList();
        List<Fooddetail> foodDetail = em.createNamedQuery("Fooddetail.findAll").getResultList();
        List<Ingredient> ingreDetail = em.createNamedQuery("Ingredient.findAll").getResultList();
        String fIDD = "";
        String foodID = request.getParameter("foodID");
        int check = 0;
        String foodName = request.getParameter("fName");
        Double foodPrice = Double.parseDouble(request.getParameter("fPrice"));
        int foodCalories = Integer.parseInt(request.getParameter("fCalories"));
        String foodType = request.getParameter("foodType1");
       
        String foodDesc = (String) request.getParameter("fDesc");
        String foodStatus = (String) request.getParameter("fStatus");
        String checker = "";
//        for(int i = 0; i < foodValidate.size();i++){
//         if(foodName.equalsIgnoreCase(foodValidate.get(i).getFoodname())){
//              check = 1;
//         }
//        
//        }
        
       
        


       if(ingre == null){
           try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<script>");
            out.println("alert('Must have at least one ingredient')");
            out.println("location='Admin/updateFood.jsp';");
            
           out.println("</script>"); 
              }
       }
       
       for(int x = 0; x < foodValidate.size(); x++){
       if(foodID.equals(foodValidate.get(x).getFoodid())){
         fIDD = foodValidate.get(x).getFoodid();
       }
       
       }

      int query = 0;
      //List listing = Arrays.asList(ingre);
     String ingreID = "";
     for(int i = 0; i < ingreDetail.size(); i++){
       for(int j = 0; j < foodDetail.size(); j++){
         if(ingreDetail.get(i).getIngredientid().equals(foodDetail.get(j).getFooddetailPK().getIngredientid())){
          
           ingreID = foodDetail.get(j).getFooddetailPK().getIngredientid();
            
    
             try{
             utx.begin();
             
             
   query = em.createQuery("DELETE FROM Fooddetail f WHERE f.fooddetailPK.foodid = :foodid AND f.fooddetailPK.ingredientid = :ingredientid").setParameter("foodid",fIDD).setParameter("ingredientid",ingreID).executeUpdate();
             utx.commit();
              query = 1;
             }catch(HeuristicMixedException | HeuristicRollbackException | NotSupportedException | IllegalStateException | SystemException | RollbackException | SecurityException ex ){
                    
                    
            }
         }
       }
     }
       
     List listings = Arrays.asList(ingre);
     String ingreIDD = "";
     int ingreGrams = 0;
     for(int y = 0; y < listings.size(); y++){
       for(int z = 0; z < ingreDetail.size(); z++){
         if(listings.get(y).equals(ingreDetail.get(z).getIngredientid())){
             
           ingreGrams = Integer.parseInt(request.getParameter(ingreDetail.get(z).getIngredientid()));
           
           
           
           ingreIDD = ingreDetail.get(z).getIngredientid();
            Fooddetail fdetail = new Fooddetail(fIDD, ingreIDD);
             fdetail.setIngredientgram(ingreGrams);
            try {
            utx.begin();
              
            em.persist(fdetail);
   
            utx.commit();
             
            
            //redirect user to StaffPage page
            
              
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
        
     
     
     
        
        
        
     
        Food food = em.find(Food.class, foodID);
        
        food.setFoodname(foodName);
        food.setFoodprice(foodPrice);
        food.setFoodcalories(foodCalories);
        food.setFooddesc(foodDesc);
        food.setFoodstatus(foodStatus);
        food.setFoodtype(foodType);
         
 
        
          try {
            utx.begin();
            
            em.merge(food);
            
            utx.commit();
            
            //redirect user to StaffPage page
            
              try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<script>");
            out.println("alert('Your Food and ingredient Have been succesfully Updated')");
            out.println("location='loadFoodTable';");
            
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
