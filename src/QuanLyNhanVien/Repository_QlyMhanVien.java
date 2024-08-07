/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyNhanVien;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Repository_QlyMhanVien {
    private Connection con = null; //kết nối
    private PreparedStatement ps = null; //chuẩn bị thực hiện lệnh
    private ResultSet rs = null; //tập kq truy vấn
    private String sql = null;
    
    public ArrayList<Model_QlyNhanVien> getAll(){
        sql="select MaNV,TenNV,GioiTinh,DiaChi,QuyenHan,matkhau from NhanVien";
        ArrayList<Model_QlyNhanVien> list_NhanVien = new ArrayList();
        try {
            con=DBConnect.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            // lấy dl từ tập kq chuyển sang list
            while(rs.next()){
                boolean gioiTinh;
                String manv,tennv,diachi,quyenhan,matkhau;
                manv = rs.getString(1);
                tennv= rs.getString(2);
                gioiTinh = rs.getBoolean(3);
                diachi = rs.getString(4);
                quyenhan = rs.getString(5);
                matkhau = rs.getString(6);
                Model_QlyNhanVien ml = new Model_QlyNhanVien(manv, tennv, gioiTinh, diachi, quyenhan,matkhau);
                list_NhanVien.add(ml);
            }// đóng while sau khi lấy hết dl từ tập kq
            return list_NhanVien;
        } catch (Exception e) { // k két nối đc
            e.printStackTrace();// tb lỗi
            return null;
        }
    }
    
    
    public int themNhanVien(Model_QlyNhanVien ml) {
        //ml là đối tượng mới nhập từ form
        sql = "insert into NhanVien(MaNV,TenNV,GioiTinh,DiaChi,QuyenHan,matkhau) values (?,?,?,?,?,?)";
        try {// thêm được
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            // nếu trong sql có ? thì phải setObject
            ps.setObject(1, ml.getMaNv());
            ps.setObject(2, ml.getTenNv());
            ps.setObject(3, ml.isGioiTinh());        
            ps.setObject(4, ml.getDiaChi());
            ps.setObject(5, ml.getQuyenHan());
            ps.setObject(6, ml.getMatKhau());
            return ps.executeUpdate();
// thêm/sửa/xóa dùng executeUpdate()
        } catch (Exception e) {//không thêm được
            e.printStackTrace();
            return 0;
        }
    }
    
    public int suaNhanVien(String maNvCanSua, Model_QlyNhanVien ml){
    sql="update NhanVien set MaNV=?,TenNV=?,GioiTinh=?,DiaChi=?,QuyenHan=?,matkhau=?\n" +
"where MaNV=?";
    try {
        con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            // có ? thì phải set
            ps.setObject(1, ml.getMaNv());
            ps.setObject(2, ml.getTenNv());
            ps.setObject(3, ml.isGioiTinh());        
            ps.setObject(4, ml.getDiaChi());
            ps.setObject(5, ml.getQuyenHan());
            ps.setObject(6, ml.getMatKhau());
            ps.setObject(7, maNvCanSua);
            return ps.executeUpdate();// thêm/sửa/xóa executeUpdate()
        
    } catch (Exception e) {
        e.printStackTrace();
        return 0;
    }
    }
    
    public int xoaNhanVien(String xoaMaNv) {
        sql = "delete from NhanVien\n"
                + "where MaNV=?";
        try {// xóa dl ok
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            // có ? thì phải set
            ps.setObject(1, xoaMaNv);
            return ps.executeUpdate();// thêm/sửa/xóa executeUpdate()
        } catch (Exception e) {// k xóa được
            e.printStackTrace();
            return 0;
        }
    }
    
    public ArrayList<Model_QlyNhanVien> timTen(String tenCanTim){
        sql="Select MaNV,TenNV,GioiTinh,DiaChi,NgayLamViec,QuyenHan,matkhau from NhanVien " +
"where TenNv like ?";
        ArrayList<Model_QlyNhanVien> list_NhanVien = new ArrayList();
        try {
            con=DBConnect.getConnection();
            ps=con.prepareStatement(sql);
            ps.setObject(1, "%"+tenCanTim+"%");
            rs=ps.executeQuery();
            // lấy dl từ tập kq chuyển sang list
            while(rs.next()){
                boolean gioiTinh;
                String manv,tennv,diachi,ngaylamviec,quyenhan,matkhau = null;
                manv = rs.getString(1);
                tennv= rs.getString(2);
                gioiTinh = rs.getBoolean(3);
                diachi = rs.getString(4);
                quyenhan = rs.getString(6);
                Model_QlyNhanVien ml = new Model_QlyNhanVien(manv, tennv, gioiTinh, diachi, quyenhan,matkhau);
                list_NhanVien.add(ml);
            }// đóng while sau khi lấy hết dl từ tập kq
            return list_NhanVien;
        } catch (Exception e) { // k két nối đc
            e.printStackTrace();// tb lỗi
            return null;
        }
    }
}
