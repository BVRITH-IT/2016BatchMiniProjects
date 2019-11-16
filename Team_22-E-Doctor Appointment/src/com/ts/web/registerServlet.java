package com.ts.web;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ts.dao.registerDAO;
import com.ts.dto.registerDTO;

@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		String utype=request.getParameter("utype");
		registerDTO user=new registerDTO();
		user.setuname(uname);
		user.setpwd(pwd);
		user.setutype(utype);
		System.out.println(user);
		
		registerDAO userDao = new registerDAO();
		if(registerDAO.add(user)!=0){
			response.getWriter().println("<html><body onload=\"alert('Registration Success')\"></body></html>");
			RequestDispatcher dispatcher=request.getRequestDispatcher("index.html");
			dispatcher.include(request, response);
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}
}