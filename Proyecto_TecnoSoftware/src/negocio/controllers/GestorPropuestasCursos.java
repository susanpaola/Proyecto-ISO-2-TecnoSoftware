package negocio.controllers;

import java.text.*;
import java.time.*;
import java.util.*;
import negocio.entities.*;

public class GestorPropuestasCursos {
	persistencia.CursoPropioDAO cDAO = new persistencia.CursoPropioDAO();
	/**
	 * 
	 * @param curso
	 * 
	 */
	
	public CursoPropio realizarPropuestaCurso(String centro, String director, String tipo, int id, String nombre,int ects,Date fechaInicio, Date fechaFin, double tasaMatricula, int edicion)  {
	
		
		CursoPropio curso=new CursoPropio(centro,director,tipo,id,nombre,ects,/*fechaInicio,fechaFin,*/tasaMatricula,edicion);
		cDAO.crearNuevoCurso(curso);
		return curso;

	}
	public void editarPropuestaCurso(CursoPropio curso) {
	}
	/**
	 * 
	 * @param curso
	 */
	public EstadoCurso evaluarPropuesta(CursoPropio curso) {
		// TODO - implement GestorPropuestasCursos.evaluarPropuesta
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param curso
	 */
	public void altaCursoAprobado(CursoPropio curso) {
		// TODO - implement GestorPropuestasCursos.altaCursoAprobado
		throw new UnsupportedOperationException();
	}
	
}