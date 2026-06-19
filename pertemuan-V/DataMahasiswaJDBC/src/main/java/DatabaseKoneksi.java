import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseKoneksi {

    private Connection koneksi;

    public Connection getKoneksi() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/mhs";

            koneksi = DriverManager.getConnection(
                    url,
                    "root",
                    ""
            );

            System.out.println("Koneksi berhasil!");

        } catch (ClassNotFoundException e) {
            System.out.println("Driver MySQL tidak ditemukan!");
            System.out.println(e.getMessage());

        } catch (SQLException e) {
            System.out.println("Koneksi gagal!");
            System.out.println(e.getMessage());
        }

        return koneksi;
    }
}