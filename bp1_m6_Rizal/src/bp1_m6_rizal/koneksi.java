package bp1_m6_rizal;

/* @author Muhammad Rizal Nur F
 */
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class koneksi {
    Connection con;

    public koneksi() {
        String id = "root"; // user DBMS MySQL
        String pass = ""; // password DBMS MySQL
        String driver = "com.mysql.jdbc.Driver"; // driver MySQL versi terbaru
        String url = "jdbc:mysql://localhost:3306/db_mhs"; // nama database : db_mhs

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, id, pass);
            JOptionPane.showMessageDialog(null, "Koneksi Berhasil");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi Gagal: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        koneksi k = new koneksi();
    }
}