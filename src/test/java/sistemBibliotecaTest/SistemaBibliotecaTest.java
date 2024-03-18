package sistemBibliotecaTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sistemaBiblioteca.Livro;
import sistemaBiblioteca.SistemaBiblioteca;
import sistemaBiblioteca.TipoUsuario;
import sistemaBiblioteca.Usuario;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class SistemaBibliotecaTest {

    private SistemaBiblioteca sistemaBiblioteca;

    @BeforeEach
    void setUp() {
        sistemaBiblioteca = new SistemaBiblioteca();
    }

    @Test
    void testCadastrarUsuario() {
        assertTrue(sistemaBiblioteca.cadastrarUsuario("123", "João", TipoUsuario.ALUNO));
        assertFalse(sistemaBiblioteca.cadastrarUsuario("123", "Maria", TipoUsuario.ALUNO)); // Tentativa de duplicação
    }

    @Test
    void testCadastrarLivro() {
        assertTrue(sistemaBiblioteca.cadastrarLivro("978-3-16-148410-0", "Título do Livro", "Autor do Livro"));
        assertFalse(sistemaBiblioteca.cadastrarLivro("978-3-16-148410-0", "Título do Livro", "Autor do Livro")); // Tentativa de duplicação
    }

    @Test
    void testEmprestarLivro() {
        sistemaBiblioteca.cadastrarUsuario("123", "João", TipoUsuario.ALUNO);
        sistemaBiblioteca.cadastrarLivro("978-3-16-148410-0", "Título do Livro", "Autor do Livro");
        assertTrue(sistemaBiblioteca.emprestarLivro("123", "978-3-16-148410-0"));
        assertFalse(sistemaBiblioteca.emprestarLivro("123", "978-3-16-148410-0")); // Tentativa de empréstimo duplicado
    }

    @Test
    void testDevolverLivro() {
        sistemaBiblioteca.cadastrarUsuario("123", "João", TipoUsuario.ALUNO);
        sistemaBiblioteca.cadastrarLivro("978-3-16-148410-0", "Título do Livro", "Autor do Livro");
        sistemaBiblioteca.emprestarLivro("123", "978-3-16-148410-0");
        assertTrue(sistemaBiblioteca.devolverLivro("123", "978-3-16-148410-0"));
        assertFalse(sistemaBiblioteca.devolverLivro("123", "978-3-16-148410-0")); // Tentativa de devolução duplicada
    }

    @Test
    void testSerializationAndDeserialization() throws IOException, ClassNotFoundException {
        sistemaBiblioteca.cadastrarUsuario("123", "João", TipoUsuario.ALUNO);
        sistemaBiblioteca.cadastrarLivro("978-3-16-148410-0", "Título do Livro", "Autor do Livro");
        sistemaBiblioteca.emprestarLivro("123", "978-3-16-148410-0");

        sistemaBiblioteca.salvarTodos();

        sistemaBiblioteca = new SistemaBiblioteca();
        sistemaBiblioteca.carregarTodos();

        Collection<Usuario> usuarios = sistemaBiblioteca.getUsuarios().values();
        assertEquals(1, usuarios.size());
        assertEquals("João", usuarios.iterator().next().getNome());

        Collection<Livro> livros = sistemaBiblioteca.getTodosOsLivros().values();
        assertEquals(1, livros.size());
        assertEquals("Título do Livro", livros.iterator().next().getTitulo());
    }

    @AfterEach
    void tearDown() throws IOException {
        File usuariosFile = new File("usuarios.ser");
        File livrosFile = new File("livros.ser");
        if (usuariosFile.exists()) {
            usuariosFile.delete();
        }
        if (livrosFile.exists()) {
            livrosFile.delete();
        }
    }
}
