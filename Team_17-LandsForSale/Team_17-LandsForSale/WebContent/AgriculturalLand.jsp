<%@page import="java.sql.*"%>
<html>
<h1>Agricultural Land</h1>

<br>
<br>        
<style>
body {
background-image: url("images/2.jpg");
    background-color: #ccffe6;
}
<style>
.tooltip {
  position: relative;
  display: inline-block;
  border-bottom: 1px dotted black;
}

.tooltip .tooltiptext {
  visibility: hidden;
  width: 250px;
  background-color: black;
  color: #fff;
  text-align: center;
  border-radius: 6px;
  padding: 5px 0;

  /* Position the tooltip */
  position: absolute;
  z-index: 1;
}

.tooltip:hover .tooltiptext {
  visibility: visible;
}
</style>


</tr>
<%
try{
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	Class.forName("com.mysql.jdbc.Driver");
	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bvrit","root","123456");
	statement=connection.createStatement();
	
	
	/*int id1 = Integer.parseInt(request.getParameter());  */

	String sql ="select * from land where category ='" + "Agricultural" + "'";
	resultSet = statement.executeQuery(sql);
	while(resultSet.next()){
	%>
	<table border="1">
<tr>
<td><b>Plot No</b></td>
<td><b>Survey No</b></td>
<td><b>Area</b></td>
<td><b>Category</b></td>
<td><b>Criteria</b></td>
<td><b>Price</b></td>
<td><b>Place</b></td>
<td><b>District</b></td>
<td><b>City</b></td>
<td><b>State</b></td>

<td><b>Owner Id</b></td>
<td><b>Owner Name</b></td>
<td><b>Owner Phone</b></td>
	
	<tr>
	<td><%=resultSet.getInt(1) %></td>
	<td><%=resultSet.getInt(2) %></td>
	<td><%=resultSet.getInt(3) %></td>
	<td><%=resultSet.getString(4) %></td>
	<td><%=resultSet.getString(5) %></td>
	<td><%=resultSet.getInt(6) %></td>
	<td><%=resultSet.getString(7) %></td>
	<td><%=resultSet.getString(8) %></td>
	<td><%=resultSet.getString(9) %></td>
	<td><%=resultSet.getString(10) %></td>

	
	<td><%=resultSet.getInt(11) %></td>
	<td><%=resultSet.getString(12) %></td>
	<td><%=resultSet.getLong(13) %></td>
	</tr>
	
	<%
	
	}
	connection.close();
	} catch (Exception e) {
	e.printStackTrace();
	}
	%>
	</table>
	</body>
	<body>
	<br>
	<br>
	</body>
	</html>
	<body style="text-align:left;">


<div class="tooltip">Want to buy the land
  <span class="tooltiptext">Please contact the owner</span>
</div>
	

       
	</script>
       <p style="line-height: 20px;"> <a href="TypesOfLand.jsp"><button type="submit" class="btn"><font size="2">Back</font></button></p>
<p style="line-height: 20px;"> <a href="Home.jsp"><button type="submit" class="btn"><font size="2">Logout</font></button></p>
        