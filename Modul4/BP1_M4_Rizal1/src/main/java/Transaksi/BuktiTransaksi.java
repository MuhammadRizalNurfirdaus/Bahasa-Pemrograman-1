/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Transaksi;

/**
 *
 * @author Muhammad Rizal Nur F
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuktiTransaksi extends JFrame {
    public BuktiTransaksi() {
        setTitle("Bukti Transaksi Pemesanan Online");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Panel utama
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        
        // Panel atas untuk informasi umum
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(5, 2, 10, 10));
        
        JLabel orderNoLabel = new JLabel("Nomor Pesanan:");
        JTextField orderNoField = new JTextField("12345");
        orderNoField.setEditable(false);
        
        JLabel dateLabel = new JLabel("Tanggal:");
        JTextField dateField = new JTextField("13/11/2024");
        dateField.setEditable(false);
        
        JLabel customerNameLabel = new JLabel("Nama Pelanggan:");
        JTextField customerNameField = new JTextField("Rizal");
        customerNameField.setEditable(false);
        
        JLabel totalLabel = new JLabel("Total Harga:");
        JTextField totalField = new JTextField("Rp 500,000");
        totalField.setEditable(false);

        // Tambah ke panel informasi
        infoPanel.add(orderNoLabel);
        infoPanel.add(orderNoField);
        infoPanel.add(dateLabel);
        infoPanel.add(dateField);
        infoPanel.add(customerNameLabel);
        infoPanel.add(customerNameField);
        infoPanel.add(totalLabel);
        infoPanel.add(totalField);
        
        mainPanel.add(infoPanel, BorderLayout.NORTH);
        
        // Panel tabel untuk daftar item yang dipesan
        String[] columnNames = {"Nama Item", "Kuantitas", "Harga Satuan", "Total"};
        Object[][] data = {
            {"Item A", "2", "Rp 100,000", "Rp 200,000"},
            {"Item B", "1", "Rp 300,000", "Rp 300,000"},
        };
        
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        JTable itemTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(itemTable);
        
        mainPanel.add(tableScrollPane, BorderLayout.CENTER);
        
        // Panel bawah untuk tombol
        JPanel buttonPanel = new JPanel();
        JButton printButton = new JButton("Cetak");
        JButton closeButton = new JButton("Keluar");
        
        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Transaksi berhasil dicetak.");
            }
        });
        
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        buttonPanel.add(printButton);
        buttonPanel.add(closeButton);
        
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        add(mainPanel);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new BuktiTransaksi().setVisible(true);
        });
    }
}
