/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ban_hang;

/**
 *
 * @author PC
 */
public class Model_SanPham {
    private int id;
    private String anhSP;
    private String maSP;
    private String tenSP;
    private String trangThai;
    private String ngayTao;
    private String tenHang;
    private String loaiSP;

    public Model_SanPham() {
    }

    public Model_SanPham(int id, String anhSP, String maSP, String tenSP, String trangThai, String ngayTao, String tenHang, String loaiSP) {
        this.id = id;
        this.anhSP = anhSP;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.trangThai = trangThai;
        this.ngayTao = ngayTao;
        this.tenHang = tenHang;
        this.loaiSP = loaiSP;
    }

    public Model_SanPham(String anhSP, String maSP, String tenSP, String trangThai, String ngayTao, String tenHang, String loaiSP) {
        this.anhSP = anhSP;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.trangThai = trangThai;
        this.ngayTao = ngayTao;
        this.tenHang = tenHang;
        this.loaiSP = loaiSP;
    }

    public int getId() {
        return id;
    }

    public String getAnhSP() {
        return anhSP;
    }

    public String getMaSP() {
        return maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public String getTenHang() {
        return tenHang;
    }

    public String getLoaiSP() {
        return loaiSP;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAnhSP(String anhSP) {
        this.anhSP = anhSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public void setLoaiSP(String loaiSP) {
        this.loaiSP = loaiSP;
    }
    public Object[] toDataRow(){
       return new Object[]{this.getId(),this.getMaSP(),this.getTenSP(),this.getTrangThai(),this.getTenHang(),this.getLoaiSP(),this.getNgayTao()};
    }
    
    
}
