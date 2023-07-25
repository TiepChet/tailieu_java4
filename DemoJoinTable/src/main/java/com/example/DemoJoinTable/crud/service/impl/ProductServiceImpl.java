package com.example.DemoJoinTable.crud.service.impl;

import com.example.DemoJoinTable.crud.entity.Product;
import com.example.DemoJoinTable.crud.repository.ProductRepository;
import com.example.DemoJoinTable.crud.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    public ProductRepository productRepository = new ProductRepository();

    @Override
    public List<Product> getAll() {
        return productRepository.getAll();
    }

    @Override
    public Product getOne(Long id) {
        return productRepository.getOne(id);
    }
}
