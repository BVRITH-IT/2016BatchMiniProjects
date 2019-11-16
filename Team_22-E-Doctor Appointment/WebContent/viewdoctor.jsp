<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<html lang="en">
  <head>
    <title>Online Doctor Appointment</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900" rel="stylesheet">

    <link rel="stylesheet" href="css/open-iconic-bootstrap.min.css">
    <link rel="stylesheet" href="css/animate.css">
    
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">
    <link rel="stylesheet" href="css/magnific-popup.css">

    <link rel="stylesheet" href="css/aos.css">

    <link rel="stylesheet" href="css/ionicons.min.css">
    
    <link rel="stylesheet" href="css/flaticon.css">
    <link rel="stylesheet" href="css/icomoon.css">
    <link rel="stylesheet" href="css/style.css">
    <style>
body {font-family: georgia,garamond,serif;font-size:20px;font-style:italic;}
form {border: 4px solid #f1f1f1;}

label {
  text-align:right;
  padding-right:20px;
  display:inline-block;
  min-width:150px;
}

input[type=text], input[type=password] {
  width: 30%;
  padding: 12px 20px;
  margin: 4px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

button {
  background-color: black;
  color: white;
  padding: 14px 20px;
  margin: 2px 0;
  border: none;
  cursor: pointer;
  width: 25%;
}

button:hover {
  opacity: 0.8;
}

.container {
  padding: 10px;
}

.imgcontainer {
  text-align: center;
  margin: 2px 0 2px 0;
} 
table, th, td {  
    border: 1px solid black;  
    border-collapse: collapse;  
}  
th, td {  
    padding: 10px;  
}  
</style>  
    
	<style>
	button {
	  background-color: lightblue;
	  color: black;
	  padding: 14px 20px;
	  margin: 8px 0;
	  border: none;
	  cursor: pointer;
	  width: 15%;
	}
	
	button:hover {
	  opacity: 0.8;
	}
}
</style>
  </head>
  <body data-spy="scroll" data-target=".site-navbar-target" data-offset="300">
  <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light site-navbar-target" id="ftco-navbar">
	    <div class="container">
	      <a class="navbar-brand" href="index.html">Avail Doctors</a>
	      <button class="navbar-toggler js-fh5co-nav-toggle fh5co-nav-toggle" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
	        <span class="oi oi-menu"></span> Menu
	      </button>
	    </div>
	  </nav>
	  
	  <section class="hero-wrap js-fullheight" style="background-image: url('images/bg3.jpg');" data-section="home" data-stellar-background-ratio="0.5">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text js-fullheight align-items-center justify-content-start" data-scrollax-parent="true">
          <div class="col-md-6 pt-5 ftco-animate">
          	<div class="mt-5">
          		<span class="subheading">Welcome to E-Doctor Appointment</span>
	            <h1 class="mb-4">We are here <br>for your Care</h1>
            </div>
          </div>
        </div>
      </div>
    </section>
    
    
    <br><br>
            <center><h1>Doctor Details</h1></center>
<%
try {
//String connectionURL = "jdbc:mysql://localhost:3306/availdoctors";
Connection connection = null;
Statement statement = null;
ResultSet rs = null;
Class.forName("com.mysql.jdbc.Driver").newInstance();
connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/availdoctors", "root", "1234");
statement = connection.createStatement();
String val=request.getParameter("qual");

String QueryString = "SELECT * from registereddoctor_details where qualification='"+val+"' ";
rs = statement.executeQuery(QueryString);

%>
<center>
<!-- <table border="2" borderColor="#ffe9bf" cellPadding="0" cellSpacing="0" width="658" height="63">-->
<TABLE>
            <TR>
                <TH>Name</TH>
                <TH>Specialization</TH>
                <TH>Start</TH>
                <TH>End</TH>
                <TH>Hospital</TH>
                <TH>Email</TH>
            </TR>
            <% while(rs.next()){ %>
            <TR>
                <TD> <%= rs.getString(1) %></td>
                <TD> <%= rs.getString(2) %></TD>
                <TD> <%= rs.getString(3) %></TD>
                <TD> <%= rs.getString(4) %></TD>
                <TD> <%= rs.getString(5) %></TD>
                <TD> <%= rs.getString(6) %></TD>
                
            </TR>
            <% } %>
        </TABLE>
        </center>

<%
rs.close();
statement.close();
connection.close();
} catch (Exception ex) {
%>
<font size="+3" color="red"></b>
<%
out.println("Unable to connect to database.");
}
%>
</font>

                    
			
    <!-- ##### All Javascript Script ##### -->
    <!-- jQuery-2.2.4 js -->
    <script src="js/jquery/jquery-2.2.4.min.js"></script>
    <!-- Popper js -->
    <script src="js/bootstrap/popper.min.js"></script>
    <!-- Bootstrap js -->
    <script src="js/bootstrap/bootstrap.min.js"></script>
    <!-- All Plugins js -->
    <script src="js/plugins/plugins.js"></script>
    <!-- Active js -->
    <script src="js/active.js"></script>
</body>

</html>