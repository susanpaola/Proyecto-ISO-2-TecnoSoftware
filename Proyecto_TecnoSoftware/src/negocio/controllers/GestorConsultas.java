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
	public double consultarIngresos(TipoCurso tipo, String fechaInicio, String fechaFin) {
		double ganancia = 0.00;
		String charsToRemove = "[] ";
			
		String sql = "SELECT * FROM CursoPropio WHERE tipo='" + tipo.toString() + "' AND fechaIni >='" + ini + "' AND fechaFin <='" + fin + "' AND estado='VALIDADO'";
		Vector<Object> vectorCursos = new Vector<Object>();
		CursoPropioDAO cursoDAO = new CursoPropioDAO();
		vectorCursos = cursoDAO.seleccionarCursos(sql);
		
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
			vectorMatriculas = cursoDAO.seleccionarCursos(sql2);
			
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
	public List<CursoPropio> consultarEstadoCursos(EstadoCurso estadoCurso, Date fechaInicio, Date fechaFin) {
		// TODO - implement GestorConsultas.consultarEstadoCursos
		List<CursoPropio> listaEstadoCurso = new ArrayList<>();
		CursoPropioDAO<CursoPropio> curso = new CursoPropioDAO<>();
		
		listaEstadoCurso = curso.listarCursosPorEstado(estadoCurso, fechaInicio, fechaFin);
		return listaEstadoCurso;
		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param fechaInicio
	 * @param fechaFin
	 */
	public List<CursoPropio> listarEdicionesCursos(Date fechaInicio, Date fechaFin) {
		// TODO - implement GestorConsultas.listarEdicionesCursos
		List<CursoPropio> listaEdicionesCurso = new ArrayList<>();
		CursoPropioDAO<CursoPropio> curso = new CursoPropioDAO<>();
		
		listaEdicionesCurso = curso.listarEdicionesCurso(fechaInicio, fechaFin);
		return listaEdicionesCurso;
		//throw new UnsupportedOperationException();
	}

}
