package com.example.LuyenTapJava4.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;


@Entity
@Table(name = "thuc_vat")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ThucVat {

    @Id
    @Column(name = "ma")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID ma;

    @Column(name = "ten")
    private String ten;

    @Column(name = "tuoi")
    private int tuoi;

    @Column(name = "gioi_tinh")
    private Boolean gioiTinh;

    @Column(name = "khu_vuc_song")
    private String khuVucSong;

    @Column(name = "loai")
    private String loai;
}
