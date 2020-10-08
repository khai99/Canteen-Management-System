<%-- 
    Document   : updateIngredient
    Created on : Mar 29, 2019, 1:05:14 AM
    Author     : vinso
--%>

<%@page import="entity.Canteenstaff"%>
<%@page import="java.util.List"%>
<%@page import="entity.Ingredient"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
   List<Ingredient> ingreList = (List)session.getAttribute("sessIngreList");
   String ingreID = (String)session.getAttribute("sessIngreID");
   String ingredientName = "";
   String ingredientStatus = "";

   for(int i = 0; i < ingreList.size(); i++){
   if(ingreID == ingreList.get(i).getIngredientid()){
   ingredientName = ingreList.get(i).getIngredientname();
   
   
     }
  
   }


 Canteenstaff staff =(Canteenstaff)session.getAttribute("sessStaff"); 


%>


<!DOCTYPE html>
﻿<!doctype html>
<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Add Course | Kiaalap - Kiaalap Admin Template</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- favicon
		============================================ -->
    <link rel="shortcut icon" type="image/x-icon" href="img/favicon.ico">
    <!-- Google Fonts
		============================================ -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,700,900" rel="stylesheet">
    <!-- Bootstrap CSS
		============================================ -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <!-- Bootstrap CSS
		============================================ -->
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <!-- owl.carousel CSS
		============================================ -->
    <link rel="stylesheet" href="css/owl.carousel.css">
    <link rel="stylesheet" href="css/owl.theme.css">
    <link rel="stylesheet" href="css/owl.transitions.css">
    <!-- animate CSS
		============================================ -->
    <link rel="stylesheet" href="css/animate.css">
    <!-- normalize CSS
		============================================ -->
    <link rel="stylesheet" href="css/normalize.css">
    <!-- meanmenu icon CSS
		============================================ -->
    <link rel="stylesheet" href="css/meanmenu.min.css">
    <!-- main CSS
		============================================ -->
    <link rel="stylesheet" href="css/main.css">
    <!-- dropzone CSS
		============================================ -->
    <link rel="stylesheet" href="css/dropzone/dropzone.css">
    <!-- educate icon CSS
		============================================ -->
    <link rel="stylesheet" href="css/educate-custon-icon.css">
    <!-- morrisjs CSS
		============================================ -->
    <link rel="stylesheet" href="css/morrisjs/morris.css">
    <!-- mCustomScrollbar CSS
		============================================ -->
    <link rel="stylesheet" href="css/scrollbar/jquery.mCustomScrollbar.min.css">
    <!-- metisMenu CSS
		============================================ -->
    <link rel="stylesheet" href="css/metisMenu/metisMenu.min.css">
    <link rel="stylesheet" href="css/metisMenu/metisMenu-vertical.css">
    <!-- calendar CSS
		============================================ -->
    <link rel="stylesheet" href="css/calendar/fullcalendar.min.css">
    <link rel="stylesheet" href="css/calendar/fullcalendar.print.min.css">
    <!-- forms CSS
		============================================ -->
    <link rel="stylesheet" href="css/form/all-type-forms.css">
    <!-- style CSS
		============================================ -->
    <link rel="stylesheet" href="style.css">
    <!-- responsive CSS
		============================================ -->
    <link rel="stylesheet" href="css/responsive.css">
    <!-- modernizr JS
		============================================ -->
    <script src="js/vendor/modernizr-2.8.3.min.js"></script>
    <style>
     input[type=text] {
  box-sizing: border-box;
  border: 1px solid black;
  padding: 14px 20px;
  border-radius: 5px;
  -moz-border-radius: 5px;
  -webkit-border-radius: 5px;
  -o-border-radius: 5px;
  -ms-border-radius: 5px;
  font-size: 14px;
  font-family: 'Poppins'; 
  border-color:gray;}
   input[type=number] {
  box-sizing: border-box;
  border: 1px solid black;
  padding: 14px 20px;
  border-radius: 5px;
  -moz-border-radius: 5px;
  -webkit-border-radius: 5px;
  -o-border-radius: 5px;
  -ms-border-radius: 5px;
  font-size: 14px;
  font-family: 'Poppins';
  border-color:gray; }
  textarea{
	 box-sizing: border-box;
  border: 1px solid black;
  padding: 14px 20px;
  border-radius: 5px;
  -moz-border-radius: 5px;
  -webkit-border-radius: 5px;
  -o-border-radius: 5px;
  -ms-border-radius: 5px;
  font-size: 14px;
  font-family: 'Poppins';
	
	
	}
	

    
    </style>
   </head>

