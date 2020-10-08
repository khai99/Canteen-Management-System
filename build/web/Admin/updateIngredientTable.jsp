<%-- 
    Document   : updateIngredientTable
    Created on : Mar 29, 2019, 12:38:50 AM
    Author     : vinso
--%>

<%@page import="entity.Canteenstaff"%>
<%@page import="java.util.List"%>
<%@page import="entity.Ingredient"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%  
   List<Ingredient> ingreList = (List) session.getAttribute("sessIngreList");
    Canteenstaff staff =(Canteenstaff)session.getAttribute("sessStaff"); 
%>

<!DOCTYPE html>
<!doctype html>
<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Data Table | Kiaalap - Kiaalap Admin Template</title>
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
    <!-- x-editor CSS
		============================================ -->
    <link rel="stylesheet" href="css/editor/select2.css">
    <link rel="stylesheet" href="css/editor/datetimepicker.css">
    <link rel="stylesheet" href="css/editor/bootstrap-editable.css">
    <link rel="stylesheet" href="css/editor/x-editor-style.css">
    <!-- normalize CSS
		============================================ -->
    <link rel="stylesheet" href="css/data-table/bootstrap-table.css">
    <link rel="stylesheet" href="css/data-table/bootstrap-editable.css">
    <!-- style CSS
		============================================ -->
    <link rel="stylesheet" href="style.css">
    <!-- responsive CSS
		============================================ -->
    <link rel="stylesheet" href="css/responsive.css">
    <!-- modernizr JS
		============================================ -->
    <script src="js/vendor/modernizr-2.8.3.min.js"></script>
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
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="logo-pro">
                        <a href="index.html"><img class="main-logo" src="img/logo/logo.png" alt="" /></a>
                    </div>
                </div>
            </div>
        </div>
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
                                                        <div class="notification-view">
                                                            <a href="#">View All Notification</a>
                                                        </div>
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
        <!-- Static Table Start -->
        <br>
        <br>
        <div class="data-table-area mg-b-15">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <div class="sparkline13-list">
                            <div class="sparkline13-hd">
                                <div class="main-sparkline13-hd">
                                    <h1>Update <span class="table-project-n">Existing</span> Ingredient</h1>
                                </div>
                            </div>
                            <div class="sparkline13-graph">
                                <div class="datatable-dashv1-list custom-datatable-overright">
                                    <form action="../processUpdateIngredient" method="POST">
                                                                        <table id="table" data-toggle="table" data-pagination="true" data-search="true" data-show-columns="true" data-show-pagination-switch="true" data-show-refresh="true" data-key-events="true" data-show-toggle="true" data-resizable="true" data-cookie="true"
                                        data-cookie-id-table="saveId" data-show-export="true" data-click-to-select="true" data-toolbar="#toolbar">
                                        <thead>
                                            <tr>
                                                
                                                <th data-field="id">Ingredient ID</th>
                                                <th data-field="name" >Ingredient Name</th>
                                                
                                                <th data-field="action">Update</th>

                                                                                           </tr>
                                        </thead>
                                        <tbody>
                                            <%
                                            int[] selectArr = new int [ingreList.size()];
                                              for(int i = 0; i < ingreList.size();i++){
                                            
                                            %>
                                            <tr>
                                               
                                                <td><%=ingreList.get(i).getIngredientid() %></td>
                                                <td><%=ingreList.get(i).getIngredientname() %></td>
                                               
                                                <td class="datatable-ct"><button type="submit" name="<%="selectArr["+i+"]" %>" class="fa fa-check"></button>
                                            </tr>
                                           <% } %>
                                      </tbody>
                                    </table>
                                        </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Static Table End -->
       
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
    <!-- data table JS
		============================================ -->
    <script src="js/data-table/bootstrap-table.js"></script>
    <script src="js/data-table/tableExport.js"></script>
    <script src="js/data-table/data-table-active.js"></script>
    <script src="js/data-table/bootstrap-table-editable.js"></script>
    <script src="js/data-table/bootstrap-editable.js"></script>
    <script src="js/data-table/bootstrap-table-resizable.js"></script>
    <script src="js/data-table/colResizable-1.5.source.js"></script>
    <script src="js/data-table/bootstrap-table-export.js"></script>
    <!--  editable JS
		============================================ -->
    <script src="js/editable/jquery.mockjax.js"></script>
    <script src="js/editable/mock-active.js"></script>
    <script src="js/editable/select2.js"></script>
    <script src="js/editable/moment.min.js"></script>
    <script src="js/editable/bootstrap-datetimepicker.js"></script>
    <script src="js/editable/bootstrap-editable.js"></script>
    <script src="js/editable/xediable-active.js"></script>
    <!-- Chart JS
		============================================ -->
    <script src="js/chart/jquery.peity.min.js"></script>
    <script src="js/peity/peity-active.js"></script>
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
