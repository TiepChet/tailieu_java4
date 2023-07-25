package com.example.LuyenTapJava4.service;

import com.example.LuyenTapJava4.entity.ThucVat;

import java.util.List;
import java.util.UUID;

public interface ThucVatService {

    List<ThucVat> getAll();

    ThucVat getOne(UUID ma);

    String add(ThucVat thucVat);

    String update(ThucVat thucVat);

    String delete(ThucVat thucVat);

    List<ThucVat> search(String ten);

    List<ThucVat> sortTuoi();

    List<ThucVat> sortTen();
}
