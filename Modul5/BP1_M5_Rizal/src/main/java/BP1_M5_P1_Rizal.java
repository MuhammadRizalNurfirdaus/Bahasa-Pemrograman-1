/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Muhammad Rizal Nur F
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class BP1_M5_P1_Rizal extends JPanel {
    private static final int L = 400, Y = 400;
    private List<Mobil> mMobil;

    public BP1_M5_P1_Rizal() {
        setBackground(new Color(0, 0, 0));
        setLayout(null);

        mMobil = new ArrayList<>();
        mMobil.add(new Mobil(100, 200));

        Timer timer = new Timer(50, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (Mobil mobil : mMobil) {
                    mobil.Bergerak();
                }
                repaint();
            }
        });

        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Mobil mobil : mMobil) {
            mobil.GambarMobil(g);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(L, Y);
    }

    public class Mobil {
        private static final int INCREMENT = 5;
        private int x, y;

        public Mobil(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void GambarMobil(Graphics g) {
            g.setColor(Color.BLUE); // atap mobil
            g.fillRect(x + 15, y - 20, 60, 35);
            g.setColor(Color.YELLOW); // badan mobil
            g.fillRect(x, y, 110, 30);
            g.setColor(Color.RED); // roda mobil
            g.fillOval(x + 15, y + 20, 20, 20);
            g.fillOval(x + 60, y + 20, 20, 20);
        }

        public void Bergerak() {
            if (x >= L) { // jika sudah mencapai batas
                x = 1;    // kembali ke posisi awal
            } else {
                x += INCREMENT; // bergerak maju
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                frame.getContentPane().add(new BP1_M5_P1_Rizal());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setTitle("Animasi Mobil Bergerak!");
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
