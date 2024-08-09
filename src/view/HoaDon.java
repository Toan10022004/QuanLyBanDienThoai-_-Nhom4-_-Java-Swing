/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author thinh
 */
public class HoaDon {
    public String MaHD;
    public String TenKH;
    public String TenSP;
    public Integer SoLuong;
    public String TrangThai;
    public Integer TongTien;

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public Integer getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(Integer SoLuong) {
        this.SoLuong = SoLuong;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public Integer getTongTien() {
        return TongTien;
    }

    public void setTongTien(Integer TongTien) {
        this.TongTien = TongTien;
    }

    public HoaDon(String MaHD, String TenKH, String TenSP, Integer SoLuong, String TrangThai, Integer TongTien) {
        this.MaHD = MaHD;
        this.TenKH = TenKH;
        this.TenSP = TenSP;
        this.SoLuong = SoLuong;
        this.TrangThai = TrangThai;
        this.TongTien = TongTien;
    }

    public HoaDon() {
    }
    public Object[] toRowTable() {
        return new Object[] {
            this.getMaHD(),
            this.getTenKH(),
            this.getTenSP(),
            this.getSoLuong(),
            this.getTrangThai(),
            this.getTongTien(),
        } ;
}
}