package ca;

public class Professor {
	private String nome, matricula;
	private HorarioProfessor horarioProfessor;

	public Professor(String nome, String matricula) {
		this.nome = nome;
		this.matricula = matricula;
	}
	
	public void adicionarHorario(HorarioProfessor horarioProfessor) {
		this.horarioProfessor = horarioProfessor;
	}
	
	// Getters
	
	protected String getNome() {
		return nome;
	}

	protected String getMatricula() {
		return matricula;
	}

	protected HorarioProfessor getHorarioProfessor() {
		return horarioProfessor;
	}
	
}
