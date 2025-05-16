package controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	private static Connection connection = null;

	private final static String url = "jdbc:sqlserver://localhost:1433;databaseName=IN_MANAGEMENT;encrypt=true;trustServerCertificate=true;";
	private final static String user = "sa";
	private final static String password = "P@ssword@321";

	public static Connection getConnection() {
		if (connection == null) {
			try {
				connection = DriverManager.getConnection(url, user, password);
				System.err.println("Database Connected Sucessfully!");
				return connection;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		System.err.println("Database Already Connected!");
		return connection;
	}
}
