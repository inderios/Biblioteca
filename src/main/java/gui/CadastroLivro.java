package gui;

import sistemaBiblioteca.SistemaBiblioteca;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroLivro extends JFrame {
    private JButton btnCadastrar;
    private JTextField txtIsbn;
    private JTextField txtTitulo;
    private JTextField txtAutor;
    private SistemaBiblioteca sistemaBiblioteca;

    public CadastroLivro(SistemaBiblioteca sistemaBiblioteca) {
        this.sistemaBiblioteca = sistemaBiblioteca;
        setTitle("Cadastro de Livro");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(new JLabel("ISBN:"));
        txtIsbn = new JTextField();
        panel.add(txtIsbn);

        panel.add(new JLabel("Título:"));
        txtTitulo = new JTextField();
        panel.add(txtTitulo);

        panel.add(new JLabel("Autor:"));
        txtAutor = new JTextField();
        panel.add(txtAutor);

        btnCadastrar = new JButton("Cadastrar");
        panel.add(btnCadastrar);

        add(panel);

        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String isbn = txtIsbn.getText();
                String titulo = txtTitulo.getText();
                String autor = txtAutor.getText();

                boolean sucesso = sistemaBiblioteca.cadastrarLivro(isbn, titulo, autor);
                if (sucesso) {
                    JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Falha no cadastro.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
