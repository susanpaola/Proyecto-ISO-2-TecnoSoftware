package persistencia;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import negocio.entities.*;

public class MatriculaDAO {
	private GestorBD agenteBD;

	public MatriculaDAO() {
		try {
			this.agenteBD = this.agenteBD.getAgente();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public Vector<Object> selectMatriculas(String sql) throws Exception{
		return agenteBD.select(sql);
	}
	
	public int insertMatricula(String sql) {
		return agenteBD.insert(sql);
	}

	public int updateMatricula(String sql) throws SQLException, Exception {
		return agenteBD.update(sql);
	}
	
	public int deleteMatricula(String sql) {
		return agenteBD.delete(sql);
	}
	
	public GestorBD getAgenteBD() {
		return this.agenteBD;	
	}
}
