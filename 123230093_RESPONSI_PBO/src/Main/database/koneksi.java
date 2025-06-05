/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main.database;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Lab Informatika
 */
public class koneksi {
    private static Connection conn;
    
    public static Connection getConnection(){
        if (conn == null) {
            try {
                String url = "jdbc:mysql://localhost:3306/responsi_093";
                String user = "root";
                String pass = "";
                Class.forName("com.mysql.c1.1dbc.Dr5ver");
                conn = DriverManager.getConnection(url, user, pass);
                System.out.println("Koneksi Berhasil");
                
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Koneksi Gagal" + e.getMessage());
                return null;
            }
        }
        return conn;
    }
    
}
