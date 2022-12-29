package test.negocio.controllers;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import main.negocio.controllers.GestorMatriculacion;
import main.negocio.entities.CursoPropio;
import main.negocio.entities.Estudiante;
import main.negocio.entities.Matricula;
import main.negocio.entities.ModoPago;
import main.persistencia.MatriculaDAO;

class testGestorMatriculacion {

	@Test
	public void testRealizarMatriculacion() throws Exception {
		MatriculaDAO agenteMatriculaDAO = new MatriculaDAO();
		Matricula matricula = new Matricula(3, "2022-12-28", true, 15, ModoPago.TARJETA_CREDITO, 2, "04258756F");
		GestorMatriculacion gestor = new GestorMatriculacion();

		String sql = "SELECT * FROM Matricula";
		try {
		Vector<Object> listarMatriculasAntes = agenteMatriculaDAO.selectMatriculas(sql);
		gestor.realizarMatriculacion(matricula);

		Vector<Object> listarMatriculasDespues = agenteMatriculaDAO.selectMatriculas(sql);
		assertTrue(listarMatriculasDespues.size() == listarMatriculasAntes.size() + 1);

		sql = "DELETE FROM Matricula WHERE id=3";
		agenteMatriculaDAO.deleteMatricula(sql);
		
		} catch(Exception e) {
			System.out.println(e);
		}
	

	}

}
