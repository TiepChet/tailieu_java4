package com.example.Tiepnmph25816_Java4_Assigment.service;

import com.example.Tiepnmph25816_Java4_Assigment.entity.NhaSanXuat;

import java.util.List;
import java.util.UUID;

public interface NhaSanXuatService {

    List<NhaSanXuat> getAll();

    NhaSanXuat getOne(UUID id);

    String add(NhaSanXuat nhaSanXuat);

    String update(NhaSanXuat nhaSanXuat);

    String delete(NhaSanXuat nhaSanXuat);
}
