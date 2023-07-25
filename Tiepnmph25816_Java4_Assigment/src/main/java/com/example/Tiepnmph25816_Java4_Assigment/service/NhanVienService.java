package com.example.Tiepnmph25816_Java4_Assigment.service;

import com.example.Tiepnmph25816_Java4_Assigment.entity.NhanVien;

import java.util.List;
import java.util.UUID;

public interface NhanVienService {

    List<NhanVien> getAll();

    NhanVien getOne(UUID id);

    String add(NhanVien nhanVien);

    String update(NhanVien nhanVien);

    String delete(NhanVien nhanVien);
}
