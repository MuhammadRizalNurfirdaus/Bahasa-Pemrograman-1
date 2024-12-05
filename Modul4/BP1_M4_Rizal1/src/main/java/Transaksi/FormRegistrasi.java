/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Transaksi;

/**
 *
 * @author Muhammad Rizal Nur F
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormRegistrasi extends Frame implements ActionListener {
    // Komponen yang dibutuhkan untuk Form Registrasi
    Label lblTitle, lblNama, lblEmail, lblGender, lblHobi, lblCountry;
    TextField txtNama, txtEmail;
    Checkbox cbCoding, cbReading, cbGaming;
    CheckboxGroup genderGroup;
    Checkbox rbMale, rbFemale;
    Choice choiceCountry;
    Button btnSubmit, btnClear;

    public FormRegistrasi() {
        // Set layout form
        setLayout(new FlowLayout());
        
        // 1. Judul Form
        lblTitle = new Label("Form Registrasi");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
        add(lblTitle);

        // 2. Nama
        lblNama = new Label("Nama:");
        txtNama = new TextField(20);
        add(lblNama);
        add(txtNama);

        // 3. Email
        lblEmail = new Label("Email:");
        txtEmail = new TextField(20);
        add(lblEmail);
        add(txtEmail);

        // 4. Gender (CheckboxGroup untuk pilihan tunggal)
        lblGender = new Label("Gender:");
        genderGroup = new CheckboxGroup();
        rbMale = new Checkbox("Laki-laki", genderGroup, false);
        rbFemale = new Checkbox("Perempuan", genderGroup, false);
        add(lblGender);
        add(rbMale);
        add(rbFemale);

        // 5. Hobi (Checkbox untuk pilihan ganda)
        lblHobi = new Label("Hobi:");
        cbCoding = new Checkbox("Coding");
        cbReading = new Checkbox("Reading");
        cbGaming = new Checkbox("Gaming");
        add(lblHobi);
        add(cbCoding);
        add(cbReading);
        add(cbGaming);

        // 6. Negara (Choice untuk dropdown menu)
        lblCountry = new Label("Negara:");
        choiceCountry = new Choice();
        choiceCountry.add("Pilih Negara");
        choiceCountry.add("Indonesia");
        choiceCountry.add("Malaysia");
        choiceCountry.add("Singapura");
        add(lblCountry);
        add(choiceCountry);

        // 7. Tombol Submit dan Clear
        btnSubmit = new Button("Submit");
        btnClear = new Button("Clear");
        add(btnSubmit);
        add(btnClear);

        // Menambahkan ActionListener untuk tombol
        btnSubmit.addActionListener(this);
        btnClear.addActionListener(this);

        // Pengaturan Frame
        setTitle("Form Registrasi");
        setSize(300, 400);
        setVisible(true);
    }

    // ActionEvent untuk Tombol Submit dan Clear
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSubmit) {
            System.out.println("Data telah disubmit.");
        } else if (e.getSource() == btnClear) {
            txtNama.setText("");
            txtEmail.setText("");
            genderGroup.setSelectedCheckbox(null);
            cbCoding.setState(false);
            cbReading.setState(false);
            cbGaming.setState(false);
            choiceCountry.select(0);
        }
    }

    public static void main(String[] args) {
        new FormRegistrasi();
    }
}
