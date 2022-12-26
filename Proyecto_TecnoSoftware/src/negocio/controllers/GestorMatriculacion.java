package negocio.controllers;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;

import negocio.entities.Matricula;
import persistencia.MatriculaDAO;
import negocio.entities.*;


public class GestorMatriculacion {

	public void realizarMatriculacion(Matricula matricula) throws SQLException {
		MatriculaDAO<Matricula> agenteMatriculaDAO = new MatriculaDAO<>();
		try {
			agenteMatriculaDAO.crearNuevaMatricula(matricula);
		} catch (SQLSyntaxErrorException e) {
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 * 
	 * @param curso
	 * @param estudiante
	 */
	public void realizarMatriculacion(CursoPropio curso, Estudiante estudiante) {
		// TODO - implement GestorMatriculacion.realizarMatriculacion
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param curso
	 * @param estudiante
	 */
	public void realizarPagoMatricula(CursoPropio curso, Estudiante estudiante) {
		// TODO - implement GestorMatriculacion.realizarPagoMatricula
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param curso
	 * @param estudiante
	 */
	private void realizarPagoTarjeta(CursoPropio curso, Estudiante estudiante) {
		// TODO - implement GestorMatriculacion.realizarPagoTarjeta
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param curso
	 * @param estudiante
	 */
	private void realizarPagoTransferencia(CursoPropio curso, Estudiante estudiante) {
		// TODO - implement GestorMatriculacion.realizarPagoTransferencia
		throw new UnsupportedOperationException();
	}

	private void operation() {
		// TODO - implement GestorMatriculacion.operation
		throw new UnsupportedOperationException();
	}

}