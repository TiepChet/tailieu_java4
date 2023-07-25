package com.example.LuyenTapBuoi7.controller;


import com.example.LuyenTapBuoi7.entity.KhachHang;
import com.example.LuyenTapBuoi7.service.KhachHangService;
import com.example.LuyenTapBuoi7.service.impl.KhachHangServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@WebServlet(name = "KhachHangServlet", value = {
        "/khach-hang/view-all",
        "/khach-hang/hien-thi",
        "/khach-hang/add",
        "/khach-hang/update",
        "/khach-hang/detail",
        "/khach-hang/delete",
        "/khach-hang/view-add",
        "/khach-hang/view-update",

})
public class KhachHangServlet extends HttpServlet {
    private KhachHangService khachHangService = new KhachHangServiceImpl();
    private List<KhachHang> listKhachHang = new ArrayList<>();
    private String id;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("view-all")) {
            this.viewAll(request, response);
        } else if (uri.contains("hien-thi")) {
            this.hienThi(request, response);
        } else if (uri.contains("detail")) {
            this.detail(request, response);
        } else if (uri.contains("delete")) {
            this.delete(request, response);
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
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        KhachHang kh = khachHangService.getOne(UUID.fromString(id));
        kh.setMa(request.getParameter("ma"));
        kh.setTen(request.getParameter("ten"));
        kh.setHo(request.getParameter("ho"));
        kh.setTenDem(request.getParameter("tenDem"));
        kh.setSdt(request.getParameter("sdt"));
        kh.setDiaChi(request.getParameter("diaChi"));
        request.setAttribute("mess",khachHangService.update(kh));
        listKhachHang = khachHangService.getAll();
        request.setAttribute("listKH",listKhachHang);
        request.getRequestDispatcher("/khachhang/trang-chu.jsp").forward(request,response);
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Random rd = new Random();
        String maKH = "KH"+ rd.nextInt(999);
        KhachHang kh = KhachHang.builder()
                .ma(maKH)
                .ten(request.getParameter("ten"))
                .ho(request.getParameter("ho"))
                .tenDem(request.getParameter("tenDem"))
                .sdt(request.getParameter("sdt"))
                .diaChi(request.getParameter("diaChi"))
                .build();
        request.setAttribute("mess",khachHangService.add(kh));
        listKhachHang = khachHangService.getAll();
        request.setAttribute("listKH",listKhachHang);
        request.getRequestDispatcher("/khachhang/trang-chu.jsp").forward(request,response);
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        id = request.getParameter("id");
        KhachHang kh = khachHangService.getOne(UUID.fromString(id));
        request.setAttribute("kh",kh);
        listKhachHang = khachHangService.getAll();
        request.setAttribute("listKH",listKhachHang);
        request.getRequestDispatcher("/khachhang/update.jsp").forward(request,response);

    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) {
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        id = request.getParameter("id");
        KhachHang kh = khachHangService.getOne(UUID.fromString(id));
        request.setAttribute("mess",khachHangService.delete(kh));
        listKhachHang = khachHangService.getAll();
        request.setAttribute("listKH",listKhachHang);
        request.getRequestDispatcher("/khachhang/trang-chu.jsp").forward(request,response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        id = request.getParameter("id");
        KhachHang kh = khachHangService.getOne(UUID.fromString(id));
        request.setAttribute("kh",kh);
        listKhachHang = khachHangService.getAll();
        request.setAttribute("listKH",listKhachHang);
        request.getRequestDispatcher("/khachhang/trang-chu.jsp").forward(request,response);
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listKhachHang = khachHangService.getAll();
        request.setAttribute("listKH",listKhachHang);
        request.getRequestDispatcher("/khachhang/trang-chu.jsp").forward(request,response);


    }

    private void viewAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/khachhang/trang-chu.jsp").forward(request,response);
    }

}
