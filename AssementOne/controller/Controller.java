package controller;

import view.View;
import database.Database;

public class Controller implements Database {
	public void screen() {
		View view = new View();
		int loginCount = 0;
		int c = 0;
		do {
			if (loginCount == 3) {
				System.err.println("Failed Attempts reached 3 times!");
				c = 2;
				break;
			}
			c = view.showMenu();
			switch (c) {
			case 1 -> loginCount = view.userLogin(loginCount);
			case 2 -> System.out.println("Thank you!");
			default -> System.out.println("Invalid Input!");
			}
		} while (c != 2);
	}
}
