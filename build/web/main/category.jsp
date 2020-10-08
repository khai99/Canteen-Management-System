<%-- 
    Document   : category
    Created on : Mar 30, 2019, 9:49:33 AM
    Author     : vinso
--%>
<%@page import="entity.Customer"%>
<%@page import="entity.Food"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
List<Food> foodList = (List)session.getAttribute("sessFoodList");
String type= (String) session.getAttribute("sessFoodType");
 %>
<!DOCTYPE html>
﻿<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Aroma Shop - Category</title>
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
            <a class="navbar-brand logo_h" href="index.jsp"><img src="img/logo.png" alt="" style="width: 138px; height: 42px"></a>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <div class="collapse navbar-collapse offset" id="navbarSupportedContent">
            <ul class="nav navbar-nav menu_nav ml-auto mr-auto">
              <li class="nav-item active"><a style="" class="nav-link" href="index.jsp">Home</a></li>
              <li class="nav-item submenu dropdown">
                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                  aria-expanded="false">Menu</a>
                <ul class="dropdown-menu">
                  <li class="nav-item"><a class="nav-link" href="../viewFood">Shop Category</a></li>
                    <% if(session.getAttribute("sessCustomer")!=null) {%> 
                  <li class="nav-item"><a class="nav-link" href="../ViewOrder">Order History</a></li>
                  <% } %>
                  
                 
                  
                </ul>
							</li>
               <% if(session.getAttribute("sessCustomer")==null) {%>   
             
      
                                                                        <% }else{ %>
                                                                          
                                                                      
              <li class="nav-item submenu dropdown">
                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                  aria-expanded="false">Profile</a>
                <ul class="dropdown-menu">
                  <li class="nav-item"><a class="nav-link" href="profileview.jsp">View profile</a></li>
                   
                  <li class="nav-item"><a class="nav-link" href="../topupPay">Top-up history</a></li>
            
                
                </ul>
							</li>
							  <%} %>
             
            </ul>
              
                  
               <ul class="nav navbar-nav menu_nav ml-auto">
                  
                   <li style=" font-family:  sans-serif; margin-top: 40px; "><b><% if(session.getAttribute("sessCustomer")==null) { } else {
                          Customer cust = (Customer)session.getAttribute("sessCustomer") ; %><%= cust.getCustname()%> <% }%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></li> 
                   
              <li class="nav-item submenu dropdown">
                 
                  
                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                  aria-expanded="false"><img src="img/pro.jpg"  alt="" style="width: 42px; height: 42px; "></a>
                <ul class="dropdown-menu">
                       <% if(session.getAttribute("sessCustomer")==null) {%>   
                  <li class="nav-item"><a class="nav-link" href="login.jsp">Log in</a></li>
                   <% }else{ %>
                    <li class="nav-item"><a class="nav-link" href="../logout">Log out</a></li>
                  
                  <% } %>
                  
           
                  
                </ul>
							</li>
              
							
             
            </ul>
                      <% if(session.getAttribute("sessCustomer")!=null) {%>                                      
                 <ul class="nav-shop">
              <li class="nav-item"><a class="button button-header" href="cart.jsp">Food Cart</a></li>
            </ul>
                  
             <% } %>
               
							
            
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
					<h1>Shop Category</h1>
					<nav aria-label="breadcrumb" class="banner-breadcrumb">
            <ol class="breadcrumb">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active" aria-current="page">Shop Category</li>
            </ol>
          </nav>
				</div>
			</div>
    </div>
	</section>
	<!-- ================ end banner area ================= -->
  <section class="section-margin--small mb-5">
    <div class="container">
      <div class="row">
        <div class="col-xl-3 col-lg-4 col-md-5">
          <div class="sidebar-categories">
            <div class="head">Browse Categories</div>
            <ul class="main-categories">
              <li class="common-filter">
                <form action="#">
                  <ul>
                   
                     <li class="nav-item active"><a style="" class="nav-link" href="../category?id=a">All</a></li>
                     <li class="nav-item active"><a style="" class="nav-link" href="../category?id=w">Western Food</a></li>
                     <li class="nav-item active"><a style="" class="nav-link" href="../category?id=m">Malay Food</a></li>
                     <li class="nav-item active"><a style="" class="nav-link" href="../category?id=c">Chinese Food</a></li>
                     <li class="nav-item active"><a style="" class="nav-link" href="../category?id=i">Indian Food</a></li>
                     <li class="nav-item active"><a style="" class="nav-link" href="../category?id=o">Others</a></li>
                                
                  </ul>
                </form>
              </li>
            </ul>
          </div>
          <div class="sidebar-filter">
           
           
          </div>
        </div>
        <div class="col-xl-9 col-lg-8 col-md-7">
          <!-- Start Filter Bar -->
          
          <!-- End Filter Bar -->
          <!-- Start Best Seller -->
              <section class="lattest-product-area pb-40 category-list">
              <form action="../processViewFood" method="POST">
            <div class="row">
                 <% int[] selectArr = new int [foodList.size()]; %>
                          <% for(int i = 0; i < foodList.size() ; i++){ 
                            if(foodList.get(i).getFoodstatus().equals("Available")){
                              if(type.equals("all")){ %>  
                            <div class="col-md-6 col-lg-4">
                <div class="card text-center card-product">
                  <div class="card-product__img">
                      <img class="card-img" src="../Food/img/<%=foodList.get(i).getFoodimg() %>" alt="">
                    <ul class="card-product__imgOverlay">
                      
                        <li><button type="submit" name="<%="selectArr["+i+"]" %>">View</button></li>
                    
                    </ul>
                  </div>
                  <div class="card-body">
                      <h4 class="card-product__title"><a href="#"><%=foodList.get(i).getFoodname() %></a></h4>
                    <p class="card-product__price">RM<%=String.format("%.2f",foodList.get(i).getFoodprice()) %></p>
                  </div>
                </div>
              </div>
                              <% }else{
                          if(foodList.get(i).getFoodtype().equals(type)){ 
                          %> 
                
                
              <div class="col-md-6 col-lg-4">
                <div class="card text-center card-product">
                  <div class="card-product__img">
                      <img class="card-img" src="img/product/<%=foodList.get(i).getFoodimg() %>" alt="">
                    <ul class="card-product__imgOverlay">
                      
                        <li><button type="submit" name="<%="selectArr["+i+"]" %>">View</button></li>
                    
                    </ul>
                  </div>
                  <div class="card-body">
                      <h4 class="card-product__title"><a href="#"><%=foodList.get(i).getFoodname() %></a></h4>
                    <p class="card-product__price">RM<%=String.format("%.2f",foodList.get(i).getFoodprice()) %></p>
                  </div>
                </div>
              </div>
             <%}}} } %>
            
              </div>
              </form>
            </div>
          </section>
          <!-- End Best Seller -->
        </div>
      </div>
    </div>
  </section>

	<!-- ================ category section start ================= -->		  
 
          <!-- Start Filter Bar -->
          
          
          <!-- End Filter Bar -->
          <!-- Start Best Seller -->
      
          
        
      	<!-- ================ category section end ================= -->		  

	<!-- ================ top product area start ================= -->	
		
	<!-- ================ top product area end ================= -->		

	<!-- ================ Subscribe section start ================= -->		  
  <section class="subscribe-position">
    <div class="container">
      <div class="subscribe text-center">
        <h3 class="subscribe__title">Get Update From Anywhere</h3>
        <p>Bearing Void gathering light light his eavening unto dont afraid</p>
        <div id="mc_embed_signup">
          <form target="_blank" action="https://spondonit.us12.list-manage.com/subscribe/post?u=1462626880ade1ac87bd9c93a&amp;id=92a4423d01" method="get" class="subscribe-form form-inline mt-5 pt-1">
            <div class="form-group ml-sm-auto">
              <input class="form-control mb-1" type="email" name="EMAIL" placeholder="Enter your email" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Your Email Address '" >
              <div class="info"></div>
            </div>
            <button class="button button-subscribe mr-auto mb-1" type="submit">Subscribe Now</button>
            <div style="position: absolute; left: -5000px;">
              <input name="b_36c4fd991d266f23781ded980_aefe40901a" tabindex="-1" value="" type="text">
            </div>

          </form>
        </div>
        
      </div>
    </div>
  </section>
	<!-- ================ Subscribe section end ================= -->		  


  <!--================ Start footer Area  =================-->	
	<footer>
		<div class="footer-area">
			<div class="container">
				<div class="row section_gap">
					<div class="col-lg-3 col-md-6 col-sm-6">
						<div class="single-footer-widget tp_widgets">
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
  <script src="vendors/nouislider/nouislider.min.js"></script>
  <script src="vendors/jquery.ajaxchimp.min.js"></script>
  <script src="vendors/mail-script.js"></script>
  <script src="js/main.js"></script>
</body>
</html>