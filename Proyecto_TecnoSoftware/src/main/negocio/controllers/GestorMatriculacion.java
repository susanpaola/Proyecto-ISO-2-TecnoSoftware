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
	public int realizarMatriculacion(Matricula matricula) {
		MatriculaDAO agenteMatriculaDAO = new MatriculaDAO();
		int res = 0;
		try {
			String sql = "INSERT INTO Matricula VALUES (" + matricula.getIdMatricula() + ",'" + matricula.getTipoPago().toString() + "'," + matricula.getIdTitulo() + ",'" + matricula.getIdEstudiante() + "'," + matricula.isPagado() + ",'" + matricula.getFecha() + "')";
			res = agenteMatriculaDAO.insertMatricula(sql);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return res;
	}

	/**
	 * 
	 * @param matricula
	 */
	public int realizarPago(Matricula matricula) {
		MatriculaDAO agenteMatriculaDAO = new MatriculaDAO();
		int res = 0;
		
		try {
			String sql = "UPDATE Matricula SET pagado=" + matricula.isPagado() +", tipoPago=" + "'" + matricula.getTipoPago().toString() + "'" + " WHERE id=" +  matricula.getIdMatricula();
			res = agenteMatriculaDAO.updateMatricula(sql);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return res;
	}
}
