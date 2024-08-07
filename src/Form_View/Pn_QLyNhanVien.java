/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Form_View;

import QuanLyNhanVien.Model_QlyNhanVien;
import QuanLyNhanVien.Repository_QlyMhanVien;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Admin
 */
public class Pn_QLyNhanVien extends javax.swing.JPanel {
    private Repository_QlyMhanVien repo_Nv = new Repository_QlyMhanVien();
    private DefaultTableModel mol = new DefaultTableModel();
    private int i=-1;// không chỉ vào dòng nào
    /**
     * Creates new form Pn_QLyNhanVien
     */
    public Pn_QLyNhanVien() {
        initComponents();
        this.fillTable(repo_Nv.getAll());
    }
    
    void fillTable(ArrayList<Model_QlyNhanVien> List){
        mol = (DefaultTableModel)tbl_NhanVien.getModel();
        //xoá sạch bảng cũ
        mol.setRowCount(0);
        for(Model_QlyNhanVien x: List){
            mol.addRow(x.toDataRow());
        }
        
    }
    
    void showData(int index){
        // lấy dl từ bảng để show
        String manv;
        String tennv;
        String gt;
        String diachi;
        String Quynhan;
        String mk;
        
        tennv = tbl_NhanVien.getValueAt(index,0).toString();
        manv = tbl_NhanVien.getValueAt(index,1).toString();
        gt = tbl_NhanVien.getValueAt(index,2).toString();
        diachi = tbl_NhanVien.getValueAt(index,3).toString();
        Quynhan = tbl_NhanVien.getValueAt(index,4).toString();
        mk = tbl_NhanVien.getValueAt(index, 5).toString();
        txtManv.setText(manv);
        txtTennv.setText(tennv);
        txtQuyenhan.setText(Quynhan);
        txtDiaChi.setText(diachi);
        txt_Pwd.setText(mk);
        
        if(gt.equalsIgnoreCase("nam")) rdoNam.setSelected(true);
        else rdoNu.setSelected(true);
    }
    
