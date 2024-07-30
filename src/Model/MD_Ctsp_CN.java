/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

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
public class MD_Ctsp_CN {
    private int idCtsp;
    private int idSanPham;
//    private String imeiMay;
    private String mauSac;
    private BigDecimal giaBan;
    private int soLuongTon;
    private String trangThai;
    private String moTa;
    private Date ngayTao;
    private Date ngaySua;
}
