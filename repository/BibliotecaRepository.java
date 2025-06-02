package repository;
import entities.Livro;
import java.util.ArrayList;
import java.util.List;


public class BibliotecaRepository {
	private List<Livro> livros; 

    public BibliotecaRepository() {
        this.livros = new ArrayList<>();
    }

    
    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public List<Livro> listarLivrosDisponiveis() {
        List<Livro> disponiveis = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.isDisponivel()) {
                disponiveis.add(livro);
            }
        }
        return disponiveis;
    }

    
    public List<Livro> listarTodosLivros() {
        return new ArrayList<>(livros);
    }

    public Livro buscarLivroPorId(int id) {
        for (Livro livro : livros) {
            if (livro.getId() == id) {
                return livro;
            }
        }
        return null;
    }
}

