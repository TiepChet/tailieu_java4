package com.example.Java4_Buoi11.controller;


import com.example.Java4_Buoi11.entity.SanPham;
import com.example.Java4_Buoi11.service.SanPhamService;
import com.example.Java4_Buoi11.service.impl.SanPhamServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SanPhamServlet", value = {
        "/san-pham/hien-thi-tat-ca",
        "/san-pham/add",
        "/san-pham/update",
        "/san-pham/delete",
        "/san-pham/detail",
        "/san-pham/search",
        "/san-pham/view-add",
        "/san-pham/view-update",

})
public class SanPhamServlet extends HttpServlet {

    private SanPhamService sanPhamService = new SanPhamServiceImpl();
    private List<SanPham> listSanPham = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi-tat-ca")) {
            this.hienThi(request, response);
        } else if (uri.contains("search")) {
            this.search(request, response);
        } else if (uri.contains("delete")) {
            this.delete(request, response);
        } else if (uri.contains("detail")) {
            this.detail(request, response);
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
        String id = request.getParameter("id");
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String loai = request.getParameter("loai");
        String gia = request.getParameter("gia");
        SanPham sp = SanPham.builder()
                .id(Long.valueOf(id))
                .ma(ma)
                .ten(ten)
                .loai(loai)
                .gia(Float.valueOf(gia))
                .build();
        request.setAttribute("mess",sanPhamService.update(sp));
        listSanPham = sanPhamService.getAll();
        request.setAttribute("listSP",listSanPham);
        request.getRequestDispatcher("/sanpham/trang-chu.jsp").forward(request,response);
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String loai = request.getParameter("loai");
        String gia = request.getParameter("gia");

        SanPham sp = SanPham.builder()
                .ma(ma)
                .ten(ten)
                .loai(loai)
                .gia(Float.valueOf(gia))
                .build();
        request.setAttribute("mess",sanPhamService.add(sp));
        listSanPham = sanPhamService.getAll();
        request.setAttribute("listSP",listSanPham);
        request.getRequestDispatcher("/sanpham/trang-chu.jsp").forward(request,response);
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        SanPham sp = sanPhamService.getOne(Long.valueOf(id));
        request.setAttribute("sp",sp);
        listSanPham = sanPhamService.getAll();
        request.setAttribute("listSP",listSanPham);
        request.getRequestDispatcher("/sanpham/update.jsp").forward(request,response);

    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) {

    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        SanPham sp = sanPhamService.getOne(Long.valueOf(id));
        request.setAttribute("sp",sp);
        listSanPham = sanPhamService.getAll();
        request.setAttribute("listSP",listSanPham);
        request.getRequestDispatcher("/sanpham/trang-chu.jsp").forward(request,response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        SanPham sp = sanPhamService.getOne(Long.valueOf(id));
        request.setAttribute("mess",sanPhamService.delete(sp));
        listSanPham = sanPhamService.getAll();
        request.setAttribute("listSP",listSanPham);
        request.getRequestDispatcher("/sanpham/trang-chu.jsp").forward(request,response);
    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ten = request.getParameter("ten");
        listSanPham = sanPhamService.search(ten);
        request.setAttribute("listSP",listSanPham);
        request.getRequestDispatcher("/sanpham/trang-chu.jsp").forward(request,response);

    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listSanPham = sanPhamService.getAll();
        request.setAttribute("listSP",listSanPham);
        request.getRequestDispatcher("/sanpham/trang-chu.jsp").forward(request,response);
    }
}
