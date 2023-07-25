package com.example.sell_clothing_api.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
@Table(name = "sanpham")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "masanpham")
    private BigInteger maSanPham;

    @Column(name = "tensanpham")
    private String tenSanPham;

    @Column(name = "chatlieu")
    private String chatLieu;

    @Column(name = "giahienhanh")
    private BigDecimal giaHienHanh;

    @Column(name = "soluongton")
    private Integer soLuongTon;

    @Column(name = "mota")
    private String moTa;

    @Column(name = "loaisanpham")
    private String loaiSanPham;

    @Column(name = "mausac")
    private String mauSac;

    @Column(name = "nhasanxuat")
    private String nhaSanXuat;

    @Column(name = "trangthai")
    private Integer trangThai;

    @Column(name = "hinhanh")
    private String hinhAnh;


}
