/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entity.Customer;
import entity.Food;
import entity.FoodOrder;
import entity.Orderdetail;
import entity.Orders;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.Order;
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
public class AddOrderNow extends HttpServlet {
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
         HttpSession session = request.getSession();
           String cust=(String)session.getAttribute("sessCustomerID");
           List<Customer> custList = em.createNamedQuery("Customer.findAll").getResultList();
           Double total2= new Double(session.getAttribute("total2").toString());
            boolean checking=true;
            Double cp = 0.0;
            for(int i = 0; i < custList.size(); i++){
             if(custList.get(i).getCustid().equals(cust)){
                cp = custList.get(i).getCreditpoint();
             
             }
            
            
            }
            
          
           if(cp<total2){
               
              checking=false;
         
           }
           
           if(checking==true){
         Customer customerID= em.find(Customer.class, cust);
         
         
             String dated= (String)session.getAttribute("sessDate");
    
       
       
       
        List<FoodOrder> fOrderList = (List)session.getAttribute("sessOrderNowFood"); 
     int[] qty = new int[100];
                 qty= (int[])session.getAttribute("sessCartQty2"); 
      List<Order> orderList= em.createNamedQuery("Orders.findAll").getResultList();
      List<Food> foodList= em.createNamedQuery("Food.findAll").getResultList();
      int ordersize= orderList.size()+1;
      String orderID="R"+String.format("%05d", ordersize);
      Double total= new Double(session.getAttribute("total2").toString());
      for(int i=0;i<fOrderList.size();i++){
          fOrderList.get(i).setFoodquantity(qty[i]);
          
      }
      
    Orders orderf=new Orders(orderID) ;
   
    orderf.setOrdertype("Order Now");
    orderf.setTotalamount(total);
   
    Date date1= new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
    sdf.format(date1);
    
    orderf.setOrderdate(date1);
    orderf.setOrdertime("Redeem Now");
    
    orderf.setOrderstatus("incomplete");
    orderf.setCustid(customerID);
    boolean check =false;
    boolean check1 =false;
    try {
            //add record into DB
            //start user tansaction
            utx.begin();
            
            em.persist(orderf);
            
            //execute to insert record
            utx.commit();
            
            
         check=true;
            
            
        } catch (Exception ex) {
            Logger.getLogger(AddCustomer.class.getName()).log(Level.ALL.SEVERE, null, ex);
        }
    
  
  
         for(int i=0;i<fOrderList.size();i++){
           for(int j=0;j<foodList.size();j++){
               if(fOrderList.get(i).getFoodID().equals(foodList.get(j).getFoodid())){
             String foodID=foodList.get(j).getFoodid();
              Orderdetail od=new Orderdetail(orderID,foodID);
             
          od.setQuantity(fOrderList.get(i).getFoodquantity());
            try {
            //add record into DB
            //start user tansaction
            utx.begin();
            
            em.persist(od);
            
            //execute to insert record
            utx.commit();
            
            
         check1=true;
            
            
        } catch (Exception ex) {
            Logger.getLogger(AddCustomer.class.getName()).log(Level.ALL.SEVERE, null, ex);
        }
               }
           }
         
      }
        Customer custo=em.find(Customer.class, cust);
        
        custo.setCreditpoint(cp-total2);
         try {
            //add record into DB
            //start user tansaction
            utx.begin();
            
            em.merge(custo);
            
            //execute to insert record
            utx.commit();
            
     
            
        } catch (Exception ex) {
            Logger.getLogger(AddCustomer.class.getName()).log(Level.ALL.SEVERE, null, ex);
        }
    
           if(check&&check1==true ){
              session.setAttribute("sessCustomer",custo);
                  session.setAttribute("sessClearCart2","clear" );
                 response.sendRedirect("AddtoCart");
            }
               }
           else{
                try (PrintWriter out = response.getWriter()) {
                          out.println("<script>");
            out.println("alert('Not enough credit point!Kindly top up at canteen');");
            out.println("location='main/cart.jsp';");
            out.println("</script>");
               }
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
        processRequest(request, response);
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
