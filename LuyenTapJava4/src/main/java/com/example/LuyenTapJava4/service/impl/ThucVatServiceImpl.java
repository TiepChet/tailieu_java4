package com.example.LuyenTapJava4.service.impl;

import com.example.LuyenTapJava4.entity.ThucVat;
import com.example.LuyenTapJava4.repository.ThucVatRepository;
import com.example.LuyenTapJava4.service.ThucVatService;

import java.util.List;
import java.util.UUID;

public class ThucVatServiceImpl implements ThucVatService{
    private ThucVatRepository thucVatRepository = new ThucVatRepository();
    @Override
    public List<ThucVat> getAll() {
        return thucVatRepository.getAll();
    }

    @Override
    public ThucVat getOne(UUID ma) {
        return thucVatRepository.getOne(ma);
    }

    @Override
    public String add(ThucVat thucVat) {
        if(thucVat.getTen().isEmpty() || String.valueOf(thucVat.getTuoi()).isEmpty()
                || thucVat.getKhuVucSong().isEmpty() || thucVat.getLoai().isEmpty()
                || String.valueOf(thucVat.getGioiTinh()).isEmpty()){
            return "Nhập thông tin đầy đủ";
        }else{
            boolean add = thucVatRepository.add(thucVat);
            if(add){
                return "add thanh cong";
            }else{
                return "add that bai";
            }
        }

    }

    @Override
    public String update(ThucVat thucVat) {
        boolean update = thucVatRepository.update(thucVat);
        if(update){
            return "update thanh cong";
        }else{
            return "update that bai";
        }
    }

    @Override
    public String delete(ThucVat thucVat) {
        boolean delete = thucVatRepository.delete(thucVat);
        if(delete){
            return "delete thanh cong";
        }else{
            return "delete that bai";
        }
    }

    @Override
    public List<ThucVat> search(String ten) {
        return thucVatRepository.search(ten);
    }

    @Override
    public List<ThucVat> sortTuoi() {
        return thucVatRepository.sortTuoi();
    }

    @Override
    public List<ThucVat> sortTen() {
        return thucVatRepository.sortTen();
    }
}
