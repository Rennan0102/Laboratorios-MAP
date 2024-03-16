package ca;

import java.util.ArrayList;

public class Coordenacao {
	private ArrayList<Professor> professores;
	private ArrayList<Aluno> alunos;
	private String nome, codigoDoCurso;
	private static int matriculaAluno;
	private static int matriculaProfessor;
	
	protected Coordenacao(String nome, String codigoDoCurso) {
		this.nome = nome;
		this.codigoDoCurso = codigoDoCurso;
		professores = new ArrayList<Professor>();
		alunos = new ArrayList<Aluno>();
	}
	
	public void cadastroAluno(String nome) {
		matriculaAluno++;
		Aluno aluno = new Aluno(nome, codigoDoCurso + String.valueOf(matriculaAluno));
		alunos.add(aluno);
	}
	
	public void cadastroProfessor(String nome) {
		matriculaProfessor++;
		Professor professor = new Professor(nome, String.valueOf(matriculaProfessor));
		professores.add(professor);
	}
	
	public void registrarHorarioAluno(Aluno aluno) {
		HorarioAluno horarioAluno = new HorarioAluno(aluno);
		aluno.adicionarHorario(horarioAluno);
	}
	
	public void registrarHorarioProfessor(Professor professor) {
		HorarioProfessor horarioProfessor = new HorarioProfessor(professor);
		professor.adicionarHorario(horarioProfessor);
	}
	
	// Getters

	protected ArrayList<Professor> getProfessores() {
		return professores;
	}

	protected ArrayList<Aluno> getAlunos() {
		return alunos;
	}

	protected String getNome() {
		return nome;
	}

	protected String getCodigoDoCurso() {
		return codigoDoCurso;
	}
	
}
