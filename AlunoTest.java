package ca;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AlunoTest {
	
	Coordenacao coordComputacao;
	Aluno aluno01;
	HorarioAluno horarioAluno01;

	@Before
	public void criarObjetos() throws CoordenacaoException {
		coordComputacao = ControleAcademico.criarCoordenacao("Computação", "080");

		coordComputacao.cadastroAluno("Rennan");
		aluno01 = coordComputacao.getAlunos().get(0);
		
		coordComputacao.registrarHorarioAluno(coordComputacao.getAlunos().get(0));
		horarioAluno01 = coordComputacao.getAlunos().get(0).getHorarioAluno();
	}
	
	@Test
	public void adicionarHorarioTest() { // Teste para verficicar se o Horário foi adicionado corretamente no Aluno
		aluno01.adicionarHorario(horarioAluno01);
		assertEquals(horarioAluno01, aluno01.getHorarioAluno());
	}

}
