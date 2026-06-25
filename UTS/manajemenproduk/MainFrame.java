package manajemenproduk;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class MainFrame extends JFrame {

    JTextField txtNama;
    JTextField txtKategori;
    JTextField txtHarga;
    JTextField txtStok;
    JTextField txtCari;

    JTable table;
    DefaultTableModel model;

    StackProduk stackProduk =
            new StackProduk();

    public MainFrame() {

        setTitle("Manajemen Produk");

        setSize(900, 550);

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JPanel panelInput =
                new JPanel(
                        new GridLayout(6, 2, 10, 10)
                );

        txtNama = new JTextField();
        txtKategori = new JTextField();
        txtHarga = new JTextField();
        txtStok = new JTextField();
        txtCari = new JTextField();

        panelInput.add(new JLabel("Nama"));
        panelInput.add(txtNama);

        panelInput.add(new JLabel("Kategori"));
        panelInput.add(txtKategori);

        panelInput.add(new JLabel("Harga"));
        panelInput.add(txtHarga);

        panelInput.add(new JLabel("Stok"));
        panelInput.add(txtStok);

        panelInput.add(new JLabel("Cari"));
        panelInput.add(txtCari);

        add(panelInput, BorderLayout.NORTH);

        model = new DefaultTableModel();

        model.addColumn("Nama");
        model.addColumn("Kategori");
        model.addColumn("Harga");
        model.addColumn("Stok");

        table = new JTable(model);

        JScrollPane scroll =
                new JScrollPane(table);

        add(scroll, BorderLayout.CENTER);

        JPanel panelButton =
                new JPanel();

        JButton btnTambah =
                new JButton("Tambah");

        JButton btnHapus =
                new JButton("Hapus");

        JButton btnCari =
                new JButton("Cari");

        JButton btnSortHarga =
                new JButton("Sort Harga");

        JButton btnSortKategori =
                new JButton("Sort Kategori");

        JButton btnRefresh =
                new JButton("Refresh");

        panelButton.add(btnTambah);
        panelButton.add(btnHapus);
        panelButton.add(btnCari);
        panelButton.add(btnSortHarga);
        panelButton.add(btnSortKategori);
        panelButton.add(btnRefresh);

        add(panelButton, BorderLayout.SOUTH);

        btnTambah.addActionListener(e -> {

            try {

                String nama =
                        txtNama.getText();

                String kategori =
                        txtKategori.getText();

                int harga =
                        Integer.parseInt(
                                txtHarga.getText()
                        );

                int stok =
                        Integer.parseInt(
                                txtStok.getText()
                        );

                Produk produk =
                        new Produk(
                                nama,
                                kategori,
                                harga,
                                stok
                        );

                stackProduk.tambahProduk(
                        produk
                );

                tampilData();

                clearForm();

                JOptionPane.showMessageDialog(
                        this,
                        "Produk berhasil ditambahkan"
                );

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "Harga dan stok harus angka!"
                );

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        this,
                        ex.getMessage()
                );

            }

        });

        btnHapus.addActionListener(e -> {

            try {

                Produk p =
                        stackProduk.hapusProduk();

                tampilData();

                JOptionPane.showMessageDialog(
                        this,
                        "Produk dihapus : "
                        + p.getNama()
                );

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        this,
                        ex.getMessage()
                );

            }

        });

        btnCari.addActionListener(e -> {

            String keyword =
                    txtCari.getText();

            Produk p =
                    stackProduk.cariProduk(
                            keyword
                    );

            if (p != null) {

                JOptionPane.showMessageDialog(
                        this,
                        "Nama : "
                        + p.getNama()
                        + "\nKategori : "
                        + p.getKategori()
                        + "\nHarga : "
                        + p.getHarga()
                        + "\nStok : "
                        + p.getStok()
                );

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Produk tidak ditemukan"
                );

            }

        });

        btnSortHarga.addActionListener(e -> {

            ArrayList<Produk> list =
                    stackProduk.sortHarga();

            tampilDataList(list);

        });

        btnSortKategori.addActionListener(e -> {

            ArrayList<Produk> list =
                    stackProduk.sortKategori();

            tampilDataList(list);

        });

        btnRefresh.addActionListener(e -> {

            tampilData();

        });

    }

    void tampilData() {

        model.setRowCount(0);

        for (Produk p :
                stackProduk.getSemuaProduk()) {

            Object[] row = {

                p.getNama(),
                p.getKategori(),
                p.getHarga(),
                p.getStok()

            };

            model.addRow(row);

        }

    }

    void tampilDataList(
            ArrayList<Produk> list) {

        model.setRowCount(0);

        for (Produk p : list) {

            Object[] row = {

                p.getNama(),
                p.getKategori(),
                p.getHarga(),
                p.getStok()

            };

            model.addRow(row);

        }

    }

    void clearForm() {

        txtNama.setText("");
        txtKategori.setText("");
        txtHarga.setText("");
        txtStok.setText("");

    }

}