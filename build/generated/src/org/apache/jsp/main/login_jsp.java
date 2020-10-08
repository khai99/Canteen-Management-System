package org.apache.jsp.main;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import entity.Customer;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("  <meta charset=\"UTF-8\">\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("  <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n");
      out.write("  <title>Aroma Shop - Login</title>\n");
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
      out.write("\t<!--================ Start Header Menu Area =================-->\n");
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
      out.write("                  <li class=\"nav-item\"><a class=\"nav-link\" href=\"../viewFood\">Shop Category</a></li>\n");
      out.write("                    ");
 if(session.getAttribute("sessCustomer")!=null) {
      out.write(" \n");
      out.write("                  <li class=\"nav-item\"><a class=\"nav-link\" href=\"../ViewOrder\">Order History</a></li>\n");
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
      out.write("                  <li class=\"nav-item\"><a class=\"nav-link\" href=\"../topupPay\">Top-up history</a></li>\n");
      out.write("            \n");
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
      out.write("                    <li class=\"nav-item\"><a class=\"nav-link\" href=\"../logout\">Log out</a></li>\n");
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
      out.write("                      ");
 if(session.getAttribute("sessCustomer")!=null) {
      out.write("                                      \n");
      out.write("                 <ul class=\"nav-shop\">\n");
      out.write("              <li class=\"nav-item\"><a class=\"button button-header\" href=\"cart.jsp\">Food Cart</a></li>\n");
      out.write("            </ul>\n");
      out.write("                  \n");
      out.write("             ");
 } 
      out.write("\n");
      out.write("               \n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("            \n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </nav>\n");
      out.write("    </div>\n");
      out.write("  </header>\n");
      out.write("\t<!--================ End Header Menu Area =================-->\n");
      out.write("  \n");
      out.write("  <!-- ================ start banner area ================= -->\t\n");
      out.write("\t<section class=\"blog-banner-area\" id=\"category\">\n");
      out.write("\t\t<div class=\"container h-100\">\n");
      out.write("\t\t\t<div class=\"blog-banner\">\n");
      out.write("\t\t\t\t<div class=\"text-center\">\n");
      out.write("\t\t\t\t\t<h1>Login / Register</h1>\n");
      out.write("\t\t\t\t\t<nav aria-label=\"breadcrumb\" class=\"banner-breadcrumb\">\n");
      out.write("            <ol class=\"breadcrumb\">\n");
      out.write("              <li class=\"breadcrumb-item\"><a href=\"#\">Home</a></li>\n");
      out.write("              <li class=\"breadcrumb-item active\" aria-current=\"page\">Login/Register</li>\n");
      out.write("            </ol>\n");
      out.write("          </nav>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("    </div>\n");
      out.write("\t</section>\n");
      out.write("\t<!-- ================ end banner area ================= -->\n");
      out.write("  \n");
      out.write("  <!--================Login Box Area =================-->\n");
      out.write("\t<section class=\"login_box_area section-margin\">\n");
      out.write("\t\t<div class=\"container\">\n");
      out.write("\t\t\t<div class=\"row\">\n");
      out.write("\t\t\t\t<div class=\"col-lg-6\">\n");
      out.write("\t\t\t\t\t<div class=\"login_box_img\">\n");
      out.write("\t\t\t\t\t\t<div class=\"hover\">\n");
      out.write("\t\t\t\t\t\t\t<h4>New to our website?</h4>\n");
      out.write("\t\t\t\t\t\t\t<p>Quickly register a new account now to pre-order or ordering food from our canteen.  </p>\n");
      out.write("\t\t\t\t\t\t\t<a class=\"button button-account\" href=\"register.jsp\">Create an Account</a>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div class=\"col-lg-6\">\n");
      out.write("\t\t\t\t\t<div class=\"login_form_inner\">\n");
      out.write("\t\t\t\t\t\t<h3>Log in to enter</h3>\n");
      out.write("                                                <form class=\"row login_form\" action=\"../VerifyUser\" id=\"contactForm\" method=\"POST\" >\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-md-12 form-group\">\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"name\" name=\"custID\" placeholder=\"Student/Staff ID\" onfocus=\"this.placeholder = ''\" onblur=\"this.placeholder = 'Username'\" required=\"required\">\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-md-12 form-group\">\n");
      out.write("                                                            <input type=\"password\" class=\"form-control\" id=\"name\"  name=\"custPassword\" placeholder=\"Password\" onfocus=\"this.placeholder = ''\" onblur=\"this.placeholder = 'Password'\" required=\"required\">\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-md-12 form-group\">\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"creat_account\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" id=\"f-option2\" name=\"selector\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<label for=\"f-option2\">Keep me logged in</label>\n");
      out.write("\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-md-12 form-group\">\n");
      out.write("\t\t\t\t\t\t\t\t<button type=\"submit\" value=\"submit\" class=\"button button-login w-100\">Log In</button>\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"forgetpassword.jsp\">Forgot Password?</a>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t</form>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</section>\n");
      out.write("\t<!--================End Login Box Area =================-->\n");
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
      out.write("\n");
      out.write("  <script src=\"vendors/jquery/jquery-3.2.1.min.js\"></script>\n");
      out.write("  <script src=\"vendors/bootstrap/bootstrap.bundle.min.js\"></script>\n");
      out.write("  <script src=\"vendors/skrollr.min.js\"></script>\n");
      out.write("  <script src=\"vendors/owl-carousel/owl.carousel.min.js\"></script>\n");
      out.write("  <script src=\"vendors/nice-select/jquery.nice-select.min.js\"></script>\n");
      out.write("  <script src=\"vendors/jquery.ajaxchimp.min.js\"></script>\n");
      out.write("  <script src=\"vendors/mail-script.js\"></script>\n");
      out.write("  <script src=\"js/main.js\"></script>\n");
      out.write("</body>\n");
      out.write("</html>\n");
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
