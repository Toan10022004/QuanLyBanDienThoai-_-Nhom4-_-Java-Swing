/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import view.KhuyenMai;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
/**
 *
 * @author thinh
 */
public class KhuyenMaiRe {
    public ArrayList<KhuyenMai> getAllKhuyenMai() throws SQLException{
        ArrayList<KhuyenMai> lsKhuyenMai = new ArrayList<>();
        Connection cn = DBconnert.getdataUSER();
        String sql = "select MaKM, TenKM, DieuKienKM, PhanTramKM, NgayBD, NgayKT from khuyenmai";
        
        try {
            Statement stm = cn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                KhuyenMai km = new KhuyenMai();
                km.setMaKM(rs.getString("MaKM"));
                km.setTenKM(rs.getString("TenKM"));
                km.setDieuKien(rs.getString("DieuKienKM"));
                km.setPhanTramKM(rs.getString("PhanTramKM"));
                km.setNgayBD(rs.getString("NgayBD"));
                km.setNgayKT(rs.getString("NgayKT"));
                lsKhuyenMai.add(km);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lsKhuyenMai;
                
    }
     public boolean addVoucher(KhuyenMai newKhuyenMai) {
    String sql = "INSERT INTO khuyenmai (MaKM, TenKM, DieuKienKM, PhanTramKM, NgayBD, NgayKT) VALUES (?, ?, ?, ?, ?, ?)";
    try (Connection cn = DBconnert.getdataUSER()) {
        PreparedStatement sttm = cn.prepareStatement(sql);

        sttm.setString(1, newKhuyenMai.getMaKM());
        sttm.setString(2, newKhuyenMai.getTenKM());
        sttm.setString(3, newKhuyenMai.getDieuKien());
        sttm.setString(4, newKhuyenMai.getPhanTramKM());
        sttm.setString(5, newKhuyenMai.getNgayBD());
        sttm.setString(6, newKhuyenMai.getNgayKT());

        int rowsAffected = sttm.executeUpdate();
            if (rowsAffected>0) {
                System.out.println("Thêm thành công ");
            }else{
                System.out.println("Thêm Thất Bại "+newKhuyenMai.getMaKM()+"found");
            }
        } catch (Exception e) {
            System.out.println("Error " + e.toString()); 
        }
        return false;
    }
    public void XoaVoucher(KhuyenMai newKhuyenMai) {
    String sql = "DELETE FROM khuyenmai WHERE MaKM = ?";

    try (Connection cn = DBconnert.getdataUSER()) {
        PreparedStatement sttm = cn.prepareStatement(sql);
        sttm.setString(1, newKhuyenMai.getMaKM());
        int rowAffected = sttm.executeUpdate();

        if (rowAffected > 0) {
            JOptionPane.showMessageDialog(null, "Xóa Thành Công");
        } else {
            JOptionPane.showMessageDialog(null, "Xóa Thất Bại!");
        }
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
}
    public boolean updateVoucher(KhuyenMai km) {
    String sql = "UPDATE khuyenmai SET TenKM = ?, DieuKien = ?, PhanTramKM = ?, NgayBD = ?, NgayKT = ? WHERE MaKM = ?";
    try (Connection cn = DBconnert.getdataUSER();
         PreparedStatement sttm = cn.prepareStatement(sql)) {

        sttm.setString(1, km.getTenKM());
        sttm.setString(2, km.getDieuKien());
        sttm.setString(3, km.getPhanTramKM());
        sttm.setString(4, km.getNgayBD());
        sttm.setString(5, km.getNgayKT());
        sttm.setString(6, km.getMaKM());

        int rowsAffected = sttm.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Cập nhật thành công voucher " + km.getMaKM());
            return true;
        } else {
            System.out.println("Không có bản ghi nào được cập nhật.");
            return false;
        }
    } catch (SQLException e) {
        System.out.println("Lỗi: " + e.getMessage());
        return false;
    }
}

    }

