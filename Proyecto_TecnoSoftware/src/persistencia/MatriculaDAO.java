package persistencia;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import negocio.entities.*;

public class MatriculaDAO extends AbstractEntityDAO<Object> {

	public MatriculaDAO(Class<Object> entityClass) {
		super(entityClass);
		// TODO Auto-generated constructor stub
	}

	//private AbstractEntityDAO<Matricula> abstractEntityDAO;
	private GestorBD agenteBD;
	
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

}
