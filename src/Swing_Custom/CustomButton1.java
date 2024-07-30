package Swing_Custom;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;

public class CustomButton1 extends JButton {
    private int roundTopLeft = 6;
    private int roundTopRight = 6;
    private int roundBottomLeft = 6;
    private int roundBottomRight = 6;

    public CustomButton1() {
        // Xóa viền của button
        setBorderPainted(false);
        setFocusPainted(false);
        setContentAreaFilled(false);

        // Đặt font chữ và màu sắc
        setFont(new Font("Arial", Font.BOLD, 14));
        setForeground(Color.BLACK);

        // Thiết lập màu nền khi hover và không hover
        setBackground(new Color(235, 245, 251)); // Màu nền mặc định
        setOpaque(false); // Cho phép vẽ màu nền

        // Bắt sự kiện hover
//        addMouseListener(new java.awt.event.MouseAdapter() {
//            public void mouseEntered(java.awt.event.MouseEvent evt) {
//                setBackground(new Color(255, 153, 153)); // Màu nền khi hover
//            }
//
//            public void mouseExited(java.awt.event.MouseEvent evt) {
//                setBackground(new Color(235, 245, 251)); // Màu nền khi không hover
//            }
//            public void MousePressed(java.awt.event.MouseEvent evt) {
//                setBackground(new Color(255, 0, 0)); 
//            }
//        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Vẽ nền với các góc bo tròn
        g2.setColor(getBackground());
        Shape border = createRoundRectangle(getWidth(), getHeight(), roundTopLeft, roundTopRight, roundBottomLeft, roundBottomRight);
        g2.fill(border);

        // Vẽ bo viền
//        g2.setColor(Color.BLACK); // Màu bo viền
//        g2.setStroke(new BasicStroke(1)); // Độ dày bo viền
        g2.draw(border);

        g2.dispose();
        super.paintComponent(g);
    }

    private Shape createRoundRectangle(int width, int height, int topLeft, int topRight, int bottomLeft, int bottomRight) {
        Path2D.Float path = new Path2D.Float();
        path.moveTo(0, topLeft);
        path.quadTo(0, 0, topLeft, 0); // Top-left corner
        path.lineTo(width - topRight, 0);
        path.quadTo(width, 0, width, topRight); // Top-right corner
        path.lineTo(width, height - bottomRight);
        path.quadTo(width, height, width - bottomRight, height); // Bottom-right corner
        path.lineTo(bottomLeft, height);
        path.quadTo(0, height, 0, height - bottomLeft); // Bottom-left corner
        path.closePath();
        return path;
    }

    
}
