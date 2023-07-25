package com.example.Java4_Buoi11.service;

import com.example.Java4_Buoi11.entity.SanPham;

import java.util.List;

public interface SanPhamService {
    List<SanPham> getAll();

    SanPham getOne(Long id);

    String add(SanPham sanPham);

    String update(SanPham sanPham);

    String delete(SanPham sanPham);

    List<SanPham> search(String ten);
}
