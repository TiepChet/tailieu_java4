package com.fpt.poly.lab.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "giang_vien")
public class GiangVien {

    @Id
    @Column(name = "mssv")
    private String ma;

    @Column(name = "ten")
    private String ten;

    @Column(name = "tuoi")
    private int tuoi;

    @Column(name = "gioi_tinh")
    private boolean gioiTinh;

    @Column(name = "que_quan")
    private String queQuan;
}
