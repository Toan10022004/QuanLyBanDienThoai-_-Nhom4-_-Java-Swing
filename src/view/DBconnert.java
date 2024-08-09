/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class DBconnert {

public static final String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=DU_AN_1;user=sa;password=123456;encrypt=true;trustServerCertificate=true;";
        public static Connection getdataUSER(){
            try {
                Connection con = null;
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection(connectionUrl);
                return con;
            } catch (ClassNotFoundException ex) {
                System.out.println("Where is Driver ?");
                System.out.println("Error: "+ex.toString());
            } catch(SQLException ex){
                System.out.println("Error: "+ex.toString());
            }
            return null;
        }
        
}