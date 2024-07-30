/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author 84904
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DTO_SanPham_CTSP {

    private int idSanPham;
    private String maSanPham;
    private String anhSanPham;
    private String tenSanPham;
    private String tenHang;
    private String tenLoaiSP;
    private String trangThai;
    private String moTa;
    private Date ngayTao;
    private Date ngaySua;

    private int idCtsp;
//    private String MaSP;
    private String mauSac;
    private int soLuongTon;
    private String moTaCtSP;
    private String trangThaiCTSP;
    private BigDecimal giaBan;
    private Date ngayTaoCTSP;
    private Date ngaySuaCTSP;
}
