/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Form_View;

import DTO.DTO_Ctsp_BanHang;
import DTO.DTO_DSSP_BanHang;
import DTO.DTO_DanhSachSanPham;
import DTO.DTO_GioHang;
import DTO.DTO_GioHangcheckGiaBan;
import DTO.DTO_KhachHang;
//import Main.ButtonColumn;
import Main.DataHolder;
import Model.MD_Hang_CN;
import Model.MD_HoaDon_CN;
import Model.MD_Vocher;
import Service.SV_BanHang;
import hung.Model_khachhang;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableCellEditor;
import javax.swing.AbstractCellEditor;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 84904
 */
// Trạng thái đơn hàng
//Đang tạo 
//Đang Trả Góp 
//Hoàn tất
public class Form_BanHang extends javax.swing.JPanel {
//    https://stackhowto.com/how-to-dynamically-filter-jtable-from-textfield-in-java/#google_vignette

    TableRowSorter<TableModel> rowSorter; // công nghệ lọc bảng 
    DefaultTableModel tblModel;
//    Biến toàn cục
    Model_khachhang mdkh_ToanCuc = new Model_khachhang();
    String idsp;//id toàn cục để fill ctsp
    Integer maHD_toanCuc;//mã Hóa đươn toàn cục gán khi click hóa đươn lấy ra giỏ hàng
    Integer idctsp_toanCuc;//id toàn cục để fill ctsp
    BigDecimal giaCTSP;
    String inputSoluong_toanCuc;
    Integer indexCu = null;
    BigDecimal tongThanhToan;
//    Sevice
    SV_BanHang svBanHang = new SV_BanHang();
//    ListModel
//    Model_khachhang listKhachHang = new Model_khachhang();
    List<DTO_DSSP_BanHang> dtoDSSP = new ArrayList<>();
    List<DTO_Ctsp_BanHang> dtoCTSP = new ArrayList<>();
    List<MD_HoaDon_CN> dtoHoaDon = new ArrayList<>();
    List<DTO_GioHang> dtoGioHang = new ArrayList<>();
    List<MD_Vocher> listvc = svBanHang.selectAllKhuyenMai();

    /**
     * Creates new form Form_BanHang
     */
    public Form_BanHang() {
        initComponents();
        initTableSanPham();
        initTableHoaDon();
        initTableGioHang();
        initTableCTSP();
        initCboVocher();

        tblModel = (DefaultTableModel) tblGioHang.getModel();
        tblModel.setRowCount(0);
//        tblModel = (DefaultTableModel) tblDonHang.getModel();
//        tblModel.setRowCount(0);
        //Lọc Banhgr hãng
        rowSorter = new TableRowSorter<>(tblDanhSachSanPham.getModel());
        tblDanhSachSanPham.setRowSorter(rowSorter);
        //set tabel
        dtoDSSP = svBanHang.selectAllDSSP();
        filltableSanPham(dtoDSSP);
        dtoHoaDon = svBanHang.selectAllHoaDon();
        filltableHoaDon(dtoHoaDon);

        //set % giá trị vocher mạc đinhgj đang ở cbo đang chọn khhi mở fomr lên sẽ là đầu tiên
        for (MD_Vocher v : listvc) {
            if (v.getTenKM().equals(cboVocher.getSelectedItem())) {
                txtPhanTramVocher.setText(v.getPhanTramKM());
            }
        }
        //Sự kiện khi ở tbl thay đổi data qua edit trực tiếp trên table thì sự kiện này sẽ thực hiện chạy
        DefaultTableModel model = (DefaultTableModel) tblGioHang.getModel();
        model.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE) {
                    int row = e.getFirstRow();
                    int column = e.getColumn();
                    if (column == 6) { // Cột "Số lượng"
                        int maHDCT = (Integer) model.getValueAt(row, 0);// mã hóa đươn chi tiết
                        int newQuantity = Integer.parseInt(model.getValueAt(row, column).toString());//số lượng
                        System.out.println("Updated Số lượng for Mã HDCT " + maHDCT + ": " + newQuantity);
                        svBanHang.updateslGioHang(newQuantity, maHDCT);
                        dtoGioHang = svBanHang.selectAllGioHang(maHD_toanCuc);
                        filltableGioHang(dtoGioHang);
                    }
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public void initTableSanPham() {
        DefaultTableModel model = (DefaultTableModel) tblDanhSachSanPham.getModel();
        model.setColumnIdentifiers(new Object[]{"ID", "Ảnh", "Mã SP", "Tên Sản Phẩm", "Loại", "Hãng"});
        //    set wweight cho cột --- căn theo indexn cột
        tblDanhSachSanPham.getColumnModel().getColumn(0).setPreferredWidth(10); // Cột ID
        tblDanhSachSanPham.getColumnModel().getColumn(2).setPreferredWidth(40); // Cột Mã sp
        tblDanhSachSanPham.getColumnModel().getColumn(4).setPreferredWidth(50); // Cột Mã sp
        tblDanhSachSanPham.getColumnModel().getColumn(5).setPreferredWidth(50); // Cột Mã sp
    }

    public void initTableCTSP() {
        DefaultTableModel model = (DefaultTableModel) tblChiTietSanPham.getModel();
        model.setColumnIdentifiers(new Object[]{"ID", "Mã SP", "Màu Sắc", "Số lượng tồn", "Giá Bán", "Mô Tả"});
    }

    public void initTableHoaDon() {
        DefaultTableModel model = (DefaultTableModel) tblDonHang.getModel();
        model.setColumnIdentifiers(new Object[]{"Mã HD", "Mã Khách Hàng", "Người Tạo", "Trạng Thái", "Ngày Tạo"});
    }

    public void initTableGioHang() {
        DefaultTableModel model = new DefaultTableModel(new Object[]{"Mã HDCT", "Mã HD", "Tên Sản Phẩm", "Hãng", "Loại", "Màu Sắc", "Số lượng", "Giá Bán", ""}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Chỉ cho phép chỉnh sửa cột thứ 6 (cột "Số lượng")
                return column == 6;
            }
        };

        tblGioHang.setModel(model);
        tblGioHang.getColumnModel().getColumn(0).setPreferredWidth(40); // Cột ID
//        tblGioHang.getColumnModel().getColumn(8).setCellRenderer(new ButtonRenderer());
//        tblGioHang.getColumnModel().getColumn(8).setCellEditor(new ButtonEditor(tblGioHang));
    }

