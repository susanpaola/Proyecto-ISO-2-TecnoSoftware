package main.persistencia;

import java.sql.SQLException;
import java.util.*;
import main.negocio.entities.*;
import main.persistencia.*;

public class CursoPropioDAO {
	private GestorBD agenteBD;
	
	public CursoPropioDAO() {
		try {
			this.agenteBD = this.agenteBD.getAgente();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public int insertarCurso(String sql) {
		return agenteBD.insert(sql);
	}

	public Vector<Object> seleccionarCursos(String sql) throws Exception {
		return agenteBD.select(sql);
	}

	public int editarCurso(String sql) throws SQLException, Exception {
		return agenteBD.update(sql);
	}
}

