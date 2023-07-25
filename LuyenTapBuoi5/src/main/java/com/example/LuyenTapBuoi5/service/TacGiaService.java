package com.example.LuyenTapBuoi5.service;

import com.example.LuyenTapBuoi5.entity.TacGia;

import java.util.List;
import java.util.UUID;

public interface TacGiaService {

    List<TacGia> getAll();

    TacGia getOne(UUID ma);

    String add(TacGia tacGia);

    String update(TacGia tacGia);

    String delete(TacGia tacGia);

    List<TacGia> sortTuoi();

    List<TacGia> sortTen();

    List<TacGia> searchTen(String ten);

}
