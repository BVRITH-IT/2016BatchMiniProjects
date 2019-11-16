<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<style>

body {

background-image: url("images/typesofland.jpg");


}
<%
int id=(int)session.getAttribute("sessname"); 
out.print("Your id: "+id); 
%> 


</body>
</style>
<style>
.btn-group button {
    position: left
    background-color: #4CAF50; /* Pink background */
    border: 10px solid pink; /* White border */
    color: black; /* Black text */
    padding: 10px 24px; /* Some padding */
    cursor: pointer; /* Pointer/hand icon */
    width: 250px;
    height:80px;/* Set a width if needed */
    display: block; /* Make the buttons appear below each other */
}

.btn-group button:not(:last-child) {
    border-bottom: none; /* Prevent double borders */
}

/* Add a background color on hover */
.btn-group button:hover {
    background-color: pink;
}
</style>
<h1 style="color:black;"><p align="center"><font size="80">Types of Lands</font></p></h1>

<div class="btn-group" align="left">

<p style="line-height: 70px; text-align: center;"> <a href="AgriculturalLand.jsp"><button type="submit" class="btn"><font size="5">Agricultural</font></button></p>
<p style="line-height: 70px; text-align: center;"> <a href="CommercialLand.jsp"><button type="submit" class="btn"><font size="5">Commercial</font></button></p>
<p style="line-height: 70px; text-align: center;"> <a href="RecreationalLand.jsp"><button type="submit" class="btn"><font size="5">Recreational</font></button></p>
 <p style="line-height: 70px; text-align: center;"> <a href="ResidentialLand.jsp"><button  type="submit" class="btn"><font size="5">Residential</font></button></p>


<div style="width:300px; float:right;"class="bottomright" style="line-height: 20px;"> <a href="Home.jsp"><button color="pink" type="submit" class="btn" ><font size="4">Logout</font></button></div> 
  <div style="width:300px; float:right;"class="bottomright" style="line-height: 20px;"> <a href="BuyerSeller.jsp"><button color="pink" type="submit" class="btn" ><font size="4">Back</font></button></div><br>
  
</div>
</body>
  
</html>