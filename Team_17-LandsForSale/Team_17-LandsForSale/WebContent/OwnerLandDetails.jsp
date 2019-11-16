
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
body {
background-image: url("images/land.jpg");
    background-color: #ccffe6;
}
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
<h1>Land Details Form</h1>
<%
int id=(int)session.getAttribute("sessname"); 
out.print("Your id: "+id); 
%> 
<form name='registration' action="land_insert.jsp" enctype="multipart/form-data">
<ul>
<li><label for="plotNo">Plot No</label></li>
<li><input type="text" name="plotNo" size="12" /></li>
<li><label for="surveyNo">Survey No</label></li>
<li><input type="text" name="surveyNo" size="50" /></li>
<li><label for="area">Area</label></li>
<li><input type="text" name="area" size="50" /></li>
<li><label for="category">Category</label></li>
<li><select name="category">
<option selected="" value="Default">(Please select a category)</option>
<option value="Agricultural">Agricultural</option>
<option value="Commercial">Commercial</option>
<option value="Recreational">Recreational</option>
<option value="Residential">Residential</option>
</select></li>
<li><label for="criteria">Criteria</label></li>
<li><select name="criteria">
<option selected="" value="Default">(Please select a criteria)</option>
<option value="Fixed Rate">Fixed Rate</option>
<option value="Lease">Lease</option>
<option value="Offers">Offers</option>
<option value="Loans">Loans</option>
</select></li>

<li><label for="price">Price</label></li>
<li><input type="text" name="price" size="12" /></li>
<li><label for="place">Place</label></li>
<li><input type="text" name="place" size="50" /></li>
<li><label for="district">District</label></li>
<li><input type="text" name="district" size="50" /></li>
<li><label for="city">City</label></li>
<li><select name="city">
<option selected="" value="Default">(Please select a city)</option>
<option value="Hyderabad">Hyderabad</option>
<option value="Sangareddy">Sangareddy</option>
<option value="Rangareddy">Rangareddy</option>
<option value="Zaheerabad">Zaheerabad</option>
</select></li>
<li><label for="state">State</label></li>
<li><input type="text" name="state" size="50" /></li>
<br>


<li><label for="ownerId">Owner Id</label></li>
<li><input type="text" name="ownerId" /></li>
<li><label for="ownerName">Owner Name</label></li>
<li><input type="text" name="ownerName" size="50" /></li>
<li><label for="ownerPhone">Owner Phone</label></li>
<li><input type="text" name="ownerPhone" size="50" /></li>
<li><input type="submit" name="submit" value="Submit" /></li>
</ul>

</form>

</body>
</html>
<body>

  
</body>
<script>
function formValidation()
{
var plotNo = document.registration.plotNo;
var surveyNo = document.registration.surveyNo;
var area = document.registration.area;
var category = document.registration.category;
var criteria = document.registration.criteria;
var price = document.registration.price;
var place = document.registration.place;
var district = document.registration.district;
var city = document.registration.city;
var state = document.registration.state;
var ownerId = document.registration.ownerId;
var ownerName = document.registration.ownerName;
var ownerPhone = document.registration.ownerPhone;
 if(uplotno_validation(plotNo,3))
{
if(usurveyno_validation(surveyNo,4))
{
if(uarea_validation(area))
{
if(category_allLetter(category))
{
if(criteria_allLetter(criteria))
{
if(price_validation(price))
{
if(place_allLetter(place))
{
if(district_allLetter(district))
{ 
if(cityselect(city))
{
if(state_allLetter(state))
{
if(ownerid_validation(ownerId))
{
if(ownername_validation(ownerName))
{
if(ownerphone_validation(ownerPhone,9))
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
}
}
}
}

return false;

} function uplotno_validation(plotNo,mx)
{
var uid_len = plotNo.value.length;
if (uid_len == 0 || uid_len != mx)
{
alert("Plot number should not be empty / length should be "+mx);
plotNo.focus();
return false;
}
return true;
}
function usurveyno_validation(surveyNo,mx)
{
var uid_len = surveyNo.value.length;
if (uid_len == 0 || uid_len != mx)
{
alert("Survey number should not be empty / length should be "+mx);
surveyNo.focus();
return false;
}
return true;
}
function uarea_validation(area)
{
var uid_len = area.value.length;
if (uid_len == 0)
{
alert("Area should not be empty ");
area.focus();
return false;
}
return true;
}
function category_allLetter(category)
{ 
var letters = /^[A-Za-z]+$/;
if(category.value.match(letters))
{
return true;
}
else
{
alert('Category should not be empty/must have alphabet characters only');
category.focus();
return false;
}
}
function criteria_allLetter(criteria)
{ 
var letters = /^[A-Za-z]+$/;
if(criteria.value.match(letters))
{
return true;
}
else
{
alert('Criteria should not be empty/must have alphabet characters only');
criteria.focus();
return false;
}
}

function price_validation(price)
{
var houseno_len = price.value.length;
if (houseno_len == 0)
{
alert("Price should not be empty");
price.focus();
return false;
}
return true;
}
function place_allLetter(place)
{ 
var letters = /^[A-Za-z]+$/;
if(place.value.match(letters))
{
return true;
}
else
{
alert('Place should not be empty/must have alphabet characters only');
place.focus();
return false;
}
}
function district_allLetter(district)
{ 
var letters = /^[A-Za-z]+$/;
if(district.value.match(letters))
{
return true;
}
else
{
alert('District should not be empty/must have alphabet characters only');
district.focus();
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
function state_allLetter(state)
{ 
var letters = /^[A-Za-z]+$/;
if(state.value.match(letters))
{
return true;
}
else
{
alert('State should not be empty/must have alphabet characters only');
state.focus();
return false;
}
}

function ownerid_validation(ownerId)
{
var uid_len = ownerId.value.length;
if (uid_len == 0)
{
alert("Owner Id should not be empty ");
ownerId.focus();
return false;
}
return true;
}
function ownername_validation(ownerName)
{ 
var letters = /^[A-Za-z]+$/;
if(ownerName.value.match(letters))
{
return true;
}
else
{
alert('Owner name should not be empty/must have alphabet characters only');
ownerName.focus();
return false;
}
}
function ownerphone_validation(ownerPhone,mx)
{ 
	var upincode_len = ownerPhone.value.length;
	if (upincode_len == 0 || upincode_len != mx)
{
		alert("Owner phone number must have numeric characters only / length should be "+mx);
		ownerPhone.focus();
		return false;
}
else
{
	return true;

}
}

</script>
<style>
<style>
.container {
  position: relative;
}

.topright {
  position: absolute;
  top: 8px;
  right: 16px;
  font-size: 18px;
}
#first {
    width: 100px;
    float: left;
    height: 300px;
        
}
#second {
    width: 200px;
    float: left;
    height: 300px;
    
}


</style>
</head>
<body>
</style>      
<div class="container">

  <div style="width:300px; float:left;"class="topright" style="line-height: 20px;"> <a href="landdetaildisplay.jsp"><button type="submit" class="btn" ><font size="2">Back</font></button></div> 
  <div style="width:300px; float:right;"class="bottomright" style="line-height: 20px;"> <a href="Home.jsp"><button type="submit" class="btn" ><font size="2">Logout</font></button></div><br>
  
</div>
