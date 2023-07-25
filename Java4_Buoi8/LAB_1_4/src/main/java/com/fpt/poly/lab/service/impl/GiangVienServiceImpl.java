package com.fpt.poly.lab.service.impl;

import com.fpt.poly.lab.entity.GiangVien;
import com.fpt.poly.lab.repository.GiangVienRepository;
import com.fpt.poly.lab.service.GiangVienService;

import java.util.List;

public class GiangVienServiceImpl implements GiangVienService {
    private GiangVienRepository giangVienRepository = new GiangVienRepository();

    @Override
    public List<GiangVien> getAll() {
        return giangVienRepository.getAll();
    }

    @Override
    public GiangVien getOne(String ma) {
        return giangVienRepository.getOne(ma);
    }

    @Override
    public void add(GiangVien giangVien) {
        giangVienRepository.add(giangVien);
    }

    @Override
    public void delete(GiangVien giangVien) {
        giangVienRepository.delete(giangVien);

    }

    @Override
    public void update(GiangVien giangVien) {
        giangVienRepository.update(giangVien);
    }

    @Override
    public List<GiangVien> searchTen(String ten) {
        return giangVienRepository.searchTen(ten);
    }

    @Override
    public List<GiangVien> searchMinMax(int min, int max) {
        return giangVienRepository.searchMinMax(min, max);
    }

    @Override
    public List<GiangVien> giangVienNu() {
        return giangVienRepository.giangVienNu();
    }

    @Override
    public List<GiangVien> sortTuoi() {
        return giangVienRepository.sortTuoi();
    }
}
