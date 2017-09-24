<%@ page import="java.util.ArrayList, java.util.Iterator, dbAccess.ParkingSpot" %>
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


<%
ArrayList<ParkingSpot> xx;
xx = ( ArrayList<ParkingSpot> ) request.getAttribute("myAttribute");
%>

<%
for ( ParkingSpot  zz  : xx ) {
	
	String street =    zz.getstreetName().toUpperCase()  ;
	int no = zz.getspotNo()      ;
	String stts = zz.getstatus().toUpperCase();
	
    
	System.out.println ( "***************");
    System.out.println ( street     );
    System.out.println ( no     );
    System.out.println ( stts     );
    System.out.println ( "***************");
%>

<form id="myForm" method="post"  style="display: block" action="ProcessGetSpot">

<%= street %> &nbsp spot #<%= no %>  <%= stts %>

<%
if  ( stts.equals("FREE")){
	
%>
<input type="hidden" name="street" value="<%=street%>"      ></input>
<input type="hidden" name="spotNo" value="<%=no%>"      ></input>
<input type="submit" value="occupy" style="background-color=green"> </input>
<input type="hidden" name="colour" value="<%= stts  %>"      > </input>

<%
}
%>
<%
if  ( stts.equals("BUSY")){
	
%>
<input type="hidden" name="street" value="<%=street%>"      ></input>
<input type="hidden" name="spotNo" value="<%=no%>"      ></input>
<input type="submit" value="release" style="background-color=RED"> </input>
<input type="hidden" name="colour" value="<%= stts  %>"      > </input>
<%
}
%>



</form>
<BR>

<%
}
%>

</body>
