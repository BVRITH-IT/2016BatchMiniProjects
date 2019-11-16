<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*,java.lang.*,java.io.*"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


<%
int id=Integer.parseInt(request.getParameter("id"));



try
{
	
Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bvrit", "root", "123456");
Statement st=conn.createStatement();

int i=st.executeUpdate("delete from user where id="+id);

response.sendRedirect("delete2.jsp");

}
catch(Exception e)
{
System.out.print(e);
e.printStackTrace();
}

%>
