/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entity.Canteenstaff;
import entity.Customer;
import entity.Food;
import entity.Orderdetail;
import entity.Orders;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author User
 */
@WebServlet(urlPatterns = {"/VerifyUser"})
public class VerifyUser extends HttpServlet {
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
            out.println("<title>Servlet VerifyUser</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet VerifyUser at " + request.getContextPath() + "</h1>");
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
                String user =request.getParameter("custID");
      String password =request.getParameter("custPassword");
     
        HttpSession session = request.getSession();
      

        // studentService studService = new studentService(em);
        //List<Student> studList =  studService.findAll();
        List<Customer> custList= em.createNamedQuery("Customer.findAll").getResultList();
        List<Canteenstaff> staffList = em.createNamedQuery("Canteenstaff.findAll").getResultList();
           
                                            
 
      
      // String user1 = studList.get(0).getSpassword();
       // session.setAttribute("sessUser", user1);
      //  response.sendRedirect("main/test.jsp");
       

        
        boolean check=false;
        boolean checkStudentStatus=false;
        
   
             for(int i = 0; i < custList.size(); i++)
           {
                if(custList.get(i).getCustid().equals(user)&& custList.get(i).getCustpassword().equals(password))
                {
                    check=true;
                      List<Orders> orderList1 = em.createNamedQuery("Orders.findAll").getResultList();
                    Customer customer= em.find(Customer.class,custList.get(i).getCustid());
            
           
                     session.setAttribute("sessCustomer", customer);
                     session.setAttribute("sessCustomerID", custList.get(i).getCustid());
                      session.setAttribute("sessClearArray","c" );
                      session.setAttribute("sessClearCart","a" );
                      session.setAttribute("sessRemoveCart","a" );
                      session.setAttribute("sessRemoveCart2","a" );
                      session.setAttribute("sessClearCart2","a" );
                      
                      session.setAttribute("sessCartType", "typees");
                      session.setAttribute("sessCartType2", "typees");
                     response.sendRedirect("main/index.jsp");
                   
                }


            }
           
               for(int i = 0 ; i < staffList.size() ; i++)
        {
            if(user.equals(staffList.get(i).getStaffid()) && password.equals(staffList.get(i).getStaffpassword()))
            {
                check=true;
                 Canteenstaff staff= em.find(Canteenstaff.class,staffList.get(i).getStaffid());
                //dmins adminDetail = em.find(Admins.class, email);
                session.setAttribute("sessStaff", staff);
                
                
                response.sendRedirect("Admin/profile.jsp");
                //response.sendRedirect("test.jsp");
            }
            
        }
              
          
             if (check==false){
                  
                // Cookie cookie = new Cookie("fail","1");
               // session.setAttribute("sesscheck", check);
               //  response.sendRedirect("main/signin.jsp");
                   try (PrintWriter out = response.getWriter()) {

            out.println("<script>");
            out.println("alert('user or password incorrect');");
            out.println("location='main/login.jsp';");
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
