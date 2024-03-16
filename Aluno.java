package ca;

public class Aluno {
	private String nome, matricula;
	private HorarioAluno horarioAluno;

	public Aluno(String nome, String matricula) {
		this.nome = nome;
		this.matricula = matricula;
	}
	
	public void adicionarHorario(HorarioAluno horarioAluno) {
		this.horarioAluno = horarioAluno;
	}
	
	// Getters
	
	protected String getNome() {
		return nome;
	}

	protected String getMatricula() {
		return matricula;
	}

	protected HorarioAluno getHorarioAluno() {
		return horarioAluno;
	}
	
}
