/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package latkuis_praktikumpbo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Pembelian extends JFrame implements ActionListener {
    JLabel labelJudul = new JLabel("Halaman Pembelian");

    JLabel labelKategori = new JLabel("Kategori");
    JLabel labelValueKategori;

    JLabel labelHarga = new JLabel("Harga Satuan");
    JLabel labelValueHarga;

    JLabel labelJumlah = new JLabel("Jumlah");
    JTextField textJumlah = new JTextField();

    JButton btnKembali = new JButton("Kembali");
    JButton btnBeli = new JButton("Beli");

    JLabel labelTotalPembelian = new JLabel("Total Pembelian");
    JLabel labelJumlahBeli = new JLabel("Jumlah");
    JLabel labelValueJumlahBeli = new JLabel("0 pcs");

    JLabel labelTotalHarga = new JLabel("Total Harga");
    JLabel labelValueTotalHarga = new JLabel("Rp0");

    private String username;
    private String kategori;
    private int hargaSatuan;

    public Pembelian(String username, String kategori) {
        this.username = username;
        this.kategori = kategori;
        labelValueKategori = new JLabel(kategori);

        // tentukan harga sesuai kategori
        switch (kategori) {
            case "Majalah Anak":
                hargaSatuan = 10800;
                break;
            case "Majalah Remaja":
                hargaSatuan = 15200;
                break;
            case "Majalah Dewasa":
                hargaSatuan = 25400;
                break;
            default:
                hargaSatuan = 0;
        }

        // Format harga agar ada titik pemisah ribuan
        labelValueHarga = new JLabel("Rp. " + formatHarga(hargaSatuan) + " /pcs");

        setSize(400, 400);
        setTitle("Halaman Pembelian");
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Menambahkan komponen ke frame
        add(labelJudul);
        add(labelKategori);
        add(labelValueKategori);
        add(labelHarga);
        add(labelValueHarga);
        add(labelJumlah);
        add(textJumlah);
        add(btnKembali);
        add(btnBeli);
        add(labelTotalPembelian);
        add(labelJumlahBeli);
        add(labelValueJumlahBeli);
        add(labelTotalHarga);
        add(labelValueTotalHarga);

        // Mengatur posisi komponen
        labelJudul.setBounds(140, 10, 200, 20);
        labelKategori.setBounds(20, 50, 100, 20);
        labelValueKategori.setBounds(150, 50, 200, 20);

        labelHarga.setBounds(20, 80, 100, 20);
        labelValueHarga.setBounds(150, 80, 200, 20);

        labelJumlah.setBounds(20, 110, 100, 20);
        textJumlah.setBounds(150, 110, 100, 25);

        btnKembali.setBounds(70, 150, 100, 30);
        btnBeli.setBounds(200, 150, 100, 30);

        labelTotalPembelian.setBounds(140, 200, 200, 20);

        labelJumlahBeli.setBounds(20, 230, 100, 20);
        labelValueJumlahBeli.setBounds(150, 230, 200, 20);

        labelTotalHarga.setBounds(20, 260, 100, 20);
        labelValueTotalHarga.setBounds(150, 260, 200, 20);

        // Menambahkan event listener
        btnBeli.addActionListener(this);
        btnKembali.addActionListener(e -> {
            new Home(username);
            dispose();
        });

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int jumlah = Integer.parseInt(textJumlah.getText());
            if (jumlah <= 0) {
                throw new NumberFormatException(); // Menangani input negatif atau nol
            }
            int totalHarga = jumlah * hargaSatuan;

            labelValueJumlahBeli.setText(jumlah + " pcs");
            labelValueTotalHarga.setText("Rp. " + formatHarga(totalHarga));
        } catch (NumberFormatException error) {
            JOptionPane.showMessageDialog(this, "Masukkan jumlah yang valid (angka positif)!");
        }
    }

    // Method untuk memformat angka dengan titik sebagai pemisah ribuan
    private String formatHarga(int harga) {
        return String.format("%,d", harga).replace(',', '.');
    }
}
