<%@page import="java.sql.*"%>
<html>
<h1>Details of your Land</h1>
<style>
body {
background-image: url("images/about1.jpg");
    background-color: #ccffe6;
}
</style>
<%
int id=(int)session.getAttribute("sessname"); 
out.print("Your id: "+id); 
%>
<br>
<br>        
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


</tr>
<%
try{
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	Class.forName("com.mysql.jdbc.Driver");
	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bvrit","root","123456");
	statement=connection.createStatement();
	int id1=(int)session.getAttribute("sessname"); 
	 
	/*int id1 = Integer.parseInt(request.getParameter());  */

	String sql ="select * from land where ownerId ='" + id1 + "'";
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
	<td><a href="delete_owner.jsp?id=<%=resultSet.getInt(1) %>"><button type="button" class="delete">Delete</button></a></td>
	
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
	<form action="OwnerLandDetails.jsp" method="post">
	 <p style="line-height: 20px;">
        <button name="subject" type="submit">Upload a Land</button>
        </form>
       <p style="line-height: 20px;"" color= blue;"> <a href="BuyerSeller.jsp"><button type="submit" class="btn"><font size="2">Back</font></button></p>
<p style="line-height: 20px;" "color=blue;">  <a href="Home.jsp"><button type="submit" class="btn"><font size="2">Logout</font></button></p>
         