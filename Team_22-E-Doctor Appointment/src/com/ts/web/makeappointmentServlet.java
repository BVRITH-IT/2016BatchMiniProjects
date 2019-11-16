package com.ts.web;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ts.dao.makeappointmentDAO;
import com.ts.dto.makeappointmentDTO;


@WebServlet("/makeappointmentServlet")
public class makeappointmentServlet extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String gnd=request.getParameter("gnd");
		int age=Integer.parseInt(request.getParameter("age"));
		String date=request.getParameter("date");
		String time=request.getParameter("time");
		String dname=request.getParameter("dname");
		String hname=request.getParameter("hname");
		makeappointmentDTO user=new makeappointmentDTO();
		user.setname(name);
		user.setgnd(gnd);
		user.setage(age);
		user.setdate(date);
		user.settime(time);
		user.setdname(dname);
		user.sethname(hname);
		System.out.println(user);
		
		makeappointmentDAO userDao = new makeappointmentDAO();
		if(makeappointmentDAO.add(user)!=0){
			response.getWriter().println("<html><body onload=\"alert('Appointment Booked Successfully')\"></body></html>");
			RequestDispatcher dispatcher=request.getRequestDispatcher("utype3.html");
			dispatcher.include(request, response);
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}
}