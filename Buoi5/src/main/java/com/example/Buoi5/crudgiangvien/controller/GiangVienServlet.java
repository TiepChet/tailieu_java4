package com.example.Buoi5.crudgiangvien.controller;


import com.example.Buoi5.crudgiangvien.entity.GiangVien;
import com.example.Buoi5.crudgiangvien.service.GiangVienService;
import com.example.Buoi5.crudgiangvien.service.impl.GiangVienServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "GiangVienServlet", value = {
        "/giang-vien/hien-thi",
        "/giang-vien/search",
        "/giang-vien/remove",
        "/giang-vien/add",
        "/giang-vien/update",
        "/giang-vien/detail",
        "/giang-vien/view-add",
        "/giang-vien/view-update",
        "/giang-vien/que-quan",
        "/giang-vien/sort",
})
public class GiangVienServlet extends HttpServlet {
    private GiangVienService giangVienService = new GiangVienServiceImpl();
    private List<GiangVien> giangViens = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThiGiangVien(request, response);
        } else if (uri.contains("search")) {
            this.searchGiangVien(request, response);
        } else if (uri.contains("remove")) {
            this.removeGiangVien(request, response);
        } else if (uri.contains("detail")) {
            this.detailGiangVien(request, response);
        } else if (uri.contains("view-add")) {
            this.viewAddGiangVien(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdateGiangVien(request, response);
        } else if (uri.contains("que-quan")) {
            this.queQuanGiangVien(request, response);
        } else if (uri.contains("sort")) {
            this.sortGiangVien(request, response);
        } else {
            this.hienThiGiangVien(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            this.addGiangVien(request, response);
        } else if (uri.contains("update")) {
            this.updateGiangVien(request, response);
        } else {
            this.hienThiGiangVien(request, response);
        }
    }

    private void updateGiangVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String tuoi = request.getParameter("tuoi");
        String queQuan = request.getParameter("queQuan");
        GiangVien gv = giangVienService.updateGiangVien(giangViens, Integer.valueOf(id));
        gv.setId(Integer.valueOf(id));
        gv.setMa(ma);
        gv.setTen(ten);
        gv.setTuoi(Integer.valueOf(tuoi));
        gv.setQueQuan(queQuan);
        giangViens.set(giangVienService.viTriUpdate(giangViens, gv.getId()), gv);
        request.setAttribute("listGV", giangViens);
        request.getRequestDispatcher("/giangvien/trang-chu.jsp").forward(request, response);
    }

    private void addGiangVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String tuoi = request.getParameter("tuoi");
        String queQuan = request.getParameter("queQuan");
        if (id.isEmpty() || ma.isEmpty() || ten.isEmpty() || tuoi.isEmpty() || queQuan.isEmpty()) {
            request.setAttribute("error", "trong");
            request.getRequestDispatcher("/giangvien/trang-chu.jsp").forward(request, response);
        } else if (Integer.valueOf(tuoi) <= 25) {
            request.setAttribute("error", "tuoi nho");
            request.getRequestDispatcher("/giangvien/trang-chu.jsp").forward(request, response);
        } else {
            GiangVien gv = GiangVien.builder()
                    .id(Integer.valueOf(id))
                    .ma(ma)
                    .ten(ten)
                    .tuoi(Integer.valueOf(tuoi))
                    .queQuan(queQuan)
                    .build();
            giangViens.add(gv);
            response.sendRedirect("/giang-vien/hien-thi");
        }

    }


    private void searchGiangVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ten = request.getParameter("ten");
        String min = request.getParameter("min");
        String max = request.getParameter("max");
        giangViens = giangVienService.searchGiangVien(giangViens, ten, Integer.valueOf(min), Integer.valueOf(max));
        request.setAttribute("listGV", giangViens);
        request.getRequestDispatcher("/giangvien/trang-chu.jsp").forward(request, response);

    }

    private void removeGiangVien(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        giangVienService.removeGiangVien(giangViens, Integer.valueOf(id));
        response.sendRedirect("/giang-vien/hien-thi");
    }

    private void detailGiangVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        GiangVien gv = giangVienService.detailGiangVien(giangViens, Integer.valueOf(id));
        request.setAttribute("gv", gv);
        request.getRequestDispatcher("/giangvien/trang-chu.jsp").forward(request, response);
    }

    private void viewAddGiangVien(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/giang-vien/hien-thi");
    }

    private void viewUpdateGiangVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        GiangVien gv = giangVienService.updateGiangVien(giangViens, Integer.valueOf(id));
        request.setAttribute("gv", gv);
        request.getRequestDispatcher("/giangvien/update.jsp").forward(request, response);
    }

    private void queQuanGiangVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        giangViens = giangVienService.queQuan(giangViens, "Thai Binh");
        request.setAttribute("listGV", giangViens);
        request.getRequestDispatcher("/giangvien/trang-chu.jsp").forward(request, response);
    }

    private void sortGiangVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        giangViens = giangVienService.sortTuoi(giangViens);
        request.setAttribute("listGV", giangViens);
        request.getRequestDispatcher("/giangvien/trang-chu.jsp").forward(request, response);
    }

    private void hienThiGiangVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (giangViens.isEmpty()) {
            giangViens = giangVienService.getAll();
        }
        request.setAttribute("listGV", giangViens);
        request.getRequestDispatcher("/giangvien/trang-chu.jsp").forward(request, response);
    }
}
