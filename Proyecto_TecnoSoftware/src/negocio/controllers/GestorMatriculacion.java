package negocio.controllers;
import java.sql.SQLException;

import java.sql.SQLSyntaxErrorException;

import negocio.entities.Matricula;
import persistencia.MatriculaDAO;
import negocio.entities.*;


public class GestorMatriculacion {
	/**
	 * 
	 * @param matricula
	 */
	public void realizarMatriculacion(Matricula matricula) {
		MatriculaDAO agenteMatriculaDAO = new MatriculaDAO();
		AgenteBD agenteBD = agenteMatriculaDAO.getAgenteBD();
		
		try {
			PreparedStatement insert = cnt.prepareStatement("INSERT INTO Matricula VALUES (?,?,?,?,?,?,?)");
			insert.setInt(1, matricula.getIdMatricula()); //id
			insert.setString(2, matricula.getTipoPago()); //tipoPago
			insert.setInt(3, matricula.getIdTitulo()); //titulo
			insert.setString(4, matricula.getIdEstudiante()); //estudiante
			insert.setInt(5, matricula.getAttribute()); //atributo
			insert.setBoolean(6, matricula.isPagado()); //pagado
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			java.util.Date parseado = sdf.parse(matricula.getFecha());
			Date fecha = new java.sql.Date(parseado.getTime());
			insert.setDate(7, fecha); //fecha
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * 
	 * @param matricula
	 */
	private void realizarPago(Matricula matricula) {
		MatriculaDAO agenteMatriculaDAO = new MatriculaDAO();
		AgenteBD agenteBD = agenteMatriculaDAO.getAgenteBD();
		
		try {
			PreparedStatement insert = cnt.prepareStatement("UPDATE Matricula SET pagado=?, tipoPago=? WHERE id=?");
			insert.setBoolean(1, matricula.isPagado()); //pagado
			insert.setString(2, matricula.getTipoPago()); //tipoPago
			insert.setInt(3, matricula.getIdMatricula()); //id
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
