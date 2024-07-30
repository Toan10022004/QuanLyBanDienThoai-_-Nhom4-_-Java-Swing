/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
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
public class DTO_DanhSachSanPham {
    private int idSanPham;
    private String maSanPham;
    private String anhSanPham;
    private String tenSanPham;
    private String tenLoaiSP;
    private String tenHang;
    private String moTa;
    private String trangThai;
    private Date ngayTao;
    private Date ngaySua;
}
