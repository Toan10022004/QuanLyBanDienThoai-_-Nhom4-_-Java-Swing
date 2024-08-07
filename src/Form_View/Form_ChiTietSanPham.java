/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Form_View;

import DTO.DTO_Ctsp;
import DTO.DTO_DanhSachSanPham;
import Service.SV_CTSP;
import Service.SV_DanhSachSanPham;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 84904
 */
public class Form_ChiTietSanPham extends javax.swing.JFrame {

    List<DTO_Ctsp> listdtoCTDSSP = new ArrayList<>();
    DefaultTableModel tblModel;
    SV_DanhSachSanPham SVDSSP = new SV_DanhSachSanPham();
    SV_CTSP SVCTSP = new SV_CTSP();
    DTO_DanhSachSanPham dtoDSSP = new DTO_DanhSachSanPham();
    Integer idsp_ToanCuc1;
    Integer idCTSP_ToanCuc;

    /**
     * Creates new form Form_ChiTietSanPham1
     */
    public Form_ChiTietSanPham(Integer idsp_ToanCuc) {
        initComponents();
        this.setLocationRelativeTo(this);
        //JFrame.HIDE_ON_CLOSE  //sẽ bị ẩn nhưng vẫn tồn tại, và chương trình sẽ tiếp tục chạy.
        this.setDefaultCloseOperation(Form_ChiTietSanPham.DISPOSE_ON_CLOSE);//sẽ được đóng và tài nguyên của nó sẽ được giải phóng, nhưng chương trình sẽ vẫn tiếp tục chạy.
        dtoDSSP = SVDSSP.selectAllDSSByIDSP(idsp_ToanCuc);
        setFormSanPham(dtoDSSP);
        rdoHoatDong.setEnabled(false);
        rdoNgungHoatDong.setEnabled(false);
        rdoHoatDong.setSelected(true);
        initTable();

        idsp_ToanCuc1 = idsp_ToanCuc;
        listdtoCTDSSP = SVCTSP.selectAllCTSPByIDSP(idsp_ToanCuc1);
        filltableHang(listdtoCTDSSP);

    }

    public void initTable() {
        DefaultTableModel model = (DefaultTableModel) tblDSCTSP.getModel();
        model.setColumnIdentifiers(new Object[]{"Mã Sản Phẩm", "ID CTSP", "Màu Sắc", "Số Lượng Tồn", "Ghi Chú", "Giá bán", "Trạng Thái", "Ngày Tạo", "Ngày Sửa",});
    }

    public void filltableHang(List<DTO_Ctsp> dto) {
        tblModel = (DefaultTableModel) tblDSCTSP.getModel();
        tblModel.setRowCount(0);
        for (DTO_Ctsp ct : dto) {
            Object[] row = new Object[9];
            row[0] = ct.getMaSP();
            row[1] = ct.getIdCtsp();
            row[2] = ct.getMauSac();
            row[3] = ct.getSoLuongTon();
            row[4] = ct.getMoTa();
            row[5] = ct.getGiaBan();
            row[6] = ct.getTrangThai();
            row[7] = ct.getNgayTao();
            row[8] = ct.getNgaySua();
            tblModel.addRow(row);
        }
    }

    public void setFormSanPham(DTO_DanhSachSanPham dto) {
        jlbMaSanPham.setText(dto.getMaSanPham());
        jlbTenSanPham.setText(dto.getTenSanPham());
        jlbLoaiSanPham.setText(dto.getTenLoaiSP());
        jlbHang.setText(dto.getTenHang());
        jlbTrangThai.setText(dto.getTrangThai());
        jlbMoTa.setText(dto.getMoTa());

        ImageIcon icon = new ImageIcon(dto.getAnhSanPham());

        txtImageSanPham.setIcon(icon);
        txtImageSanPham.setText("");
    }

    public void resetForm() {
        txtMauSac.setText("");
        txtSoLuongTon.setText("");
        txtGiaBan.setText("");
        txtGhiChu.setText("");
        rdoHoatDong.setEnabled(false);
        rdoNgungHoatDong.setEnabled(false);
        rdoHoatDong.setSelected(true);
    }

