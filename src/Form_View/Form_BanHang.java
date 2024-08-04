/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Form_View;

import Main.DataHolder;
import hung.Model_khachhang;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 84904
 */
public class Form_BanHang extends javax.swing.JPanel {
    Model_khachhang mdkh_ToanCuc = new Model_khachhang();
    List<Model_khachhang> listDonHang = new ArrayList<>();
    /**
     * Creates new form Form_BanHang
     */
    public Form_BanHang() {
        initComponents();
        initTableSanPham();
        initTableHoaDon();
        initTableGioHang();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public void initTableSanPham() {
        DefaultTableModel model = (DefaultTableModel) tblDanhSachSanPham.getModel();
        model.setColumnIdentifiers(new Object[]{"Ảnh","ID", "Mã Sản Phẩm", "Tên Sản Phẩm", "Loại", "Hãng", "Mô Tả"});
    }
    public void initTableHoaDon() {
        DefaultTableModel model = (DefaultTableModel) tblDonHang.getModel();
        model.setColumnIdentifiers(new Object[]{"Mã HD","SDT Khách Hàng", "Người Tạo", "Trạng Thái", "Ngày Tạo"});
    }
    public void initTableGioHang() {
        DefaultTableModel model = (DefaultTableModel) tblGioHang.getModel();
        model.setColumnIdentifiers(new Object[]{"Tên Sản Phẩm" , "Hãng", "Loại" ,"Màu Sắc", "Giá Bán"});
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
        jButton2 = new javax.swing.JButton();
        panel_Custom4 = new Swing_Custom.Panel_Custom();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblDanhSachSanPham = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        panel_Custom5 = new Swing_Custom.Panel_Custom();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblGioHang = new javax.swing.JTable();
        panel_Custom2 = new Swing_Custom.Panel_Custom();
        jLabel26 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        panel_Custom6 = new Swing_Custom.Panel_Custom();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        panel_Custom7 = new Swing_Custom.Panel_Custom();
        jLabel27 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(243, 243, 243));

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
        ));
        jScrollPane2.setViewportView(tblDonHang);

        jButton2.setBackground(new java.awt.Color(255, 0, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Tạo Hóa Đơn");

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
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panel_Custom3Layout.setVerticalGroup(
            panel_Custom3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Custom3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_Custom3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jButton2))
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
        jScrollPane4.setViewportView(tblDanhSachSanPham);

        jTextField1.setText("jTextField1");

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
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panel_Custom4Layout.setVerticalGroup(
            panel_Custom4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Custom4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_Custom4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
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
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tblGioHang);

        panel_Custom2.setBackground(new java.awt.Color(204, 204, 204));
        panel_Custom2.setRoundBottomLeft(15);
        panel_Custom2.setRoundBottomRight(15);
        panel_Custom2.setRoundTopLeft(15);
        panel_Custom2.setRoundTopRight(15);

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel26.setText("Vocher");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        panel_Custom6.setBackground(new java.awt.Color(255, 255, 255));
        panel_Custom6.setRoundBottomLeft(15);
        panel_Custom6.setRoundBottomRight(15);
        panel_Custom6.setRoundTopLeft(15);
        panel_Custom6.setRoundTopRight(15);

        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setText("%");

        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("10");

        javax.swing.GroupLayout panel_Custom6Layout = new javax.swing.GroupLayout(panel_Custom6);
        panel_Custom6.setLayout(panel_Custom6Layout);
        panel_Custom6Layout.setHorizontalGroup(
            panel_Custom6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_Custom6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addGap(46, 46, 46))
        );
        panel_Custom6Layout.setVerticalGroup(
            panel_Custom6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel_Custom6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                    .addComponent(jComboBox1))
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

        jLabel15.setBackground(new java.awt.Color(102, 102, 102));
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("123.000");

        jLabel16.setBackground(new java.awt.Color(102, 102, 102));
        jLabel16.setForeground(new java.awt.Color(102, 102, 102));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("123.000");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 0, 51));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("123.000");

        javax.swing.GroupLayout panel_Custom7Layout = new javax.swing.GroupLayout(panel_Custom7);
        panel_Custom7.setLayout(panel_Custom7Layout);
        panel_Custom7Layout.setHorizontalGroup(
            panel_Custom7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Custom7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_Custom7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_Custom7Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_Custom7Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panel_Custom7Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_Custom7Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel17)))
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
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_Custom7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_Custom7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel17))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton3.setBackground(new java.awt.Color(0, 153, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Thanh Toán");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

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
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel_Custom5Layout.setVerticalGroup(
            panel_Custom5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Custom5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_Custom2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_Custom7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addContainerGap(24, Short.MAX_VALUE))
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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

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
            System.out.println("Thông tin khách hàng set toàn cục : "+mdkh_ToanCuc);
        } else {
            JOptionPane.showMessageDialog(this, "Thông tin khách hàng chưa được chọn !", "Thông Báo Hệ Thống", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextField1;
    private Swing_Custom.Panel_Custom panel_Custom1;
    private Swing_Custom.Panel_Custom panel_Custom2;
    private Swing_Custom.Panel_Custom panel_Custom3;
    private Swing_Custom.Panel_Custom panel_Custom4;
    private Swing_Custom.Panel_Custom panel_Custom5;
    private Swing_Custom.Panel_Custom panel_Custom6;
    private Swing_Custom.Panel_Custom panel_Custom7;
    private javax.swing.JTable tblDanhSachSanPham;
    private javax.swing.JTable tblDonHang;
    private javax.swing.JTable tblGioHang;
    private javax.swing.JTextArea txtDiaChiKH;
    private javax.swing.JLabel txtEmail;
    private javax.swing.JLabel txtMaKH;
    private javax.swing.JLabel txtSDTKH;
    private javax.swing.JLabel txtTenKH;
    // End of variables declaration//GEN-END:variables
}