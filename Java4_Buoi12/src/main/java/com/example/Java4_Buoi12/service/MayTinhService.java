package com.example.Java4_Buoi12.service;

import com.example.Java4_Buoi12.entity.MayTinh;

import java.util.List;
import java.util.UUID;

public interface MayTinhService {
    List<MayTinh> getAll();

    MayTinh getOne(UUID ma);

    List<MayTinh> sortGia();

    List<MayTinh> sortBoNho();

    String add(MayTinh mayTinh);

    String update(MayTinh mayTinh);

    String delete(MayTinh mayTinh);
}
