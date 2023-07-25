package com.example.DemoJoinTable.crud.service;

import com.example.DemoJoinTable.crud.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();

    Product getOne(Long id);
}
