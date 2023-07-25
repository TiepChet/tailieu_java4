package com.example.LuyenTapBuoi7.service.impl;

import com.example.LuyenTapBuoi7.entity.KhachHang;
import com.example.LuyenTapBuoi7.repository.KhachHangRepository;
import com.example.LuyenTapBuoi7.service.KhachHangService;

import java.util.List;
import java.util.UUID;

public class KhachHangServiceImpl implements KhachHangService {
    private KhachHangRepository khachHangRepository = new KhachHangRepository();

    @Override
    public List<KhachHang> getAll() {
        return khachHangRepository.getAll();
    }

    @Override
    public KhachHang getOne(UUID id) {
        return khachHangRepository.getOne(id);
    }

    @Override
    public String add(KhachHang khachHang) {
        boolean add = khachHangRepository.add(khachHang);
        if (add) {
            return "add thanh cong";
        } else {
            return "add that bai";
        }
    }

    @Override
    public String update(KhachHang khachHang) {
        boolean update = khachHangRepository.update(khachHang);
        if (update) {
            return "update thanh cong";
        } else {
            return "update that bai";
        }
    }

    @Override
    public String delete(KhachHang khachHang) {
        boolean delete = khachHangRepository.delete(khachHang);
        if (delete) {
            return "delete thanh cong";
        } else {
            return "delete that bai";
        }
    }
}
