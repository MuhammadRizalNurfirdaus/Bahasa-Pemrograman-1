/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * 
 * @author Muhammad Rizal Nur F
 */

public class BP1_M4_PRETEST1_Rizal {
    public static void main(String[] args) {
        // Membuat JFrame
        JFrame frame = new JFrame("Contoh Swing Control");
        frame.setSize(400, 300); // Ukuran JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Menutup aplikasi saat JFrame ditutup
        frame.setLayout(null); // Menggunakan layout null untuk posisi manual komponen

        // Membuat Label
        JLabel label = new JLabel("Nama:"); // Label untuk input nama
        label.setBounds(50, 50, 100, 30); // Posisi dan ukuran label
        frame.add(label);

        // Membuat TextField
        JTextField textField = new JTextField(); // Input teks untuk nama
        textField.setBounds(150, 50, 150, 30); // Posisi dan ukuran TextField
        frame.add(textField);

        // Membuat Button
        JButton button = new JButton("Tampilkan"); // Tombol untuk menampilkan nama
        button.setBounds(150, 100, 100, 30); // Posisi dan ukuran tombol
        frame.add(button);

        // Membuat Label untuk output
        JLabel outputLabel = new JLabel(); // Label untuk menampilkan hasil output
        outputLabel.setBounds(50, 150, 300, 30); // Posisi dan ukuran output label
        frame.add(outputLabel);

        // Menambahkan Action Listener pada tombol
        /*
         * Click nbfs://nbhost/SystemFileSystem/Templates/Events/ActionListener.java to edit this template
         */
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mengambil teks dari TextField
                String nama = textField.getText();
                // Menampilkan teks di outputLabel
                outputLabel.setText("Halo, " + nama + "!");
            }
        });

        // Menampilkan JFrame
        frame.setVisible(true); // Membuat JFrame terlihat
    }
}
