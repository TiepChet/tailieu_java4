package com.example.Tiepnmph25816_Java4_Assigment.service;

import com.example.Tiepnmph25816_Java4_Assigment.entity.ChucVu;

import java.util.List;
import java.util.UUID;

public interface ChucVuService {
    List<ChucVu> getAll();

    ChucVu getOne(UUID id);

    String add(ChucVu chucVu);

    String update(ChucVu chucVu);

    String delete(ChucVu chucVu);
}
