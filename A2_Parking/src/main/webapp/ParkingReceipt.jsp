<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert ---- here we are in ParkingReceipt ---- </title>
</head>
<body>
<H3>---- Parking Receipt ---- </H3>


<table style="width:48%; text-align=right">
  
  <tr>
    <td>Street:</td>
    <td><%= request.getAttribute("streetName") %></td> 
    <td></td>
  </tr>
  <tr>
    <td>Spot Number:</td>
    <td><%= request.getAttribute("spotNumber") %></td> 
    <td></td>
  </tr>
  
  <tr>
    <td>Registration:</td>
    <td><%= request.getAttribute("regNumber") %></td> 
    <td></td>
  </tr>  
  
  <tr>
    <td>Duration:</td>
    <td><%= request.getAttribute("duration") %></td> 
    <td>minutes</td>
  </tr>
  <tr>
    <td>New Balance:</td>
    <td>$<%= request.getAttribute("newBalance") %></td> 
    <td>=($1000 - fee)</td>
  </tr>
  <tr>
    <td>start:</td>
    <td><%= request.getAttribute("startTime") %></td> 
    <td></td>
  </tr>
  <tr>
    <td>end time:</td>
    <td><%= request.getAttribute("endTime") %></td> 
    <td></td>
  </tr>
</table>

 <form id="myForm" action="SpotInfo" method="post" >
 <input id="mySubmit" type="submit" value="OK" style="height:50px; width:50px" >
 </form>
 
</body>
</html>
