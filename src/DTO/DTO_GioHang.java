/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import Model.*;
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
public class DTO_GioHang {
    private int maHD;
    private String tenSP;
    private String tenHang;
    private String tenLoaiSP;
    private String mauSac;
    private int soLuong;
    private BigDecimal giaBan;
    
}
