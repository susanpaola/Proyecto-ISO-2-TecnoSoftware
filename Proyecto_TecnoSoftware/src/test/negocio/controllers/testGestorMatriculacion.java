package test.negocio.controllers;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Vector;

import org.junit.jupiter.api.Test;

import main.negocio.controllers.GestorMatriculacion;
import main.negocio.entities.Matricula;
import main.negocio.entities.ModoPago;
import main.persistencia.MatriculaDAO;

public class testGestorMatriculacion {
	@Test
	public void realizarMatriculacionTest() {
		MatriculaDAO agenteMatriculaDAO = new MatriculaDAO();
		Matricula matricula = new Matricula(1000, "2022-12-28", false, 15, ModoPago.TRANSFERENCIA, 3, "04258756F");
		GestorMatriculacion gestor = new GestorMatriculacion();

		String sql = "SELECT * FROM Matricula";
		try {
		Vector<Object> listarMatriculasAntes = agenteMatriculaDAO.selectMatriculas(sql);
		gestor.realizarMatriculacion(matricula);

		Vector<Object> listarMatriculasDespues = agenteMatriculaDAO.selectMatriculas(sql);
		assertTrue(listarMatriculasDespues.size() == listarMatriculasAntes.size() + 1);

		sql = "DELETE FROM Matricula WHERE id=1000";
		agenteMatriculaDAO.deleteMatricula(sql);
		
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	@Test
	public void realizarPagoTest() {
		MatriculaDAO agenteMatriculaDAO = new MatriculaDAO();
		Matricula matricula = new Matricula(1001, "2022-12-28", false, 15, ModoPago.TRANSFERENCIA, 3, "04258756F");
		GestorMatriculacion gestor = new GestorMatriculacion();
		
		String sql = null;
		try {
			gestor.realizarMatriculacion(matricula);
			matricula.setPagado(true);
			gestor.realizarPago(matricula);
			
			sql = "SELECT pagado FROM Matricula WHERE id=1001";
			
			Vector<Object> matriculaModificada = agenteMatriculaDAO.selectMatriculas(sql);
			
			String nuevoPagoCadena = matriculaModificada.get(0).toString();
			String charsToRemove = "[] ";
			
			for (char c : charsToRemove.toCharArray()) {
				nuevoPagoCadena = nuevoPagoCadena.replace(String.valueOf(c), "");
	       	}
			
			boolean nuevoPago = Boolean.parseBoolean(nuevoPagoCadena);
			
			assertTrue(true==nuevoPago);
			
			sql = "DELETE FROM Matricula WHERE id=1001";
			agenteMatriculaDAO.deleteMatricula(sql);
			
			} catch(Exception e) {
				System.out.println(e);
			}
	}
}
