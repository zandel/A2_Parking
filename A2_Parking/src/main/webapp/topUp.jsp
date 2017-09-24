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
h1 {
margin-right: 50%;
text-align:right;
font-weight: bold;
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
<li><a href="./topUp.jsp">Top-Up</a></li>
<ul>
<li><a href="./startHere.jsp">zzzzzzzzzz</a></li>
</ul>
</li>
</ul>
</nav>
<h1>Top-Up
</h1>
<br><br>
<form id="myForm" action="TopUpAccount" method="post">

Registration (AccountNo):  <input type="text" id="registration"  name="registration"  > <br/> <br/>
Amount:  <input  type="text" name="amount" id="duration" > <br/> <br/>

<input id="mySubmit" type="submit" value="Top-Up Now" style="margin-left=100px;">
<input id="myReset" type="Reset">

<br>
<br>


</form>


</body>
</html>