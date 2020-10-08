/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entity.Canteenstaff;
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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;

/**
 *
 * @author User
 */
@WebServlet(urlPatterns = {"/AddCustomer"})
public class AddCustomer extends HttpServlet {

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
            out.println("<title>Servlet AddCustomer</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddCustomer at " + request.getContextPath() + "</h1>");
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
        int checking=0;
        
         List<Customer> custList= em.createNamedQuery("Customer.findAll").getResultList();
        //List<Canteenstaff> staffList = em.createNamedQuery("Canteenstaff.findAll").getResultList();
        
           String name = request.getParameter("custName");
       String custID = request.getParameter("custID");
      String email = request.getParameter("custEmail");
      String password = request.getParameter("password");
       String custpassword = request.getParameter("custPassword");
         String icNO = request.getParameter("custIC");
         String phoneNo = request.getParameter("custPhoneNo");
         
         String type= custID.substring(0,1);
         String id=custID.substring(1,6);
         
         char[] charID= id.toCharArray();
         
         for(char names: charID) {
          if(!Character.isDigit(names)){
              checking=5;
          }
         }
         
         if(type.equals("S")!=true){
             if(type.equals("C")!=true)
             checking=5;
         }
         
       /////check for customer password
         if(!password.equals(custpassword)){
            checking=1;
           
       }
         ////Check for email
          for(int i = 0; i < custList.size(); i++)
           {
                if(custList.get(i).getCustemail().equals(email))
                {  
                    checking=2;
                }
                  
            }
          
          //check for custID
            for(int i = 0; i < custList.size(); i++)
           {
                if(custList.get(i).getCustid().equals(custID))
                {  
                    checking=4;
                }
                  
            }
            
            
            
         char gender;
         //generate student ID
     
        
        //to get the IC number and translate to gender
        int verifyGender=Character.getNumericValue(icNO.charAt(icNO.length()-1));
        int age=0;
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
        if(fICNum==0){
            int yearnow =2000+year;
            age=now.get(Calendar.YEAR)-yearnow ;
        }else{
        age=year1+year2;
        }
        if (verifyGender % 2 == 0){
            gender= 'f';
        }else{
           gender= 'm'; 
        }
        
        
         Boolean success = false;
        HttpSession session = request.getSession();
        
        double credit= 0;
        String custType = "M";
        Customer cust= new Customer(custID, custpassword, email, name, custType, icNO, gender, age, credit);
        
        cust.setCustphoneno(phoneNo);
        
                 if(checking==1){
             try (PrintWriter out = response.getWriter()) {
                        out.println("<script>");
                       out.println("alert('Both password does not matched!');");
                       out.println("location='main/register.jsp';");
                       out.println("</script>"); 
                      
     }
         }
         else if(checking==2){
             try (PrintWriter out = response.getWriter()) {
                        out.println("<script>");
                       out.println("alert('Email enter already registered by other customer!');");
                       out.println("location='main/register.jsp';");
                       out.println("</script>"); 
                      
     }
             }
         else if(checking==3){
              try (PrintWriter out = response.getWriter()) {
         
          out.println("<script>");
            out.println("alert('Invalid ic number!');");
            out.println("location='main/register.jsp';");
            out.println("</script>"); 
     }
             }
        else if (checking==4){
         
                                 try (PrintWriter out = response.getWriter()) {

            out.println("<script>");
            out.println("alert('Student/Staff ID enter already registered by other customer!');");
            out.println("location='main/register.jsp';");
            out.println("</script>"); 
                   }
         }
        else if (checking==5){
         
                                 try (PrintWriter out = response.getWriter()) {

            out.println("<script>");
            out.println("alert('Please enter the valid Student/Staff ID');");
            out.println("location='main/register.jsp';");
            out.println("</script>"); 
                   }
         }
         else if (checking==6){
         
                                 try (PrintWriter out = response.getWriter()) {

            out.println("<script>");
            out.println("alert('Please enter the valid Student/Staff ID');");
            out.println("location='main/register.jsp';");
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
            
            em.persist(cust);
            
            //execute to insert record
            utx.commit();
            success = true;
            
         
            
            
        } catch (Exception ex) {
            Logger.getLogger(AddCustomer.class.getName()).log(Level.ALL.SEVERE, null, ex);
        }
        
                if(success==true){
             try (PrintWriter out = response.getWriter()) {
                       out.println("<script>");
            out.println("alert('Register successfully !');");
            out.println("location='main/index.jsp';");
            out.println("</script>");
            
             }
        }
        else{
             try (PrintWriter out = response.getWriter()) {
            out.println("<script>");
            out.println("alert('Record send unsuccessfully!');");
            out.println("location='main/index.jsp';");
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
