package com.action;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TrustedLogin extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         try {
            System.out.println(request.getParameter("name_")+"-------"+request.getParameter("password"));
            if ( request.getParameter("name_").equals("admin") && request.getParameter("password").equals("admin") ) {
                response.sendRedirect("domAuthReg.jsp");
            } else {
                response.sendRedirect("trustedAuthLogin.jsp?msg=Check Userid or Password");
            }
        } catch(Exception e){
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
