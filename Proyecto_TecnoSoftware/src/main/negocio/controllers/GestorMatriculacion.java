package main.negocio.controllers;
import java.sql.SQLException;

import java.sql.*;
import main.persistencia.*;
import main.negocio.entities.*;


public class GestorMatriculacion {
	/**
	 * 
	 * @param matricula
	 */
	public void realizarMatriculacion(Matricula matricula) {
		MatriculaDAO agenteMatriculaDAO = new MatriculaDAO();
		
		try {
			String sql = "INSERT INTO Matricula VALUES (" + matricula.getIdMatricula() + ",'" + matricula.getTipoPago().toString() + "'," + matricula.getIdTitulo() + ",'" + matricula.getIdEstudiante() + "'," + matricula.getAtributo() + "," + matricula.isPagado() + ",'" + matricula.getFecha() + "')";
			agenteMatriculaDAO.insertMatricula(sql);
			
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
		
		try {
			String sql = "UPDATE Matricula SET pagado=" + matricula.isPagado() +", tipoPago=" + "'" + matricula.getTipoPago().toString() + "'" + " WHERE id=" +  matricula.getIdMatricula();
			agenteMatriculaDAO.updateMatricula(sql);
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
