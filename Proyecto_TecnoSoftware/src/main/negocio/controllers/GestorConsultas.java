package main.negocio.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import main.negocio.entities.*;
import main.persistencia.CursoPropioDAO;

public class GestorConsultas {

	/**
	 * 
	 * @param tipo
	 * @param fechaInicio
	 * @param fechaFin
	 */
	public double consultarIngresos(TipoCurso tipo, String fechaInicio, String fechaFin) {
		double ganancia = 0.00;
		String charsToRemove = "[] ";
			
		String sql = "SELECT * FROM CursoPropio WHERE tipo='" + tipo.toString() + "' AND fechaIni >='" + fechaInicio + "' AND fechaFin <='" + fechaFin + "' AND estado='VALIDADO'";
		Vector<Object> vectorCursos = new Vector<Object>();
		CursoPropioDAO cursoDAO = new CursoPropioDAO();
		try {
			vectorCursos = cursoDAO.seleccionarCursos(sql);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		for (int i = 0; i < vectorCursos.size(); i++) {
			String curso = vectorCursos.get(i).toString();
				 
		       	for (char c : charsToRemove.toCharArray()) {
		        	curso = curso.replace(String.valueOf(c), "");
			}
		       
		        String[] parts = curso.split(",");
		        int id = Integer.parseInt(parts[0]);
		        double tasa = Double.parseDouble(parts[5]);
		        
		        String sql2 = "SELECT COUNT(*) FROM Matricula WHERE titulo=" + id;
		        Vector<Object> vectorMatriculas = new Vector<Object>();
			try {
				vectorMatriculas = cursoDAO.seleccionarCursos(sql2);
			} catch (Exception e) {
				System.out.println(e);
			}
			
			String num_matriculas = vectorMatriculas.get(0).toString();
				 
		        for (char c : charsToRemove.toCharArray()) {
		        	num_matriculas = num_matriculas.replace(String.valueOf(c), "");
		        }
		        
		        int num = Integer.parseInt(num_matriculas);
				ganancia += tasa * num;
		}
		
		return ganancia;		
	}

	/**
	 * 
	 * @param estadoCurso
	 * @param fechaInicio
	 * @param fechaFin
	 */
	public List<CursoPropio> consultarEstadoCursos(EstadoCurso estado, String fechaInicio, String fechaFin) {
		String charsToRemove = "[] ";
		List<CursoPropio> listaEstadoCurso = new ArrayList<>();
		String sql = "SELECT * FROM CursoPropio WHERE estado='" + estado.toString() + "' AND fechaIni >='" + fechaInicio + "' AND fechaFin <='" + fechaFin + "'";
		Vector<Object> vectorCursos = new Vector<Object>();
		CursoPropioDAO cursoDAO = new CursoPropioDAO();
		try {
			vectorCursos = cursoDAO.seleccionarCursos(sql);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		for (int i = 0; i < vectorCursos.size(); i++) {
			String curso = vectorCursos.get(i).toString();
				 
		       	for (char c : charsToRemove.toCharArray()) {
		        	curso = curso.replace(String.valueOf(c), "");
			}
		       
		        String[] parts = curso.split(",");
			
			int id = Integer.parseInt(parts[0]);
			String nombre = parts[1];
			int ECTS = Integer.parseInt(parts[2]);
			String fechaIni = parts[3];
			String fechaFinParts = parts[4];
			double tasa = Double.parseDouble(parts[5]);
			int edicion = Integer.parseInt(parts[6]);
			String centro = parts[7];
			String director = parts[8];
			String secretario = parts[9];
			String tipoCurso = parts[11];
			
			TipoCurso tipo = null;
			switch(tipoCurso) {
				case "MASTER":
					tipo = TipoCurso.MASTER;
					break;
				case "EXPERTO":
					tipo = TipoCurso.EXPERTO;
					break;
				case "ESPECIALISTA":
					tipo = TipoCurso.ESPECIALISTA;
					break;
				case "FORMACION_AVANZADA":
					tipo = TipoCurso.FORMACION_AVANZADA;
					break;
				case "FORMACION_CONTINUA":
					tipo = TipoCurso.FORMACION_CONTINUA;
					break;
				case "MICROCREDENCIALES":
					tipo = TipoCurso.MICROCREDENCIALES;
					break;
				case "CORTA_DURACION":
					tipo = TipoCurso.CORTA_DURACION;
					break;
			}
			
			CursoPropio cursoCreado = new CursoPropio(id, nombre, ECTS, fechaIni, fechaFinParts, tasa, edicion, centro, director, secretario, estado, tipo);
			listaEstadoCurso.add(cursoCreado);
		}
		
		return listaEstadoCurso;
	}

	/**
	 * 
	 * @param fechaInicio
	 * @param fechaFin
	 */
	public List<CursoPropio> listarEdicionesCursos(String fechaInicio, String fechaFin) {
		List<CursoPropio> listaEdicionesCurso = new ArrayList<>();
		CursoPropioDAO cursoDAO = new CursoPropioDAO();
		
		String charsToRemove = "[] ";
		String sql = "SELECT * FROM CursoPropio WHERE fechaIni >='" + fechaInicio + "' AND fechaFin <='" + fechaFin + "'";
		Vector<Object> vectorCursos = new Vector<Object>();
		try {
			vectorCursos = cursoDAO.seleccionarCursos(sql);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		for (int i = 0; i < vectorCursos.size(); i++) {
			String curso = vectorCursos.get(i).toString();
				 
		       	for (char c : charsToRemove.toCharArray()) {
		        	curso = curso.replace(String.valueOf(c), "");
			}
		       
		        String[] parts = curso.split(",");
			
			int id = Integer.parseInt(parts[0]);
			String nombre = parts[1];
			int ECTS = Integer.parseInt(parts[2]);
			String fechaIni = parts[3];
			String fechaFinParts = parts[4];
			double tasa = Double.parseDouble(parts[5]);
			int edicion = Integer.parseInt(parts[6]);
			String centro = parts[7];
			String director = parts[8];
			String secretario = parts[9];
			String estadoCurso = parts[10];
			String tipoCurso = parts[11];
			
			EstadoCurso estado = null;
			switch(estadoCurso) {
				case "PROPUESTO":
					estado = EstadoCurso.PROPUESTO;
					break;
				case "VALIDADO":
					estado = EstadoCurso.VALIDADO;
					break;
				case "PROPUESTA_RECHAZADA":
					estado = EstadoCurso.PROPUESTA_RECHAZADA;
					break;
				case "EN_MATRICULACION":
					estado = EstadoCurso.EN_MATRICULACION;
					break;
				case "EN_IMPARTIZICION":
					estado = EstadoCurso.EN_IMPARTIZICION;
					break;
				case "TERMINADO":
					estado = EstadoCurso.TERMINADO;
					break;
			}
			
			TipoCurso tipo = null;
			switch(tipoCurso) {
				case "MASTER":
					tipo = TipoCurso.MASTER;
					break;
				case "EXPERTO":
					tipo = TipoCurso.EXPERTO;
					break;
				case "ESPECIALISTA":
					tipo = TipoCurso.ESPECIALISTA;
					break;
				case "FORMACION_AVANZADA":
					tipo = TipoCurso.FORMACION_AVANZADA;
					break;
				case "FORMACION_CONTINUA":
					tipo = TipoCurso.FORMACION_CONTINUA;
					break;
				case "MICROCREDENCIALES":
					tipo = TipoCurso.MICROCREDENCIALES;
					break;
				case "CORTA_DURACION":
					tipo = TipoCurso.CORTA_DURACION;
					break;
			}
			
			CursoPropio cursoCreado = new CursoPropio(id, nombre, ECTS, fechaIni, fechaFinParts, tasa, edicion, centro, director, secretario, estado, tipo);
			listaEdicionesCurso.add(cursoCreado);
		}
		
		return listaEdicionesCurso;
	}

}
