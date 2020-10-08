<%-- 
    Document   : profilenew
    Created on : Mar 28, 2019, 7:48:35 PM
    Author     : User
--%>
<%@page import="entity.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:useBean scope="session" class="entity.Customer" id="sessCustomer" />
`<!DOCTYPE html>
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
    
     <style>
.modal {
  display: none; /* Hidden by default */
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
 
  top: 0;
  width: auto; /* Full width */
  /* Full height */
  overflow: auto; /* Enable scroll if needed */
  /* Black w/ opacity */
margin-left: 27%;

}

/* Modal Content */
.modal-content {
  background-color: #fefefe;
  margin-top: 200px;
  margin-left: 200px;
  margin-right: 200px;
  margin-bottom: 200px;
  background-color: white;
  padding: 20px;
  border: 1px solid #888;
  

  
  position:relative;animation:animatetop 0.4s}@keyframes animatetop{from{right;-300px;opacity:0} to{right:0px;opacity:1}
             
}

/* The Close Button */
.close {
  color: #bd2130;
  font-size: 12px;
  float: right;
  /*font-weight: normal;*/
  
  
}

.close:hover,
.close:focus {
  color: #000;
  text-decoration: underline;
  cursor: pointer;
}


.table{
    font-size: 18px;
}

.table1{
    color: black;
    font-weight: bold;
}

.submit1{
    background-color: #6c757d; color: black;
    font-size:20px;
    padding: 7px;
    width: 150px;
    border-radius: 8px;
    border: 1px solid #16181b;
    font-weight: bold;
    position: relative;
    left: 30%;
    
}

.submit1:hover{
    background-color:#e7e7e7;
    color: black;
    cursor: pointer;
}
</style>
</head>
<body>

    <div class="main">

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
                    <form action="../UpdateCustomer" method="POST" class="register-form" id="register-form" style="background-color:#f8f9fa">
                    <div ><font size="6">Profile</font></div>
                        <div class="form-row">
                        
                            <div class="form-group">
                                <div class="form-input">
                                     <br/><label for="custID" class="required">Student / Staff ID</label>
                                     <input type="text" name="custID" id="" placeholder="Full Name" value="<%=sessCustomer.getCustid()%>" disabled="disabled"/>
                                   
                                </div>
                                <div class="form-input">
                                    <label for="first_name" class="required">Full NAME</label>
                                    <input type="text" name="custName" id="sfullName" placeholder="Full Name" value="<%=sessCustomer.getCustname()%>" required="required" />
                                </div>
                                <div class="form-input">
                                    <label for="last_name" class="required">Email</label>
                                    <input type="text" name="custEmail" id="semail" placeholder="Email" value="<%=sessCustomer.getCustemail()%>" required="required"/>
                                </div>
                                
                             
                                <div class="form-input">
                                    <label for="email" class="required">IC number</label>
                                    <input type="text" name="custIC" id="custIC" placeholder="IC NUMBER" value="<%=sessCustomer.getCustic()%>" required="required" />
                                </div>
                                <div>
                                                <br/>
                                            </div>
                                
                                                         </div>
                                
                                                        
                            <div class="form-group">
                             
                                <div class="form-radio">
                                    <br/>
                                    <div class="label-flex">
                                         <label for="gender" >GENDER</label>
                                         <%
                                            String a="";
                                            String b="";
                                           if( (sessCustomer.getCustgender()=='m') ){ 
                                            a= "checked"; }
                                           else  if( (sessCustomer.getCustgender()=='f') ){
                                               b= "checked";
                                           }
                                           else{
                                               
                                           }
                                         %>                                      
                                    </div>
                                    <div class="form-radio-group">            
                                        <div class="form-radio-item">
                                            <input type="radio" name="gender"  value="m" id="m" <%= a %>  >
                                            <label for="m">MALE</label>
                                            <span class="check"></span>
                                        </div>
                                     <div class="form-radio-item">
                                         <input type="radio" name="gender"  value="f" id="f" <%= b %>  >
                                            <label for="f">FEMALE</label>
                                            <span class="check"></span>
                                        </div>
                                            
                                                                     </div>
                                </div>
                                 <div class="form-input">
                                    <label for="phone_number" class="required">Phone number</label>
                                    <input type="number" name="custPhoneNo" id="phone_number" value="<%=sessCustomer.getCustphoneno()%>" required="required" />
                                </div>
                                        <div class="form-input">
                                    <label for="blank_name">Age</label>
                                    
                                    <input type="number" name="custAge" id="age" value="<%=sessCustomer.getCustage()%>" required="required"/>
                                </div>
                                       
                                


                                </br>
                                </br>
                                
                                <a href="#" id="myBtn">Change my password</a>
                                
                                                           </div>
                                
                             

                                
                                
                        </div>
                        <div class="donate-us">
                            
                            <br/><br/>
                        </div>
                    
                        <div class="form-submit">
                            
                            <input type="submit" value="UPDATE" class="submit" id="submit" name="button" />
                            <input type="submit" value="BACK"   class="submit" id="submit" name="button" style="background-color: #000000"/>
                                                   
                        </div>
                     
                    </form>
                </div>
            </div>
        </div>

    </div>
                              <div id="myModal" class="modal">

                          <!-- Modal content -->
                            <div class="modal-content">
                                <span class="close">close</span><br/>
                                <form action="../UpdatePassword" method="POST">
                                    <h1>Change Password</h1><br/>
                                <div class="registration_detail">
                                    <table class="table" id="table">
                                        <tr>
                                            <td>Old Password</td>
                                            <td><input type="password" id="password-input" name="oldPassword" placeholder="Password" class="form-control"><td/>
                                        </tr>
                                        <tr>
                                            <td>New Password</td>
                                            <td><input type="password" id="password-input" name="newPass" placeholder="Password" class="form-control"></td>
                                        </tr>
                                        <tr>
                                            <td>Confirm Password</td>
                                            <td><input type="password" id="password-input" name="confirmPass" placeholder="Password" class="form-control"></td>
                                        </tr>
                                        </br>   
                                    </table>
                                    </br>
                                    <div  >
                                    <input type="submit" value="Submit"  class="submit" id="submit" style="background-color: #000000"/>
                                    <input type="reset" value="Reset"  class="submit" id="submit" style="background-color: #fefefe ; color: #000000 ; border-color: black ; border-style: outset" />
                                    </div>
                                </div>
                                </form>
                            </div>
                        </div>

  <!-- JS -->
    <script src="profile/vendor/jquery/jquery.min.js"></script>
    <script src="profile/vendor/nouislider/nouislider.min.js"></script>
    <script src="profile/vendor/wnumb/wNumb.js"></script>
    <script src="profile/vendor/jquery-validation/dist/jquery.validate.min.js"></script>
    <script src="profile/vendor/jquery-validation/dist/additional-methods.min.js"></script>
    <script src="profile/js/main.js"></script>
        <script>
// Get the modal
var modal = document.getElementById('myModal');

// Get the button that opens the modal
var btn = document.getElementById("myBtn");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal 
btn.onclick = function() {
  modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
  modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}


</script>
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>
