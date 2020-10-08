/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Food;
import entity.Fooddetail;
import entity.Ingredient;
import entity.Orderdetail;
import entity.Orders;
import entity.orderFood;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author vinso
 */
public class searchIngredientNeeded extends HttpServlet {
@PersistenceContext EntityManager em;
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
            out.println("<title>Servlet searchIngredientNeeded</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet searchIngredientNeeded at " + request.getContextPath() + "</h1>");
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
           ArrayList<orderFood> orderFoodList = new ArrayList<orderFood>();
           List<Orders> orderList = em.createNamedQuery("Orders.findAll").getResultList();
           List<Orderdetail> orderDList = em.createNamedQuery("Orderdetail.findAll").getResultList();
           List<Food> foodList = em.createNamedQuery("Food.findAll").getResultList();
           List<Fooddetail> foodDList = em.createNamedQuery("Fooddetail.findAll").getResultList();
           List<Ingredient> ingredientList = em.createNamedQuery("Ingredient.findAll").getResultList();
       
           SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yy");
           SimpleDateFormat sdfmt2= new SimpleDateFormat("dd-MM-yy");
           String dateS = request.getParameter("dates");
         
//           Date date1 = null;
//           Date date = new Date();
//           
//           
//           
//           String format = "";
//           try{
//            date1 = new SimpleDateFormat("yyyy-MM-dd").parse(dateS);  
//            //format = dateFormatter.format(date1);
//           }catch(ParseException ex){
//           
//           }
//           
           
           
           
           Date todayDate = new Date();
       SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
       //dateFormat.format(todayDate);
       Date date1 = null;
       try{
       date1 = new SimpleDateFormat("yyyy-MM-dd").parse(dateS);
       todayDate = dateFormat.parse(dateFormat.format(todayDate));
       }catch(ParseException ex){
       
       }
       
        
       
       
       
      

       dateFormat.format(date1);
       
       
       
//       
//      // dateFormat.format(date1);
//       if(todayDate.equals(date1)||todayDate.before(date1)){
//          
//           try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<script>");
//            out.println("alert('True')");
//            out.println("location='testNeededIngredient.jsp';");
//            
//           out.println("</script>"); 
//            }
//                 
//              
//       }else{
//       
//       try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<script>");
//            out.println("alert('Not True')");
//            out.println("location='testNeededIngredient.jsp';");
//            
//           out.println("</script>"); 
//            }
//                 
//       
//       
//       
//     }
      if(todayDate.equals(date1)||todayDate.before(date1)){
      int orderQuantity = 0;
      int ingredientGram = 0;
      int totalGram = 0;
      String ingredientID = "";
      String ingredientName = "";
      Date checkDate = null;
      String convertDate = "";
      Date validate = null;
      String validation = "";
      int calculate = 0;
      int allTotal = 0;
      Date cDate = null;
      Date tDate = null;
      for(int i = 0; i < orderList.size(); i++){
        if(orderList.get(i).getOrderdate().equals(date1)){
           cDate = orderList.get(i).getOrderdate();
           tDate = orderList.get(i).getOrderdate();
           for(int j = 0; j < orderDList.size(); j++){
             if(orderDList.get(j).getOrders().getOrderid().equals(orderList.get(i).getOrderid())){
               for(int k = 0; k < foodList.size(); k++){
                 if(foodList.get(k).getFoodid().equals(orderDList.get(j).getFood().getFoodid())){
                    for(int l = 0; l < foodDList.size(); l++){
                      if(foodDList.get(l).getFooddetailPK().getFoodid().equals(foodList.get(k).getFoodid())){
                        for(int m = 0; m < ingredientList.size(); m++){  
                          if(ingredientList.get(m).getIngredientid().equals(foodDList.get(l).getFooddetailPK().getIngredientid())){
                            orderQuantity = orderDList.get(j).getQuantity();
                            ingredientGram = foodDList.get(l).getIngredientgram();
                            totalGram = (ingredientGram*orderQuantity);
                            ingredientID = foodDList.get(l).getFooddetailPK().getIngredientid();
                            ingredientName = ingredientList.get(m).getIngredientname();
                            
                            
                            
                            
                            orderFood of = new orderFood(ingredientID, ingredientName, totalGram);
                            orderFoodList.add(of);
                            
                        }
                      }    
                    }    
                  }    
                } 
              }   
            }
          }  
        }
      }
     
        
        session.setAttribute("sessOrderFoodList1", orderFoodList);
        session.setAttribute("sessffood", foodList);
        session.setAttribute("sessTotalIngredient", ingredientList);
       
        session.setAttribute("trueDate", cDate);
        session.setAttribute("love", tDate);
        session.setAttribute("sessFoodListing", foodDList);
        session.setAttribute("sessOrderID", convertDate);
        session.setAttribute("sessValidate", validation);
        response.sendRedirect("Admin/ingredientNeeded.jsp");
      }else{
       try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<script>");
            out.println("alert('only can choose today or future date')");
            out.println("location='Admin/testNeededIngredient.jsp';");
            
           out.println("</script>"); 
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
