package test.negocio.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.charset.Charset;
import java.time.LocalDate;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import main.negocio.entities.Matricula;
import main.negocio.entities.ModoPago;

public class MatriculaTest {

	Matricula matricula;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		matricula = new Matricula();
		matricula.setIdMatricula(3);
		@SuppressWarnings("deprecation")
		Date date = new Date(2022,12,28);
		matricula.setFecha(date);
		matricula.setPagado(true);
		matricula.setAtributo("15");
		matricula.setIdEstudiante("04258756F");
		matricula.setTipoPago(ModoPago.TARJETA_CREDITO);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetiD() {
		assertEquals(3, matricula.getIdMatricula(), "FALLO");
	}

	@Test
	public void testSetiD() {
		matricula.setIdMatricula(2);
		assertEquals(2, matricula.getIdMatricula(), "FALLO");
	}

	@Test
	public void testGetfecha() {
		Date date = new Date(2022,12,28);
		assertEquals(date, matricula.getFecha(), "FALLO");
	}

	@Test
	public void testSetfecha() {
		Date date = new Date(2005,5,5);
		matricula.setFecha(date);
		assertEquals(date, matricula.getFecha(), "FALLO");
	}

	@Test
	public void testIspagado() {
		assertEquals(true, matricula.isPagado(), "FALLO");
	}

	@Test
	public void testSetpagado() {
		matricula.setPagado(false);
		assertEquals(false, matricula.isPagado(), "FALLO");
	}

	@Test
	public void testGetattribute() {
		assertEquals("15", matricula.getAtributo(), "FALLO");
	}

	@Test
	public void testSetattribute() {
		matricula.setAtributo("6");
		assertEquals("6", matricula.getAtributo(), "FALLO");
	}

	@Test
	public void testGetIdestudiante() {
		assertEquals("04258756F", matricula.getIdEstudiante(), "FALLO");
	}

	@Test
	public void testSetIdestudiante() {
		matricula.setIdEstudiante("04258755T");
		assertEquals("04258755T", matricula.getIdEstudiante(), "FALLO");
	}

	@Test
	public void testGettipoPago() {
		assertEquals(ModoPago.TARJETA_CREDITO, matricula.getTipoPago(), "FALLO");
	}

	@Test
	public void testSettipoPago() {
		matricula.setTipoPago(ModoPago.TRANSFERENCIA);
		assertEquals(ModoPago.TRANSFERENCIA, matricula.getTipoPago(), "FALLO");
	}
}