package com.example.Java4_Buoi3.hienthijavaweb.controller;

import com.example.Java4_Buoi3.hienthijavaweb.entity.GiangVien;
import com.example.Java4_Buoi3.hienthijavaweb.service.GiangVienService;
import com.example.Java4_Buoi3.hienthijavaweb.service.impl.GiangVienServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "HienThiController", value = {
        "/giang-vien/hien-thi",
})
public class HienThiController extends HttpServlet {

    private GiangVienService giangVienService = new GiangVienServiceImpl();
    private List<GiangVien> giangViens = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThiGiangVien(request, response);
        } else {
            this.hienThiGiangVien(request, response);
        }
    }

    private void hienThiGiangVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        giangViens.add(new GiangVien(1, "a", "Nguyen Van A", 20, true, "Ha Noi"));
        giangViens.add(new GiangVien(2, "b", "Nguyen Van B", 20, false, "Ha Noi"));
        giangViens.add(new GiangVien(3, "c", "Nguyen Van C", 20, true, "Ha Noi"));
        giangViens.add(new GiangVien(4, "d", "Nguyen Van D", 20, false, "Ha Noi"));
        request.setAttribute("listGiangVien", giangViens);
        request.getRequestDispatcher("/hienthi/trang-chu.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
