package com.fpt.poly.lab.controller;


import com.fpt.poly.lab.entity.GiangVien;
import com.fpt.poly.lab.service.GiangVienService;
import com.fpt.poly.lab.service.impl.GiangVienServiceImpl;
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
        "/giang-vien/delete",
        "/giang-vien/detail",
        "/giang-vien/sort",
        "/giang-vien/giang-vien-nu",
        "/giang-vien/view-add",
        "/giang-vien/view-update",
        "/giang-vien/add",
        "/giang-vien/update",
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
        } else if (uri.contains("detail")) {
            this.detail(request, response);
        } else if (uri.contains("delete")) {
            this.delete(request, response);
        } else if (uri.contains("sort")) {
            this.sort(request, response);
        } else if (uri.contains("giang-vien-nu")) {
            this.giangVienNu(request, response);
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
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String tuoi = request.getParameter("tuoi");
        String gioiTinh = request.getParameter("gioiTinh");
        String queQuan = request.getParameter("queQuan");
        GiangVien gv = new GiangVien(ma, ten, Integer.valueOf(tuoi), Boolean.valueOf(gioiTinh), queQuan);
        giangVienService.update(gv);
        listGiangVien = giangVienService.getAll();
        request.setAttribute("listGV", listGiangVien);
        request.getRequestDispatcher("/lab1_4/trang-chu.jsp").forward(request, response);

    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String tuoi = request.getParameter("tuoi");
        String gioiTinh = request.getParameter("gioiTinh");
        String queQuan = request.getParameter("queQuan");
        if (ma.isEmpty() || ten.isEmpty() || tuoi.isEmpty() || queQuan.isEmpty()) {
            request.setAttribute("error", "nhap day du thong tin");
            request.setAttribute("listGV", listGiangVien);
            request.getRequestDispatcher("/lab1_4/trang-chu.jsp").forward(request, response);

        }
        if (!ten.matches("[a-z A-Z]+")) {
            request.setAttribute("error", "ten phai là chu");
            request.setAttribute("listGV", listGiangVien);
            request.getRequestDispatcher("/lab1_4/trang-chu.jsp").forward(request, response);

        }
        if (Integer.valueOf(tuoi) <= 25) {
            request.setAttribute("error", "can nang phai > 25");
            request.setAttribute("listGV", listGiangVien);
            request.getRequestDispatcher("/lab1_4/trang-chu.jsp").forward(request, response);

        } else {
            GiangVien gv = new GiangVien(ma, ten, Integer.valueOf(tuoi), Boolean.valueOf(gioiTinh), queQuan);
            giangVienService.add(gv);
            listGiangVien = giangVienService.getAll();
            request.setAttribute("listGV", listGiangVien);
            request.getRequestDispatcher("/lab1_4/trang-chu.jsp").forward(request, response);
        }

    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        GiangVien gv = giangVienService.getOne(ma);
        request.setAttribute("gv", gv);
        request.setAttribute("listGV", listGiangVien);
        request.getRequestDispatcher("/lab1_4/update.jsp").forward(request, response);
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) {
    }

    private void giangVienNu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listGiangVien = giangVienService.giangVienNu();
        request.setAttribute("listGV", listGiangVien);
        request.getRequestDispatcher("/lab1_4/trang-chu.jsp").forward(request, response);
    }

    private void sort(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listGiangVien = giangVienService.sortTuoi();
        request.setAttribute("listGV", listGiangVien);
        request.getRequestDispatcher("/lab1_4/trang-chu.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String ma = request.getParameter("ma");
        GiangVien gv = giangVienService.getOne(ma);
        giangVienService.delete(gv);
        listGiangVien = giangVienService.getAll();
        request.setAttribute("listGV", listGiangVien);
        request.getRequestDispatcher("/lab1_4/trang-chu.jsp").forward(request, response);

    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        GiangVien gv = giangVienService.getOne(ma);
        request.setAttribute("gv", gv);
        request.setAttribute("listGV", listGiangVien);
        request.getRequestDispatcher("/lab1_4/trang-chu.jsp").forward(request, response);
    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ten = request.getParameter("ten");
        String min = request.getParameter("min");
        String max = request.getParameter("max");

        if (ten.isEmpty()) {
            listGiangVien = giangVienService.searchMinMax(Integer.valueOf(min), Integer.valueOf(max));
        } else {
            listGiangVien = giangVienService.searchTen(ten);
        }
        request.setAttribute("listGV", listGiangVien);
        request.getRequestDispatcher("/lab1_4/trang-chu.jsp").forward(request, response);
    }

    private void hienThiTatCa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (listGiangVien.isEmpty()) {
            listGiangVien = giangVienService.getAll();
        }
        request.setAttribute("listGV", listGiangVien);
        request.getRequestDispatcher("/lab1_4/trang-chu.jsp").forward(request, response);
    }
}
