/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Transaksi;

/**
 *
 * @author Muhammad Rizal Nur F
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TransaksiPembelianPulsa {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        try {
            System.out.println("=== Transaksi Pembelian Pulsa ===");
            
            // Input nomor telepon
            System.out.print("Masukkan Nomor Telepon: ");
            String nomorTelepon = reader.readLine();
            
            // Input nominal pulsa
            System.out.print("Masukkan Nominal Pulsa (contoh: 10000, 50000, 100000): ");
            String nominalInput = reader.readLine();
            int nominalPulsa = Integer.parseInt(nominalInput);
            
            // Input metode pembayaran
            System.out.print("Masukkan Metode Pembayaran (contoh: Bank Transfer, OVO, GoPay): ");
            String metodePembayaran = reader.readLine();
            
            // Cetak hasil transaksi
            System.out.println("\n=== Bukti Transaksi Pembelian Pulsa ===");
            System.out.println("Nomor Telepon: " + nomorTelepon);
            System.out.println("Nominal Pulsa: Rp " + nominalPulsa);
            System.out.println("Metode Pembayaran: " + metodePembayaran);
            System.out.println("Status Transaksi: Berhasil");

        } catch (IOException | NumberFormatException e) {
            System.out.println("Terjadi kesalahan input: " + e.getMessage());
        }
    }
}
