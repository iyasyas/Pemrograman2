package pertemuan2;

public class HitungNilai {

    public void proses(Mahasiswa mhs) {
        double rata = (mhs.getUts() + mhs.getUas()) / 2;
        mhs.setNilaiAkhir(rata);

        if (rata < 50)
            mhs.setGrade("E");
        else if (rata < 60)
            mhs.setGrade("D");
        else if (rata < 70)
            mhs.setGrade("C");
        else if (rata < 80)
            mhs.setGrade("B");
        else
            mhs.setGrade("A");
    }
}