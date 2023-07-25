package com.example.Java4_Buoi3.hienthijavaweb.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GiangVien {

    private int id;
    private String ma;
    private String ten;
    private int tuoi;
    private boolean gioiTinh;
    private String diaChi;

}
