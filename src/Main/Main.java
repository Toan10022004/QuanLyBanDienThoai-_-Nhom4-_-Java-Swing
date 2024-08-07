
package Main;

import Form_View.Form_BanHang;

/**
 *
 * @author 84904
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        tablepanel_from.setSelectedComponent(form_TrangChu);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnBanHang = new javax.swing.JButton();
        btnHoaDon = new javax.swing.JButton();
        btnVocher = new javax.swing.JButton();
        btnKhachHang = new javax.swing.JButton();
        btnBanHang4 = new javax.swing.JButton();
        btnBanHang5 = new javax.swing.JButton();
        panel_Custom1 = new Swing_Custom.Panel_Custom();
        jLabel2 = new javax.swing.JLabel();
        customButton11 = new Swing_Custom.CustomButton1();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnBanHang6 = new javax.swing.JButton();
        btbLoai = new javax.swing.JButton();
        panel_Custom2 = new Swing_Custom.Panel_Custom();
        jLabel1 = new javax.swing.JLabel();
        tablepanel_from = new javax.swing.JTabbedPane();
        form_dssp = new Form_View.Form_DanhSachSanPham();
        form_hang = new Form_View.Form_Hang();
        form_TrangChu = new Form_View.Form_TrangChu();
        form_KhachHang = new Form_View.Form_KhachHang();
        form_loai = new Form_View.Form_loai();
        form_BanHang = new Form_View.Form_BanHang();
        from_QuanLyNhanVien = new Form_View.Pn_QLyNhanVien();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jButton1.setText("Sản Phẩm");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Hãng");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnBanHang.setText("Bán Hàng");
        btnBanHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBanHangMouseClicked(evt);
            }
        });
        btnBanHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBanHangActionPerformed(evt);
            }
        });

        btnHoaDon.setText("Hóa Đơn");
        btnHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHoaDonMouseClicked(evt);
            }
        });
        btnHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoaDonActionPerformed(evt);
            }
        });

        btnVocher.setText("Vocher");
        btnVocher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVocherMouseClicked(evt);
            }
        });
        btnVocher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVocherActionPerformed(evt);
            }
        });

        btnKhachHang.setText("Khách Hàng");
        btnKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnKhachHangMouseClicked(evt);
            }
        });
        btnKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhachHangActionPerformed(evt);
            }
        });

        btnBanHang4.setText("Nhân Viên");
        btnBanHang4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBanHang4MouseClicked(evt);
            }
        });
        btnBanHang4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBanHang4ActionPerformed(evt);
            }
        });

        btnBanHang5.setText("Thống Kê");
        btnBanHang5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBanHang5MouseClicked(evt);
            }
        });
        btnBanHang5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBanHang5ActionPerformed(evt);
            }
        });

        panel_Custom1.setRoundBottomLeft(25);
        panel_Custom1.setRoundBottomRight(25);
        panel_Custom1.setRoundTopLeft(25);
        panel_Custom1.setRoundTopRight(25);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Thông Tin Đăng Nhập");

        customButton11.setText("Đăng Xuất");

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        jLabel3.setText("Mã Nhân Viên");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel4.setText("NV009");

        jLabel5.setText("Tên Nhân Viên");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel6.setText("Nguyen Van A");

        jLabel7.setText("Quyền Hạn");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel9.setText("ADMIN");

        javax.swing.GroupLayout panel_Custom1Layout = new javax.swing.GroupLayout(panel_Custom1);
        panel_Custom1.setLayout(panel_Custom1Layout);
        panel_Custom1Layout.setHorizontalGroup(
            panel_Custom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
            .addComponent(jSeparator2)
            .addGroup(panel_Custom1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_Custom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(customButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panel_Custom1Layout.createSequentialGroup()
                        .addGroup(panel_Custom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel_Custom1Layout.setVerticalGroup(
            panel_Custom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Custom1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(customButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        btnBanHang6.setText("Trang Chủ");
        btnBanHang6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBanHang6MouseClicked(evt);
            }
        });
        btnBanHang6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBanHang6ActionPerformed(evt);
            }
        });

        btbLoai.setText("Loại Sản Phẩm");
        btbLoai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btbLoaiMouseClicked(evt);
            }
        });
        btbLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbLoaiActionPerformed(evt);
            }
        });

        panel_Custom2.setBackground(new java.awt.Color(255, 255, 255));
        panel_Custom2.setRoundBottomLeft(10);
        panel_Custom2.setRoundBottomRight(10);
        panel_Custom2.setRoundTopLeft(10);
        panel_Custom2.setRoundTopRight(10);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/logo.jpg"))); // NOI18N

        javax.swing.GroupLayout panel_Custom2Layout = new javax.swing.GroupLayout(panel_Custom2);
        panel_Custom2.setLayout(panel_Custom2Layout);
        panel_Custom2Layout.setHorizontalGroup(
            panel_Custom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Custom2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel_Custom2Layout.setVerticalGroup(
            panel_Custom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Custom2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panel_Custom2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBanHang5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_Custom1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBanHang4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnKhachHang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVocher, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHoaDon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBanHang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btbLoai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBanHang6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_Custom2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBanHang6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btbLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVocher, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBanHang4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBanHang5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_Custom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 737));

        tablepanel_from.addTab("tab1", form_dssp);
        tablepanel_from.addTab("tab3", form_hang);
        tablepanel_from.addTab("tab5", form_TrangChu);
        tablepanel_from.addTab("tab7", form_KhachHang);
        tablepanel_from.addTab("tab8", form_loai);
        tablepanel_from.addTab("tab9", form_BanHang);
        tablepanel_from.addTab("tab7", from_QuanLyNhanVien);

        getContentPane().add(tablepanel_from, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, -33, 1343, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        tablepanel_from.setSelectedComponent(form_dssp);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        tablepanel_from.setSelectedComponent(form_hang);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnBanHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBanHangMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBanHangMouseClicked

    private void btnBanHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBanHangActionPerformed
        // TODO add your handling code here:
        // Loại bỏ panel hiện tại nếu tồn tại
        int index = tablepanel_from.indexOfComponent(form_BanHang);
        if (index != -1) {
            tablepanel_from.remove(index);
        }

        // Tạo một instance mới của Form_BanHang
        form_BanHang = new Form_View.Form_BanHang();

        // Thêm instance mới vào tabbed pane
        tablepanel_from.addTab("Bán Hàng", form_BanHang);

        // Đặt instance mới làm component được chọn
        tablepanel_from.setSelectedComponent(form_BanHang);
    }//GEN-LAST:event_btnBanHangActionPerformed

    private void btnHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHoaDonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHoaDonMouseClicked

    private void btnHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoaDonActionPerformed
        // TODO add your handling code here:
//        tablepanel_from.setSelectedComponent(form_HoaDon);

    }//GEN-LAST:event_btnHoaDonActionPerformed

    private void btnVocherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVocherMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVocherMouseClicked

    private void btnVocherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVocherActionPerformed
        // TODO add your handling code here:
//        tablepanel_from.setSelectedComponent(form_KhuyenMai);

    }//GEN-LAST:event_btnVocherActionPerformed

    private void btnKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKhachHangMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnKhachHangMouseClicked

    private void btnKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhachHangActionPerformed
        // TODO add your handling code here:
        tablepanel_from.setSelectedComponent(form_KhachHang);
    }//GEN-LAST:event_btnKhachHangActionPerformed

    private void btnBanHang4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBanHang4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBanHang4MouseClicked

    private void btnBanHang4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBanHang4ActionPerformed
        // TODO add your handling code here:
        tablepanel_from.setSelectedComponent(from_QuanLyNhanVien);
    }//GEN-LAST:event_btnBanHang4ActionPerformed

    private void btnBanHang5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBanHang5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBanHang5MouseClicked

    private void btnBanHang5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBanHang5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBanHang5ActionPerformed

    private void btnBanHang6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBanHang6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBanHang6MouseClicked

    private void btnBanHang6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBanHang6ActionPerformed
        // TODO add your handling code here:
        tablepanel_from.setSelectedComponent(form_TrangChu);
    }//GEN-LAST:event_btnBanHang6ActionPerformed

    private void btbLoaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btbLoaiMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btbLoaiMouseClicked

    private void btbLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbLoaiActionPerformed
        // TODO add your handling code here:
        tablepanel_from.setSelectedComponent(form_loai);
    }//GEN-LAST:event_btbLoaiActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btbLoai;
    private javax.swing.JButton btnBanHang;
    private javax.swing.JButton btnBanHang4;
    private javax.swing.JButton btnBanHang5;
    private javax.swing.JButton btnBanHang6;
    private javax.swing.JButton btnHoaDon;
    private javax.swing.JButton btnKhachHang;
    private javax.swing.JButton btnVocher;
    private Swing_Custom.CustomButton1 customButton11;
    private Form_View.Form_BanHang form_BanHang;
    private Form_View.Form_KhachHang form_KhachHang;
    private Form_View.Form_TrangChu form_TrangChu;
    private Form_View.Form_DanhSachSanPham form_dssp;
    private Form_View.Form_Hang form_hang;
    private Form_View.Form_loai form_loai;
    private Form_View.Pn_QLyNhanVien from_QuanLyNhanVien;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private Swing_Custom.Panel_Custom panel_Custom1;
    private Swing_Custom.Panel_Custom panel_Custom2;
    private javax.swing.JTabbedPane tablepanel_from;
    // End of variables declaration//GEN-END:variables
}
