<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*"%>

<%

try
{
String name=request.getParameter("uname");
String selected=request.getParameter("status");
Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/availdoctors", "root", "1234");
Statement st=conn.createStatement();
if (!selected.equals("select"))
{
   int j = st.executeUpdate("update makeappointment_details set status='" + selected + "' where name='" + name + "' ");
   
 }out.println("<html><body onload=\"alert('Successfully done!!')\" if(onload==ok){window.location.href='viewappointment.jsp'}></body></html>");
 
}
catch(Exception e)
{
System.out.print(e);
e.printStackTrace();
}
%>