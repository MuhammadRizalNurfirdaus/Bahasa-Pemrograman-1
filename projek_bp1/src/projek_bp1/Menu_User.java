/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projek_bp1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Menu_User extends javax.swing.JFrame {

    Statement st;
    ResultSet rs;
    Connection con;
    koneksi koneksi;

    private int hargaPerMalam = 0;

    public Menu_User() {
        koneksi = new koneksi();
        initComponents();
        load_data();
        load_data1();

        // Menambahkan listener untuk comboBox dan spinner
        jComboBox1.addItemListener(evt -> handleComboBoxSelection(evt));
        jSpinner1.addChangeListener(evt -> handleSpinnerChange(evt));
    }

    private void load_data() {
        String sql = "SELECT nama, umur, jk, nohp, alamat, tanggal, pilih_kamar, lama_menginap, harga FROM data_pemesan";
        try {
            con = koneksi.con;
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                String[] k = {
                    rs.getString("nama"),
                    rs.getString("umur"),
                    rs.getString("jk"),
                    rs.getString("nohp"),
                    rs.getString("alamat"),
                    rs.getString("tanggal"),
                    rs.getString("pilih_kamar"),
                    rs.getString("lama_menginap"),
                    rs.getString("harga")
                };
                // Proses data k jika diperlukan
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void input_data() {
        try {
            // Validasi input
            if (jTextField1.getText().isEmpty() ||
                jTextField2.getText().isEmpty() ||
                (!jRadioButton1.isSelected() && !jRadioButton2.isSelected()) ||
                jTextField3.getText().isEmpty() ||
                jTextArea1.getText().isEmpty() ||
                jComboBox1.getSelectedIndex() == 0 ||
                (int) jSpinner1.getValue() <= 0) {

                JOptionPane.showMessageDialog(null, "Semua data harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String jk = jRadioButton1.isSelected() ? "L" : "P";
            int jumlahHari = (int) jSpinner1.getValue();
            int totalHarga = jumlahHari * hargaPerMalam;

            int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menyimpan data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                String sql = "INSERT INTO data_pemesan (nama, umur, jk, nohp, alamat, tanggal, pilih_kamar, lama_menginap, harga) " +
                             "VALUES ('" + jTextField1.getText() + "', '" + jTextField2.getText() + "', '" + jk + "', '" + jTextField3.getText() + "', '" +
                             jTextArea1.getText() + "', '" + jTextField5.getText() + "', '" + jComboBox1.getSelectedItem().toString() + "', '" +
                             jumlahHari + "', '" + totalHarga + "')";
                st = con.createStatement();
                st.execute(sql);

                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");

                showReceipt(jTextField1.getText(), jk, jComboBox1.getSelectedItem().toString(), jumlahHari, totalHarga);
                reset_form();
                load_data();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    private void showReceipt(String nama, String jenisKelamin, String kamar, int lamaMenginap, int totalHarga) {
        StringBuilder struk = new StringBuilder();
        struk.append("=== STRUK PEMBELIAN ===\n");
        struk.append("Nama: ").append(nama).append("\n");
        struk.append("Jenis Kelamin: ").append(jenisKelamin).append("\n");
        struk.append("Jenis Kamar: ").append(kamar).append("\n");
        struk.append("Lama Menginap: ").append(lamaMenginap).append(" hari\n");
        struk.append("Total Harga: Rp. ").append(totalHarga).append("\n");
        struk.append("=======================\n");

        JOptionPane.showMessageDialog(this, struk.toString(), "Struk Pembelian", JOptionPane.INFORMATION_MESSAGE);
    }

    private void reset_form() {
        jTextField1.setText("");
        jTextField2.setText("");
        jRadioButton1.setSelected(false);
        jRadioButton2.setSelected(false);
        jTextField3.setText("");
        jTextArea1.setText("");
        jTextField5.setText("");
        jComboBox1.setSelectedIndex(0);
        jSpinner1.setValue(0);
        jTextField6.setText("");
    }

    private void handleComboBoxSelection(java.awt.event.ItemEvent evt) {
        if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
            String selectedKamar = jComboBox1.getSelectedItem().toString();
            switch (selectedKamar) {
                case "Standard":
                    hargaPerMalam = 1000000;
                    break;
                case "Family":
                    hargaPerMalam = 1500000;
                    break;
                case "Deluxe":
                    hargaPerMalam = 2000000;
                    break;
                default:
                    hargaPerMalam = 0;
                    break;
            }
            hitungTotalHarga();
        }
    }

    private void handleSpinnerChange(javax.swing.event.ChangeEvent evt) {
        hitungTotalHarga();
    }

    private void hitungTotalHarga() {
        int jumlahHari = (int) jSpinner1.getValue();
        if (jumlahHari < 0) {
            JOptionPane.showMessageDialog(this, "Jumlah hari tidak boleh negatif!");
            return;
        }
        int totalHarga = jumlahHari * hargaPerMalam;
        jTextField6.setText("Rp. " + totalHarga);
}
    private void load_data1() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nama");
        model.addColumn("Jenis");
        model.addColumn("Spesifikasi");
        model.addColumn("Harga");

        try {
            st = koneksi.con.createStatement();
            rs = st.executeQuery("SELECT * FROM kamar ORDER BY id ASC");

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("id"),
                    rs.getString("nama"),
                    rs.getString("jenis"),
                    rs.getString("spesifikasi"),
                    rs.getString("harga")
                });
            }
            jTable1.setModel(model);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
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
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField4 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setText("FORM PEMESANAN");

        jLabel2.setText("Masukan Biodata Anda Disini!");

        jLabel3.setText("Nama");

        jLabel4.setText("Umur");

        jLabel5.setText("Jenis Kelamin");

        jLabel6.setText("No HP");

        jLabel7.setText("Alamat");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jRadioButton1.setText("L");

        jRadioButton2.setText("P");

        jLabel8.setText("Tahun");

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setText("Simpan");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Batal");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel9.setText("Pencarian lewat ID");

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

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField4KeyReleased(evt);
            }
        });

        jLabel10.setText("Tanggal");

        jLabel11.setText("Pilih Kamar");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Standard", "Family", "Deluxe" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jLabel12.setText("Berapa Lama Menginap");

        jSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner1StateChanged(evt);
            }
        });

        jLabel13.setText("Hari");

        jLabel14.setText("Harga");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(222, 222, 222)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel4)
                        .addComponent(jLabel3)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel14))))
                .addGap(188, 188, 188)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jRadioButton1)
                                    .addGap(33, 33, 33)
                                    .addComponent(jRadioButton2))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel8))
                                .addComponent(jTextField3)
                                .addComponent(jTextField1)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                                .addComponent(jTextField5)
                                .addComponent(jTextField6))
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(67, 67, 67)
                                .addComponent(jButton2))
                            .addComponent(jLabel9)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(528, 528, 528))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel9)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton2))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(jLabel7))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(56, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        input_data();
            this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         int confirm = JOptionPane.showConfirmDialog(
        this, 
        "Apakah Anda yakin ingin Membatalkan dan Keluar?", 
        "Konfirmasi", 
        JOptionPane.YES_NO_OPTION
    );
    if (confirm == JOptionPane.YES_OPTION) {
        this.dispose();
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:
         if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
        String pilihan = (String) jComboBox1.getSelectedItem();
        switch (pilihan) {
            case "Standard":
                hargaPerMalam = 1000000;
                break;
            case "Family":
                hargaPerMalam = 1500000;
                break;
            case "Deluxe":
                hargaPerMalam = 2000000;
                break;
            default:
                hargaPerMalam = 0;
                break;
        }
        // Hitung total harga baru
        hitungTotalHarga();
    }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jSpinner1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner1StateChanged
        // TODO add your handling code here:
         // Cek apakah item yang dipilih benar-benar berubah (diselect)
   String pilihan = jComboBox1.getSelectedItem().toString();

    // Tentukan harga per malam berdasarkan pilihan kamar
    switch (pilihan) {
        case "Standard":
            hargaPerMalam = 1000000;
            break;
        case "Family":
            hargaPerMalam = 1500000;
            break;
        case "Deluxe":
            hargaPerMalam = 2000000;
            break;
        default:
            hargaPerMalam = 0; // Jika tidak ada pilihan valid
            break;
    }

    // Hitung total harga baru
    hitungTotalHarga();
    }//GEN-LAST:event_jSpinner1StateChanged

    private void jTextField4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyReleased
        // TODO add your handling code here:
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nama");
        model.addColumn("Jenis");
        model.addColumn("Spesifikasi");
        model.addColumn("Harga");

        String cariID = jTextField4.getText();

        try {
            st = koneksi.con.createStatement();
            String query = "SELECT * FROM kamar WHERE id LIKE '%" + cariID + "%'";
            rs = st.executeQuery(query);

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("id"),
                    rs.getString("nama"),
                    rs.getString("jenis"),
                    rs.getString("spesifikasi"),
                    rs.getString("harga")
                });
            }
            jTable1.setModel(model);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_jTextField4KeyReleased

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

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
            java.util.logging.Logger.getLogger(Menu_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_User().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
