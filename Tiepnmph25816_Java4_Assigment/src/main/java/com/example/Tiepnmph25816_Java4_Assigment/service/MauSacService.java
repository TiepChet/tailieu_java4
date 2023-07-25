package com.example.Tiepnmph25816_Java4_Assigment.service;

import com.example.Tiepnmph25816_Java4_Assigment.entity.MauSac;

import java.util.List;
import java.util.UUID;

public interface MauSacService {

    List<MauSac> getAll();

    MauSac getOne(UUID id);

    String add(MauSac mauSac);

    String update(MauSac mauSac);

    String delete(MauSac mauSac);
}
