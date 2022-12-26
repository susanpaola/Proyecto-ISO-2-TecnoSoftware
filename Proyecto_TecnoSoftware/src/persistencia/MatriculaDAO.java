package persistencia;

import java.util.List;

import negocio.entities.*;

public class MatriculaDAO extends AbstractEntityDAO<Object> {

	//private AbstractEntityDAO<Matricula> abstractEntityDAO;
	private GestorBD agenteBD;

	public MatriculaDAO() {
		this.agenteBD = agenteBD.getAgente();
	}
	
	public Vector<Object> selectMatriculas(String sql){
		return agenteBD.select(sql);
	}
	
	public int insertMatricula(String sql) {
		return agenteBD.insert(sql);
	}

	public int updateMatricula(String sql) {
		return agenteBD.update(sql);
	}
	
	public int deleteMatricula(String sql) {
		return agenteBD.delete(sql);
	}

}
