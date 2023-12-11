package Pekan8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DataMahasiswa {
    private JFrame frame;
    private JTextField namaField, nimField;
    private JComboBox<String> jurusanBox;
    private Mahasiswa[] dataMahasiswa = new Mahasiswa[999];
    private int index = 0;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DataMahasiswa window = new DataMahasiswa();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public DataMahasiswa() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(64, 128, 128));
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNama = new JLabel("Nama");
        lblNama.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblNama.setForeground(new Color(255, 255, 255));
        lblNama.setBounds(28, 60, 70, 18);
        frame.getContentPane().add(lblNama);

        namaField = new JTextField();
        namaField.setFont(new Font("Times New Roman", Font.BOLD, 12));
        namaField.setBounds(108, 60, 148, 18);
        frame.getContentPane().add(namaField);
        namaField.setColumns(10);

        JLabel lblNim = new JLabel("NIM");
        lblNim.setForeground(new Color(255, 255, 255));
        lblNim.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblNim.setBounds(28, 98, 46, 14);
        frame.getContentPane().add(lblNim);

        nimField = new JTextField();
        nimField.setFont(new Font("Times New Roman", Font.BOLD, 12));
        nimField.setBounds(108, 95, 148, 20);
        frame.getContentPane().add(nimField);
        nimField.setColumns(10);

        JLabel lblJurusan = new JLabel("Jurusan");
        lblJurusan.setForeground(new Color(255, 255, 255));
        lblJurusan.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblJurusan.setBounds(28, 140, 58, 14);
        frame.getContentPane().add(lblJurusan);

        String[] jurusan = {"", "Informatika", "Sistem Informasi", "Teknik Komputer"};
        jurusanBox = new JComboBox<>(jurusan);
        jurusanBox.setModel(new DefaultComboBoxModel(new String[] {"", "Informatika", "Sistem Informasi", "Teknik Komputer"}));
        jurusanBox.setBounds(108, 137, 148, 20);
        frame.getContentPane().add(jurusanBox);

        JButton btnSave = new JButton("Simpan");
        btnSave.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (index < dataMahasiswa.length) {
                    dataMahasiswa[index] = new Mahasiswa(namaField.getText(), nimField.getText(), (String) jurusanBox.getSelectedItem());
                    index++;
                    JOptionPane.showMessageDialog(null, "Terima kasih, " + namaField.getText()+". Data anda sudah disimpan.");
                    namaField.setText("");
                    nimField.setText("");
                    jurusanBox.setSelectedIndex(0);
                } else {
                    JOptionPane.showMessageDialog(null, "Data penuh!");
                }
            }
        });
        btnSave.setBounds(28, 195, 89, 30);
        frame.getContentPane().add(btnSave);

        JButton btnReset = new JButton("Reset");
        btnReset.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                namaField.setText("");
                nimField.setText("");
                jurusanBox.setSelectedIndex(0);
            }
        });
        btnReset.setBounds(167, 195, 89, 30);
        frame.getContentPane().add(btnReset);
        
        JLabel lblNewLabel = new JLabel("Aplikasi Data Mahasiswa");
        lblNewLabel.setForeground(new Color(230, 230, 250));
        lblNewLabel.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 15));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(10, 10, 416, 30);
        frame.getContentPane().add(lblNewLabel);
    }

    class Mahasiswa {
        String nama;
        String nim;
        String jurusan;

        Mahasiswa(String nama, String nim, String jurusan) {
            this.nama = nama;
            this.nim = nim;
            this.jurusan = jurusan;
        }
    }
}
