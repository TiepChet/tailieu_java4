package com.example.LuyenTapBuoi5.service.impl;

import com.example.LuyenTapBuoi5.entity.TacGia;
import com.example.LuyenTapBuoi5.repository.TacGiaRepository;
import com.example.LuyenTapBuoi5.service.TacGiaService;

import java.util.List;
import java.util.UUID;

public class TacGiaServiceImpl implements TacGiaService {
    private TacGiaRepository tacGiaRepository = new TacGiaRepository();

    @Override
    public List<TacGia> getAll() {
        return tacGiaRepository.getAll();
    }

    @Override
    public TacGia getOne(UUID ma) {
        return tacGiaRepository.getOne(ma);
    }

    @Override
    public String add(TacGia tacGia) {
        boolean add = tacGiaRepository.add(tacGia);
        if (add) {
            return "add thanh cong";
        } else {
            return "add that bai";
        }
    }

    @Override
    public String update(TacGia tacGia) {
        boolean update = tacGiaRepository.update(tacGia);
        if (update) {
            return "update thanh cong";
        } else {
            return "update that bai";
        }
    }

    @Override
    public String delete(TacGia tacGia) {
        boolean delete = tacGiaRepository.delete(tacGia);
        if (delete) {
            return "delete thanh cong";
        } else {
            return "delete that bai";
        }
    }

    @Override
    public List<TacGia> sortTuoi() {
        return tacGiaRepository.sortTuoi();
    }

    @Override
    public List<TacGia> sortTen() {
        return tacGiaRepository.sortTen();
    }

    @Override
    public List<TacGia> searchTen(String ten) {
        return tacGiaRepository.searchTen(ten);
    }
}
