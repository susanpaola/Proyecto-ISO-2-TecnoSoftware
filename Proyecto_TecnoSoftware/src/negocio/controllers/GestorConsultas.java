package negocio.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import negocio.entities.*;
import persistencia.CursoPropioDAO;

public class GestorConsultas {

	/**
	 * 
	 * @param tipo
	 * @param fechaInicio
	 * @param fechaFin
	 */
	public List<List<String>> consultarIngresos(TipoCurso tipo, Date fechaInicio, Date fechaFin) {
		// TODO - implement GestorConsultas.consultarIngresos

		List<List<String>> ingreso = new ArrayList<>();
		CursoPropioDAO<CursoPropio> curso = new CursoPropioDAO<>();
		
		ingreso = curso.listarIngresos(tipo, fechaInicio, fechaFin);
		return ingreso;

	}

	/**
	 * 
	 * @param estadoCurso
	 * @param fechaInicio
	 * @param fechaFin
	 */
	public List<CursoPropio> consultarEstadoCursos(EstadoCurso estadoCurso, Date fechaInicio, Date fechaFin) {
		// TODO - implement GestorConsultas.consultarEstadoCursos
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param fechaInicio
	 * @param fechaFin
	 */
	public List<CursoPropio> listarEdicionesCursos(Date fechaInicio, Date fechaFin) {
		// TODO - implement GestorConsultas.listarEdicionesCursos
		throw new UnsupportedOperationException();
	}

}