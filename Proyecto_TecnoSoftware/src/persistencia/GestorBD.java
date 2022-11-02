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
		// instancia del agente
		protected static GestorBD mInstancia = null;
		// Conexion con la base de datos
		protected static Connection mBD;
		// Identificador ODBC de la base de datos
		private static String url = "jdbc:mysql://127.0.0.1:3306/TecnoSoftware?user=root";
		// Driven para conectar con bases de datos MySQL
		
		private static String driver= "com.mysql.cj.jdbc.Driver";
		private static String user= "root";
		private static String password="admin";
	
		
		public static void conectar() throws Exception {
			Class.forName(driver);
			mBD = DriverManager.getConnection(url, user, password);
			mBD.setAutoCommit(true);
		}
		public static void desconectar() throws Exception {
			mBD.close();
		}
		public static void main(String[] args) throws Exception {
			conectar();
			
			
			
		}

		public static GestorBD getmInstancia() {
			return mInstancia;
		}

		public static void setmInstancia(GestorBD mInstancia) {
			GestorBD.mInstancia = mInstancia;
		}


		public int insert(String SQL) throws SQLException, Exception {
			conectar();
			PreparedStatement stmt = mBD.prepareStatement(SQL);
			int res = stmt.executeUpdate(SQL);
			stmt.close();
			desconectar();
			return res;
		}


		public int delete(String SQL) throws SQLException, Exception {
			conectar();
			PreparedStatement stmt = mBD.prepareStatement(SQL);
			int res = stmt.executeUpdate(SQL);
			stmt.close();
			desconectar();
			return res;
		}

		// Metodo para realizar una eliminacion en la base de datos
		public int update(String SQL) throws SQLException, Exception {
			conectar();
			PreparedStatement stmt = mBD.prepareStatement(SQL);
			int res = stmt.executeUpdate(SQL);
			stmt.close();
			desconectar();
			return res;
		}


		public Vector<Object>  select(String SQL) throws Exception {
			/*
			 * Metodo para realizar una busqueda o seleccion de informacion enla base de
			 * datos El método select develve un vector de vectores, donde cada uno de los
			 * vectores que contiene el vector principal representa los registros que se
			 * recuperan de la base de datos.
			*/
			Vector<Object> vectoradevolver = new Vector<Object>();
			conectar();
			Statement stmt = mBD.createStatement();
			ResultSet res = stmt.executeQuery(SQL);
			while (res.next()) {
				Vector<Object> v = new Vector<Object>();
				for(int i=1; i<20; i++) {
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
			conectar();
			return vectoradevolver;

		}

		public static GestorBD getAgente() throws Exception {
			if (mInstancia == null) {
				mInstancia = new GestorBD();
			}
			return mInstancia;
		}

		public GestorBD() throws Exception {
			conectar();
		}

	}
