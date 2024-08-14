package Form_View;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class myTableCellRenderer extends DefaultTableCellRenderer {
    private int imageWidth;
    private int imageHeight;

    public myTableCellRenderer(int width, int height) {
        this.imageWidth = width;
        this.imageHeight = height;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (value instanceof JLabel) {
            JLabel label = (JLabel) value;
            Icon icon = label.getIcon();
            if (icon != null) {
                Image img = ((ImageIcon) icon).getImage();
                Image scaledImg = img.getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);
                label.setIcon(new ImageIcon(scaledImg));
            }
            label.setPreferredSize(new Dimension(imageWidth, imageHeight)); // Set preferred size for the JLabel
            return label;
        } else {
            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Image in JTable");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                String[] columnNames = {"Image"};
                Object[][] data = {
                    {new JLabel(new ImageIcon("path/to/image1.jpg"))},
                    {new JLabel(new ImageIcon("path/to/image2.jpg"))}
                };

                JTable table = new JTable(data, columnNames);
                
                // Thiết lập kích thước cho ảnh
                int imageWidth = 100; // Thay đổi giá trị này để thiết lập chiều rộng của ảnh
                int imageHeight = 100; // Thay đổi giá trị này để thiết lập chiều cao của ảnh
                
                // Sử dụng myTableCellRenderer cho cột "Image"
                table.getColumnModel().getColumn(0).setCellRenderer(new myTableCellRenderer(imageWidth, imageHeight));
                table.setRowHeight(imageHeight); // Set row height to accommodate the image

                frame.add(new JScrollPane(table));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
