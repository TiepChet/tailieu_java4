package com.example.Java4_Buoi9.crud.controller;


import com.example.Java4_Buoi9.crud.entity.GiangVien;
import com.example.Java4_Buoi9.crud.service.GiangVienService;
import com.example.Java4_Buoi9.crud.service.impl.GiangVienServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "GiangVienServlet", value = {
        "/giang-vien/hien-thi-tat-ca",
        "/giang-vien/search",
        "/giang-vien/giang-vien-nu",
        "/giang-vien/sort",
        "/giang-vien/delete",
        "/giang-vien/detail",
        "/giang-vien/update",
        "/giang-vien/add",
        "/giang-vien/view-update",
        "/giang-vien/view-add",
})
public class GiangVienServlet extends HttpServlet {
    private GiangVienService giangVienService = new GiangVienServiceImpl();
    private List<GiangVien> listGiangVien = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi-tat-ca")) {
            this.hienThiTatCa(request, response);
        } else if (uri.contains("search")) {
            this.search(request, response);
        } else if (uri.contains("giang-vien-nu")) {
            this.giangVienNu(request, response);
        } else if (uri.contains("sort")) {
            this.sort(request, response);
        } else if (uri.contains("delete")) {
            this.delete(request, response);
        } else if (uri.contains("detail")) {
            this.detail(request, response);
        } else if (uri.contains("view-add")) {
            this.viewAdd(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdate(request, response);
        } else {
            this.hienThiTatCa(request, response);
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

        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String tuoi = request.getParameter("tuoi");
        String gioiTinh = request.getParameter("gioiTinh");
        String diaChi = request.getParameter("diaChi");
        GiangVien gv = GiangVien.builder()
                .id(Long.valueOf(id))
                .ma(ma)
                .ten(ten)
                .tuoi(Long.valueOf(tuoi))
                .gioiTinh(Boolean.valueOf(gioiTinh))
                .diaChi(diaChi)
                .build();
        request.setAttribute("error",giangVienService.update(gv));
        listGiangVien = giangVienService.getAll();
        request.setAttribute("listGV", listGiangVien);
        request.getRequestDispatcher("/giangvien/trang-chu.jsp").forward(request, response);
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String tuoi = request.getParameter("tuoi");
        String gioiTinh = request.getParameter("gioiTinh");
        String diaChi = request.getParameter("diaChi");
        GiangVien gv = GiangVien.builder()
                .ma(ma)
                .ten(ten)
                .tuoi(Long.valueOf(tuoi))
                .gioiTinh(Boolean.valueOf(gioiTinh))
                .diaChi(diaChi)
                .build();

        request.setAttribute("error",giangVienService.add(gv));
        listGiangVien = giangVienService.getAll();
        request.setAttribute("listGV", listGiangVien);
        request.getRequestDispatcher("/giangvien/trang-chu.jsp").forward(request, response);
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        GiangVien gv = giangVienService.getOne(Long.valueOf(id));
        request.setAttribute("gv", gv);
        request.getRequestDispatcher("/giangvien/update.jsp").forward(request, response);
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/giangvien/add.jsp").forward(request, response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        GiangVien gv = giangVienService.getOne(Long.valueOf(id));
        request.setAttribute("gv", gv);
        request.getRequestDispatcher("/giangvien/detail.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id= request.getParameter("id");
        GiangVien gv = giangVienService.getOne(Long.valueOf(id));
        request.setAttribute("error",giangVienService.delete(gv));
        listGiangVien = giangVienService.getAll();
        request.setAttribute("listGV", listGiangVien);
        request.getRequestDispatcher("/giangvien/trang-chu.jsp").forward(request, response);

    }

    private void sort(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listGiangVien = giangVienService.sortTuoi();
        request.setAttribute("listGV", listGiangVien);
        request.getRequestDispatcher("/giangvien/trang-chu.jsp").forward(request, response);
    }

    private void giangVienNu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listGiangVien = giangVienService.giangVienNu();
        request.setAttribute("listGV", listGiangVien);
        request.getRequestDispatcher("/giangvien/trang-chu.jsp").forward(request, response);
    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ten = request.getParameter("ten");
        listGiangVien = giangVienService.search(ten);
        request.setAttribute("listGV", listGiangVien);
        request.getRequestDispatcher("/giangvien/trang-chu.jsp").forward(request, response);
    }

    private void hienThiTatCa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (listGiangVien.isEmpty()) {
            listGiangVien = giangVienService.getAll();
        }
        request.setAttribute("listGV", listGiangVien);
        request.getRequestDispatcher("/giangvien/trang-chu.jsp").forward(request, response);
    }
}