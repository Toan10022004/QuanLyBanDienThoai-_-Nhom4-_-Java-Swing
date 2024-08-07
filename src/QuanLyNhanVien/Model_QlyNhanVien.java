/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyNhanVien;


/**
 *
 * @author Admin
 */
public class Model_QlyNhanVien {
    private String MaNv;
    private String TenNv;
    private boolean gioiTinh;
    private String DiaChi;
    private String quyenHan;
    private String matKhau;

    public Model_QlyNhanVien() {
    }

    public Model_QlyNhanVien(String MaNv, String TenNv, boolean gioiTinh, String DiaChi, String quyenHan, String matKhau) {
        this.MaNv = MaNv;
        this.TenNv = TenNv;
        this.gioiTinh = gioiTinh;
        this.DiaChi = DiaChi;
        this.quyenHan = quyenHan;
        this.matKhau = matKhau;
    }

    

    public String getMaNv() {
        return MaNv;
    }

    public void setMaNv(String MaNv) {
        this.MaNv = MaNv;
    }

    public String getTenNv() {
        return TenNv;
    }

    public void setTenNv(String TenNv) {
        this.TenNv = TenNv;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }


    public String getQuyenHan() {
        return quyenHan;
    }

    public void setQuyenHan(String quyenHan) {
        this.quyenHan = quyenHan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
    
    
    
    public Object[] toDataRow(){
        return new Object[]{
        this.getTenNv(),
        this.getMaNv(),
        this.isGioiTinh()?"Nam":"Nữ",
        this.getDiaChi(),
        this.getQuyenHan(),
        this.getMatKhau()
    };
                
    }
    
}
