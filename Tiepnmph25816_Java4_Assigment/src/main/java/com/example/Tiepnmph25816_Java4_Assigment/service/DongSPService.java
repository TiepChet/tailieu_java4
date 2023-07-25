package com.example.Tiepnmph25816_Java4_Assigment.service;

import com.example.Tiepnmph25816_Java4_Assigment.entity.DongSP;

import java.util.List;
import java.util.UUID;

public interface DongSPService {

    List<DongSP> getAll();

    DongSP getOne(UUID id);

    String add(DongSP dongSP);

    String update(DongSP dongSP);

    String delete(DongSP dongSP);
}
