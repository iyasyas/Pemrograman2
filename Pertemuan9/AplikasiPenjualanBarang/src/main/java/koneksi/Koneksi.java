package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;

public class Koneksi {

    private static Connection conn;

    public static Connection getConnection() {

        try {

            if (conn == null || conn.isClosed()) {

                Class.forName("com.mysql.cj.jdbc.Driver");

                String url = "jdbc:mysql://localhost:3306/db_penjualan";
                String user = "root";
                String password = "";

                conn = DriverManager.getConnection(
                        url,
                        user,
                        password
                );

                System.out.println("Koneksi berhasil");
            }

            return conn;

        } catch (Exception e) {

            System.out.println("Koneksi gagal");
            e.printStackTrace();

            return null;
        }
    }
}