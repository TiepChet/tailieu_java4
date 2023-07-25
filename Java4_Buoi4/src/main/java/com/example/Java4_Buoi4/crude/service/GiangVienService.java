package com.example.Java4_Buoi4.crude.service;

import com.example.Java4_Buoi4.crude.etity.GiangVien;

import java.util.List;

public interface GiangVienService {

    List<GiangVien> fakeData();

    void removeGiangVien(List<GiangVien> lists, String ma);

    GiangVien findGiangVienbyMa(List<GiangVien> lists, String ma);

    int viTriGiangVien(List<GiangVien> lists, String ma);

}
