/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

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
public class MD_SanPham_CN {
    private int idSanPham;
    private String anhSanPham;
    private String maSanPham;
    private String tenSanPham;
    private String trangThai;
    private Date ngayTao;
    private Date ngaySua;
    private int hang;
    private int loaiSanPham;
    private String moTa;
}
