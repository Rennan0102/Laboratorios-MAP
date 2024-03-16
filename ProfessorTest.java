package ca;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProfessorTest {

	Professor professor01;
	HorarioProfessor horarioProf01;
	
	@Before
	public void criarObjetos() {
		professor01 = new Professor("Sabrina", "0202");
		horarioProf01 = new HorarioProfessor(professor01);
	}
	
	@Test
	public void adicionarHorarioTest() { // Teste para verficicar se o Horário foi adicionado corretamente no Professor
		professor01.adicionarHorario(horarioProf01);
		assertEquals(horarioProf01, professor01.getHorarioProfessor());
	}

}
