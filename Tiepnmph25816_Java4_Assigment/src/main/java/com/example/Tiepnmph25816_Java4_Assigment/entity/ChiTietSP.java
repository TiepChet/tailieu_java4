package com.example.Tiepnmph25816_Java4_Assigment.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "ChiTietSP")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ChiTietSP implements Serializable {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy =  GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "IdSP",referencedColumnName = "Id")
    private SanPham sanPham;

    @ManyToOne
    @JoinColumn(name = "IdNsx",referencedColumnName = "Id")
    private NhaSanXuat nhaSanXuat;

    @ManyToOne
    @JoinColumn(name = "IdMauSac",referencedColumnName = "Id")
    private MauSac mauSac;

    @ManyToOne
    @JoinColumn(name = "IdDongSP",referencedColumnName = "Id")
    private DongSP dongSP;

    @Column(name = "NamBH")
    private int namBH;

    @Column(name = "MoTa")
    private String moTa;

    @Column(name = "SoLuongTon")
    private int soLuongTon;

    @Column(name = "GiaNhap")
    private Float giaNhap;

    @Column(name = "GiaBan")
    private Float giaBan;

}
