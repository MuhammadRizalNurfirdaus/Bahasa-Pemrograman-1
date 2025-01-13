/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import javax.swing.JOptionPane;
/**
 * 
 * @author Muhammad Rizal Nur F
 */
public class BP1_M4_P1_Rizal extends javax.swing.JFrame {

    public BP1_M4_P1_Rizal() {
        initComponents(); // Inisialisasi komponen yang ada di desain GUI
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        btnRegister = new javax.swing.JButton();
        jLabelImage = new javax.swing.JLabel();  // Label untuk gambar
        jLabel3 = new javax.swing.JLabel(); // Label untuk level
        comboLevel = new javax.swing.JComboBox<>(); // JComboBox untuk level
        txtAreaOutput = new javax.swing.JTextArea(); // JTextArea untuk menampilkan hasil inputan

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Username:");
        jLabel2.setText("Password:");
        jLabel3.setText("Level:");

        // Menambahkan pilihan level
        comboLevel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "User " }));

        btnLogin.setText("Login");
        btnLogin.addActionListener(evt -> btnLoginActionPerformed(evt));

        btnRegister.setText("Register");
        btnRegister.addActionListener(evt -> btnRegisterActionPerformed(evt));

        // Menambahkan gambar bayi
        try {
            jLabelImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bayi.jpg"))); // pastikan gambar ada di folder yang tepat
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "Gambar tidak ditemukan!", "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Mengatur JTextArea
        txtAreaOutput.setEditable(false); // Tidak bisa diedit oleh pengguna
        txtAreaOutput.setRows(5); // Jumlah baris
        txtAreaOutput.setColumns(20); // Jumlah kolom

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabelImage) // Menampilkan gambar bayi di kiri
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPassword))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRegister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(txtAreaOutput) // Menampilkan JTextArea di bawah
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelImage) // Gambar bayi di kiri
 .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(comboLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLogin)
                            .addComponent(btnRegister))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAreaOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE) // Ukuran JTextArea
                .addContainerGap(30, Short.MAX_VALUE)
        );

        pack();
    }

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {
        // Validasi login
        String username = txtUsername.getText().trim();
        String password = new String(txtPassword.getPassword()).trim();
        String level = (String) comboLevel.getSelectedItem(); // Mendapatkan level yang dipilih

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Username dan Password tidak boleh kosong!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validasi berdasarkan level
        if (level.equals("Admin") && username.equals("admin") && password.equals("admin123")) {
            JOptionPane.showMessageDialog(this, "Login Berhasil sebagai Admin!");
            // Tampilkan hasil inputan di JTextArea
            txtAreaOutput.setText("Username: " + username + "\nPassword: " + password + "\nLevel: " + level);
            // Pindah ke Form Data Nilai Mahasiswa jika login berhasil
            new FormDataNilaiMahasiswa().setVisible(true);
            this.dispose(); // Menutup form login setelah berpindah
        } else if (level.equals("User  ") && username.equals("user") && password.equals("user123")) {
            JOptionPane.showMessageDialog(this, "Login Berhasil sebagai User!");
            // Tampilkan hasil inputan di JTextArea
            txtAreaOutput.setText("Username: " + username + "\nPassword: " + password + "\nLevel: " + level);
            // Pindah ke Form User jika login berhasil
            new FormUser ().setVisible(true);
            this.dispose(); // Menutup form login setelah berpindah
        } else {
            JOptionPane.showMessageDialog(this, "Username atau Password salah!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {
        // Pindah ke Form Register
        new BP1_M4_P2_Rizal_Register().setVisible(true);
        this.dispose(); // Tutup form login setelah berpindah
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BP1_M4_P1_Rizal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new BP1_M4_P1_Rizal().setVisible(true));
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnRegister;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3; // Label untuk level
    private javax.swing.JTextField txtUsername;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JLabel jLabelImage;  // Label untuk gambar bayi
    private javax.swing.JComboBox<String> combo Level; // JComboBox untuk level
    private javax.swing.JTextArea txtAreaOutput; // JTextArea untuk menampilkan hasil inputan
    // End of variables declaration
}