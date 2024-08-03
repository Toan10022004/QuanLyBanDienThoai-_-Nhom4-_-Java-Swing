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
public class Repositories {
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;
    public ArrayList<Model_QuanLyDonHang> getAll(){
        sql = "select \n" +
"QuanLyDonHang.MaDH,QuanLyKhachHang.MaKH,ctsp.id,QuanLyDonHang.SoLuong,ctsp.gia_ban*QuanLyDonHang.SoLuong as thanhtien,QuanLyDonHang.NgayDatHang,QuanLyDonHang.TrangThai,QuanLyKhachHang.TenKH,san_pham.ten_san_pham\n" +
"from QuanLyDonHang\n" +
"INNER JOIN QuanLyKhachHang ON QuanLyDonHang.MaKH = QuanLyKhachHang.MaKH\n" +
"inner join ctsp ON QuanLyDonHang.IdSP = ctsp.id\n" +
"INNER JOIN san_pham ON ctsp.id_san_pham = san_pham.id_san_pham";
        ArrayList<Model_QuanLyDonHang> list_DonHang = new ArrayList<>();
        try{
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(); //chạy câu lệnh select
            while(rs.next()){
                int maDH;
                int maKH;
                int idSP;
                int soLuong;
                int thanhTien;
                String ngayDatHang;
                String trangThai;
                String tenKH, tenSP;
                maDH = rs.getInt(1);//;ấy theo thứ tự(lấy theo cột) 
                //cách 2: id = rs.getInt("id"); lấy theo tên
                maKH = rs.getInt(2);
                idSP = rs.getInt(3);
                soLuong = rs.getInt(4);
                thanhTien = rs.getInt(5);
                ngayDatHang = rs.getString(6);
                trangThai = rs.getString(7);
                tenKH = rs.getString(8);
                tenSP = rs.getString(9);
                Model_QuanLyDonHang m = new Model_QuanLyDonHang(maDH, maKH, tenKH, idSP, tenSP, soLuong, thanhTien, ngayDatHang, trangThai);
                list_DonHang.add(m);
                
            }
            return list_DonHang;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public ArrayList<Model_HoaDon> getAllHoaDon(){
        sql = "select MaHD, MaKH, MaDH,TongTien,TrangThai,NgayTao from HoaDon";
        ArrayList<Model_HoaDon> list_HoaDon = new ArrayList<>();
        try{
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(); //chạy câu lệnh select
            while(rs.next()){
                int maHD;
                int maKH;
                int maDH;
                int thanhTien;
                String ngayTao;
                String trangThai;
                maHD = rs.getInt(1);//;ấy theo thứ tự(lấy theo cột) 
                //cách 2: id = rs.getInt("id"); lấy theo tên
                maKH = rs.getInt(2);
                maDH = rs.getInt(3);
                thanhTien = rs.getInt(4);
                trangThai = rs.getString(5);
                ngayTao = rs.getString(6);          
                Model_HoaDon m = new Model_HoaDon(maHD, maDH, maKH, thanhTien, trangThai, ngayTao);
                list_HoaDon.add(m);
                
            }
            return list_HoaDon;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public int them(Model_QuanLyDonHang m){
        //lấy đối tượng m từ form thêm vào database
        sql = "INSERT INTO QuanLyDonHang (MaKH, IdSP, SoLuong, TrangThai)\n" +
"VALUES(?,?,?,?)";
        try{
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, m.getMaKH()); //số 1 tương ứng với dấu hỏi chấm đầu tiên
            ps.setObject(2, m.getIdSP());
            ps.setObject(3, m.getSoLuong());
            ps.setObject(4, m.getTrangThai());
            return ps.executeUpdate();
            //update, dalete,insert: đểu dùng câu lệnh executeUpdate()
        }catch(Exception e){ // ko thêm đc
            e.printStackTrace();
            return 0;
        }
    }
    public int themHoaDon(Model_HoaDon m){
        //lấy đối tượng m từ form thêm vào database
        sql = "INSERT INTO HoaDon (MaKH, MaDH, TongTien, TrangThai, NgayTao)\n" +
"VALUES (?,?,?,?,?)";
        try{
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, m.getMaKH()); //số 1 tương ứng với dấu hỏi chấm đầu tiên
            ps.setObject(2, m.getMaDH());
            ps.setObject(3, m.getThanhTien());
            ps.setObject(4, m.getTrangThai());
            ps.setObject(5, m.getNgayTao());
            return ps.executeUpdate();
            //update, dalete,insert: đểu dùng câu lệnh executeUpdate()
        }catch(Exception e){ // ko thêm đc
            e.printStackTrace();
            return 0;
        }
    }
//    public int them(Model_Mylove m){
//        //lấy đối tượng m từ form thêm vào database
//        sql = "insert into mylove(Hoten,namsinh,gioitinh) values (?,?,?)";
//        try{
//            con = DBConnect.getConnection();
//            ps = con.prepareStatement(sql);
//            ps.setObject(1, m.getHoTen()); //số 1 tương ứng với dấu hỏi chấm đầu tiên
//            ps.setObject(2, m.getNamSinh());
//            ps.setObject(3, m.isGioiTinh());
//            return ps.executeUpdate();
//            //update, dalete,insert: đểu dùng câu lệnh executeUpdate()
//        }catch(Exception e){ // ko thêm đc
//            e.printStackTrace();
//            return 0;
//        }
//    }
    public int xoa(int maKH){
      //xóa dl theo id truyền vào
      sql = "delete from QuanLyDonHang where MaKH = ?";
      try{
          con = DBConnect.getConnection();
          ps = con.prepareStatement(sql);
          ps.setObject(1, maKH); // số 1 thay thế dấu hỏi chấm( chỉ vị trí của dấu hỏi chấm)
          return ps.executeUpdate();
      }catch(Exception e){
          e.printStackTrace();
          return 0;
      }
    }
    public int suaDH(int MaDH, Model_QuanLyDonHang m){ //m : đối tượng mới sau khi sửa
        sql ="update QuanLyDonHang set SoLuong = ? where MaDH = ?";
        try{
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, m.getSoLuong());
            ps.setObject(2, MaDH);
            return ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }
    public int suaKH(int MaKH, Model_KhachHang m){ //m : đối tượng mới sau khi sửa
        sql ="update QuanLyKhachHang set TenKH = ?, SDT = ?, Email = ?,DiaChi = ? where MaKH = ?";
        try{
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, m.getTenKH());
            ps.setObject(2, m.getSdt());
            ps.setObject(3, m.getEmail());
            ps.setObject(4, m.getDiaChi());
            ps.setObject(5, MaKH);
            return ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }
    public int suaDH2(int MaDH, Model_QuanLyDonHang m){ //m : đối tượng mới sau khi sửa
        sql ="update QuanLyDonHang set TrangThai = ? where MaDH = ?";
        try{
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, m.getTrangThai());
            ps.setObject(2, MaDH);
            return ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }
//    public ArrayList<Model_Mylove> sapXep(){
//        sql = "select id, Hoten, namsinh, gioitinh from mylove\n" +
//"order by namsinh desc";
//        ArrayList<Model_Mylove> list_Mylove = new ArrayList<>();
//        try{
//            con = DBConnect.getConnection();
//            ps = con.prepareStatement(sql);
//            rs = ps.executeQuery(); //chạy câu lệnh select
//            while(rs.next()){
//                int id, nam;
//                String ten;
//                boolean gt;
//                id = rs.getInt(1);//;ấy theo thứ tự(lấy theo cột) 
//                //cách 2: id = rs.getInt("id"); lấy theo tên
//                ten = rs.getString(2);
//                nam = rs.getInt(3);
//                gt = rs.getBoolean(4);
//                Model_Mylove m = new Model_Mylove(id, ten, nam, gt);
//                list_Mylove.add(m);
//                
//            }
//            return list_Mylove;
//        }catch(Exception e){
//            e.printStackTrace();
//            return null;
//        }
//    }
//    public ArrayList<Model_Mylove> timKiem(String tenCanTim){
//        sql = "select id, Hoten, namsinh, gioitinh from mylove\n" +
//"where Hoten like ?";
//        ArrayList<Model_Mylove> list_Mylove = new ArrayList<>();
//        try{
//            con = DBConnect.getConnection();
//            ps = con.prepareStatement(sql);
//            ps.setObject(1, '%'+tenCanTim+'%');
//            rs = ps.executeQuery(); //chạy câu lệnh select
//            while(rs.next()){
//                int id, nam;
//                String ten;
//                boolean gt;
//                id = rs.getInt(1);//;ấy theo thứ tự(lấy theo cột) 
//                //cách 2: id = rs.getInt("id"); lấy theo tên
//                ten = rs.getString(2);
//                nam = rs.getInt(3);
//                gt = rs.getBoolean(4);
//                Model_Mylove m = new Model_Mylove(id, ten, nam, gt);
//                list_Mylove.add(m);
//                
//            }
//            return list_Mylove;
//        }catch(Exception e){
//            e.printStackTrace();
//            return null;
//        }
//    }
}
