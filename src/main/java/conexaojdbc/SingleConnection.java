package conexaojdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {
	
	private static String url = "jdbc:sqlserver://URANO;database=SASFSARHBD_CSQV;";
	private static String password = "too4Ture";
	private static String user = "developer";
	private static Connection connection = null;
	private static Connection connection1 = null;
	
	static {
		conectar();
	}
	
	public SingleConnection() {
		conectar();
	}

	private static void conectar() {
		try {
			if (connection == null) {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				connection = DriverManager.getConnection(url, user, password);
				connection.setAutoCommit(false);
				System.out.println("Conectou com sucesso !");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static Connection getConnection() {
		return connection;
	}
}
