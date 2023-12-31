package com.example.Tiepnmph25816_Java4_Assigment.service.impl;

import com.example.Tiepnmph25816_Java4_Assigment.entity.DongSP;
import com.example.Tiepnmph25816_Java4_Assigment.repository.DongSPRepository;
import com.example.Tiepnmph25816_Java4_Assigment.service.DongSPService;

import java.util.List;
import java.util.UUID;

public class DongSPServiceImpl implements DongSPService {
    private DongSPRepository dongSPRepository = new DongSPRepository();

    @Override
    public List<DongSP> getAll() {
        return dongSPRepository.getAll();
    }

    @Override
    public DongSP getOne(UUID id) {
        return dongSPRepository.getOne(id);
    }

    @Override
    public String add(DongSP dongSP) {
        if (dongSP.getMa().isEmpty() || dongSP.getTen().isEmpty()) {
            return "Nhập đầy đủ thông tin";
        } else {
            boolean add = dongSPRepository.add(dongSP);
            if (add) {
                return "add thanh cong";
            } else {
                return "add that bai";
            }
        }

    }

    @Override
    public String update(DongSP dongSP) {
        boolean update = dongSPRepository.update(dongSP);
        if (update) {
            return "update thanh cong";
        } else {
            return "update that bai";
        }
    }

    @Override
    public String delete(DongSP dongSP) {
        boolean delete = dongSPRepository.delete(dongSP);
        if (delete) {
            return "delete thanh cong";
        } else {
            return "delete that bai";
        }
    }
}
