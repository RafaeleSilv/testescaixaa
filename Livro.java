public class Livro {
    private String titulo;
    private String autor;
    private boolean emprestado;

    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.emprestado = false;
    }

    public void emprestar() {
        if (emprestado) {
            throw new IllegalStateException("O livro já está emprestado.");
        }
        emprestado = true;
    }

    public void devolver() {
        if (!emprestado) {
            throw new IllegalStateException("O livro não está emprestado.");
        }
        emprestado = false;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }
}
