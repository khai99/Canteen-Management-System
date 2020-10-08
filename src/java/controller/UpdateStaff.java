/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import entity.Canteenstaff;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
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
public class UpdateStaff extends HttpServlet {

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
            out.println("<title>Servlet UpdateStaff</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateStaff at " + request.getContextPath() + "</h1>");
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
        Canteenstaff staff =(Canteenstaff)session.getAttribute("sessStaff");
                  String name = request.getParameter("staffname");
                  
               
      int age1 = Integer.parseInt(request.getParameter("age"));
      String password = request.getParameter("password");
       String custpassword = request.getParameter("custPassword");
         String icNO = request.getParameter("staffic");
         String phoneNo = request.getParameter("phone");
         
           
            
            int checking=0;
         
         //generate student ID
     
        
        //to get the IC number and translate to gender
        int verifyGender=Character.getNumericValue(icNO.charAt(icNO.length()-1));
        
        int fICNum=Character.getNumericValue(icNO.charAt(0));
        int lICNum=Character.getNumericValue(icNO.charAt(1));
        int year=fICNum*10+lICNum;
        int year1=100-year;
        //get the birth
         int icNum2=Character.getNumericValue(icNO.charAt(2));
         int icNum3=Character.getNumericValue(icNO.charAt(3));
         int icNum4=Character.getNumericValue(icNO.charAt(4));
         int icNum5=Character.getNumericValue(icNO.charAt(5));
         //get the medium 2 number
         int icNum6=Character.getNumericValue(icNO.charAt(6));
         int icNum7=Character.getNumericValue(icNO.charAt(7));
         //validate second number
         if( icNum6==6 || (icNum6==0&&icNum7==0)){
             checking=3;
                             
         }
           int actualyear=0;
          if(fICNum==0){
              actualyear =2000+year;
            
        }else{
             actualyear =1900+year;
        }
         int day=icNum4*10+icNum5;
         int month=icNum2*10+icNum3;
         //String birthDate=day+"/"+month+"/"+actualyear;
   
       boolean checkDate=true;
       boolean isLeap=false;
       //check for leap year
       if(((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)){
             isLeap=true;
         }
       ///check for valid month
        if (month < 1 || month > 12) {
                 checkDate=false;
             }
        //check for valid day    
        if (day < 1 || day > 31) {
            checkDate=false;
        }
        
        //check for february
          if (month == 2)  
        { 
            if (isLeap==true) {
                if(day >29){
                    checkDate=false;
                }
            } 
            else{
                if(day >28){
                     checkDate=false;
                }
            }  
        } 
         
           if (month == 4 || month == 6 ||  
            month == 9 || month == 11) {
               if(day>30){
                   checkDate=false;
               }
           } 
            
       
       
       
     if(  checkDate==false) {
         checking=3;
    
        }
         
         
        Calendar now = Calendar.getInstance();
      now.setTimeInMillis(System.currentTimeMillis());
        //get year start from 2000
        int year2= now.get(Calendar.YEAR) -2000;
        
        
         Boolean success = false;
        
        
        Canteenstaff cs = em.find(Canteenstaff.class, staff.getStaffid());
        cs.setStaffname(name);
        cs.setStaffage(age1);
        cs.setStaffic(icNO);
        cs.setStaffphoneno(phoneNo);
       
        
           
             if(checking==3){
              try (PrintWriter out = response.getWriter()) {
         
          out.println("<script>");
            out.println("alert('Invalid ic number!');");
            out.println("location='Admin/profile.jsp';");
            out.println("</script>"); 
     }
             }
       
       
         else{
       
         
            //redirect user to AddConfirm page
//            response.sendRedirect("test.jsp");
//         
        
        try {
            //add record into DB
            //start user tansaction
            utx.begin();
            
            em.merge(cs);
            
            //execute to insert record
            utx.commit();
            success = true;
            
         
            
            
        } catch (Exception ex) {
         
        }
        
                if(success==true){
                    
             Canteenstaff staffe= em.find(Canteenstaff.class, staff.getStaffid());
            
           
                    session.setAttribute("sessStaff",staffe);
             try (PrintWriter out = response.getWriter()) {
                       out.println("<script>");
            out.println("alert('Record update successfully !');");
            out.println("location='Admin/profile.jsp';");
            out.println("</script>");
            
             }
        }
        else{
             try (PrintWriter out = response.getWriter()) {
            out.println("<script>");
            out.println("alert('Record update unsuccessfully!');");
            out.println("location='Admin/profile.jsp';");
            out.println("</script>");
             }
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
