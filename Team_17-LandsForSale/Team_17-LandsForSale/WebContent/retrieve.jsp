<%@page import="java.sql.*"%>

<%
try{
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	Class.forName("com.mysql.jdbc.Driver");
	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bvrit","root","123456");
	statement=connection.createStatement();
	System.out.println("Connection established");
	
	String sql ="select * from admin";
	resultSet = statement.executeQuery(sql);
	while(resultSet.next()){
	%>
	<tr>
	<td><%=resultSet.getInt(1) %></td>
	<td><%=resultSet.getString(2) %></td>
	
	
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