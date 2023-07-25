package com.example.Java4_Buoi11.service.impl;

import com.example.Java4_Buoi11.entity.SanPham;
import com.example.Java4_Buoi11.repository.SanPhamRepository;
import com.example.Java4_Buoi11.service.SanPhamService;

import java.util.List;

public class SanPhamServiceImpl implements SanPhamService {
    private SanPhamRepository sanPhamRepository = new SanPhamRepository();

    @Override
    public List<SanPham> getAll() {
        return sanPhamRepository.getAll();
    }

    @Override
    public SanPham getOne(Long id) {
        return sanPhamRepository.getOne(id);
    }

    @Override
    public String add(SanPham sanPham) {


            boolean add = sanPhamRepository.add(sanPham);
            if (add) {
                return "add thanh cong";
            } else {
                return "add that bai";
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

    @Override
    public List<SanPham> search(String ten) {
        return sanPhamRepository.search(ten);
    }
}
