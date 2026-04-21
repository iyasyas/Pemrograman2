package Pert6;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MahasiswaDAO {

    public List<Mahasiswa> search(String keyword, String kategori) {
        List<Mahasiswa> list = new ArrayList<>();

        try {
            Connection conn = Koneksi.getConnection();

            String sql;

            if (keyword.isEmpty()) {
                sql = "SELECT * FROM datamhs";
            } else if (kategori.equals("Semua")) {
                sql = "SELECT * FROM datamhs WHERE " +
                        "nim LIKE ? OR nama LIKE ? OR semester LIKE ? OR kelas LIKE ?";
            } else {
                sql = "SELECT * FROM datamhs WHERE " + kategori.toLowerCase() + " LIKE ?";
            }

            PreparedStatement ps = conn.prepareStatement(sql);

            if (!keyword.isEmpty()) {
                String key = "%" + keyword + "%";

                if (kategori.equals("Semua")) {
                    ps.setString(1, key);
                    ps.setString(2, key);
                    ps.setString(3, key);
                    ps.setString(4, key);
                } else {
                    ps.setString(1, key);
                }
            }

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Mahasiswa(
                        rs.getString("nim"),
                        rs.getString("nama"),
                        rs.getString("semester"),
                        rs.getString("kelas")
                ));
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return list;
    }
}