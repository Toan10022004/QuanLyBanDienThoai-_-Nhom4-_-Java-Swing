/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Form_View;

import DTO.DTO_DanhSachSanPham;
import Model.MD_Hang_CN;
import OuputFile.DanhSachXuatFile;
import Service.SV_Hang;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

/**
 *
 * @author 84904
 */
public class Form_Hang extends javax.swing.JPanel {
//    https://stackhowto.com/how-to-dynamically-filter-jtable-from-textfield-in-java/#google_vignette

    TableRowSorter<TableModel> rowSorter; // công nghệ lọc bảng 

    DefaultTableModel tblModel;
    List<MD_Hang_CN> listhang = new ArrayList<>();
    List<DTO_DanhSachSanPham> listdto = new ArrayList<>();
    MD_Hang_CN hang;
    SV_Hang svhang = new SV_Hang();

    public Integer idHang;

    /**
     * Creates new form Form_SanPham
     */
    public Form_Hang() {
        initComponents();
        initTableSanOhamTheoHang();
        initTableHang();

        listhang = svhang.selectAllHang();
        filltableHang(listhang);

        listdto = svhang.selectAllSanPhamTheoHangByIDHang(0);
        filltableSanPhamTheoHang(listdto);

        //Lọc Banhgr hãng
        rowSorter = new TableRowSorter<>(tblHang.getModel());
        tblHang.setRowSorter(rowSorter);

    }

    public void initTableSanOhamTheoHang() {
        DefaultTableModel model = (DefaultTableModel) tblSanPhamTheoHang.getModel();
        model.setColumnIdentifiers(new Object[]{"ID", "Mã Sản Phẩm", "Ảnh", "Tên Sản Phẩm", "Loại", "Hãng", "Mô Tả", "Trạng Thái", "Ngày Tạo", "Ngày Sửa"});
    }

    public void initTableHang() {
        DefaultTableModel model = (DefaultTableModel) tblHang.getModel();
        model.setColumnIdentifiers(new Object[]{"ID", "Tên Hãng", "Mô Tả"});
    }

    public void filltableHang(List<MD_Hang_CN> lhang) {
        tblModel = (DefaultTableModel) tblHang.getModel();
        tblModel.setRowCount(0);
        for (MD_Hang_CN h : lhang) {
            Object[] row = new Object[3];
            row[0] = h.getIdHang();
            row[1] = h.getTenHang();
            row[2] = h.getMoTa();
            tblModel.addRow(row);
        }
    }

    public void filltableSanPhamTheoHang(List<DTO_DanhSachSanPham> dto) {
        tblModel = (DefaultTableModel) tblSanPhamTheoHang.getModel();
        tblModel.setRowCount(0);
        for (DTO_DanhSachSanPham l : dto) {
            Object[] row = new Object[10];
            row[0] = l.getIdSanPham();
            row[1] = l.getMaSanPham();
            row[2] = l.getAnhSanPham();
            row[3] = l.getTenSanPham();
            row[4] = l.getTenLoaiSP();
            row[5] = l.getTenHang();
            row[6] = l.getMoTa();
            row[7] = l.getTrangThai();
            row[8] = l.getNgayTao();
            row[9] = (l.getNgaySua() == null) ? "" : l.getNgaySua();
            tblModel.addRow(row);
        }
    }

    public void setModel(MD_Hang_CN h) {
        txtIDhang.setText(String.valueOf(h.getIdHang()));
        txtTenHang.setText(h.getTenHang());
        txtMoTa.setText(h.getMoTa());
    }

    public MD_Hang_CN getModel() {
        if (txtTenHang.getText() == null || txtTenHang.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên hãng!", "Thông Báo Hệ Thống", JOptionPane.WARNING_MESSAGE);
            txtTenHang.requestFocus();
        } else if (!txtTenHang.getText().matches("[a-zA-Z0-9]+")) {
            JOptionPane.showMessageDialog(this, "Tên hãng chỉ được chứa ký tự chữ và số!", "Thông Báo Hệ Thống", JOptionPane.WARNING_MESSAGE);
            txtTenHang.requestFocus();
        } else if (txtTenHang.getText().length() < 10 || txtTenHang.getText().length() > 30) {
            JOptionPane.showMessageDialog(this, "Tên hãng không được ít hơn 10 kí tự và không nhiều hơn 30 kí tự ký tự !", "Thông Báo Hệ Thống", JOptionPane.WARNING_MESSAGE);
            txtTenHang.requestFocus();
        } else if (txtMoTa.getText().length() > 255) {
            JOptionPane.showMessageDialog(this, "Mô tả hãng không được hơn 255 kí tự ký tự !", "Thông Báo Hệ Thống", JOptionPane.WARNING_MESSAGE);
            txtTenHang.requestFocus();
        } else {
            // Xử lý khi tên hãng hợp lệ
            MD_Hang_CN h = new MD_Hang_CN();
            h.setTenHang(txtTenHang.getText());
            h.setMoTa(txtMoTa.getText());
            return h;
        }
        return null;

    }

