package test.negocio.entities;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import main.negocio.entities.Centro;

public class CentroTest {

	Centro centro = new Centro("Facultad de ciencias sociales", "Talavera de la Reina", 13);

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetnombre() {
		String expected = "Facultad de ciencias sociales";
		String actual = centro.getNombre();
		assertEquals(expected, actual);
		//fail("Not yet implemented");
	}

	@Test
	public void testGetlocalizacion() {
		String expected = "Talavera de la Reina";
		String actual = centro.getLocalizacion();
		assertEquals(expected, actual);
		//fail("Not yet implemented");
	}

	@Test
	public void testGetattribute() {
		Integer expected = 13;
		Integer actual = centro.getAttribute();
		assertEquals(expected, actual);
		//assertEquals(expected, actual, 0.0001);
		//fail("Not yet implemented");
	}


}
