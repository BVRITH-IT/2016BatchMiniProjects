package com.action;

import com.util.LoginProcessor;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OwnerLogin extends HttpServlet {
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            if (LoginProcessor.getUserDetailsClient(request.getParameter("name_"), request.getParameter("password"), "downer")) {
                HttpSession session = request.getSession();
                session.setAttribute("userid", request.getParameter("name_"));
                System.out.println(">>>>>>>" + session.getAttribute("userid"));
                response.sendRedirect("dataOwnerHome.jsp");
            } else {
                response.sendRedirect("ownerLogin.jsp?msg=Check Userid or Password");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
