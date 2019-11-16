<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
h1 {
margin-left: 70px;
}
body {margin:0;font-family:Arial;background-image:url("images/register.jpg")}
form li {
list-style: none;
margin-bottom: 5px;
}

form ul li label{
float: left;
clear: left;
width: 100px;
text-align: right;
margin-right: 10px;
font-family:Verdana, Arial, Helvetica, sans-serif;
font-size:14px;
}

form ul li input, select, span {
float: left;
margin-bottom: 10px;
}

form textarea {
float: left;
width: 350px;
height: 150px;
}

[type="submit"] {
clear: left;
margin: 20px 0 0 230px;
font-size:18px
}

p {
margin-left: 70px;
font-weight: bold;
}
</style>
<html lang="en"><head>
<meta charset="utf-8">
</head>
<body onload="document.registration.userid.focus();">
<h1>User Registration Form</h1>

<form name='registration' action = "register_insert.jsp" ">
<ul>
<li><label for="id">User Id</label></li>
<li><input type="text" name="id" required /></li>
<li><label for="name">Name</label></li>
<li><input type="text" name="name"  required/></li>
<li><label for="email">Email</label></li>
<li><input type="text" name="email" size="50" required/></li>
<li><label for="password">Password</label></li>
<li><input type="password" name="password"  required/></li>
<li><label for="phone">Phone</label></li>
<li><input type="text" name="phone" required/></li>
<li><label for="houseno">House No</label></li>
<li><input type="text" name="houseno" required/></li>
<li><label for="colony">Colony</label></li>
<li><input type="text" name="colony" required /></li>
<li><label for="city">City</label></li>
<li><select name="city">
<option selected="" value="Default">(Please select a city)</option>
<option value="Hyderabad">Hyderabad</option>
<option value="Sangareddy">Sangareddy</option>
<option value="Rangareddy">Rangareddy</option>
<option value="Zaheerabad">Zaheerabad</option>

</select></li>
<li><label for="pincode">Pincode</label></li>
<li><input type="text" name="pincode" /></li>
<li><input type="submit" name="submit" value="Submit" required/></li>
</ul>
</form>

</body>
<script>
function formValidation()
{
var id = document.registration.id;
var name = document.registration.name;
var email = document.registration.email;
var password = document.registration.password;
var phone = document.registration.phone;
var houseno = document.registration.houseno;
var colony = document.registration.colony;
var city = document.registration.city;
var pincode = document.registration.pincode;

 if(userid_validation(id,3))
{
if(allLetter(name))
{
if(ValidateEmail(email))
{
if(passid_validation(password,10))
{
if(phone_validation(phone,9))
{
if(alphanumeric(houseno))
{
if(alphanumeric(colony))
{ 
if(cityselect(city))
{
if(pincode_validation(pincode,6))
{

}
} 
}
} 
}
}
}
}
}

return false;

} function userid_validation(id,mx)
{
var uid_len = id.value.length;
if (uid_len == 0 || uid_len != mx)
{
alert("User Id should not be empty / length should be "+mx);
id.focus();
return false;
}
return true;
}
function allLetter(name)
{ 
var letters = /^[A-Za-z]+$/;
if(name.value.match(letters))
{
return true;
}
else
{
alert('Username should not be empty/must have alphabet characters only');
name.focus();
return false;
}
}
function ValidateEmail(email)
{
var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
if(email.value.match(mailformat))
{
return true;
}
else
{
alert("You have entered an invalid email address!");
email.focus();
return false;
}
}
function passid_validation(password,mx)
{
var passid_len = password.value.length;
if (passid_len == 0 ||passid_len != mx)
{
alert("Password should not be empty / length should be "+mx);
password.focus();
return false;
}
return true;
}
function phone_validation(phone,mx)
{
var phone_len = phone.value.length;
if (phone_len == 0 ||phone_len != mx)
{
alert("Phone number should not be empty / length should be "+mx);
phone.focus();
return false;
}
return true;
}
function houseno_validation(houseno)
{
var houseno_len = houseno.value.length;
if (houseno_len == 0)
{
alert("House number should not be empty");
houseno.focus();
return false;
}
return true;
}

function alphanumeric(colony)
{ 
var letters = /^[0-9a-zA-Z]+$/;
if(colony.value.match(letters))
{
return true;
}
else
{
alert('Colony should not be empty/must have alphanumeric characters only');
colony.focus();
return false;
}
}
function cityselect(city)
{
if(city.value == "Default")
{
alert('Select your city from the list');
city.focus();
return false;
}
else
{
return true;
}
}
function pincode_validation(pincode,mx)
{ 
	var upincode_len = pincode.value.length;
	if (upincode_len == 0 || upincode_len != mx)
{
		alert("Pincode must have numeric characters only / length should be "+mx);
		pincode.focus();
		return false;
}
else
{
	return true;

}
}

</script>
</html>