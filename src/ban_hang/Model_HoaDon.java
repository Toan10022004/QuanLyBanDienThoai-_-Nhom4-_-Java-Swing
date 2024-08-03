/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ban_hang;

/**
 *
 * @author PC
 */
public class Model_HoaDon {
    private int maHD;
    private int maDH;
    private int maKH;
    private int thanhTien;
    private String trangThai;
    private String ngayTao;

    public Model_HoaDon(int maHD, int maDH, int maKH, int thanhTien, String trangThai, String ngayTao) {
        this.maHD = maHD;
        this.maDH = maDH;
        this.maKH = maKH;
        this.thanhTien = thanhTien;
        this.trangThai = trangThai;
        this.ngayTao = ngayTao;
    }
  

    public Model_HoaDon(int maDH, int maKH, int thanhTien, String trangThai) {
        this.maDH = maDH;
        this.maKH = maKH;
        this.thanhTien = thanhTien;
        this.trangThai = trangThai;
    }

    public Model_HoaDon(String trangThai) {
        this.trangThai = trangThai;
    }

    public Model_HoaDon(int maDH, int maKH, int thanhTien, String trangThai, String ngayTao) {
        this.maDH = maDH;
        this.maKH = maKH;
        this.thanhTien = thanhTien;
        this.trangThai = trangThai;
        this.ngayTao = ngayTao;
    }

    public Model_HoaDon() {
    }

  
    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }
    public int getMaDH() {
        return maDH;
    }

    public int getMaKH() {
        return maKH;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setMaDH(int maDH) {
        this.maDH = maDH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Object[] toDataRow(){
       return new Object[]{this.getMaHD(),this.getMaKH(),this.getMaDH(),this.getThanhTien(),this.getTrangThai(),this.getNgayTao()};
    }
}
