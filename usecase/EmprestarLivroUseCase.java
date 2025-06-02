package usecase;

import entities.Livro;
import entities.Usuario;
import repository.BibliotecaRepository;

public class EmprestarLivroUseCase {
	private BibliotecaRepository repository;

    public EmprestarLivroUseCase(BibliotecaRepository repository) {
        this.repository = repository;
    }

    
    public boolean executar(int livroId, Usuario usuario) {
        Livro livro = repository.buscarLivroPorId(livroId);
        
        if (livro == null || !livro.isDisponivel() || !usuario.podePegarEmprestado()) {
            return false;
        }

        if (usuario instanceof entities.Aluno) {
            ((entities.Aluno) usuario).removerCredito();
        }

        livro.emprestar(usuario);
        return true;
    }
}
