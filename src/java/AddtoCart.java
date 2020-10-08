

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entity.Food;
import entity.FoodOrder;
import entity.Food_;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author User
 */
public class AddtoCart extends HttpServlet {
    @PersistenceContext EntityManager em;
    public  ArrayList<FoodOrder> addCartFood = new ArrayList<FoodOrder>();
    public  ArrayList<FoodOrder> addCartFood2 = new ArrayList<FoodOrder>();
    
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
         HttpSession session = request.getSession();
      
            String type= (String)session.getAttribute("sessCartType");
            String type2= (String)session.getAttribute("sessCartType2");
            String clear= (String)session.getAttribute("sessClearArray");
            String clearC= (String)session.getAttribute("sessClearCart");
            String clearC2= (String)session.getAttribute("sessClearCart2");
            String remove= (String)session.getAttribute("sessRemoveCart");
            String remove2= (String)session.getAttribute("sessRemoveCart2");
            
              if(remove.equals("remove")){ 
                  
                   String q= (String)session.getAttribute("sessItemRemove");
                   for(int a=0;a<addCartFood.size();a++){
                       if(addCartFood.get(a).getFoodID().equals(q))
                         addCartFood.remove(a);
                         
                   }
                   
                 
                    session.setAttribute("sessItemRemove","a" );
                    session.setAttribute("sessRemoveCart","a" );
                     response.sendRedirect("main/cart.jsp");

              }
               
                if(remove2.equals("remove")){ 
                  
                   String q= (String)session.getAttribute("sessItemRemove2");
                   for(int a=0;a<addCartFood2.size();a++){
                       if(addCartFood2.get(a).getFoodID().equals(q))
                         addCartFood2.remove(a);
                         
                   }
                   
                 
                    session.setAttribute("sessItemRemove2","a" );
                    session.setAttribute("sessRemoveCart2","a" );
                     response.sendRedirect("main/ordercart.jsp");

              }
                
               if(clearC.equals("clear")){ 
                   addCartFood.clear();
                    session.setAttribute("sessClearCart","a" );
               try (PrintWriter out = response.getWriter()) {
                          out.println("<script>");
            out.println("alert('Your order has completed');");
            out.println("location='ViewOrder';");
            out.println("</script>");
               }
               
               }
                  if(clearC2.equals("clear")){ 
                   addCartFood2.clear();
                    session.setAttribute("sessClearCart2","a" );
               try (PrintWriter out = response.getWriter()) {
                          out.println("<script>");
            out.println("alert('Your order has completed');");
            out.println("location='ViewOrder';");
            out.println("</script>");
               }
               
               }
             if(type.equals("type")){
               
                 int[] qty = new int[100];
                 qty= (int[])session.getAttribute("sessCartQty");
                
                for(int i=0;i<addCartFood.size();i++){
                    addCartFood.get(i).setFoodquantity(qty[i]);
                
                }
             
                session.setAttribute("sessCartType", "typees");
          response.sendRedirect("main/cart.jsp");
          
      }
             
                
         if(type2.equals("type")){
              
               
                 int[] qty = new int[100];
                 qty= (int[])session.getAttribute("sessCartQty2");
                
                for(int i=0;i<addCartFood2.size();i++){
                    addCartFood2.get(i).setFoodquantity(qty[i]);
                    
                
     
      
      }
                 session.setAttribute("sessCartType2", "typees");
          response.sendRedirect("main/ordercart.jsp");
                 
                }
                
                
      if(clear.equals("clear")){
          addCartFood.clear();
          addCartFood2.clear();
          session.invalidate();
          response.sendRedirect("main/index.jsp");
          
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
       if(session.getAttribute("sessCustomer")!=null){
      String button=request.getParameter("button");
     String quantity = request.getParameter("foodQty");
        
      String IDD = "";
      String fName1 = "";
      Double fPrice1 = 0.0;
      int qty = Integer.parseInt(quantity);
      
       
            String foodID= request.getParameter("cartfood");
            
              Food food= em.find(Food.class,foodID);
              IDD = food.getFoodid();
              fName1 = food.getFoodname();
              fPrice1 = food.getFoodprice();
              int newqty=0;
                 boolean status=true;
                 
       if("Pre order".equals(button)){
      
             
              
              for(int i=0;i<addCartFood.size();i++){
                  if(addCartFood.get(i).getFoodID().equals(foodID)){
                     newqty=qty+addCartFood.get(i).getFoodquantity();
                     addCartFood.get(i).setFoodquantity(newqty);
                     status=false;
                  }
              }
              if(status==true){
              FoodOrder fOrder = new FoodOrder(IDD,fName1,fPrice1,qty);
              
              addCartFood.add(fOrder);
              }
             
                session.setAttribute("sessCartFood", addCartFood);
                
               response.sendRedirect("main/cart.jsp");
       }
       else{
          
           
              
              for(int i=0;i<addCartFood2.size();i++){
                  if(addCartFood2.get(i).getFoodID().equals(foodID)){
                     newqty=qty+addCartFood2.get(i).getFoodquantity();
                     addCartFood2.get(i).setFoodquantity(newqty);
                     status=false;
                  }
              }
              if(status==true){
              FoodOrder fOrder = new FoodOrder(IDD,fName1,fPrice1,qty);
              
              addCartFood2.add(fOrder);
              }
               
              
                session.setAttribute("sessOrderNowFood", addCartFood2);
                
               response.sendRedirect("main/ordercart.jsp");
       }
       }else{
           try (PrintWriter out = response.getWriter()) {
                          out.println("<script>");
            out.println("alert('Please sign in first');");
            out.println("location='main/index.jsp';");
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