    public void initCboVocher() {

        DefaultComboBoxModel model = (DefaultComboBoxModel) cboVocher.getModel();
        model.removeAllElements();
        for (MD_Vocher vc : listvc) {
            model.addElement(vc.getTenKM());
        }
        cboVocher.setSelectedIndex(0);

    }

    public void filltableSanPham(List<DTO_DSSP_BanHang> dto) {
        tblModel = (DefaultTableModel) tblDanhSachSanPham.getModel();
        tblModel.setRowCount(0);
        for (DTO_DSSP_BanHang l : dto) {
            Object[] row = new Object[6];

            String imagePath = l.getAnhSanPham();
            File imageFile = new File(imagePath);

            JLabel label = new JLabel();
            if (imageFile.exists()) {
                ImageIcon icon = new ImageIcon(imagePath);
                Image image = icon.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH); // Set chiều rộng và chiều cao của hình ảnh
                label.setIcon(new ImageIcon(image));
            } else {

            }
            label.setHorizontalAlignment(JLabel.CENTER);
            row[1] = label;

            row[0] = l.getIdSanPham();
            row[2] = l.getMaSanPham();
            row[3] = l.getTenSanPham();
            row[4] = l.getTenLoai();
            row[5] = l.getTenHang();
//            row[6] = l.getMoTa();

            tblModel.addRow(row);
        }

