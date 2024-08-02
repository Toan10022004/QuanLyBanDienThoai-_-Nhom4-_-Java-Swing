/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thinh;

/**
 *
 * @author thinh
 */
public class HoaDon {
    public String MaHD;
    public String TenKH;
    public String TenSP;
    public Integer SoLuong;
    public String GhiChu;
    public Integer ThanhTien;

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

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public Integer getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(Integer ThanhTien) {
        this.ThanhTien = ThanhTien;
    }

    public HoaDon(String MaHD, String TenKH, String TenSP, Integer SoLuong, String GhiChu, Integer ThanhTien) {
        this.MaHD = MaHD;
        this.TenKH = TenKH;
        this.TenSP = TenSP;
        this.SoLuong = SoLuong;
        this.GhiChu = GhiChu;
        this.ThanhTien = ThanhTien;
    }

    public HoaDon() {
    }
    public Object[] toRowTable() {
        return new Object[] {
            this.getMaHD(),
            this.getTenKH(),
            this.getTenSP(),
            this.getSoLuong(),
            this.getGhiChu(),
            this.getThanhTien(),
        } ;
}
}