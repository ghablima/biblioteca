package entities;

import java.util.List;
import repository.BibliotecaRepository;
import usecase.DevolverLivroUseCase;
import usecase.EmprestarLivroUseCase;

public class Biblioteca {
	public static void main(String[] args) {

        BibliotecaRepository repository = new BibliotecaRepository();
        
      
        repository.adicionarLivro(new Livro(1, "Dom Casmurro", 1));
        repository.adicionarLivro(new Livro(2, "O Senhor dos Anéis", 1));
        repository.adicionarLivro(new Livro(3, "Metamorfose", 1));
        
        
        Aluno aluno = new Aluno(1, "João", 1);
        Professor professor = new Professor(2, "Maria");
     
        EmprestarLivroUseCase emprestarUseCase = new EmprestarLivroUseCase(repository);
        DevolverLivroUseCase devolverUseCase = new DevolverLivroUseCase(repository);
        
        
        System.out.println("Livros disponíveis:");
        listarLivrosDisponiveis(repository);
        
        
      
        boolean emprestimoSucesso = emprestarUseCase.executar(1, aluno);
        System.out.println("\nEmpréstimo " + (emprestimoSucesso ? "realizado por aluno" : "não realizado"));
        System.out.println("Créditos do aluno após empréstimo: " + aluno.getCreditos());
        
        System.out.println("\n--------------------");
        
        
        System.out.println("\nLivros disponíveis:");
        listarLivrosDisponiveis(repository);

        emprestimoSucesso = emprestarUseCase.executar(2, professor);
        System.out.println("\nEmpréstimo " + (emprestimoSucesso ? "realizado por professor" : "não realizado"));
        
        System.out.println("\n--------------------");
        
        System.out.println("\nLivros disponíveis:");
        listarLivrosDisponiveis(repository);
        
        System.out.println("\n--------------------");
     
       
        boolean devolucaoSucesso = devolverUseCase.executar(1, aluno);
        System.out.println("\nDevolução " + (devolucaoSucesso ? "bem-sucedida por aluno" : "falhou"));
        System.out.println("Créditos do aluno após devolução: " + aluno.getCreditos());
        
     
        System.out.println("\nLivros disponíveis:");
        listarLivrosDisponiveis(repository);
    }
    
    private static void listarLivrosDisponiveis(BibliotecaRepository repository) {
        List<Livro> disponiveis = repository.listarLivrosDisponiveis();
        if (disponiveis.isEmpty()) {
            System.out.println("Nenhum livro disponível no momento.");
        } else {
            for (Livro livro : disponiveis) {
                System.out.println(livro.getId() + " - " + livro.getTitulo() + 
                                 " (Valor: " + livro.getValorCredito() + " crédito(s))");
            }
        }
    }
}
