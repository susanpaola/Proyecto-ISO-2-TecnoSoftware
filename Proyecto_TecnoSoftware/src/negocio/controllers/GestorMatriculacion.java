package negocio.controllers;
import java.sql.SQLException;

import java.sql.SQLSyntaxErrorException;

import negocio.entities.Matricula;
import persistencia.MatriculaDAO;
import negocio.entities.*;


public class GestorMatriculacion {
	/**
	 * 
	 * @param curso
	 * @param estudiante
	 * @throws Exception 

	 */
	public void realizarMatriculacion(Matricula matricula) throws Exception {
		MatriculaDAO agenteMatriculaDAO = new MatriculaDAO();
		try {
			agenteMatriculaDAO.insertMatricula(
					"INSERT INTO Matricula(id, tipoPago, titulo, estudiante, atributo, pagado, fecha) VALUES ('"
					+ matricula.getIdMatricula()+", '"
					+ matricula.getTipoPago()+", '"
					+ matricula.getIdTitulo()+", '"
					+ matricula.getIdEstudiante()+", '"
					+ matricula.getAttribute()+", '"
					+ matricula.isPagado()+", '"
					+ matricula.getFecha()+"')");
		} catch (SQLSyntaxErrorException e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * 
	 * @param curso
	 * @param estudiante
	 * @throws Exception 
	 */
	public void realizarPagoMatricula(CursoPropio curso, Estudiante estudiante) throws Exception {
		Matricula matricula = new Matricula(estudiante, curso);
		matricula.matriculaDAO.selectMatriculas("SELECT * FROM matricula WHERE cursoPropio_id='"
				+matricula.titulo.getId()+"' AND cursoPropio_edicion="
				+matricula.titulo.getEdicion()+" AND estudiante_dni='"
				+matricula.estudiante.getDni()+"'");


		matricula.setPagado(true);
	}

	/**
	 * 
	 * @param curso
	 * @param estudiante
	 * @throws Exception 
	 */
	private void realizarPagoTarjeta(CursoPropio curso, Estudiante estudiante) throws Exception {
		Matricula matricula = new Matricula(estudiante, curso);
		matricula.matriculaDAO.selectMatriculas("SELECT * FROM matricula WHERE cursoPropio_id='"
				+matricula.titulo.getId()+"' AND cursoPropio_edicion="
				+matricula.titulo.getEdicion()+" AND estudiante_dni='"
				+matricula.estudiante.getDni()+"'");
		matricula.tipoPago = ModoPago.TARJETA_CREDITO;
	}

	/**
	 * 
	 * @param curso
	 * @param estudiante
	 * @throws Exception 
	 */
	private void realizarPagoTransferencia(CursoPropio curso, Estudiante estudiante) throws Exception {
		Matricula matricula = new Matricula(estudiante, curso);
		matricula.matriculaDAO.selectMatriculas("SELECT * FROM matricula WHERE cursoPropio_id='"
				+matricula.titulo.getId()+"' AND cursoPropio_edicion="
				+matricula.titulo.getEdicion()+" AND estudiante_dni='"
				+matricula.estudiante.getDni()+"'");
		matricula.tipoPago = ModoPago.TRANSFERENCIA;
	}

	private void operation() {
		// TODO - implement GestorMatriculacion.operation
		throw new UnsupportedOperationException();
	}

}