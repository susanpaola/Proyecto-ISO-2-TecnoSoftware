package persistencia;

import java.util.*;
import negocio.entities.*;
import persistencia.*;

public class CursoPropioDAO {
	private GestorBD agenteBD;
	
	public CursoPropioDAO() {
		try {
			this.agenteBD = this.agenteBD.getAgente();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public int insertarCurso(String sql) {
		return agenteBD.insert(sql);
	}

	public Vector<Object> seleccionarCursos(String sql) {
		return agenteBD.select(sql);
	}

	public int editarCurso(String sql) {
		return agenteBD.update(sql);
	}

	//Dado un estado, devolver un Vector<Object> con ellos
	public Vector<Object> listarCursosPorEstado(EstadoCurso estado) {
		return agenteBD.select(sql);
	}

	//Dado un tipo de curso, devolver un double con la suma de sus campos tasa
	public double listarIngresos(TipoCurso tipo, Date fechaInicio, Date fechaFin) {
		return 0.00;
	}
	
	//Devolver una EDA con los ids de las ediciones
	public void listarEdicionesCursos(Date fechaInicio, Date fechaFin) {
		
	}
}
