package sistemaBiblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collection;
import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    private Usuario usuario;

    @BeforeEach
    void setUp() {
        usuario = new Usuario("123", "Test User", TipoUsuario.ALUNO);
        assertEquals(usuario.getTipoUsuario(), TipoUsuario.ALUNO);
        assertEquals(usuario.getMatricula(), "123");
        assertEquals(usuario.getNome(), "Test User");
        Livro livro1 = new Livro("1234567890", "Book 1", "autorGenerico");
        Livro livro2 = new Livro("0987654321", "Book 2", "autorGenerico");
        usuario.adicionarEmprestimo(livro1);
        usuario.adicionarEmprestimo(livro2);
        assertTrue(usuario.getLivrosEmprestados().contains(livro1));
        assertTrue(usuario.getLivrosEmprestados().contains(livro2));
    }
    @Test
    void testAdicionarEmprestimoERemoverEmprestimo() {
        Livro novoLivro = new Livro("1111111111", "New Book", "autorGenerico");
        Livro novoLivro01 = new Livro("894563452", "New Book", "autorGenerico");
        usuario.adicionarEmprestimo(novoLivro);
        assertTrue(usuario.getLivrosEmprestados().contains(novoLivro));
        assertTrue(usuario.removerEmprestimo(novoLivro));
        assertFalse(usuario.removerEmprestimo(novoLivro01));
    }

}
