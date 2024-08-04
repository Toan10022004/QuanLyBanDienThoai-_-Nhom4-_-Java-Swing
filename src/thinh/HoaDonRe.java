package thinh;


import ConnectDao.ConnectDao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class HoaDonRe {
    ConnectDao cdao = new ConnectDao();
    public ArrayList<Model_HoaDon> getAllHoaDon() throws SQLException{
        ArrayList<Model_HoaDon> lsHoadon = new ArrayList<>();
        Connection cn = cdao.getConnectDAO();
         String sql = "SELECT HoaDon.MaHD, QuanLyKhachHang.TenKH, san_pham.ten_san_pham AS TenSP, QuanLyDonHang.SoLuong, ctsp.gia_ban * QuanLyDonHang.SoLuong AS ThanhTien " +
                     "FROM ctsp " +
                     "INNER JOIN san_pham ON ctsp.id_san_pham = san_pham.id_san_pham " +
                     "INNER JOIN QuanLyDonHang ON ctsp.id = QuanLyDonHang.IdSP " +
                     "INNER JOIN HoaDon ON QuanLyDonHang.MaDH = HoaDon.MaDH " +
                     "INNER JOIN QuanLyKhachHang ON HoaDon.MaKH = QuanLyKhachHang.MaKH " +
                     "INNER JOIN HoaDonChiTiet ON ctsp.id = HoaDonChiTiet.IdSP AND HoaDon.MaHD = HoaDonChiTiet.MaHD";

        try (Statement stm = cn.createStatement(); ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                Model_HoaDon hd = new Model_HoaDon();
                hd.setMaHD(rs.getString("MaHD"));
                hd.setTenKH(rs.getString("TenKH"));
                hd.setTenSP(rs.getString("TenSP"));
                hd.setSoLuong(rs.getInt("SoLuong"));
                hd.setThanhTien(rs.getInt("ThanhTien"));
                lsHoadon.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lsHoadon;
    }
}
    

