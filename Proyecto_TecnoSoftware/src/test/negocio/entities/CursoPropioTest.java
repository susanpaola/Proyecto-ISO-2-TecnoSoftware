package test.negocio.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import main.negocio.entities.CursoPropio;
import main.negocio.entities.EstadoCurso;
import main.negocio.entities.Matricula;
import main.negocio.entities.ModoPago;
import main.negocio.entities.TipoCurso;

class CursoPropioTest {

	CursoPropio cursopropio;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		cursopropio = new CursoPropio();
		cursopropio.setId(2);
		cursopropio.setNombre("Ingeniería Informática");
		cursopropio.setECTS(30);
		String date = "2022-09-10";
		cursopropio.setFechaInicio(date);
		cursopropio.setFechaFin(date);
		cursopropio.setTasaMatricula(1100.5);
		cursopropio.setEdicion(1);
		Matricula m = new Matricula();
		List<Matricula> matriculas = new ArrayList<Matricula>();
		matriculas.add(m);
		cursopropio.setCentro("Facultad de ciencias sociales");
		cursopropio.setDirector("96315247O");
		cursopropio.setSecretario("25895175N");
		cursopropio.setEstadoCurso(EstadoCurso.VALIDADO);
		cursopropio.setTipoCurso(TipoCurso.FORMACION_AVANZADA);
	}

	@After
	public void tearDown() throws Exception {
	}
	@Test
	public void testGetIdcentro() {
		assertEquals("Facultad de ciencias sociales", cursopropio.getCentro(), "FALLO");
	}

	@Test
	public void testSetIdcentro() {
		cursopropio.setCentro("Facultad de ciencias sociales");
		assertEquals(2, cursopropio.getCentro(), "FALLO");
	}

	@Test
	public void testGetIddirector() {
		assertEquals("96315247O", cursopropio.getDirector(), "FALLO");
	}


	@Test
	public void testSetIddirector() {
		cursopropio.setDirector("0233236524R");
		assertEquals("0233236524R", cursopropio.getDirector(), "FALLO");
	}

	@Test
	public void testGetIdsecretario() {
		assertEquals("25895175N", cursopropio.getSecretario(), "FALLO");
	}

	@Test
	public void testSetIdsecretario() {
		cursopropio.setSecretario("88725643H");
		assertEquals("88725643H", cursopropio.getSecretario(), "FALLO");
	}

	@Test
	public void testGetestado() {
		assertEquals(EstadoCurso.VALIDADO, cursopropio.getEstadoCurso(), "FALLO");
	}

	@Test
	public void testSetestado() {
		cursopropio.setEstadoCurso(EstadoCurso.TERMINADO);
		assertEquals(EstadoCurso.TERMINADO, cursopropio.getEstadoCurso(), "FALLO");
	}

	@Disabled
	public void testGettipo() {
		assertEquals(TipoCurso.FORMACION_AVANZADA, cursopropio.getTipoCurso(), "FALLO");
	}

	@Disabled
	public void testSettipo() {
		cursopropio.setTipoCurso(TipoCurso.EXPERTO);
		assertEquals(TipoCurso.EXPERTO, cursopropio.getTipoCurso(), "FALLO");
	}

	@Disabled
	public void testCursoPropio() {
		fail("Not yet implemented");
	}

	@Disabled
	public void testCursoPropioString() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetid() {
		assertEquals(2, cursopropio.getId(), "FALLO");
	}

	@Test
	public void testSetid() {
		cursopropio.setId(7);
		assertEquals(7, cursopropio.getId(), "FALLO");
	}

	@Test
	public void testGetnombre() {
		assertEquals("Ingeniería Informática", cursopropio.getNombre(), "FALLO");
	}

	@Test
	public void testSetnombre() {
		cursopropio.setNombre("Derecho");
		assertEquals("Derecho", cursopropio.getNombre(), "FALLO");
	}

	@Test
	public void testGetECTS() {
		assertEquals(30, cursopropio.getECTS(), "FALLO");
	}

	@Test
	public void testSeteCTS() {
		cursopropio.setECTS(11);
		assertEquals(11, cursopropio.getECTS(), "FALLO");
	}

	@Test
	public void testGetfechaInicio() {
		String date = "2022-09-10";
		assertEquals(date, cursopropio.getFechaInicio(), "FALLO");

	}

	@Test
	public void testSetfechaInicio() {
		String date = "2021-09-25";
		cursopropio.setFechaInicio(date);
		assertEquals(date, cursopropio.getFechaInicio(), "FALLO");
	}

	@Test
	public void testGetfechaFin() {
		String date = "2022-09-10";
		assertEquals(date, cursopropio.getFechaFin(), "FALLO");
	}

	@Test
	public void testSetfechaFin() {
		String date = "2012-01-23";
		cursopropio.setFechaFin(date);
		assertEquals(date, cursopropio.getFechaFin(), "FALLO");
	}

	@Test
	public void testGettasaMatricula() {
		assertEquals(1100.5, cursopropio.getTasaMatricula(), "FALLO");
	}

	@Test
	public void testSettasaMatricula() {
		cursopropio.setTasaMatricula(255.5);
		assertEquals(255.5, cursopropio.getTasaMatricula(), "FALLO");
	}

	@Test
	public void testGetedicion() {
		assertEquals(1, cursopropio.getEdicion(), "FALLO");
	}

	@Test
	public void testSet_edicion() {
		cursopropio.setEdicion(2);
		assertEquals(2, cursopropio.getEdicion(), "FALLO");
	}
}
