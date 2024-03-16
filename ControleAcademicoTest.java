package ca;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

public class ControleAcademicoTest {

	static Coordenacao coordComputacao;
	static Aluno aluno01;
	static Aluno aluno02;
	static Professor professor01;
	static Professor professor02;
	static HorarioAluno horarioAluno01;
	static HorarioProfessor horarioProf01;
	static HorarioProfessor horarioProf02;
	static Turma turma01;
	static Turma turma02;
	static LocalDateTime hora01;
	
	@BeforeClass
	public static void criarObjetos() throws TurmaException, DisciplinaException, CoordenacaoException {
		coordComputacao = ControleAcademico.criarCoordenacao("Computação", "080");
		
		LocalDateTime hora01 = LocalDateTime.parse("11/12/2024 09:00", Turma.formatoData);
		coordComputacao.cadastroProfessor("Davis");
		coordComputacao.cadastroProfessor("Sabrina");
		professor01 = coordComputacao.getProfessores().get(0);
		professor02 = coordComputacao.getProfessores().get(1);
		
		coordComputacao.cadastroAluno("Rennan");
		aluno01 = coordComputacao.getAlunos().get(0);
		coordComputacao.cadastroAluno("Shara");
		aluno02 = coordComputacao.getAlunos().get(1);
		
		coordComputacao.registrarHorarioProfessor(coordComputacao.getProfessores().get(0));
		horarioProf01 = coordComputacao.getProfessores().get(0).getHorarioProfessor();
		coordComputacao.registrarHorarioProfessor(coordComputacao.getProfessores().get(1));
		horarioProf02 = coordComputacao.getProfessores().get(1).getHorarioProfessor();
		
		coordComputacao.registrarHorarioAluno(coordComputacao.getAlunos().get(0));
		horarioAluno01 = coordComputacao.getAlunos().get(0).getHorarioAluno();

		turma01 = ControleAcademico.criarTurma(coordComputacao.getProfessores().get(0), ControleAcademico.criarDisciplina("Cálculo I", "GRAD.01"), hora01, 1);
		turma02 = ControleAcademico.criarTurma(coordComputacao.getProfessores().get(1), ControleAcademico.criarDisciplina("MAP", "GRAD.02"), hora01, 1);
	}
	
	@Test
	public void criarCoordenacoesTest() { // Verifica se a Coordenação foi criada corretamente
		assertEquals(coordComputacao.getNome(), ControleAcademico.getCoordenacoes().get(0).getNome());
	}
	
	@Test
	public void criarDisciplinaTest() { // Teste para verificar se a Disciplina foi criada corretamente
		assertEquals(turma01.getDisciplina(), ControleAcademico.getDisciplinas().get(0));
	}
	
	@Test(expected = DisciplinaException.class)
	public void disciplinaExisteTest() throws DisciplinaException { // Verifica se a Disciplina já existe
		ControleAcademico.criarDisciplina("Cálculo I", "GRAD.01");
	}
	
	@Test
	public void criarTurmaTest() { // Verifica se a Turma foi criada corretamente
		assertEquals(turma01, ControleAcademico.getTurmas().get(0));
	}
	
	@Test
	public void matricularAlunoTest() throws TurmaException { // Verifica se o Aluno foi matriculado corretamente
		ControleAcademico.matricularAluno(aluno01, turma01);
		assertEquals(aluno01, turma01.getAlunos().get(0));
	}
	
	@Test(expected = TurmaException.class)
	public void choqueHorarioAlunoTest() throws TurmaException { // Testa se está colocando duas turmas em um mesmo horário de um Aluno
		ControleAcademico.matricularAluno(aluno01, turma02);
	}
	
	@Test(expected = TurmaException.class)
	public void choqueHorarioProfessorTest() throws TurmaException { // Testa se está criando o mesmo horário com o mesmo Professor
		ControleAcademico.criarTurma(professor01, ControleAcademico.getDisciplinas().get(0), hora01, 5);
		ControleAcademico.criarTurma(professor01, ControleAcademico.getDisciplinas().get(0), hora01, 5);
	}
	
	@Test(expected = TurmaException.class)
	public void turmaCheiaTest() throws TurmaException { // Adicionando um Aluno em uma turma que está cheia
		ControleAcademico.matricularAluno(aluno02, turma01);
	}
	
	@Test(expected = TurmaException.class)
	public void removerAlunoTest() throws TurmaException { // Removendo um Aluno de uma turma sem Aluno
		ControleAcademico.removerAluno(aluno01, turma01);
		ControleAcademico.removerAluno(aluno01, turma01);
	}
	
	@Test
	public void disciplinasProfessorTest() { // Verifica se as disciplinas do Professor foram adicionadas corretamente
		ArrayList<Disciplina> disciplinasProf = new ArrayList<Disciplina>();
		
		for(Turma turma : coordComputacao.getProfessores().get(0).getHorarioProfessor().getTurmasProf()) {
			disciplinasProf.add(turma.getDisciplina());
		}
		
		assertEquals(disciplinasProf, ControleAcademico.disciplinasProfessor(professor01));
	}
	
	@Test
	public void disciplinasAlunoTest() { // Verifica se as disciplinas do Aluno foram adicionadas corretamente
		ArrayList<Disciplina> disciplinasAluno = new ArrayList<Disciplina>();
		
		for(Turma turma : coordComputacao.getAlunos().get(0).getHorarioAluno().getTurmasAluno()) {
			disciplinasAluno.add(turma.getDisciplina());
		}
		
		assertEquals(disciplinasAluno, ControleAcademico.disciplinasAluno(aluno01));
	}

}
