package com.action;

import com.mysql.jdbc.PreparedStatement;
import com.util.DbConnector;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DataOwnerReg extends HttpServlet {  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        PreparedStatement pst = null;
        Connection conn = null;
        try {
            conn = (Connection) DbConnector.getConnection();
            String name = request.getParameter("_name").trim();
            String password = request.getParameter("_password").trim();
            String age = request.getParameter("_age").trim();
            String emailid = request.getParameter("_emailid").trim();
            String phone = request.getParameter("_phone").trim();
            String location = request.getParameter("add");
            String role = request.getParameter("role");
            if (name != null && name != "" && password != null && password != "" && age != null && age != "" && emailid != null && emailid != "" && phone != "" && phone != null && location != "" && location != null) {
                String sql = "insert into user values('" + name + "','" + password + "','" + location + "','" + age + "','" + emailid + "',now(),'" + phone + "','downer')";
                System.out.println(">>" + sql);
                pst = (PreparedStatement) conn.prepareStatement(sql);
                int a = pst.executeUpdate();
                if (a > 0) {
                    response.sendRedirect("index.jsp?msg=Owner_Registration_Done");
                } else {
                    response.sendRedirect("index.jsp?msg=UserId Already Exit");
                }
            } else {
                response.sendRedirect("index.jsp?msg=Fill All The Fileds");
            }
        } catch (Exception e) {
            response.sendRedirect("index.jsp?msg=UserId Already Exit");
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
