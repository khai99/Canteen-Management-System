/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author User
 */
public class updateQuantity2 extends HttpServlet {

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
            ArrayList<String> qtyy= (ArrayList<String>) session.getAttribute("qtyy2");
            int[] qty= new int[100];
            for(int i=0;i<qtyy.size();i++){
                   String qtyS= request.getParameter("qty"+i);
                    qty[i] = Integer.parseInt(qtyS);
            }
  
           session.setAttribute("sessCartQty2",qty );
           
           session.setAttribute("sessCartType2","type" );
       
        response.sendRedirect("AddtoCart");
            }
            else{
                boolean check=true;
                         double total =(double) session.getAttribute("checktotal2");
                     
                      if(total==0){
                   check=false;
                    try (PrintWriter out = response.getWriter()) {
                          out.println("<script>");
            out.println("alert('Must consist at least one item');");
            out.println("location='main/ordercart.jsp';");
            out.println("</script>");
               }
                
            }
             
              if(check=true){
          ArrayList<String> qtyy= (ArrayList<String>) session.getAttribute("qtyy2");
            int[] qty= new int[100];
            for(int i=0;i<qtyy.size();i++){
                   String qtyS= request.getParameter("qty"+i);
                    qty[i] = Integer.parseInt(qtyS);
            }
  
           session.setAttribute("sessCartQty2",qty );
           response.sendRedirect("main/viewCart2.jsp");
              }    }
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
