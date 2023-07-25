package com.example.Tiepnmph25816_Java4_Assigment.service;

import com.example.Tiepnmph25816_Java4_Assigment.entity.KhachHang;

import java.util.List;
import java.util.UUID;

public interface KhachHangService {

    List<KhachHang> getAll();

    KhachHang getOne(UUID id);

    String add(KhachHang khachHang);

    String update(KhachHang khachHang);

    String delete(KhachHang khachHang);
}
