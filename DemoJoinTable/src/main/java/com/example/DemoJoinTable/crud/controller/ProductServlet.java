package com.example.DemoJoinTable.crud.controller;


import com.example.DemoJoinTable.crud.entity.Category;
import com.example.DemoJoinTable.crud.entity.Product;
import com.example.DemoJoinTable.crud.service.CategoryService;
import com.example.DemoJoinTable.crud.service.ProductService;
import com.example.DemoJoinTable.crud.service.impl.CategoryServiceImpl;
import com.example.DemoJoinTable.crud.service.impl.ProductServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", value = {
        "/product/hien-thi",
        "/product/add",
        "/product/update",
        "/product/detail",
        "/product/delete",
        "/product/view-add",
        "/product/view-update",

})
public class ProductServlet extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();
    private List<Product> listProduct = new ArrayList<>();
    private CategoryService category = new CategoryServiceImpl();
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
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
    }

    private void add(HttpServletRequest request, HttpServletResponse response) {
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) {
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) {
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String id = request.getParameter("id");
//        Product pd = productService.getOne(Long.valueOf(id));
//        request.setAttribute("id",pd);
//        request.setAttribute("listProduct", listProduct);
//        request.setAttribute("listCategory",category.getAll());
//        request.getRequestDispatcher("/product/trang-chu.jsp").forward(request, response);
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listProduct = productService.getAll();
        request.setAttribute("listProduct", listProduct);
        request.setAttribute("listCategory",category.getAll());
        request.getRequestDispatcher("/product/trang-chu.jsp").forward(request, response);
    }
}
