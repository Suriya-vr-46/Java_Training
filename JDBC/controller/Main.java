package controller;

public class Main {
	public static void main(String[] args) {
		JDBC db = new JDBC();
		int c = 0;
		do {
			c = db.shownMenu();
			switch(c) {
			case 1 -> db.jdbcConnection();
			case 2 -> db.getUserDetials();
			case 3 -> db.setRecord();
			case 4 -> db.updateRecord();
			case 5 -> db.closeConnnection();
			}
		}while(c != 5);
	}
}
