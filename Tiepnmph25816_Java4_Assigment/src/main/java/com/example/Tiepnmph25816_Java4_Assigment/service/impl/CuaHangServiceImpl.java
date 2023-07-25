package com.example.Tiepnmph25816_Java4_Assigment.service.impl;

import com.example.Tiepnmph25816_Java4_Assigment.entity.CuaHang;
import com.example.Tiepnmph25816_Java4_Assigment.repository.CuaHangRepository;
import com.example.Tiepnmph25816_Java4_Assigment.service.CuaHangService;

import java.util.List;
import java.util.UUID;

public class CuaHangServiceImpl implements CuaHangService {
    private CuaHangRepository cuaHangRepository = new CuaHangRepository();

    @Override
    public List<CuaHang> getAll() {
        return cuaHangRepository.getAll();
    }

    @Override
    public CuaHang getOne(UUID id) {
        return cuaHangRepository.getOne(id);
    }

    @Override
    public String add(CuaHang cuaHang) {
        if (cuaHang.getMa().isEmpty() || cuaHang.getTen().isEmpty() || cuaHang.getDiaChi().isEmpty()
                || cuaHang.getThanhPho().isEmpty() || cuaHang.getQuocGia().isEmpty()) {
            return "Nhập thông tin đầy đủ";
        } else {
            boolean add = cuaHangRepository.add(cuaHang);
            if (add) {
                return "add thanh cong";
            } else {
                return "add that bai";
            }
        }

    }

    @Override
    public String update(CuaHang cuaHang) {
        boolean update = cuaHangRepository.update(cuaHang);
        if (update) {
            return "update thanh cong";
        } else {
            return "update that bai";
        }
    }

    @Override
    public String delete(CuaHang cuaHang) {
        boolean delete = cuaHangRepository.delete(cuaHang);
        if (delete) {
            return "delete thanh cong";
        } else {
            return "delete that bai";
        }
    }
}
