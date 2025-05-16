package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static Connection connection = null;
	String url = "jdbc:sqlserver://localhost:1433;databaseName=IN_MANAGEMENT;encrypt=true;trustServerCertificate=true;";
	String user = "sa";
	String password = "P@ssword@321";
	
	public Connection getConnection() {
		if(connection == null) {
			try {
				connection = DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}  catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return connection;
		}
		return connection;
	}
}
