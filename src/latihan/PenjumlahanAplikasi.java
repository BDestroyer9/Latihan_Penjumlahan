package latihan;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PenjumlahanAplikasi extends JFrame {
    private JTextField textFieldAngka1, textFieldAngka2, textFieldHasil;
    private JButton buttonTambah, buttonHapus, buttonKeluar;

    public PenjumlahanAplikasi() {
        // Set judul jendela
        setTitle("Aplikasi Penjumlahan");

        // Atur layout
        setLayout(new FlowLayout());

        // Membuat label dan textfield untuk angka pertama
        JLabel labelAngka1 = new JLabel("Angka 1:");
        textFieldAngka1 = new JTextField(10);
        add(labelAngka1);
        add(textFieldAngka1);

        // Membuat label dan textfield untuk angka kedua
        JLabel labelAngka2 = new JLabel("Angka 2:");
        textFieldAngka2 = new JTextField(10);
        add(labelAngka2);
        add(textFieldAngka2);

        // Membuat label dan textfield untuk hasil
        JLabel labelHasil = new JLabel("Hasil:");
        textFieldHasil = new JTextField(10);
        textFieldHasil.setEditable(false); // Hanya untuk menampilkan hasil
        add(labelHasil);
        add(textFieldHasil);

        // Tombol Tambah
        buttonTambah = new JButton("Tambah");
        add(buttonTambah);

        // Tombol Hapus
        buttonHapus = new JButton("Hapus");
        add(buttonHapus);

        // Tombol Keluar
        buttonKeluar = new JButton("Keluar");
        add(buttonKeluar);

        // ActionListener untuk tombol Tambah
        buttonTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Mengambil angka dari TextField dan mengkonversi ke double
                    double angka1 = Double.parseDouble(textFieldAngka1.getText());
                    double angka2 = Double.parseDouble(textFieldAngka2.getText());
                    double hasil = angka1 + angka2;

                    // Menampilkan hasil penjumlahan di TextField Hasil
                    textFieldHasil.setText(String.valueOf(hasil));
                } catch (NumberFormatException ex) {
                    // Menampilkan error jika input bukan angka
                    JOptionPane.showMessageDialog(null, "Input harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // ActionListener untuk tombol Hapus
        buttonHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Menghapus input di textfield
                textFieldAngka1.setText("");
                textFieldAngka2.setText("");
                textFieldHasil.setText("");
                // Fokus kembali ke textfield angka pertama
                textFieldAngka1.requestFocus();
            }
        });

        // ActionListener untuk tombol Keluar
        buttonKeluar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Menutup aplikasi
                System.exit(0);
            }
        });

        // Menambahkan FocusListener untuk membersihkan JTextField saat mendapatkan fokus
        textFieldAngka1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                textFieldAngka1.setText("");
            }
        });
        textFieldAngka2.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                textFieldAngka2.setText("");
            }
        });

        // Membatasi input hanya angka pada JTextField menggunakan KeyAdapter
        textFieldAngka1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != '.' && c != KeyEvent.VK_BACK_SPACE) {
                    e.consume(); // Menyaring input yang bukan angka atau titik desimal
                }
            }
        });

        textFieldAngka2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != '.' && c != KeyEvent.VK_BACK_SPACE) {
                    e.consume(); // Menyaring input yang bukan angka atau titik desimal
                }
            }
        });

        // Menyetel ukuran jendela dan tampilkan
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        // Menjalankan aplikasi
        new PenjumlahanAplikasi();
    }
}

