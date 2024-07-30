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
import DTO.DTO_Ctsp;
import DTO.DTO_DanhSachSanPham;

/**
 *
 * @author 84904
 */
public class SV_CTSP {

    MD_Hang_CN hang;
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    ConnectDao cdao = new ConnectDao();

    public List<DTO_Ctsp> selectAllCTSPByIDSP(Integer idsp) {
        String sql = "SELECT ctsp.id,san_pham.ma_san_pham, ctsp.mau_sac, ctsp.so_luong_ton, ctsp.mo_Ta, ctsp.gia_ban, ctsp.trang_thai, ctsp.ngay_tao, ctsp.ngay_sua\n"
                + "FROM   ctsp INNER JOIN\n"
                + "             san_pham ON ctsp.id_san_pham = san_pham.id_san_pham\n"
                + "			 WHERE (ctsp.id_san_pham = ?)";
        List<DTO_Ctsp> dto = new ArrayList<>();
        try {
            conn = cdao.getConnectDAO();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idsp);
            rs = ps.executeQuery();
            while (rs.next()) {
                dto.add(new DTO_Ctsp(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getBigDecimal(6),
                        rs.getString(7),
                        rs.getDate(8),
                        rs.getDate(9)
                ));
            }
            return dto;
        } catch (SQLException ex) {
        }
        return null;
    }

    public void insert(DTO_Ctsp ct, Integer idsp) {
        String sql = "INSERT INTO ctsp\n"
                + "             (id_san_pham, mau_sac, so_luong_ton, mo_Ta, gia_ban, trang_thai, ngay_tao)\n"
                + "VALUES (?, ?, ?, ?, ?, ?, GETDATE())";
        try {
            conn = cdao.getConnectDAO();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idsp);
            ps.setString(2, ct.getMauSac());
            ps.setInt(3, ct.getSoLuongTon());
            ps.setString(4, ct.getMoTa());
            ps.setBigDecimal(5, ct.getGiaBan());
            ps.setString(6, ct.getTrangThai());

            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void update(DTO_Ctsp dto , Integer idctsp) {
        String sql = "UPDATE ctsp\n"
                + "SET       mau_sac = ?, so_luong_ton = ?, gia_ban = ?, mo_Ta = ?, trang_thai = ?, ngay_sua = GETDATE()\n"
                + "WHERE (id = ?)";
        try {
            conn = cdao.getConnectDAO();
            ps = conn.prepareStatement(sql);

            ps.setString(1, dto.getMauSac());
            ps.setInt(2, dto.getSoLuongTon());
            ps.setBigDecimal(3, dto.getGiaBan());
            ps.setString(4, dto.getMoTa());
            ps.setString(5, dto.getTrangThai());
            ps.setInt(6, idctsp);

            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void delete(Integer id) {
        String sql = "DELETE FROM ctsp\n"
                + "WHERE (id = ?)";
        try {
            conn = cdao.getConnectDAO();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
