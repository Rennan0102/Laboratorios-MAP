package ca;

import java.time.LocalDateTime;

public class Main {
	public static void main(String[] args) throws DisciplinaException, TurmaException, CoordenacaoException{
		Coordenacao coordComputacao = ControleAcademico.criarCoordenacao("Computação", "080");
		
		coordComputacao.cadastroProfessor("Davis");
		coordComputacao.cadastroProfessor("Daniel");
		
		LocalDateTime hora01 = LocalDateTime.parse("11/12/2024 09:00", Turma.formatoData);
		LocalDateTime hora02 = LocalDateTime.parse("03/08/2024 14:00", Turma.formatoData);
		
		coordComputacao.cadastroAluno("Rennan");
		coordComputacao.cadastroAluno("Shara");
		
		coordComputacao.registrarHorarioProfessor(coordComputacao.getProfessores().get(0));
		coordComputacao.registrarHorarioProfessor(coordComputacao.getProfessores().get(1));
		
		coordComputacao.registrarHorarioAluno(coordComputacao.getAlunos().get(0));
		coordComputacao.registrarHorarioAluno(coordComputacao.getAlunos().get(1));
		
		Turma turma01 = ControleAcademico.criarTurma(coordComputacao.getProfessores().get(0), ControleAcademico.criarDisciplina("Cálculo I", "GRAD.01"), hora01, 15);
		Turma turma02 = ControleAcademico.criarTurma(coordComputacao.getProfessores().get(1), ControleAcademico.criarDisciplina("MAP", "GRAD.02"), hora02, 10);
		
		ControleAcademico.matricularAluno(coordComputacao.getAlunos().get(0), turma01);
		ControleAcademico.matricularAluno(coordComputacao.getAlunos().get(1), turma01);
		ControleAcademico.matricularAluno(coordComputacao.getAlunos().get(0), turma02);
		
		System.out.println("Quais disciplinas um professor está ministrando?");
		for (Disciplina disciplina : ControleAcademico.disciplinasProfessor(coordComputacao.getProfessores().get(0))) {
			System.out.println(disciplina.getNome());
		}
		
		System.out.println("\nQual o horário de um professor?");
		coordComputacao.getProfessores().get(0).getHorarioProfessor().horarioProf();
		
		System.out.println("\nQuais os alunos de uma dada disciplina?");
		System.out.println(ControleAcademico.getTurmas().get(0).getDisciplina().getNome());
		for (Aluno aluno : ControleAcademico.getTurmas().get(0).getAlunos()) {
			System.out.println(aluno.getNome());
		}
		
		System.out.println("\nQuais as disciplinas de um aluno?");
		for (Disciplina disciplina : ControleAcademico.disciplinasAluno(coordComputacao.getAlunos().get(0))) {
			System.out.println(disciplina.getNome());
		}
		
		System.out.println("\nQual o horário de um aluno?");
		coordComputacao.getAlunos().get(0).getHorarioAluno().horarioAluno();
		
		System.out.println("\nQual o número de alunos de uma disciplina?");
		System.out.println(ControleAcademico.getTurmas().get(0).getDisciplina().getNome());
		System.out.println(ControleAcademico.getTurmas().get(0).getAlunos().size());
	}
}
