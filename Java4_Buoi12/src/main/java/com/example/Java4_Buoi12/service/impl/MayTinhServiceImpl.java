package com.example.Java4_Buoi12.service.impl;

import com.example.Java4_Buoi12.entity.MayTinh;
import com.example.Java4_Buoi12.repository.MayTinhRepository;
import com.example.Java4_Buoi12.service.MayTinhService;

import java.util.List;
import java.util.UUID;

public class MayTinhServiceImpl implements MayTinhService {

    private MayTinhRepository mayTinhRepository = new MayTinhRepository();

    @Override
    public List<MayTinh> getAll() {
        return mayTinhRepository.getAll();
    }

    @Override
    public MayTinh getOne(UUID ma) {
        return mayTinhRepository.getOne(ma);
    }

    @Override
    public List<MayTinh> sortGia() {
        return mayTinhRepository.sortGia();
    }

    @Override
    public List<MayTinh> sortBoNho() {
        return mayTinhRepository.sortBoNho();
    }

    @Override
    public String add(MayTinh mayTinh) {
        boolean add = mayTinhRepository.add(mayTinh);
        if (add) {
            return "add thanh cong";
        } else {
            return "add that bai";
        }
    }

    @Override
    public String update(MayTinh mayTinh) {

        boolean update = mayTinhRepository.update(mayTinh);
        if (update) {
            return "update thanh cong";
        } else {
            return "update that bai";
        }
    }

    @Override
    public String delete(MayTinh mayTinh) {
        boolean delete = mayTinhRepository.delete(mayTinh);
        if (delete) {
            return "delete thanh cong";
        } else {
            return "delete that bai";
        }
    }
}
