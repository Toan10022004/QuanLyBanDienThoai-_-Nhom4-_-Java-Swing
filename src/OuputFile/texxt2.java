/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OuputFile;
import javax.swing.table.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.awt.Desktop;


class JTableToExcel extends JFrame
{
  //JTable Header
  String[] columns = new String[] {
        "Id",
        "Name", 
        "Address", 
        "Hourly rate", 
  };

  //data for JTable in a 2D table
  Object[][] data = new Object[][] {
        {1, "taon", "hà nam", 123.0 },
        {2, "nam", "Marseille", 50.0 },
        {3, "link", "Lyon", 30.0 },
        {4, "Emily", "Toulouse", 60.0 },
        {5, "Alex", "Nice", 10.0 },
        {6, "Nicolas", "Lille", 11.5 },
  };
 
  //create a JTable with data
  JTable table = new JTable(data, columns);
  JPanel panel = new JPanel(new BorderLayout());
  JButton btn = new JButton("Export");

  public JTableToExcel(){
    setSize(450,200);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setTitle("Export JTable to Excel");
    panel.add(btn, BorderLayout.SOUTH);
    panel.add(new JScrollPane(table), BorderLayout.NORTH);
    add(panel);
    setVisible(true);
    btn.addActionListener(new MyListener());
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

        // Mở file sau khi ghi xong
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            if (file.exists()) {
                desktop.open(file);
            }
        }
    } catch (IOException e) {
        System.out.println(e);
    }
}


  public static void main(String[] args){
        new JTableToExcel();
  }

  class MyListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
         if(e.getSource() == btn){
           JFileChooser fchoose = new JFileChooser();
           int option = fchoose.showSaveDialog(JTableToExcel.this);
           if(option == JFileChooser.APPROVE_OPTION){
             String name = fchoose.getSelectedFile().getName(); 
             String path = fchoose.getSelectedFile().getParentFile().getPath();
             String file = path + "\\" + name + ".xls"; 
             export(table, new File(file));
           }
         }
      }
  }
}