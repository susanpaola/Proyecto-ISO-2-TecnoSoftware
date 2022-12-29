package test.negocio.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import main.negocio.entities.Estudiante;

public class EstudianteTest {

	Estudiante estudiante = new Estudiante("95174326Q", "Marta", "Villegas Campos", null, null);

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetdni() {
		String expected = "95174326Q";
		String actual = estudiante.getDni();
		assertEquals(expected, actual);
		//fail("Not yet implemented");
	}

    @Test
    public void testGetnombre(){
        String expected = "Marta";
        String actual = estudiante.getNombre();
        assertEquals(expected, actual);
        //fail("Not yet implemented");
    }

    @Test
    public void testGetapellido(){
        String expected = "Villegas Campos";
        String actual = estudiante.getApellidos();
        assertEquals(expected, actual);
        //fail("Not yet implemented");
    }

	@Test
	public void testGettitulacion() {
		String expected = null;
		String actual = estudiante.getTitulacion();
		assertEquals(expected, actual);
		//fail("Not yet implemented");
	}

	@Test
	public void testGetcualificacion() {
		String expected = null;
		String actual = estudiante.getCualificacion();
		assertEquals(expected, actual);
		//fail("Not yet implemented");
	}

}