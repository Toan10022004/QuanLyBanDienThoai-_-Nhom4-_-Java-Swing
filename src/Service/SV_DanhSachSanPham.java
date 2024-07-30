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
import DTO.DTO_MauSacAndGia_CTSP;
import DTO.DTO_SanPham_CTSP;
import Form_View.Form_DanhSachSanPham;
import Model.MD_Ctsp_CN;
import Model.MD_LoaiSP_CN;
import Model.MD_SanPham_CN;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author 84904
 */
public class SV_DanhSachSanPham {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    ConnectDao cdao = new ConnectDao();

    public List<MD_LoaiSP_CN> selectAllLoaiSanPham() {
        String sql = "SELECT * FROM loaisp;";
        List<MD_LoaiSP_CN> listLSP = new ArrayList<>();
        try {
            conn = cdao.getConnectDAO();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                listLSP.add(new MD_LoaiSP_CN(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3)
                ));
            }
            return listLSP;
        } catch (SQLException ex) {
        }
        return null;
    }

    public List<DTO_DanhSachSanPham> selectAllDSS() {
        String sql = "SELECT san_pham.id_san_pham, san_pham.ma_san_pham, san_pham.anh_san_pham, san_pham.ten_san_pham, loaisp.ten_LSP, hang.ten_Hang, san_pham.mo_Ta, san_pham.trang_thai, san_pham.ngay_tao, san_pham.ngay_sua\n"
                + "FROM   hang INNER JOIN\n"
                + "             san_pham ON hang.id_Hang = san_pham.id_Hang INNER JOIN\n"
                + "             loaisp ON san_pham.id_LSP = loaisp.id_LSP ORDER BY san_pham.id_san_pham DESC";
        List<DTO_DanhSachSanPham> dto = new ArrayList<>();
        try {
            conn = cdao.getConnectDAO();
            ps = conn.prepareStatement(sql);
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

    public DTO_DanhSachSanPham selectAllDSSByIDSP(Integer idsp) {
        String sql = "SELECT san_pham.id_san_pham, san_pham.ma_san_pham, san_pham.anh_san_pham, san_pham.ten_san_pham, loaisp.ten_LSP, hang.ten_Hang, san_pham.mo_Ta, san_pham.trang_thai, san_pham.ngay_tao, san_pham.ngay_sua\n"
                + "FROM   hang INNER JOIN\n"
                + "             san_pham ON hang.id_Hang = san_pham.id_Hang INNER JOIN\n"
                + "             loaisp ON san_pham.id_LSP = loaisp.id_LSP WHERE (san_pham.id_san_pham = ?) ORDER BY san_pham.id_san_pham DESC";
        DTO_DanhSachSanPham dto = new DTO_DanhSachSanPham();
        try {
            conn = cdao.getConnectDAO();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idsp);
            rs = ps.executeQuery();
            while (rs.next()) {
                dto = new DTO_DanhSachSanPham(
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
                );
            }
            return dto;
        } catch (SQLException ex) {
        }
        return null;
    }

    public List<DTO_MauSacAndGia_CTSP> selectCTSPMauSacandCTSPGiaByIDSanPham(Integer idsp) {
        String sql = "SELECT ctsp.mau_sac, ctsp.gia_ban\n"
                + "FROM   ctsp INNER JOIN\n"
                + "             san_pham ON ctsp.id_san_pham = san_pham.id_san_pham\n"
                + "WHERE (san_pham.id_san_pham = ?)";
        List<DTO_MauSacAndGia_CTSP> dto = new ArrayList<>();
        try {
            conn = cdao.getConnectDAO();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idsp);
            rs = ps.executeQuery();
            while (rs.next()) {
                dto.add(new DTO_MauSacAndGia_CTSP(
                        rs.getString(1),
                        rs.getBigDecimal(2)
                ));
            }
            return dto;
        } catch (SQLException ex) {
        }
        return null;
    }

    public Integer insert(MD_SanPham_CN sp) {
        String sql = "INSERT INTO san_pham\n"
                + "             (anh_san_pham, ma_san_pham, ten_san_pham, trang_thai, ngay_tao, id_Hang, id_LSP, mo_Ta)\n"
                + "VALUES (?, ?, ?, ?, GETDATE(), ?, ?,?)";
        try {
            conn = cdao.getConnectDAO();
            ps = conn.prepareStatement(sql);
            ps.setString(1, sp.getAnhSanPham());//1 là số thứ tự của ? trong câu lệnh sql
            ps.setString(2, sp.getMaSanPham());
            ps.setString(3, sp.getTenSanPham());
            ps.setString(4, sp.getTrangThai());
//            ps.setDate(5,(java.sql.Date) (Date) sp.getNgayTao());
            ps.setInt(5, sp.getHang());
            ps.setInt(6, sp.getLoaiSanPham());
            ps.setString(7, sp.getMoTa());

            ps.executeUpdate();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public Integer update(MD_SanPham_CN sp, Integer idsp, String Img) {
        String sql = "UPDATE san_pham\n"
                + "SET       ma_san_pham = ?, anh_san_pham = ?, ten_san_pham = ?, id_Hang = ?, id_LSP = ?, mo_Ta = ?, trang_thai = ?, ngay_sua = GETDATE()\n"
                + "WHERE (id_san_pham = ?)";
        try {
            conn = cdao.getConnectDAO();
            ps = conn.prepareStatement(sql);

            ps.setString(1, sp.getMaSanPham());
            ps.setString(2, Img);
            ps.setString(3, sp.getTenSanPham());
            ps.setInt(4, sp.getHang());
            ps.setInt(5, sp.getLoaiSanPham());
            ps.setString(6, sp.getMoTa());
            ps.setString(7, sp.getTrangThai());
            ps.setInt(8, idsp);

            ps.executeUpdate();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public void delete(Integer id) {
        String sql = "DELETE FROM san_pham\n"
                + "WHERE (id_san_pham = ?)";
        try {
            conn = cdao.getConnectDAO();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public List<DTO_SanPham_CTSP> selectAllCTSP() {
        String sql = "SELECT ctsp.id_san_pham, san_pham.ma_san_pham, san_pham.anh_san_pham, san_pham.ten_san_pham, hang.ten_Hang, loaisp.ten_LSP, san_pham.trang_thai, san_pham.mo_Ta, san_pham.ngay_tao, san_pham.ngay_sua, ctsp.id, ctsp.mau_sac, ctsp.so_luong_ton, ctsp.mo_Ta AS Expr1, \n" +
"             ctsp.trang_thai AS Expr2, ctsp.gia_ban, ctsp.ngay_tao AS Expr3, ctsp.ngay_sua AS Expr4\n" +
"FROM   ctsp INNER JOIN\n" +
"             san_pham ON ctsp.id_san_pham = san_pham.id_san_pham INNER JOIN\n" +
"             hang ON san_pham.id_Hang = hang.id_Hang INNER JOIN\n" +
"             loaisp ON san_pham.id_LSP = loaisp.id_LSP";
        List<DTO_SanPham_CTSP> dto = new ArrayList<>();
        try {
            conn = cdao.getConnectDAO();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                dto.add(new DTO_SanPham_CTSP(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getDate(9),
                        rs.getDate(10),
                        

                        rs.getInt(11),
                        rs.getString(12),
                        rs.getInt(13),
                        rs.getString(14),
                        rs.getString(15),
                        rs.getBigDecimal(16),
                        rs.getDate(17),
                        rs.getDate(18)
                ));
            }
            return dto;
        } catch (SQLException ex) {
        }
        return null;
    }
}
