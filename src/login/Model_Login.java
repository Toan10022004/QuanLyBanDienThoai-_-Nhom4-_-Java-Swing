/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login;

/**
 *
 * @author PC
 */
public class Model_Login {
    private String maNV;
    private String tenNV;
    private int gioiTinh;
    private String queQuan;
    private String diaChi;
    private String ngaLamViec;
    private String quyenHan;
    private String matKhau;

    public Model_Login(String maNV, String tenNV, int gioiTinh, String queQuan, String diaChi, String ngaLamViec, String quyenHan, String matKhau) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.gioiTinh = gioiTinh;
        this.queQuan = queQuan;
        this.diaChi = diaChi;
        this.ngaLamViec = ngaLamViec;
        this.quyenHan = quyenHan;
        this.matKhau = matKhau;
    }

    public Model_Login() {
    }

    public String getMaNV() {
        return maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getNgaLamViec() {
        return ngaLamViec;
    }

    public String getQuyenHan() {
        return quyenHan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setNgaLamViec(String ngaLamViec) {
        this.ngaLamViec = ngaLamViec;
    }

    public void setQuyenHan(String quyenHan) {
        this.quyenHan = quyenHan;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
    
    
}
