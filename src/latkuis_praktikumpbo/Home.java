/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package latkuis_praktikumpbo;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
/**
 *
 * @author andika dwi saktiawan
 */

public class Home extends JFrame implements ActionListener {
    JLabel welcomeLabel, subLabel;
    JButton tombolAnak, tombolRemaja, tombolDewasa;
    private String username;

    public Home(String username) {
        this.username = username;

        // Konfigurasi Frame
        setSize(480, 300);
        setTitle("Home Page");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Menambahkan Label
        welcomeLabel = new JLabel("Selamat Datang, " + username);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        subLabel = new JLabel("SILAHKAN PILIH MAJALAH YANG INGIN DIBELI"); // Perbaikan titik koma
        add(welcomeLabel);
        add(subLabel);
        welcomeLabel.setBounds(20, 20, 300, 30);
        subLabel.setBounds(20, 45, 350, 25); // Memperbaiki posisi label kedua

        // Membuat tombol kategori majalah
        tombolAnak = new JButton("Majalah Anak");
        tombolRemaja = new JButton("Majalah Remaja");
        tombolDewasa = new JButton("Majalah Dewasa");

        // Menambahkan tombol ke frame
        add(tombolAnak);
        add(tombolRemaja);
        add(tombolDewasa);

        // Mengatur posisi tombol
        tombolAnak.setBounds(115, 110, 250, 40);
        tombolRemaja.setBounds(115, 160, 250, 40);
        tombolDewasa.setBounds(115, 210, 250, 40);

        // Menambahkan event listener
        tombolAnak.addActionListener(this);
        tombolRemaja.addActionListener(this);
        tombolDewasa.addActionListener(this);

        // Menampilkan frame
        setVisible(true);
    }

    Home() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String kategori = "";
        if (e.getSource() == tombolAnak) {
            kategori = "Majalah Anak";
        } else if (e.getSource() == tombolRemaja) {
            kategori = "Majalah Remaja";
        } else if (e.getSource() == tombolDewasa) {
            kategori = "Majalah Dewasa";
        }

        // Pastikan PembelianPage sudah ada sebelum dipanggil
        new Pembelian(username, kategori);
        dispose();
    }
}