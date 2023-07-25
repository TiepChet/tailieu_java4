package com.example.LuyenTapBuoi7.service;

import com.example.LuyenTapBuoi7.entity.KhachHang;

import java.util.List;
import java.util.UUID;

public interface KhachHangService {

    List<KhachHang> getAll();

    KhachHang getOne(UUID id);

    String add(KhachHang khachHang);

    String update(KhachHang khachHang);

    String delete(KhachHang khachHang);


}
