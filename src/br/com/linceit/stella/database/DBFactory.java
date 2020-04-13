package br.com.linceit.stella.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBFactory {

	private static Connection connection = null;

	private static DBType config;

	private DBFactory() {
	}
	
	public static void setupConfig(DBType config) {
		DBFactory.config = config;
	}
	
	public static Connection getConnection() {
		if (config == null) {
			throw new RuntimeException("Erro ao adquirir conexao sem config no DatabaseManager");
		}
		
		try {
			if (config == DBType.DS) {
				// Conexao gerenciada pelo container
				return DBFactory.openConnectionFromDS();
			} else if (config == DBType.NON_DS) {
				
				if (connection == null || connection.isClosed() || !connection.isValid(60)) {
					// Cria conexao apenas quando for nula ou fechada
					connection = DBFactory.openConnection();
				}
				
				return connection;
			}
			
			return null;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			throw new RuntimeException("Ocorreu um problema ao abrir a conexão com o database.");
		}
	}
	
	private static Connection openConnectionFromDS() throws NamingException, SQLException {
		Context ctx = new InitialContext();
		DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/StellaDB");
		return ds.getConnection();
	}

	private static Connection openConnection() throws SQLException, ClassNotFoundException {
		String connString = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
		String usuario = "RM80387";
		String senha = "091296";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(connString, usuario, senha);
		return conn;
	}
}
