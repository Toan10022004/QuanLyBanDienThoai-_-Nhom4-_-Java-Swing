/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OuputFile;

import DTO.DTO_DanhSachSanPham;
import DTO.DTO_SanPham_CTSP;
import Form_View.Form_XuatFile;
import OuputFile.Header;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Image;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author RAVEN
 */
public class DanhSachXuatFile extends javax.swing.JFrame {

    DefaultTableModel tblModel;
    List<DTO_SanPham_CTSP> listsp_ctsp = new ArrayList<>();
    List<DTO_DanhSachSanPham> listDSSP = new ArrayList<>();

    /**
     * Creates new form Main
     */
//    private PageFormat pageFormat = new PageFormat(PageType.A4, 0, 0, PageOrientation.PORTRAIT);
    public DanhSachXuatFile(List<DTO_SanPham_CTSP> sanPham_XuatFile_daChon, List<DTO_DanhSachSanPham> listSP) {
        initComponents();
        this.setLocationRelativeTo(this);
        this.setDefaultCloseOperation(Form_XuatFile.DISPOSE_ON_CLOSE);//sẽ được đóng và tài nguyên của nó sẽ được giải phóng, nhưng chương trình sẽ vẫn tiếp tục chạy.
        setLocationRelativeTo(null);
        setTitle("Export JTable to Excel");

        if (table.getColumnModel().getColumnCount() > 0) {
            int lastColumnIndex = table.getColumnModel().getColumnCount() - 1;
            int lastColumnWidth = table.getColumnModel().getColumn(lastColumnIndex).getPreferredWidth();
            table.getColumnModel().getColumn(3).setPreferredWidth(lastColumnWidth);
            table.getColumnModel().getColumn(9).setPreferredWidth(1000);
        }
        for (DTO_SanPham_CTSP ctsp : sanPham_XuatFile_daChon) {
            listsp_ctsp.add(ctsp);
        }
        for (DTO_DanhSachSanPham dssp : listSP) {
            listDSSP.add(dssp);
//            System.out.println("Danbh sachs sanr phaarm truyeenf sang "+dssp);
        }
        init();
    }

    private void init() {
        tblModel = (DefaultTableModel) table.getModel();
//                        List<Object> columnData = new ArrayList<>();
        List<DTO_SanPham_CTSP> l1 = new ArrayList<>();
        // Xóa các hàng cũ trong bảng nếu có
        tblModel.setRowCount(0);

        // Thêm dữ liệu vào bảng
        for (DTO_DanhSachSanPham l : listDSSP) {
             ImageIcon icon = new ImageIcon(l.getAnhSanPham());
             System.out.println("Link icon "+icon);
            tblModel.addRow(new Object[]{
                l.getMaSanPham(),
                icon,
                l.getTenSanPham(),
                l.getTenHang(),
                l.getTenLoaiSP(),
                l.getTrangThai(),
                l.getMoTa(),
                l.getNgayTao(),
                l.getNgaySua(),
                getSubTableData(l.getIdSanPham())
            });

        }
        table.autoRowHeight(table);
 // Tùy chỉnh TableCellRenderer để hiển thị hình ảnh với kích thước tùy chỉnh
    table.getColumnModel().getColumn(1).setCellRenderer(new ImageRenderer(50, 50)); // Chỉnh chiều rộng và chiều cao theo nhu cầu
    table.autoRowHeight(table);
    }
// Tạo lớp ImageRenderer để hiển thị hình ảnh với kích thước tùy chỉnh
class ImageRenderer extends DefaultTableCellRenderer {
    private int width;
    private int height;

    public ImageRenderer(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = new JLabel();
        if (value instanceof ImageIcon) {
            ImageIcon icon = (ImageIcon) value;
            Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
            label.setIcon(new ImageIcon(img));
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setPreferredSize(new Dimension(width, height));
        } else {
            label.setText(value != null ? value.toString() : "");
        }
        return label;
    }
}

    public DefaultTableModel getSubTableData(Integer idsp) {
//        System.out.println("ID sp ném sang chi Tiết ++++++" + idsp);
        DefaultTableModel data = new DefaultTableModel();
        data.setColumnCount(6);
        data.addRow(new Object[]{
            new Header("ID", 50),
            new Header("Màu Sắc", 120),
            new Header("Lượng Tồn", 170),
            new Header("Mô tả", 700),
            new Header("Trạng Thái", 200),
            new Header("Giá Bán", 200),
            new Header("Ngày Tạo", 200),
            new Header("Ngày Sửa", 200)
        });
        for (DTO_SanPham_CTSP l : listsp_ctsp) {
            if (l.getIdSanPham() == idsp) {
                if (l.getIdCtsp() == -1) {
                    data.addRow(new Object[]{
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        ""
                    });
                    break;
                } else if (l.getIdCtsp() != -1) {
                    data.addRow(new Object[]{
                        l.getIdCtsp(),
                        l.getMauSac(),
                        l.getSoLuongTon(),
                        l.getMoTa(),
                        l.getTrangThai(),
                        l.getGiaBan(),
                        l.getNgaySuaCTSP(),
                        l.getNgaySua()
                    });
                }

            }
        }

//        data.addRow(new Object[]{"1", "Hồng", "50", "Mô tả 1", "Ngưng hoạt động", "5000.000", "", ""});
//        data.addRow(new Object[]{"2", "Vital", "$ 70"});
//        data.addRow(new Object[]{"3", "Fanta", "$ 20"});
//        data.addRow(new Object[]{"4", "Coca", "$ 35"});
        return data;
    }

public void export(JTable table, File file) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
        TableModel model = table.getModel();

