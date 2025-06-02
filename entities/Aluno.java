package entities;

public class Aluno extends Usuario {
	private int creditos;

    public Aluno(int id, String nome, int creditos) {
        super(id, nome);
        this.creditos = creditos;
    }

    public int getCreditos() {
        return creditos;
    }

    public void adicionarCredito() {
        this.creditos++;
    }

    public void removerCredito() {
        if (creditos > 0) {
            this.creditos--;
        }
    }

    public boolean podePegarEmprestado() {
        return creditos > 0;
    }
}
