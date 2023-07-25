package com.example.Buoi5.crudgiangvien.service.impl;

import com.example.Buoi5.crudgiangvien.entity.GiangVien;
import com.example.Buoi5.crudgiangvien.service.GiangVienService;

import java.util.ArrayList;
import java.util.List;

public class GiangVienServiceImpl implements GiangVienService {
    @Override
    public List<GiangVien> getAll() {
        List<GiangVien> listGiangVien = new ArrayList<>();
        listGiangVien.add(new GiangVien(1, "anv", "a", 1, "Thai Binh"));
        listGiangVien.add(new GiangVien(2, "bnv", "b", 2, "Ha Noi"));
        listGiangVien.add(new GiangVien(3, "cnv", "c", 3, "Thai Binh"));
        listGiangVien.add(new GiangVien(4, "dnv", "d", 4, "Ha Noi"));
        return listGiangVien;
    }

    @Override
    public GiangVien detailGiangVien(List<GiangVien> list, int id) {
        int viTri = viTriTimDuoc(list, id);
        return list.get(viTri);
    }

    @Override
    public GiangVien updateGiangVien(List<GiangVien> list, int id) {
        int viTri = viTriTimDuoc(list, id);
        return list.get(viTri);
    }

    @Override
    public int viTriUpdate(List<GiangVien> list, int id) {
        int viTri = viTriTimDuoc(list, id);
        return viTri;
    }

    @Override
    public void removeGiangVien(List<GiangVien> list, int id) {
        int viTri = viTriTimDuoc(list, id);
        list.remove(viTri);
    }

    @Override
    public List<GiangVien> sortTuoi(List<GiangVien> list) {
        list.sort((o1, o2) -> o2.getTuoi() - o1.getTuoi());
        return list;
    }

    @Override
    public List<GiangVien> searchGiangVien(List<GiangVien> list, String ten, int min, int max) {
        List<GiangVien> listGiangVien = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getTen().equalsIgnoreCase(ten) || min <= list.get(i).getTuoi() && max >= list.get(i).getTuoi()) {
                listGiangVien.add(list.get(i));
            }
        }
        return listGiangVien;
    }


    @Override
    public List<GiangVien> queQuan(List<GiangVien> list, String queQuan) {
        List<GiangVien> listGiangVien = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getQueQuan().equalsIgnoreCase(queQuan)) {
                listGiangVien.add(list.get(i));
            }
        }
        return listGiangVien;
    }

    private int viTriTimDuoc(List<GiangVien> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
}
