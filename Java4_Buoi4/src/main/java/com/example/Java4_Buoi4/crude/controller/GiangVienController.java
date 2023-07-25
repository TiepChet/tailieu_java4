package com.example.Java4_Buoi4.crude.controller;

import com.example.Java4_Buoi4.crude.etity.GiangVien;
import com.example.Java4_Buoi4.crude.service.GiangVienService;
import com.example.Java4_Buoi4.crude.service.impl.GiangVienServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "GiangVienController", value = {
        "/giang-vien/hien-thi",//GET
        "/giang-vien/search",//GET
        "/giang-vien/remove",//GET
        "/giang-vien/detail",//GET
        "/giang-vien/view-update",//GET
        "/giang-vien/view-add",//GET
        "/giang-vien/add",//POST
        "/giang-vien/update",//POST
        "/giang-vien/giang-vien-nu"//GET
})
public class GiangVienController extends HttpServlet {
    private GiangVienService giangVienService = new GiangVienServiceImpl();
    private List<GiangVien> giangViens = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String tenServlet = (String) session.getAttribute("name");
        request.setAttribute("ten", tenServlet);

        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            // hien thi du liệu
            this.hienThiGiangVien(request, response);
        } else if (uri.contains("search")) {
            // search dữ liệu
            this.searchGiangVien(request, response);
        } else if (uri.contains("remove")) {
            // remove dữ liệu
            this.removeGiangVien(request, response);
        } else if (uri.contains("detail")) {
            // detail dữ liệu
            this.detailGiangVien(request, response);
        } else if (uri.contains("view-update")) {
            // view-update dữ liệu
            this.viewUpdateGiangVien(request, response);
        } else if (uri.contains("view-add")) {
            // view-add dữ liệu
            this.viewAddGiangVien(request, response);
        } else {
            // Nếu không vào các test case trên thì quay lại trang hiển thị
            this.hienThiGiangVien(request, response);
        }



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("update")) {
            // update du liệu
            this.updateGiangVien(request, response);
        } else if (uri.contains("add")) {
            // add dữ liệu
            this.addGiangVien(request, response);
        } else {
            // Nếu không vào các test case trên thì quay lại trang hiển thị
            this.hienThiGiangVien(request, response);
        }
    }

    private void addGiangVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String tuoi = request.getParameter("tuoi");
        String diaChi = request.getParameter("diaChi");
        String gioiTinh = request.getParameter("gioiTinh");
        GiangVien gv = GiangVien.builder()
                .id(Integer.parseInt(id))
                .ma(ma)
                .ten(ten)
                .tuoi(Integer.valueOf(tuoi))
                .diaChi(diaChi)
                .gioiTinh(Boolean.parseBoolean(gioiTinh))
                .build();
        giangViens.add(gv);
        request.setAttribute("listGiangVien", giangViens);
        request.getRequestDispatcher("/giangvien/trang-chu.jsp").forward(request, response);
    }

    private void updateGiangVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String tuoi = request.getParameter("tuoi");
        String diaChi = request.getParameter("diaChi");
        String gioiTinh = request.getParameter("gioiTinh");

        GiangVien giangVienUpdate = giangVienService.findGiangVienbyMa(giangViens, ma);
        giangVienUpdate.setId(Integer.valueOf(id));
        giangVienUpdate.setTen(ten);
        giangVienUpdate.setTuoi(Integer.valueOf(tuoi));
        giangVienUpdate.setDiaChi(diaChi);
        if (Boolean.parseBoolean(gioiTinh)) {
            giangVienUpdate.setGioiTinh(true);
        } else {
            giangVienUpdate.setGioiTinh(false);
        }

        giangViens.set(giangVienService.viTriGiangVien(giangViens, giangVienUpdate.getMa()), giangVienUpdate);
        request.setAttribute("listGiangVien", giangViens);
        request.getRequestDispatcher("/giangvien/trang-chu.jsp").forward(request, response);
    }

    private void searchGiangVien(HttpServletRequest request, HttpServletResponse response) {
    }

    private void removeGiangVien(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma = request.getParameter("ma");
        giangVienService.removeGiangVien(giangViens, ma);
        response.sendRedirect("/giang-vien/hien-thi");
    }

    private void detailGiangVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.valueOf(request.getParameter("id"));
        GiangVien gv = giangViens.get(id);

//        String ma = request.getParameter("ma");
//        GiangVien gv = giangVienService.findGiangVienbyMa(giangViens, ma);
        request.setAttribute("gv", gv);
        request.getRequestDispatcher("/giangvien/detail.jsp").forward(request, response);
    }

    private void viewUpdateGiangVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        GiangVien gv = giangVienService.findGiangVienbyMa(giangViens, ma);
        request.setAttribute("gv", gv);
        request.getRequestDispatcher("/giangvien/update.jsp").forward(request, response);
    }

    private void viewAddGiangVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/giangvien/add.jsp").forward(request, response);
    }


    private void hienThiGiangVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (giangViens.isEmpty()) {
            giangViens = giangVienService.fakeData();
        }
        request.setAttribute("listGiangVien", giangViens);
        request.getRequestDispatcher("/giangvien/trang-chu.jsp").forward(request, response);
    }

}
