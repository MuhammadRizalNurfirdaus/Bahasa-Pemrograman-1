


import java.util.Scanner;

public class NilaiMahasiswa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input data mahasiswa
        System.out.print("Masukkan nama mahasiswa: ");
        String nama = scanner.nextLine();

        System.out.print("Masukkan NIM mahasiswa: ");
        String nim = scanner.nextLine();

        // Input nilai mata kuliah
        System.out.print("Masukkan jumlah mata kuliah: ");
        int jumlahMataKuliah = scanner.nextInt();
        double totalNilai = 0;

        for (int i = 1; i <= jumlahMataKuliah; i++) {
            System.out.print("Masukkan nilai untuk mata kuliah ke-" + i + ": ");
            double nilai = scanner.nextDouble();
            totalNilai += nilai;
        }

        // Hitung rata-rata
        double rataRata = totalNilai / jumlahMataKuliah;

        // Tampilkan data mahasiswa dan hasil perhitungan
        System.out.println("\nData Mahasiswa");
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);
        System.out.printf("Rata-rata nilai: %.2f\n", rataRata);

        scanner.close();
    }
}
