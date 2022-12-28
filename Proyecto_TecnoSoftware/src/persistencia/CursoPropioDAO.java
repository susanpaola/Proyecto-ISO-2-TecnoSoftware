package persistencia;

<<<<<<< HEAD
import java.sql.SQLException;
=======
>>>>>>> refs/heads/Feature-GestorConsultas
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

<<<<<<< HEAD
	public Vector<Object> seleccionarCursos(String sql) throws Exception {
		Vector<Object> cursos;
			cursos = GestorBD.getAgente().select(sql);			
			return cursos;
=======
	public Vector<Object> seleccionarCursos(String sql) {
		return agenteBD.select(sql);
>>>>>>> refs/heads/Feature-GestorConsultas
	}

<<<<<<< HEAD
	public Vector<Object> estadoResuelto() throws Exception {
		Vector<Object> a = seleccionarCursos("SELECT id,nombre,centro,tipo,estado FROM CursoPropio WHERE `estado`<>'PROPUESTO'");
	return a;
	}
	public Vector<Object> estadoPendiente() throws Exception {
		Vector<Object> a = seleccionarCursos("SELECT id,nombre,centro,tipo,estado FROM CursoPropio WHERE `estado`='PROPUESTO'");
	return a;
	}
	public int editarCurso(String sql) throws SQLException, Exception {
=======
	public int editarCurso(String sql) {
>>>>>>> refs/heads/Feature-GestorConsultas
		return agenteBD.update(sql);
	}
<<<<<<< HEAD

	//Dado un estado, devolver un Vector<Object> con ellos
	/*public Vector<Object> listarCursosPorEstado(EstadoCurso estado) throws Exception {
	return agenteBD.select(sql);
	}*/

	//Dado un tipo de curso, devolver un double con la suma de sus campos tasa
	public double listarIngresos(TipoCurso tipo, Date fechaInicio, Date fechaFin) {
		return 0.00;
	}
	
	//Devolver una EDA con los ids de las ediciones
	public void listarEdicionesCursos(Date fechaInicio, Date fechaFin) {
		
	}
=======
>>>>>>> refs/heads/Feature-GestorConsultas
}
