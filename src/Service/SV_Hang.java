/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;
import Model.MD_Hang_CN;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import ConnectDao.ConnectDao;
import DTO.DTO_DanhSachSanPham;
/**
 *
 * @author 84904
 */
public class SV_Hang {
    MD_Hang_CN hang;
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    ConnectDao cdao = new ConnectDao();
    public List<MD_Hang_CN> selectAllHang(){
         String sql = "select * from hang";
        List<MD_Hang_CN> listHang = new ArrayList<>();
        try {
            conn = cdao.getConnectDAO();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                listHang.add(new MD_Hang_CN(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3)
                ));
            }
            return listHang;
        } catch (SQLException ex) {
        }
        return null;
     }
    public List<DTO_DanhSachSanPham> selectAllSanPhamTheoHangByIDHang(Integer idhang){
         String sql = "SELECT san_pham.id_san_pham, san_pham.ma_san_pham, san_pham.anh_san_pham, san_pham.ten_san_pham, loaisp.ten_LSP, hang.ten_Hang, san_pham.mo_Ta, san_pham.trang_thai, san_pham.ngay_tao, san_pham.ngay_sua\n" +
"FROM   hang INNER JOIN\n" +
"             san_pham ON hang.id_Hang = san_pham.id_Hang INNER JOIN\n" +
"             loaisp ON san_pham.id_LSP = loaisp.id_LSP\n" +
"			 Where hang.id_Hang = ?";
        List<DTO_DanhSachSanPham> dto = new ArrayList<>();
        try {
            conn = cdao.getConnectDAO();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idhang);
            rs = ps.executeQuery();
            while (rs.next()) {
                dto.add(new DTO_DanhSachSanPham(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getDate(9),
                        rs.getDate(10)
                ));
            }
            return dto;
        } catch (SQLException ex) {
        }
        return null;
     }
    
    
    public void insert(MD_Hang_CN hang){
         String sql = "INSERT INTO hang\n" +
                        "             (ten_Hang, mo_ta)\n" +
                        "VALUES (?, ?)";
        try {
            conn = cdao.getConnectDAO();
            ps = conn.prepareStatement(sql);
            ps.setString(1, hang.getTenHang());
            ps.setString(2,hang.getMoTa());
            
            ps.executeUpdate();
        } catch (Exception e) {
        }
     }
    public void update(String tenHang , String moTaHang , Integer idHang){
         String sql = "UPDATE hang\n" +
                        "SET       ten_Hang = ?, mo_ta = ?\n" +
                        "WHERE (id_Hang = ?)";
        try {
            conn = cdao.getConnectDAO();
            ps = conn.prepareStatement(sql);
            
            ps.setString(1,tenHang);
            ps.setString(2,moTaHang);
            ps.setInt(3,idHang);
            
            ps.executeUpdate();
        } catch (Exception e) {
        }
     }
    public void delete(Integer id){
         String sql = "DELETE FROM hang Where id_Hang = ?";
        try {
            conn = cdao.getConnectDAO();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
     }
}