<body>
   <!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->
    <!-- Start Left menu area -->
    <div class="left-sidebar-pro" style="margin-top: -20px;">
        <nav id="sidebar" class="">
            <div class="sidebar-header">
                <a href="profile.jsp"><img class="main-logo" width="200" height="60" src="img/logo/psdc.png" alt="" /></a>
                           </div>
            <div class="left-custom-menu-adp-wrap comment-scrollbar">
                <nav class="sidebar-nav left-sidebar-menu-pro">
                    <ul class="metismenu" id="menu1">
                        <li>
                                                                             </li>
                       
                         <li class="active">
                            <a title="Landing Page" href="profile.jsp" aria-expanded="false"><span aria-hidden="true"></span> <span class="mini-click-non">Profile</span></a>
                        </li>
 
                        <li>
                            <a class="has-arrow" href="all-professors.html" aria-expanded="false"><span></span> <span class="mini-click-non">Meal Management</span></a>
                            <ul class="submenu-angle" aria-expanded="false">
                             
                                <li><a title="Add Professor" href="../addFoodIG"><span class="mini-sub-pro">Add Food / Ingredient</span></a></li>
                                <li><a title="Edit Professor" href="../loadFoodTable"><span class="mini-sub-pro">Update food</span></a></li>
                                <li><a title="Professor Profile" href="../loadIngredientTable"><span class="">Update Ingredient</span></a></li>
                                <li><a title="Needed Ingredient" href="testNeededIngredient.jsp"><span class="">Needed Ingredient</span></a></li>
                            </ul>
                        </li>
                        <li>
                            <a class="has-arrow" href="all-students.html" aria-expanded="false"><span></span> <span class="mini-click-non">Order Management</span></a>
                            <ul class="submenu-angle" aria-expanded="false">
                                <li><a title="order valid" href="couponValidity.jsp"><span class="mini-sub-pro">Coupon Redeem</span></a></li>
                                <li><a title="All Students" href="../loadOrderTable"><span class="mini-sub-pro">View Order Record</span></a></li>
                                                            </ul>
                        </li>
                       

                        <li>
                            <a class="has-arrow" href="all-courses.html" aria-expanded="false"><span></span> <span class="mini-click-non">Topup Management</span></a>
                            <ul class="submenu-angle" aria-expanded="false">
                                <li><a title="All Courses" href="searchCusTopup.jsp"><span class="mini-sub-pro">Topup Payment</span></a></li>
                                <li><a title="Add Courses" href="../loadTopupTable"><span class="mini-sub-pro">Topup History</span></a></li>
                                                            </ul>
                        </li>
                         <li>
                            <a class="has-arrow" href="all-courses.html" aria-expanded="false"><span></span> <span class="mini-click-non">Report</span></a>
                            <ul class="submenu-angle" aria-expanded="false">
                              <li><a title="report" href="topupReportRun.jsp"><span class="mini-sub-pro">Report</span></a></li>
                                                                                           </ul>
                        </li>

                       
                                            </ul>
                </nav>
            </div>
        </nav>
    </div>



    <!-- End Left menu area -->
    <!-- Start Welcome area -->
    <div class="all-content-wrapper">
       
        <div class="header-advance-area">
            <div class="header-top-area">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                            <div class="header-top-wraper">
                                <div class="row">
                                    <div class="col-lg-1 col-md-0 col-sm-1 col-xs-12">
                                        <div class="menu-switcher-pro">
                                            <button type="button" id="sidebarCollapse" class="btn bar-button-pro header-drl-controller-btn btn-info navbar-btn">
													<i class="educate-icon educate-nav"></i>
												</button>
                                        </div>
                                    </div>
                                    <div class="col-lg-6 col-md-7 col-sm-6 col-xs-12">
                                        <div class="header-top-menu tabl-d-n">
                                            <ul class="nav navbar-nav mai-top-nav">
                                                                                                                                                                              </ul>
                                        </div>
                                    </div>
                                    <div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
                                        <div class="header-right-info">
                                            <ul class="nav navbar-nav mai-top-nav header-right-menu">
                                                <li class="nav-item dropdown">
                                                   
                                                    <div role="menu" class="author-message-top dropdown-menu animated zoomIn">
                                                       
                                                        <ul class="message-menu">
                                                            
                                                           
                                                        </ul>
                                                        
                                                    </div>
                                                </li>
                                              
                                                    <div role="menu" class="notification-author dropdown-menu animated zoomIn">
                                                       
                                                        <ul class="notification-menu">
                                                            
                                                           
                                                            
                                                        </ul>
                                                      
                                                    </div>
                                                </li>
                                                <li class="nav-item">
                                                    <a href="#" data-toggle="dropdown" role="button" aria-expanded="false" class="nav-link dropdown-toggle">
															<img src="img/product/personalprofile.jpg" width="600px" height="600px" alt="" />
															<span class="admin-name"><%=staff.getStaffname() %></span>
															<i class="fa fa-angle-down edu-icon edu-down-arrow"></i>
														</a>
                                                    <ul role="menu" class="dropdown-header-top author-log dropdown-menu animated zoomIn">
                                                       
                                                        <li><a href="../logout1"><span class="edu-icon edu-locked author-log-ic"></span>Log Out</a>
                                                        </li>
                                                    </ul>
                                                </li>
                                               

                                                    <div role="menu" class="admintab-wrap menu-setting-wrap menu-setting-wrap-bg dropdown-menu animated zoomIn">
                                                        
                                                        <div class="tab-content custom-bdr-nt">
                                                            <div id="Notes" class="tab-pane fade in active">
                                                                <div class="notes-area-wrap">
                                                                    
                                                                    <div class="notes-list-area notes-menu-scrollbar">
                                                                        <ul class="notes-menu-list">
                                                                            
                                                                           
                                                                        </ul>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div id="Projects" class="tab-pane fade">
                                                                <div class="projects-settings-wrap">
                                                                    
                                                                    <div class="project-st-list-area project-st-menu-scrollbar">
                                                                        <ul class="projects-st-menu-list">
                                                                           
                                                                           
                                                                            
                                                                            
                                                                            
                                                                           
                                                                            
                                                                           
                                                                        </ul>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div id="Settings" class="tab-pane fade">
                                                                <div class="setting-panel-area">
                                                                   
                                                                    <ul class="setting-panel-list">
                                                                        
                                                                       
                                                                        
                                                                        
                                                                       
                                                                    </ul>

                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
  

            <!-- Mobile Menu start -->
            
            <!-- Mobile Menu end -->
            
        </div>
        <!-- Single pro tab review Start-->
        <br>
        <br>
        <br>
        <br>
        <div class="single-pro-review-area mt-t-30 mg-b-15">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <div class="product-payment-inner-st">
                            <ul id="myTabedu1" class="tab-review-design">
                                <li class="active"><a href="#description">Update Ingredient</a></li>
                                                             
                            </ul>
                            <div id="myTabContent" class="tab-content custom-product-edit">
                                <div class="product-tab-list tab-pane fade active in" id="description">
                                    <div class="row">
                                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                            <div class="review-content-section">
                                                <div id="dropzone1" class="pro-ad addcoursepro">
                                                    <form action="../confirmUpdateIngredient" method="POST">
                                                        <div class="row">
                                                            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                                            <div class="form-group">
                                                        <h4>Ingredient ID</h4>


                                                        <input name="iID" type="text" class="form-control3" disabled="disabled" style="background-color:silver" value="<%=ingreID %>" placeholder="Ingredient ID">
                                                                </div>

                                                                                                                       <div class="form-group">
                                                                                                                        <h4>Ingredient Name</h4>
                                                                                                                        <input type="text" required="required" required pattern="([A-z\s]){2,}" value="<%=ingredientName %>" maxlength="30" class="form-control4" name="iName" placeholder="Ingredient Name">
                                                            </div>
                                                            
                                                                                                                         <button type="submit"  class="btn btn-primary waves-effect waves-light">Update Ingredient</button>
                                                        </div>
                                                    </div>
                                                    </form>
                                            </div>
                                        </div>
                                    </div>
                               

                                                                                                               
                                                                                                                     </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
       
    <!-- jquery
		============================================ -->
    <script src="js/vendor/jquery-1.12.4.min.js"></script>
    <!-- bootstrap JS
		============================================ -->
    <script src="js/bootstrap.min.js"></script>
    <!-- wow JS
		============================================ -->
    <script src="js/wow.min.js"></script>
    <!-- price-slider JS
		============================================ -->
    <script src="js/jquery-price-slider.js"></script>
    <!-- meanmenu JS
		============================================ -->
    <script src="js/jquery.meanmenu.js"></script>
    <!-- owl.carousel JS
		============================================ -->
    <script src="js/owl.carousel.min.js"></script>
    <!-- sticky JS
		============================================ -->
    <script src="js/jquery.sticky.js"></script>
    <!-- scrollUp JS
		============================================ -->
    <script src="js/jquery.scrollUp.min.js"></script>
    <!-- mCustomScrollbar JS
		============================================ -->
    <script src="js/scrollbar/jquery.mCustomScrollbar.concat.min.js"></script>
    <script src="js/scrollbar/mCustomScrollbar-active.js"></script>
    <!-- metisMenu JS
		============================================ -->
    <script src="js/metisMenu/metisMenu.min.js"></script>
    <script src="js/metisMenu/metisMenu-active.js"></script>
    <!-- morrisjs JS
		============================================ -->
    <script src="js/sparkline/jquery.sparkline.min.js"></script>
    <script src="js/sparkline/jquery.charts-sparkline.js"></script>
    <!-- calendar JS
		============================================ -->
    <script src="js/calendar/moment.min.js"></script>
    <script src="js/calendar/fullcalendar.min.js"></script>
    <script src="js/calendar/fullcalendar-active.js"></script>
    <!-- maskedinput JS
		============================================ -->
    <script src="js/jquery.maskedinput.min.js"></script>
    <script src="js/masking-active.js"></script>
    <!-- datepicker JS
		============================================ -->
    <script src="js/datepicker/jquery-ui.min.js"></script>
    <script src="js/datepicker/datepicker-active.js"></script>
    <!-- form validate JS
		============================================ -->
    <script src="js/form-validation/jquery.form.min.js"></script>
    <script src="js/form-validation/jquery.validate.min.js"></script>
    <script src="js/form-validation/form-active.js"></script>
    <!-- dropzone JS
		============================================ -->
    <script src="js/dropzone/dropzone.js"></script>
    <!-- tab JS
		============================================ -->
    <script src="js/tab.js"></script>
    <!-- plugins JS
		============================================ -->
    <script src="js/plugins.js"></script>
    <!-- main JS
		============================================ -->
    <script src="js/main.js"></script>
    <!-- tawk chat JS
		============================================ -->
    <script src="js/tawk-chat.js"></script>
</body>

</html>