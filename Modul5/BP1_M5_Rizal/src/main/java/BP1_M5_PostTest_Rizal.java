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

public class BP1_M5_PostTest_Rizal extends JPanel {
    private int x = 0;  // Posisi x awal objek
    private int y = 0;  // Posisi y awal objek
    private int dx = 5; // Kecepatan horizontal
    private int dy = 3; // Kecepatan vertikal

    public void moveBall() {
        while (true) {
            x += dx; // Gerak horizontal
            y += dy; // Gerak vertikal

            // Pantul jika mencapai tepi layar
            if (x < 0 || x > getWidth() - 30) dx = -dx;
            if (y < 0 || y > getHeight() - 30) dy = -dy;

            repaint(); // Gambar ulang
            try {
                Thread.sleep(30); // Delay animasi
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillOval(x, y, 30, 30); // Gambar lingkaran
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("PostTest Animation");
        BP1_M5_PostTest_Rizal animation = new BP1_M5_PostTest_Rizal();

        frame.add(animation);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        animation.moveBall(); // Memulai animasi
    }
}