    public DTO_Ctsp getModel() {
        DTO_Ctsp dtoct = new DTO_Ctsp();
        if (txtMauSac.getText() != null && !txtMauSac.getText().isEmpty()
                && txtSoLuongTon.getText() != null && !txtSoLuongTon.getText().isEmpty()
                && txtGiaBan.getText() != null && !txtGiaBan.getText().isEmpty()) {
            dtoct.setMauSac(txtMauSac.getText());
            dtoct.setSoLuongTon(Integer.parseInt(txtSoLuongTon.getText()));

            try {
                String giaBanStr = txtGiaBan.getText();
                BigDecimal giaBan = new BigDecimal(giaBanStr);
                dtoct.setGiaBan(giaBan);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                // Hiển thị thông báo lỗi cho người dùng hoặc ghi log
            }
            dtoct.setMoTa(txtGhiChu.getText());

            if (rdoHoatDong.isSelected() == true) {
                dtoct.setTrangThai("Hoạt động");
            } else if (rdoNgungHoatDong.isSelected() == true) {
                dtoct.setTrangThai("Ngưng hoạt động");
            }
            return dtoct;
        } else {
            if (txtMauSac.getText() == null || txtMauSac.getText().isEmpty()) {
                txtMauSac.requestFocus();
                JOptionPane.showMessageDialog(this, "Vui lòng không để trống màu sắc !", "Thông Báo Hệ Thống", JOptionPane.WARNING_MESSAGE);
            } else if (txtSoLuongTon.getText() == null || txtSoLuongTon.getText().isEmpty()) {
                txtSoLuongTon.requestFocus();
                JOptionPane.showMessageDialog(this, "Vui lòng không để trống số lượng tồn !", "Thông Báo Hệ Thống", JOptionPane.WARNING_MESSAGE);
            } else if (txtGiaBan.getText() == null || txtGiaBan.getText().isEmpty()) {
                txtGiaBan.requestFocus();
                JOptionPane.showMessageDialog(this, "Vui lòng không để trống Giá Bán!", "Thông Báo Hệ Thống", JOptionPane.WARNING_MESSAGE);
            }
            return null;
        }

    }

