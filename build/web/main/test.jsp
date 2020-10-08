<%-- 
    Document   : test
    Created on : Mar 27, 2019, 11:41:21 PM
    Author     : User
--%>

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
 
 String date1= (String) session.getAttribute("1"); 
 
//double user1= Double.parseDouble(user);

%>
  
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <%= date1 %>
      
    </body>
</html>
