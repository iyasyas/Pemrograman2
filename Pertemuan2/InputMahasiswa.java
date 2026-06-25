package pertemuan2;

import java.util.Scanner;

public class InputMahasiswa {
    Scanner input = new Scanner(System.in);

    public Mahasiswa inputData() {
        Mahasiswa mhs = new Mahasiswa();

        System.out.print("NIM: ");
        mhs.setNim(input.next());

        input.nextLine(); // FIX buffer

        System.out.print("Nama: ");
        mhs.setNama(input.nextLine());

        System.out.print("UTS: ");
        mhs.setUts(input.nextFloat());

        System.out.print("UAS: ");
        mhs.setUas(input.nextFloat());

        return mhs;
    }
}