    public void resetForm() {
        txtIDhang.setText(null);
        txtTenHang.setText(null);
        txtMoTa.setText(null);
        listdto = svhang.selectAllSanPhamTheoHangByIDHang(0);
        filltableSanPhamTheoHang(listdto);

    }

    public void export(JTable table, File file) {
        try {
            TableModel m = table.getModel();
            FileWriter fw = new FileWriter(file);
            for (int i = 0; i < m.getColumnCount(); i++) {
                fw.write(m.getColumnName(i) + "\t");
            }
            fw.write("\n");
            for (int i = 0; i < m.getRowCount(); i++) {
                for (int j = 0; j < m.getColumnCount(); j++) {
                    fw.write(m.getValueAt(i, j).toString() + "\t");
                }
                fw.write("\n");
            }
            fw.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        // Open the file after exporting
    try {
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            if (file.exists()) {
                desktop.open(file);
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
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
        panel_Custom2 = new Swing_Custom.Panel_Custom();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtTenHang = new javax.swing.JTextField();
        btnThemMoi = new Swing_Custom.CustomButton1();
        btnXoa = new Swing_Custom.CustomButton1();
        btnLamMoi = new Swing_Custom.CustomButton1();
        txtMoTa = new javax.swing.JTextField();
        btnSua = new Swing_Custom.CustomButton1();
        jLabel19 = new javax.swing.JLabel();
        txtIDhang = new javax.swing.JTextField();
        panel_Custom3 = new Swing_Custom.Panel_Custom();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblSanPhamTheoHang = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnXuatFile = new Swing_Custom.CustomButton1();
        jLabel2 = new javax.swing.JLabel();
        panel_Custom4 = new Swing_Custom.Panel_Custom();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblHang = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtTimKiemHang = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 153, 102));

        panel_Custom2.setRoundBottomLeft(25);
        panel_Custom2.setRoundBottomRight(25);
        panel_Custom2.setRoundTopLeft(25);
        panel_Custom2.setRoundTopRight(25);

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setText("Thêm/Chỉnh Sửa Hãng");

        jLabel18.setText("Tên hãng");

        jLabel24.setText("Mô Tả");

        txtTenHang.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtTenHang.setForeground(new java.awt.Color(101, 85, 143));
        txtTenHang.setPreferredSize(new java.awt.Dimension(300, 30));

        btnThemMoi.setBackground(new java.awt.Color(101, 85, 143));
        btnThemMoi.setForeground(new java.awt.Color(255, 255, 255));
        btnThemMoi.setText("Thêm mới ");
        btnThemMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMoiActionPerformed(evt);
            }
        });

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

        txtMoTa.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtMoTa.setForeground(new java.awt.Color(101, 85, 143));
        txtMoTa.setPreferredSize(new java.awt.Dimension(300, 30));

        btnSua.setBackground(new java.awt.Color(101, 85, 143));
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        jLabel19.setText("ID");

        txtIDhang.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtIDhang.setForeground(new java.awt.Color(101, 85, 143));
        txtIDhang.setEnabled(false);
        txtIDhang.setPreferredSize(new java.awt.Dimension(300, 30));

        javax.swing.GroupLayout panel_Custom2Layout = new javax.swing.GroupLayout(panel_Custom2);
        panel_Custom2.setLayout(panel_Custom2Layout);
        panel_Custom2Layout.setHorizontalGroup(
            panel_Custom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Custom2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panel_Custom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_Custom2Layout.createSequentialGroup()
                        .addGroup(panel_Custom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panel_Custom2Layout.createSequentialGroup()
                        .addGroup(panel_Custom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtIDhang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panel_Custom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel19)
                                .addGroup(panel_Custom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtTenHang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtMoTa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel_Custom2Layout.createSequentialGroup()
                                        .addComponent(btnThemMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)
                                        .addGroup(panel_Custom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnLamMoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(0, 17, Short.MAX_VALUE))))
        );
        panel_Custom2Layout.setVerticalGroup(
            panel_Custom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Custom2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIDhang, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenHang, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_Custom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_Custom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        panel_Custom3.setRoundBottomLeft(25);
        panel_Custom3.setRoundBottomRight(25);
        panel_Custom3.setRoundTopLeft(25);
        panel_Custom3.setRoundTopRight(25);

        tblSanPhamTheoHang.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tblSanPhamTheoHang);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Danh Sách Sản Phẩm Theo Hãng");

        btnXuatFile.setBackground(new java.awt.Color(101, 85, 143));
        btnXuatFile.setForeground(new java.awt.Color(255, 255, 255));
        btnXuatFile.setText("Xuất File");
        btnXuatFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatFileActionPerformed(evt);
            }
        });

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 492, Short.MAX_VALUE)
                        .addComponent(btnXuatFile, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panel_Custom3Layout.setVerticalGroup(
            panel_Custom3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_Custom3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel_Custom3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnXuatFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Hãng");

        panel_Custom4.setRoundBottomLeft(25);
        panel_Custom4.setRoundBottomRight(25);
        panel_Custom4.setRoundTopLeft(25);
        panel_Custom4.setRoundTopRight(25);

        tblHang.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        tblHang.setModel(new javax.swing.table.DefaultTableModel(
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
        tblHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHangMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblHang);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Danh Sách Hãng");

        txtTimKiemHang.setBackground(new java.awt.Color(137, 137, 137));
        txtTimKiemHang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTimKiemHang.setForeground(new java.awt.Color(255, 255, 255));
        txtTimKiemHang.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTimKiemHang.setToolTipText("Tìm kiếm sản phẩm theo mã hoặc tên .");
        txtTimKiemHang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTimKiemHangKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemHangKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout panel_Custom4Layout = new javax.swing.GroupLayout(panel_Custom4);
        panel_Custom4.setLayout(panel_Custom4Layout);
        panel_Custom4Layout.setHorizontalGroup(
            panel_Custom4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Custom4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panel_Custom4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panel_Custom4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(108, 108, 108)
                        .addComponent(txtTimKiemHang))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_Custom4Layout.setVerticalGroup(
            panel_Custom4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_Custom4Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(panel_Custom4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTimKiemHang, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(panel_Custom2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(panel_Custom4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panel_Custom3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel_Custom4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_Custom2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(panel_Custom3, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(514, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHangMouseClicked
        // TODO add your handling code here:
        int index = tblHang.getSelectedRow();
        setModel(listhang.get(index));
        idHang = listhang.get(index).getIdHang();
        listdto = svhang.selectAllSanPhamTheoHangByIDHang(idHang);
        filltableSanPhamTheoHang(listdto);


    }//GEN-LAST:event_tblHangMouseClicked

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        resetForm();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void txtTimKiemHangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemHangKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtTimKiemHangKeyPressed

    private void txtTimKiemHangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemHangKeyReleased
        // TODO add your handling code here:
        String text = txtTimKiemHang.getText();
        if (text.trim().length() == 0) {
            rowSorter.setRowFilter(null);
        } else {
            rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
        }
        System.out.println("Kí tự được nhập vào input timf kiếm :" + txtTimKiemHang.getText());
    }//GEN-LAST:event_txtTimKiemHangKeyReleased

    private void btnThemMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMoiActionPerformed
        // TODO add your handling code here:
        if (getModel() != null) {
            svhang.insert(getModel());

            listhang = svhang.selectAllHang();
            filltableHang(listhang);
            resetForm();
            JOptionPane.showMessageDialog(this, "Thêm mới hãng thành công", "Thông Báo Hệ Thống", JOptionPane.INFORMATION_MESSAGE);
        } else {

        }
    }//GEN-LAST:event_btnThemMoiActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        if (txtIDhang.getText() != null) {
            int response = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa không ?", "Thông Báo Hệ Thống", 0, 3, null);
            if (response == JOptionPane.YES_OPTION) {
                svhang.delete(Integer.parseInt(txtIDhang.getText()));

                listhang = svhang.selectAllHang();
                filltableHang(listhang);
                resetForm();
                JOptionPane.showMessageDialog(this, "Xóa thành công");
            } else if (response == JOptionPane.NO_OPTION) {

            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hãng ở [Danh Sách Hãng] trước khi xóa thông tin", "Thông Báo Hệ Thống", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        if (txtIDhang.getText() != null) {
            int response = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn sửa không ?", "Thông Báo Hệ Thống", 0, 3, null);
            if (response == JOptionPane.YES_OPTION) {
                svhang.update(txtTenHang.getText(), txtMoTa.getText(), Integer.parseInt(txtIDhang.getText()));

                listhang = svhang.selectAllHang();
                filltableHang(listhang);
                resetForm();
                JOptionPane.showMessageDialog(this, "Update thành công");
            } else if (response == JOptionPane.NO_OPTION) {

            }

        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hãng ở [Danh Sách Hãng] trước khi sửa thông tin", "Thông Báo Hệ Thống", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXuatFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatFileActionPerformed
        // TODO add your handling code here:
        JFileChooser fchoose = new JFileChooser();
        int option = fchoose.showSaveDialog(Form_Hang.this);
        if (option == JFileChooser.APPROVE_OPTION) {
            String name = fchoose.getSelectedFile().getName();
            String path = fchoose.getSelectedFile().getParentFile().getPath();
            String file = path + "\\" + name + ".xls";
            export(tblHang, new File(file));
//            export(tblSanPhamTheoHang, new File(file));
        }
    }//GEN-LAST:event_btnXuatFileActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Swing_Custom.CustomButton1 btnLamMoi;
    private Swing_Custom.CustomButton1 btnSua;
    private Swing_Custom.CustomButton1 btnThemMoi;
    private Swing_Custom.CustomButton1 btnXoa;
    private Swing_Custom.CustomButton1 btnXuatFile;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private Swing_Custom.Panel_Custom panel_Custom2;
    private Swing_Custom.Panel_Custom panel_Custom3;
    private Swing_Custom.Panel_Custom panel_Custom4;
    private javax.swing.JTable tblHang;
    private javax.swing.JTable tblSanPhamTheoHang;
    private javax.swing.JTextField txtIDhang;
    private javax.swing.JTextField txtMoTa;
    private javax.swing.JTextField txtTenHang;
    private javax.swing.JTextField txtTimKiemHang;
    // End of variables declaration//GEN-END:variables
}
