/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Muhammad Rizal Nur F
 */
    public class BP1_M2_PostTest1_Rizal_AppletMouse extends Applet implements MouseListener, MouseMotionListener {
        
       private String message = "Arahkan dan klik mouse pada area ini";

    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */


    @Override
    public void init() {
        addMouseListener(this);
        addMouseMotionListener(this);
          // TODO start asynchronous download of heavy resources
    }

    @Override
    public void paint(Graphics g) {
        g.setFont(new Font("Arial", Font.PLAIN, 16));
        g.drawString(message, 20, 20);
    }

    // Event handler untuk mouse klik
    @Override
    public void mouseClicked(MouseEvent e) {
        message = "Mouse diklik pada: " + e.getX() + ", " + e.getY();
        repaint();
    }

    // Event handler untuk mouse masuk
    @Override
    public void mouseEntered(MouseEvent e) {
        message = "Mouse masuk area";
        repaint();
    }

    // Event handler untuk mouse keluar
    @Override
    public void mouseExited(MouseEvent e) {
        message = "Mouse keluar dari area";
        repaint();
    }

    // Event handler untuk mouse ditekan
    @Override
    public void mousePressed(MouseEvent e) {}

    // Event handler untuk mouse dilepas
    @Override
    public void mouseReleased(MouseEvent e) {}

    // Event handler untuk pergerakan mouse
    @Override
    public void mouseMoved(MouseEvent e) {
        message = "Mouse bergerak ke: " + e.getX() + ", " + e.getY();
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {}
}
  
        // TODO start asynchronous download of heavy resources
    
    // TODO overwrite start(), stop() and destroy() methods
