import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormPemesananRizalCell extends JFrame {

    public FormPemesananRizalCell() {
        setTitle("Form Pemesanan Online - Rizal Cell");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel untuk form
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));

        // Label dan input nama
        panel.add(new JLabel("Nama:"));
        JTextField namaField = new JTextField();
        panel.add(namaField);

        // Label dan input alamat
        panel.add(new JLabel("Alamat:"));
        JTextField alamatField = new JTextField();
        panel.add(alamatField);

        // Label dan pilihan item
        panel.add(new JLabel("Produk yang dipesan:"));
        String[] items = {"Handphone", "Charger", "Headset", "Power Bank"};
        JComboBox<String> itemComboBox = new JComboBox<>(items);
        panel.add(itemComboBox);

        // Label dan input jumlah
        panel.add(new JLabel("Jumlah:"));
        JSpinner jumlahSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
        panel.add(jumlahSpinner);

        // Tombol Pesan
        JButton pesanButton = new JButton("Pesan Sekarang");
        panel.add(pesanButton);

        // Area hasil
        JTextArea hasilArea = new JTextArea(5, 20);
        hasilArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(hasilArea);
        
        // Menambahkan listener untuk tombol pesan
        pesanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = namaField.getText();
                String alamat = alamatField.getText();
                String item = (String) itemComboBox.getSelectedItem();
                int jumlah = (int) jumlahSpinner.getValue();

                String hasilPesan = "Terima kasih, " + nama + "!\n"
                        + "Pesanan Anda di Rizal Cell:\n"
                        + "- Produk: " + item + "\n"
                        + "- Jumlah: " + jumlah + "\n"
                        + "- Alamat: " + alamat + "\n"
                        + "Pesanan Anda sedang diproses.";
                hasilArea.setText(hasilPesan);
            }
        });

        // Menambahkan panel dan area hasil ke frame
        add(panel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FormPemesananRizalCell form = new FormPemesananRizalCell();
            form.setVisible(true);
        });
    }
}
