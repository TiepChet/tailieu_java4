package com.example.Java4_Buoi9.crud.service.impl;

import com.example.Java4_Buoi9.crud.entity.GiangVien;
import com.example.Java4_Buoi9.crud.repository.GiangVienRepository;
import com.example.Java4_Buoi9.crud.service.GiangVienService;

import java.util.List;

public class GiangVienServiceImpl implements GiangVienService {
    private GiangVienRepository giangVienRepository = new GiangVienRepository();

    @Override
    public List<GiangVien> getAll() {
        return giangVienRepository.getAll();
    }

    @Override
    public List<GiangVien> search(String ten) {
        return giangVienRepository.search(ten);
    }

    @Override
    public List<GiangVien> giangVienNu() {
        return giangVienRepository.giangVienNu();
    }

    @Override
    public List<GiangVien> sortTuoi() {
        return giangVienRepository.sortTuoi();
    }

    @Override
    public GiangVien getOne(Long id) {
        return giangVienRepository.getOne(id);
    }

    @Override
    public String add(GiangVien giangVien) {
        boolean add = giangVienRepository.add(giangVien);
        if (add) {
            return "add thanh cong";
        } else {
            return "add that bai";
        }
    }

    @Override
    public String update(GiangVien giangVien) {
        boolean update = giangVienRepository.update(giangVien);
        if (update) {
            return "update thanh cong";
        } else {
            return "update that bai";
        }
    }

    @Override
    public String delete(GiangVien giangVien) {
        boolean delete = giangVienRepository.delete(giangVien);
        if (delete) {
            return "delete thanh cong";
        } else {
            return "delete that bai";
        }
    }
}
