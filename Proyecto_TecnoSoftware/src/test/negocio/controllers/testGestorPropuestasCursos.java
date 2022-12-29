package test.negocio.controllers;
import main.negocio.controllers.GestorMatriculacion;
import main.negocio.controllers.GestorPropuestasCursos;
import main.negocio.entities.*;
import main.persistencia.CursoPropioDAO;
import main.persistencia.MatriculaDAO;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Vector;

import org.junit.jupiter.api.Test;

class testGestorPropuestasCursos {

	@Test
	public void realizarPropuestaCursoTest() {
		CursoPropioDAO agenteCursoPropioDAO = new CursoPropioDAO();
		EstadoCurso estado = EstadoCurso.PROPUESTA_RECHAZADA;
		TipoCurso tipo = TipoCurso.FORMACION_AVANZADA;
		CursoPropio curso = new CursoPropio(100, "Curso_Test", 100, "2022-12-20", "2022-12-29", 900.0, 1, "Facultad de ciencias sociales", "76943196M", "25895175N", estado, tipo);
		
		GestorPropuestasCursos gestor = new GestorPropuestasCursos();
		
		String sql = "SELECT * FROM CursoPropio";
		
		try {
			Vector<Object> cursosAntes = agenteCursoPropioDAO.seleccionarCursos(sql);
		
			gestor.realizarPropuestaCurso(curso);
			
			Vector<Object> cursosDespues = agenteCursoPropioDAO.seleccionarCursos(sql);
			
			assertTrue(cursosDespues.size()==cursosAntes.size()+1);
		
			sql = "DELETE FROM CursoPropio WHERE nombre='Curso_Test'";
			agenteCursoPropioDAO.eliminarCurso(sql);
		
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Test
	public void editarPropuestaCursoTest() {
		CursoPropioDAO agenteCursoPropioDAO = new CursoPropioDAO();
		EstadoCurso estado = EstadoCurso.PROPUESTA_RECHAZADA;
		TipoCurso tipo = TipoCurso.FORMACION_AVANZADA;
		CursoPropio curso = new CursoPropio(101, "Curso_Test", 100, "2022-12-20", "2022-12-29", 900.0, 1, "Facultad de ciencias sociales", "76943196M", "25895175N", estado, tipo);
		
		GestorPropuestasCursos gestor = new GestorPropuestasCursos();
		
		String sql = null;
		try {
			gestor.realizarPropuestaCurso(curso);
			
			curso.setTasaMatricula(700.0);
			
			gestor.editarPropuestaCurso(curso);
			
			sql = "SELECT tasa FROM CursoPropio WHERE nombre='Curso_Test'";
			Vector<Object> cursoModificado = agenteCursoPropioDAO.seleccionarCursos(sql);
			
			String nuevaTasaCadena = cursoModificado.get(0).toString();
			String charsToRemove = "[] ";
			
			for (char c : charsToRemove.toCharArray()) {
				nuevaTasaCadena = nuevaTasaCadena.replace(String.valueOf(c), "");
	       	}
			
			double nuevaTasa = Double.parseDouble(nuevaTasaCadena);
			
			assertTrue(700.0==nuevaTasa);
			
			sql = "DELETE FROM CursoPropio WHERE nombre='Curso_Test'";
			agenteCursoPropioDAO.eliminarCurso(sql);
		
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/*
	@Test
	public void evaluarPropuestaTest() {
		CursoPropioDAO agenteCursoPropioDAO = new CursoPropioDAO();
		EstadoCurso estado = EstadoCurso.PROPUESTA_RECHAZADA;
		TipoCurso tipo = TipoCurso.FORMACION_AVANZADA;
		CursoPropio curso = new CursoPropio(101, "Curso_Test", 100, "2022-12-20", "2022-12-29", 900.0, 1, "Facultad de ciencias sociales", "76943196M", "25895175N", estado, tipo);
		
		GestorPropuestasCursos gestor = new GestorPropuestasCursos();
		String sql = null;
		try {
			
			
			sql = "DELETE FROM CursoPropio WHERE nombre='Curso_Test'";
			agenteCursoPropioDAO.eliminarCurso(sql);
		
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	*/
	
	@Test
	public void testRealizarMatriculacion() throws Exception {
		MatriculaDAO agenteMatriculaDAO = new MatriculaDAO();
		Matricula matricula = new Matricula(1000, "2022-12-28", true, 15, ModoPago.TARJETA_CREDITO, 2, "04258756F");
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
}