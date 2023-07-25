package com.example.Java4_Buoi2.javawebb2.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoginBuoi14", value = {

})
public class LoginBuoi14 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/dang-nhap-buoi14.jsp").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        String user = request.getParameter("uname");
        String pass = request.getParameter("psw");

        request.setAttribute("username", user);
        request.setAttribute("password", pass);

        if (user.isEmpty() || pass.isEmpty()) {
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("username",user);
            request.setAttribute("error", "isEmpty user and pass");
            request.getRequestDispatcher("/form-login.jsp").forward(request, response);
        } else if (user.equals("hangnt169") && pass.equals("12345")) {
            request.getRequestDispatcher("/ket-qua.jsp").forward(request, response);
        } else {
            request.setAttribute("error", "error user and pass");
            request.getRequestDispatcher("/form-login.jsp").forward(request, response);
        }
    }
}
