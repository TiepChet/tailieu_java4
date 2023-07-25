package com.example.Java4_Buoi4.crude.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DangXuatServlet", value = "/dang-xuat")
public class DangXuatServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Xoa sesstion
        HttpSession session = request.getSession();
        //Cpo 2 cach
        // C1 Xoa tat ca
//        session.invalidate();
        //C2  Xoa 1 session nao do
        session.removeAttribute("name");
        response.sendRedirect("/login");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
