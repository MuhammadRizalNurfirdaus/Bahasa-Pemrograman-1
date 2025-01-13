/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Muhammad Rizal Nur F
 */
import javax.swing.*;
import java.awt.*;

public class BP1_M5_PreTest_Rizal extends JPanel {
    private int x = 0;  // Posisi x awal objek
    private int y = 50; // Posisi y awal objek

    public void moveBall() {
        while (true) {
            x += 5; // Gerak ke kanan
            if (x > getWidth()) {
                x = 0; // Reset posisi jika keluar layar
            }
            repaint(); // Gambar ulang
            try {
                Thread.sleep(50); // Delay animasi
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillOval(x, y, 30, 30); // Gambar lingkaran
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Animation");
        BP1_M5_PreTest_Rizal animation = new BP1_M5_PreTest_Rizal();

        frame.add(animation);
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        animation.moveBall(); // Memulai animasi
    }
}
