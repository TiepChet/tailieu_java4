package com.example.LuyenTapJava4.controller;


import com.example.LuyenTapJava4.entity.ThucVat;
import com.example.LuyenTapJava4.service.ThucVatService;
import com.example.LuyenTapJava4.service.impl.ThucVatServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "ThucVatServlet", value = {
        "/thuc-vat/hien-thi",
        "/thuc-vat/add",
        "/thuc-vat/update",
        "/thuc-vat/detail",
        "/thuc-vat/delete",
        "/thuc-vat/search",
        "/thuc-vat/sort",
        "/thuc-vat/view-add",
        "/thuc-vat/view-update",

})
public class ThucVatServlet extends HttpServlet {

    private ThucVatService thucVatService = new ThucVatServiceImpl();
    private List<ThucVat> listThucVat = new ArrayList<>();
    private UUID ma;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThi(request, response);
        } else if (uri.contains("detail")) {
            this.detail(request, response);
        } else if (uri.contains("delete")) {
            this.delete(request, response);
        } else if (uri.contains("search")) {
            this.search(request, response);
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
        } else {
            this.hienThi(request, response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ThucVat tv = thucVatService.getOne(ma);
        tv.setTen(request.getParameter("ten"));
        tv.setTuoi(Integer.valueOf(request.getParameter("tuoi")));
        tv.setGioiTinh(Boolean.valueOf(request.getParameter("gioiTinh")));
        tv.setKhuVucSong(request.getParameter("khuVucSong"));
        tv.setLoai(request.getParameter("loai"));
        request.setAttribute("mess",thucVatService.update(tv));
        listThucVat = thucVatService.getAll();
        request.setAttribute("listTV", listThucVat);
        request.getRequestDispatcher("/thucvat/trang-chu.jsp").forward(request, response);
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ThucVat tv = ThucVat.builder()
                .ten(request.getParameter("ten"))
                .tuoi(parseInteger(request.getParameter("tuoi")))
                .gioiTinh(Boolean.valueOf(request.getParameter("gioiTinh")))
                .khuVucSong(request.getParameter("khuVucSong"))
                .loai(request.getParameter("loai"))
                .build();
        request.setAttribute("mess",thucVatService.add(tv));
        listThucVat = thucVatService.getAll();
        request.setAttribute("listTV", listThucVat);
        request.getRequestDispatcher("/thucvat/trang-chu.jsp").forward(request, response);
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ma = UUID.fromString(request.getParameter("ma"));
        ThucVat tv = thucVatService.getOne(ma);
        request.setAttribute("tv",tv);
        listThucVat = thucVatService.getAll();
        request.setAttribute("listTV", listThucVat);
        request.getRequestDispatcher("/thucvat/update.jsp").forward(request, response);
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/thucvat/add.jsp").forward(request,response);
    }

    private void sort(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sapXep = request.getParameter("sapXep");
        if(sapXep.contains("tuoi")){
            listThucVat = thucVatService.sortTuoi();
            request.setAttribute("listTV", listThucVat);
            request.getRequestDispatcher("/thucvat/trang-chu.jsp").forward(request, response);
        }else{
            listThucVat = thucVatService.sortTen();
            request.setAttribute("listTV", listThucVat);
            request.getRequestDispatcher("/thucvat/trang-chu.jsp").forward(request, response);
        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ten = request.getParameter("ten");
        listThucVat = thucVatService.search(ten);
        request.setAttribute("listTV", listThucVat);
        request.getRequestDispatcher("/thucvat/trang-chu.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ma = UUID.fromString(request.getParameter("ma"));
        ThucVat tv = thucVatService.getOne(ma);
        request.setAttribute("mess",thucVatService.delete(tv));
        listThucVat = thucVatService.getAll();
        request.setAttribute("listTV", listThucVat);
        request.getRequestDispatcher("/thucvat/trang-chu.jsp").forward(request, response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ma = UUID.fromString(request.getParameter("ma"));
        ThucVat tv = thucVatService.getOne(ma);
        request.setAttribute("tv",tv);
        listThucVat = thucVatService.getAll();
        request.setAttribute("listTV", listThucVat);
        request.getRequestDispatcher("/thucvat/detail.jsp").forward(request, response);
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listThucVat = thucVatService.getAll();
        request.setAttribute("listTV", listThucVat);
        request.getRequestDispatcher("/thucvat/trang-chu.jsp").forward(request, response);
    }


    private int parseInteger(String number){
        if (number != null && number.length() > 0) {
            try {
                return Integer.parseInt(number);
            } catch(Exception e) {
                return -1;
            }
        }
        else return 0;
    }



}
