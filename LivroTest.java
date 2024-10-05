import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LivroTest {
    
    @Test
    public void testEmprestar() {
        Livro livro = new Livro("Título", "Autor");
        livro.emprestar();
        assertTrue(livro.isEmprestado());
    }

    @Test
    public void testDevolver() {
        Livro livro = new Livro("Título", "Autor");
        livro.emprestar();
        livro.devolver();
        assertFalse(livro.isEmprestado());
    }

    @Test
    public void testEmprestarLivroJaEmprestado() {
        Livro livro = new Livro("Título", "Autor");
        livro.emprestar();
        Exception exception = assertThrows(IllegalStateException.class, livro::emprestar);
        assertEquals("O livro já está emprestado.", exception.getMessage());
    }

    @Test
    public void testDevolverLivroNaoEmprestado() {
        Livro livro = new Livro("Título", "Autor");
        Exception exception = assertThrows(IllegalStateException.class, livro::devolver);
        assertEquals("O livro não está emprestado.", exception.getMessage());
    }
}
