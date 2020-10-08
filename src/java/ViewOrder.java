/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import entity.Food;
import entity.Orderdetail;
import entity.Orders;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author User
 */
public class ViewOrder extends HttpServlet {
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
      HttpSession session = request.getSession();
         
         
          String custID=(String)session.getAttribute("sessCustomerID");
          
          Query query = em.createNamedQuery("Orders.findAll");
          Query query2 = em.createNamedQuery("Orderdetail.findAll");
          Query query3 = em.createNamedQuery("Food.findAll");
           List<Orders> orderList = query.getResultList();
           List<Orderdetail> orderDList = query2.getResultList();
           List<Food> foodList = query3.getResultList();
        
            List<Orders> orders = new ArrayList<>();
            
            
            
           
                 for(int i=0;i<orderList.size();i++){
                 if(orderList.get(i).getCustid().getCustid().equals(custID)){
                     orders.add(orderList.get(i));
                               
                        }
                    }
                    
                
                  session.setAttribute("sessViewOrder",orders);
                  session.setAttribute("sessViewOrderDetail",orderDList);
                  session.setAttribute("sessViewfood",foodList);
               
                 
                  response.sendRedirect("main/vieworder.jsp");
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
        processRequest(request, response);
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
