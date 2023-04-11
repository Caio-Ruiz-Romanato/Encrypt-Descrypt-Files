import javax.swing.*;

import classes.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class CriptoFile extends JFrame {

    private JLabel lblFile, lblResutado;
    private JButton btnEncrypt, btnDescrypt;

    public CriptoFile() {

        // Objeto lblFile
        lblFile = new JLabel("Selecione um arquivo");
        lblFile.setBounds(50, 50, 500, 40);
        lblFile.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
        lblFile.setOpaque(true);
        lblFile.setBackground(Color.WHITE);
        add(lblFile);
        lblFile.addMouseListener(
                new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        JFileChooser fileChooser = new JFileChooser();
                        int result = fileChooser.showOpenDialog(null);
                        if (result == JFileChooser.APPROVE_OPTION) {
                            lblFile.setText(fileChooser.getSelectedFile().getAbsolutePath());
                        }
                    }
                });

        // Objeto lblResultado
        lblResutado = new JLabel("Selecione 1um arquivo");
        lblResutado.setBounds(50, 150, 500, 40);
        lblResutado.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
        lblResutado.setOpaque(true);
        add(lblResutado);

        // Botoes
        btnEncrypt = new JButton("Criptografar");
        btnEncrypt.setBounds(50, 100, 245, 40);
        btnEncrypt.setFont(new Font("Arial", Font.BOLD, 18));
        add(btnEncrypt);
        btnEncrypt.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (Criptografia.encrypt(lblFile.getText())) {

                            lblResutado.setText("Arquivo criptografado com sucesso !!!");
                            lblResutado.setForeground(Color.BLUE);

                        } else {
                            lblResutado.setText("Arquivo nao foi criptografado");
                            lblResutado.setForeground(Color.RED);
                        }
                    }
                });

        btnDescrypt = new JButton("Descriptografar");
        btnDescrypt.setBounds(305, 100, 245, 40);
        btnDescrypt.setFont(new Font("Arial", Font.BOLD, 18));
        add(btnDescrypt);
        btnDescrypt.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (Criptografia.decrypt(lblFile.getText())) {

                            lblResutado.setText("Arquivo descriptografado com sucesso !!!");
                            lblResutado.setForeground(Color.BLUE);

                        } else {
                            lblResutado.setText("Arquivo nao foi descriptografado");
                            lblResutado.setForeground(Color.RED);
                        }
                    }
                });

    }

    public static void main(String[] args) {

        // Configuracao da interface grafica / Janela
        CriptoFile form = new CriptoFile();
        form.setLayout(null);
        form.setBounds(0, 0, 600, 300);
        form.setLocationRelativeTo(null);
        form.setVisible(true);
        form.setDefaultCloseOperation(EXIT_ON_CLOSE);
        form.setTitle("Criptografia de Arquivos");

    }
}
