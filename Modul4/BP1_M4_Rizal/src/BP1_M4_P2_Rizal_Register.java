/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * @author Muhammad Rizal Nur F
 */
public class BP1_M4_P2_Rizal_Register extends JFrame {
    private JTextField txtNIM, txtNama, txtKelas, txtAngkatan, txtDPA, txtSemester;
    private JRadioButton rbLaki, rbPerempuan;
    private JComboBox<String> cbProdi;
    private JCheckBox cbNonton, cbOlahraga, cbDengerinMusik, cbTraveling;
    private JTextArea txtAlamat, txtHasil; // Declare txtHasil for results
    private JButton btnRegister, btnKeluar;

    public BP1_M4_P2_Rizal_Register() {
        // Set title JFrame
        setTitle("FORM REGISTER");
        setSize(400, 800);  // Increase size to accommodate new fields
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Title
        JLabel lblTitle = new JLabel("FORM REGISTER", SwingConstants.CENTER);
        lblTitle.setBounds(100, 10, 200, 30);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 16));
        add(lblTitle);

        // NIM
        JLabel lblNIM = new JLabel("NIM");
        lblNIM.setBounds(20, 50, 100, 30);
        add(lblNIM);
        txtNIM = new JTextField();
        txtNIM.setBounds(120, 50, 240, 30);
        add(txtNIM);

        // Nama
        JLabel lblNama = new JLabel("NAMA");
        lblNama.setBounds(20, 90, 100, 30);
        add(lblNama);
        txtNama = new JTextField();
        txtNama.setBounds(120, 90, 240, 30);
        add(txtNama);

        // Jenis Kelamin
        JLabel lblJenisKelamin = new JLabel("JENIS KELAMIN");
        lblJenisKelamin.setBounds(20, 130, 100, 30);
        add(lblJenisKelamin);

        rbLaki = new JRadioButton("Laki-laki");
        rbLaki.setBounds(120, 130, 100, 30);
        add(rbLaki);

        rbPerempuan = new JRadioButton("Perempuan");
        rbPerempuan.setBounds(230, 130, 100, 30);
        add(rbPerempuan);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(rbLaki);
        genderGroup.add(rbPerempuan);

        // Prodi
        JLabel lblProdi = new JLabel("PRODI");
        lblProdi.setBounds(20, 170, 100, 30);
        add(lblProdi);
        String[] prodiOptions = {"Teknik Informatika", "Sistem Informasi", "Manajemen"};
        cbProdi = new JComboBox<>(prodiOptions);
        cbProdi.setBounds(120, 170, 240, 30);
        add(cbProdi);

        // Hobi
        JLabel lblHobi = new JLabel("HOBI");
        lblHobi.setBounds(20, 210, 100, 30);
        add(lblHobi);

        cbNonton = new JCheckBox("Nonton");
        cbNonton.setBounds(120, 210, 100, 30);
        add(cbNonton);

        cbOlahraga = new JCheckBox("Dedengerin Musik");
        cbOlahraga.setBounds(230, 210, 100, 30);
        add(cbOlahraga);

        cbDengerinMusik = new JCheckBox("Olahraga");
        cbDengerinMusik.setBounds(120, 240, 150, 30);
        add(cbDengerinMusik);

        cbTraveling = new JCheckBox("Traveling");
        cbTraveling.setBounds(230, 240, 100, 30);
        add(cbTraveling);

        // Alamat
        JLabel lblAlamat = new JLabel("ALAMAT");
        lblAlamat.setBounds(20, 280, 100,  30);
        add(lblAlamat);
        txtAlamat = new JTextArea();
        txtAlamat.setBounds(120, 280, 240, 50);
        add(txtAlamat);

        // Kelas
        JLabel lblKelas = new JLabel("KELAS");
        lblKelas.setBounds(20, 340, 100, 30);
        add(lblKelas);
        txtKelas = new JTextField();
        txtKelas.setBounds(120, 340, 240, 30);
        add(txtKelas);

        // Angkatan
        JLabel lblAngkatan = new JLabel("ANGKATAN");
        lblAngkatan.setBounds(20, 380, 100, 30);
        add(lblAngkatan);
        txtAngkatan = new JTextField();
        txtAngkatan.setBounds(120, 380, 240, 30);
        add(txtAngkatan);

        // DPA
        JLabel lblDPA = new JLabel("DPA");
        lblDPA.setBounds(20, 420, 100, 30);
        add(lblDPA);
        txtDPA = new JTextField();
        txtDPA.setBounds(120, 420, 240, 30);
        add(txtDPA);

        // Semester
        JLabel lblSemester = new JLabel("SEMESTER");
        lblSemester.setBounds(20, 460, 100, 30);
        add(lblSemester);
        txtSemester = new JTextField();
        txtSemester.setBounds(120, 460, 240, 30);
        add(txtSemester);

        // Register and Exit Buttons
        btnRegister = new JButton("Register");
        btnRegister.setBounds(120, 500, 100, 30);
        add(btnRegister);

        btnKeluar = new JButton("Keluar");
        btnKeluar.setBounds(230, 500, 100, 30);
        add(btnKeluar);

        // Result TextArea
        txtHasil = new JTextArea();
        txtHasil.setBounds(20, 540, 340, 150);
        txtHasil.setEditable(false); // Make it non-editable
        add(txtHasil);

        // Action Listener for Register
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isDataLengkap()) {
                    tampilkanHasil();
                    JOptionPane.showMessageDialog(null, "Registrasi berhasil!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                    new FormDataNilaiMahasiswa();  // Show the next form
                    dispose(); // Close register form
                } else {
                    JOptionPane.showMessageDialog(null, "Registrasi gagal, data harus lengkap!", "Error", JOptionPane.ERROR_MESSAGE);
                    new BP1_M4_P1_Rizal(); // Show login form again
                    dispose(); // Close register form
                }
            }
        });

        // Action Listener for Exit
        btnKeluar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    // Method to check if data is complete
    private boolean isDataLengkap() {
        // Check if all fields are filled
        return !txtNIM.getText().isEmpty() && !txtNama.getText().isEmpty() && 
               !txtKelas.getText().isEmpty() && !txtAngkatan.getText().isEmpty() &&
               !txtDPA.getText().isEmpty() && !txtSemester.getText().isEmpty() && 
               (rbLaki.isSelected() || rbPerempuan.isSelected()) && cbProdi.getSelectedIndex() != -1;
    }

    // Method to display the results in a TextArea
    private void tampilkanHasil() {
        String hasil = "NIM: " + txtNIM.getText() + "\n";
        hasil += "Nama: " + txtNama.getText() + "\n";
        hasil += "Jenis Kelamin: " + (rbLaki.isSelected() ? "Laki-laki" : "Perempuan") + "\n";
        hasil += "Prodi: " + cbProdi.getSelectedItem() + "\n";
        hasil += "Hobi: " + (cbNonton.isSelected() ? "Nonton, " : "") + 
                 (cbOlahraga.isSelected() ? "Olahraga, " : "") +
                 (cbDengerinMusik.isSelected() ? "Dengerin Musik, " : "") + 
                 (cbTraveling.isSelected() ? "Traveling" : "") + "\n";
        hasil += "Alamat: " + txtAlamat.getText() + "\n";
        hasil += "Kelas: " + txtKelas.getText() + "\n";
        hasil += "Angkatan: " + txtAngkatan.getText() + "\n";
        hasil += "DPA: " + txtDPA.getText() + "\n";
        hasil += "Semester: " + txtSemester.getText() + "\n";
        
        txtHasil.setText(hasil); // Set the result to the JTextArea
    }

    public static void main(String[] args) {
        // Create and display the register form
        new BP1_M4_P2_Rizal_Register();
    }
}