    Model_QlyNhanVien readForm() {
    String maNv, tenNv, diaChi, quyenHan,matkhau;
    boolean gioiTinh;
    
    maNv = txtManv.getText().trim();
    if (maNv.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Mã nhân viên đang rỗng");
        txtManv.requestFocus();
        return null;
    }

    // Kiểm tra mã nhân viên không có dấu
    if (!maNv.matches("[a-zA-Z0-9]+")) {
        JOptionPane.showMessageDialog(this, "Mã nhân viên chỉ được chứa ký tự không dấu và số");
        txtManv.requestFocus();
        return null;
    }
    
    tenNv = txtTennv.getText().trim();
    if (tenNv.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Tên nhân viên đang rỗng");
        txtTennv.requestFocus();
        return null;
    }

    diaChi = txtDiaChi.getText().trim();
    if (diaChi.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Địa chỉ đang rỗng");
        txtDiaChi.requestFocus();
        return null;
    }

    quyenHan = txtQuyenhan.getText().trim();
    if (quyenHan.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Quyền hạn đang rỗng");
        txtQuyenhan.requestFocus();
        return null;
    }

    matkhau = txt_Pwd.getText().trim();
    if (matkhau.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Mật khẩu đang rỗng");
        txt_Pwd.requestFocus();
        return null;
    }
    
    if (rdoNam.isSelected()) {
        gioiTinh = true;
    } else {
        gioiTinh = false;
    }

    return new Model_QlyNhanVien(maNv, tenNv, gioiTinh, diaChi, quyenHan,matkhau);
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
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_NhanVien = new javax.swing.JTable();
        btnSearch = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtManv = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTennv = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDiaChi = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        txtQuyenhan = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        txt_Pwd = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 153, 102));

        tbl_NhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên Nv", "Mã Nv", "Giới Tính", "Địa Chỉ", "Quyền Hạn", "Mật Khẩu"
            }
        ));
        tbl_NhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_NhanVienMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_NhanVien);

        btnSearch.setText("Tìm Kiếm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 153, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Mã Nhân Viên");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 9, -1, -1));
        jPanel1.add(txtManv, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 6, 205, -1));

        jLabel3.setText("Tên Nhân Viên");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 9, 77, -1));
        jPanel1.add(txtTennv, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 6, 250, -1));

        jLabel4.setText("Địa Chỉ:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 46, -1, -1));

        txtDiaChi.setColumns(20);
        txtDiaChi.setRows(5);
        jScrollPane1.setViewportView(txtDiaChi);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 43, 250, -1));

        jLabel5.setText("Quyền Hạn:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 46, -1, -1));
        jPanel1.add(txtQuyenhan, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 43, 206, -1));

        jPanel5.setBackground(new java.awt.Color(255, 153, 102));

        jLabel6.setText("Giới Tính:");

        buttonGroup1.add(rdoNam);
        rdoNam.setText("Nam");

        buttonGroup1.add(rdoNu);
        rdoNu.setText("Nữ");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(38, 38, 38)
                .addComponent(rdoNam)
                .addGap(53, 53, 53)
                .addComponent(rdoNu)
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(rdoNam)
                    .addComponent(rdoNu))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 123, -1, -1));

        jLabel7.setText("Mật Khẩu");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 86, -1, -1));
        jPanel1.add(txt_Pwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 83, 206, -1));

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-add-24.png"))); // NOI18N
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jPanel1.add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 6, 170, -1));

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/del.png"))); // NOI18N
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        jPanel1.add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 63, 170, -1));

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/rs.png"))); // NOI18N
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        jPanel1.add(btnSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 112, 170, -1));

        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-new-employee-24.png"))); // NOI18N
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        jPanel1.add(btnNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 161, 170, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản Lý Nhân Viên");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1014, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(200, 200, 200))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(139, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_NhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_NhanVienMouseClicked
        // TODO add your handling code here:
        i = tbl_NhanVien.getSelectedRow(); // lấy ra chỉ số dòng đc chọn
        this.showData(i);
    }//GEN-LAST:event_tbl_NhanVienMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        String tenCanTim = JOptionPane.showInputDialog(this, "Mời nhập tên");

        // Kiểm tra chuỗi nhập vào
        if (tenCanTim == null || tenCanTim.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên hợp lệ");
        } else {
            // Thực hiện tìm kiếm

            if(repo_Nv.timTen(tenCanTim).isEmpty()){
                JOptionPane.showMessageDialog(this,"Không tim thấy");
            }
            else{
                JOptionPane.showMessageDialog(this,"Có tìm được");
                this.fillTable(repo_Nv.timTen(tenCanTim));
    }//GEN-LAST:event_btnSearchActionPerformed
        }
    }
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        if(this.readForm()!=null){// có đối mới từ form để thêm
            int chon=JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm không?");
            if(chon==0){// có thêm
                repo_Nv.themNhanVien(this.readForm());// dl them vào data
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                // them vào bảng
                this.fillTable(repo_Nv.getAll());
            }
            else{// không thêm
                JOptionPane.showMessageDialog(this, "Bạn không thêm dl");
            }
        }

    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        i=tbl_NhanVien.getSelectedRow();// chọn dòng cần sửa
        if(i<0){
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn");
        }
        else{
            if(this.readForm()!=null){// dl mới sửa ok
                int chon=JOptionPane.showConfirmDialog(this, "Bạn chắc chắn sửa?");
                if(chon==0){
                    String maNv=tbl_NhanVien.getValueAt(i, 1).toString();
                    repo_Nv.suaNhanVien(maNv, this.readForm());
                    JOptionPane.showMessageDialog(this, "Sửa thành công");
                    this.fillTable(repo_Nv.getAll());
                }
            }
        }

    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        i=tbl_NhanVien.getSelectedRow();
        if(i<0) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn dòng cần xóa!");
        }
        else{// chọn rồi
            int chon=JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xoá không?");
            if(chon==0){// có xóa
                repo_Nv.xoaNhanVien(
                    tbl_NhanVien.getValueAt(i, 1).toString());
                JOptionPane.showMessageDialog(this, "Bạn đã xóa thành công.");
                // xóa trên bảng
                this.fillTable(repo_Nv.getAll());
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        // TODO add your handling code here:
        txtManv.setText("");
        txtTennv.setText("");
        txtQuyenhan.setText("");
        txtDiaChi.setText("");
        buttonGroup1.clearSelection();
        txt_Pwd.setText("");
    }//GEN-LAST:event_btnNewActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tbl_NhanVien;
    private javax.swing.JTextArea txtDiaChi;
    private javax.swing.JTextField txtManv;
    private javax.swing.JTextField txtQuyenhan;
    private javax.swing.JTextField txtTennv;
    private javax.swing.JTextField txt_Pwd;
    // End of variables declaration//GEN-END:variables
}
