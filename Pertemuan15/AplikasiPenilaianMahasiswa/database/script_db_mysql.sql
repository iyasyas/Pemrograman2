CREATE DATABASE IF NOT EXISTS dbaplikasipenilaianmahasiswa;
USE dbaplikasipenilaianmahasiswa;

CREATE TABLE IF NOT EXISTS tbmahasiswa (
    nim      VARCHAR(15) NOT NULL PRIMARY KEY,
    nama     VARCHAR(50),
    semester INT,
    kelas    VARCHAR(20),
    password VARCHAR(32)
);

CREATE TABLE IF NOT EXISTS tbmatakuliah (
    kode_mk  VARCHAR(10) NOT NULL PRIMARY KEY,
    nama_mk  VARCHAR(50),
    sks      INT
);

CREATE TABLE IF NOT EXISTS tbuser (
    username VARCHAR(30) NOT NULL PRIMARY KEY,
    password VARCHAR(32),
    nama     VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS tbnilai (
    id          INT AUTO_INCREMENT PRIMARY KEY,
    nim         VARCHAR(15),
    kode_mk     VARCHAR(10),
    nilai_tugas FLOAT,
    nilai_uts   FLOAT,
    nilai_uas   FLOAT,
    nilai_akhir FLOAT,
    grade       VARCHAR(2),
    CONSTRAINT fk_nilai_mhs FOREIGN KEY (nim)     REFERENCES tbmahasiswa(nim),
    CONSTRAINT fk_nilai_mk  FOREIGN KEY (kode_mk) REFERENCES tbmatakuliah(kode_mk)
);

INSERT INTO tbuser (username, password, nama)
SELECT * FROM (SELECT 'admin', MD5('admin'), 'Administrator') AS tmp
WHERE NOT EXISTS (
    SELECT username FROM tbuser WHERE username = 'admin'
) LIMIT 1;
