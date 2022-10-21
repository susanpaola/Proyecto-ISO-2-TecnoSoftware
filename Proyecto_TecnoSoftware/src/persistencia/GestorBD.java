package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class GestorBD {
	
	// instancia del agente
	protected static GestorBD gInstance = null;
	//Conexion con la base de datos
	protected static Connection gBD;
	// Identificador ODBC de la base de datos
	private static String url;
	// Driven para conectar con bases de datos MySQL
	private static String driver = "com.mysql.jdbc.Driver";
		
	// Constructor
	private GestorBD() throws Exception {
		conectarBD();

	}
		
	public static GestorBD getGestor() throws Exception {
		if (gInstance == null) {
			gInstance = new GestorBD();
		}
		return gInstance;
	}

	public GestorBD conectarBD() throws Exception {
		Class.forName(driver);
		gBD = DriverManager.getConnection(url);
		return conectarBD();
	}

	public void desconectarBD() throws Exception {
		gBD.close();
		
	}

	/**
	 * Metodo para realizar una busqueda o seleccion de informacion en la base de
	 * datos.
	 * @param sql
	 * 
	 * NO TENEMOS CLARO COMO ES
	 */
	public void select(String sql) throws SQLException, Exception{
		Vector<Object> vectoradevolver = new Vector<Object>();
		conectarBD();
		Statement stmt = gBD.createStatement();
		ResultSet res = stmt.executeQuery(sql);
		while (res.next()) {
			Vector<Object> v = new Vector<Object>();
			v.add(res.getObject(1));
			v.add(res.getObject(2));
			vectoradevolver.add(v);
		}
		stmt.close();
		desconectarBD();
	}

	/**
	 * Metodo para realizar una insercion en la base de datos
	 * @param sql
	 * @throws SQLException, Exception 
	 */
	public int insert(String sql) throws SQLException, Exception {
		conectarBD();
		PreparedStatement stmt = gBD.prepareStatement(sql);
		int res = stmt.executeUpdate();
		stmt.close();
		desconectarBD();
		return res;
		
	}

	/**
	 * Metodo para realizar una actualizacion en la base de datos
	 * @param sql
	 * @throws SQLException, Exception 
	 */
	public int update(String sql) throws SQLException, Exception {
		conectarBD();
		PreparedStatement stmt = gBD.prepareStatement(sql);
		int res = stmt.executeUpdate();
		stmt.close();
		desconectarBD();
		return res;
	}

	/**
	 * Metodo para realizar una eliminacion en la base de datos
	 * @param sql
	 * @throws SQLException, Exception 
	 */
	public int delete(String sql) throws SQLException, Exception {
		PreparedStatement stmt = gBD.prepareStatement(sql);
		int res = stmt.executeUpdate();
		stmt.close();
		desconectarBD();
		return res;
	}

	public void operation() throws Exception {
		//gBD.close();
	}

}