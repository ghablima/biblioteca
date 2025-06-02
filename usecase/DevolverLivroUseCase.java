package usecase;

import entities.Livro;
import entities.Usuario;
import repository.BibliotecaRepository;

public class DevolverLivroUseCase {
	
	private BibliotecaRepository repository;

    public DevolverLivroUseCase(BibliotecaRepository repository) {
        this.repository = repository;
    }

    
    public boolean executar(int livroId, Usuario usuario) {
        Livro livro = repository.buscarLivroPorId(livroId);
        
        if (livro == null || livro.isDisponivel() || 
            livro.getEmprestadoPara() == null || 
            livro.getEmprestadoPara().getId() != usuario.getId()) {
            return false;
        }

        
        if (usuario instanceof entities.Aluno) {
            ((entities.Aluno) usuario).adicionarCredito();
        }

        livro.devolver();
        return true;
    }
	
}
