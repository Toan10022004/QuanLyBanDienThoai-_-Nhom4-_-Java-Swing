/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConnectDao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author 84904
 */
public class ConnectDao {
    private final String serverName ="localhost";
    private final String dbName ="DU_AN_1";
    private final String portNumber = "1433";
     private final String userID ="sa";
    private final String pass = "123456";
    
    String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName+ ";user="+userID+ ";password="+pass;
    //     public   String url = "jdbc:sqlserver://localhost:1433;databaseName=QLHocSinh;user=sa;password=123456";
    public  Connection getConnectDAO(){
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("ban da cai dirver jdbc");
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            conn =DriverManager.getConnection(url);
            System.out.println("ket noi thanh cong");
            return conn;
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return null;
    }
    
    public static void main(String[] args) {
        ConnectDao con = new ConnectDao();
        con.getConnectDAO();
    }
}
