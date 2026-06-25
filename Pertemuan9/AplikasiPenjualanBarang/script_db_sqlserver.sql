CREATE DATABASE IF NOT EXISTS db_penjualan;
USE db_penjualan;

DROP TABLE IF EXISTS detail_transaksi;
DROP TABLE IF EXISTS inventory;
DROP TABLE IF EXISTS transaksi;
DROP TABLE IF EXISTS barang;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS supplier;

CREATE TABLE barang (
    kd_barang VARCHAR(10) NOT NULL,
    nm_barang VARCHAR(50),
    harga DOUBLE,
    stok INT,
    PRIMARY KEY (kd_barang)
);

CREATE TABLE customer (
    kd_customer VARCHAR(10) NOT NULL,
    nm_customer VARCHAR(50),
    alamat VARCHAR(100),
    telp VARCHAR(15),
    PRIMARY KEY (kd_customer)
);

CREATE TABLE supplier (
    kd_supplier VARCHAR(10) NOT NULL,
    nm_supplier VARCHAR(50),
    alamat VARCHAR(100),
    telp VARCHAR(15),
    PRIMARY KEY (kd_supplier)
);

CREATE TABLE transaksi (
    no_transaksi VARCHAR(15) NOT NULL,
    kd_customer VARCHAR(10),
    tgl_transaksi DATE,
    total DOUBLE,
    PRIMARY KEY (no_transaksi),
    FOREIGN KEY (kd_customer)
        REFERENCES customer(kd_customer)
);

CREATE TABLE detail_transaksi (
    id_detail INT AUTO_INCREMENT,
    no_transaksi VARCHAR(15),
    kd_barang VARCHAR(10),
    qty INT,
    subtotal DOUBLE,
    PRIMARY KEY (id_detail),
    FOREIGN KEY (no_transaksi)
        REFERENCES transaksi(no_transaksi),
    FOREIGN KEY (kd_barang)
        REFERENCES barang(kd_barang)
);

CREATE TABLE inventory (
    id_inventory INT AUTO_INCREMENT,
    kd_barang VARCHAR(10),
    kd_supplier VARCHAR(10),
    tgl_masuk DATE,
    qty_masuk INT,
    PRIMARY KEY (id_inventory),
    FOREIGN KEY (kd_barang)
        REFERENCES barang(kd_barang),
    FOREIGN KEY (kd_supplier)
        REFERENCES supplier(kd_supplier)
);

INSERT INTO barang VALUES
('B001', 'Pensil 2B', 3000, 100),
('B002', 'Buku Tulis', 5000, 200);

INSERT INTO customer VALUES
('C001', 'Andi', 'Jakarta', '08123456789');

INSERT INTO supplier VALUES
('S001', 'PT Alat Tulis', 'Bandung', '0227654321');