package com.unpam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseKoneksi {

    public Connection getKoneksi() {

        Connection koneksi = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/mhs";
            String user = "root";
            String password = "";

            koneksi = DriverManager.getConnection(
                    url,
                    user,
                    password
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