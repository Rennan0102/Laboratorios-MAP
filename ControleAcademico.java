package ca;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ControleAcademico {
	private static ArrayList<Turma> turmas = new ArrayList<Turma>();
	private static ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
	private static ArrayList<Coordenacao> coordenacoes = new ArrayList<Coordenacao>();
	
	public static Coordenacao criarCoordenacao(String nomeDoCurso, String codigoDoCurso) throws CoordenacaoException {
		Coordenacao newCoordenacao = new Coordenacao(nomeDoCurso, codigoDoCurso);
		
		for (Coordenacao coordenacao : coordenacoes) {
			if (coordenacao.getCodigoDoCurso() == newCoordenacao.getCodigoDoCurso()) {
				throw new CoordenacaoException();
			}
		}
		
		coordenacoes.add(newCoordenacao);
		return newCoordenacao;
	}
	
	public static Disciplina criarDisciplina(String nome, String id) throws DisciplinaException{
		Disciplina newDisciplina = new Disciplina(nome, id);
		
		for (Disciplina disciplina : disciplinas) {
			if (disciplina.getId() == newDisciplina.getId()) {
				throw new DisciplinaException();
			}
		}
		
		disciplinas.add(newDisciplina);
		return newDisciplina;
	}
	
	public static Turma criarTurma(Professor professor, Disciplina disciplina, LocalDateTime horario, int quantidadeMaxima) throws TurmaException {
		for (Turma turma : turmas) {
			if (turma.getHorario() == horario && turma.getProfessor() == professor) {
				throw new TurmaException();
			}
		}
		
		Turma turma = new Turma(professor, disciplina, horario, quantidadeMaxima);
		turmas.add(turma);
		professor.getHorarioProfessor().getTurmasProf().add(turma);
		return turma;
	}
	
	public static void matricularAluno(Aluno aluno, Turma turma) throws TurmaException {
		if (turma.estaCheia()) {
			throw new TurmaException();
		} else {
			for (int i = 0; i < turma.getAlunos().size(); i++) {
				if (turma.getAlunos().get(i).getMatricula() == aluno.getMatricula()) {
					throw new TurmaException();
				}
			}
			
			for (int i = 0; i < aluno.getHorarioAluno().getTurmasAluno().size(); i++) { // Verifica se a nova Turma causa choque de horário com as turmas do horário do Aluno
				if (aluno.getHorarioAluno().getTurmasAluno().get(i).getHorario() == turma.getHorario()) {
					throw new TurmaException();
				}
			}
			
			aluno.getHorarioAluno().getTurmasAluno().add(turma);
			turma.getAlunos().add(aluno);
		}
		
	}
	
	public static void removerAluno(Aluno aluno, Turma turma) throws TurmaException {
		for (int i = 0; i < turma.getAlunos().size(); i++) {
			if (turma.getAlunos().get(i).getMatricula() == aluno.getMatricula()) {
				turma.getAlunos().remove(i);
				return;
			}
		} 
		
		throw new TurmaException();
		
	}
	
	public static ArrayList<Disciplina> disciplinasProfessor(Professor professor){
		ArrayList<Disciplina> disciplinasProf = new ArrayList<Disciplina>();
		
		for(Turma turma : professor.getHorarioProfessor().getTurmasProf()) {
			disciplinasProf.add(turma.getDisciplina());
		}
		return disciplinasProf;
	}
	
	public static ArrayList<Disciplina> disciplinasAluno(Aluno aluno){
		ArrayList<Disciplina> disciplinasAluno = new ArrayList<Disciplina>();
		
		for(Turma turma : aluno.getHorarioAluno().getTurmasAluno()) {
			disciplinasAluno.add(turma.getDisciplina());
		}
		return disciplinasAluno;
	}

	// Getter
	
	protected static ArrayList<Turma> getTurmas() {
		return turmas;
	}

	protected static ArrayList<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	protected static ArrayList<Coordenacao> getCoordenacoes() {
		return coordenacoes;
	}

}
