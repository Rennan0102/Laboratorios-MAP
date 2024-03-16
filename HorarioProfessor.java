package ca;

import java.util.ArrayList;

public class HorarioProfessor {
	private Professor professor;
	private ArrayList<Turma> turmasProf;
	
	public HorarioProfessor(Professor professor) {
		this.professor = professor;
		turmasProf = new ArrayList<Turma>();
	}
	
	public void horarioProf() {
		System.out.printf("Horário de %s:\n", professor.getNome());
		for (Turma turma : turmasProf) {
			System.out.println(turma.getDisciplina().getNome());
			System.out.println(turma.getHorario().format(turma.formatoData));
		}
	}

	// Getters
	
	protected Professor getProfessor() {
		return professor;
	}

	protected ArrayList<Turma> getTurmasProf() {
		return turmasProf;
	}
	
}
