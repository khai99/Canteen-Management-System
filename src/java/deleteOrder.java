/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entity.Customer;
import entity.Orders;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;

/**
 *
 * @author User
 */
public class deleteOrder extends HttpServlet {
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
         HttpSession session = request.getSession();
          Date todayDate=new Date();
          SimpleDateFormat df= new SimpleDateFormat("dd/MM/yyyy");
                   
         
         String orderL= request.getParameter("orderdel");
         
          Orders order =em.find(Orders.class, orderL);
          
          Date date = order.getOrderdate();
          
                        Date date1=null;
                    try {
                    
                    todayDate = df.parse(df.format(todayDate));
                       } catch (ParseException ex) {
                      Logger.getLogger(AddOrder.class.getName()).log(Level.SEVERE, null, ex);
                         }
                   
                   
                      if(todayDate.before(date)){
           String cust= order.getCustid().getCustid();
           
           Customer customer =em.find(Customer.class, cust);
           
           double total = (customer.getCreditpoint()+ order.getTotalamount());
           
           customer.setCreditpoint(total);
           
             try {
            //add record into DB
            //start user tansaction
            utx.begin();
            
            em.merge(customer);
      
            //execute to insert record
            utx.commit();
            
            
            //set success into session
            
            
        } catch (Exception ex) {
            Logger.getLogger(UpdateCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
           
           order.setOrderstatus("canceled");
          
           boolean success=false;
            try {
            //add record into DB
            //start user tansaction
            utx.begin();
            
            em.merge(order);
      
            //execute to insert record
            utx.commit();
            
            
            //set success into session
            success = true;
            
        } catch (Exception ex) {
            Logger.getLogger(AddCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
         if(success==true){
             String customer2=customer.getCustid();
             Customer customer1= em.find(Customer.class,customer2);
            
           
                     session.setAttribute("sessCustomer", customer1);
                     
             try (PrintWriter out = response.getWriter()) {
                       out.println("<script>");
            out.println("alert('Order successfully cancelled!');");
            out.println("location='ViewOrder';");
            out.println("</script>");

        }
           
         }
         
                      }
                      else{
                              try (PrintWriter out = response.getWriter()) {
                           out.println("<script>");
                           out.println("alert('The order can only be cancel at least a day before');");
                              out.println("location='main/vieworder.jsp';");
                              out.println("</script>");
             }
                          
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
