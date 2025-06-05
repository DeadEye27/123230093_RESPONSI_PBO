/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main.model;
import java.sql.*;
import java.util.ArrayList;
import Main.database.koneksi;
/**
 *
 * @author Lab Informatika
 */
public class modelParkir {
    public static class dataParkir {
        public String nama;
        public String plat;
        public String merk;
        public int durasi;
        
        public dataParkir(String nama, String plat, String merk, int durasi) {
            this.nama = nama;
            this.plat = plat;
            this.merk = merk;
            this.durasi = durasi; 
        }

        public int getTotalBayar(){
            int total = 0;
            if (durasi <= 4){
                total += durasi * 5000;
            } else {
                total += (durasi * 5000) + 2000;
            }
            return total;
        }
    }
    
    
    //mengambil semua data parkir yang ada di dalam database
    public ArrayList<dataParkir> getAlldataParkir(){
        ArrayList<dataParkir> dataparkirs =new ArrayList<>();
        try {
            Connection conn = koneksi.getConnection();
            String sql = "SELECT * FROM db_parkir";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                dataparkirs.add(new dataParkir(
                    rs.getString("nama"),
                    rs.getString("plat"),
                    rs.getString("merk"),
                    rs.getInt("durasi")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataparkirs;
    }
    
    //method tambah data parkir
    public boolean addDataParkir(String nama, String plat, String merk, int durasi){
        try {
            Connection conn = koneksi.getConnection();
            String sql = "INSERT INTO db_parkir(nama, plat, merk, durasi) VALUES (?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nama);
            stmt.setString(2, plat);
            stmt.setString(3, merk);
            stmt.setInt(4, durasi);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    //method hapus data parkir
    public boolean deleteDataParkir(int id){
        try {
            Connection conn = koneksi.getConnection();
            String sql = "DELETE FROM db_parkir WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    //method edit data parkir
    public boolean updateDataParkir(int id, String nama, String plat, String merk, int durasi){
        try {
            Connection conn = koneksi.getConnection();
            String sql = "UPDATE db_parkir SET nama=?, plat=?, merk=?, durasi=? WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nama);
            stmt.setString(2, plat);
            stmt.setString(3, merk);
            stmt.setInt(4, durasi);
            stmt.setInt(5, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
