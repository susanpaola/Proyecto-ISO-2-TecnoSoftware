package negocio.controllers;

import java.text.*;
import java.time.*;
import java.util.*;

import negocio.entities.*;
import persistencia.*;

public class GestorPropuestasCursos {

	public void realizarPropuestaCurso(CursoPropio curso) {
		CursoPropioDAO agenteCursoPropioDAO = new CursoPropioDAO();
		
		try {
			String sql = "INSERT INTO CursoPropio VALUES (" + curso.getId() + ",'" + curso.getNombre() + "'," + curso.getECTS() + ",'" + curso.getFechaInicio() + "','" + curso.getFechaFin() + "'," + curso.getTasaMatricula() + "," + curso.getEdicion() + ",'" + curso.getCentro() + "','" + curso.getDirector() + "','" + curso.getSecretario() + "','" + curso.getEstadoCurso().toString() + "','" + curso.getTipoCurso().toString() + "')";
			agenteCursoPropioDAO.insertarCurso(sql);
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void editarPropuestaCurso(CursoPropio curso) {
		CursoPropioDAO agenteCursoPropioDAO = new CursoPropioDAO();
		
		try {
			String sql = "UPDATE CursoPropio SET nombre='" + curso.getNombre() + "', ECTS=" + curso.getECTS() + ", fechaIni='" + curso.getFechaInicio() + "', fechaFin='" + curso.getFechaFin() + "', tasa=" + curso.getTasaMatricula() + ", edicion=" + curso.getEdicion() + ", centro='" + curso.getCentro() + "', director='" + curso.getDirector() + "', secretario='" + curso.getSecretario() + "', estado='" + curso.getEstadoCurso().toString() + "', tipo='" + curso.getTipoCurso().toString() + "' WHERE id=" + curso.getId();
			agenteCursoPropioDAO.editarCurso(sql);
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public EstadoCurso evaluarPropuesta(CursoPropio curso) {
		CursoPropioDAO agenteCursoPropioDAO = new CursoPropioDAO();
		
		try {
			String sql = "SELECT * FROM CursoPropio WHERE id=" + curso.getId();
			Vector<Object> = agenteCursoPropioDAO.seleccionarCursos(sql);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}

	public void altaCursoAprobado(CursoPropio curso) {
		CursoPropioDAO agenteCursoPropioDAO = new CursoPropioDAO();
		
		try {
			String sql = "UPDATE CursoPropio SET estado='" + curso.getEstadoCurso().toString() + "' WHERE id=" + curso.getId();
			agenteCursoPropioDAO.editarCurso(sql);
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
