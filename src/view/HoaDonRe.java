package view;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import view.HoaDon;
import view.HoaDonChiTiet;
import view.KhuyenMailk;
import java.sql.PreparedStatement;

public class HoaDonRe {

    private PreparedStatement ps = null;

    public ArrayList<HoaDon> getAllHoaDon() throws SQLException {
        ArrayList<HoaDon> lsHoadon = new ArrayList<>();
        Connection cn = DBconnert.getdataUSER();
        String sql = "SELECT HoaDon.MaHD, QuanLyKhachHang.TenKH, san_pham.ten_san_pham, HoaDonChiTiet.SoLuong, HoaDon.TrangThai, HoaDon.TongTien, HoaDon.TrangThai AS Expr1\n"
                + "FROM   HoaDon INNER JOIN\n"
                + "             QuanLyKhachHang ON HoaDon.MaKH = QuanLyKhachHang.MaKH INNER JOIN\n"
                + "             HoaDonChiTiet ON HoaDon.MaHD = HoaDonChiTiet.MaHD INNER JOIN\n"
                + "             ctsp ON HoaDonChiTiet.IdSP = ctsp.id INNER JOIN\n"
                + "             san_pham ON ctsp.id_san_pham = san_pham.id_san_pham\n"
                + "WHERE (HoaDon.TrangThai = N'Hoàn tất')";

        try (Statement stm = cn.createStatement(); ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getString("MaHD"));
                hd.setTenKH(rs.getString("TenKH"));
                hd.setTenSP(rs.getString("ten_san_pham"));
                hd.setSoLuong(rs.getInt("SoLuong"));
                hd.setTrangThai(rs.getString("TrangThai"));
                hd.setTongTien(rs.getInt("TongTien"));
                lsHoadon.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lsHoadon;
    }

    public ArrayList<HoaDonChiTiet> getAllHoaDonChiTiet(int MaHD) throws SQLException {
        ArrayList<HoaDonChiTiet> lsHoadonchitiet = new ArrayList<>();
        Connection cn = DBconnert.getdataUSER();
        String sql = "SELECT * FROM HoaDonChiTiet WHERE MaHD = ?";

        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, MaHD);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    HoaDonChiTiet hdct = new HoaDonChiTiet();
                    hdct.setMaHD(rs.getString("MaHD"));
                    hdct.setMaSp(rs.getString("IdSP"));
                    hdct.setSoLuong(rs.getInt("SoLuong"));
                    hdct.setGia(rs.getInt("DonGia"));
                    hdct.setTongTien(rs.getInt("ThanhTien"));
                    lsHoadonchitiet.add(hdct);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lsHoadonchitiet;
    }

    public ArrayList<KhuyenMailk> getAllKhuyenMailk(int MaHD) throws SQLException {
        ArrayList<KhuyenMailk> lsKhuyenMailk = new ArrayList<>();
        Connection cn = DBconnert.getdataUSER();
        String sql = "SELECT * FROM khuyenmai WHERE MaHD = ?";

        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, MaHD);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    KhuyenMailk km = new KhuyenMailk();
                    km.setMaHD(rs.getString("MaHD"));
                    km.setMaKM(rs.getString("MaKM"));
                    km.setTenKM(rs.getString("TenKM"));
                    km.setDieuKien(rs.getString("DieuKienKM"));
                    km.setPhanTramKM(rs.getString("PhanTramKM"));
                    km.setNgayBD(rs.getString("NgayBD"));
                    km.setNgayKT(rs.getString("NgayKT"));
                    lsKhuyenMailk.add(km);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lsKhuyenMailk;
    }
}
