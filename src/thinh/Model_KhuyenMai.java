/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thinh;

/**
 *
 * @author thinh
 */
public class Model_KhuyenMai {
    private String MaKM;
    private String TenKM;
    private String DieuKien;
    private String PhanTramKM;
    private String NgayBD;
    private String NgayKT;

    public String getMaKM() {
        return MaKM;
    }

    public void setMaKM(String MaKM) {
        this.MaKM = MaKM;
    }

    public String getTenKM() {
        return TenKM;
    }

    public void setTenKM(String TenKM) {
        this.TenKM = TenKM;
    }

    public String getDieuKien() {
        return DieuKien;
    }

    public void setDieuKien(String DieuKien) {
        this.DieuKien = DieuKien;
    }

    public String getPhanTramKM() {
        return PhanTramKM;
    }

    public void setPhanTramKM(String PhanTramKM) {
        this.PhanTramKM = PhanTramKM;
    }

    public String getNgayBD() {
        return NgayBD;
    }

    public void setNgayBD(String NgayBD) {
        this.NgayBD = NgayBD;
    }

    public String getNgayKT() {
        return NgayKT;
    }

    public void setNgayKT(String NgayKT) {
        this.NgayKT = NgayKT;
    }

    public Model_KhuyenMai(String MaKM, String TenKM, String DieuKien, String PhanTramKM, String NgayBD, String NgayKT) {
        this.MaKM = MaKM;
        this.TenKM = TenKM;
        this.DieuKien = DieuKien;
        this.PhanTramKM = PhanTramKM;
        this.NgayBD = NgayBD;
        this.NgayKT = NgayKT;
    }

    public Model_KhuyenMai() {
    }
    public Object[] toRowTable() {
    return new Object[]{this.MaKM, this.TenKM, this.DieuKien, this.PhanTramKM, this.NgayBD, this.NgayKT};
}
}
    