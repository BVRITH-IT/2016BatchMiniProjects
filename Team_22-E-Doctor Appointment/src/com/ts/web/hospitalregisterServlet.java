package com.ts.web;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ts.dao.hospitalregisterDAO;
import com.ts.dto.hospitalregisterDTO;

@WebServlet("/hospitalregisterServlet")
public class hospitalregisterServlet extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String hname=request.getParameter("hname");
		String address=request.getParameter("address");
		String state=request.getParameter("state");
		String country=request.getParameter("country");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		hospitalregisterDTO user=new hospitalregisterDTO();
		user.sethname(hname);
		user.setaddress(address);
		user.setstate(state);
		user.setcountry(country);
		user.setphone(phone);
		user.setemail(email);
		System.out.println(user);
		
		hospitalregisterDAO userDao = new hospitalregisterDAO();
		if(hospitalregisterDAO.add(user)!=0){
			response.getWriter().println("<html><body onload=\"alert('Hospital Registered Successfully')\"></body></html>");
			RequestDispatcher dispatcher=request.getRequestDispatcher("utype1.html");
			dispatcher.include(request, response);
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}
}