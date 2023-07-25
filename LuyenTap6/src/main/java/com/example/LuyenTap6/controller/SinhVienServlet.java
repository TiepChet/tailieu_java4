package com.example.LuyenTap6.controller;


import com.example.LuyenTap6.entity.SinhVien;
import com.example.LuyenTap6.service.SinhVienService;
import com.example.LuyenTap6.service.impl.SinhVienServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "SinhVienServlet", value = {
        "/sinh-vien/hien-thi",
        "/sinh-vien/add",
        "/sinh-vien/update",
        "/sinh-vien/detail",
        "/sinh-vien/delete",
        "/sinh-vien/giang-vien-nu",
        "/sinh-vien/sort",
        "/sinh-vien/search",
        "/sinh-vien/view-add",
        "/sinh-vien/view-update",

})
public class SinhVienServlet extends HttpServlet {
    private SinhVienService sinhVienService = new SinhVienServiceImpl();
    private List<SinhVien> listSinhVien = new ArrayList<>();
    private String ma;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThi(request, response);
        } else if (uri.contains("detail")) {
            this.detail(request, response);
        } else if (uri.contains("delete")) {
            this.delete(request, response);
        } else if (uri.contains("giang-vien-nu")) {
            this.giangVienNu(request, response);
        } else if (uri.contains("sort")) {
            this.sort(request, response);
        } else if (uri.contains("search")) {
            this.search(request, response);
        } else if (uri.contains("view-add")) {
            this.viewAdd(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdate(request, response);
        } else {
            this.hienThi(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            this.add(request, response);
        } else if (uri.contains("update")) {
            this.update(request, response);
        } else {
            this.hienThi(request, response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SinhVien sv = sinhVienService.getOne(UUID.fromString(ma));
        sv.setTen(request.getParameter("ten"));
        sv.setTuoi(Integer.valueOf(request.getParameter("tuoi")));
        sv.setGioiTinh(Boolean.valueOf(request.getParameter("gioiTinh")));
        sv.setDiaChi(request.getParameter("diaChi"));
        sv.setKyHoc(Integer.valueOf(request.getParameter("kyHoc")));
        request.setAttribute("mess",sinhVienService.update(sv));
        listSinhVien = sinhVienService.getAll();
        request.setAttribute("listSV", listSinhVien);
        request.getRequestDispatcher("/sinhvien/trang-chu.jsp").forward(request, response);
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SinhVien sv = SinhVien.builder()
                .ten(request.getParameter("ten"))
                .tuoi(Integer.valueOf(request.getParameter("tuoi")))
                .gioiTinh(Boolean.valueOf(request.getParameter("gioiTinh")))
                .diaChi(request.getParameter("diaChi"))
                .kyHoc(Integer.valueOf(request.getParameter("kyHoc")))
                .build();
        request.setAttribute("mess", sinhVienService.add(sv));
        listSinhVien = sinhVienService.getAll();
        request.setAttribute("listSV", listSinhVien);
        request.getRequestDispatcher("/sinhvien/trang-chu.jsp").forward(request, response);
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ma = request.getParameter("ma");
        SinhVien sv = sinhVienService.getOne(UUID.fromString(ma));
        request.setAttribute("sv", sv);
        listSinhVien = sinhVienService.getAll();
        request.setAttribute("listSV", listSinhVien);
        request.getRequestDispatcher("/sinhvien/update.jsp").forward(request, response);
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/sinhvien/add.jsp").forward(request, response);
    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ten = request.getParameter("ten");
        listSinhVien = sinhVienService.searchTen(ten);
        request.setAttribute("listSV", listSinhVien);
        request.getRequestDispatcher("/sinhvien/trang-chu.jsp").forward(request, response);
    }

    private void sort(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sapXep = request.getParameter("sapXep");
        if (sapXep.contains("tuoi")) {
            listSinhVien = sinhVienService.sortTuoi();
            request.setAttribute("listSV", listSinhVien);
            request.getRequestDispatcher("/sinhvien/trang-chu.jsp").forward(request, response);
        } else {
            listSinhVien = sinhVienService.sortTen();
            request.setAttribute("listSV", listSinhVien);
            request.getRequestDispatcher("/sinhvien/trang-chu.jsp").forward(request, response);
        }
    }

    private void giangVienNu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listSinhVien = sinhVienService.sinhVienNu();
        request.setAttribute("listSV", listSinhVien);
        request.getRequestDispatcher("/sinhvien/trang-chu.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ma = request.getParameter("ma");
        SinhVien sv = sinhVienService.getOne(UUID.fromString(ma));
        request.setAttribute("mess", sinhVienService.delete(sv));
        listSinhVien = sinhVienService.getAll();
        request.setAttribute("listSV", listSinhVien);
        request.getRequestDispatcher("/sinhvien/trang-chu.jsp").forward(request, response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ma = request.getParameter("ma");
        SinhVien sv = sinhVienService.getOne(UUID.fromString(ma));
        request.setAttribute("sv", sv);
        listSinhVien = sinhVienService.getAll();
        request.setAttribute("listSV", listSinhVien);
        request.getRequestDispatcher("/sinhvien/trang-chu.jsp").forward(request, response);

    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listSinhVien = sinhVienService.getAll();
        request.setAttribute("listSV", listSinhVien);
        request.getRequestDispatcher("/sinhvien/trang-chu.jsp").forward(request, response);
    }

}
