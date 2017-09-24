<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert ---- here we are in ParkingReceipt ---- </title>
</head>
<body>

<nav class="zNav">
<ul>
<li><a href="./startHere.jsp">Home</a></li>
<li><a href="./topUp.jsp">Top-Up</a></li>
<ul>	
<li><a href="./startHere.jsp">zzzzzzzzzz</a></li>
</ul>
</li>
</ul>
</nav>


<H3>---- Top-Up Receipt ---- </H3>


<table style="width:48%; text-align=right">
  
  
  
  <tr>
    <td>Registration:</td>
    <td><%= request.getAttribute("registration") %></td> 
    <td></td>
  </tr>  
  
  <tr>
    <td>Old Balance:</td>
    <td>$<%= request.getAttribute("oldBalance") %></td> 
    <td></td>
  </tr>
  
  <tr>
    <td>Top-Up Amount:</td>
    <td>$<%= request.getAttribute("topUpAmount") %></td> 
    <td></td>
  </tr>
  
  <tr>
    <td>New Balance:</td>
    <td>$<%= request.getAttribute("newBalance") %></td> 
    <td></td>
  </tr>
  
</table>

 <form id="myForm" action="SpotInfo" method="post" >
 <input id="mySubmit" type="submit" value="OK" style="height:50px; width:50px" >
 </form>
 
</body>
</html>
