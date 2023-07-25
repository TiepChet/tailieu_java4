package com.example.Java4_Buoi9.crud.service;

import com.example.Java4_Buoi9.crud.entity.GiangVien;

import java.util.List;

public interface GiangVienService {
    List<GiangVien> getAll();

    List<GiangVien> search(String ten);

    List<GiangVien> giangVienNu();

    List<GiangVien> sortTuoi();

    GiangVien getOne(Long id);

    String add(GiangVien giangVien);

    String  update(GiangVien giangVien);

    String delete(GiangVien giangVien);
}