        bw.write("<html><head><style>");
        bw.write("table { border-collapse: collapse; font-family: 'Times New Roman'; width: 100%; }");
        bw.write("th, td { border: 1px solid black; padding: 5px; text-align: center; }");
        bw.write("</style></head><body><table>");

        // Write table headers
        bw.write("<tr>");
        for (int i = 0; i < model.getColumnCount(); i++) {
            if (i == 1) {
                bw.write("<th style='width: 25%;'>" + model.getColumnName(i) + "</th>");
            } else {
                bw.write("<th>" + model.getColumnName(i) + "</th>");
            }
        }
        bw.write("</tr>");

        // Write table data with images and nested tables
        for (int i = 0; i < model.getRowCount(); i++) {
            bw.write("<tr>");
            for (int j = 0; j < model.getColumnCount(); j++) {
                Object value = model.getValueAt(i, j);
                if (value != null) {
                    if (value instanceof DefaultTableModel) {
                        DefaultTableModel subTable = (DefaultTableModel) value;
                        bw.write("<td colspan='" + (model.getColumnCount() - j) + "'>");
                        bw.write("<table>");
                        bw.write("<tr>");
                        for (int subCol = 0; subCol < subTable.getColumnCount(); subCol++) {
                            bw.write("<th style='background-color: #00BFFF; color: white;'>" + subTable.getColumnName(subCol) + "</th>");
                        }
                        bw.write("</tr>");
                        for (int subRow = 0; subRow < subTable.getRowCount(); subRow++) {
                            bw.write("<tr>");
                            for (int subCol = 0; subCol < subTable.getColumnCount(); subCol++) {
                                Object subValue = subTable.getValueAt(subRow, subCol);
                                bw.write("<td>" + (subValue != null ? subValue.toString() : "") + "</td>");
                            }
                            bw.write("</tr>");
                        }
                        bw.write("</table>");
                        bw.write("</td>");
                    } else if (j == 1 && value instanceof ImageIcon) { // Image column
                        ImageIcon icon = (ImageIcon) value;
                        bw.write("<td><img  src='file:///" + icon.getDescription().replace("\\", "/") + "' alt='Image' width='100' height='100'/></td>");
                    } else {
                        bw.write("<td>" + value.toString() + "</td>");
                    }
                } else {
                    bw.write("<td></td>");
                }
            }
            bw.write("</tr>");
        }

        bw.write("</table></body></html>");
    } catch (IOException e) {
        e.printStackTrace();
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








//    public DefaultTableModel getSubTableData1() {
//        DefaultTableModel data = new DefaultTableModel();
//        data.setColumnCount(3);
//        data.addRow(new Object[]{new Header("No", 200), new Header("Type"), new Header("Qty")});
//        data.addRow(new Object[]{1, "Unit", "50"});
//        data.addRow(new Object[]{1, "Case", "70"});
//        data.addRow(new Object[]{1, "Box", "3"});
//        return data;
//    }
//    private ReportOption getReportOption() {
//        return new ReportOption("", "No", "Customer", "Amount", "", "", "", "", "", "", new ReportOption("Product List", "No", "Item", "Total", new ReportOption("Detail", "No", "Type", "Qty")));
//    }
//
//    private File showFileChooser() {
//        JFileChooser ch = new JFileChooser();
//        int opt = ch.showSaveDialog(this);
//        if (opt == JFileChooser.APPROVE_OPTION) {
//            return ch.getSelectedFile();
//        } else {
//            return null;
//        }
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new OuputFile.TableCustom();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Sản Phẩm", "Ảnh Sản Phẩm", "Tên Sản Phẩm", "Hãng", "Loại", "Trạng Thái", "Mô Tả", "Ngày Tạo", "Ngày sửa", "Chi tiết Sản Phẩm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(3).setPreferredWidth(500);
        }

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(153, 51, 0));
        jButton1.setText("Xuất File");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1176, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
//        if(evt.get() == btn){
        JFileChooser fchoose = new JFileChooser();
        int option = fchoose.showSaveDialog(DanhSachXuatFile.this);
        if (option == JFileChooser.APPROVE_OPTION) {
            String name = fchoose.getSelectedFile().getName();
            String path = fchoose.getSelectedFile().getParentFile().getPath();
            String file = path + "\\" + name + ".xls";
            export(table, new File(file));
        }
//         }
    }//GEN-LAST:event_jButton1ActionPerformed

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
//            java.util.logging.Logger.getLogger(DanhSachXuatFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(DanhSachXuatFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(DanhSachXuatFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(DanhSachXuatFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new DanhSachXuatFile().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private OuputFile.TableCustom table;
    // End of variables declaration//GEN-END:variables
}
