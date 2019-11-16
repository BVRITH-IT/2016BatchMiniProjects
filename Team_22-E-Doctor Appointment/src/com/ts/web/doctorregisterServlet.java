package com.ts.web;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ts.dao.doctorregisterDAO;
import com.ts.dto.doctorregisterDTO;


@WebServlet("/doctorregisterServlet")
public class doctorregisterServlet extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String dname=request.getParameter("dname");
		String start=request.getParameter("start");
		String end=request.getParameter("end");
		String qual=request.getParameter("qual");
		String hosp=request.getParameter("hosp");
		String email=request.getParameter("email");
		doctorregisterDTO user=new doctorregisterDTO();
		user.setdname(dname);
		user.setstart(start);
		user.setend(end);
		user.setqual(qual);
		user.sethosp(hosp);
		user.setemail(email);
		System.out.println(user);
		
		doctorregisterDAO userDao = new doctorregisterDAO();
		if(doctorregisterDAO.add(user)!=0){
			response.getWriter().println("<h1 style=color:green;>Doctor registered Successfully</h1>");
			RequestDispatcher dispatcher=request.getRequestDispatcher("utype1.html");
			dispatcher.include(request, response);
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}
}