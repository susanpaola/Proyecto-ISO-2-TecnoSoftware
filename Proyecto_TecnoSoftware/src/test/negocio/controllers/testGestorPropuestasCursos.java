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
		CursoPropio curso = new CursoPropio(1000, "Curso_Test", 100, "2022-12-20", "2022-12-29", 900.0, 1, "Facultad de ciencias sociales", "76943196M", "25895175N", estado, tipo);
		
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
		CursoPropio curso = new CursoPropio(1001, "Curso_Test", 100, "2022-12-20", "2022-12-29", 900.0, 1, "Facultad de ciencias sociales", "76943196M", "25895175N", estado, tipo);
		
		GestorPropuestasCursos gestor = new GestorPropuestasCursos();
		
		String sql = null;
		try {
			gestor.realizarPropuestaCurso(curso);
			
			curso.setTasaMatricula(700.0);
			
			gestor.editarPropuestaCurso(curso, 0);
			
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
	
	
	@Test
	public void evaluarPropuestaTest() {
		CursoPropioDAO agenteCursoPropioDAO = new CursoPropioDAO();
		EstadoCurso estado = EstadoCurso.PROPUESTA_RECHAZADA;
		TipoCurso tipo = TipoCurso.FORMACION_AVANZADA;
		CursoPropio curso = new CursoPropio(1002, "Curso_Test", 100, "2022-12-20", "2022-12-29", 900.0, 1, "Facultad de ciencias sociales", "76943196M", "25895175N", estado, tipo);
		
		GestorPropuestasCursos gestor = new GestorPropuestasCursos();
		String sql = null;
		try {
			gestor.realizarPropuestaCurso(curso);
			EstadoCurso estadoCurso = gestor.evaluarPropuesta(curso);
			
			int idCurso = curso.getId();
			String estadoCadena = estado.name();
			
			assertTrue(estadoCadena.equals(estadoCurso.name()));
			
			sql = "DELETE FROM CursoPropio WHERE nombre='Curso_Test'";
			agenteCursoPropioDAO.eliminarCurso(sql);
		
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Test
	public void altaCursoAprobadoTest() {
		CursoPropioDAO agenteCursoPropioDAO = new CursoPropioDAO();
		EstadoCurso estado = EstadoCurso.PROPUESTA_RECHAZADA;
		TipoCurso tipo = TipoCurso.FORMACION_AVANZADA;
		CursoPropio curso = new CursoPropio(1003, "Curso_Test", 100, "2022-12-20", "2022-12-29", 900.0, 1, "Facultad de ciencias sociales", "76943196M", "25895175N", estado, tipo);
		
		GestorPropuestasCursos gestor = new GestorPropuestasCursos();
		String sql = null;
		try {
			gestor.realizarPropuestaCurso(curso);
			curso.setEstadoCurso(EstadoCurso.VALIDADO);
			gestor.altaCursoAprobado(curso);
			
			sql = "SELECT estado FROM CursoPropio WHERE nombre='Curso_Test'";
			
			Vector<Object> cursoModificado = agenteCursoPropioDAO.seleccionarCursos(sql);
			
			String nuevoEstadoCadena = cursoModificado.get(0).toString();
			String charsToRemove = "[] ";
			
			for (char c : charsToRemove.toCharArray()) {
				nuevoEstadoCadena = nuevoEstadoCadena.replace(String.valueOf(c), "");
	       	}
			
			assertTrue(nuevoEstadoCadena.equals("VALIDADO"));
			
			sql = "DELETE FROM CursoPropio WHERE nombre='Curso_Test'";
			agenteCursoPropioDAO.eliminarCurso(sql);
		
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
