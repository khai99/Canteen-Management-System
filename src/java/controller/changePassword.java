/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import entity.Canteenstaff;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;

/**
 *
 * @author vinso
 */
public class changePassword extends HttpServlet {
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
            out.println("<title>Servlet changePassword</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet changePassword at " + request.getContextPath() + "</h1>");
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
        String oldPass=request.getParameter("oldPassword");
       String newPass=request.getParameter("newPass");
       String confirmPass=request.getParameter("confirmPass");
       
        HttpSession session = request.getSession();
                       
       
       Boolean success = false;
     
           Canteenstaff staff =(Canteenstaff)session.getAttribute("sessStaff"); 
            
            if(!oldPass.equals(staff.getStaffpassword())){
                             try (PrintWriter out = response.getWriter()) {
            out.println("<script>");
            out.println("alert('Password enter is incorrect!!');");
            out.println("location='Admin/profile.jsp';");
            out.println("</script>");
             }
            }
            if(oldPass.equals(staff.getStaffpassword())){
           if(!newPass.equals(confirmPass)){
                               try (PrintWriter out = response.getWriter()) {            out.println("<script>");
            out.println("alert('The confirm password does not match with the new Password enter!!');");
            out.println("location='Admin/profile.jsp';");
            out.println("</script>");
             }
            }
            }
//            else{
            if(oldPass.equals(staff.getStaffpassword()) && newPass.equals(confirmPass)){
           staff.setStaffpassword(confirmPass);
            }
            //}
                    try {
            //add record into DB
            //start user tansaction
            utx.begin();
            
            em.merge(staff);
      
            //execute to insert record
            utx.commit();
            
            
            //set success into session
            success = true;
            
        } catch (Exception ex) {
            
        }
        
        if(success==true){
             try (PrintWriter out = response.getWriter()) {
                       out.println("<script>");
            out.println("alert('Password updated successfully!');");
            out.println("location='Admin/profile.jsp';");
            out.println("</script>");

             }
        }
        else{
             try (PrintWriter out = response.getWriter()) {
            out.println("<script>");
            out.println("alert('Password updated unsuccessfully!');");
            out.println("location='Admin/profile.jsp';");
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
