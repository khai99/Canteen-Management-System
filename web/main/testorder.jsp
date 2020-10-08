<%-- 
    Document   : vieworder
    Created on : Apr 2, 2019, 7:02:14 PM
    Author     : User
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="entity.Food"%>
<%@page import="entity.Orderdetail"%>
<%@page import="entity.Orders"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
 List<Orders> orderList = (List<Orders>)session.getAttribute("sessViewOrder");
 List<Orderdetail> detailList = (List<Orderdetail>)session.getAttribute("sessViewOrderDetail");
 List<Food> foodList = (List<Food>)session.getAttribute("sessViewfood");
 String custID = (String)session.getAttribute("sessCustomerID");
 
SimpleDateFormat ft = 
      new SimpleDateFormat ("yyyy/MM/dd");
%>
 <!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Aroma Shop - Cart</title>
	<link rel="icon" href="img/Fevicon.png" type="image/png">
  <link rel="stylesheet" href="vendors/bootstrap/bootstrap.min.css">
  <link rel="stylesheet" href="vendors/fontawesome/css/all.min.css">
	<link rel="stylesheet" href="vendors/themify-icons/themify-icons.css">
	<link rel="stylesheet" href="vendors/linericon/style.css">
  <link rel="stylesheet" href="vendors/owl-carousel/owl.theme.default.min.css">
  <link rel="stylesheet" href="vendors/owl-carousel/owl.carousel.min.css">
  <link rel="stylesheet" href="vendors/nice-select/nice-select.css">
  <link rel="stylesheet" href="vendors/nouislider/nouislider.min.css">

  <link rel="stylesheet" href="css/style.css">
