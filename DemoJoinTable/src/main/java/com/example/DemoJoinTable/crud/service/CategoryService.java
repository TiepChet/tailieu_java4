package com.example.DemoJoinTable.crud.service;

import com.example.DemoJoinTable.crud.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();

    Category getOne(Long id);

    String add(Category category);

    String update(Category category);

    String delete(Category category);
}
