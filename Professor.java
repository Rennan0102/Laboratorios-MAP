package ca;

public class Professor {
	private String nome, matricula;
	private HorarioProfessor horarioProfessor;

	protected Professor(String nome, String matricula) {
		this.nome = nome;
		this.matricula = matricula;
	}
	
	protected void adicionarHorario(HorarioProfessor horarioProfessor) {
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