        tblDanhSachSanPham.getColumnModel().getColumn(1).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                if (value instanceof JLabel) {
                    return (JLabel) value;
                }
                return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            }
        });
        tblDanhSachSanPham.setRowHeight(70); // Đặt chiều cao hàng để vừa với hình ảnh
    }

    public void filltableCTSP(List<DTO_Ctsp_BanHang> lhd) {
        tblModel = (DefaultTableModel) tblChiTietSanPham.getModel();
        tblModel.setRowCount(0);
        for (DTO_Ctsp_BanHang l : lhd) {
            Object[] row = new Object[6];
            row[0] = l.getIdCtsp();
            row[1] = l.getMaSP();
            row[2] = l.getMauSac();
            row[3] = l.getSoLuongTon();
            row[4] = l.getGiaBan();
            row[5] = l.getMoTa();
            tblModel.addRow(row);
        }
    }

    public void filltableHoaDon(List<MD_HoaDon_CN> lhd) {
        tblModel = (DefaultTableModel) tblDonHang.getModel();
        tblModel.setRowCount(0);
        for (MD_HoaDon_CN hd : lhd) {
            Object[] row = new Object[5];
            row[0] = hd.getMaHD();
            row[1] = hd.getMaKH();
            row[2] = hd.getMaNV();
            row[3] = hd.getTrangThai();
            row[4] = hd.getNgayTao();
            tblModel.addRow(row);
        }
    }

    public void filltableGioHang(List<DTO_GioHang> lgh) {
        tblModel = (DefaultTableModel) tblGioHang.getModel();
        tblModel.setRowCount(0);
        for (DTO_GioHang gh : lgh) {
            Object[] row = new Object[9];
            row[0] = gh.getMaHDCT();
            row[1] = gh.getMaHD();
            row[2] = gh.getTenSP();
            row[3] = gh.getTenHang();
            row[4] = gh.getTenLoaiSP();
            row[5] = gh.getMauSac();
            row[6] = gh.getSoLuong();
            row[7] = gh.getGiaBan();
            row[8] = "Xóa"; // Gán giá trị "Xóa" cho cột 8
            tblModel.addRow(row);
        }
//        tblGioHang.getColumnModel().getColumn(8).setCellRenderer(new ButtonRenderer());
//        tblGioHang.getColumnModel().getColumn(8).setCellEditor(new ButtonEditor(tblGioHang));
        // Add the button column only once
//    if (tblGioHang.getColumnModel().getColumnCount() == 9) {
//        Action delete = new AbstractAction() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JTable table = (JTable) e.getSource();
//                int modelRow = Integer.valueOf(e.getActionCommand());
//                Object value = tblGioHang.getModel().getValueAt(modelRow, 0); // Lấy giá trị của row[0]
//                System.out.println("================ data cột khi chọn xóa row[0]: " + value); // In ra giá trị của row[0]
//            }
//        };
//
//        ButtonColumn buttonColumn = new ButtonColumn(tblGioHang, delete, 8);
//        buttonColumn.setMnemonic(KeyEvent.VK_D);
//    }
    }

    class ButtonColumn extends AbstractCellEditor
            implements TableCellRenderer, TableCellEditor, ActionListener {

        private JTable table;
        private Action action;
        private int mnemonic;
        private Border originalBorder;
        private Border focusBorder;

        private JButton renderButton;
        private JButton editButton;
        private Object editorValue;
        private boolean isButtonColumnEditor;

        public ButtonColumn(JTable table, Action action, int column) {
            this.table = table;
            this.action = action;

            renderButton = new JButton();
            editButton = new JButton();
            editButton.setFocusPainted(false);
            editButton.addActionListener(this);
            originalBorder = editButton.getBorder();
            setFocusBorder(new LineBorder(Color.BLUE));

            TableColumnModel columnModel = table.getColumnModel();
            columnModel.getColumn(column).setCellRenderer(this);
            columnModel.getColumn(column).setCellEditor(this);
            table.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    if (table.isEditing()
                            && table.getCellEditor() == ButtonColumn.this) {
                        isButtonColumnEditor = true;
                    }
                }

                public void mouseReleased(MouseEvent e) {
                    if (isButtonColumnEditor
                            && table.getCellEditor() == ButtonColumn.this) {
                        isButtonColumnEditor = false;
                    }
                }
            });
        }

        public void setMnemonic(int mnemonic) {
            this.mnemonic = mnemonic;
            renderButton.setMnemonic(mnemonic);
            editButton.setMnemonic(mnemonic);
        }

        public Border getFocusBorder() {
            return focusBorder;
        }

        public void setFocusBorder(Border focusBorder) {
            this.focusBorder = focusBorder;
            editButton.setBorder(focusBorder);
        }

        public int getMnemonic() {
            return mnemonic;
        }

        public Component getTableCellRendererComponent(
                JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (isSelected) {
                renderButton.setForeground(table.getSelectionForeground());
                renderButton.setBackground(table.getSelectionBackground());
            } else {
                renderButton.setForeground(table.getForeground());
                renderButton.setBackground(UIManager.getColor("Button.background"));
            }

            renderButton.setText((value == null) ? "" : value.toString());
            return renderButton;
        }

        public Component getTableCellEditorComponent(
                JTable table, Object value, boolean isSelected, int row, int column) {
            editorValue = value;
            editButton.setText((value == null) ? "" : value.toString());
            return editButton;
        }

        public Object getCellEditorValue() {
            return editorValue;
        }

        public void actionPerformed(ActionEvent e) {
            int row = table.convertRowIndexToModel(table.getEditingRow());
            fireEditingStopped();

            ActionEvent event = new ActionEvent(table, ActionEvent.ACTION_PERFORMED, "" + row);
            action.actionPerformed(event);
        }

        protected void fireEditingStopped() {
            super.fireEditingStopped();
        }
    }

    public BigDecimal billTinhTien_tongTienhang() {
        DefaultTableModel model = (DefaultTableModel) tblGioHang.getModel();
        BigDecimal total = BigDecimal.ZERO;

        for (int i = 0; i < model.getRowCount(); i++) {
            // Lấy giá trị của cột "Số lượng" và "Giá bán"
            String soLuongStr = model.getValueAt(i, 6).toString();
            String giaBanStr = model.getValueAt(i, 7).toString();

            try {
                // Chuyển đổi các giá trị này về kiểu BigDecimal
                BigDecimal soLuong = new BigDecimal(soLuongStr);
                BigDecimal giaBan = new BigDecimal(giaBanStr);

                // Nhân số lượng với giá bán
                BigDecimal thanhTien = soLuong.multiply(giaBan);

                // Cộng dồn vào tổng
                total = total.add(thanhTien);
            } catch (NumberFormatException e) {
                System.out.println("Dữ liệu không hợp lệ tại hàng " + i + ". Bỏ qua hàng này.");
            }
        }

        // Định dạng tổng tiền hàng
        NumberFormat vndFormat = NumberFormat.getInstance(new Locale("vi", "VN"));
        vndFormat.setMinimumFractionDigits(3);
        vndFormat.setMaximumFractionDigits(3);
        String formattedTotal = vndFormat.format(total);
        txtTongTienHang.setText(formattedTotal);

        String phanTramGiamct = txtPhanTramVocher.getText();
        BigDecimal phanTramGiam = new BigDecimal(phanTramGiamct);

        // Chuyển phần trăm về dạng thập phân
        BigDecimal phanTramThucTe = phanTramGiam.divide(new BigDecimal("100"));

        // Tính giá trị giảm giá
        BigDecimal giamGiaKhuyeMai = total.multiply(phanTramThucTe);

        // Định dạng giá trị giảm giá
        String formattedGiamGia = vndFormat.format(giamGiaKhuyeMai);
        txtGiamGiaKhuyenMai.setText(formattedGiamGia);

        tongThanhToan = total.subtract(giamGiaKhuyeMai);

        // Hiển thị kết quả ra console
        System.out.println("Tổng thanh toán: " + tongThanhToan);

        // Định dạng tổng thanh toán
        String formattedTongThanhToan = vndFormat.format(tongThanhToan);
        txtTongThanhToan.setText(formattedTongThanhToan);

        return tongThanhToan;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panel_Custom1 = new Swing_Custom.Panel_Custom();
        jLabel21 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JLabel();
        txtTenKH = new javax.swing.JLabel();
        txtEmail = new javax.swing.JLabel();
        txtSDTKH = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDiaChiKH = new javax.swing.JTextArea();
        jButton4 = new javax.swing.JButton();
        panel_Custom3 = new Swing_Custom.Panel_Custom();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDonHang = new javax.swing.JTable();
        btnTaoDonHang = new javax.swing.JButton();
        panel_Custom4 = new Swing_Custom.Panel_Custom();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblDanhSachSanPham = new javax.swing.JTable();
        txtTimKiemSanPham = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblChiTietSanPham = new javax.swing.JTable();
        jLabel28 = new javax.swing.JLabel();
        btnThemSP = new javax.swing.JButton();
        panel_Custom5 = new Swing_Custom.Panel_Custom();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblGioHang = new javax.swing.JTable();
        panel_Custom2 = new Swing_Custom.Panel_Custom();
        jLabel26 = new javax.swing.JLabel();
        cboVocher = new javax.swing.JComboBox<>();
        panel_Custom6 = new Swing_Custom.Panel_Custom();
        jLabel11 = new javax.swing.JLabel();
        txtPhanTramVocher = new javax.swing.JLabel();
        panel_Custom7 = new Swing_Custom.Panel_Custom();
        jLabel27 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtTongTienHang = new javax.swing.JLabel();
        txtGiamGiaKhuyenMai = new javax.swing.JLabel();
        txtTongThanhToan = new javax.swing.JLabel();
        btnThanhToan = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 153, 102));

        panel_Custom1.setBackground(new java.awt.Color(255, 255, 255));
        panel_Custom1.setRoundBottomLeft(20);
        panel_Custom1.setRoundBottomRight(20);
        panel_Custom1.setRoundTopLeft(20);
        panel_Custom1.setRoundTopRight(20);
        panel_Custom1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel21.setText("Thông Tin Khách Hàng");
        panel_Custom1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        jButton1.setText("Chọn|Thêm Khách Hàng");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panel_Custom1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(321, 6, -1, 30));

        jLabel1.setText("Mã Khách Hàng :");
        panel_Custom1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 48, -1, -1));

        jLabel2.setText("Tên Khách Hàng :");
        panel_Custom1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 76, -1, -1));

        jLabel3.setText("Số Điện Thoại:");
        panel_Custom1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 48, -1, -1));

        jLabel4.setText("Email :");
        panel_Custom1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 104, -1, -1));

        jLabel5.setText("Địa Chỉ :");
        panel_Custom1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 132, -1, -1));

        txtMaKH.setForeground(new java.awt.Color(255, 0, 51));
        panel_Custom1.add(txtMaKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 48, 132, -1));

        txtTenKH.setForeground(new java.awt.Color(255, 0, 51));
        panel_Custom1.add(txtTenKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 76, 132, -1));

        txtEmail.setForeground(new java.awt.Color(255, 0, 51));
        panel_Custom1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 104, 132, -1));

        txtSDTKH.setForeground(new java.awt.Color(255, 0, 51));
        panel_Custom1.add(txtSDTKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 48, 134, -1));

        txtDiaChiKH.setColumns(20);
        txtDiaChiKH.setForeground(new java.awt.Color(255, 0, 51));
        txtDiaChiKH.setRows(5);
        jScrollPane1.setViewportView(txtDiaChiKH);

        panel_Custom1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 132, 378, 60));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/rs.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        panel_Custom1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(484, 6, -1, 30));

        panel_Custom3.setBackground(new java.awt.Color(255, 255, 255));
        panel_Custom3.setRoundBottomLeft(20);
        panel_Custom3.setRoundBottomRight(20);
        panel_Custom3.setRoundTopLeft(20);
        panel_Custom3.setRoundTopRight(20);

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel23.setText("Đơn Hàng");

        tblDonHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDonHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDonHangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDonHang);

        btnTaoDonHang.setBackground(new java.awt.Color(255, 0, 0));
        btnTaoDonHang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTaoDonHang.setForeground(new java.awt.Color(255, 255, 255));
        btnTaoDonHang.setText("Tạo Hóa Đơn");
        btnTaoDonHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoDonHangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_Custom3Layout = new javax.swing.GroupLayout(panel_Custom3);
        panel_Custom3.setLayout(panel_Custom3Layout);
        panel_Custom3Layout.setHorizontalGroup(
            panel_Custom3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Custom3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_Custom3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(panel_Custom3Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTaoDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panel_Custom3Layout.setVerticalGroup(
            panel_Custom3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Custom3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_Custom3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(btnTaoDonHang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        panel_Custom4.setBackground(new java.awt.Color(255, 255, 255));
        panel_Custom4.setRoundBottomLeft(20);
        panel_Custom4.setRoundBottomRight(20);
        panel_Custom4.setRoundTopLeft(20);
        panel_Custom4.setRoundTopRight(20);

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel24.setText("Danh Sách Sản Phẩm");

        tblDanhSachSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDanhSachSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachSanPhamMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblDanhSachSanPham);

        txtTimKiemSanPham.setBackground(new java.awt.Color(102, 102, 102));
        txtTimKiemSanPham.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTimKiemSanPham.setForeground(new java.awt.Color(255, 204, 51));
        txtTimKiemSanPham.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemSanPhamKeyReleased(evt);
            }
        });

        tblChiTietSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblChiTietSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChiTietSanPhamMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblChiTietSanPham);

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel28.setText("Chi Tiết Sản Phẩm");

        btnThemSP.setBackground(new java.awt.Color(0, 153, 255));
        btnThemSP.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnThemSP.setForeground(new java.awt.Color(255, 255, 255));
        btnThemSP.setText("Thêm Sản Phẩm");
        btnThemSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_Custom4Layout = new javax.swing.GroupLayout(panel_Custom4);
        panel_Custom4.setLayout(panel_Custom4Layout);
        panel_Custom4Layout.setHorizontalGroup(
            panel_Custom4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Custom4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_Custom4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
                    .addGroup(panel_Custom4Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTimKiemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_Custom4Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
                    .addComponent(btnThemSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel_Custom4Layout.setVerticalGroup(
            panel_Custom4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Custom4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_Custom4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txtTimKiemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThemSP, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_Custom5.setBackground(new java.awt.Color(255, 255, 255));
        panel_Custom5.setRoundBottomLeft(20);
        panel_Custom5.setRoundBottomRight(20);
        panel_Custom5.setRoundTopLeft(20);
        panel_Custom5.setRoundTopRight(20);

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel25.setText("Giỏ Hàng");

        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblGioHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGioHangMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblGioHang);

        panel_Custom2.setBackground(new java.awt.Color(204, 204, 204));
        panel_Custom2.setRoundBottomLeft(15);
        panel_Custom2.setRoundBottomRight(15);
        panel_Custom2.setRoundTopLeft(15);
        panel_Custom2.setRoundTopRight(15);

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel26.setText("Vocher");

        cboVocher.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cboVocher.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboVocherItemStateChanged(evt);
            }
        });
        cboVocher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboVocherActionPerformed(evt);
            }
        });

        panel_Custom6.setBackground(new java.awt.Color(255, 255, 255));
        panel_Custom6.setRoundBottomLeft(15);
        panel_Custom6.setRoundBottomRight(15);
        panel_Custom6.setRoundTopLeft(15);
        panel_Custom6.setRoundTopRight(15);

        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setText("%");

        txtPhanTramVocher.setForeground(new java.awt.Color(255, 0, 0));
        txtPhanTramVocher.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtPhanTramVocher.setText("0");

        javax.swing.GroupLayout panel_Custom6Layout = new javax.swing.GroupLayout(panel_Custom6);
        panel_Custom6.setLayout(panel_Custom6Layout);
        panel_Custom6Layout.setHorizontalGroup(
            panel_Custom6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_Custom6Layout.createSequentialGroup()
                .addComponent(txtPhanTramVocher, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );
        panel_Custom6Layout.setVerticalGroup(
            panel_Custom6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtPhanTramVocher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_Custom2Layout = new javax.swing.GroupLayout(panel_Custom2);
        panel_Custom2.setLayout(panel_Custom2Layout);
        panel_Custom2Layout.setHorizontalGroup(
            panel_Custom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Custom2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_Custom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_Custom2Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panel_Custom2Layout.createSequentialGroup()
                        .addComponent(cboVocher, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panel_Custom6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panel_Custom2Layout.setVerticalGroup(
            panel_Custom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Custom2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_Custom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel_Custom6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboVocher))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_Custom7.setBackground(new java.awt.Color(241, 227, 227));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel27.setText("Chi tiết thanh toán");

        jLabel12.setBackground(new java.awt.Color(102, 102, 102));
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("Tổng tiền hàng");

        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Giảm giá khuyến mãi");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Tổng Thanh Toán");

        txtTongTienHang.setBackground(new java.awt.Color(102, 102, 102));
        txtTongTienHang.setForeground(new java.awt.Color(102, 102, 102));
        txtTongTienHang.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtTongTienHang.setText("123.000");

        txtGiamGiaKhuyenMai.setBackground(new java.awt.Color(102, 102, 102));
        txtGiamGiaKhuyenMai.setForeground(new java.awt.Color(102, 102, 102));
        txtGiamGiaKhuyenMai.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtGiamGiaKhuyenMai.setText("123.000");

        txtTongThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTongThanhToan.setForeground(new java.awt.Color(255, 0, 51));
        txtTongThanhToan.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtTongThanhToan.setText("123.000");

        javax.swing.GroupLayout panel_Custom7Layout = new javax.swing.GroupLayout(panel_Custom7);
        panel_Custom7.setLayout(panel_Custom7Layout);
        panel_Custom7Layout.setHorizontalGroup(
            panel_Custom7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Custom7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_Custom7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_Custom7Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtGiamGiaKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_Custom7Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTongThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_Custom7Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panel_Custom7Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTongTienHang, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panel_Custom7Layout.setVerticalGroup(
            panel_Custom7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Custom7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_Custom7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtTongTienHang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_Custom7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtGiamGiaKhuyenMai))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_Custom7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtTongThanhToan))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnThanhToan.setBackground(new java.awt.Color(0, 153, 255));
        btnThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnThanhToan.setForeground(new java.awt.Color(255, 255, 255));
        btnThanhToan.setText("Thanh Toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        jLabel6.setText("Nhấn 2 Click liên tiếp để xóa sản phẩm khỏi giỏ hàng !");

        javax.swing.GroupLayout panel_Custom5Layout = new javax.swing.GroupLayout(panel_Custom5);
        panel_Custom5.setLayout(panel_Custom5Layout);
        panel_Custom5Layout.setHorizontalGroup(
            panel_Custom5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Custom5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_Custom5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_Custom7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                    .addComponent(panel_Custom2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panel_Custom5Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6))
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel_Custom5Layout.setVerticalGroup(
            panel_Custom5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Custom5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_Custom5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_Custom2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_Custom7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel_Custom1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_Custom4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel_Custom5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_Custom3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel_Custom3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_Custom1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel_Custom4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_Custom5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new BanHang_KhachHang().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        // TODO add your handling code here:
        //Đang tạo 
        //Đang Trả Góp 
        //Hoàn tất
        if (dtoGioHang == null || dtoGioHang.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Giỏ hàng trống. Vui thêm sản phẩm vào đơn hàng mới được thanh toán!", "Thông Báo Hệ Thống", JOptionPane.ERROR_MESSAGE);
        } else if (dtoGioHang != null || !dtoGioHang.isEmpty()) {
            int response = JOptionPane.showConfirmDialog(this, "Xác nhận thanh toán ?", "Thông Báo Hệ Thống", 0, 3, null);
            if (response == JOptionPane.YES_OPTION) {

                for (DTO_GioHang gh : dtoGioHang) {

                    // Chuyển đổi số lượng thành BigDecimal
                    BigDecimal soLuong = new BigDecimal(gh.getSoLuong());

                    // Lấy giá bán từ gh và đảm bảo nó không có ký tự không hợp lệ
                    BigDecimal giaBan = gh.getGiaBan();

                    // Nhân số lượng với giá bán để tính thành tiền
                    BigDecimal thanhTien = soLuong.multiply(giaBan);
                    // In giá trị thành tiền để kiểm tra
                    System.out.println("Thành tiến thanh toán: " + thanhTien + " của HDCT: " + gh.getMaHDCT());

                    // Cập nhật HDCT
                    svBanHang.updateHDCT(gh.getSoLuong(), gh.getGiaBan(), thanhTien, gh.getMaHDCT());

                    // Chuyển đổi tổng thanh toán từ TextField thành BigDecimal
                    String tongThanhToanString = txtTongThanhToan.getText().replace(',', '.');

                    // Loại bỏ các ký tự không phải số hoặc dấu chấm
                    tongThanhToanString = tongThanhToanString.replaceAll("[^\\d.]", "");

                    // Kiểm tra và loại bỏ các dấu chấm thừa
                    int firstDotIndex = tongThanhToanString.indexOf('.');
                    int lastDotIndex = tongThanhToanString.lastIndexOf('.');
                    if (firstDotIndex != lastDotIndex) {
                        tongThanhToanString = tongThanhToanString.substring(0, lastDotIndex).replaceAll("\\.", "") + tongThanhToanString.substring(lastDotIndex);
                    }

                    // Chuyển đổi chuỗi thành BigDecimal
                    BigDecimal tongTien = new BigDecimal(tongThanhToanString);
                    System.out.println("=================Tổng tiền: " + tongTien);
                    System.out.println("===================Mã HD ToanCuc: " + maHD_toanCuc);

                    // Cập nhật HD (bạn có thể bỏ ghi chú để gọi phương thức này nếu cần)
                    for (MD_Vocher v : listvc) {
                        if (v.getTenKM().equals(cboVocher.getSelectedItem().toString())) {
                            svBanHang.updateHD(tongTien, v.getIdKM(), maHD_toanCuc);
                            dtoHoaDon = svBanHang.selectAllHoaDon();
                        }
                    }
                }

                filltableHoaDon(dtoHoaDon);
                JOptionPane.showMessageDialog(this, "Thanh toán thành công");
                FirstPdf pdf = new FirstPdf(maHD_toanCuc, "NVTest", Integer.parseInt(txtMaKH.getText()), txtTenKH.getText(), txtSDTKH.getText(), txtTongTienHang.getText(), txtGiamGiaKhuyenMai.getText(), txtTongThanhToan.getText());
                pdf.run();

                tblDonHang.clearSelection();
                tblDanhSachSanPham.clearSelection();
                idctsp_toanCuc = null;
                idsp = null;
                tblModel = (DefaultTableModel) tblChiTietSanPham.getModel();
                tblModel.setRowCount(0);
                tblModel = (DefaultTableModel) tblGioHang.getModel();
                tblModel.setRowCount(0);
                cboVocher.setSelectedIndex(0);
                txtMaKH.setText("");
                txtTenKH.setText("");
                txtSDTKH.setText("");
                txtEmail.setText("");
                txtDiaChiKH.setText("");

            } else if (response == JOptionPane.NO_OPTION) {

            }
        }

    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        Model_khachhang mdkh = DataHolder.getInstance().getMdkh();
        if (!mdkh.equals(null)) {
            txtMaKH.setText(String.valueOf(mdkh.getMaKH()));
            txtTenKH.setText(mdkh.getTenKH());
            txtSDTKH.setText(mdkh.getSDT());
            txtEmail.setText(mdkh.getEmail());
            txtDiaChiKH.setText(mdkh.getDiaChi());
            //Set data lên biến toàn cục
            mdkh_ToanCuc.setMaKH(mdkh.getMaKH());
            mdkh_ToanCuc.setTenKH(mdkh.getTenKH());
            mdkh_ToanCuc.setSDT(mdkh.getSDT());
            mdkh_ToanCuc.setEmail(mdkh.getEmail());
            mdkh_ToanCuc.setDiaChi(mdkh.getDiaChi());
            System.out.println("Thông tin khách hàng set toàn cục : " + mdkh_ToanCuc);
        } else {
            JOptionPane.showMessageDialog(this, "Thông tin khách hàng chưa được chọn !", "Thông Báo Hệ Thống", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtTimKiemSanPhamKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemSanPhamKeyReleased
        // TODO add your handling code here:
        String text = txtTimKiemSanPham.getText();
        if (text.trim().length() == 0) {
            rowSorter.setRowFilter(null);
        } else {
            rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
        }
        System.out.println("Kí tự được nhập vào input timf kiếm :" + txtTimKiemSanPham.getText());

    }//GEN-LAST:event_txtTimKiemSanPhamKeyReleased

    private void btnThemSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSPActionPerformed
        // TODO add your handling code here:
        System.out.println("Max spp trc khi chayj theem sp : " + idsp);
        if (maHD_toanCuc == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn trước khi thêm sản phẩm vào giỏ hàng tại bảng [Đơn hàng]", "Thông Báo Hệ Thống", JOptionPane.ERROR_MESSAGE);
        } else if (idsp == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng sản phẩm cần mua tại bảng [Danh sách sản phẩm]", "Thông Báo Hệ Thống", JOptionPane.ERROR_MESSAGE);
        } else if (idctsp_toanCuc == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng Phiên bản sản phẩm cần mua tại bảng [Chi tiết sản phẩm]", "Thông Báo Hệ Thống", JOptionPane.ERROR_MESSAGE);
        } else {
            inputSoluong_toanCuc = JOptionPane.showInputDialog("Nhập số lượng cần mua ?", 1);
            System.out.println("=========================================================================");
            System.out.println("Đã chọn hóa đơn với mã hóa đơn : " + maHD_toanCuc);
            System.out.println("CTSP đã chọn : " + idctsp_toanCuc + " Giá chi tiết sản phẩm đã chọn : " + giaCTSP);
            System.out.println("Số lượng input  ctsp: " + inputSoluong_toanCuc);

            BigDecimal soLuong = new BigDecimal(inputSoluong_toanCuc);

            // Tính thành tiền bằng cách nhân giá với số lượng
            BigDecimal thanhTienCTSP = giaCTSP.multiply(soLuong);
            System.out.println("Sum gía số lương : " + thanhTienCTSP);

            svBanHang.themCTSPVaoGioHang_HDCT(maHD_toanCuc, idctsp_toanCuc, Integer.parseInt(inputSoluong_toanCuc), giaCTSP, thanhTienCTSP);
            dtoGioHang = svBanHang.selectAllGioHang(maHD_toanCuc);
            filltableGioHang(dtoGioHang);
            billTinhTien_tongTienhang();
        }
    }//GEN-LAST:event_btnThemSPActionPerformed

    private void tblDanhSachSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachSanPhamMouseClicked
        // TODO add your handling code here:
        if (txtMaKH.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn thông tin khách hàng trước khi tạo đơn . Chọn xong nhấn Reload lại để thông tin khách hàng được cập nhật hiện lên From ! ", "Thông Báo Hệ Thống", JOptionPane.ERROR_MESSAGE);
        } else if (maHD_toanCuc == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn trước khi thêm sản phẩm vào giỏ hàng tại bảng [Đơn hàng]", "Thông Báo Hệ Thống", JOptionPane.ERROR_MESSAGE);
        } else {
            int viewRow = tblDanhSachSanPham.getSelectedRow();
            if (viewRow != -1) {
                // Chuyển đổi chỉ số hàng từ chế độ xem sang mô hình
                int modelRow = tblDanhSachSanPham.convertRowIndexToModel(viewRow);
                // Lấy giá trị từ cột 0 của hàng trong mô hình
                idsp = tblDanhSachSanPham.getModel().getValueAt(modelRow, 0).toString();
                System.out.println("ID Sản Phẩm : " + idsp);

                // Sử dụng idsp để lấy chi tiết sản phẩm và cập nhật bảng
                dtoCTSP = svBanHang.selectAllctsp_ByIDSP(Integer.parseInt(idsp));
                filltableCTSP(dtoCTSP);
            }
        }
    }//GEN-LAST:event_tblDanhSachSanPhamMouseClicked

    private void btnTaoDonHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoDonHangActionPerformed
        // TODO add your handling code here:
        //Đang tạo 
        //Đang Trả Góp 
        //Hoàn tất
//        System.out.println("List Khách Hàng : "+mdkh_ToanCuc);
        if (txtMaKH.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn thông tin khách hàng trước khi tạo đơn . Chọn xong nhấn Reload lại để thông tin khách hàng được cập nhật hiện lên From ! ", "Thông Báo Hệ Thống", JOptionPane.ERROR_MESSAGE);
        } else {
            svBanHang.taoDon(Integer.parseInt(txtMaKH.getText()), "NV001");
            dtoHoaDon = svBanHang.selectAllHoaDon();
            filltableHoaDon(dtoHoaDon);
        }


    }//GEN-LAST:event_btnTaoDonHangActionPerformed

    private void tblDonHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDonHangMouseClicked
        // TODO add your handling code here:
        Integer idHD;
        int indexHienTai = tblDonHang.getSelectedRow();
