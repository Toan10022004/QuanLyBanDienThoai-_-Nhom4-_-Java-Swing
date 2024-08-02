/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hung;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Repositories_KhachHang {

    private static Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;

    public Repositories_KhachHang() {
        con = DBConnect.getConnection();
        if (con == null) {
            System.out.println("Failed to make connection!");
        } else {
            System.out.println("Connection successful!");
        }
    }

    public ArrayList<Model_khachhang> getAll() {
        ArrayList<Model_khachhang> list_Khachhang = new ArrayList<>();
        sql = "select MaKH, TenKH, SDT, Email, DiaChi from QuanLyKhachHang";
        try {
            if (con.isClosed()) {
                con = DBConnect.getConnection();
            }
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int MaKH;
                String TenKH, SDT, Email, DiaChi;
                MaKH = rs.getInt(1);
                TenKH = rs.getString(2);
                SDT = rs.getString(3);
                Email = rs.getString(4);
                DiaChi = rs.getString(5);
                list_Khachhang.add(new Model_khachhang(MaKH, TenKH, SDT, Email, DiaChi));
            }
            return list_Khachhang;
        } catch (SQLException e) {
            Logger.getLogger(Repositories_KhachHang.class.getName()).log(Level.SEVERE, null, e);
            return null;
        } finally {
            closeResources();
        }
    }
public boolean isValidName(String name) {
    return name != null && !name.trim().isEmpty() && name.matches("[a-zA-Z\\s-]+");
}
public boolean isValidPhoneNumber(String phoneNumber) {
    // Example regex for validating phone numbers
    String phoneRegex = "^\\+?[0-9]{1,4}?[-.\\s]?\\(?[0-9]{1,4}?\\)?[-.\\s]?[0-9]{1,9}$";
    return phoneNumber != null && phoneNumber.matches(phoneRegex);
}
    private void closeResources() {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null && !con.isClosed()) con.close();
        } catch (SQLException e) {
            Logger.getLogger(Repositories_KhachHang.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public boolean add(Model_khachhang khachHang) {
        sql = "INSERT INTO QuanLyKhachHang (TenKH, SDT, Email, DiaChi) VALUES (?, ?, ?, ?)";
        try {
            if (con.isClosed()) {
                con = DBConnect.getConnection();
            }
            ps = con.prepareStatement(sql);
            ps.setString(1, khachHang.getTenKH());
            ps.setString(2, khachHang.getSDT());
            ps.setString(3, khachHang.getEmail());
            ps.setString(4, khachHang.getDiaChi());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            Logger.getLogger(Repositories_KhachHang.class.getName()).log(Level.SEVERE, null, e);
            return false;
        } finally {
            closeResources();
        }
    }
    public boolean update(Model_khachhang khachHang) {
        sql = "UPDATE QuanLyKhachHang SET TenKH = ?, SDT = ?, Email = ?, DiaChi = ? WHERE MaKH = ?";
        try {
            if (con.isClosed()) {
                con = DBConnect.getConnection();
            }
            ps = con.prepareStatement(sql);
            ps.setString(1, khachHang.getTenKH());
            ps.setString(2, khachHang.getSDT());
            ps.setString(3, khachHang.getEmail());
            ps.setString(4, khachHang.getDiaChi());
            ps.setInt(5, khachHang.getMaKH());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            Logger.getLogger(Repositories_KhachHang.class.getName()).log(Level.SEVERE, null, e);
            return false;
        } finally {
            closeResources();
        }
    }

    public boolean delete(int maKH) {
        sql = "DELETE FROM QuanLyKhachHang WHERE MaKH = ?";
        try {
            if (con.isClosed()) {
                con = DBConnect.getConnection();
            }
            ps = con.prepareStatement(sql);
            ps.setInt(1, maKH);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            Logger.getLogger(Repositories_KhachHang.class.getName()).log(Level.SEVERE, null, e);
            return false;
        } finally {
            closeResources();
        }
    }

    public Model_khachhang find(int maKH) {
        Model_khachhang khachHang = null;
        sql = "SELECT MaKH, TenKH, SDT, Email, DiaChi FROM QuanLyKhachHang WHERE MaKH = ?";
        try {
            if (con.isClosed()) {
                con = DBConnect.getConnection();
            }
            ps = con.prepareStatement(sql);
            ps.setInt(1, maKH);
            rs = ps.executeQuery();
            if (rs.next()) {
                khachHang = new Model_khachhang(
                        rs.getInt("MaKH"),
                        rs.getString("TenKH"),
                        rs.getString("SDT"),
                        rs.getString("Email"),
                        rs.getString("DiaChi")
                );
            }
            return khachHang;
        } catch (SQLException e) {
            Logger.getLogger(Repositories_KhachHang.class.getName()).log(Level.SEVERE, null, e);
            return null;
        } finally {
            closeResources();
        }
    }
}

