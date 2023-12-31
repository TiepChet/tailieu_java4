package com.example.Tiepnmph25816_Java4_Assigment.service.impl;

import com.example.Tiepnmph25816_Java4_Assigment.entity.SanPham;
import com.example.Tiepnmph25816_Java4_Assigment.repository.SanPhamRepository;
import com.example.Tiepnmph25816_Java4_Assigment.service.SanPhamService;

import java.util.List;
import java.util.UUID;

public class SanPhamServiceImpl implements SanPhamService {
    private SanPhamRepository sanPhamRepository = new SanPhamRepository();

    @Override
    public List<SanPham> getAll() {
        return sanPhamRepository.getAll();
    }

    @Override
    public SanPham getOne(UUID id) {
        return sanPhamRepository.getOne(id);
    }

    @Override
    public String add(SanPham sanPham) {
        if(sanPham.getMa().isEmpty() || sanPham.getTen().isEmpty()){
            return "Nhập đầy đủ thông tin";
        }else{
            boolean add = sanPhamRepository.add(sanPham);
            if (add) {
                return "add thanh cong";
            } else {
                return "add that bai";
            }
        }

    }

    @Override
    public String update(SanPham sanPham) {
        boolean update = sanPhamRepository.update(sanPham);
        if (update) {
            return "update thanh cong";
        } else {
            return "update that bai";
        }
    }

    @Override
    public String delete(SanPham sanPham) {
        boolean delete = sanPhamRepository.delete(sanPham);
        if (delete) {
            return "delete thanh cong";
        } else {
            return "delete that bai";
        }
    }
}
