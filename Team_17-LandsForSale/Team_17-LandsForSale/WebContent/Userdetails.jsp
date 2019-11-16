<%@page import="java.sql.*"%>
<style>
body{background-image: url("images/1.jpg");}



</style>
<p style="line-height: 20px;"> <a href="Adminhomepage.jsp"><button type="submit" class="btn"><font size="2">Back</font></button></p>
<p style="line-height: 20px;"> <a href="Home.jsp"><button type="submit" class="btn"><font size="2">Logout</font></button></p>
   
   <body>     
<table border="1">
<tr>
<td>Id</td>
<td>Name</td>
<td>Email</td>
<td>Password</td>
<td>Phone</td>
<td>House No</td>
<td>Colony</td>
<td>City</td>
<td>Pincode</td>

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
	
	String sql ="select * from user";
	resultSet = statement.executeQuery(sql);
	while(resultSet.next()){
	%>
	<tr>
	<td><%=resultSet.getInt(1) %></td>
	<td><%=resultSet.getString(2) %></td>
	<td><%=resultSet.getString(3) %></td>
	<td><%=resultSet.getString(4) %></td>
	<td><%=resultSet.getLong(5) %></td>
	<td><%=resultSet.getInt(6) %></td>
	<td><%=resultSet.getString(7) %></td>
	<td><%=resultSet.getString(8) %></td>
	<td><%=resultSet.getInt(9) %></td>
	
	<td><a href="delete_user.jsp?id=<%=resultSet.getInt(1) %>"><button type="button" class="delete">Delete</button></a></td>
	
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
	</html>