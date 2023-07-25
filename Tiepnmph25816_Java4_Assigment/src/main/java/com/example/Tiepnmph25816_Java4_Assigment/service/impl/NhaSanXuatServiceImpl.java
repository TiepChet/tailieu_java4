package com.example.Tiepnmph25816_Java4_Assigment.service.impl;

import com.example.Tiepnmph25816_Java4_Assigment.entity.MauSac;
import com.example.Tiepnmph25816_Java4_Assigment.entity.NhaSanXuat;
import com.example.Tiepnmph25816_Java4_Assigment.repository.NhaSanXuatRepository;
import com.example.Tiepnmph25816_Java4_Assigment.service.NhaSanXuatService;

import java.util.List;
import java.util.UUID;

public class NhaSanXuatServiceImpl implements NhaSanXuatService {
    private NhaSanXuatRepository nhaSanXuatRepository= new NhaSanXuatRepository();

    @Override
    public List<NhaSanXuat> getAll() {
        return nhaSanXuatRepository.getAll();
    }

    @Override
    public NhaSanXuat getOne(UUID id) {
        return nhaSanXuatRepository.getOne(id);
    }

    @Override
    public String add(NhaSanXuat nhaSanXuat) {
        if(nhaSanXuat.getMa().isEmpty() || nhaSanXuat.getTen().isEmpty()){
            return "Nhập đầy đủ thông tin";
        }else{
            boolean add = nhaSanXuatRepository.add(nhaSanXuat);
            if (add) {
                return "add thanh cong";
            } else {
                return "add that bai";
            }
        }

    }

    @Override
    public String update(NhaSanXuat nhaSanXuat) {

            boolean update = nhaSanXuatRepository.update(nhaSanXuat);
            if (update) {
                return "update thanh cong";
            } else {
                return "update that bai";
            }

    }

    @Override
    public String delete(NhaSanXuat nhaSanXuat) {
        boolean delete = nhaSanXuatRepository.delete(nhaSanXuat);
        if (delete) {
            return "delete thanh cong";
        } else {
            return "delete that bai";
        }
    }
}
