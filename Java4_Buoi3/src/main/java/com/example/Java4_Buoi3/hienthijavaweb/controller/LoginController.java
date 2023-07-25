package com.example.Java4_Buoi3.hienthijavaweb.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login/form-login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("uname");
        String pass = request.getParameter("psw");
        if (user.isEmpty() || pass.isEmpty()) {
            request.setAttribute("error", "trong");
            request.getRequestDispatcher("/login/form-login.jsp").forward(request, response);
        }else{
            response.sendRedirect("/giang-vien/hien-thi");
        }
    }
}
