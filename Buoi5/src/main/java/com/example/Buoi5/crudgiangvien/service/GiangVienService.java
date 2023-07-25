package com.example.Buoi5.crudgiangvien.service;

import com.example.Buoi5.crudgiangvien.entity.GiangVien;

import java.util.List;

public interface GiangVienService {
    List<GiangVien> getAll();

    GiangVien detailGiangVien(List<GiangVien> list, int id);

    GiangVien updateGiangVien(List<GiangVien> list, int id);

    int viTriUpdate(List<GiangVien> list, int id);

    void removeGiangVien(List<GiangVien> list, int id);

    List<GiangVien> sortTuoi(List<GiangVien>list);

    List<GiangVien> searchGiangVien(List<GiangVien> list, String ten, int min, int max);

    List<GiangVien> queQuan(List<GiangVien> list, String queQuan);
}
