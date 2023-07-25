package com.example.LuyenTap6.service;

import com.example.LuyenTap6.entity.SinhVien;

import java.util.List;
import java.util.UUID;

public interface SinhVienService {

    List<SinhVien> getAll();

    SinhVien getOne(UUID ma);

    String add(SinhVien sinhVien);

    String update(SinhVien sinhVien);

    String delete(SinhVien sinhVien);

    List<SinhVien> sinhVienNu();

    List<SinhVien> searchTen(String ten);

    List<SinhVien> sortTuoi();

    List<SinhVien> sortTen();

}
