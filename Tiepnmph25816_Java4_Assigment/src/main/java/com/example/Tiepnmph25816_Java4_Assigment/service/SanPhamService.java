package com.example.Tiepnmph25816_Java4_Assigment.service;

import com.example.Tiepnmph25816_Java4_Assigment.entity.SanPham;

import java.util.List;
import java.util.UUID;

public interface SanPhamService {

    List<SanPham> getAll();

    SanPham getOne(UUID id);

    String add(SanPham sanPham);

    String update(SanPham sanPham);

    String delete(SanPham sanPham);
}
