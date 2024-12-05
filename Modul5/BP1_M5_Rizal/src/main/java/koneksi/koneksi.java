/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package koneksi;

/**
 *
 * @author Muhammad Rizal Nur F
 */
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class koneksi {
    Connection con;
    
    public koneksi(){
        String id, pass, driver, url;
        id="root"; //user DBMS MySql
        pass=""; //password DBMS MySql
        driver="com.mysql.jdbc.Driver"; //driver MySql
        url="jdbc:mysql://localhost:3306/db_mhs"; // nama database : db_mhs
        
        try
        {
            Class.forName(driver).newInstance();
            con=DriverManager.getConnection(url,id,pass);
            JOptionPane.showMessageDialog(null, "Koneksi Berhasil");
        }
        catch(Exception e)
        { System.out.println(""+e.getLocalizedMessage());}
    }
    
    public static void main(String[]args)
    { koneksi k=new koneksi(); }
}
