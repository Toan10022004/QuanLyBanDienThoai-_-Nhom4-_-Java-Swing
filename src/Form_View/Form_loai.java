/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Form_View;

import hung.Model_Loai;
import hung.Repositories_Loai;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 84904
 */
public class Form_loai extends javax.swing.JPanel {

    private Repositories_Loai repositories_Loai;
    private Repositories_Loai R_loai = new Repositories_Loai();
    private Repositories_Loai R_Loai = new Repositories_Loai();
    private DefaultTableModel mol = new DefaultTableModel();
    private int i = -1;// chỉ số dòng trong bảng

    public Form_loai() {
        repositories_Loai = new Repositories_Loai();
        initComponents();
        // xóa dữ liệu cũ trong combo
//        ccbloai.removeAllItems();
//        // load toàn bộ mã nhân viên vào combo
//        for (Model_Loai x : R_Loai.getAll()) {
//            ccbloai.addItem(x.getTen_LSP().toString());
//        }
        // đẩy dl ra bảng người học
        this.fillTable(R_Loai.getAll());
        loadTableData();
    }
private void loadTableData() {
        mol = (DefaultTableModel) tblloai.getModel();
        mol.setRowCount(0);
        for (Model_Loai loai : repositories_Loai.getAll()) {
            mol.addRow(loai.toDataRow());
        }
    }

    void fillTable(ArrayList<Model_Loai> list) {
        mol = (DefaultTableModel) tblloai.getModel();
        mol.setRowCount(0);
        for (Model_Loai x : list) {
            mol.addRow(x.toDataRow());
        }
    }

    void showData(int i) {
        txtma.setText(tblloai.getValueAt(i, 0).toString());
        txtloai.setText(tblloai.getValueAt(i, 1).toString());
        txtten.setText(tblloai.getValueAt(i, 2).toString());
    }

    private boolean validateFields() {
//        String ma = txtma.getText().trim();
        String ten = txtten.getText().trim();
        String moTa = txtloai.getText().trim();

//       // if (ma.isEmpty() || ten.isEmpty() || moTa.isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin!", "Error", JOptionPane.ERROR_MESSAGE);
//            return false;
//        }
//        try {
//            Integer.parseInt(ma);
//        } catch (NumberFormatException e) {
//            JOptionPane.showMessageDialog(this, "Mã loại sản phẩm phải là số nguyên!", "Error", JOptionPane.ERROR_MESSAGE);
//            return false;
//        }
        return true;
    }
    private void fillTable() {
        // Xóa dữ liệu cũ trong bảng
        DefaultTableModel model = (DefaultTableModel) tblloai.getModel();
        model.setRowCount(0);

        // Lấy danh sách khách hàng từ cơ sở dữ liệu
        ArrayList<Model_Loai> list = repositories_Loai.getAll();

        // Kiểm tra danh sách có rỗng không
        if (list != null) {
            // Thêm từng khách hàng vào bảng
            for (Model_Loai l : list) {
                model.addRow(new Object[]{l.getId_LSP(), l.getTen_LSP(), l.getMo_ta()});
            }
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

        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtma = new javax.swing.JTextField();
        txtten = new javax.swing.JTextField();
        txttimkiem = new javax.swing.JTextField();
        btntk = new javax.swing.JButton();
        btnthem = new javax.swing.JButton();
        btnsua = new javax.swing.JButton();
        btnxoa = new javax.swing.JButton();
        txtloai = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblloai = new javax.swing.JTable();

        jLabel4.setBackground(new java.awt.Color(0, 204, 51));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 51, 51));
        jLabel4.setText("Loại");

        jLabel1.setText("Mã");

        jLabel2.setText("mô tả");

        jLabel3.setText("Loại");

        txttimkiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txttimkiemCaretUpdate(evt);
            }
        });

        btntk.setBackground(new java.awt.Color(204, 255, 204));
        btntk.setText("Tim kiếm");
        btntk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntkActionPerformed(evt);
            }
        });

        btnthem.setBackground(new java.awt.Color(204, 255, 204));
        btnthem.setText("Thêm");
        btnthem.setPreferredSize(new java.awt.Dimension(72, 25));
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        btnsua.setBackground(new java.awt.Color(204, 255, 204));
        btnsua.setText("Sửa");
        btnsua.setPreferredSize(new java.awt.Dimension(72, 25));
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });

        btnxoa.setBackground(new java.awt.Color(204, 255, 204));
        btnxoa.setText("Xóa");
        btnxoa.setPreferredSize(new java.awt.Dimension(72, 25));
        btnxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaActionPerformed(evt);
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
                        .addGap(18, 18, 18)
                        .addComponent(txtten, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnsua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnxoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtloai, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtma)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnthem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btntk)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btntk)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnthem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtloai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnsua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtten, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addComponent(btnxoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblloai.setForeground(new java.awt.Color(255, 51, 51));
        tblloai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "loại", "Mô tả"
            }
        ));
        tblloai.setSelectionBackground(new java.awt.Color(204, 255, 204));
        tblloai.setSelectionForeground(new java.awt.Color(255, 51, 51));
        tblloai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblloaiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblloai);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 100, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txttimkiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txttimkiemCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_txttimkiemCaretUpdate

    private void btntkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntkActionPerformed
        try {
            int id_LSP = Integer.parseInt(txttimkiem.getText());
            Model_Loai loai = repositories_Loai.findById(id_LSP);

            if (loai != null) {
                ArrayList<Model_Loai> list = new ArrayList<>();
                list.add(loai);
                mol.setRowCount(0); // clear table
                for (Model_Loai l : list) {
                    mol.addRow(l.toDataRow());
                }
            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy loại sản phẩm với mã: " + id_LSP, "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Mã loại sản phẩm không hợp lệ!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btntkActionPerformed

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        //        if (!validateFields()) {
        //            return;
        //        }

        try {
            int id_LSP = Integer.parseInt(txtma.getText());
            String ten_LSP = txtten.getText();
            String mo_ta = txtloai.getText();

            Model_Loai loai = new Model_Loai(id_LSP, ten_LSP, mo_ta);

            if (repositories_Loai.add(loai)) {
                JOptionPane.showMessageDialog(this, "Thêm thành công!");
                fillTable();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm thất bại!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Mã loại sản phẩm không hợp lệ!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnthemActionPerformed

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed

        Model_Loai loai = new Model_Loai(Integer.parseInt(txtma.getText()),
                txtten.getText(),
                txtloai.getText());

        boolean updateSuccess = repositories_Loai.update(loai);
        if (updateSuccess) {
            JOptionPane.showMessageDialog(this, "Sửa thành công!", "Success", JOptionPane.INFORMATION_MESSAGE);
            fillTable();
        } else {
            JOptionPane.showMessageDialog(this, "Sửa thất bại!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnsuaActionPerformed

    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
        int id_LSP;
        try {
            id_LSP = Integer.parseInt(txtma.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Mã khách hàng không hợp lệ!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean deleteSuccess = repositories_Loai.delete(id_LSP);
        if (deleteSuccess) {
            JOptionPane.showMessageDialog(this, "Xóa thành công!", "Success", JOptionPane.INFORMATION_MESSAGE);
            fillTable();  // Cập nhật lại bảng sau khi xóa
        } else {
            JOptionPane.showMessageDialog(this, "Xóa thất bại!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        this.loadTableData();
    }//GEN-LAST:event_btnxoaActionPerformed

    private void tblloaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblloaiMouseClicked
        i = tblloai.getSelectedRow();
        this.showData(i);
    }//GEN-LAST:event_tblloaiMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnthem;
    private javax.swing.JButton btntk;
    private javax.swing.JButton btnxoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblloai;
    private javax.swing.JTextField txtloai;
    private javax.swing.JTextField txtma;
    private javax.swing.JTextField txtten;
    private javax.swing.JTextField txttimkiem;
    // End of variables declaration//GEN-END:variables
}
