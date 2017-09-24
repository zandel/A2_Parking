<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<style>

#myForm{
margin: 0 auto;
}

#myForm{
margin-right: 50%;
text-align:right;
font-weight: bold;
}

#myForm {
text-align:-moz-right;
margin-right: 40%;

}
</style>


</head>
<body>


<nav class="zNav">

<ul>

<li><a href="./startHere.jsp">Home</a></li>



<li><a href="./startHere.jsp">Home</a></li>

<ul>	

<li><a href="./startHere.jsp">zzzzzzzzzz</a></li>

</ul>



</li>

</ul>

<li><a href="./startHere.jsp">Contact</a>

</li>

</ul>

</nav>

<!-- Parking spot:&nbsp<%= request.getAttribute("myStreet") %>&nbsp# <%= request.getAttribute("mySpot") %> -->
<br><br>
<form id="myForm" action="ParkingReg" method="post">
Registration (AccountNo):  <input type="text" id="registration"  name="registration"  > <br/> <br/>
Duration(minutes):  <input  type="text" name="duration" id="duration" > <br/> <br/>

street:  <input  type="text" name="street" readonly="readonly" value="<%= request.getAttribute("myStreet") %>" > <br/> <br/>
spotNo:  <input  type="text" name="spotNo" readonly="readonly" value="<%= request.getAttribute("mySpot") %>" > <br/> <br/>
<input id="mySubmit" type="submit" value="Park Now" style="margin-left=100px;">
<input id="myReset" type="Reset">
<br>
<br>
<br>
Testing Info:</br></br>
Useful registration numbers in the mysql database "onlinejobseek":
123456
<br>
777888
<br>
<br>
Please note: Clicking "Park Now" will immediately bring the balance to $1000
<br>
so that testing of payment procees can commence
<br>
regardless of previous balance


</form>


</body>
</html>