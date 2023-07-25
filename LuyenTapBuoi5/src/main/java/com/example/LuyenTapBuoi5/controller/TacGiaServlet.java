package com.example.LuyenTapBuoi5.controller;


import com.example.LuyenTapBuoi5.entity.TacGia;
import com.example.LuyenTapBuoi5.service.TacGiaService;
import com.example.LuyenTapBuoi5.service.impl.TacGiaServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "TacGiaServlet", value = {
        "/tac-gia/hien-thi",
        "/tac-gia/add",
        "/tac-gia/update",
        "/tac-gia/delete",
        "/tac-gia/detail",
        "/tac-gia/sort",
        "/tac-gia/search",
        "/tac-gia/view-add",
        "/tac-gia/view-update",

})
public class TacGiaServlet extends HttpServlet {
    private TacGiaService tacGiaService = new TacGiaServiceImpl();
    private List<TacGia> listTacGia = new ArrayList<>();
    private String ma;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThiTatCa(request, response);
        } else if (uri.contains("delete")) {
            this.delete(request, response);
        } else if (uri.contains("detail")) {
            this.detail(request, response);
        } else if (uri.contains("sort")) {
            this.sort(request, response);
        } else if (uri.contains("search")) {
            this.search(request, response);
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
            this.hienThiTatCa(request, response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TacGia tg = tacGiaService.getOne(UUID.fromString(ma));
        tg.setTen(request.getParameter("ten"));
        tg.setTuoi(Integer.valueOf(request.getParameter("tuoi")));
        tg.setGioiTinh(Boolean.valueOf(request.getParameter("gioiTinh")));
        tg.setLoaiSachViet(request.getParameter("loaiSachViet"));
        request.setAttribute("mess", tacGiaService.update(tg));
        listTacGia = tacGiaService.getAll();
        request.setAttribute("listTG", listTacGia);
        request.getRequestDispatcher("/tacgia/trang-chu.jsp").forward(request, response);
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TacGia tg = TacGia.builder()
                .ten(request.getParameter("ten"))
                .tuoi(Integer.valueOf(request.getParameter("tuoi")))
                .gioiTinh(Boolean.valueOf(request.getParameter("gioiTinh")))
                .loaiSachViet((request.getParameter("loaiSachViet")))
                .build();
        request.setAttribute("mess", tacGiaService.add(tg));
        listTacGia = tacGiaService.getAll();
        request.setAttribute("listTG", listTacGia);
        request.getRequestDispatcher("/tacgia/trang-chu.jsp").forward(request, response);
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ma = request.getParameter("ma");
        TacGia tg = tacGiaService.getOne(UUID.fromString(ma));
        request.setAttribute("tg", tg);
        listTacGia = tacGiaService.getAll();
        request.setAttribute("listTG", listTacGia);
        request.getRequestDispatcher("/tacgia/update.jsp").forward(request, response);
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) {
    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ten = request.getParameter("ten");
        listTacGia = tacGiaService.searchTen(ten);
        request.setAttribute("listTG", listTacGia);
        request.getRequestDispatcher("/tacgia/trang-chu.jsp").forward(request, response);
    }

    private void sort(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sort  = request.getParameter("sapXep");
        if(sort.contains("tuoi")){
            listTacGia = tacGiaService.sortTuoi();
            request.setAttribute("listTG", listTacGia);
            request.getRequestDispatcher("/tacgia/trang-chu.jsp").forward(request, response);
        }else{
            listTacGia = tacGiaService.sortTen();
            request.setAttribute("listTG", listTacGia);
            request.getRequestDispatcher("/tacgia/trang-chu.jsp").forward(request, response);
        }
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ma = request.getParameter("ma");
        TacGia tg = tacGiaService.getOne(UUID.fromString(ma));
        request.setAttribute("tg", tg);
        listTacGia = tacGiaService.getAll();
        request.setAttribute("listTG", listTacGia);
        request.getRequestDispatcher("/tacgia/trang-chu.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ma = request.getParameter("ma");
        TacGia tg = tacGiaService.getOne(UUID.fromString(ma));
        request.setAttribute("mess", tacGiaService.delete(tg));
        listTacGia = tacGiaService.getAll();
        request.setAttribute("listTG", listTacGia);
        request.getRequestDispatcher("/tacgia/trang-chu.jsp").forward(request, response);
    }

    private void hienThiTatCa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listTacGia = tacGiaService.getAll();
        request.setAttribute("listTG", listTacGia);
        request.getRequestDispatcher("/tacgia/trang-chu.jsp").forward(request, response);
    }
}
