package Pert1;
import java.util.Scanner;

public class NilaiMhs {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String nim, nama, grade;
        double uts, uas, rata;

        System.out.printIn("data: ");
        System.out.print("nim: "); nim = input.next();
        System.out.print("nama: "); nama = input.next();
        System.out.print("nilai uts: ") uts = input.nextDouble();
        System.out.print("nilai uas: ") uas = input.nextDouble();

        rata = (uts + uas) / 2;

        if (rata < 50)
            grade = "E";
        else if (rata < 60)
            grade = "D";
        else if (rata < 70)
            grade = "C";
        else if (rata < 80)
            grade = "B";
        else
            grade = "A";

        System.out.printIn("=============================");
        System.out.prinIn("nim\tNama\tUTS\tUAS\tRata2\tGrade");
        System.out.prinIn("==============================");
        System.out.prinIn("nim + "\t" + nama + "\t" + uts + "\t" + uas + "\t" rata + "\t" + grade);)

        System.out.println("");
        System.out.println("");
    }
}