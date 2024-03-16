package ca;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AlunoTest {
	Aluno aluno01;
	HorarioAluno horarioAluno01;

	@Before
	public void criarObjetos() {
		aluno01 = new Aluno("Rennan", "221080074");
		horarioAluno01 = new HorarioAluno(aluno01);
	}
	
	@Test
	public void adicionarHorarioTest() { // Teste para verficicar se o Horário foi adicionado corretamente no Aluno
		aluno01.adicionarHorario(horarioAluno01);
		assertEquals(horarioAluno01, aluno01.getHorarioAluno());
	}

}
