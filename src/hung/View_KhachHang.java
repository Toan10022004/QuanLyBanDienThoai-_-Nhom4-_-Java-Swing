/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hung;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class View_KhachHang extends javax.swing.JFrame {
    private Repositories_KhachHang repositories_KhachHang;
 private Repositories_KhachHang R_KH = new Repositories_KhachHang();
 private DefaultTableModel mol = new DefaultTableModel();
    private int i = -1;// chỉ số dòng trong bảng
    
     void fillTable(ArrayList<Model_khachhang> list){
        mol = (DefaultTableModel)btlqlkh.getModel();
        mol.setRowCount(0);
        for(Model_khachhang x : list){
            mol.addRow(x.toDataRow());
        }
    }
     
    public View_KhachHang() {
        repositories_KhachHang = new Repositories_KhachHang();
        initComponents();
        fillTable(R_KH.getAll());
    }
     void showData(int i) {
        txtma.setText(btlqlkh.getValueAt(i, 0).toString());
        txtten.setText(btlqlkh.getValueAt(i, 1).toString());
        txtsdt.setText(btlqlkh.getValueAt(i, 2).toString());
        txtemai.setText(btlqlkh.getValueAt(i, 3).toString());
        txtdiachi.setText(btlqlkh.getValueAt(i, 4).toString());
     }
    private boolean isValidCustomerData() {
    if (txtma.getText().trim().isEmpty() || !txtma.getText().matches("\\d+")) {
        JOptionPane.showMessageDialog(this, "Mã khách hàng không hợp lệ!", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    if (txtten.getText().trim().isEmpty() || !isValidName(txtten.getText())) {
        JOptionPane.showMessageDialog(this, "Tên khách hàng không hợp lệ!", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    if (!isValidPhoneNumber(txtsdt.getText())) {
        JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ!", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    // Add more validations as needed
    return true;
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        btlqlkh = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtma = new javax.swing.JTextField();
        txtten = new javax.swing.JTextField();
        txtsdt = new javax.swing.JTextField();
        txtemai = new javax.swing.JTextField();
        txtdiachi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txttk = new javax.swing.JTextField();
        BtnTimkiem = new javax.swing.JButton();
        btnthem = new javax.swing.JButton();
        btnsua = new javax.swing.JButton();
        Btnxoa = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btlqlkh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ma", "ten", "SDT", "emai", "diachi"
            }
        ));
        btlqlkh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btlqlkhMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(btlqlkh);

        jLabel1.setText("Mã");

        jLabel2.setText("Tên");

        txtma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmaActionPerformed(evt);
            }
        });

        txtten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttenActionPerformed(evt);
            }
        });

        jLabel3.setText("SDT");

        jLabel4.setText("Emai");

        jLabel5.setText("DiaChi");

        BtnTimkiem.setBackground(new java.awt.Color(204, 255, 204));
        BtnTimkiem.setText("Tim kiếm");
        BtnTimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnTimkiemActionPerformed(evt);
            }
        });

        btnthem.setBackground(new java.awt.Color(204, 255, 204));
        btnthem.setText("Them");
        btnthem.setMaximumSize(new java.awt.Dimension(72, 25));
        btnthem.setPreferredSize(new java.awt.Dimension(73, 25));
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        btnsua.setBackground(new java.awt.Color(204, 255, 204));
        btnsua.setText("Sua");
        btnsua.setPreferredSize(new java.awt.Dimension(72, 25));
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });

        Btnxoa.setBackground(new java.awt.Color(204, 255, 204));
        Btnxoa.setText("Xóa");
        Btnxoa.setPreferredSize(new java.awt.Dimension(72, 25));
        Btnxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnxoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtten, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnthem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtsdt, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtdiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Btnxoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtemai, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtma, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addComponent(btnsua, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(txttk, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                                .addComponent(BtnTimkiem)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(btnthem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(txtsdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtemai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(btnsua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtdiachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btnxoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 51, 51));
        jLabel6.setText("Quản Lý Khách hàng");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(217, 217, 217)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel6)
                .addGap(34, 34, 34)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
private void fillTable() {
    // Xóa dữ liệu cũ trong bảng
    DefaultTableModel model = (DefaultTableModel) btlqlkh.getModel();
    model.setRowCount(0);

    // Lấy danh sách khách hàng từ cơ sở dữ liệu
    ArrayList<Model_khachhang> list = repositories_KhachHang.getAll();

    // Kiểm tra danh sách có rỗng không
    if (list != null) {
        // Thêm từng khách hàng vào bảng
        for (Model_khachhang kh : list) {
            model.addRow(new Object[]{kh.getMaKH(), kh.getTenKH(), kh.getSDT(), kh.getEmail(), kh.getDiaChi()});
        }
    }
}
    private void txtmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmaActionPerformed

    private void txttenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttenActionPerformed

    private void btlqlkhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btlqlkhMouseClicked
        // TODO add your handling code here:
         i = btlqlkh.getSelectedRow();
        this.showData(i);
    }//GEN-LAST:event_btlqlkhMouseClicked

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        if (isValidCustomerData()) {
        String tenKH = txtten.getText();
        String sdt = txtsdt.getText();
        String email = txtemai.getText();
        
        // Kiểm tra xem tên, SDT, email đã tồn tại chưa
        boolean isDuplicateName = R_KH.getAll().stream().anyMatch(kh -> kh.getTenKH().equals(tenKH));
        boolean isDuplicateSDT = R_KH.getAll().stream().anyMatch(kh -> kh.getSDT().equals(sdt));
        boolean isDuplicateEmail = R_KH.getAll().stream().anyMatch(kh -> kh.getEmail().equals(email));
        
        if (isDuplicateName) {
            JOptionPane.showMessageDialog(this, "Tên khách hàng đã tồn tại!", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (isDuplicateSDT) {
            JOptionPane.showMessageDialog(this, "Số điện thoại đã tồn tại!", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (isDuplicateEmail) {
            JOptionPane.showMessageDialog(this, "Email đã tồn tại!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Model_khachhang khachHang = new Model_khachhang();
            khachHang.setMaKH(Integer.parseInt(txtma.getText()));
            khachHang.setTenKH(tenKH);
            khachHang.setSDT(sdt);
            khachHang.setEmail(email);
            khachHang.setDiaChi(txtdiachi.getText());
            if (R_KH.add(khachHang)) {
                fillTable(R_KH.getAll());
                JOptionPane.showMessageDialog(this, "Thêm khách hàng thành công!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Thêm khách hàng thất bại!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    }//GEN-LAST:event_btnthemActionPerformed

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
     if (isValidCustomerData()) {
        String tenKH = txtten.getText();
        String sdt = txtsdt.getText();
        String email = txtemai.getText();
        int maKH = Integer.parseInt(txtma.getText());
        
        // Kiểm tra xem tên, SDT, email đã tồn tại chưa, ngoại trừ chính khách hàng hiện tại
        boolean isDuplicateName = R_KH.getAll().stream()
                .anyMatch(kh -> kh.getTenKH().equals(tenKH) && kh.getMaKH() != maKH);
        boolean isDuplicateSDT = R_KH.getAll().stream()
                .anyMatch(kh -> kh.getSDT().equals(sdt) && kh.getMaKH() != maKH);
        boolean isDuplicateEmail = R_KH.getAll().stream()
                .anyMatch(kh -> kh.getEmail().equals(email) && kh.getMaKH() != maKH);
        
        if (isDuplicateName) {
            JOptionPane.showMessageDialog(this, "Tên khách hàng đã tồn tại!", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (isDuplicateSDT) {
            JOptionPane.showMessageDialog(this, "Số điện thoại đã tồn tại!", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (isDuplicateEmail) {
            JOptionPane.showMessageDialog(this, "Email đã tồn tại!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Model_khachhang khachHang = new Model_khachhang();
            khachHang.setMaKH(maKH);
            khachHang.setTenKH(tenKH);
            khachHang.setSDT(sdt);
            khachHang.setEmail(email);
            khachHang.setDiaChi(txtdiachi.getText());
            if (R_KH.update(khachHang)) {
                fillTable(R_KH.getAll());
                JOptionPane.showMessageDialog(this, "Sửa thông tin khách hàng thành công!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Sửa thông tin khách hàng thất bại!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    }//GEN-LAST:event_btnsuaActionPerformed
public boolean isValidName(String name) {
    return name != null && !name.trim().isEmpty() && name.matches("[a-zA-Z\\s-]+");
}
public boolean isValidPhoneNumber(String phoneNumber) {
    // Example regex for validating phone numbers
    String phoneRegex = "^\\+?[0-9]{1,4}?[-.\\s]?\\(?[0-9]{1,4}?\\)?[-.\\s]?[0-9]{1,9}$";
    return phoneNumber != null && phoneNumber.matches(phoneRegex);
}
    private void BtnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnxoaActionPerformed
 if (txtma.getText().trim().isEmpty() || !txtma.getText().matches("\\d+")) {
        JOptionPane.showMessageDialog(this, "Mã khách hàng không hợp lệ!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    int maKH = Integer.parseInt(txtma.getText());

    boolean deleteSuccess = repositories_KhachHang.delete(maKH);
    if (deleteSuccess) {
        JOptionPane.showMessageDialog(this, "Xóa thành công!", "Success", JOptionPane.INFORMATION_MESSAGE);
        fillTable();  // Cập nhật lại bảng sau khi xóa
    } else {
        JOptionPane.showMessageDialog(this, "Xóa thất bại!", "Error", JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_BtnxoaActionPerformed

    private void BtnTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTimkiemActionPerformed
         String input = txttk.getText();
        if (input.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã loại sản phẩm!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int MaKH;
        try {
            MaKH = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Mã loại sản phẩm không hợp lệ!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Model_khachhang model_khachhang = R_KH.find(MaKH);
        if (model_khachhang != null) {
            ArrayList<Model_khachhang> list = new ArrayList<>();
            list.add(model_khachhang);
            fillTable(list);
        } else {
            JOptionPane.showMessageDialog(this, "Không tìm thấy loại sản phẩm với mã: " + MaKH, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BtnTimkiemActionPerformed

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
            java.util.logging.Logger.getLogger(View_KhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View_KhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View_KhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View_KhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View_KhachHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnTimkiem;
    private javax.swing.JButton Btnxoa;
    private javax.swing.JTable btlqlkh;
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnthem;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txtdiachi;
    private javax.swing.JTextField txtemai;
    private javax.swing.JTextField txtma;
    private javax.swing.JTextField txtsdt;
    private javax.swing.JTextField txtten;
    private javax.swing.JTextField txttk;
    // End of variables declaration//GEN-END:variables
}