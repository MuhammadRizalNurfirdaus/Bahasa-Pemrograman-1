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
public class BP1_M2_PostTest2_Rizal_Applet3D extends Applet {

    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
     @Override
    public void paint(Graphics g) {
         setBackground(Color.lightGray);

        g.setColor(Color.blue);
        g.fillRect(50, 50, 100, 100);

         g.setColor(Color.darkGray);
        g.fillRect(70, 70, 100, 100);
  
        g.setColor(Color.black);
        g.drawLine(50, 50, 70, 70);
        g.drawLine(150, 50, 170, 70);
        g.drawLine(50, 150, 70, 170);
        g.drawLine(150, 150, 170, 170);
    }

        // TODO start asynchronous download of heavy resources
    // TODO overwrite start(), stop() and destroy() methods
}