package org.apache.jsp.main;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import entity.Food;
import entity.Customer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import entity.FoodOrder;

public final class cart_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      entity.Customer sessCustomer = null;
      synchronized (session) {
        sessCustomer = (entity.Customer) _jspx_page_context.getAttribute("sessCustomer", PageContext.SESSION_SCOPE);
        if (sessCustomer == null){
          sessCustomer = new entity.Customer();
          _jspx_page_context.setAttribute("sessCustomer", sessCustomer, PageContext.SESSION_SCOPE);
        }
      }
      out.write('\n');
 
 List<FoodOrder> fOrderList = (List)session.getAttribute("sessCartFood");
 double total=0;
 List<Food> foodList = (List)session.getAttribute("sessFoodList");
 
  ArrayList<String> qty=new ArrayList<String>();
  String date1 = "";
  Date date=new Date();
  SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
  date1 = sdf.format(date);
    
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("  <meta charset=\"UTF-8\">\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("  <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n");
      out.write("  <title>Aroma Shop - Cart</title>\n");
      out.write("\t<link rel=\"icon\" href=\"img/Fevicon.png\" type=\"image/png\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"vendors/bootstrap/bootstrap.min.css\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"vendors/fontawesome/css/all.min.css\">\n");
      out.write("\t<link rel=\"stylesheet\" href=\"vendors/themify-icons/themify-icons.css\">\n");
      out.write("\t<link rel=\"stylesheet\" href=\"vendors/linericon/style.css\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"vendors/owl-carousel/owl.theme.default.min.css\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"vendors/owl-carousel/owl.carousel.min.css\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"vendors/nice-select/nice-select.css\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"vendors/nouislider/nouislider.min.css\">\n");
      out.write("\n");
      out.write("  <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("  <!--================ Start Header Menu Area =================-->\n");
      out.write("\t<header class=\"header_area\">\n");
      out.write("    <div class=\"main_menu\">\n");
      out.write("      <nav class=\"navbar navbar-expand-lg navbar-light\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <a class=\"navbar-brand logo_h\" href=\"index.jsp\"><img src=\"img/logo.png\" alt=\"\" style=\"width: 138px; height: 42px\"></a>\n");
      out.write("          <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\"\n");
      out.write("            aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("            <span class=\"icon-bar\"></span>\n");
      out.write("            <span class=\"icon-bar\"></span>\n");
      out.write("            <span class=\"icon-bar\"></span>\n");
      out.write("          </button>\n");
      out.write("          <div class=\"collapse navbar-collapse offset\" id=\"navbarSupportedContent\">\n");
      out.write("            <ul class=\"nav navbar-nav menu_nav ml-auto mr-auto\">\n");
      out.write("              <li class=\"nav-item active\"><a style=\"\" class=\"nav-link\" href=\"index.jsp\">Home</a></li>\n");
      out.write("              <li class=\"nav-item submenu dropdown\">\n");
      out.write("                <a href=\"#\" class=\"nav-link dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\"\n");
      out.write("                  aria-expanded=\"false\">Menu</a>\n");
      out.write("                <ul class=\"dropdown-menu\">\n");
      out.write("                  <li class=\"nav-item\"><a class=\"nav-link\" href=\"viewFood\">Shop Category</a></li>\n");
      out.write("                    ");
 if(session.getAttribute("sessCustomer")!=null) {
      out.write(" \n");
      out.write("                  <li class=\"nav-item\"><a class=\"nav-link\" href=\"ViewOrder\">Order History</a></li>\n");
      out.write("                  ");
 } 
      out.write("\n");
      out.write("                  \n");
      out.write("                 \n");
      out.write("                  \n");
      out.write("                </ul>\n");
      out.write("\t\t\t\t\t\t\t</li>\n");
      out.write("               ");
 if(session.getAttribute("sessCustomer")==null) {
      out.write("   \n");
      out.write("             \n");
      out.write("      \n");
      out.write("                                                                        ");
 }else{ 
      out.write("\n");
      out.write("                                                                          \n");
      out.write("                                                                      \n");
      out.write("              <li class=\"nav-item submenu dropdown\">\n");
      out.write("                <a href=\"#\" class=\"nav-link dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\"\n");
      out.write("                  aria-expanded=\"false\">Profile</a>\n");
      out.write("                <ul class=\"dropdown-menu\">\n");
      out.write("                  <li class=\"nav-item\"><a class=\"nav-link\" href=\"profileview.jsp\">View profile</a></li>\n");
      out.write("                   \n");
      out.write("                  <li class=\"nav-item\"><a class=\"nav-link\" href=\"topupPay\">Top-up history</a></li>\n");
      out.write("                \n");
      out.write("                </ul>\n");
      out.write("\t\t\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t\t\t  ");
} 
      out.write("\n");
      out.write("             \n");
      out.write("            </ul>\n");
      out.write("              \n");
      out.write("                  \n");
      out.write("               <ul class=\"nav navbar-nav menu_nav ml-auto\">\n");
      out.write("                  \n");
      out.write("                   <li style=\" font-family:  sans-serif; margin-top: 40px; \"><b>");
 if(session.getAttribute("sessCustomer")==null) { } else {
                          Customer cust = (Customer)session.getAttribute("sessCustomer") ; 
      out.print( cust.getCustname());
      out.write(' ');
 }
      out.write("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></li> \n");
      out.write("                   \n");
      out.write("              <li class=\"nav-item submenu dropdown\">\n");
      out.write("                 \n");
      out.write("                  \n");
      out.write("                <a href=\"#\" class=\"nav-link dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\"\n");
      out.write("                  aria-expanded=\"false\"><img src=\"img/pro.jpg\"  alt=\"\" style=\"width: 42px; height: 42px; \"></a>\n");
      out.write("                <ul class=\"dropdown-menu\">\n");
      out.write("                       ");
 if(session.getAttribute("sessCustomer")==null) {
      out.write("   \n");
      out.write("                  <li class=\"nav-item\"><a class=\"nav-link\" href=\"login.jsp\">Log in</a></li>\n");
      out.write("                   ");
 }else{ 
      out.write("\n");
      out.write("                    <li class=\"nav-item\"><a class=\"nav-link\" href=\"logout\">Log out</a></li>\n");
      out.write("                  \n");
      out.write("                  ");
 } 
      out.write("\n");
      out.write("                  \n");
      out.write("           \n");
      out.write("                  \n");
      out.write("                </ul>\n");
      out.write("\t\t\t\t\t\t\t</li>\n");
      out.write("              \n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("             \n");
      out.write("            </ul>\n");
      out.write("                                                        \n");
      out.write("                 <ul class=\"nav-shop\">\n");
      out.write("              <li class=\"nav-item\"><a class=\"button button-header\" href=\"cart.jsp\">Food Cart</a></li>\n");
      out.write("            </ul>\n");
      out.write("                  \n");
      out.write("             \n");
      out.write("               \n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("            \n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </nav>\n");
      out.write("    </div>\n");
      out.write("  </header>\n");
      out.write("\t<!--================ End Header Menu Area =================-->\n");
      out.write("\n");
      out.write("\t<!-- ================ start banner area ================= -->\t\n");
      out.write("\t<section class=\"blog-banner-area\" id=\"category\">\n");
      out.write("\t\t<div class=\"container h-100\">\n");
      out.write("\t\t\t<div class=\"blog-banner\">\n");
      out.write("\t\t\t\t<div class=\"text-center\">\n");
      out.write("\t\t\t\t\t<h1>Pre-order Cart</h1>\n");
      out.write("\t\t\t\t\t<nav aria-label=\"breadcrumb\" class=\"banner-breadcrumb\">\n");
      out.write("            <ol class=\"breadcrumb\">\n");
      out.write("              <li class=\"breadcrumb-item\"><a href=\"#\">Home</a></li>\n");
      out.write("              <li class=\"breadcrumb-item active\" aria-current=\"page\">Pre-order Cart</li>\n");
      out.write("            </ol>\n");
      out.write("          </nav>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("    </div>\n");
      out.write("\t</section>\n");
      out.write("\t<!-- ================ end banner area ================= -->\n");
      out.write("  \n");
      out.write("  \n");
      out.write("\n");
      out.write("  <!--================Cart Area =================-->\n");
      out.write("  <section class=\"cart_area\">\n");
      out.write("      <div class=\"container\">\n");
      out.write("          <div class=\"cart_inner\">\n");
      out.write("              <div class=\"table-responsive\">\n");
      out.write("                 \n");
      out.write("                                  \n");
      out.write("                                  <a class=\"button\" style=\"padding:14px; border-radius: 5px; width: 130px;\" href=\"cart.jsp\">Pre-order Cart</a>\n");
      out.write("                                  <a class=\"button\" style=\"padding:14px; border-radius: 5px; width: 130px;\"href=\"ordercart.jsp\">&nbsp;&nbsp;&nbsp;Order Cart</a><br/><br/><br/>\n");
      out.write("                     ");
 if(session.getAttribute("sessCartFood")!=null) {
      out.write("       \n");
      out.write("                  <table class=\"table\">\n");
      out.write("                     \n");
      out.write("                      <thead>\n");
      out.write("                          <tr>\n");
      out.write("                              <th></th>\n");
      out.write("                              <th scope=\"col\">Food image</th>\n");
      out.write("                              <th scope=\"col\">Food Name</th>\n");
      out.write("                              <th scope=\"col\">Food Quantity</th>\n");
      out.write("                              <th scope=\"col\">Price</th>\n");
      out.write("                              <th scope=\"col\">Total Price</th>\n");
      out.write("                          </tr>\n");
      out.write("                      </thead>\n");
      out.write("                      <form action=\"../updateQuantity\" method=\"POST\">\n");
      out.write("                          \n");
      out.write("                      <tbody>\n");
      out.write("                          ");

                             
                              
                              for(int i=0;i < fOrderList.size(); i++){
                              
                          
                          
      out.write("\n");
      out.write("                          <tr>\n");
      out.write("                                <td>\n");
      out.write("                                  \n");
      out.write("                                  <a  href=\"../remove?id=");
      out.print(fOrderList.get(i).getFoodID() );
      out.write("\" onclick=\"return confirm('Are you sure you want to remove ");
      out.print(fOrderList.get(i).getFoodName() );
      out.write("?')\" >\n");
      out.write("                                     \n");
      out.write("                                      \n");
      out.write("                                       <img style=\"width: 20px; height: 20px;\" src=\"img/remove.png\" alt=\"\">\n");
      out.write("                                  </a>     \n");
      out.write("                                                   \n");
      out.write("                              </td>\n");
      out.write("                              <td>\n");
      out.write("                                  <div class=\"media\">\n");
      out.write("                                      <div class=\"d-flex\">\n");
      out.write("                                          ");
 for(int j=0;j<foodList.size();j++){
                                           if(fOrderList.get(i).getFoodID().equals(foodList.get(j).getFoodid())){                                 
      out.write("\n");
      out.write("                                           <img style=\"width: 100px; height: 100px;\" src=\"img/product/");
      out.print(foodList.get(j).getFoodimg() );
      out.write("\" alt=\"\">\n");
      out.write("                                       ");
 }}
      out.write("\n");
      out.write("                                      </div>\n");
      out.write("                                      \n");
      out.write("                                  </div>\n");
      out.write("                              </td>\n");
      out.write("                              <td>\n");
      out.write("                                  <h5>");
      out.print(fOrderList.get(i).getFoodName() );
      out.write("</h5>\n");
      out.write("                              </td>\n");
      out.write("                              <td>\n");
      out.write("                                  <div class=\"product_count\">\n");
      out.write("                                      <input type=\"number\" name=\"qty");
      out.print(i);
      out.write("\" id=\"sst");
      out.print(i );
      out.write("\" min=\"1\" maxlength=\"12\" value=\"");
      out.print(fOrderList.get(i).getFoodquantity());
      out.write("\" title=\"Quantity:\"\n");
      out.write("                                          class=\"input-text qty\">\n");
      out.write("                                     \n");
      out.write("                                                                       </div>\n");
      out.write("                              </td>\n");
      out.write("                              <td>\n");
      out.write("                                  <h5>RM");
      out.print(String.format("%.2f", fOrderList.get(i).getFoodprice()) );
      out.write("</h5>\n");
      out.write("                              </td>\n");
      out.write("                              <td>\n");
      out.write("                                  <h5>RM");
      out.print(String.format("%.2f", fOrderList.get(i).getFoodprice()*fOrderList.get(i).getFoodquantity()) );
      out.write("</h5>\n");
      out.write("                              </td>\n");
      out.write("                          </tr>\n");
      out.write("                               ");
   
                                   total+=fOrderList.get(i).getFoodprice() *fOrderList.get(i).getFoodquantity();
                                  
                                          qty.add("qty"+i);
                                          
                                       }  
      out.write("\n");
      out.write("                          \n");
      out.write("                                       ");
 session.setAttribute("qtyy", qty); 
      out.write("\n");
      out.write("                              <tr class=\"shipping_area\">\n");
      out.write("                                  <td>\n");
      out.write("\n");
      out.write("                              </td>\n");
      out.write("                              <td class=\"d-none d-md-block\">\n");
      out.write("                                      <input type=\"submit\" value=\"Update Cart\" class=\"button\" style=\"padding:10px; border-radius: 5px; width: 120px; height: 50px\" id=\"submit\" name=\"button\" />\n");
      out.write("                              </td>\n");
      out.write("                              \n");
      out.write("                              <td>\n");
      out.write("\n");
      out.write("                              </td>\n");
      out.write("                              <td>\n");
      out.write("                                 \n");
      out.write("                              </td>\n");
      out.write("                              <td>\n");
      out.write("\n");
      out.write("                              </td>\n");
      out.write("                              <td>\n");
      out.write("                                  <div class=\"shipping_box\">\n");
      out.write("                                      \n");
      out.write("                                      <h6>Order Date <i class=\"fa fa-caret-down\" aria-hidden=\"true\"></i></h6>\n");
      out.write("                                      <input style=\"font-size: 16px; font-family: 'Material-Design-Iconic-Font'; \" type=\"date\" value=\"\" id=\"date\" name=\"date\"  />\n");
      out.write("                                      \n");
      out.write("                                      <h6>Order Time <i class=\"fa fa-caret-down\" aria-hidden=\"true\"></i></h6>\n");
      out.write("                                       <select class=\"shipping_select\">\n");
      out.write("                                          <option value=\"1\">Breakfast</option>\n");
      out.write("                                          <option value=\"2\">lunch</option>\n");
      out.write("                                          \n");
      out.write("                                      </select>\n");
      out.write("                                       \n");
      out.write("                                    \n");
      out.write("                                  </div>\n");
      out.write("                              </td>\n");
      out.write("                          </tr>\n");
      out.write("                     \n");
      out.write("                          \n");
      out.write("                         \n");
      out.write("                                              \n");
      out.write("                          <tr>\n");
      out.write("                               <td>\n");
      out.write("\n");
      out.write("                              </td>\n");
      out.write("                              <td>\n");
      out.write("\n");
      out.write("                              </td>\n");
      out.write("                              <td>\n");
      out.write("\n");
      out.write("                              </td>\n");
      out.write("                              <td>\n");
      out.write("\n");
      out.write("                              </td>\n");
      out.write("                              <td>\n");
      out.write("                                  <h5>Subtotal</h5>\n");
      out.write("                              </td>\n");
      out.write("                              <td>\n");
      out.write("                                  \n");
      out.write("                                  <h5>RM");
      out.print(String.format("%.2f",total) );
      out.write("</h5>\n");
      out.write("                                  ");
 session.setAttribute("checktotal", total); 
      out.write("\n");
      out.write("                              </td>\n");
      out.write("                          </tr>\n");
      out.write("                \n");
      out.write("                          <tr class=\"out_button_area\">\n");
      out.write("                              <td class=\"d-none-l\">\n");
      out.write("\n");
      out.write("                              </td>\n");
      out.write("                              <td class=\"\">\n");
      out.write("\n");
      out.write("                              </td>\n");
      out.write("                               <td>\n");
      out.write("\n");
      out.write("                              </td>\n");
      out.write("                              \n");
      out.write("                              <td>\n");
      out.write("\n");
      out.write("                              </td>\n");
      out.write("                              <td>\n");
      out.write("\n");
      out.write("                              </td>\n");
      out.write("                              <td>\n");
      out.write("                                  <div class=\"checkout_btn_inner d-flex align-items-center\">\n");
      out.write("                                      \n");
      out.write("                                        <a class=\"gray_btn\" href=\"category.jsp\"  style=\" width: 220px; \" >Continue Shopping</a>\n");
      out.write("                                        &nbsp;&nbsp;&nbsp;\n");
      out.write("                                      \n");
      out.write("                                       <input type=\"submit\" value=\"Proceed Checkout\" class=\"button\" style=\" width: 220px; height: 50px\" id=\"datePicker\" name=\"button\" />\n");
      out.write("                                  </div>\n");
      out.write("                              </td>\n");
      out.write("                          </tr>\n");
      out.write("                     \n");
      out.write("                      </tbody>\n");
      out.write("                         </form>\n");
      out.write("\n");
      out.write("                  </table>\n");
      out.write("                   \n");
      out.write("              </div>\n");
      out.write("\n");
      out.write("          </div>\n");
      out.write("                               \n");
      out.write("      </div>\n");
      out.write("                                                               ");
 }else{ 
      out.write("\n");
      out.write("                                <div >\n");
      out.write("                                    <br/><br/><br/><p style=\"font-size: 45px;  \" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;No record found</p><br/><br/><br/><br/><br/><br/>                \n");
      out.write("                                </div>\n");
      out.write("                    ");
} 
      out.write("\n");
      out.write("  </section>\n");
      out.write("  <!--================End Cart Area =================-->\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("  <!--================ Start footer Area  =================-->\t\n");
      out.write("\t<footer>\n");
      out.write("\t\t<div class=\"footer-area footer-only\">\n");
      out.write("\t\t\t<div class=\"container\">\n");
      out.write("\t\t\t\t<div class=\"row section_gap\">\n");
      out.write("\t\t\t\t\t<div class=\"col-lg-3 col-md-6 col-sm-6\">\n");
      out.write("\t\t\t\t\t\t<div class=\"single-footer-widget tp_widgets \">\n");
      out.write("\t\t\t\t\t\t\t<h4 class=\"footer_title large_title\">Our Mission</h4>\n");
      out.write("\t\t\t\t\t\t\t<p>\n");
      out.write("\t\t\t\t\t\t\t\tSo seed seed green that winged cattle in. Gathering thing made fly you're no \n");
      out.write("\t\t\t\t\t\t\t\tdivided deep moved us lan Gathering thing us land years living.\n");
      out.write("\t\t\t\t\t\t\t</p>\n");
      out.write("\t\t\t\t\t\t\t<p>\n");
      out.write("\t\t\t\t\t\t\t\tSo seed seed green that winged cattle in. Gathering thing made fly you're no divided deep moved \n");
      out.write("\t\t\t\t\t\t\t</p>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div class=\"offset-lg-1 col-lg-2 col-md-6 col-sm-6\">\n");
      out.write("\t\t\t\t\t\t<div class=\"single-footer-widget tp_widgets\">\n");
      out.write("\t\t\t\t\t\t\t<h4 class=\"footer_title\">Quick Links</h4>\n");
      out.write("\t\t\t\t\t\t\t<ul class=\"list\">\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"#\">Home</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"#\">Shop</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"#\">Blog</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"#\">Product</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"#\">Brand</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"#\">Contact</a></li>\n");
      out.write("\t\t\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div class=\"col-lg-2 col-md-6 col-sm-6\">\n");
      out.write("\t\t\t\t\t\t<div class=\"single-footer-widget instafeed\">\n");
      out.write("\t\t\t\t\t\t\t<h4 class=\"footer_title\">Gallery</h4>\n");
      out.write("\t\t\t\t\t\t\t<ul class=\"list instafeed d-flex flex-wrap\">\n");
      out.write("\t\t\t\t\t\t\t\t<li><img src=\"img/gallery/r1.jpg\" alt=\"\"></li>\n");
      out.write("\t\t\t\t\t\t\t\t<li><img src=\"img/gallery/r2.jpg\" alt=\"\"></li>\n");
      out.write("\t\t\t\t\t\t\t\t<li><img src=\"img/gallery/r3.jpg\" alt=\"\"></li>\n");
      out.write("\t\t\t\t\t\t\t\t<li><img src=\"img/gallery/r5.jpg\" alt=\"\"></li>\n");
      out.write("\t\t\t\t\t\t\t\t<li><img src=\"img/gallery/r7.jpg\" alt=\"\"></li>\n");
      out.write("\t\t\t\t\t\t\t\t<li><img src=\"img/gallery/r8.jpg\" alt=\"\"></li>\n");
      out.write("\t\t\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div class=\"offset-lg-1 col-lg-3 col-md-6 col-sm-6\">\n");
      out.write("\t\t\t\t\t\t<div class=\"single-footer-widget tp_widgets\">\n");
      out.write("\t\t\t\t\t\t\t<h4 class=\"footer_title\">Contact Us</h4>\n");
      out.write("\t\t\t\t\t\t\t<div class=\"ml-40\">\n");
      out.write("\t\t\t\t\t\t\t\t<p class=\"sm-head\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<span class=\"fa fa-location-arrow\"></span>\n");
      out.write("\t\t\t\t\t\t\t\t\tHead Office\n");
      out.write("\t\t\t\t\t\t\t\t</p>\n");
      out.write("\t\t\t\t\t\t\t\t<p>123, Main Street, Your City</p>\n");
      out.write("\t\n");
      out.write("\t\t\t\t\t\t\t\t<p class=\"sm-head\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<span class=\"fa fa-phone\"></span>\n");
      out.write("\t\t\t\t\t\t\t\t\tPhone Number\n");
      out.write("\t\t\t\t\t\t\t\t</p>\n");
      out.write("\t\t\t\t\t\t\t\t<p>\n");
      out.write("\t\t\t\t\t\t\t\t\t+123 456 7890 <br>\n");
      out.write("\t\t\t\t\t\t\t\t\t+123 456 7890\n");
      out.write("\t\t\t\t\t\t\t\t</p>\n");
      out.write("\t\n");
      out.write("\t\t\t\t\t\t\t\t<p class=\"sm-head\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<span class=\"fa fa-envelope\"></span>\n");
      out.write("\t\t\t\t\t\t\t\t\tEmail\n");
      out.write("\t\t\t\t\t\t\t\t</p>\n");
      out.write("\t\t\t\t\t\t\t\t<p>\n");
      out.write("\t\t\t\t\t\t\t\t\tfree@infoexample.com <br>\n");
      out.write("\t\t\t\t\t\t\t\t\twww.infoexample.com\n");
      out.write("\t\t\t\t\t\t\t\t</p>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\n");
      out.write("\t\t<div class=\"footer-bottom\">\n");
      out.write("\t\t\t<div class=\"container\">\n");
      out.write("\t\t\t\t<div class=\"row d-flex\">\n");
      out.write("\t\t\t\t\t<p class=\"col-lg-12 footer-text text-center\">\n");
      out.write("\t\t\t\t\t\t<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->\n");
      out.write("Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class=\"fa fa-heart\" aria-hidden=\"true\"></i> by <a href=\"https://colorlib.com\" target=\"_blank\">Colorlib</a>\n");
      out.write("<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</footer>\n");
      out.write("\t<!--================ End footer Area  =================-->\n");
      out.write("\n");
      out.write("\n");
      out.write("<script> \n");
      out.write(" \n");
      out.write("</script>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("        \n");
      out.write("            var today = new Date();\n");
      out.write("         \n");
      out.write("var dd = today.getDate();\n");
      out.write("var mm = today.getMonth()+1; //January is 0!\n");
      out.write("var maxMM = today.getMonth()+2; \n");
      out.write("var maxDay = today.getDate();\n");
      out.write("var yyyy = today.getFullYear();\n");
      out.write("dd+=2;\n");
      out.write(" if(dd<10){\n");
      out.write("        dd='0'+dd\n");
      out.write("    } \n");
      out.write("    if(mm<10){\n");
      out.write("        mm='0'+mm\n");
      out.write("    } \n");
      out.write("    if(maxMM<10){\n");
      out.write("        maxMM='0'+maxMM\n");
      out.write("    } \n");
      out.write("          if(mm==12){\n");
      out.write("        maxMM =1;\n");
      out.write("    } \n");
      out.write("    \n");
      out.write("\n");
      out.write("\n");
      out.write("today = yyyy+'-'+mm+'-'+dd;\n");
      out.write("maxDay = yyyy+'-'+maxMM+'-'+dd;\n");
      out.write("\n");
      out.write("document.getElementById(\"date\").setAttribute(\"min\", today);\n");
      out.write("document.getElementById(\"date\").setAttribute(\"max\",maxDay );\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write(" </script> \n");
      out.write("  <script src=\"vendors/jquery/jquery-3.2.1.min.js\"></script>\n");
      out.write("  <script src=\"vendors/bootstrap/bootstrap.bundle.min.js\"></script>\n");
      out.write("  <script src=\"vendors/skrollr.min.js\"></script>\n");
      out.write("  <script src=\"vendors/owl-carousel/owl.carousel.min.js\"></script>\n");
      out.write("  <script src=\"vendors/nice-select/jquery.nice-select.min.js\"></script>\n");
      out.write("  <script src=\"vendors/jquery.ajaxchimp.min.js\"></script>\n");
      out.write("  <script src=\"vendors/mail-script.js\"></script>\n");
      out.write("  <script src=\"js/main.js\"></script>\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
