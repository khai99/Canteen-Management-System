/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Customer;
import entity.Topuppayment;
import java.io.IOException;
import java.io.PrintWriter;
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
public class confirmPayment extends HttpServlet {
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
            out.println("<title>Servlet confirmPayment</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet confirmPayment at " + request.getContextPath() + "</h1>");
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
      List<Topuppayment> topUpList = em.createNamedQuery("Topuppayment.findAll").getResultList();
     int topUpSize = topUpList.size() + 1;
     String topUpID = "T" + String.format("%05d", topUpSize); 
      
        
    
       Double amount = Double.parseDouble(request.getParameter("amount"));
       String custTempID = request.getParameter("custID");
       //String date = request.getParameter("date");
       int check = 0;
       int checker = 0;
       Date date = new Date();
       SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
       dateFormat.format(date);
       
       
     
       
       List<Customer> custValidate = em.createNamedQuery("Customer.findAll").getResultList();
       for(int i = 0; i < custValidate.size(); i++){
        if(custTempID.equals(custValidate.get(i).getCustid())){
            check = 2;
           }
       }
       
       
       if(check == 0){
       try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<script>");
            out.println("alert('Invalid customer ID')");
            out.println("location='Admin/searchCusTopup.jsp';");
            
           out.println("</script>"); 
            }
       
       }
        
       else if(check == 2 && checker == 0){
   
           
      Customer cust = em.find(Customer.class, custTempID);
     
      cust.setCreditpoint(cust.getCreditpoint() + amount);
      
     
       try {
            utx.begin();
            
          
            
            em.merge(cust);
            
            utx.commit();
        
             
            
            
            //redirect user to StaffPage page
            
              
       }catch(IllegalStateException ex){
       
       }catch(NotSupportedException ex){
       
       }catch(RollbackException ex){
       
       }catch(HeuristicMixedException ex){
       
       }catch(SystemException ex){
       
       }catch(HeuristicRollbackException ex){
       
       }
      
      
      Topuppayment tPayment = new Topuppayment(topUpID, amount, date ,cust);
      tPayment.setTopupid(topUpID);
      tPayment.setTopupamount(amount);
      //tPayment.setTopupdate(date1);
      tPayment.setTopupdate(date);
      tPayment.setCustid(cust);
     
    
      
       try {
            utx.begin();
            
            em.persist(tPayment);
            
        
            
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
       List<Customer> custListNew = em.createNamedQuery("Customer.findAll").getResultList();
       HttpSession session = request.getSession();
       session.setAttribute("custID",custTempID );
       session.setAttribute("dateTop", date);
       session.setAttribute("topUpAmount", amount);
       session.setAttribute("newCustList",custListNew);
       response.sendRedirect("Admin/showPayment.jsp");
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
