package com.example.Tiepnmph25816_Java4_Assigment.service;

import com.example.Tiepnmph25816_Java4_Assigment.entity.CuaHang;

import java.util.List;
import java.util.UUID;

public interface CuaHangService {

    List<CuaHang> getAll();

    CuaHang getOne(UUID id);

    String add(CuaHang cuaHang);

    String update(CuaHang cuaHang);

    String delete(CuaHang cuaHang);
}
