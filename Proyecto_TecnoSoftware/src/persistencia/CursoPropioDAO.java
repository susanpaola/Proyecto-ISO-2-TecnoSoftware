package persistencia;

import java.sql.SQLException;
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

	public Vector<Object> seleccionarCursos(String sql) throws Exception {
		Vector<Object> cursos;
			cursos = GestorBD.getAgente().select(sql);			
			return cursos;
	}

	public Vector<Object> estadoResuelto() throws Exception {
		Vector<Object> a = seleccionarCursos("SELECT id,nombre,centro,tipo,estado FROM CursoPropio WHERE `estado`<>'PROPUESTO'");
	return a;
	}
	public Vector<Object> estadoPendiente() throws Exception {
		Vector<Object> a = seleccionarCursos("SELECT id,nombre,centro,tipo,estado FROM CursoPropio WHERE `estado`='PROPUESTO'");
	return a;
	}
	public int editarCurso(String sql) throws SQLException, Exception {
		return agenteBD.update(sql);
	}

	//Dado un estado, devolver un Vector<Object> con ellos
	/*public Vector<Object> listarCursosPorEstado(EstadoCurso estado) throws Exception {
	return agenteBD.select(sql);
	}*/


	/**
	 * 
	 * @param tipo
	 * @param fechaInicio
	 * @param fechaFin
	 */
	public List<List<String>> listarIngresos(TipoCurso tipo, Date fechaInicio, Date fechaFin) {
		// TODO - implement CursoPropioDAO.listarIngresos
		throw new UnsupportedOperationException();
	}
	
	//Devolver una EDA con los ids de las ediciones
	public void listarEdicionesCursos(Date fechaInicio, Date fechaFin) {
		
	}
}
