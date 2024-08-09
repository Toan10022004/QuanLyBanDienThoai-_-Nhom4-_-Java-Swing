package Test.src.test;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import raven.chart.ModelChart;

/**
 *
 * @author RAVEN
 */
public class Test extends javax.swing.JFrame {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;

    /**
     * Creates new form Test
     */
    public Test() {
        initComponents();
        chart.setTitle("Dữ liệu");
        chart.addLegend("Doanh thu", Color.decode("#7b4397"), Color.decode("#dc2430"));
        chart.addLegend("Số lượng sản phẩm", Color.decode("#e65c00"), Color.decode("#F9D423"));
        chart.addLegend("Số đơn", Color.decode("#0099F7"), Color.decode("#F11712"));
//        test();
        setData();
    }

    private void setData() {
        try {
            List<Model_Data> lists = new ArrayList<>();
            String sql = "SELECT Month(HoaDon.NgayTao) AS 'Tháng', SUM(HoaDon.TongTien) AS 'Doanh Thu', SUM(HoaDon.TongTien) AS 'Khác' , SUM(HoaDon.TongTien) AS 'Khác' \n"
                    + "FROM HoaDon\n"
                    + "WHERE HoaDon.TrangThai LIKE N'Hoàn tất'\n"
                    + "GROUP BY Month(HoaDon.NgayTao)\n"
                    + "ORDER BY Month(HoaDon.NgayTao);";
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String thang = rs.getString(1);
                double doanhThu = rs.getDouble(2);
                int SLSP = rs.getInt(3);
                int soDon = rs.getInt(4);
                lists.add(new Model_Data(thang, doanhThu, soDon, soDon));
            }
            rs.close();
            ps.close();
            //  Add Data to chart
            for (int i = lists.size() - 1; i >= 0; i--) {
                Model_Data d = lists.get(i);
                chart.addData(new ModelChart(d.getThang(), new double[]{d.getDoanhThu(), d.getSoLuong(), d.getSoDon()}));
            }
            //  Start to show data with animation
            chart.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    private void test() {
//        chart.clear();
//        chart.addData(new ModelChart("1", new double[]{500, 50, 100}));
//        chart.addData(new ModelChart("2", new double[]{600, 300, 150}));
//        chart.addData(new ModelChart("3", new double[]{200, 50, 900}));
//        chart.addData(new ModelChart("4", new double[]{480, 700, 100}));
//        chart.addData(new ModelChart("5", new double[]{350, 540, 500}));
//        chart.addData(new ModelChart("6", new double[]{450, 800, 100}));
//        chart.start();
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelShadow1 = new raven.panel.PanelShadow();
        chart = new raven.chart.CurveLineChart();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelShadow1.setBackground(new java.awt.Color(34, 59, 69));
        panelShadow1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelShadow1.setColorGradient(new java.awt.Color(17, 38, 47));

        chart.setForeground(new java.awt.Color(237, 237, 237));
        chart.setFillColor(true);

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Test().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private raven.chart.CurveLineChart chart;
    private raven.panel.PanelShadow panelShadow1;
    // End of variables declaration//GEN-END:variables
}