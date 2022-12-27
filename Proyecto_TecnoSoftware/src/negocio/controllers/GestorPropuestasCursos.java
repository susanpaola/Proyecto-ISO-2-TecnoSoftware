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
			String sql = "SELECT estado FROM CursoPropio WHERE id=" + curso.getId();
			Vector<Object> res = agenteCursoPropioDAO.seleccionarCursos(sql);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		String estado = res.get(0).toString();
		String charsToRemove = "[]";
			 
	        for (char c : charsToRemove.toCharArray()) {
	            estado = estado.replace(String.valueOf(c), "");
		}
		
		EstadoCurso ec = null;
		switch(estado) {
			case "PROPUESTO":
				ec = EstadoCurso.PROPUESTO;
				break;
			case "VALIDADO":
				ec = EstadoCurso.VALIDADO;
				break;
			case "PROPUESTA_RECHAZADA":
				ec = EstadoCurso.PROPUESTA_RECHAZADA;
				break;
			case "EN_MATRICULACION":
				ec = EstadoCurso.EN_MATRICULACION;
				break;
			case "EN_IMPARTIZICION":
				ec = EstadoCurso.EN_IMPARTIZICION;
				break;
			case "TERMINADO":
				ec = EstadoCurso.TERMINADO;
				break;
		}
		return ec;
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
