package persistencia;

import java.util.Date;

public abstract class AbstractEntityDAO<E> {

	private String id;
	private Date fechaCreacion;
	private Date fechaActualizacion;

	/**
	 * 
	 * @param id
	 */
	public E get(String id) {
		// TODO - implement AbstEntityDAO.get
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param entity
	 */
	public int insert(E entity) {
		// TODO - implement AbstEntityDAO.insert
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param entity
	 */
	public E update(E entity) {
		// TODO - implement AbstEntityDAO.update
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param entity
	 */
	public int delete(E entity) {
		// TODO - implement AbstEntityDAO.delete
		throw new UnsupportedOperationException();
	}

	public void operation() {
		// TODO - implement AbstEntityDAO.operation
		throw new UnsupportedOperationException();
	}

}