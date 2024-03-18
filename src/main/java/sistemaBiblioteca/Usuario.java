package sistemaBiblioteca;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class Usuario implements Serializable {
    private String matricula;
    private String nome;
    private TipoUsuario tipoUsuario;
    private Collection<Livro> livrosEmprestados;
    public Usuario(String matricula, String nome, TipoUsuario tipoUsuario) {
        this.matricula = matricula;
        this.nome = nome;
        this.tipoUsuario = tipoUsuario;
        livrosEmprestados = new ArrayList<>();
    }
    //Feature Envy: essa metodo tá tomando o papel que outra classe poderia assumir.
    public boolean adicionarEmprestimo(Livro livro) {
        if (livrosEmprestados.contains(livro)) {
            return false; // Retorna false se o livro já estiver na lista
        }
        livro.setEmprestado(true);
        return livrosEmprestados.add(livro); // Retorna true se o livro foi adicionado com sucesso
    }

    public boolean removerEmprestimo(Livro livro) {
        if (livrosEmprestados.contains(livro)) {
            livrosEmprestados.remove(livro);
            return true;
        } else {
            return false;
        }
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public Collection<Livro> getLivrosEmprestados() {
        return livrosEmprestados;
    }
}
