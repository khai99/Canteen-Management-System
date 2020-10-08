/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import entity.FoodOrder;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author User
 */
public class updateQuantity extends HttpServlet {

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
            String button=request.getParameter("button");
            
            if("Update Cart".equals(button)){
            ArrayList<String> qtyy= (ArrayList<String>) session.getAttribute("qtyy");
            int[] qty= new int[100];
            for(int i=0;i<qtyy.size();i++){
                   String qtyS= request.getParameter("qty"+i);
                    qty[i] = Integer.parseInt(qtyS);
            }
  
           session.setAttribute("sessCartQty",qty );
           
           session.setAttribute("sessCartType","type" );
       
        response.sendRedirect("AddtoCart");
            }
            else{
                
                boolean check=true;
                     double total =(double) session.getAttribute("checktotal");
                     
                      if(total==0){
                   check=false;
                    try (PrintWriter out = response.getWriter()) {
                          out.println("<script>");
            out.println("alert('Must consist at least one item');");
            out.println("location='main/cart.jsp';");
            out.println("</script>");
               }
                
            }
                      
               if(request.getParameter("date").equals("")==true){
                   check=false;
                    try (PrintWriter out = response.getWriter()) {
                          out.println("<script>");
            out.println("alert('Please select a date');");
            out.println("location='main/cart.jsp';");
            out.println("</script>");
               }
                
            }
         
          
         
               
               if(check==true){
                   Date todayDate=new Date();
                   SimpleDateFormat df= new SimpleDateFormat("dd/MM/yyyy");
                   
                   
                      String date= request.getParameter("date");
                      String selecTime= request.getParameter("selectedTime");
                     
                        Date date1=null;
                    try {
                    date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
                    todayDate = df.parse(df.format(todayDate));
                       } catch (ParseException ex) {
                      Logger.getLogger(AddOrder.class.getName()).log(Level.SEVERE, null, ex);
                         }
                     df.format(date1);
                   
                      if(todayDate.after(date1)){
                             try (PrintWriter out = response.getWriter()) {
                           out.println("<script>");
                           out.println("alert('Please choose the correct date!');");
                              out.println("location='main/cart.jsp';");
                              out.println("</script>");
             }
                          
                      }
                      
                      else{
                    session.setAttribute("sessDate",date );
                    ArrayList<String> qtyy= (ArrayList<String>) session.getAttribute("qtyy");
            int[] qty= new int[100];
            for(int i=0;i<qtyy.size();i++){
                   String qtyS= request.getParameter("qty"+i);
                    qty[i] = Integer.parseInt(qtyS);
            }
  
           session.setAttribute("sessCartQty",qty );
           session.setAttribute("sessSelectTime",selecTime);
           response.sendRedirect("main/viewCart.jsp");
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

    private Object SimpleDateFormat(String yyyyMMdd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
