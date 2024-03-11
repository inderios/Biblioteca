package gui;

import sistemaBiblioteca.SistemaBiblioteca;
import sistemaBiblioteca.TipoUsuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroUsuario extends JFrame {
    private JButton btnCadastrar;
    private JTextField txtMatricula;
    private JTextField txtNome;
    private JRadioButton aluno, professor, funcionario;
    private ButtonGroup grupoTipoUsuario;

    private SistemaBiblioteca sistemaBiblioteca;

    public CadastroUsuario(SistemaBiblioteca sistemaBiblioteca) {
        this.sistemaBiblioteca = sistemaBiblioteca;
        setTitle("Cadastro de Usuário");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(new JLabel("Matrícula:"));
        txtMatricula = new JTextField();
        panel.add(txtMatricula);

        panel.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        panel.add(txtNome);

        // Adicionando os botões de opção ao JPanel
        panel.add(new JLabel("Tipo de Usuário:"));
        aluno = new JRadioButton("Aluno");
        panel.add(aluno);
        professor = new JRadioButton("Professor");
        panel.add(professor);
        funcionario = new JRadioButton("Funcionário");
        panel.add(funcionario);

        // Agrupando os botões de opção
        grupoTipoUsuario = new ButtonGroup();
        grupoTipoUsuario.add(aluno);
        grupoTipoUsuario.add(professor);
        grupoTipoUsuario.add(funcionario);

        btnCadastrar = new JButton("Cadastrar");
        panel.add(btnCadastrar);

        add(panel);

        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String matricula = txtMatricula.getText();
                String nome = txtNome.getText();
                TipoUsuario tipoUsuario = null;
                if (aluno.isSelected()) {
                    tipoUsuario = TipoUsuario.ALUNO;
                } else if (professor.isSelected()) {
                    tipoUsuario = TipoUsuario.PROFESSOR;
                } else if (funcionario.isSelected()) {
                    tipoUsuario = TipoUsuario.FUNCIONARIO;
                }
                boolean sucesso = sistemaBiblioteca.cadastrarUsuario(matricula, nome, tipoUsuario);
                if (sucesso) {
                    JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Falha no cadastro.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
