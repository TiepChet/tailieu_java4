package com.example.Java4_Buoi12.controller;


import com.example.Java4_Buoi12.entity.MayTinh;
import com.example.Java4_Buoi12.service.MayTinhService;
import com.example.Java4_Buoi12.service.impl.MayTinhServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "MayTinhServlet", value = {
        "/may-tinh/hien-thi",
        "/may-tinh/add",
        "/may-tinh/update",
        "/may-tinh/delete",
        "/may-tinh/detail",
        "/may-tinh/sort",
        "/may-tinh/view-add",
        "/may-tinh/view-update",
})
public class MayTinhServlet extends HttpServlet {
    private MayTinhService mayTinhService = new MayTinhServiceImpl();
    private List<MayTinh> listMayTinh = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThi(request, response);
        } else if (uri.contains("delete")) {
            this.delete(request, response);
        } else if (uri.contains("detail")) {
            this.detail(request, response);
        } else if (uri.contains("sort")) {
            this.sort(request, response);
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
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String gia = request.getParameter("gia");
        String boNho = request.getParameter("boNho");
        String mauSac = request.getParameter("mauSac");
        String hang = request.getParameter("hang");
        String mieuTa = request.getParameter("mieuTa");

        MayTinh mt = MayTinh.builder()
                .ma(UUID.fromString(ma))
                .ten(ten)
                .gia(Float.valueOf(gia))
                .boNho(boNho)
                .mauSac(mauSac)
                .hang(hang)
                .mieuTa(mieuTa)
                .build();
        request.setAttribute("mess", mayTinhService.update(mt));
        listMayTinh = mayTinhService.getAll();
        request.setAttribute("listMT", listMayTinh);
        request.getRequestDispatcher("/maytinh/trang-chu.jsp").forward(request, response);
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ten = request.getParameter("ten");
        String gia = request.getParameter("gia");
        String boNho = request.getParameter("boNho");
        String mauSac = request.getParameter("mauSac");
        String hang = request.getParameter("hang");
        String mieuTa = request.getParameter("mieuTa");

        MayTinh mt = MayTinh.builder()
                .ten(ten)
                .gia(Float.valueOf(gia))
                .boNho(boNho)
                .mauSac(mauSac)
                .hang(hang)
                .mieuTa(mieuTa)
                .build();
        request.setAttribute("mess", mayTinhService.add(mt));
        listMayTinh = mayTinhService.getAll();
        request.setAttribute("listMT", listMayTinh);
        request.getRequestDispatcher("/maytinh/trang-chu.jsp").forward(request, response);
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        MayTinh mt = mayTinhService.getOne(UUID.fromString(ma));
        request.setAttribute("mt", mt);
        listMayTinh = mayTinhService.getAll();
        request.setAttribute("listMT", listMayTinh);
        request.getRequestDispatcher("/maytinh/update.jsp").forward(request, response);
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/maytinh/add.jsp").forward(request, response);
    }

    private void sort(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String sapXep = request.getParameter("sort");
        if(sapXep.equals("gia")){
            listMayTinh = mayTinhService.sortGia();
            request.setAttribute("listMT", listMayTinh);
            request.getRequestDispatcher("/maytinh/trang-chu.jsp").forward(request, response);
        }else{
            listMayTinh = mayTinhService.sortBoNho();
            request.setAttribute("listMT", listMayTinh);
            request.getRequestDispatcher("/maytinh/trang-chu.jsp").forward(request, response);
        }

    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        MayTinh mt = mayTinhService.getOne(UUID.fromString(ma));
        request.setAttribute("mt", mt);
        listMayTinh = mayTinhService.getAll();
        request.setAttribute("listMT", listMayTinh);
        request.getRequestDispatcher("/maytinh/detail.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        MayTinh mt = mayTinhService.getOne(UUID.fromString(ma));
        request.setAttribute("mess", mayTinhService.delete(mt));
        listMayTinh = mayTinhService.getAll();
        request.setAttribute("listMT", listMayTinh);
        request.getRequestDispatcher("/maytinh/trang-chu.jsp").forward(request, response);
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listMayTinh = mayTinhService.getAll();
        request.setAttribute("listMT", listMayTinh);
        request.getRequestDispatcher("/maytinh/trang-chu.jsp").forward(request, response);
    }
}
