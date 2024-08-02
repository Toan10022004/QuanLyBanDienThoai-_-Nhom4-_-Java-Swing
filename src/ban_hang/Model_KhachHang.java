/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ban_hang;

/**
 *
 * @author PC
 */
public class Model_KhachHang {
    private int maKH;
    private String tenKH;
    private String sdt;
    private String email;
    private String diaChi;

    public Model_KhachHang() {
    }

    public Model_KhachHang(int maKH, String tenKH, String sdt, String email, String diaChi) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.sdt = sdt;
        this.email = email;
        this.diaChi = diaChi;
    }

    public Model_KhachHang(String tenKH, String sdt, String email, String diaChi) {
        this.tenKH = tenKH;
        this.sdt = sdt;
        this.email = email;
        this.diaChi = diaChi;
    }

    public int getMaKH() {
        return maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public String getSdt() {
        return sdt;
    }

    public String getEmail() {
        return email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    
    public Object[] toDataRow(){
       return new Object[]{this.getMaKH(),this.getTenKH(),this.getSdt(),this.getEmail(),this.getDiaChi()};
    }
}
