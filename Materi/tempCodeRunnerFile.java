// File: DataMahasiswa.java
public class DataMahasiswa {
    private String nama;
    private int umur;

    public DataMahasiswa(String nama, int umur) {
        this.nama = nama;
        this.umur = umur;
    }

    public void tampilkanInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("Umur: " + umur);
    }
}
