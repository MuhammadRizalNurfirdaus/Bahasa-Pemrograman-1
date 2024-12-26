/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projek_bp1;

/**
 *
 * @author Muhammad Rizal Nur F
 */
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class koneksi {
    Connection con;

    public koneksi() {
        String id = "root"; // user DBMS MySQL
        String pass = ""; // password DBMS MySQL
        String driver = "com.mysql.cj.jdbc.Driver"; // driver MySQL versi terbaru
        String url = "jdbc:mysql://localhost:3306/projek_bp1"; // nama database : db_mhs

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, id, pass);
            JOptionPane.showMessageDialog(null, "Koneksi Berhasil");
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Koneksi Gagal: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        koneksi k = new koneksi();
    }

    Statement Statement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}