package manajemenproduk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

public class StackProduk {

    private Stack<Produk> stackProduk = new Stack<>();

    public void tambahProduk(Produk produk) {

        stackProduk.push(produk);

        System.out.println(
                "Produk ditambahkan : "
                + produk.getNama()
        );

    }

    public Produk hapusProduk() {

        if (stackProduk.isEmpty()) {

            throw new RuntimeException(
                    "Stack produk kosong!"
            );

        }

        Produk p = stackProduk.pop();

        System.out.println(
                "Produk dihapus : "
                + p.getNama()
        );

        return p;
    }

    public Stack<Produk> getSemuaProduk() {
        return stackProduk;
    }

    public Produk cariProduk(String nama) {

        for (Produk p : stackProduk) {

            if (p.getNama()
                    .equalsIgnoreCase(nama)) {

                return p;

            }

        }

        return null;
    }

    public ArrayList<Produk> sortHarga() {

        ArrayList<Produk> list =
                new ArrayList<>(stackProduk);

        Collections.sort(
                list,
                new Comparator<Produk>() {

            @Override
            public int compare(
                    Produk o1,
                    Produk o2) {

                return Integer.compare(
                        o1.getHarga(),
                        o2.getHarga()
                );

            }

        });

        return list;
    }

    public ArrayList<Produk> sortKategori() {

        ArrayList<Produk> list =
                new ArrayList<>(stackProduk);

        Collections.sort(
                list,
                new Comparator<Produk>() {

            @Override
            public int compare(
                    Produk o1,
                    Produk o2) {

                return o1.getKategori()
                        .compareToIgnoreCase(
                                o2.getKategori()
                        );

            }

        });

        return list;
    }

}