package sistemBibliotecaTest;

import org.junit.jupiter.api.Test;
import sistemaBiblioteca.Livro;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LivroTest {

    @Test
    void testLivroConstructor() {
        Livro livro = new Livro("1234567890", "Test Book", "autorGenerico");
        assertEquals("1234567890", livro.getIsbn());
        assertEquals("Test Book", livro.getTitulo());
        assertFalse(livro.isEmprestado());
    }

    @Test
    void testSetIsbn() {
        Livro livro = new Livro("1234567890", "Test Book", "autorGenerico");
        livro.setIsbn("0987654321");
        assertEquals("0987654321", livro.getIsbn());
    }

    @Test
    void testSetTitulo() {
        Livro livro = new Livro("1234567890", "Test Book", "autorGenerico");
        livro.setTitulo("Updated Title");
        assertEquals("Updated Title", livro.getTitulo());
    }

    @Test
    void testSetEmprestado() {
        Livro livro = new Livro("1234567890", "Test Book", "autorGenerico");
        livro.setEmprestado(true);
        assertTrue(livro.isEmprestado());
    }
}
