CREATE DATABASE IF NOT EXISTS mhs;
USE mhs;

CREATE TABLE IF NOT EXISTS datamhs (
    nim VARCHAR(15) NOT NULL,
    nama VARCHAR(50),
    semester INT,
    kelas VARCHAR(20),
    PRIMARY KEY (nim)
);

INSERT IGNORE INTO datamhs (nim, nama, semester, kelas)
VALUES
('2023001', 'Budi Santoso', 3, 'TI-A'),
('2023002', 'Siti Aminah', 3, 'TI-B'),
('2023003', 'Budiman', 5, 'TI-A');