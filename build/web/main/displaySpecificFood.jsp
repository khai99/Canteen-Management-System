<%-- 
    Document   : displaySpecificFood
    Created on : Mar 30, 2019, 10:02:45 AM
    Author     : vinso
--%>

<%@page import="entity.Food"%>
<%@page import="entity.Customer"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
  List<Food> foodList = (List)session.getAttribute("sessFoodList");
  String foodID = (String)session.getAttribute("sessFoodID");
  
  String foodName = "";
  Double foodPrice = 0.0;
  String foodStatus = "";
  int foodCalories = 0;
  String foodDesc = "";
  String foodImg = "";
  String foodI ="";
  
  for(int i = 0 ; i < foodList.size(); i++){
    if(foodID.equals(foodList.get(i).getFoodid())){
        foodI = foodList.get(i).getFoodid();
       foodName = foodList.get(i).getFoodname();
       foodPrice = foodList.get(i).getFoodprice();
       foodStatus = foodList.get(i).getFoodstatus();
       foodCalories = foodList.get(i).getFoodcalories();
       foodDesc = foodList.get(i).getFooddesc();
       foodImg = foodList.get(i).getFoodimg();
    }
  }
%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Aroma Shop - Product Details</title>
	<link rel="icon" href="img/Fevicon.png" type="image/png">
  <link rel="stylesheet" href="vendors/bootstrap/bootstrap.min.css">
  <link rel="stylesheet" href="vendors/fontawesome/css/all.min.css">
	<link rel="stylesheet" href="vendors/themify-icons/themify-icons.css">
	<link rel="stylesheet" href="vendors/linericon/style.css">
  <link rel="stylesheet" href="vendors/nice-select/nice-select.css">
  <link rel="stylesheet" href="vendors/owl-carousel/owl.theme.default.min.css">
  <link rel="stylesheet" href="vendors/owl-carousel/owl.carousel.min.css">

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
		<!-- ================ end banner area ================= -->


  <!--================Single Product Area =================-->
  
	<div class="product_image_area">
          
		<div class="container">
			<div class="row s_product_inner">
				<div class="col-lg-6">
					<div>
                                            <img src="../Food/img/<%=foodImg %>" style="margin-left:120px;margin-top:50px ;width:350px;height:350px;" alt="">
						</div>
						<!-- <div class="single-prd-item">
							<img class="img-fluid" src="img/category/s-p1.jpg" alt="">
						</div>
						<div class="single-prd-item">
							<img class="img-fluid" src="img/category/s-p1.jpg" alt="">
						</div> -->
					</div>
                                               
				<div class="col-lg-5 offset-lg-1a">
					<div class="s_product_text">
                                             <form method="POST" action="../AddtoCart">
                                                 <input name="cartfood" value="<%=foodI %>" type="hidden">
						<h3><%=foodName %></h3>
						<h2>RM <%=String.format("%.2f",foodPrice) %></h2>
						<ul class="list">
						<li><a href="#"><span>Availibility</span> : <%=foodStatus %></a></li>
						<li><a href="#"><span>Calories</span> : <%=foodCalories %></a></li>

						</ul>
						<p><%=foodDesc %></p>
                                                <br/>
                                                <div > 
                                                <span>Quantity :</span>
                                                
                                                <input style="width: 60px;height: 30px; margin-left : 20px ;border-color: blue;" required="required" type="number" name="foodQty" id="sst" size="2" min="1" max="15" maxlength="12" value="1" title="Quantity:" class="input-text qty">
						</div>
                                                                                  

                                                <div style="margin-top: 20px">
                                                   
                                                    <button  style=" height: 60px;border-radius: 30px;margin-right: 10px " type="submit" value="Pre order" class="button"  name="button">Pre order</button>
                                                    <button  style=" height: 60px;border-radius: 30px " type="submit" value="Order Now" class="button"  name="button"/>Order Now</button>
								
								
							</div>             
						
						<div class="card_area d-flex align-items-center">
							<a class="icon_btn" href="../viewFood"><i class="lnr lnr lnr-arrow-left"></i></a>
							
						</div>
                                                <br/><br/><br/><br/>
                                                                                                </form>

					</div>
				</div>
			</div>
		</div>
	</div>
	<!--================End Single Product Area =================-->

	<!--================Product Description Area =================-->
		<!--================ end related Product area =================-->  	

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
