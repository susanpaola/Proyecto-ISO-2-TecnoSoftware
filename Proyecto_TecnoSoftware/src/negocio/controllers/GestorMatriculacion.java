package negocio.controllers;
import java.sql.SQLException;

import java.sql.*;
import persistencia.*;
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
			String sql = "INSERT INTO Matricula VALUES (" + matricula.getIdMatricula() + ",'" + matricula.getTipoPago().toString() + "'," + matricula.getIdTitulo() + ",'" + matricula.getIdEstudiante() + "'," + matricula.getAtributo() + "," + matricula.isPagado() + ",'" + matricula.getFecha() + "')";
			agenteBD.insert(sql);
			
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
			String sql = "UPDATE Matricula SET pagado=" + matricula.isPagado() +", tipoPago=" + "'" + matricula.getTipoPago().toString() + "'" + " WHERE id=" +  matricula.getIdMatricula();
			agenteBD.update(sql);
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
