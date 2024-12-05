/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.applet.Applet;
import java.awt.Graphics;
/**
 *
 * @author Muhammad Rizal Nur F
 */
public class Applet_Umum extends Applet {

    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    public void init() {
        // TODO start asynchronous download of heavy resources
    }
      public void start() {
    
    }
          public void stop() {
        // Logika untuk menghentikan applet
    }

    // Method yang dipanggil saat applet dihancurkan
    public void destroy() {
        // Logika untuk membersihkan sebelum applet dihancurkan
    }

    // Method untuk menggambar di applet
    public void paint(Graphics g) {
        // Logika untuk menggambar di layar
        g.drawString("Hello, Applet!!!", 20, 20);
    }
}

    // TODO overwrite start(), stop() and destroy() methods
