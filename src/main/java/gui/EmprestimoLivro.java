package gui;
import sistemaBiblioteca.SistemaBiblioteca;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmprestimoLivro extends JFrame {
    private JButton btnEmprestar;
    private JTextField txtMatriculaUsuario;
    private JTextField txtIdLivro;
    private SistemaBiblioteca sistemaBiblioteca;

    public EmprestimoLivro(SistemaBiblioteca sistemaBiblioteca) {
        this.sistemaBiblioteca = sistemaBiblioteca;
        setTitle("Empréstimo de Livro");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(new JLabel("Matrícula do Usuário:"));
        txtMatriculaUsuario = new JTextField();
        panel.add(txtMatriculaUsuario);

        panel.add(new JLabel("ID do Livro:"));
        txtIdLivro = new JTextField();
        panel.add(txtIdLivro);

        btnEmprestar = new JButton("Emprestar");
        panel.add(btnEmprestar);

        add(panel);

        btnEmprestar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String matriculaUsuario = txtMatriculaUsuario.getText();
                String idLivro = txtIdLivro.getText();

                boolean sucesso = sistemaBiblioteca.emprestarLivro(matriculaUsuario, idLivro);
                if (sucesso) {
                    JOptionPane.showMessageDialog(null, "Empréstimo realizado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Falha no empréstimo.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
