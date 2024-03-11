package sistemBibliotecaTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sistemaBiblioteca.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestSistemaBiblioteca {
    private SistemaBiblioteca sistemaBiblioteca = new SistemaBiblioteca();
    @BeforeEach
    public void setUp() {
        Usuario usuario1 = new Usuario("123", "Test User3", TipoUsuario.ALUNO);
        Usuario usuario2 = new Usuario("456", "Test User2", TipoUsuario.FUNCIONARIO);
        Usuario usuario3 = new Usuario("789", "Test User1", TipoUsuario.PROFESSOR);
        Livro livro1 = new Livro("6548456782", "Book 1", "autorGenerico3");
        Livro livro2 = new Livro("7868678672", "Book 2", "autorGenerico2");
        Livro livro3 = new Livro("5765345354", "Book 3", "autorGenerico1");
        assertTrue(sistemaBiblioteca.cadastrarUsuario(usuario1));
        assertFalse(sistemaBiblioteca.cadastrarUsuario(usuario1));
        assertTrue(sistemaBiblioteca.cadastrarUsuario(usuario2));
        assertFalse(sistemaBiblioteca.cadastrarUsuario(usuario2));
        assertTrue(sistemaBiblioteca.cadastrarUsuario(usuario3));
        assertFalse(sistemaBiblioteca.cadastrarUsuario(usuario3));
        assertTrue(sistemaBiblioteca.cadastrarLivro(livro1));
        assertFalse(sistemaBiblioteca.cadastrarLivro(livro1));
        assertTrue(sistemaBiblioteca.cadastrarLivro(livro2));
        assertFalse(sistemaBiblioteca.cadastrarLivro(livro2));
        assertTrue(sistemaBiblioteca.cadastrarLivro(livro3));
        assertFalse(sistemaBiblioteca.cadastrarLivro(livro3));
        sistemaBiblioteca.getTodosOsLivros().size();
    }
    @Test
    public void pegarLivroTest() {
        assertTrue(sistemaBiblioteca.emprestarLivro("123", "6548456782"));
        assertFalse(sistemaBiblioteca.emprestarLivro("123", "6548456782"));
    }
    public void devolverLivroTest() {

    }
}
