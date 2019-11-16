package com.ts.web;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ts.dao.userDAO;
import com.ts.dto.registerDTO;

@WebServlet("/userServlet")
public class userServlet extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		String utype=request.getParameter("utype");	
		response.setContentType("text/html");
		 
		userDAO userDao = new userDAO();
		registerDTO user=userDao.getuser(uname,pwd,utype);
		System.out.println("Inside servlet:"+user);
		out.println("<html>");
		if(user !=null && uname.equals("Admin")){
			RequestDispatcher d=request.getRequestDispatcher("utype1.html");	
			d.forward(request, response);			
		}
		else if(user !=null && utype.equals("Doctor")){
			RequestDispatcher d=request.getRequestDispatcher("utype2.html");	
			d.forward(request, response);			
		}
		else if(user !=null && utype.equals("Users")){
			RequestDispatcher d=request.getRequestDispatcher("utype3.html");	
			d.forward(request, response);			
		}
		
		out.println("</html>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}
}
