package com.example.DemoJoinTable.crud.service.impl;

import com.example.DemoJoinTable.crud.entity.Category;
import com.example.DemoJoinTable.crud.repository.CategoryRepository;
import com.example.DemoJoinTable.crud.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository = new CategoryRepository();

    @Override
    public List<Category> getAll() {
        return categoryRepository.getAll();
    }

    @Override
    public Category getOne(Long id) {
        return  categoryRepository.getOne(id);
    }


    @Override
    public String add(Category category) {
        boolean add = categoryRepository.add(category);
        if (add) {
            return "add thanh cong";
        } else {
            return "add that bai";
        }
    }

    @Override
    public String update(Category category) {
        boolean update = categoryRepository.update(category);
        if (update) {
            return "update thanh cong";
        } else {
            return "update that bai";
        }
    }

    @Override
    public String delete(Category category) {
        boolean delete = categoryRepository.delete(category);
        if (delete) {
            return "delete thanh cong";
        } else {
            return "delete that bai";
        }
    }
}
