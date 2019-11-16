<html>
<body>



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
body{background-image: url("images/bg1.jpg");}


}
</style>
<body>

</body>
<style>
.btn {
    border: purple;
    background-color: pink;
    padding: 14px 28px;
    font-size: 16px;
    cursor: pointer;
    display: inline-block;
}

.btn:hover {background: #eee;}

.success {color: pink;}
.info {color: dodgerblue;}
.warning {color: orange;}
.danger {color: red;}
.default {color: black;}
</style>
 
 </head>
</style>
<h1 style="color:Pink;"><p align="center"><font size="5">Congratulations!!! You are successfully logged in...</font></p></h1>
<%
int id=(int)session.getAttribute("sessname");
%>
<h2 style="color:Pink;">Your id:<%out.print(+id); %>  </h2>

<div class="btn-group">
<p style="line-height: 40px; text-align: center;"> <a href="landdetaildisplay.jsp"><button align =left color=Grey type="submit" class="btn"><font size="5">Owner</font></button></p>
<p style="line-height: 40px; text-align: center;"> <a href="TypesOfLand.jsp"><button align=right color=Grey type="submit" class="btn"><font size="5">Buyer</font></button></p>

</div>

</body>

<p style="line-height: 20px;"> <a href="Home.jsp"><button type="submit" class="btn"><font size="2">Logout</font></button></p>
</html>