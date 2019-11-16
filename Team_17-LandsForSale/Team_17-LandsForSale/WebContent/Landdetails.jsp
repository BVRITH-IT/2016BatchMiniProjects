<%@page import="java.sql.*"%>
<%@page import="java.sql.*,java.util.*,java.lang.*,java.io.*"%>

<style>
body{background-image: url("images/1.jpg");}



</style>
<p style="line-height: 20px;"> <a href="Adminhomepage.jsp"><button type="submit" class="btn"><font size="2">Back</font></button></p>
<p style="line-height: 20px;"> <a href="Home.jsp"><button type="submit" class="btn"><font size="2">Logout</font></button></p>
        

<table border="1">
<tr>
<td>Plot No</td>
<td>Survey No</td>
<td>Area</td>
<td>Category</td>
<td>Criteria</td>
<td>Price</td>
<td>Place</td>
<td>District</td>
<td>City</td>
<td>State</td>
<td>Owner Id</td>
<td>Owner Name</td>
<td>Owner Phone</td>
</tr>
<%
try{
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	Class.forName("com.mysql.jdbc.Driver");
	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bvrit","root","123456");
	statement=connection.createStatement();
	System.out.println("Connection established");
	
	String sql ="select * from land";
	resultSet = statement.executeQuery(sql);
	while(resultSet.next()){
	%>
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
	
	<td><a href="delete_land.jsp?plotNo=<%=resultSet.getInt(1) %>"><button type="button" class="delete">Delete</button></a></td>
	</tr>
	<%
	}
	connection.close();
	} catch (Exception e) {
	e.printStackTrace();
	}
	%>
	<body></body>
	<br>
	<br>
	
	
	
	

</table>
</form>
	
	</html>
	
	