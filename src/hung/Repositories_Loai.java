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

public class Repositories_Loai {
    private static Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;
public Repositories_Loai(){
     con = DBConnect.getConnection();
        if (con == null) {
            System.out.println("Failed to make connection!");
        } else {
            System.out.println("Connection successful!");
        }
    }
public ArrayList<Model_Loai> getAll() {
        ArrayList<Model_Loai> list_loai = new ArrayList<>();
        sql = "select id_LSP, ten_LSP, mo_ta from loaisp ";
        try {
            if (con.isClosed()) {
                con = DBConnect.getConnection();
            }
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id_LSP;
                String  ten_LSP, mo_ta;
                id_LSP = rs.getInt(1);
                ten_LSP = rs.getString(2);
                mo_ta = rs.getString(3);
                list_loai.add(new Model_Loai(id_LSP, ten_LSP, mo_ta));
            }
            return list_loai;
        } catch (SQLException e) {
            Logger.getLogger(Repositories_KhachHang.class.getName()).log(Level.SEVERE, null, e);
            return null;
        } finally {
            closeResources();
        }
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
public boolean add(String tenLoai, String moTa) {
         sql = "insert into loaisp( ten_LSP, mo_ta) values (?,?)";
        try {
            if (con.isClosed()) {
                con = DBConnect.getConnection();
            }
            ps = con.prepareStatement(sql);
            ps.setString(1, tenLoai);
            ps.setString(2,moTa);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            Logger.getLogger(Repositories_KhachHang.class.getName()).log(Level.SEVERE, null, e);
            return false;
        } finally {
            closeResources();
        }
    }
    public boolean update(Model_Loai loai) {
    String sql = "UPDATE loaisp SET ten_LSP = ?, mo_ta = ? WHERE id_LSP = ?";
    try {
        if (con.isClosed()) {
            con = DBConnect.getConnection();
        }
        ps = con.prepareStatement(sql);
        ps.setString(1, loai.getTen_LSP()); // Tham số thứ nhất
        ps.setString(2, loai.getMo_ta());   // Tham số thứ hai
        ps.setInt(3, loai.getId_LSP());     // Tham số thứ ba
        ps.executeUpdate();
        return true;
    } catch (SQLException e) {
        Logger.getLogger(Repositories_Loai.class.getName()).log(Level.SEVERE, null, e);
        return false;
    } finally {
        closeResources();
    }
}

    public boolean delete(int id_LSP ) {
        String sql = "DELETE FROM loaisp WHERE id_LSP=? ";
        try {
            if (con.isClosed()) {
                con = DBConnect.getConnection();
            }
            ps = con.prepareStatement(sql);
            ps.setInt(1, id_LSP);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            Logger.getLogger(Repositories_KhachHang.class.getName()).log(Level.SEVERE, null, e);
            return false;
        } finally {
            closeResources();
        }
    }
    
    public Model_Loai findById(int id_LSP) {
    sql = "SELECT id_LSP, ten_LSP, mo_ta FROM loaisp WHERE id_LSP = ?";
    try {
        if (con.isClosed()) {
            con = DBConnect.getConnection();
        }
        ps = con.prepareStatement(sql);
        ps.setInt(1, id_LSP);
        rs = ps.executeQuery();
        if (rs.next()) {
            int id = rs.getInt("id_LSP");
            String ten = rs.getString("ten_LSP");
            String moTa = rs.getString("mo_ta");
            return new Model_Loai(id, ten, moTa);
        }
    } catch (SQLException e) {
        Logger.getLogger(Repositories_Loai.class.getName()).log(Level.SEVERE, null, e);
    } finally {
        closeResources();
    }
    return null;
}
    
    public ArrayList<Model_Loai> findByTenLSP(String ten_LSP) {
    ArrayList<Model_Loai> list = new ArrayList<>();
    sql = "SELECT id_LSP, ten_LSP, mo_ta FROM loaisp WHERE ten_LSP LIKE ?";
    try {
        if (con.isClosed()) {
            con = DBConnect.getConnection();
        }
        ps = con.prepareStatement(sql);
        ps.setString(1, "%" + ten_LSP + "%");
        rs = ps.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id_LSP");
            String ten = rs.getString("ten_LSP");
            String moTa = rs.getString("mo_ta");
            list.add(new Model_Loai(id, ten, moTa));
        }
    } catch (SQLException e) {
        Logger.getLogger(Repositories_Loai.class.getName()).log(Level.SEVERE, null, e);
    } finally {
        closeResources();
    }
    return list;
}

public ArrayList<Model_Loai> findByMoTa(String mo_ta) {
    ArrayList<Model_Loai> list = new ArrayList<>();
    sql = "SELECT id_LSP, ten_LSP, mo_ta FROM loaisp WHERE mo_ta LIKE ?";
    try {
        if (con.isClosed()) {
            con = DBConnect.getConnection();
        }
        ps = con.prepareStatement(sql);
        ps.setString(1, "%" + mo_ta + "%");
        rs = ps.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id_LSP");
            String ten = rs.getString("ten_LSP");
            String moTa = rs.getString("mo_ta");
            list.add(new Model_Loai(id, ten, moTa));
        }
    } catch (SQLException e) {
        Logger.getLogger(Repositories_Loai.class.getName()).log(Level.SEVERE, null, e);
    } finally {
        closeResources();
    }
    return list;
}

}
