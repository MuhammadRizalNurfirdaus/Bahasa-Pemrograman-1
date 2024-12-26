/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bp1_m9_rizal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import javax.swing.JFileChooser;


/**
 *
 * @author Muhammad Rizal Nur F
 */
public class BP1_M9_P1_Rizal extends javax.swing.JFrame {
    Statement st;
    ResultSet rs;
    koneksi koneksi;

    public BP1_M9_P1_Rizal() {
        koneksi = new koneksi();
        initComponents();
        load_data();
    }

    private void load_data() {
        Object header[] = {"NIM", "NAMA", "JENIS KELAMIN", "PRODI", "KELAS", "NILAI", "PHOTO"};
        DefaultTableModel data = new DefaultTableModel(null, header);
        jTable1.setModel(data);
        String sql = "SELECT nim, nama, jk, prodi, kelas, nilai, photo FROM tabel_mahasiswa";
        try {
            st = koneksi.con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                String k1 = rs.getString("nim");
                String k2 = rs.getString("nama");
                String k3 = rs.getString("jk");
                String k4 = rs.getString("prodi");
                String k5 = rs.getString("kelas");
                String k6 = rs.getString("nilai");
                String k7 = rs.getString("photo");

                String k[] = {k1, k2, k3, k4, k5, k6, k7};
                data.addRow(k);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

  public void input_data() {
    try {
        if (jTextField1.getText().isEmpty() || jTextField2.getText().isEmpty() ||
            (!jRadioButton1.isSelected() && !jRadioButton2.isSelected()) || 
            jTextFieldKelas.getText().isEmpty() || jTextFieldNilai.getText().isEmpty() ||
            jTextFieldPath.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Semua Data Harus Diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String jk = jRadioButton1.isSelected() ? jRadioButton1.getText() : jRadioButton2.getText();
        int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menyimpan data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            String sql = "INSERT INTO tabel_mahasiswa (nim, nama, jk, prodi, kelas, nilai, photo) VALUES ('"
                    + jTextField1.getText() + "', '"
                    + jTextField2.getText() + "', '"
                    + jk + "', '"
                    + jComboBox1.getSelectedItem().toString() + "', '"
                    + jTextFieldKelas.getText() + "', '"
                    + jTextFieldNilai.getText() + "', '"
                    + jTextFieldPath.getText() + "')";
            st = koneksi.con.createStatement();
            st.execute(sql);
            JOptionPane.showMessageDialog(null, "Data Mahasiswa Berhasil Disimpan");
            load_data();
            reset_form();
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
}


   private void reset_form() {
    jTextField1.setText("");
    jTextField2.setText("");
    jRadioButton1.setSelected(false);
    jRadioButton2.setSelected(false);
    jComboBox1.setSelectedIndex(0);
    jTextFieldKelas.setText("");
    jTextFieldNilai.setText("");
    jTextFieldPath.setText("");
}



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jComboBox1 = new javax.swing.JComboBox();
        ButtonSimpan = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextFieldKelas = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldNilai = new javax.swing.JTextField();
        jFileChooser1 = new javax.swing.JFileChooser();
        ButtonPilihFoto = new javax.swing.JButton();
        jTextFieldPath = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("DATA MAHASISWA");

        jLabel2.setText("FORM INPUT DATA ");

        jLabel3.setText("DATA MAHASISWA");

        jLabel4.setText("NIM");

        jLabel5.setText("NAMA");

        jLabel6.setText("JENIS KELAMIN");

        jLabel7.setText("PRODI");

        jLabel8.setText("PHOTO");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jRadioButton1.setText("L");

        jRadioButton2.setText("p");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TI", "SI", "DKV", "MI", "TS" }));

        ButtonSimpan.setText("SIMPAN");
        ButtonSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSimpanActionPerformed(evt);
            }
        });

        jButton2.setText("EDIT");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jButton3.setText("HAPUS");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jTextFieldKelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldKelasActionPerformed(evt);
            }
        });

        jLabel9.setText("KELAS");

        jLabel10.setText("NILAI");

        jFileChooser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileChooser1ActionPerformed(evt);
            }
        });

        ButtonPilihFoto.setText("ButtonPilihFoto");
        ButtonPilihFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonPilihFotoActionPerformed(evt);
            }
        });

        jTextFieldPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPathActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(422, 422, 422))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(ButtonPilihFoto))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(102, 102, 102)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jFileChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(ButtonSimpan)
                                            .addGap(38, 38, 38)
                                            .addComponent(jButton2)
                                            .addGap(18, 18, 18)
                                            .addComponent(jButton3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE))))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel8)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jTextFieldPath, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel4)
                                                .addComponent(jLabel5)
                                                .addComponent(jLabel6)
                                                .addComponent(jLabel10)
                                                .addComponent(jLabel9)
                                                .addComponent(jLabel7))
                                            .addGap(38, 38, 38)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel2)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jRadioButton1)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(jRadioButton2))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
                                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jTextFieldNilai, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jTextFieldKelas, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(155, 155, 155)
                                .addComponent(jLabel3)
                                .addGap(188, 188, 188))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldKelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jTextFieldNilai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jTextFieldPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ButtonPilihFoto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(ButtonSimpan)
                            .addComponent(jButton3))))
                .addGap(118, 314, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void ButtonSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSimpanActionPerformed
        // TODO add your handling code here:
        input_data();
    }//GEN-LAST:event_ButtonSimpanActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        // Button Edit                                     
    try {
        int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin mengedit data?", "Konfirmasi Edit", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            String jk = jRadioButton1.isSelected() ? jRadioButton1.getText() : jRadioButton2.getText();

            // Proses upload gambar jika file baru dipilih
            String photoName = "";
            if (jFileChooser1.getSelectedFile() != null) {
                File selectedFile = jFileChooser1.getSelectedFile();
                photoName = jTextField1.getText() + "_" + selectedFile.getName();
                File destinationFile = new File("resources/images/" + photoName);

                // Buat folder jika belum ada
                destinationFile.getParentFile().mkdirs();

                // Copy file ke folder tujuan
                Files.copy(selectedFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            }

            // Update data di database
            String sql_edit = "UPDATE tabel_mahasiswa SET nama = '"
                    + jTextField2.getText()
                    + "', jk = '" + jk
                    + "', prodi = '" + jComboBox1.getSelectedItem().toString()
                    + "', kelas = '" + jTextFieldKelas.getText()
                    + "', nilai = '" + jTextFieldNilai.getText() + "'";
            if (!photoName.isEmpty()) {
                sql_edit += ", photo = '" + photoName + "'";
            }
            sql_edit += " WHERE nim = '" + jTextField1.getText() + "'";
            st.executeUpdate(sql_edit);

            JOptionPane.showMessageDialog(null, "Data Mahasiswa Berhasil Diupdate");

            // Muat ulang data di tabel dan reset form
            load_data();
            reset_form();
        }
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Error saat mengunggah file: " + e.getMessage());
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }


    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
        // Button Hapus                                
    try {
        int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus data?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            String sql_delete = "DELETE FROM tabel_mahasiswa WHERE nim = '" + jTextField1.getText() + "'";
            st.executeUpdate(sql_delete);
            JOptionPane.showMessageDialog(null, "Data Mahasiswa Berhasil Dihapus");

            // Muat ulang data di tabel dan reset form
            load_data();
            reset_form();
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
    }//GEN-LAST:event_jButton3MouseClicked

    private void jTextFieldKelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldKelasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldKelasActionPerformed

    private void jFileChooser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFileChooser1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFileChooser1ActionPerformed

    private void ButtonPilihFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonPilihFotoActionPerformed
        // TODO add your handling code here:
JFileChooser fileChooser = new JFileChooser();
fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY); // Tidak ada "1" di JFileChooser
int result = fileChooser.showOpenDialog(this);

if (result == JFileChooser.APPROVE_OPTION) { // Tidak ada "1" di JFileChooser
    File selectedFile = fileChooser.getSelectedFile();
    jTextFieldPath.setText(selectedFile.getAbsolutePath());
}

    }//GEN-LAST:event_ButtonPilihFotoActionPerformed

    private void jTextFieldPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPathActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BP1_M6_P1_Rizal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BP1_M6_P1_Rizal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BP1_M6_P1_Rizal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BP1_M6_P1_Rizal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BP1_M9_P1_Rizal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonPilihFoto;
    private javax.swing.JButton ButtonSimpan;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextFieldKelas;
    private javax.swing.JTextField jTextFieldNilai;
    private javax.swing.JTextField jTextFieldPath;
    // End of variables declaration//GEN-END:variables
}
