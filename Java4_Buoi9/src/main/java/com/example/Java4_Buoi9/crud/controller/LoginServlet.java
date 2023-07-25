package com.example.Java4_Buoi9.crud.controller;

import com.example.Java4_Buoi9.crud.entity.Login;
import com.example.Java4_Buoi9.crud.service.LoginService;
import com.example.Java4_Buoi9.crud.service.impl.LoginServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "LoginServlet", value = {
        "/login/hien-thi"
})
public class LoginServlet extends HttpServlet {
    private LoginService loginService = new LoginServiceImpl();
    private List<Login> logins = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login/form-login.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Login tk = loginService.getOne(username, password);
        if (username.isEmpty() || password.isEmpty()) {
            request.setAttribute("error", "nhap day du thong tin");
            request.getRequestDispatcher("/login/form-login.jsp").forward(request, response);
        } else if (username.equalsIgnoreCase(tk.getUsername()) && password.equalsIgnoreCase(tk.getPassword())) {
            response.sendRedirect("/giang-vien/hien-thi-tat-ca");
        }
    }
}
