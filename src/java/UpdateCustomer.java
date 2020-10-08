/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entity.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;
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
 * @author User
 */
public class UpdateCustomer extends HttpServlet {
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
            out.println("<title>Servlet UpdateStudent</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateStudent at " + request.getContextPath() + "</h1>");
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
        
                      
          String button=request.getParameter("button");
        
        if("UPDATE".equals(button)){
               boolean checking=true;
             
                  String name = request.getParameter("custName");
      String email = request.getParameter("custEmail");
         String icNO = request.getParameter("custIC");
         String custPhoneNo = request.getParameter("custPhoneNo");
         int custAge =Integer.parseInt(request.getParameter("custAge"));
         String  gender= request.getParameter("gender");
         

                 HttpSession session = request.getSession();
                       
             //check if fullname is empty
                 if(name.equals("")==true){
                     checking=false;
             try (PrintWriter out = response.getWriter()) {
                          out.println("<script>");
            out.println("alert('Name cannot be empty');");
            out.println("location='User/profile.jsp';");
            out.println("</script>");
            
                      }
            }
                 
                       if(email.equals("")==true){
                     checking=false;
             try (PrintWriter out = response.getWriter()) {
                          out.println("<script>");
            out.println("alert('Email cannot be empty');");
            out.println("location='User/profile.jsp';");
            out.println("</script>");
            
                      }
            }
                 
            if(custPhoneNo.equals("")==true){
                checking=false;
             try (PrintWriter out = response.getWriter()) {
                          out.println("<script>");
            out.println("alert('Phone Number cannot be empty');");
            out.println("location='User/profile.jsp';");
            out.println("</script>");
            
                      }
            }
           
             if(icNO.equals("")==true){
                 checking=false;
             try (PrintWriter out = response.getWriter()) {
                          out.println("<script>");
            out.println("alert('IC number cannot be empty');");
            out.println("location='User/profile.jsp';");
            out.println("</script>");
            
                      }
            }
             
            
            
       Boolean success = false;
     
            Customer customer = (Customer)session.getAttribute("sessCustomer");
        
            
            
            customer.setCustname(name);
            customer.setCustemail(email);
            customer.setCustic(icNO);
            customer.setCustphoneno(custPhoneNo);
            customer.setCustage(custAge);
            customer.setCustgender(gender.charAt(0));
        
            
            
    if(checking==true) {
        try {
            //add record into DB
            //start user tansaction
            utx.begin();
            
            em.merge(customer);
      
            //execute to insert record
            utx.commit();
            
            
            //set success into session
            success = true;
            
        } catch (Exception ex) {
            Logger.getLogger(UpdateCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(success==true){
             try (PrintWriter out = response.getWriter()) {
                       out.println("<script>");
            out.println("alert('Customer updated successfully!');");
            out.println("location='main/profileview.jsp';");
            out.println("</script>");
//          session.setAttribute("1", sicNo);
//          session.setAttribute("2", g);
//          session.setAttribute("3", oldpassword);
//          session.setAttribute("4", newpassword);
//          out.println("<script>");
//           out.println("alert('Student updated successfully!');");
//           out.println("location='testing.jsp';");
//          out.println("</script>");
             }
        }
        else{
             try (PrintWriter out = response.getWriter()) {
            out.println("<script>");
            out.println("alert('Customer updated unsuccessfully!');");
            out.println("location='main/profileview.jsp';");
            out.println("</script>");
             }
        }
        }
        }
        else if ("BACK".equals(button)){
             response.sendRedirect("main/profileview.jsp");
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
