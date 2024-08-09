/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author thinh
 */
public class HoaDonChiTiet {
    public String MaHD;
    public String MaSp;
    public Integer SoLuong;
    public Integer Gia;
    public Integer TongTien;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(String MaHD, String MaSp, Integer SoLuong, Integer Gia, Integer TongTien) {
        this.MaHD = MaHD;
        this.MaSp = MaSp;
        this.SoLuong = SoLuong;
        this.Gia = Gia;
        this.TongTien = TongTien;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getMaSp() {
        return MaSp;
    }

    public void setMaSp(String MaSp) {
        this.MaSp = MaSp;
    }

    public Integer getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(Integer SoLuong) {
        this.SoLuong = SoLuong;
    }

    public Integer getGia() {
        return Gia;
    }

    public void setGia(Integer Gia) {
        this.Gia = Gia;
    }

    public Integer getTongTien() {
        return TongTien;
    }

    public void setTongTien(Integer TongTien) {
        this.TongTien = TongTien;
    }
    public Object[] toRowTable() {
        return new Object[] {
            this.getMaHD(),
            this.getMaSp(),
            this.getSoLuong(),
            this.getGia(),
            this.getTongTien()
        } ;
}
}