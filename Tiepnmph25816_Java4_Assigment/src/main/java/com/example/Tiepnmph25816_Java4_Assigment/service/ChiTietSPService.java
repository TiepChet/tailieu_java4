package com.example.Tiepnmph25816_Java4_Assigment.service;

import com.example.Tiepnmph25816_Java4_Assigment.entity.ChiTietSP;

import java.util.List;
import java.util.UUID;

public interface ChiTietSPService {

    List<ChiTietSP> getAll();

    ChiTietSP getOne(UUID id);

    String add(ChiTietSP chiTietSP);

    String update(ChiTietSP chiTietSP);

    String delete(ChiTietSP chiTietSP);
}
