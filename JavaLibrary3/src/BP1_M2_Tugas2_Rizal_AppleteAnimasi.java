/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.applet.Applet;
import java.awt.*;

/**
 *
 * @author Muhammad Rizal Nur F
 */
   public class BP1_M2_Tugas2_Rizal_AppleteAnimasi extends Applet implements Runnable {
      private int x = 0;  
      private int dx = 2; 
      private Thread animasiThread;
    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    @Override
    public void init() {
        setBackground(Color.white);
    }

    @Override
    public void start() {
        animasiThread = new Thread(this);
        animasiThread.start();
    }

    @Override
    public void run() {
        while (true) {
            x += dx;
            if (x < 0 || x > getWidth() - 50) { 
                dx = -dx; 
            }
            repaint();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.red);
        g.fillOval(x, getHeight() / 2 - 25, 50, 50); 
    }

    @Override
    public void stop() {
        animasiThread = null;
    }
        // TODO start asynchronous download of heavy resources

    // TODO overwrite start(), stop() and destroy() methods
}    