/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Orderdetail;
import entity.Orders;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
public class redeemCoupon extends HttpServlet {
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
            out.println("<title>Servlet redeemCoupon</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet redeemCoupon at " + request.getContextPath() + "</h1>");
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
        
         String cOrderID = (String)session.getAttribute("sessOrderIDD");
         List<Orderdetail> od = em.createNamedQuery("Orderdetail.findAll").getResultList();
         String orderID = request.getParameter("orderID");
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         Date date = new Date();
         String verified = "";
         for(int i = 0; i < od.size(); i++){
            if(od.get(i).getOrderdetailPK().getOrderid().equals(cOrderID)){
               verified = od.get(i).getOrderdetailPK().getOrderid();
            
            
            }
         
         }
         
         
         
         
         Date checker = null;
         String validate = "";
         int check = 0;
         for(int i = 0; i < od.size(); i++){
          if(od.get(i).getOrderdetailPK().getOrderid().equals(verified)){
             if(sdf.format(od.get(i).getOrders().getOrderdate()).equals(sdf.format(date))){
                 if(od.get(i).getOrders().getOrderstatus().equals("incomplete")){
                       
                        check = 1; 
                         validate = od.get(i).getOrderdetailPK().getOrderid();
               
          }else{
          
           check = 2;
           }
           }else{
             check = 2;
           }
          }
         }
         
         if(check == 1){
             Orders ods = em.find(Orders.class,validate);
             
             ods.setOrderstatus("redeem");
             
             try {
            utx.begin();
            
            em.merge(ods);
            
            utx.commit();
            
            //redirect user to StaffPage page
            
             
       }catch(IllegalStateException ex){
       
       }catch(NotSupportedException ex){
       
       }catch(RollbackException ex){
       
       }catch(HeuristicMixedException ex){
       
       }catch(SystemException ex){
       
       }catch(HeuristicRollbackException ex){
       
        }
              
          try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<script>");
            out.println("alert('Redeem Successful')");
            out.println("location='Admin/couponValidity.jsp';");
            
           out.println("</script>"); 
            }
         }
      
          if(check == 2){
                
  
          try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<script>");
            out.println("alert('coupon redeemed or the coupon is expired')");
            out.println("location='Admin/couponValidity.jsp';");
            
           out.println("</script>"); 
            }
     
         }
         
//        session.setAttribute("sessDate", date);
//        session.setAttribute("sessDateget", checker);
//         session.setAttribute("sessID", validate);
//         session.setAttribute("sessIDDD", ccOrderID);
//        response.sendRedirect("test.jsp");
//        
        
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
