/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Food;
import entity.Fooddetail;
import entity.Ingredient;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
public class processUpdateFood extends HttpServlet {
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
            out.println("<title>Servlet processUpdateFood</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet processUpdateFood at " + request.getContextPath() + "</h1>");
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
       List<Ingredient> allIngreList = em.createNamedQuery("Ingredient.findAll").getResultList();
      
      
       
      
        List<Fooddetail> sltFood= new ArrayList<Fooddetail>();
       
          List<Food> foodList = (List)session.getAttribute("sessFoodList");
         String foodid = "";
         for(int i = 0 ;i<foodList.size();i++ ){
           
            if(request.getParameter("selectArr["+i+"]")!= null)
            {
              foodid = foodList.get(i).getFoodid();
                
            }
               
        }
        
          List<Fooddetail> allFoodList = em.createNamedQuery("Fooddetail.findByFoodid").setParameter("foodid", foodid).getResultList();
          
          
         // List<Fooddetail> validateFood = em.find(Fooddetail.class, );
       
        session.setAttribute("sessIngredient", allIngreList);
        session.setAttribute("sessAllFood", allFoodList);
        session.setAttribute("sessFoodSelectedID", foodid);
        response.sendRedirect("Admin/updateFood.jsp");
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
