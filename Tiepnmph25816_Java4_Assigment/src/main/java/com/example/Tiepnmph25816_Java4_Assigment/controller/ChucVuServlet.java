package com.example.Tiepnmph25816_Java4_Assigment.controller;


import com.example.Tiepnmph25816_Java4_Assigment.entity.ChucVu;
import com.example.Tiepnmph25816_Java4_Assigment.service.ChucVuService;
import com.example.Tiepnmph25816_Java4_Assigment.service.impl.ChucVuServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "ChucVuServlet", value = {
        "/chuc-vu/hien-thi",
        "/chuc-vu/add",
        "/chuc-vu/update",
        "/chuc-vu/delete",
        "/chuc-vu/detail",
        "/chuc-vu/view-add",
        "/chuc-vu/view-update",

})
public class ChucVuServlet extends HttpServlet {
    private ChucVuService chucVuService = new ChucVuServiceImpl();
    private List<ChucVu> listChucVu = new ArrayList<>();
    private String id;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThi(request, response);
        } else if (uri.contains("view-add")) {
            this.viewAdd(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdate(request, response);
        } else if (uri.contains("detail")) {
            this.detail(request, response);
        } else if (uri.contains("delete")) {
            this.delete(request, response);
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
        ChucVu cv = chucVuService.getOne(UUID.fromString(id));
        cv.setMa(request.getParameter("ma"));
        cv.setTen(request.getParameter("ten"));
        request.setAttribute("mess",chucVuService.update(cv));
        listChucVu = chucVuService.getAll();
        request.setAttribute("listCV", listChucVu);
        request.getRequestDispatcher("/chucvu/trang-chu.jsp").forward(request, response);
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ChucVu cv = ChucVu.builder()
                .ma(request.getParameter("ma"))
                .ten(request.getParameter("ten"))
                .build();
        request.setAttribute("mess",chucVuService.add(cv));
        listChucVu = chucVuService.getAll();
        request.setAttribute("listCV", listChucVu);
        request.getRequestDispatcher("/chucvu/trang-chu.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        id = request.getParameter("id");
        ChucVu cv = chucVuService.getOne(UUID.fromString(id));
        request.setAttribute("mess", chucVuService.delete(cv));
        listChucVu = chucVuService.getAll();
        request.setAttribute("listCV", listChucVu);
        request.getRequestDispatcher("/chucvu/trang-chu.jsp").forward(request, response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        id = request.getParameter("id");
        ChucVu cv = chucVuService.getOne(UUID.fromString(id));
        request.setAttribute("cv", cv);
        listChucVu = chucVuService.getAll();
        request.setAttribute("listCV", listChucVu);
        request.getRequestDispatcher("/chucvu/detail.jsp").forward(request, response);
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        id = request.getParameter("id");
        ChucVu cv = chucVuService.getOne(UUID.fromString(id));
        request.setAttribute("cv", cv);
        listChucVu = chucVuService.getAll();
        request.setAttribute("listCV", listChucVu);
        request.getRequestDispatcher("/chucvu/update.jsp").forward(request, response);
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/chucvu/add.jsp").forward(request,response);
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listChucVu = chucVuService.getAll();
        request.setAttribute("listCV", listChucVu);
        request.getRequestDispatcher("/chucvu/trang-chu.jsp").forward(request, response);
    }


}
