package persistencia;

import java.util.List;

import negocio.entities.*;

public class MatriculaDAO extends AbstractEntityDAO<Object> {

	private AbstractEntityDAO<Matricula> abstractEntityDAO;

	public MatriculaDAO(Class entityClass) {
		super(entityClass);
		this.abstractEntityDAO = new AbstractEntityDAO<Matricula>(entityClass) {
		};
	}
	
	public List<Matricula> selectMatriculas(){
		return abstractEntityDAO.showAll();
	}
	
	public void insertMatricula(Matricula matricula) {
		abstractEntityDAO.save(matricula);
	}

	public void updateMatricula(Matricula matricula) {
		abstractEntityDAO.update(matricula);
	}
	public void deleteMatricula(Matricula matricula) {
		abstractEntityDAO.delete(matricula);
	}

}
