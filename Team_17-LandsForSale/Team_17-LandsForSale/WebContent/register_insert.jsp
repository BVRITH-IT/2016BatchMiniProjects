<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<%

int id=Integer.parseInt(request.getParameter("id"));
String name=request.getParameter("name");
String email=request.getParameter("email");
String password=request.getParameter("password");
Long phone=Long.parseLong(request.getParameter("phone"));
int houseno=Integer.parseInt(request.getParameter("houseno"));
String colony=request.getParameter("colony");
String city=request.getParameter("city");
int pincode=Integer.parseInt(request.getParameter("pincode"));
System.out.print("before try in insert");

try
{
Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bvrit", "root", "123456");
Statement st=conn.createStatement();

int i=st.executeUpdate("insert into user(id,name,email,password,phone,houseno,colony,city,pincode) values('"+id+"','"+name+"','"+email+"','"+password+"','"+phone+"','"+houseno+"','"+colony+"','"+city+"','"+pincode+"')");
response.sendRedirect("Login1.jsp");
//out.println("Data is successfully inserted!");
}
catch(Exception e)
{
System.out.print(e);
e.printStackTrace();
}

%>
