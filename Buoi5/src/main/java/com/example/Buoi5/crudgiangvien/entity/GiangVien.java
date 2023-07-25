package com.example.Buoi5.crudgiangvien.entity;

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
    private String queQuan;
}

