<%-- 
    Document   : profileview
    Created on : Mar 27, 2019, 10:31:16 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:useBean scope="session" class="entity.Customer" id="sessCustomer" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sign Up Form by Colorlib</title>

    <!-- Font Icon -->
    <link rel="stylesheet" href="profile/fonts/material-icon/css/material-design-iconic-font.min.css">
    <link rel="stylesheet" href="profile/vendor/nouislider/nouislider.min.css">

    <!-- Main css -->
    <link rel="stylesheet" href="profile/css/style.css">
</head>
<body>

 <div class="main" >

        <div class="container">
            <div class="signup-content">
                <div class="signup-img">
                    <img src="img/form-img.jpg" alt="">
                    <div class="signup-img-content">
                        <h2>My Account </h2>
                       
                        <p></p>
                    </div>
                </div>
                <div class="signup-form">
                    <form action="../ViewProfileChoice" method="POST" class="register-form" id="register-form" style="background-color:#f8f9fa">
                    <div ><font size="6">Profile</font></div>
                        <div class="form-row">
                        
                            <div class="form-group">
                                <div class="form-input">
                                     <br/><label for="custID" class="required">Student ID/Staff ID</label>
                                    <%=sessCustomer.getCustid()%>
                                </div></br>
                                <div class="form-input">
                                    <label for="first_name" class="required">Full NAME</label>
                                    <%=sessCustomer.getCustname()%>
                                </div></br>
                                
                                <div class="form-input">
                                    <label for="last_name" class="required">Email</label>
                                    <%=sessCustomer.getCustemail()%>
                                </div></br>
                               
                                <div class="form-input">
                                    <label for="email" class="required">IC number</label>
                                   <%=sessCustomer.getCustic()%>
                                </div></br>  
                                <div class="form-input">
                                    
                                </div>
                                     
                                                         </div>
                            <div class="form-group">
                       
                                   <div class="form-input">
                                    <br/> <label for="email" class="required">Gender</label>
                                       <% if(sessCustomer.getCustgender()=='m') {%>
                                               MALE
                                             <% } %>
                                        <% if(sessCustomer.getCustgender()=='f') {%>
                                               FEMALE
                                             <% } %>
                                 
                                              
                                     </div></br>         
                              <div class="form-input">
                                    <label for="phone_number" class="required">Phone number</label>
                                    <%=sessCustomer.getCustphoneno()%>
                              </div></br>
                                <div class="form-input">
                                    <label for="blank_name">Age</label>
                                      <%=sessCustomer.getCustage()%>
                                </div><br/>   
                                
                                                           </div>
                        </div>
                        <div class="donate-us">
                           <br/>
                            <div class="price_slider ui-slider ui-slider-horizontal">
                               
                            </div> </br>
                        </div>
                        <div class="form-submit">
                             <div class="form-submit" >
                            <input  type="submit" value="Edit" class="submit" id="submit" name="button" />
                            
                            <input type="submit" value="Back" class="submit"  id="reset" name="button" />
                            
                         
                            
                        </div>

                                                   </div>
                    </form>
                </div>
            </div>
        </div>
                  
    </div>

    <!-- JS -->
    <script src="profile/vendor/jquery/jquery.min.js"></script>
    <script src="profile/vendor/nouislider/nouislider.min.js"></script>
    <script src="profile/vendor/wnumb/wNumb.js"></script>
    <script src="profile/vendor/jquery-validation/dist/jquery.validate.min.js"></script>
    <script src="profile/vendor/jquery-validation/dist/additional-methods.min.js"></script>
    <script src="profile/js/main.js"></script>
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>