package ca;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProfessorTest {

	Coordenacao coordComputacao;
	Professor professor01;
	HorarioProfessor horarioProf01;
	
	@Before
	public void criarObjetos() throws CoordenacaoException {
		coordComputacao = ControleAcademico.criarCoordenacao("Computação", "080");
		
		coordComputacao.cadastroProfessor("Davis");
		professor01 = coordComputacao.getProfessores().get(0);
		
		coordComputacao.registrarHorarioProfessor(coordComputacao.getProfessores().get(0));
		horarioProf01 = coordComputacao.getProfessores().get(0).getHorarioProfessor();
	}
	
	@Test
	public void adicionarHorarioTest() { // Teste para verficicar se o Horário foi adicionado corretamente no Professor
		professor01.adicionarHorario(horarioProf01);
		assertEquals(horarioProf01, professor01.getHorarioProfessor());
	}

}
