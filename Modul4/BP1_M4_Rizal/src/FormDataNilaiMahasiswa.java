/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import javax.swing.*;
import java.awt.event.*;


public class FormDataNilaiMahasiswa extends JFrame {
    private JTextField txtNIM, txtNama;
    private JTextArea txtNilai;
    private JButton btnSimpan;

    public FormDataNilaiMahasiswa() {
        setTitle("Data Nilai Mahasiswa");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblNIM = new JLabel("NIM");
        lblNIM.setBounds(20, 30, 100, 30);
        add(lblNIM);
        txtNIM = new JTextField();
        txtNIM.setBounds(120, 30, 240, 30);
        add(txtNIM);

        JLabel lblNama = new JLabel("Nama");
        lblNama.setBounds(20, 70, 100, 30);
        add(lblNama);
        txtNama = new JTextField();
        txtNama.setBounds(120, 70, 240, 30);
        add(txtNama);

        JLabel lblNilai = new JLabel("Nilai");
        lblNilai.setBounds(20, 110, 100, 30);
        add(lblNilai);
        txtNilai = new JTextArea();
        txtNilai.setBounds(120, 110, 240, 100);
        add(txtNilai);

        btnSimpan = new JButton("Simpan");
        btnSimpan.setBounds(150, 220, 100, 30);
        add(btnSimpan);

        btnSimpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Data Nilai Tersimpan!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        setVisible(true);
    }
}
