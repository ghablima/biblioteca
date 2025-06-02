package entities;

public class Professor extends Usuario {
	public Professor(int id, String nome) {
        super(id, nome);
    }

    public boolean podePegarEmprestado() {
        return true;
    }
}
