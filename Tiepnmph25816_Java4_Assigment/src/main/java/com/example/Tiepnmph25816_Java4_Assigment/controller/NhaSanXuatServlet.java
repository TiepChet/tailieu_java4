package com.example.Tiepnmph25816_Java4_Assigment.controller;

import com.example.Tiepnmph25816_Java4_Assigment.entity.NhaSanXuat;
import com.example.Tiepnmph25816_Java4_Assigment.service.NhaSanXuatService;
import com.example.Tiepnmph25816_Java4_Assigment.service.impl.NhaSanXuatServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "NhaSanXuatServlet", value = {
        "/nsx/hien-thi",
        "/nsx/add",
        "/nsx/update",
        "/nsx/delete",
        "/nsx/detail",
        "/nsx/view-add",
        "/nsx/view-update",
})
public class NhaSanXuatServlet extends HttpServlet {

    private NhaSanXuatService nhaSanXuatService = new NhaSanXuatServiceImpl();
    private List<NhaSanXuat> lisNSX = new ArrayList<>();
    private String id;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
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
        }else{
            this.hienThi(request,response);
        }
    }


    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NhaSanXuat nsx = nhaSanXuatService.getOne(UUID.fromString(id));
        nsx.setMa(request.getParameter("ma"));
        nsx.setTen(request.getParameter("ten"));
        request.setAttribute("mess",nhaSanXuatService.update(nsx));
        lisNSX = nhaSanXuatService.getAll();
        request.setAttribute("listNSX",lisNSX);
        request.getRequestDispatcher("/nsx/trang-chu.jsp").forward(request,response);
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        NhaSanXuat nsx = NhaSanXuat.builder()
                .ma(request.getParameter("ma"))
                .ten(request.getParameter("ten"))
                .build();
        request.setAttribute("mess",nhaSanXuatService.add(nsx));
        lisNSX = nhaSanXuatService.getAll();
        request.setAttribute("listNSX",lisNSX);
        request.getRequestDispatcher("/nsx/trang-chu.jsp").forward(request,response);
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         id = request.getParameter("id");
        NhaSanXuat nsx = nhaSanXuatService.getOne(UUID.fromString(id));
        request.setAttribute("nsx",nsx);
        lisNSX = nhaSanXuatService.getAll();
        request.setAttribute("listNSX",lisNSX);
        request.getRequestDispatcher("/nsx/update.jsp").forward(request,response);
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/nsx/add.jsp").forward(request,response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         id = request.getParameter("id");
        NhaSanXuat nsx = nhaSanXuatService.getOne(UUID.fromString(id));
        request.setAttribute("mess",nhaSanXuatService.delete(nsx));
        lisNSX = nhaSanXuatService.getAll();
        request.setAttribute("listNSX",lisNSX);
        request.getRequestDispatcher("/nsx/trang-chu.jsp").forward(request,response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         id = request.getParameter("id");
        NhaSanXuat nsx = nhaSanXuatService.getOne(UUID.fromString(id));
        request.setAttribute("nsx",nsx);
        lisNSX = nhaSanXuatService.getAll();
        request.setAttribute("listNSX",lisNSX);
        request.getRequestDispatcher("/nsx/detail.jsp").forward(request,response);
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        lisNSX = nhaSanXuatService.getAll();
        request.setAttribute("listNSX",lisNSX);
        request.getRequestDispatcher("/nsx/trang-chu.jsp").forward(request,response);
    }
}
