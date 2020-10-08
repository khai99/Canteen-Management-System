<%-- 
    Document   : voucher
    Created on : Apr 8, 2019, 8:09:30 PM
    Author     : User
--%>
<%@page import="entity.Customer"%>
<%@page import="com.sun.xml.rpc.processor.modeler.j2ee.xml.string"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="entity.Food"%>
<%@page import="entity.Orderdetail"%>
<%@page import="entity.Orders"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    String orderr =(String)session.getAttribute("sessorderClick");
 List<Orders> orderList = (List<Orders>)session.getAttribute("sessViewOrder");
 List<Orderdetail> detailList = (List<Orderdetail>)session.getAttribute("sessViewOrderDetail");
 List<Food> foodList = (List<Food>)session.getAttribute("sessViewfood");
 String custID = (String)session.getAttribute("sessCustomerID");
 String sltorder=(String)session.getAttribute("sessSelected");
SimpleDateFormat ft = 
      new SimpleDateFormat ("yyyy/MM/dd");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
	
	<title>Editable Invoice</title>
	
        <link rel='stylesheet' type='text/css' href='receipt/css/style.css' />
	<link rel='stylesheet' type='text/css' href='receipt/css/print.css' media="print" />
        <script type='text/javascript' src='receipt/js/jquery-1.3.2.min.js'></script>
	<script type='text/javascript' src='receipt/js/example.js'></script>

</head>

<body onload="printM()">

    <div id="page-wrap" >

		<textarea id="header">PSDC Food Order Coupon</textarea>
		
                <div id="identity" style="margin-left: 550px;text-align: center">
                    <div>
		<img src="img/logo.png" style="width: 138px; height: 42px"/>
                <br/>
               
            <textarea id="address"  style="font-family: sans-serif; ">

 1, Jalan Sultan Azlan Shah,
 Kawasan Perindustrian Bayan Lepas,
 11900 Bayan Lepas, Pulau Pinang

 Phone Number:04-647 7909
</textarea>
                 </div>
            <div >

              <div id="logoctr">
                <a href="javascript:;" id="change-logo" title="Change logo">Change Logo</a>
                <a href="javascript:;" id="save-logo" title="Save changes">Save</a>
                |
                <a href="javascript:;" id="delete-logo" title="Delete logo">Delete Logo</a>
                <a href="javascript:;" id="cancel-logo" title="Cancel changes">Cancel</a>
              </div>

              <div id="logohelp">
                <input id="imageloc" type="text" size="50" value="" /><br />
                (max width: 540px, max height: 100px)
              </div>
              
            </div>
		
		</div>
		
		<div style="clear:both"></div>
		 <%    for(int i=0;i<orderList.size();i++) {
                            if(orderList.get(i).getOrderid().equals(orderr)){  %>  
                <div id="customer" >

                    <h2  style="font-family: sans-serif;">Redeem code: <span style="color: red"><%=orderList.get(i).getOrderid() %></span></h2><br/>
                   

                    <table id="meta" style="margin-left: 0px; font-family: sans-serif; " >
                 <tr>
                     <td class="meta-head" style="width: 90px ; "><b>Customer ID</b></td>
                    <td>&nbsp;<%=custID%></td>
                </tr>
                <tr>
                    <td class="meta-head" style="width: 80px ; "><b>Order Type</b></td>
                    <td>&nbsp;<%=orderList.get(i).getOrdertype()%></td>
                </tr>
                <tr>

                    <td class="meta-head"><b>Order Date</b></td>
                    <td>&nbsp;<%=ft.format(orderList.get(i).getOrderdate()) %></td>
                </tr>
                <tr>
                    <td class="meta-head"><b>Order Time</b></td>
                    <td><div class="due">&nbsp;<%=orderList.get(i).getOrdertime() %></div></td>
                </tr>

            </table>
		
		</div>
		
		<table id="items" style="font-family: sans-serif;">
		
		  
		      
		      <th>Item</th>
		      <th>Quantity</th>
		      <th>Price</th>
		      <th>Total</th>
		      
		  
		    <% for(int j=0;j< detailList.size();j++) {
                                 if(detailList.get(j).getOrderdetailPK().getOrderid().equals(orderList.get(i).getOrderid())) {  
                                 for(int k=0;k<foodList.size();k++){
                                   if(foodList.get(k).getFoodid().equals(detailList.get(j).getOrderdetailPK().getFoodid())) {%>
		  <tr class="item-row">
		      
		      
		      <td><textarea class="cost"><%=foodList.get(k).getFoodname()%></textarea></td>
		      <td><%=detailList.get(j).getQuantity() %></td>
		      <td><span class="price">RM<%= String.format("%.2f",foodList.get(k).getFoodprice())%></span></td>
		      <td><span class="price">RM<%= String.format("%.2f",foodList.get(k).getFoodprice()*detailList.get(j).getQuantity())%></span></td>
		  </tr>
		  
		   <% }}}}%>
		  
		 
		  
		  <tr>
		      <td colspan="3" class="blank"> </td>
		      
		      <td class="total-value"><div id="subtotal">RM<%= String.format("%.2f",orderList.get(i).getTotalamount())%></div></td>
		  </tr>
		 
                    <% }}%>
              
		
		</table>
		
		<div id="terms">
		  <h5>Terms</h5>
		  <textarea style="font-family: sans-serif;">Coupon can only be redeem at the same day at PSDC canteen</textarea>
		</div>
	
	</div>
	
</body>
                    <script>
                        function printM(){
       window.print();                       
    }
                    </script>
</html>