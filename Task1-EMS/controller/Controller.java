package controller;
import view.View;

public class Controller {
	static View view = new View();
	
	public void start() {
		int c = 0;
		do {
			c = view.showMenu();
			switch(c) {
				case 1 -> view.userLogin();
				case 2 -> System.out.println("Thank you!");
				default -> System.out.println("Invalid Choice!");
			}
		}while(c != 2);
	}
}
