<%@page import="java.sql.*"%>
<%
try{
int id=Integer.parseInt(request.getParameter("id"));
String password=request.getParameter("password");
 Class.forName("com.mysql.jdbc.Driver").newInstance();
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bvrit","root","123456");  
           Statement st=con.createStatement();
           ResultSet rs=st.executeQuery("select * from admin where id='"+id+"' and password='"+password+"'");
           int count=0;
           while(rs.next()){
           count++;
          }
          if(count>0){
        	  response.sendRedirect("Adminhomepage.jsp");
           }
          else{
           response.sendRedirect("Login2.jsp");
          }
        }
    catch(Exception e){
    System.out.println(e);
}
%>