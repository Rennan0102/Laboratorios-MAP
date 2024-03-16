package ca;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.BeforeClass;
import org.junit.Test;

public class CoordenacaoTest {
	
	static Coordenacao coordComputacao;
	static Aluno aluno01;
	static Professor professor01;
	static HorarioAluno horarioAluno01;
	static HorarioProfessor horarioProf01;
	static Turma turma01;
	static LocalDateTime hora01;
	
	@BeforeClass
	public static void criarObjetos() throws TurmaException, DisciplinaException, CoordenacaoException {
		coordComputacao = ControleAcademico.criarCoordenacao("Computação", "080");
		
		LocalDateTime hora01 = LocalDateTime.parse("11/12/2024 09:00", Turma.formatoData);
		coordComputacao.cadastroProfessor("Davis");
		professor01 = coordComputacao.getProfessores().get(0);
		coordComputacao.cadastroAluno("Rennan");
		aluno01 = coordComputacao.getAlunos().get(0);
		
		coordComputacao.registrarHorarioProfessor(coordComputacao.getProfessores().get(0));
		horarioProf01 = coordComputacao.getProfessores().get(0).getHorarioProfessor();
		coordComputacao.registrarHorarioAluno(coordComputacao.getAlunos().get(0));
		horarioAluno01 = coordComputacao.getAlunos().get(0).getHorarioAluno();

		turma01 = ControleAcademico.criarTurma(coordComputacao.getProfessores().get(0), ControleAcademico.criarDisciplina("Cálculo I", "GRAD.01"), hora01, 1);
	}
	
	@Test
	public void cadastroAlunoTest() { // Verifica se o Aluno foi cadastrado corretamente
		assertEquals(aluno01, coordComputacao.getAlunos().get(0));
	}
	
	@Test
	public void cadastroProfessorTest() { // Verifica se o Professor foi cadastrado corretamente
		assertEquals(professor01, coordComputacao.getProfessores().get(0));
	}
	
	@Test
	public void registrarHorarioAlunoTest() { // Verifica se o horário foi adicionado corretamente no Aluno
		assertEquals(aluno01, horarioAluno01.getAluno());
	}
	
	@Test
	public void registrarHorarioProfessorTest() { // Verifica se o horário foi adicionado corretamente no Professor
		assertEquals(professor01, horarioProf01.getProfessor());
	}
	
}
