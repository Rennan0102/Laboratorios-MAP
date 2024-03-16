package ca;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

public class ControleAcademicoTest {

	static Aluno aluno01;
	static Professor professor01;
	static HorarioAluno horarioAluno01;
	static HorarioProfessor horarioProf01;
	static Turma turma01;
	static LocalDateTime hora01;
	
	@BeforeClass
	public static void criarObjetos() throws TurmaException, DisciplinaException {
		aluno01 = new Aluno("Rennan", "221080074");
		horarioAluno01 = new HorarioAluno(aluno01);
		professor01 = new Professor("Sabrina", "0202");
		horarioProf01 = new HorarioProfessor(professor01);
		
		professor01.adicionarHorario(horarioProf01);
		aluno01.adicionarHorario(horarioAluno01);
		
		hora01 = LocalDateTime.parse("11/12/2024 09:00", Turma.formatoData);
		turma01 = ControleAcademico.criarTurma(professor01, ControleAcademico.criarDisciplina("Cálculo I", "GRAD.01"), hora01, 1);
	}
	
	@Test
	public void criarDisciplinaTest() { // Teste para verificar se a Disciplina foi criada corretamente
		assertEquals(turma01.getDisciplina(), ControleAcademico.getDisciplinas().get(0));
	}
	
	@Test(expected = DisciplinaException.class)
	public void disciplinaExisteTest() throws DisciplinaException {
		ControleAcademico.criarDisciplina("Cálculo I", "GRAD.01");
	}
	
	@Test
	public void criarTurmaTest() {
		assertEquals(turma01, ControleAcademico.getTurmas().get(0));
	}
	
	@Test
	public void matricularAlunoTest() throws TurmaException {
		ControleAcademico.matricularAluno(aluno01, turma01);
		assertEquals(aluno01, turma01.getAlunos().get(0));
	}
	
	@Test(expected = TurmaException.class)
	public void turmaCheiaTest() throws TurmaException {
		ControleAcademico.matricularAluno(aluno01, turma01);
		Aluno aluno02 = new Aluno("Shara", "221080112");
		ControleAcademico.matricularAluno(aluno02, turma01);
	}
	
	/*@Test
	public void removerAlunoTest() throws TurmaException {
		ControleAcademico.matricularAluno(aluno01, turma01);
		ControleAcademico.removerAluno(aluno01, turma01);
		assertEquals(null, turma01.getAlunos().get(0));
	}*/
	
	@Test
	public void disciplinasProfessorTest() {
		ArrayList<Disciplina> disciplinasProf = new ArrayList<Disciplina>();
		
		for(Turma turma : horarioProf01.getTurmasProf()) {
			disciplinasProf.add(turma.getDisciplina());
		}
		
		assertEquals(disciplinasProf, ControleAcademico.disciplinasProfessor(professor01));
	}
	
	@Test
	public void disciplinasAlunoTest() {
		ArrayList<Disciplina> disciplinasAluno = new ArrayList<Disciplina>();
		
		for(Turma turma : horarioAluno01.getTurmasAluno()) {
			disciplinasAluno.add(turma.getDisciplina());
		}
		
		assertEquals(disciplinasAluno, ControleAcademico.disciplinasAluno(aluno01));
	}

}
