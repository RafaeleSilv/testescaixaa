import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class BibliotecaTest {
    
    @Test
    public void testAdicionarLivro() {
        Biblioteca biblioteca = new Biblioteca();
        Livro livro = new Livro("Título", "Autor");
        biblioteca.adicionarLivro(livro);
        assertEquals(1, biblioteca.consultarLivrosDisponiveis().size());
    }

    @Test
    public void testConsultarLivrosDisponiveis() {
        Biblioteca biblioteca = new Biblioteca();
        Livro livro1 = new Livro("Título 1", "Autor 1");
        Livro livro2 = new Livro("Título 2", "Autor 2");
        livro1.emprestar();
        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);
        
        List<Livro> disponiveis = biblioteca.consultarLivrosDisponiveis();
        assertEquals(1, disponiveis.size());
        assertEquals("Título 2", disponiveis.get(0).getTitulo());
    }

    @Test
    public void testEmprestarLivro() {
        Biblioteca biblioteca = new Biblioteca();
        Livro livro = new Livro("Título", "Autor");
        biblioteca.adicionarLivro(livro);
        biblioteca.emprestarLivro("Título");
        assertTrue(livro.isEmprestado());
    }

    @Test
    public void testEmprestarLivroNaoEncontrado() {
        Biblioteca biblioteca = new Biblioteca();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            biblioteca.emprestarLivro("Título Inexistente");
        });
        assertEquals("Livro não encontrado.", exception.getMessage());
    }

    @Test
    public void testDevolverLivro() {
        Biblioteca biblioteca = new Biblioteca();
        Livro livro = new Livro("Título", "Autor");
        biblioteca.adicionarLivro(livro);
        biblioteca.emprestarLivro("Título");
        biblioteca.devolverLivro("Título");
        assertFalse(livro.isEmprestado());
    }

    @Test
    public void testDevolverLivroInexistente() {
        Biblioteca biblioteca = new Biblioteca();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            biblioteca.devolverLivro("Título Inexistente");
        });
        assertEquals("Livro não encontrado.", exception.getMessage());
    }
    
    @Test
    public void testDevolverLivroNaoEmprestado() {
        Biblioteca biblioteca = new Biblioteca();
        Livro livro = new Livro("Título", "Autor");
        biblioteca.adicionarLivro(livro);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            biblioteca.devolverLivro("Título");
        });
        assertEquals("Livro não encontrado.", exception.getMessage());
    }
}
