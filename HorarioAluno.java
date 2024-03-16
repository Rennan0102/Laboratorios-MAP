package ca;

import java.util.ArrayList;

public class HorarioAluno {
	private Aluno aluno;
	private ArrayList<Turma> turmasAluno;
	
	public HorarioAluno(Aluno aluno) {
		this.aluno = aluno;
		turmasAluno = new ArrayList<Turma>();
	}
	
	public void horarioAluno() {
		for (Turma turma : turmasAluno) {
			System.out.println(turma.getDisciplina().getNome());
			System.out.println(turma.getHorario().format(turma.formatoData));
		}
	}
	
	// Getters
	
	protected Aluno getAluno() {
		return aluno;
	}

	protected ArrayList<Turma> getTurmasAluno() {
		return turmasAluno;
	}
	
}
