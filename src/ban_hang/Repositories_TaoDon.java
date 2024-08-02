/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ban_hang;
import java.sql.*;

import java.util.ArrayList;
/**
 *
 * @author PC
 */
public class Repositories_TaoDon {
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;
    public ArrayList<Model_SanPham> getAll(){
        sql = "select  san_pham.id_san_pham,san_pham.ma_san_pham,san_pham.ten_san_pham,san_pham.trang_thai,hang.ten_Hang,loaisp.ten_LSP,san_pham.ngay_tao,san_pham.anh_san_pham\n" +
"from san_pham\n" +
"inner join hang on san_pham.id_Hang = hang.id_Hang\n" +
"inner join loaisp on san_pham.id_LSP = loaisp.id_LSP";
        ArrayList<Model_SanPham> list_TaoDon = new ArrayList<>();
        try{
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(); //chạy câu lệnh select
            while(rs.next()){
                 int id;
                 String anhSP;
                 String maSP;
                 String tenSP;
                 String trangThai;
                 String ngayTao;
                 String tenHang;
                 String loaiSP;
                id = rs.getInt(1);//;ấy theo thứ tự(lấy theo cột) 
                //cách 2: id = rs.getInt("id"); lấy theo tên
                maSP = rs.getString(2);
                tenSP = rs.getString(3);
                trangThai = rs.getString(4);
                tenHang = rs.getString(5);
                loaiSP = rs.getString(6);
                ngayTao = rs.getString(7);
                anhSP = rs.getString(8);
                Model_SanPham m = new Model_SanPham(id, anhSP, maSP, tenSP, trangThai, ngayTao, tenHang, loaiSP);
                list_TaoDon.add(m);
                
            }
            return list_TaoDon;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public ArrayList<Model_KhachHang> getAllKH(){
        sql = "select MaKH,TenKH,SDT,Email,DiaChi from QuanLyKhachhang";
    ArrayList<Model_KhachHang> list_KhachHang = new ArrayList<>();
        try{
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(); //chạy câu lệnh select
            while(rs.next()){
                int maKH;
                String tenKH;
                String sdt;
                String email;
                String diaChi;
                maKH = rs.getInt(1);//;ấy theo thứ tự(lấy theo cột) 
                //cách 2: id = rs.getInt("id"); lấy theo tên
                tenKH = rs.getString(2);
                sdt = rs.getString(3);
                email = rs.getString(4);
                diaChi = rs.getString(5);               
                Model_KhachHang k = new Model_KhachHang(maKH, tenKH, sdt, email, diaChi);
                list_KhachHang.add(k);
                
            }
            return list_KhachHang;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public int ThemKhachHang(Model_KhachHang KH){
        //lấy đối tượng m từ form thêm vào database
        sql = "INSERT INTO QuanLyKhachHang (TenKH, SDT, Email, DiaChi)\n" +
"VALUES(?,?,?,?)";
        try{
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, KH.getTenKH()); //số 1 tương ứng với dấu hỏi chấm đầu tiên
            ps.setObject(2, KH.getSdt());
            ps.setObject(3, KH.getEmail());
            ps.setObject(4, KH.getDiaChi());
            return ps.executeUpdate();
            //update, dalete,insert: đểu dùng câu lệnh executeUpdate()
        }catch(Exception e){ // ko thêm đc
            e.printStackTrace();
            return 0;
        }
    }
    public int ThemDonHang(Model_QuanLyDonHang DH){
        //lấy đối tượng m từ form thêm vào database
        sql = "INSERT INTO QuanLyDonHang (MaKH, IdSP, SoLuong, TrangThai)\n" +
"VALUES(?,?,?,?)";
        try{
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, DH.getTenKH()); //số 1 tương ứng với dấu hỏi chấm đầu tiên
            ps.setObject(2, DH.getIdSP());
            ps.setObject(3, DH.getSoLuong());
            ps.setObject(4, DH.getTrangThai());
            return ps.executeUpdate();
            //update, dalete,insert: đểu dùng câu lệnh executeUpdate()
        }catch(Exception e){ // ko thêm đc
            e.printStackTrace();
            return 0;
        }
    }
//    public ArrayList<Model_KhachHang> getAllKH(){
//        sql = "select  san_pham.id_san_pham,san_pham.ma_san_pham,san_pham.ten_san_pham,san_pham.trang_thai,hang.ten_Hang,loaisp.ten_LSP,san_pham.ngay_tao,san_pham.anh_san_pham\n" +
//"from san_pham\n" +
//"inner join hang on san_pham.id_Hang = hang.id_Hang\n" +
//"inner join loaisp on san_pham.id_LSP = loaisp.id_LSP";
//        ArrayList<Model_SanPham> list_TaoDon = new ArrayList<>();
//        try{
//            con = DBConnect.getConnection();
//            ps = con.prepareStatement(sql);
//            rs = ps.executeQuery(); //chạy câu lệnh select
//            while(rs.next()){
//                 int id;
//                 String anhSP;
//                 String maSP;
//                 String tenSP;
//                 String trangThai;
//                 String ngayTao;
//                 String tenHang;
//                 String loaiSP;
//                id = rs.getInt(1);//;ấy theo thứ tự(lấy theo cột) 
//                //cách 2: id = rs.getInt("id"); lấy theo tên
//                maSP = rs.getString(2);
//                tenSP = rs.getString(3);
//                trangThai = rs.getString(4);
//                tenHang = rs.getString(5);
//                loaiSP = rs.getString(6);
//                ngayTao = rs.getString(7);
//                anhSP = rs.getString(8);
//                Model_SanPham m = new Model_SanPham(id, anhSP, maSP, tenSP, trangThai, ngayTao, tenHang, loaiSP);
//                list_TaoDon.add(m);
//                
//            }
//            return list_TaoDon;
//        }catch(Exception e){
//            e.printStackTrace();
//            return null;
//        }
//}
    public ArrayList<Model_SanPham> timKiem(String tencantim){
        sql = "select  san_pham.id_san_pham,san_pham.ma_san_pham,san_pham.ten_san_pham,san_pham.trang_thai,hang.ten_Hang,loaisp.ten_LSP,san_pham.ngay_tao,san_pham.anh_san_pham\n" +
"from san_pham\n" +
"inner join hang on san_pham.id_Hang = hang.id_Hang\n" +
"inner join loaisp on san_pham.id_LSP = loaisp.id_LSP\n" +
"where san_pham.ten_san_pham = ?";
        ArrayList<Model_SanPham> list_SanPham = new ArrayList<>();
        try{
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, tencantim);
            rs = ps.executeQuery(); //chạy câu lệnh select
            while(rs.next()){
                 int id;
                 String anhSP;
                 String maSP;
                 String tenSP;
                 String trangThai;
                 String ngayTao;
                 String tenHang;
                 String loaiSP;
                id = rs.getInt(1);//;ấy theo thứ tự(lấy theo cột) 
                //cách 2: id = rs.getInt("id"); lấy theo tên
                maSP = rs.getString(2);
                tenSP = rs.getString(3);
                trangThai = rs.getString(4);
                tenHang = rs.getString(5);
                loaiSP = rs.getString(6);
                ngayTao = rs.getString(7);
                anhSP = rs.getString(8);
                Model_SanPham m = new Model_SanPham(id, anhSP, maSP, tenSP, trangThai, ngayTao, tenHang, loaiSP);
                list_SanPham.add(m);
                
            }
            return list_SanPham;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}