//        if (!txtMaKH.getText().isEmpty()) {

        if (indexCu == null || !indexCu.equals(indexHienTai)) {
            idHD = dtoHoaDon.get(indexHienTai).getMaHD();
            int response = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn chọn hóa đơn bán hàng " + idHD + " không ?", "Thông Báo Hệ Thống", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
            if (response == JOptionPane.YES_OPTION) {

                JOptionPane.showMessageDialog(this, "Chọn thành công hóa đơn " + idHD);
                dtoGioHang = svBanHang.selectAllGioHang(idHD);
                indexCu = indexHienTai;
                if (dtoGioHang != null) {
                    maHD_toanCuc = dtoHoaDon.get(indexHienTai).getMaHD();
                    filltableGioHang(dtoGioHang);
                } else {
                    maHD_toanCuc = null;
                    tblModel.setRowCount(0);
                }
                billTinhTien_tongTienhang();
//                    tblDanhSachSanPham.clearSelection();
//                    tblGioHang.clearSelection();
//                    maHD_toanCuc = null;

                tblDanhSachSanPham.clearSelection();
                tblModel = (DefaultTableModel) tblChiTietSanPham.getModel();
                tblModel.setRowCount(0);
                idctsp_toanCuc = null;
                idsp = null;
                Integer idKhachHang = dtoHoaDon.get(indexHienTai).getMaKH();
                DTO_KhachHang kh = svBanHang.selectAllKhachHang(idKhachHang);
                txtMaKH.setText(String.valueOf(kh.getMaKH()));
                txtTenKH.setText(kh.getTenKH());
                txtSDTKH.setText(kh.getSDT());
                txtEmail.setText(kh.getEmail());
                txtDiaChiKH.setText(kh.getDiaChi());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chỉ nhấn 1 lần duy nhất để chọn sản phẩm");
        }
//        } 
//else {
//            JOptionPane.showMessageDialog(this, "Vui lòng chọn thông tin khách hàng trước khi tạo đơn . Chọn xong nhấn Reload lại để thông tin khách hàng được cập nhật hiện lên From ! ", "Thông Báo Hệ Thống", JOptionPane.ERROR_MESSAGE);
//            tblDonHang.clearSelection();
//        }


    }//GEN-LAST:event_tblDonHangMouseClicked

    private void cboVocherItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboVocherItemStateChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_cboVocherItemStateChanged

    private void cboVocherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboVocherActionPerformed
        // TODO add your handling code here:
        for (MD_Vocher v : listvc) {
            if (v.getTenKM().equals(cboVocher.getSelectedItem())) {
                txtPhanTramVocher.setText(v.getPhanTramKM());
            }
        }
        System.out.println("Data vocher đã chọn " + cboVocher.getSelectedItem());
        billTinhTien_tongTienhang();
    }//GEN-LAST:event_cboVocherActionPerformed

    private void tblChiTietSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChiTietSanPhamMouseClicked
        // TODO add your handling code here:
        int index = tblChiTietSanPham.getSelectedRow();
        idctsp_toanCuc = dtoCTSP.get(index).getIdCtsp();
        giaCTSP = dtoCTSP.get(index).getGiaBan();
    }//GEN-LAST:event_tblChiTietSanPhamMouseClicked

    private void tblGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGioHangMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            int response = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa sản phẩm này ra khỏi giỏ hàng không ?", "Thông Báo Hệ Thống", 0, 3, null);
            if (response == JOptionPane.YES_OPTION) {
                int index = tblGioHang.getSelectedRow();
                Integer idDHCT = dtoGioHang.get(index).getMaHDCT();
                System.out.println("Mã Hóa đơn chi tiết xóa == " + idDHCT);
                svBanHang.deleteSP_GioHang(idDHCT);
                dtoGioHang = svBanHang.selectAllGioHang(maHD_toanCuc);
                filltableGioHang(dtoGioHang);
            } else if (response == JOptionPane.NO_OPTION) {

            }
        }
    }//GEN-LAST:event_tblGioHangMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTaoDonHang;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThemSP;
    private javax.swing.JComboBox<String> cboVocher;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private Swing_Custom.Panel_Custom panel_Custom1;
    private Swing_Custom.Panel_Custom panel_Custom2;
    private Swing_Custom.Panel_Custom panel_Custom3;
    private Swing_Custom.Panel_Custom panel_Custom4;
    private Swing_Custom.Panel_Custom panel_Custom5;
    private Swing_Custom.Panel_Custom panel_Custom6;
    private Swing_Custom.Panel_Custom panel_Custom7;
    private javax.swing.JTable tblChiTietSanPham;
    private javax.swing.JTable tblDanhSachSanPham;
    private javax.swing.JTable tblDonHang;
    private javax.swing.JTable tblGioHang;
    private javax.swing.JTextArea txtDiaChiKH;
    private javax.swing.JLabel txtEmail;
    private javax.swing.JLabel txtGiamGiaKhuyenMai;
    private javax.swing.JLabel txtMaKH;
    private javax.swing.JLabel txtPhanTramVocher;
    private javax.swing.JLabel txtSDTKH;
    private javax.swing.JLabel txtTenKH;
    private javax.swing.JTextField txtTimKiemSanPham;
    private javax.swing.JLabel txtTongThanhToan;
    private javax.swing.JLabel txtTongTienHang;
    // End of variables declaration//GEN-END:variables
}
