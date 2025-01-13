import javax.swing.*;

public class AplikasiSwingSederhana extends JFrame {

    public AplikasiSwingSederhana() {
        // Atur judul jendela
        setTitle("Contoh Swing dengan Menu");

        // Atur ukuran dan operasi tutup default
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Membuat menu bar
        JMenuBar menuBar = new JMenuBar();

        // Membuat menu
        JMenu menuFile = new JMenu("File");
        JMenu menuEdit = new JMenu("Edit");

        // Membuat item menu
        JMenuItem itemBuka = new JMenuItem("Buka");
        JMenuItem itemSimpan = new JMenuItem("Simpan");
        JMenuItem itemKeluar = new JMenuItem("Keluar");

        // Menambahkan item ke dalam menu File
        menuFile.add(itemBuka);
        menuFile.add(itemSimpan);
        menuFile.addSeparator(); // Menambahkan garis pemisah
        menuFile.add(itemKeluar);

        // Menambahkan menu ke menu bar
        menuBar.add(menuFile);
        menuBar.add(menuEdit);

        // Mengatur menu bar ke dalam frame
        setJMenuBar(menuBar);

        // Tambahkan aksi untuk item menu Keluar
        itemKeluar.addActionListener(e -> System.exit(0));

        // Menambahkan container sederhana (JPanel) dengan label
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Selamat datang di Aplikasi Swing Sederhana!");
        panel.add(label);

        // Menambahkan panel ke dalam frame
        add(panel);

        // Menampilkan jendela
        setVisible(true);
    }

    public static void main(String[] args) {
        // Jalankan aplikasi
        new AplikasiSwingSederhana();
    }
}
