/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ban_hang;

/**
 *
 * @author PC
 */
public class Model_QuanLyDonHang {
    private int maDH;
    private int maKH;
    private String tenKH;
    private int idSP;
    private String tenSP;
    private int soLuong;
    private int thanhTien;
    private String ngayDatHang;
    private String trangThai;

    public Model_QuanLyDonHang() {
    }

    public Model_QuanLyDonHang(int maDH, int maKH, String tenKH, int idSP, String tenSP, int soLuong, int thanhTien, String ngayDatHang, String trangThai) {
        this.maDH = maDH;
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.idSP = idSP;
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
        this.ngayDatHang = ngayDatHang;
        this.trangThai = trangThai;
    }

    public Model_QuanLyDonHang(int maDH, int maKH, int idSP, int soLuong, int thanhTien, String ngayDatHang, String trangThai) {
        this.maDH = maDH;
        this.maKH = maKH;
        this.idSP = idSP;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
        this.ngayDatHang = ngayDatHang;
        this.trangThai = trangThai;
    }

    public Model_QuanLyDonHang(int soLuong) {
        this.soLuong = soLuong;
    }

    public Model_QuanLyDonHang(int maKH, int idSP, int soLuong, String trangThai) {
        this.maKH = maKH;
        this.idSP = idSP;
        this.soLuong = soLuong;
        this.trangThai = trangThai;
    }

    public int getMaDH() {
        return maDH;
    }

    public int getMaKH() {
        return maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public int getIdSP() {
        return idSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public String getNgayDatHang() {
        return ngayDatHang;
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

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public void setIdSP(int idSP) {
        this.idSP = idSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }

    public void setNgayDatHang(String ngayDatHang) {
        this.ngayDatHang = ngayDatHang;
    }

    public Model_QuanLyDonHang(String trangThai) {
        this.trangThai = trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    public Object[] toDataRow(){
       return new Object[]{this.getMaDH(),this.getMaKH(),this.getIdSP(),this.getSoLuong(),this.getThanhTien(),this.getNgayDatHang(),this.getTrangThai(),this.getTenKH(),this.getTenSP()};
    }
}
