package gui;

import sistemaBiblioteca.SistemaBiblioteca;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaInicial extends JFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            TelaInicial tela = new TelaInicial();
            tela.setVisible(true);
            tela.definitEvento();
        });
    }
    private JButton btnCadastroLivro, btnCadastroUsuario, btnEmprestimo, btnSalvaTudo;
    SistemaBiblioteca sistemaBiblioteca;

    public TelaInicial() {
        sistemaBiblioteca = new SistemaBiblioteca();
        sistemaBiblioteca.carregarTodos();
        setTitle("Sistema de Biblioteca");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Criação dos botões
        btnCadastroLivro = new JButton("Cadastrar Livro");
        btnCadastroUsuario = new JButton("Cadastrar Usuário");
        btnEmprestimo = new JButton("Empréstimo de Livros");
        btnSalvaTudo = new JButton("Salva tudo");

        // Adicionando os botões ao JFrame
        setLayout(new GridLayout(4,0)); // Define o layout para organizar os botões
        add(btnCadastroLivro);
        add(btnCadastroUsuario);
        add(btnEmprestimo);
        add(btnSalvaTudo);
    }
    private void definitEvento() {
        btnCadastroUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CadastroUsuario cadastroUsuario = new CadastroUsuario(sistemaBiblioteca);
                cadastroUsuario.setVisible(true);
            }
        });
        btnCadastroLivro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CadastroLivro cadastroLivro = new CadastroLivro(sistemaBiblioteca);
                cadastroLivro.setVisible(true);
            }
        });
        btnEmprestimo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EmprestimoLivro emprestimoLivro = new EmprestimoLivro(sistemaBiblioteca);
                emprestimoLivro.setVisible(true);
            }
        });
        btnSalvaTudo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sistemaBiblioteca.salvarTodos();
            }
        });
    }
}
