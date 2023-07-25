package com.example.LuyenTapBuoi5.entity;


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
@Table(name = "tac_gia")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TacGia {
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

    @Column(name = "loai_sach_viet")
    private String loaiSachViet;
}
