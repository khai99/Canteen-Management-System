<%-- 
    Document   : test
    Created on : Apr 6, 2019, 4:16:11 PM
    Author     : vinso
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
Date actual = (Date)session.getAttribute("sessDate");
Date getDate = (Date)session.getAttribute("sessDateget");
String valid = (String)session.getAttribute("sessID");
String id = (String)session.getAttribute("sessIDDD");

String idd1 = (String)session.getAttribute("sessOrder2");

String idd2 = (String)session.getAttribute("sessOrder3");

String idd3 = (String)session.getAttribute("sessOrder4");


Date dato = (Date)session.getAttribute("sessDateNew");

Date date1 = (Date)session.getAttribute("sessDate1");



Date dateTry = (Date)session.getAttribute("sessTry");
Date dateTry2 = (Date)session.getAttribute("sessTry1");
SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
dateFormat.format(dateTry);
       dateFormat.format(dateTry2);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>1:<%=dateTry %></h1>
        <h1>2:<%=dateTry2 %></h1>
        <h1></h1>
     
    </body>
</html>
