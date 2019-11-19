package com.action;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class cloudLogin extends HttpServlet { 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {

            String name = request.getParameter("name_");
            String pass = request.getParameter("password");

            if ((name.equals("cloud")) && (pass.equals("cloud"))) {
                HttpSession session = request.getSession();
                session.setAttribute("userid", request.getParameter("name_"));
                System.out.println(">>>>>>>" + session.getAttribute("userid"));
                response.sendRedirect("cloudHome.jsp");
            } else {
                response.sendRedirect("cloudLogin.jsp?msg=Check Userid or Password");
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
