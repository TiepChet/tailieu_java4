package com.example.LuyenTap6.service.impl;

import com.example.LuyenTap6.entity.SinhVien;
import com.example.LuyenTap6.repository.SinhVienRepository;
import com.example.LuyenTap6.service.SinhVienService;

import java.util.List;
import java.util.UUID;

public class SinhVienServiceImpl implements SinhVienService {
    private SinhVienRepository  sinhVienRepository = new SinhVienRepository();
    @Override
    public List<SinhVien> getAll() {
        return sinhVienRepository.getAll();
    }

    @Override
    public SinhVien getOne(UUID ma) {
        return sinhVienRepository.getOne(ma);
    }

    @Override
    public String add(SinhVien sinhVien) {
        boolean add = sinhVienRepository.add(sinhVien);
        if(add){
            return "add thanh cong";
        }else{
            return "add that bai";
        }
    }

    @Override
    public String update(SinhVien sinhVien) {
        boolean update = sinhVienRepository.update(sinhVien);
        if(update){
            return "update thanh cong";
        }else{
            return "update that bai";
        }
    }

    @Override
    public String delete(SinhVien sinhVien) {
        boolean delete = sinhVienRepository.delete(sinhVien);
        if(delete){
            return "delete thanh cong";
        }else{
            return "delete that bai";
        }
    }

    @Override
    public List<SinhVien> sinhVienNu() {
        return sinhVienRepository.sinhVienNu();
    }

    @Override
    public List<SinhVien> searchTen(String ten) {
        return sinhVienRepository.searchTen(ten);
    }

    @Override
    public List<SinhVien> sortTuoi() {
        return sinhVienRepository.sortTuoi();
    }

    @Override
    public List<SinhVien> sortTen() {
        return sinhVienRepository.sortTen();
    }
}
