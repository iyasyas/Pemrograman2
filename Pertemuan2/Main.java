package pertemuan2;

public class Main {
    public static void main(String[] args) {

        InputMahasiswa input = new InputMahasiswa();
        HitungNilai hitung = new HitungNilai();

        Mahasiswa mhs = input.inputData();
        hitung.proses(mhs);

        System.out.println("\n=================================");
        System.out.println("NIM\tNama\tRata\tGrade");
        System.out.println("=================================");
        System.out.println(mhs.getNim() + "\t" + mhs.getNama() + "\t" + mhs.getNilaiAkhir() + "\t" + mhs.getGrade());
    }
}