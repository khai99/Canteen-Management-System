/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Customer;
import java.io.IOException;
import java.io.PrintWriter;
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
public class searchTopup extends HttpServlet {
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
            out.println("<title>Servlet searchTopup</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet searchTopup at " + request.getContextPath() + "</h1>");
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
        List<Customer> custList = em.createNamedQuery("Customer.findAll").getResultList();
        
        String custIDD = request.getParameter("custID");
        int check = 0;
        String trueCustIDD = "";
        String cc = "";
        for(int i = 0; i < custList.size(); i++){
          if(custList.get(i).getCustid().equals(custIDD)){
          
          trueCustIDD = custList.get(i).getCustid();
          check = 1;
          }
               
         
          
        }
        
        if(check != 1){
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<script>");
            out.println("alert('No such ID found')");
            out.println("location='Admin/searchCusTopup.jsp';");
            
           out.println("</script>"); 
              }
        } 
        //if(check == 1){
        
        if(check == 1){
        HttpSession session = request.getSession();
        
        session.setAttribute("sessCustID", trueCustIDD);
        session.setAttribute("sessAllCust", custList);
        response.sendRedirect("Admin/topup.jsp");
        }//        }else if(check == 0){
//        
//         try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<script>");
//            out.println("alert('No such customer ID found')");
//            out.println("location='events.jsp';");
//            
//           out.println("</script>"); 
//              }
//        
//        
//        }
        
        
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