</head>
<body>
  <!--================ Start Header Menu Area =================-->
		<header class="header_area">
    <div class="main_menu">
      <nav class="navbar navbar-expand-lg navbar-light">
        <div class="container">
            <a class="navbar-brand logo_h" href="index.html"><img src="img/logo.png" alt="" style="width: 138px; height: 42px"></a>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <div class="collapse navbar-collapse offset" id="navbarSupportedContent">
            <ul class="nav navbar-nav menu_nav ml-auto mr-auto">
              <li class="nav-item active"><a style="" class="nav-link" href="index.html">Home</a></li>
              <li class="nav-item submenu dropdown">
                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                  aria-expanded="false">Menu</a>
                <ul class="dropdown-menu">
                  <li class="nav-item"><a class="nav-link" href="category.html">Shop Category</a></li>
                  <li class="nav-item"><a class="nav-link" href="single-product.html">Product Details</a></li>
                  <li class="nav-item"><a class="nav-link" href="checkout.html">Product Checkout</a></li>
                  <li class="nav-item"><a class="nav-link" href="confirmation.html">Confirmation</a></li>
                  <li class="nav-item"><a class="nav-link" href="cart.html">Shopping Cart</a></li>
                </ul>
							</li>
              <li class="nav-item submenu dropdown">
                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                  aria-expanded="false">Profile</a>
                <ul class="dropdown-menu">
                  <li class="nav-item"><a class="nav-link" href="blog.html">Blog</a></li>
                  <li class="nav-item"><a class="nav-link" href="single-blog.html">Blog Details</a></li>
                </ul>
							</li>
							
             
            </ul>
              
                  
               <ul class="nav navbar-nav menu_nav ml-auto mr-auto">
                  
                   <li style=" font-family:  sans-serif; margin-top: 40px; "><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></li> 
                   
              <li class="nav-item submenu dropdown">
                 
                  
                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                  aria-expanded="false"><img src="img/pro.jpg"  alt="" style="width: 42px; height: 42px; "></a>
                <ul class="dropdown-menu">
                  <li class="nav-item"><a class="nav-link" href="category.html">Log in</a></li>
                  
                  
                </ul>
							</li>
              
							
             
            </ul>
                                                        
          
             
               
							
            
          </div>
        </div>
      </nav>
    </div>
  </header>
	<!--================ End Header Menu Area =================-->

	<!-- ================ start banner area ================= -->	
	<section class="blog-banner-area" id="category">
		<div class="container h-100">
			<div class="blog-banner">
				<div class="text-center">
					<h1>View Order</h1>
					<nav aria-label="breadcrumb" class="banner-breadcrumb">
            <ol class="breadcrumb">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active" aria-current="page">View Order</li>
            </ol>
          </nav>
				</div>
			</div>
    </div>
	</section>
	<!-- ================ end banner area ================= -->
  
  

  <!--================Cart Area =================-->
  
  <section class="cart_area">
      <div class="container">
          
          <div class="cart_inner">
              <h2 style="font-size: 28px; margin-left: 20px;">Incomplete order</h2>
              <div class="table-responsive">
                  <table class="table">
                      <thead>
                          <tr>
                              <th scope="col">Order ID</th>
                              <th scope="col">Order Type</th>
                              <th scope="col">Order Date</th>
                              <th scope="col">Order Time</th>
                              <th scope="col">Total Amount</th>
                              <th scope="col">Order Food&Quantity</th>
                              
                              
                          </tr>
                      </thead>
                      <tbody>
                          <%   
                              int[] arr= new int [orderList.size()];
                              for(int i=0;i<orderList.size();i++) {
                                   if(orderList.get(i).getCustid().getCustid().equals(custID)){
                          if(orderList.get(i).getOrderstatus().equals("incomplete")){    
                          %>
                          <tr>
                              <% session.setAttribute("sessSelected",orderList.get(i).getOrderid()); %>
                              <td>
                                  <h5><%=orderList.get(i).getOrderid() %></h5>
                              </td>
                                <td>
                                 <h5><%=orderList.get(i).getOrdertype()%></h5>
                              </td>
                               <td>
                                 <h5><%=ft.format(orderList.get(i).getOrderdate())%></h5>
                              </td>
                              <td>
                                 <h5>to be enter</h5>
                              </td>
                               <td>
                                 <h5>RM--</h5>
                              </td>
                              <td>
                                 
                              </td>
                              
                              <td>
                                  <div class="cupon_text d-flex align-items-center">
                                      <form action="couponview"  >
                                          <button type="submit" name="" class="button" style="padding:10px; border-radius: 5px;" >View Coupon</button>
                                          <input name="orderbut" type="hidden" value="<%=orderList.get(i).getOrderid() %>">
                                      </form>
                                  </div>
                              </td>
                              <% if(orderList.get(i).getOrdertype().equals("Pre-order")){ %>
                              <td>
                                   <div class="cupon_text d-flex align-items-center">
                                  <form>
                                      <button type="submit" name="<%= "arr["+i+"]" %>" class="button" style="padding:10px; border-radius: 5px;" onclick="return confirm('Are you sure you want to cancel the order <%=orderList.get(i).getOrderid() %>?')">Cancel order</button>
                                      </form>
                                  </div>
                              </td>
                              <% } else {%>
                              <td>
                                  
                              </td>
                              <% }%>
                          </tr>
                          <% } } }%>
                          
                            <!---seconf -->
                           
                              <% for(int j=0;j< detailList.size();j++) { %>
                                     
                               
                                     
                                     <%=detailList.get(j).getQuantity() %></h5><br/>
                                 <% }%>
                           

                     
                         <% for(int k=0;k<foodList.size();k++){   %>
                              
                         <h5><%=foodList.get(k).getFoodname()%></h5>
                              
                            <%  }%>
                          
                         
                        
                      
                      </tbody>
                  </table>
              </div>
          </div>
      </div>
  </section>
  
  <!--       Complete-->
  
  
    <section class="cart_area">
      <div class="container">
          <div class="cart_inner">
              <h2 style="font-size: 28px; margin-left: 20px;">Completed order</h2>
              <div class="table-responsive">
                  <table class="table">
                      <thead>
                          <tr>
                       <th scope="col">Order ID</th>
                              <th scope="col">Order Type</th>
                              <th scope="col">Order Date</th>
                              <th scope="col">Order Time</th>
                              <th scope="col">Total Amount</th>
                              <th scope="col">Order Food&Quantity</th>
                              
                              
                          </tr>
                      </thead>
                      <tbody>
                               <%for(int i=0;i<orderList.size();i++) {
                          if(orderList.get(i).getOrderstatus().equals("redeem")){    
                          %>
                          <tr>
                              <td>
                                  <h5><%=orderList.get(i).getOrderid() %></h5>
                              </td>
                                <td>
                                 <h5><%=orderList.get(i).getOrdertype()%></h5>
                              </td>
                               <td>
                                 <h5><%=ft.format(orderList.get(i).getOrderdate())%></h5>
                              </td>
                              <td>
                                 <h5>to be enter</h5>
                              </td>
                               <td>
                                 <h5>RM--</h5>
                              </td>
                              <td>
                                 <% for(int j=0;j< detailList.size();j++) {
                                 if(detailList.get(j).getOrders().getOrderid().equals(orderList.get(i).getOrderid())) {  
                                 for(int k=0;k<foodList.size();k++){
                                   if(foodList.get(k).getFoodid().equals(detailList.get(j).getFood().getFoodid())) {%>
                                   <h5><%=foodList.get(k).getFoodname()%>  X <%=detailList.get(j).getQuantity() %></h5><br/>
                                 <% }}}}%>
                              </td>
                             
                             

                          </tr>
                          <% } }%>
                         
                        
                      
                      </tbody>
                  </table>
              </div>
          </div>
      </div>
  </section>
  
  
  
  
  
  
  
  
   <section class="cart_area">
      <div class="container">
          <div class="cart_inner">
              <h2 style="font-size: 28px; margin-left: 20px;">Canceled</h2>
              <div class="table-responsive">
                  <table class="table">
                      <thead>
                          <tr>
                          <th scope="col">Order ID</th>
                              <th scope="col">Order Type</th>
                              <th scope="col">Order Date</th>
                              <th scope="col">Order Time</th>
                              <th scope="col">Total Amount</th>
                              <th scope="col">Order Food&Quantity</th>
                              
                              
                          </tr>
                      </thead>
                      <tbody>
                  <%for(int i=0;i<orderList.size();i++) {
                          if(orderList.get(i).getOrderstatus().equals("canceled")){    
                          %>
                          <tr>
                              <td>
                                  <h5><%=orderList.get(i).getOrderid() %></h5>
                              </td>
                                <td>
                                 <h5><%=orderList.get(i).getOrdertype()%></h5>
                              </td>
                               <td>
                                 <h5><%=ft.format(orderList.get(i).getOrderdate())%></h5>
                              </td>
                              <td>
                                 <h5>to be enter</h5>
                              </td>
                               <td>
                                 <h5>RM--</h5>
                              </td>
                              <td>
                                 <% for(int j=0;j< detailList.size();j++) {
                                 if(detailList.get(j).getOrders().getOrderid().equals(orderList.get(i).getOrderid())) {  
                                 for(int k=0;k<foodList.size();k++){
                                   if(foodList.get(k).getFoodid().equals(detailList.get(j).getFood().getFoodid())) {%>
                                   <h5><%=foodList.get(k).getFoodname()%>  X <%=detailList.get(j).getQuantity() %></h5><br/>
                                 <% }}}}%>
                              </td>
                             


                          </tr>
                          <% } }%>
                       
                           

                          </tr>
                         
                        
                      
                      </tbody>
                  </table>
              </div>
          </div>
      </div>
  </section>
  <!--================End Cart Area =================-->



  <!--================ Start footer Area  =================-->	
	<footer>
		<div class="footer-area footer-only">
			<div class="container">
				<div class="row section_gap">
					<div class="col-lg-3 col-md-6 col-sm-6">
						<div class="single-footer-widget tp_widgets ">
							<h4 class="footer_title large_title">Our Mission</h4>
							<p>
								So seed seed green that winged cattle in. Gathering thing made fly you're no 
								divided deep moved us lan Gathering thing us land years living.
							</p>
							<p>
								So seed seed green that winged cattle in. Gathering thing made fly you're no divided deep moved 
							</p>
						</div>
					</div>
					<div class="offset-lg-1 col-lg-2 col-md-6 col-sm-6">
						<div class="single-footer-widget tp_widgets">
							<h4 class="footer_title">Quick Links</h4>
							<ul class="list">
								<li><a href="#">Home</a></li>
								<li><a href="#">Shop</a></li>
								<li><a href="#">Blog</a></li>
								<li><a href="#">Product</a></li>
								<li><a href="#">Brand</a></li>
								<li><a href="#">Contact</a></li>
							</ul>
						</div>
					</div>
					<div class="col-lg-2 col-md-6 col-sm-6">
						<div class="single-footer-widget instafeed">
							<h4 class="footer_title">Gallery</h4>
							<ul class="list instafeed d-flex flex-wrap">
								<li><img src="img/gallery/r1.jpg" alt=""></li>
								<li><img src="img/gallery/r2.jpg" alt=""></li>
								<li><img src="img/gallery/r3.jpg" alt=""></li>
								<li><img src="img/gallery/r5.jpg" alt=""></li>
								<li><img src="img/gallery/r7.jpg" alt=""></li>
								<li><img src="img/gallery/r8.jpg" alt=""></li>
							</ul>
						</div>
					</div>
					<div class="offset-lg-1 col-lg-3 col-md-6 col-sm-6">
						<div class="single-footer-widget tp_widgets">
							<h4 class="footer_title">Contact Us</h4>
							<div class="ml-40">
								<p class="sm-head">
									<span class="fa fa-location-arrow"></span>
									Head Office
								</p>
								<p>123, Main Street, Your City</p>
	
								<p class="sm-head">
									<span class="fa fa-phone"></span>
									Phone Number
								</p>
								<p>
									+123 456 7890 <br>
									+123 456 7890
								</p>
	
								<p class="sm-head">
									<span class="fa fa-envelope"></span>
									Email
								</p>
								<p>
									free@infoexample.com <br>
									www.infoexample.com
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="footer-bottom">
			<div class="container">
				<div class="row d-flex">
					<p class="col-lg-12 footer-text text-center">
						<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
				</div>
			</div>
		</div>
	</footer>
	<!--================ End footer Area  =================-->



  <script src="vendors/jquery/jquery-3.2.1.min.js"></script>
  <script src="vendors/bootstrap/bootstrap.bundle.min.js"></script>
  <script src="vendors/skrollr.min.js"></script>
  <script src="vendors/owl-carousel/owl.carousel.min.js"></script>
  <script src="vendors/nice-select/jquery.nice-select.min.js"></script>
  <script src="vendors/jquery.ajaxchimp.min.js"></script>
  <script src="vendors/mail-script.js"></script>
  <script src="js/main.js"></script>
</body>
</html>