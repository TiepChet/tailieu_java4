package com.fpt.poly.lab.service;

import com.fpt.poly.lab.entity.GiangVien;

import java.util.List;

public interface GiangVienService {

    List<GiangVien> getAll();

    GiangVien getOne(String ma);

    void add(GiangVien giangVien);

    void delete(GiangVien giangVien);

    void  update(GiangVien giangVien);

    List<GiangVien> searchTen(String ten);

    List<GiangVien> searchMinMax(int min, int max);

    List<GiangVien> giangVienNu();

    List<GiangVien> sortTuoi();

}
