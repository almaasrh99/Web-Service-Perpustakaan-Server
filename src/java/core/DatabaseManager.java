/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

//import Model.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DatabaseManager {
    public static Connection getDBConnection() {
        String host = "localhost"; 
        String port = "1521";
        String db = "xe"; 
        String usr = "ADMIN"; 
        String pwd = "ADMIN"; 

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Maaf driver class tidak ditemukan");
            System.out.println(ex.getMessage());
        }
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@" + host + ":" + port + ":" + db, usr, pwd);
        } catch (SQLException ex) {
            System.out.println("koneksi tidak berhasil");
            System.out.println(ex.getMessage());
        }

        if (conn != null) {
            System.out.println("Koneksi ke database terbentuk");
        } else {
            System.out.println("Koneksi gagal terbentuk");
        }
        return conn;
    }
}
