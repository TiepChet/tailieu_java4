package com.example.Java4_Buoi4.crude.service.impl;

import com.example.Java4_Buoi4.crude.etity.GiangVien;
import com.example.Java4_Buoi4.crude.service.GiangVienService;

import java.util.ArrayList;
import java.util.List;

public class GiangVienServiceImpl implements GiangVienService {
    @Override
    public List<GiangVien> fakeData() {
        List<GiangVien> giangVien = new ArrayList<>();
        giangVien.add(new GiangVien(1, "HangNT169", "a", 3, "Ha Noi", false));
        giangVien.add(new GiangVien(2, "NguyenVV4", "b", 4, "Thai Binh", true));
        giangVien.add(new GiangVien(3, "PhongTT35", "c", 5, "Ha Noi", true));
        giangVien.add(new GiangVien(4, "KhanhPG", "d", 7, "Ha Noi", true));
        giangVien.add(new GiangVien(5, "TienNH21", "e", 10, "Ha Noi", true));
        return giangVien;
    }

    @Override
    public void removeGiangVien(List<GiangVien> lists, String ma) {
        int viTriRemove = findGiangVien(lists, ma);
        lists.remove(viTriRemove);
    }`

    @Override
    public GiangVien findGiangVienbyMa(List<GiangVien> lists, String ma) {
        int viTriTimDuoc = findGiangVien(lists, ma);
        return lists.get(viTriTimDuoc);
    }

    @Override
    public int viTriGiangVien(List<GiangVien> lists, String ma) {
        return findGiangVien(lists, ma);
    }


    private int findGiangVien(List<GiangVien> lists, String ma) {
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i).getMa().equalsIgnoreCase(ma)) {
                return i;
            }
        }
        return -1;
    }
}
