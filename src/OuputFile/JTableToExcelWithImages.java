package OuputFile;

import javax.swing.table.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;

public class JTableToExcelWithImages extends JFrame {
    // JTable Header
    String[] columns = new String[] {
        "Id",
        "Name", 
        "Address", 
        "Hourly rate", 
        "Ảnh sản phẩm" // New column for images
    };

    // data for JTable in a 2D table
    Object[][] data = new Object[][] {
        {1, "Thomas", "Paris", 20.0, "C:\\Users\\84904\\Desktop\\image\\images (1).jpg"},
        {2, "Jean", "Marseille", 50.0, "C:\\Users\\84904\\Desktop\\image\\images.jpg"},
        {3, "Yohan", "Lyon", 30.0, ""},
        {4, "Emily", "Toulouse", 60.0, ""},
        {5, "Alex", "Nice", 10.0, ""},
        {6, "Nicolas", "Lille", 11.5, ""}
    };

    // create a JTable with data
    JTable table = new JTable(data, columns);
    JPanel panel = new JPanel(new BorderLayout());
    JButton btnExportExcel = new JButton("Export Excel");

    public JTableToExcelWithImages() {
        setSize(450, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Export JTable to Excel with Images");
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(btnExportExcel);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        add(panel);
        setVisible(true);
        btnExportExcel.addActionListener(new ExportExcelListener());
    }

    public void exportExcelWithImages(JTable table, File file) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            TableModel model = table.getModel();

            bw.write("<html><body><table border='1' style='border-collapse:collapse;'>");

            // Write column headers
            bw.write("<tr>");
            for (int i = 0; i < model.getColumnCount(); i++) {
                bw.write("<th>" + model.getColumnName(i) + "</th>");
            }
            bw.write("</tr>");

            // Write table data with images in the new column
            for (int i = 0; i < model.getRowCount(); i++) {
                bw.write("<tr>");
                for (int j = 0; j < model.getColumnCount(); j++) {
                    if (j == 4 && !model.getValueAt(i, j).toString().isEmpty()) { // New column for images
                        bw.write("<td style='width:120px; height:120px;'><img src='file:///" + model.getValueAt(i, j).toString().replace("\\", "/") + "' width='100' height='100'/></td>");
                    } else {
                        bw.write("<td style='width:120px; height:120px;'>" + model.getValueAt(i, j).toString() + "</td>");
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
            Desktop.getDesktop().open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new JTableToExcelWithImages();
    }

    class ExportExcelListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JFileChooser fchoose = new JFileChooser();
            int option = fchoose.showSaveDialog(JTableToExcelWithImages.this);
            if (option == JFileChooser.APPROVE_OPTION) {
                String name = fchoose.getSelectedFile().getName(); 
                String path = fchoose.getSelectedFile().getParentFile().getPath();
                String file = path + "\\" + name + ".xls"; 

                exportExcelWithImages(table, new File(file));
            }
        }
    }
}
