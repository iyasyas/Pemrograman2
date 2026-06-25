package pertemuan2;

public class Mahasiswa {

    private String nim, nama, grade;
    private float uts, uas;
    private double nilaiakhir;

    public String getNim() { return nim; }
    public void setNim(String nim) { this.nim = nim; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public float getUts() { return uts; }
    public void setUts(float uts) { this.uts = uts; }

    public float getUas() { return uas; }
    public void setUas(float uas) { this.uas = uas; }

    public double getNilaiAkhir() { return nilaiakhir; }
    public void setNilaiAkhir(double nilaiakhir) { this.nilaiakhir = nilaiakhir; }

    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }
}