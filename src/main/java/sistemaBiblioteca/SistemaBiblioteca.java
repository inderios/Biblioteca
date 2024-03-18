package sistemaBiblioteca;

import java.io.*;
import java.util.*;
//Code Smell God Class
public class SistemaBiblioteca {
    private Map<String, Livro> livrosMap;
    private Map<String, Usuario> usuariosMap;

    public SistemaBiblioteca() {
        this.livrosMap = new HashMap<>();
        this.usuariosMap = new HashMap<>();
    }
    //Long Method
    public boolean emprestarLivro(String matricula, String idLivro) {
        if (!usuariosMap.containsKey(matricula) || !livrosMap.containsKey(idLivro)) {
            return false;
        }
        Usuario usuario = usuariosMap.get(matricula);
        Livro livro = livrosMap.get(idLivro);
        // Supondo que o método adicionarEmprestimo existe na classe Usuario
        return usuario.adicionarEmprestimo(livro);
    }

    //Long Method: complicado de entender.
    public boolean devolverLivro(String matricula, String idLivro) {
        Usuario usuario = usuariosMap.get(matricula);
        if (usuario == null) {
            return false;
        }
        Livro livroEmprestado = livrosMap.get(idLivro);
        if (livroEmprestado == null || !usuario.getLivrosEmprestados().contains(livroEmprestado)) {
            return false;
        }
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

    public Map<String, Usuario> getUsuarios() {
        return usuariosMap;
    }

    public Collection<Livro> getLivrosEmprestadosPorUsuario(String matriculaUsuario) {
        Usuario usuario = usuariosMap.get(matriculaUsuario);
        if (usuario != null) {
            return usuario.getLivrosEmprestados();
        } else {
            return Collections.emptyList();
        }
    }
    public void salvarTodos() {
        salvarUsuarios();
        salvarLivros();
    }
    public void salvarUsuarios() {
        try (FileOutputStream fos = new FileOutputStream("src/main/java/dados/usuarios");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(new ArrayList<>(usuariosMap.values()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void salvarLivros() {
        try (FileOutputStream fos = new FileOutputStream("src/main/java/dados/livros");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(new ArrayList<>(livrosMap.values()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void carregarTodos() {
        carregarLivros();
        carregarUsuarios();
    }
    public void carregarUsuarios() {
        try (FileInputStream fis = new FileInputStream("src/main/java/dados/usuarios");
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            ArrayList<Usuario> usuarios = (ArrayList<Usuario>) ois.readObject();
            usuariosMap.clear();
            for (Usuario usuario : usuarios) {
                usuariosMap.put(usuario.getMatricula(), usuario);
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void carregarLivros() {
        try (FileInputStream fis = new FileInputStream("src/main/java/dados/livros");
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            ArrayList<Livro> livros = (ArrayList<Livro>) ois.readObject();
            livrosMap.clear();
            for (Livro livro : livros) {
                livrosMap.put(livro.getIsbn(), livro);
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
