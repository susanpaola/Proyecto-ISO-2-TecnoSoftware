package persistencia;

import java.sql.Connection;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class GestorBD {
	//Instancia 
	protected GestorBD = null;
	// Conexion con la base de datos
	protected static Connection mBD;
	// Identificador ODBC de la base de datos
	private static String url = "jdbc:mysql://db4free.net:3306/proyecto_iso";
	// Driven para conectar con bases de datos MySQL
		
	private static String driver= "com.mysql.cj.jdbc.Driver";
	private static String user= "proyecto_iso";
	private static String password="contraseña";
	
		
	public static void connect() {
		try {
			Class.forName(driver);
			mBD = DriverManager.getConnection(url, user, password);
			mBD.setAutoCommit(true);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
		
	public static void disconnect() throws Exception {
		mBD.close();
	}


	public  int insert(String SQL) {
		int res = -1;
		try {
			connect();
			PreparedStatement stmt = mBD.prepareStatement(SQL);
			res = stmt.executeUpdate(SQL);
			stmt.close();
			disconnect();
		} catch (Exception e) {
			System.out.println(e);
		} 
		return res;
	}

	public int delete(String SQL) {
		int res = -1;
		try {
			connect();
			PreparedStatement stmt = mBD.prepareStatement(SQL);
			res = stmt.executeUpdate(SQL);
			stmt.close();
			disconnect();
		} catch (Exception e) {
			System.out.println(e);
		} 
		return res;
	}

	// Metodo para realizar una eliminacion en la base de datos
	public int update(String SQL) throws SQLException, Exception {
		connect();
		PreparedStatement stmt = mBD.prepareStatement(SQL);
		int res = stmt.executeUpdate(SQL);
		stmt.close();
		disconnect();
		return res;
	}


	public Vector<Object>  select(String SQL) throws Exception {
			/*
			 * Metodo para realizar una busqueda o seleccion de informacion enla base de
			 * datos El mŽtodo select develve un vector de vectores, donde cada uno de los
			 * vectores que contiene el vector principal representa los registros que se
			 * recuperan de la base de datos.
			*/
		Vector<Object> vectoradevolver = new Vector<Object>();
		connect();
		Statement stmt = mBD.createStatement();
		ResultSet res = stmt.executeQuery(SQL);
		ResultSetMetaData rsmd = rs.getMetaData();
		int columns = rsmd.getColumnCount();
		
		while (res.next()) {
			Vector<Object> v = new Vector<Object>();
			for(int i=1; i<=columns; i++) {
				try {
					v.add(res.getObject(i));
				}
				catch(SQLException ex) {
					continue;
				}
			}
			vectoradevolver.add(v);
		}
		stmt.close();
		disconnect();
		return vectoradevolver;
	}

	public static GestorBD getAgente() throws Exception {
		if (mInstancia == null) {
			mInstancia = new GestorBD();
		}
		return mInstancia;
	}

	public GestorBD() throws Exception {
		connect();
	}

}
