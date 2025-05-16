package controller;

public class Main {
	public static void main(String[] args) {
		JDBC db = new JDBC();
		db.jdbcConnection();
		db.getUserDetials();
	}
}
