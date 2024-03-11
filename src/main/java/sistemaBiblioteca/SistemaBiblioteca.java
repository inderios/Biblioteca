package sistemaBiblioteca;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SistemaBiblioteca {
    private Map<String, Livro> livrosMap;
    private Map<String, Usuario> usuariosMap;

    public SistemaBiblioteca() {
        this.livrosMap = new HashMap<>();
        this.usuariosMap = new HashMap<>();
    }

    public boolean emprestarLivro(String matricula, String idLivro) {
        if (!usuariosMap.containsKey(matricula) || !livrosMap.containsKey(idLivro)) {
            return false;
        }
        Usuario usuario = usuariosMap.get(matricula);
        Livro livro = livrosMap.get(idLivro);
        // Supondo que o método adicionarEmprestimo existe na classe Usuario
        return usuario.adicionarEmprestimo(livro);
    }
    public boolean devolverLivro(String matricula, String idLivro) {
        Usuario usuario = usuariosMap.get(matricula);
        if (usuario == null || !usuario.getLivrosEmprestados().contains(idLivro)) {
            return false;
        }
        Livro livroEmprestado = livrosMap.get(idLivro);
        usuario.removerEmprestimo(livroEmprestado);
        return true;
    }
    public boolean cadastrarUsuario(String matricula, String nome, TipoUsuario tipoUsuario) {
        Usuario usuarioNovo = new Usuario(matricula, nome, tipoUsuario);
        return adicionarUsuario(usuarioNovo);
    }
    public boolean cadastrarUsuario(Usuario usuarioNovo) {
        return adicionarUsuario(usuarioNovo);
    }

    private boolean adicionarUsuario(Usuario usuarioNovo) {
        if (usuariosMap.containsKey(usuarioNovo.getMatricula())) {
            return false;
        }
        usuariosMap.put(usuarioNovo.getMatricula(), usuarioNovo);
        return true;
    }
    public boolean cadastrarLivro(String isbn, String titulo, String autor) {
        Livro novoLivro = new Livro(isbn, titulo, autor);
        return adicionarLivro(novoLivro);
    }

    public boolean cadastrarLivro(Livro novoLivro) {
        return adicionarLivro(novoLivro);
    }

    private boolean adicionarLivro(Livro novoLivro) {
        if (livrosMap.containsKey(novoLivro.getIsbn())) {
            return false;
        }
        livrosMap.put(novoLivro.getIsbn(), novoLivro);
        return true;
    }
    public Map<String, Livro> getTodosOsLivros() {
        return livrosMap;
    }

    public Collection<Usuario> getUsuarios() {
        return usuariosMap.values();
    }

    public Collection<Livro> getLivrosEmprestadosPorUsuario(String matriculaUsuario) {
        Usuario usuario = usuariosMap.get(matriculaUsuario);
        if (usuario != null) {
            return usuario.getLivrosEmprestados();
        } else {
            return Collections.emptyList();
        }
    }
}
