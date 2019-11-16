<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*,java.lang.*,java.io.*"%>

<%@page import="java.io.InputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


<%
int plotNo=Integer.parseInt(request.getParameter("plotNo"));
int surveyNo=Integer.parseInt(request.getParameter("surveyNo"));
int area=Integer.parseInt(request.getParameter("area"));
String category=request.getParameter("category");
String criteria=request.getParameter("criteria");
int price=Integer.parseInt(request.getParameter("price"));
String place=request.getParameter("place");
String district=request.getParameter("district");
String city=request.getParameter("city");
String state=request.getParameter("state");
int ownerId=Integer.parseInt(request.getParameter("ownerId"));
String ownerName=request.getParameter("ownerName");
Long ownerPhone=Long.parseLong(request.getParameter("ownerPhone"));


try
{
Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bvrit", "root", "123456");

Statement st=conn.createStatement();


int i=st.executeUpdate("insert into land(plotNo,surveyNo,area,category,criteria,price,place,district,city,state,ownerId,ownerName,ownerPhone)values('"+plotNo+"','"+surveyNo+"','"+area+"','"+category+"','"+criteria+"','"+price+"','"+place+"','"+district+"','"+city+"','"+state+"','"+ownerId+"','"+ownerName+"','"+ownerPhone+"')");

response.sendRedirect("buyers.jsp");

}
catch(Exception e)
{
System.out.print(e);
e.printStackTrace();
}

%>
