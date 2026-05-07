package manajemenproduk;

public class Produk {

    private String nama;
    private String kategori;
    private int harga;
    private int stok;

    public Produk(String nama, String kategori, int harga, int stok) {
        this.nama = nama;
        this.kategori = kategori;
        this.harga = harga;
        this.stok = stok;
    }

    public String getNama() {
        return nama;
    }

    public String getKategori() {
        return kategori;
    }

    public int getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

}