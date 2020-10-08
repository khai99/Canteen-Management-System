/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Ingredient;
import java.io.IOException;
import java.io.PrintWriter;
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
public class confirmUpdateIngredient extends HttpServlet {
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
            out.println("<title>Servlet confirmUpdateIngredient</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet confirmUpdateIngredient at " + request.getContextPath() + "</h1>");
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
          String ingreID = (String)session.getAttribute("sessIngreID");
          
          String ingreName = request.getParameter("iName");
      
          
           List<Ingredient> ingreValidate = em.createNamedQuery("Ingredient.findAll").getResultList();
           int check = 0;
           for(int i = 0; i < ingreValidate.size();i++){
         if(ingreName.equalsIgnoreCase(ingreValidate.get(i).getIngredientname())){
              check = 1;
         }
        
        }
            if(check == 1){
         try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<script>");
            out.println("alert('Same Ingredient name being used or contain incorrect value!')");
            out.println("location='loadIngredientTable';");
            
           out.println("</script>"); 
            }
      }
          else if(check == 0){
          Ingredient ingredient = em.find(Ingredient.class, ingreID);
          
          ingredient.setIngredientname(ingreName);
          
          
              try {
            utx.begin();
            
            em.merge(ingredient);
            
            utx.commit();
             
          
             
            
            
            //redirect user to StaffPage page
            
              try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<script>");
            out.println("alert('Your Ingredient Have been succesfully Updated')");
            out.println("location='loadIngredientTable'");
            
           out.println("</script>"); 
              }
       }catch(IllegalStateException ex){
       
       }catch(NotSupportedException ex){
       
       }catch(RollbackException ex){
       
       }catch(HeuristicMixedException ex){
       
       }catch(SystemException ex){
       
       }catch(HeuristicRollbackException ex){
       
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
