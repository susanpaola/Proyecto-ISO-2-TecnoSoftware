package test.negocio.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.negocio.entities.Centro;
import main.negocio.entities.Profesor;

class ProfesorTest {

	Profesor profesor = new Profesor("25895175N", "Sergio", "Onís Gómez", false);

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetnombre() {
		String expected = "Sergio";
		String actual = profesor.getNombre();
		assertEquals(expected, actual);
		//fail("Not yet implemented");
	}

	@Test
	public void testGetlocalizacion() {
		String expected = "25895175N";
		String actual = profesor.getDni();
		assertEquals(expected, actual);
		//fail("Not yet implemented");
	}

	@Test
	public void testGetattribute() {
		String expected = "Onís Gómez";
		String actual = profesor.getApellidos();
		assertEquals(expected, actual);
		//assertEquals(expected, actual, 0.0001);
		//fail("Not yet implemented");
	}
	
	@Test
	public void testGetdoctor() {
		boolean expected = false;
		boolean actual = profesor.isDoctor();
		assertEquals(expected, actual);
		//fail("Not yet implemented");
	}

}
