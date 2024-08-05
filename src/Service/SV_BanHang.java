/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import ConnectDao.ConnectDao;
import DTO.DTO_Ctsp;
import DTO.DTO_Ctsp_BanHang;
import DTO.DTO_DSSP_BanHang;
import DTO.DTO_GioHang;
import DTO.DTO_KhachHang;
import Model.MD_Hang_CN;
import Model.MD_HoaDon_CN;
import Model.MD_SanPham_CN;
import Model.MD_Vocher;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 84904
 */
public class SV_BanHang {

    MD_Hang_CN hang;
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    ConnectDao cdao = new ConnectDao();

    public List<DTO_DSSP_BanHang> selectAllDSSP() {
        String sql = "SELECT san_pham.id_san_pham, san_pham.anh_san_pham,  san_pham.ma_san_pham, san_pham.ten_san_pham, loaisp.ten_LSP, hang.ten_Hang\n"
                + "FROM   hang INNER JOIN\n"
                + "             san_pham ON hang.id_Hang = san_pham.id_Hang INNER JOIN\n"
                + "             loaisp ON san_pham.id_LSP = loaisp.id_LSP\n"
                + "WHERE (san_pham.trang_thai = N'Hoạt động')";
        List<DTO_DSSP_BanHang> dto = new ArrayList<>();
        try {
            conn = cdao.getConnectDAO();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                dto.add(new DTO_DSSP_BanHang(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)
                //                        rs.getString(7)
                ));
            }
            return dto;
        } catch (SQLException ex) {
        }
        return null;
    }

    public List<DTO_Ctsp_BanHang> selectAllctsp_ByIDSP(Integer idsp) {
        String sql = "SELECT ctsp.id, san_pham.ma_san_pham, ctsp.mau_sac, ctsp.so_luong_ton, ctsp.gia_ban, ctsp.mo_Ta\n"
                + "FROM   ctsp INNER JOIN\n"
                + "             san_pham ON ctsp.id_san_pham = san_pham.id_san_pham\n"
                + "WHERE (ctsp.id_san_pham = ?) AND (ctsp.trang_thai = N'Hoạt động')";
        List<DTO_Ctsp_BanHang> dto = new ArrayList<>();
        try {
            conn = cdao.getConnectDAO();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idsp);
            rs = ps.executeQuery();
            while (rs.next()) {
                dto.add(new DTO_Ctsp_BanHang(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getBigDecimal(5),
                        rs.getString(6)
                ));
            }
            return dto;
        } catch (SQLException ex) {
        }
        return null;
    }

    public List<MD_HoaDon_CN> selectAllHoaDon() {
        String sql = "SELECT MaHD, MaKH, TrangThai, MaNV, NgayTao, TongTien, NgaySua\n"
                + "FROM   HoaDon\n"
                + "WHERE (TrangThai = N'Đang tạo')";
        List<MD_HoaDon_CN> dto = new ArrayList<>();
        try {
            conn = cdao.getConnectDAO();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                dto.add(new MD_HoaDon_CN(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getBigDecimal(6),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(5),
                        rs.getDate(7)
                ));
            }
            return dto;
        } catch (SQLException ex) {
        }
        return null;
    }

    public List<DTO_GioHang> selectAllGioHang(Integer maHD) {
        String sql = "SELECT HoaDon.MaHD, san_pham.ten_san_pham, hang.ten_Hang, loaisp.ten_LSP, ctsp.mau_sac, HoaDonChiTiet.SoLuong, ctsp.gia_ban\n"
                + "FROM HoaDon \n"
                + "INNER JOIN HoaDonChiTiet ON HoaDon.MaHD = HoaDonChiTiet.MaHD\n"
                + "INNER JOIN ctsp ON HoaDonChiTiet.IdSP = ctsp.id\n"
                + "INNER JOIN san_pham ON ctsp.id_san_pham = san_pham.id_san_pham\n"
                + "INNER JOIN hang ON san_pham.id_Hang = hang.id_Hang\n"
                + "INNER JOIN loaisp ON san_pham.id_LSP = loaisp.id_LSP\n"
                + "WHERE HoaDon.MaHD = ?;";
        List<DTO_GioHang> dto = new ArrayList<>();
        try {
            conn = cdao.getConnectDAO();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, maHD);
            rs = ps.executeQuery();
            while (rs.next()) {
                dto.add(new DTO_GioHang(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getBigDecimal(7)
                ));
            }
            return dto;
        } catch (SQLException ex) {
        }
        return null;
    }

    public List<MD_Vocher> selectAllKhuyenMai() {
        String sql = "SELECT idKM, MaKM, TenKM, DieuKienKM, PhanTramKM, NgayBD, NgayKT, MaHD\n"
                + "FROM   khuyenmai ORDER BY idKM ASC";
        List<MD_Vocher> dto = new ArrayList<>();
        try {
            conn = cdao.getConnectDAO();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                dto.add(new MD_Vocher(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)
                ));
            }
            return dto;
        } catch (SQLException ex) {
        }
        return null;
    }

    public void taoDon(Integer maKH, String maNV) {
        String sql = "INSERT INTO HoaDon\n"
                + "             (MaKH, MaNV, NgayTao, TrangThai)\n"
                + "VALUES (?, ?,GETDATE(),N'Đang tạo')";
        try {
            conn = cdao.getConnectDAO();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, maKH);
            ps.setString(2, maNV);

            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void themCTSPVaoGioHang_HDCT(Integer mahd, Integer idctsp, Integer soluong, BigDecimal dongia, BigDecimal thanhtien) {
        String sql = "INSERT INTO HoaDonChiTiet\n"
                + "             (MaHD, IdSP, SoLuong, DonGia, ThanhTien)\n"
                + "VALUES (?,?,?,?,?)";
        try {
            conn = cdao.getConnectDAO();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, mahd);
            ps.setInt(2, idctsp);
            ps.setInt(3, soluong);
            ps.setBigDecimal(4, dongia);
            ps.setBigDecimal(5, thanhtien);

            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public DTO_KhachHang selectAllKhachHang(Integer idkh) {
        String sql = "SELECT MaKH, TenKH, SDT, Email, DiaChi FROM QuanLyKhachHang WHERE MaKH = ? ORDER BY MaKH ASC";
        DTO_KhachHang dto = null;
        try {
            conn = cdao.getConnectDAO();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idkh); // Thiết lập giá trị tham số
            rs = ps.executeQuery();
            if (rs.next()) {
                // Tạo một đối tượng DTO_KhachHang mới với các giá trị từ kết quả truy vấn
                dto = new DTO_KhachHang(
                        rs.getInt("MaKH"), // Cột 1: MaKH
                        rs.getString("TenKH"), // Cột 2: TenKH
                        rs.getString("SDT"), // Cột 3: SDT
                        rs.getString("Email"), // Cột 4: Email
                        rs.getString("DiaChi") // Cột 5: DiaChi
                );
            }
            return dto;
        } catch (SQLException ex) {
            ex.printStackTrace(); // Ghi log lỗi
        }
        return null;
    }

}
