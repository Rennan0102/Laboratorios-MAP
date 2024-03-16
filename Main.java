package ca;

import java.time.LocalDateTime;

public class Main {
	public static void main(String[] args) throws DisciplinaException, TurmaException{
		Professor professor01 = new Professor("Ricardo", "0101");
		Professor professor02 = new Professor("Sabrina", "0202");
		
		LocalDateTime hora01 = LocalDateTime.parse("11/12/2024 09:00", Turma.formatoData);
		LocalDateTime hora02 = LocalDateTime.parse("03/08/2024 14:00", Turma.formatoData);
		
		Aluno aluno01 = new Aluno("Rennan", "221080074");
		Aluno aluno02 = new Aluno("Shara", "221080112");
		
		HorarioProfessor horarioProf01 = new HorarioProfessor(professor01);
		HorarioProfessor horarioProf02 = new HorarioProfessor(professor02);
		
		HorarioAluno horarioAluno01 = new HorarioAluno(aluno01);
		HorarioAluno horarioAluno02 = new HorarioAluno(aluno02);
		
		professor01.adicionarHorario(horarioProf01);
		professor02.adicionarHorario(horarioProf02);
		aluno01.adicionarHorario(horarioAluno01);
		aluno02.adicionarHorario(horarioAluno02);
		
		Turma turma01 = ControleAcademico.criarTurma(professor01, ControleAcademico.criarDisciplina("Cálculo I", "GRAD.01"), hora01, 15);
		Turma turma02 = ControleAcademico.criarTurma(professor02, ControleAcademico.criarDisciplina("MAP", "GRAD.02"), hora02, 10);
		
		ControleAcademico.matricularAluno(aluno01, turma01);
		ControleAcademico.matricularAluno(aluno02, turma01);
		ControleAcademico.matricularAluno(aluno01, turma02);
		
		System.out.println("Quais disciplinas um professor está ministrando?");
		for (Disciplina disciplina : ControleAcademico.disciplinasProfessor(professor01)) {
			System.out.println(disciplina.getNome());
		}
		
		System.out.println("\nQual o horário de um professor?");
		horarioProf01.horarioProf();
		
		System.out.println("\nQuais os alunos de uma dada disciplina?");
		System.out.println(ControleAcademico.getTurmas().get(0).getDisciplina().getNome());
		for (Aluno aluno : ControleAcademico.getTurmas().get(0).getAlunos()) {
			System.out.println(aluno.getNome());
		}
		
		System.out.println("\nQuais as disciplinas de um aluno?");
		for (Disciplina disciplina : ControleAcademico.disciplinasAluno(aluno01)) {
			System.out.println(disciplina.getNome());
		}
		
		System.out.println("\nQual o horário de um aluno?");
		horarioAluno01.horarioAluno();
		
		System.out.println("\nQual o número de alunos de uma disciplina?");
		System.out.println(ControleAcademico.getTurmas().get(0).getDisciplina().getNome());
		System.out.println(ControleAcademico.getTurmas().get(0).getAlunos().size());
	}
}
