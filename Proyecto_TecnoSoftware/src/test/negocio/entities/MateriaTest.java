package test.negocio.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import main.negocio.entities.Materia;
import main.negocio.entities.Profesor;

public class MateriaTest {

	Materia materia = new Materia("25895175N", "Programacion I", 40, "2022-9-10", "2022-12-22", 2);

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSetnombre() {
		String expected = "Programacion I";
		String actual = materia.getNombre();
		assertEquals(expected, actual);
		//fail("Not yet implemented");
	}

	@Test
	public void testGetresponsable() {
		String expected = "25895175N";
		String actual = materia.getResponsable2();
		assertEquals(expected, actual);
		//fail("Not yet implemented");
	}

	@Test
	public void testGethoras() {
		Double expected = (double)40;
		Double actual = materia.getHoras();
		assertEquals(expected, actual, 0.0001);
		//fail("Not yet implemented");
	}

	@Test
	public void testGetfechaini(){
		String expected = "2022-9-10";
		String actual = materia.getFechaInicio();
		assertEquals(expected, actual);
	}

	@Test
	public void testGetfechafin(){
		String expected = "2022-12-22";
		String actual = materia.getFechaFin();
		assertEquals(expected, actual);
	}

	@Test
	public void testGetcurso() {
		Integer expected = 2;
		Integer actual = materia.getCurso();
		assertEquals(expected, actual);
		//fail("Not yet implemented");
	}
}