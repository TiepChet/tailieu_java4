package com.example.DemoJoinTable.crud.controller;


import com.example.DemoJoinTable.crud.entity.Category;
import com.example.DemoJoinTable.crud.service.CategoryService;
import com.example.DemoJoinTable.crud.service.impl.CategoryServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "CategoryServlet", value = {
        "/category/hien-thi",
        "/category/add",
        "/category/update",
        "/category/detail",
        "/category/delete",
        "/category/view-add",
        "/category/view-update",
})
public class CategoryServlet extends HttpServlet {
    private CategoryService categoryService = new CategoryServiceImpl();
    private List<Category> listCategory = new ArrayList<>();

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
        } else {
            this.hienThi(request, response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UUID id = UUID.fromString(request.getParameter("id"));
        String ma = request.getParameter("categoryCode");
        String ten = request.getParameter("categoryName");
        Category category = Category.builder()
                .categoryCode(ma)
                .categoryName(ten)
                .build();
        request.setAttribute("mess",categoryService.update(category));
        listCategory = categoryService.getAll();
        request.setAttribute("listCategory",listCategory);
        request.getRequestDispatcher("/category/trang-chu.jsp").forward(request,response);
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("categoryCode");
        String ten = request.getParameter("categoryName");
        Category category = Category.builder()
                .categoryCode(ma)
                .categoryName(ten)
                .build();
        request.setAttribute("mess",categoryService.add(category));
        listCategory = categoryService.getAll();
        request.setAttribute("listCategory",listCategory);
        request.getRequestDispatcher("/category/trang-chu.jsp").forward(request,response);
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Category category = categoryService.getOne(Long.valueOf(id));
        request.setAttribute("category",category);
        request.getRequestDispatcher("/category/update.jsp").forward(request,response);
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) {
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Category category = categoryService.getOne(Long.valueOf(id));
        request.setAttribute("mess",categoryService.delete(category));
        listCategory = categoryService.getAll();
        request.setAttribute("listCategory",listCategory);
        request.getRequestDispatcher("/category/trang-chu.jsp").forward(request,response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Category  category = categoryService.getOne(Long.valueOf(id));
        request.setAttribute("category",category);
        listCategory = categoryService.getAll();
        request.setAttribute("listCategory",listCategory);
        request.getRequestDispatcher("/category/trang-chu.jsp").forward(request,response);
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(listCategory.isEmpty()){
            listCategory = categoryService.getAll();
        }
        request.setAttribute("listCategory",listCategory);
        request.getRequestDispatcher("/category/trang-chu.jsp").forward(request,response);
    }

}
