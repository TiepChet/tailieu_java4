package com.example.Java4_Buoi4.crude.etity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class GiangVien {

    private int id;
    private String ma;
    private String ten;
    private int tuoi;
    private String diaChi;
    private boolean gioiTinh;

}
