/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hung;

import java.util.Vector;

/**
 *
 * @author admin
 */
public class Model_khachhang {
  private int MaKH ;
  private String TenKH ;
  private String SDT ;
  private String Email;
  private String DiaChi ;

    public Model_khachhang() {
    }

    public Model_khachhang(int MaKH, String TenKH, String SDT, String Email, String DiaChi) {
        this.MaKH = MaKH;
        this.TenKH = TenKH;
        this.SDT = SDT;
        this.Email = Email;
        this.DiaChi = DiaChi;
    }

    public int getMaKH() {
        return MaKH;
    }

    public void setMaKH(int MaKH) {
        this.MaKH = MaKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

  public Object[] toDataRow() {
        return new Object[]{MaKH, TenKH, SDT, Email, DiaChi};
    }
  
  
}
