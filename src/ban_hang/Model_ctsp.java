/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ban_hang;

/**
 *
 * @author PC
 */
public class Model_ctsp {
    private int id;
    private int idSP;
//    private int imei;
    private String mauSac;
    private int giaBan;
    private int soLuongTon;
    private String trangThai;
    private String moTa;
    private String ngayTao;
    private String ngaySua;

    public Model_ctsp() {
    }

    public Model_ctsp(int id, int idSP, String mauSac, int giaBan, int soLuongTon, String trangThai, String moTa, String ngayTao, String ngaySua) {
        this.id = id;
        this.idSP = idSP;
//        this.imei = imei;
        this.mauSac = mauSac;
        this.giaBan = giaBan;
        this.soLuongTon = soLuongTon;
        this.trangThai = trangThai;
        this.moTa = moTa;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
    }

    public int getId() {
        return id;
    }

    public int getIdSP() {
        return idSP;
    }

//    public int getImei() {
//        return imei;
//    }

    public String getMauSac() {
        return mauSac;
    }

    public int getGiaBan() {
        return giaBan;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public String getMoTa() {
        return moTa;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public String getNgaySua() {
        return ngaySua;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdSP(int idSP) {
        this.idSP = idSP;
    }
//
//    public void setImei(int imei) {
//        this.imei = imei;
//    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public void setGiaBan(int giaBan) {
        this.giaBan = giaBan;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public void setNgaySua(String ngaySua) {
        this.ngaySua = ngaySua;
    }
    
    public Object[] toDataRow(){
       return new Object[]{this.getId(),this.getIdSP(),this.getMauSac(),this.getGiaBan(),this.getSoLuongTon(),this.getTrangThai(),this.getMoTa(),this.getNgayTao(),this.getNgaySua()};
    }
}
