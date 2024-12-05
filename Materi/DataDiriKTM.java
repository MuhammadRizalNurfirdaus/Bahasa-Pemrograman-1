import javax.swing.JOptionPane;

public class DataDiriKTM {
    public static void main(String[] args) {
        // Input data diri menggunakan JOptionPane
        String nama = JOptionPane.showInputDialog("Masukkan Nama Anda:");
        String nim = JOptionPane.showInputDialog("Masukkan NIM Anda:");
        String jurusan = JOptionPane.showInputDialog("Masukkan Jurusan Anda:");
        String fakultas = JOptionPane.showInputDialog("Masukkan Fakultas Anda:");

        // Format output data diri
        String dataDiri = "Data Diri Mahasiswa:\n" +
                          "Nama     : " + nama + "\n" +
                          "NIM      : " + nim + "\n" +
                          "Jurusan  : " + jurusan + "\n" +
                          "Fakultas : " + fakultas;

        // Tampilkan data diri dalam JOptionPane
        JOptionPane.showMessageDialog(null, dataDiri, "Kartu Tanda Mahasiswa", JOptionPane.INFORMATION_MESSAGE);
    }
}
