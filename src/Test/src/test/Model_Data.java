/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test.src.test;

/**
 *
 * @author PC
 */
public class Model_Data {
    private String thang;
    private double doanhThu;
    private int soLuong;
    private int soDon;

    public Model_Data(String thang, double doanhThu, int soLuong, int soDon) {
        this.thang = thang;
        this.doanhThu = doanhThu;
        this.soLuong = soLuong;
        this.soDon = soDon;
    }

    public Model_Data() {
    }

    public String getThang() {
        return thang;
    }

    public double getDoanhThu() {
        return doanhThu;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public int getSoDon() {
        return soDon;
    }

    public void setThang(String thang) {
        this.thang = thang;
    }

    public void setDoanhThu(double doanhThu) {
        this.doanhThu = doanhThu;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setSoDon(int soDon) {
        this.soDon = soDon;
    }
    
}
