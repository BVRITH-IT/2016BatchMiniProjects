<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
body {
    background-image:url(images/login.jpg);
}
body {
    text-align: center;
}
form {
    display: inline-block;
}

h1 {
    color: white;
    text-align: center;
}

p {
    font-family: verdana;
    font-size: 20px;
}

</style>
</head>
<body>
<form name="loginForm" method="post" action="check_user.jsp" >
<table width="20%"  align="center">

<tr>
<td colspan=2><center><font size=4><b> Login Page</b></font></center></td>
</tr>

<tr>
<td>Id</td>
<td><input onsubmit="return validateForm()" type="number" name="id" required>
</td>
</tr>

<tr>
<td>Password</td>
<td><input type="password" name="password" pattern="[0-9A-Za-z]{10}" title ="password must have alphabets or numbers only and upto size 10" required></td>
</tr>

<tr>
<td ><input type="Reset"></td>
<td><input type="submit" onclick="return check(this.form)" value="Login"></td>
</tr>

</table>
</form>

<script>
function validateForm()
{ 
var numbers = /^[0-9]+$/;
if(value.match(numbers))
{
return true;
}
else
{
alert('numeric characters only are allowed');
return false;
}
}
</script>

</body>
</html>