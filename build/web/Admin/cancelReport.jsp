<%-- 
    Document   : cancelReport
    Created on : Apr 12, 2019, 7:56:52 PM
    Author     : vinso
--%>

<%@page import="entity.Canteenstaff"%>
<%@page import="net.sf.jasperreports.engine.JasperRunManager"%>
<%-- 
    Document   : reportDate
    Created on : Apr 8, 2019, 1:44:28 PM
    Author     : vinso
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.sql.Date"%>
<%@page import="java.util.HashMap"%>
<%@page import="org.hibernate.mapping.Map"%>
<%@page import="net.sf.jasperreports.engine.JasperRunManager"%>
<%@page import="java.io.File"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.util.logging.Level"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="net.sf.jasperreports.engine.JRException"%>
<%@page import="net.sf.jasperreports.view.JasperViewer"%>
<%@page import="net.sf.jasperreports.engine.JasperFillManager"%>
<%@page import="net.sf.jasperreports.engine.JasperCompileManager"%>
<%@page import="net.sf.jasperreports.engine.JasperPrint"%>
<%@page import="net.sf.jasperreports.engine.JasperReport"%>
<%@page import="net.sf.jasperreports.engine.design.JRDesignQuery"%>
<%@page import="net.sf.jasperreports.engine.xml.JRXmlLoader"%>
<%@page import="net.sf.jasperreports.engine.design.JasperDesign"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Canteenstaff staff =(Canteenstaff)session.getAttribute("sessStaff"); 
            //String test = request.getParameter("test");
            String start = request.getParameter("dateStart");
            String end = request.getParameter("dateEnd");
            //DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
             String st = staff.getStaffname();
            //java.util.Date newDate = format.parse(start);
            //java.util.Date newDate1 = format.parse(end);
            //java.sql.Date st = new java.sql.Date(newDate.getTime());
            //java.sql.Date ed = new java.sql.Date(format.parse(end).getTime());
                 String dater = request.getParameter("hiddenDate");
            
            try{
            //Connection conn = nul'l;
            Connection conn=DriverManager.getConnection("jdbc:derby://localhost:1527/psdcDatabase","nbuser","nbuser");
        
            File file = new File(application.getRealPath("//Report//cancelReport.jasper"));
            java.util.Map parameter = new HashMap();
            parameter.put("parameter1", start);
            parameter.put("parameter2", end);
            parameter.put("parameter3",st);
            parameter.put("parameter4",dater);
            //parameter.put("end", newDate1);
            byte[] bytes = JasperRunManager.runReportToPdf(file.getPath(),parameter, conn);
            
            response.setContentType("application/pdf");
            response.setContentLength(bytes.length);
            ServletOutputStream outStream = response.getOutputStream();
            outStream.write(bytes, 0, bytes.length);
            outStream.flush();
            outStream.close();
            }catch(Exception ex)
            {
                
            }
        %>
    </body>
</html>


