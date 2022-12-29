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
		Date date = new Date(2010,10,10);
		matricula.setFecha(date);
		matricula.setPagado(false);
		matricula.setAtributo("atributo");
		matricula.setIdEstudiante("04258756F");
		matricula.setTipoPago(ModoPago.TARJETA_CREDITO);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetiD() {
		assertEquals(1, matricula.getIdMatricula(), "FALLO");
	}

	@Test
	public void testSetiD() {
		matricula.setIdMatricula(2);
		assertEquals(2, matricula.getIdMatricula(), "FALLO");
	}

	@Test
	public void testGet_fecha() {
		Date date = new Date(2010,10,10);
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
		assertEquals(false, matricula.isPagado(), "FALLO");
	}

	@Test
	public void testSetpagado() {
		matricula.setPagado(true);
		assertEquals(true, matricula.isPagado(), "FALLO");
	}

	@Test
	public void testGetattribute() {
		assertEquals("atributo", matricula.getAtributo(), "FALLO");
	}

	@Test
	public void testSetattribute() {
		matricula.setAtributo("atr");
		assertEquals("atr", matricula.getAtributo(), "FALLO");
	}

	@Test
	public void testGetIdestudiante() {
		assertEquals("01", matricula.getIdEstudiante(), "FALLO");
	}

	@Test
	public void testSetIdestudiante() {
		matricula.setIdEstudiante("02");
		assertEquals("02", matricula.getIdEstudiante(), "FALLO");
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