    public void setModel(DTO_Ctsp dto1) {
        txtMauSac.setText(dto1.getMauSac());
        txtSoLuongTon.setText(String.valueOf(dto1.getSoLuongTon()));
        BigDecimal giaBan = dto1.getGiaBan();
        if (giaBan != null) {
            txtGiaBan.setText(giaBan.toString());
        }
        txtGhiChu.setText(dto1.getMoTa());
        if (dto1.getTrangThai().equalsIgnoreCase("Hoạt động")) {
            rdoHoatDong.setSelected(true);
        } else if (dto1.getTrangThai().equalsIgnoreCase("Ngưng hoạt động")) {
            rdoNgungHoatDong.setSelected(true);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panel_Custom4 = new Swing_Custom.Panel_Custom();
        panel_Custom6 = new Swing_Custom.Panel_Custom();
        jLabel21 = new javax.swing.JLabel();
        jlbImage = new javax.swing.JPanel();
        txtImageSanPham = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jlbMaSanPham = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jlbTenSanPham = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jlbLoaiSanPham = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jlbHang = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jlbTrangThai = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlbMoTa = new javax.swing.JTextArea();
        panel_Custom3 = new Swing_Custom.Panel_Custom();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDSCTSP = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        panel_Custom2 = new Swing_Custom.Panel_Custom();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtMauSac = new javax.swing.JTextField();
        txtSoLuongTon = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        rdoHoatDong = new javax.swing.JRadioButton();
        rdoNgungHoatDong = new javax.swing.JRadioButton();
        btnThemMoi = new Swing_Custom.CustomButton1();
        btnSua = new Swing_Custom.CustomButton1();
        txtGiaBan = new javax.swing.JTextField();
        btnXoa = new Swing_Custom.CustomButton1();
        btnLamMoi = new Swing_Custom.CustomButton1();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel_Custom4.setBackground(new java.awt.Color(255, 153, 102));

        panel_Custom6.setRoundBottomLeft(25);
        panel_Custom6.setRoundBottomRight(25);
        panel_Custom6.setRoundTopLeft(25);
        panel_Custom6.setRoundTopRight(25);

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel21.setText("Sản Phẩm");

        jlbImage.setBackground(new java.awt.Color(204, 204, 255));

        txtImageSanPham.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtImageSanPham.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtImageSanPham.setText("Ảnh sản phẩm");

        javax.swing.GroupLayout jlbImageLayout = new javax.swing.GroupLayout(jlbImage);
        jlbImage.setLayout(jlbImageLayout);
        jlbImageLayout.setHorizontalGroup(
            jlbImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtImageSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jlbImageLayout.setVerticalGroup(
            jlbImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtImageSanPham, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel3.setText("Mã Sản Phẩm");

        jlbMaSanPham.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlbMaSanPham.setForeground(new java.awt.Color(101, 85, 143));
        jlbMaSanPham.setText("jLabel7");

        jLabel8.setText("Tên Sản Phẩm");

        jlbTenSanPham.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlbTenSanPham.setForeground(new java.awt.Color(101, 85, 143));
        jlbTenSanPham.setText("jLabel7");

        jLabel10.setText("Trạng Thái");

        jlbLoaiSanPham.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlbLoaiSanPham.setForeground(new java.awt.Color(101, 85, 143));
        jlbLoaiSanPham.setText("jLabel7");

        jLabel12.setText("Hãng");

        jlbHang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlbHang.setForeground(new java.awt.Color(101, 85, 143));
        jlbHang.setText("jLabel7");

        jLabel14.setText("Loại Sản Phẩm");

        jlbTrangThai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlbTrangThai.setForeground(new java.awt.Color(101, 85, 143));
        jlbTrangThai.setText("jLabel7");

        jLabel16.setText("Mô tả");

        jlbMoTa.setColumns(20);
        jlbMoTa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlbMoTa.setForeground(new java.awt.Color(101, 85, 143));
        jlbMoTa.setRows(5);
        jlbMoTa.setEnabled(false);
        jScrollPane1.setViewportView(jlbMoTa);

        javax.swing.GroupLayout panel_Custom6Layout = new javax.swing.GroupLayout(panel_Custom6);
        panel_Custom6.setLayout(panel_Custom6Layout);
        panel_Custom6Layout.setHorizontalGroup(
            panel_Custom6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Custom6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panel_Custom6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_Custom6Layout.createSequentialGroup()
                        .addGroup(panel_Custom6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_Custom6Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_Custom6Layout.createSequentialGroup()
                                .addGap(0, 231, Short.MAX_VALUE)
                                .addGroup(panel_Custom6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addGroup(panel_Custom6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_Custom6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jlbMaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8))
                                        .addComponent(jlbTenSanPham, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jlbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16))))
                        .addGroup(panel_Custom6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbLoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(jlbHang, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)))
                    .addGroup(panel_Custom6Layout.createSequentialGroup()
                        .addComponent(jlbImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17))
        );
        panel_Custom6Layout.setVerticalGroup(
            panel_Custom6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Custom6Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_Custom6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panel_Custom6Layout.createSequentialGroup()
                        .addGroup(panel_Custom6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel14))
                        .addGap(6, 6, 6)
                        .addGroup(panel_Custom6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlbMaSanPham)
                            .addComponent(jlbLoaiSanPham))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel_Custom6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_Custom6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlbTenSanPham)
                            .addComponent(jlbHang))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlbTrangThai)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jlbImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_Custom3.setRoundBottomLeft(25);
        panel_Custom3.setRoundBottomRight(25);
        panel_Custom3.setRoundTopLeft(25);
        panel_Custom3.setRoundTopRight(25);

        tblDSCTSP.setModel(new javax.swing.table.DefaultTableModel(
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
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSCTSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSCTSPMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblDSCTSP);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Danh Sách Chi Tiết Sản Phẩm");

        javax.swing.GroupLayout panel_Custom3Layout = new javax.swing.GroupLayout(panel_Custom3);
        panel_Custom3.setLayout(panel_Custom3Layout);
        panel_Custom3Layout.setHorizontalGroup(
            panel_Custom3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Custom3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_Custom3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(panel_Custom3Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panel_Custom3Layout.setVerticalGroup(
            panel_Custom3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_Custom3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panel_Custom2.setRoundBottomLeft(25);
        panel_Custom2.setRoundBottomRight(25);
        panel_Custom2.setRoundTopLeft(25);
        panel_Custom2.setRoundTopRight(25);

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setText("Chi Tiết Sản Phẩm");

        jLabel18.setText("Màu Sắc");

        jLabel20.setText("Số Lượng Tồn");

        jLabel24.setText("Ghi Chú");

        jLabel26.setText("Giá Bán");

        txtMauSac.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtMauSac.setForeground(new java.awt.Color(101, 85, 143));
        txtMauSac.setPreferredSize(new java.awt.Dimension(300, 30));

        txtSoLuongTon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtSoLuongTon.setForeground(new java.awt.Color(101, 85, 143));
        txtSoLuongTon.setPreferredSize(new java.awt.Dimension(300, 30));

        jLabel25.setText("Trạng Thái");

        buttonGroup1.add(rdoHoatDong);
        rdoHoatDong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdoHoatDong.setForeground(new java.awt.Color(101, 85, 143));
        rdoHoatDong.setText("Hoạt Động");

        buttonGroup1.add(rdoNgungHoatDong);
        rdoNgungHoatDong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdoNgungHoatDong.setForeground(new java.awt.Color(101, 85, 143));
        rdoNgungHoatDong.setText("Ngưng Hoạt Động");
        rdoNgungHoatDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNgungHoatDongActionPerformed(evt);
            }
        });

        btnThemMoi.setBackground(new java.awt.Color(101, 85, 143));
        btnThemMoi.setForeground(new java.awt.Color(255, 255, 255));
        btnThemMoi.setText("Thêm mới ");
        btnThemMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMoiActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(101, 85, 143));
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        txtGiaBan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtGiaBan.setForeground(new java.awt.Color(101, 85, 143));
        txtGiaBan.setPreferredSize(new java.awt.Dimension(300, 30));

        btnXoa.setBackground(new java.awt.Color(101, 85, 143));
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnLamMoi.setBackground(new java.awt.Color(255, 255, 255));
        btnLamMoi.setText("Làm Mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        txtGhiChu.setColumns(20);
        txtGhiChu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtGhiChu.setForeground(new java.awt.Color(101, 85, 143));
        txtGhiChu.setRows(5);
        jScrollPane2.setViewportView(txtGhiChu);

        javax.swing.GroupLayout panel_Custom2Layout = new javax.swing.GroupLayout(panel_Custom2);
        panel_Custom2.setLayout(panel_Custom2Layout);
        panel_Custom2Layout.setHorizontalGroup(
            panel_Custom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Custom2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panel_Custom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_Custom2Layout.createSequentialGroup()
                        .addGroup(panel_Custom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel26))
                        .addGap(18, 18, 18)
                        .addGroup(panel_Custom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSoLuongTon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtGiaBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panel_Custom2Layout.createSequentialGroup()
                        .addComponent(btnThemMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLamMoi, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
                    .addGroup(panel_Custom2Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(48, 48, 48)
                        .addComponent(txtMauSac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panel_Custom2Layout.createSequentialGroup()
                        .addGroup(panel_Custom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addGroup(panel_Custom2Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addGap(38, 38, 38)
                                .addComponent(rdoHoatDong)
                                .addGap(31, 31, 31)
                                .addComponent(rdoNgungHoatDong)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panel_Custom2Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addGap(52, 52, 52)
                        .addComponent(jScrollPane2)))
                .addGap(15, 15, 15))
        );
        panel_Custom2Layout.setVerticalGroup(
            panel_Custom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Custom2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel17)
                .addGap(15, 15, 15)
                .addGroup(panel_Custom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_Custom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuongTon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_Custom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel_Custom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_Custom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(rdoHoatDong)
                    .addComponent(rdoNgungHoatDong))
                .addGap(15, 15, 15)
                .addGroup(panel_Custom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panel_Custom4Layout = new javax.swing.GroupLayout(panel_Custom4);
        panel_Custom4.setLayout(panel_Custom4Layout);
        panel_Custom4Layout.setHorizontalGroup(
            panel_Custom4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Custom4Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(panel_Custom4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panel_Custom4Layout.createSequentialGroup()
                        .addComponent(panel_Custom6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(panel_Custom2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panel_Custom3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_Custom4Layout.setVerticalGroup(
            panel_Custom4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Custom4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_Custom4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel_Custom2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_Custom6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panel_Custom3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_Custom4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_Custom4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rdoNgungHoatDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNgungHoatDongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoNgungHoatDongActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        resetForm();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnThemMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMoiActionPerformed
        // TODO add your handling code here:
        if (getModel() != null) {
            SVCTSP.insert(getModel(), idsp_ToanCuc1);
            resetForm();
        } else {
//            System.out.println("Inset dữ liệu mới không thành công với data : "+getModel());
//            System.out.println("Inset dữ liệu mới không thành công id toàn cục : "+idCTSP_ToanCuc);
        }
        listdtoCTDSSP = SVCTSP.selectAllCTSPByIDSP(idsp_ToanCuc1);
        filltableHang(listdtoCTDSSP);

    }//GEN-LAST:event_btnThemMoiActionPerformed

    private void tblDSCTSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSCTSPMouseClicked
        // TODO add your handling code here:
        int index = tblDSCTSP.getSelectedRow();
        setModel(listdtoCTDSSP.get(index));
        rdoHoatDong.setEnabled(true);
        rdoNgungHoatDong.setEnabled(true);

        idCTSP_ToanCuc = listdtoCTDSSP.get(index).getIdCtsp();
    }//GEN-LAST:event_tblDSCTSPMouseClicked

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
//        idCTSP_ToanCuc
        if (idCTSP_ToanCuc != null) {
            int response = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa không ?", "Thông Báo Hệ Thống", 0, 3, null);
            if (response == JOptionPane.YES_OPTION) {
                SVCTSP.delete(idCTSP_ToanCuc);

                listdtoCTDSSP = SVCTSP.selectAllCTSPByIDSP(idsp_ToanCuc1);
                filltableHang(listdtoCTDSSP);
                resetForm();
                JOptionPane.showMessageDialog(this, "Xóa thành công");
            } else if (response == JOptionPane.NO_OPTION) {

            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn chi tiết sản phẩm ở [Danh Sách Chi Tiết Sản Phẩm] trước khi xóa thông tin", "Thông Báo Hệ Thống", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:

        if (idCTSP_ToanCuc == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn chi tiết sản phẩm ở [Danh Sách Chi Tiết Sản Phẩm] trước khi sửa thông tin", "Thông Báo Hệ Thống !", 0);
        } else if (idCTSP_ToanCuc != null) {

            int response = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn sửa không ?", "Thông Báo Hệ Thống", 0, 3, null);
            if (response == JOptionPane.YES_OPTION) {
                if (getModel() != null) {
                    SVCTSP.update(getModel(), idCTSP_ToanCuc);
                    resetForm();
                    JOptionPane.showMessageDialog(this, "Update thành công");
                }
                listdtoCTDSSP = SVCTSP.selectAllCTSPByIDSP(idsp_ToanCuc1);
                filltableHang(listdtoCTDSSP);

            } else if (response == JOptionPane.NO_OPTION) {

            }

        }

    }//GEN-LAST:event_btnSuaActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Form_ChiTietSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Form_ChiTietSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Form_ChiTietSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Form_ChiTietSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Form_ChiTietSanPham(Integer idsp).setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Swing_Custom.CustomButton1 btnLamMoi;
    private Swing_Custom.CustomButton1 btnSua;
    private Swing_Custom.CustomButton1 btnThemMoi;
    private Swing_Custom.CustomButton1 btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel jlbHang;
    private javax.swing.JPanel jlbImage;
    private javax.swing.JLabel jlbLoaiSanPham;
    private javax.swing.JLabel jlbMaSanPham;
    private javax.swing.JTextArea jlbMoTa;
    private javax.swing.JLabel jlbTenSanPham;
    private javax.swing.JLabel jlbTrangThai;
    private Swing_Custom.Panel_Custom panel_Custom2;
    private Swing_Custom.Panel_Custom panel_Custom3;
    private Swing_Custom.Panel_Custom panel_Custom4;
    private Swing_Custom.Panel_Custom panel_Custom6;
    private javax.swing.JRadioButton rdoHoatDong;
    private javax.swing.JRadioButton rdoNgungHoatDong;
    private javax.swing.JTable tblDSCTSP;
    private javax.swing.JTextArea txtGhiChu;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JLabel txtImageSanPham;
    private javax.swing.JTextField txtMauSac;
    private javax.swing.JTextField txtSoLuongTon;
    // End of variables declaration//GEN-END:variables
}
