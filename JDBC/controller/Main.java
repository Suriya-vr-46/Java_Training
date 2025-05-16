package controller;

public class Main {
	public static void main(String[] args) {
		JDBC db = new JDBC();
		db.jdbcConnection();
		db.getUserDetials();
		db.setRecord("Mad", "Mad@14");
		db.updateRecord(1004, "VIY", "VI@32");
		db.getUserDetials();
	}
}
