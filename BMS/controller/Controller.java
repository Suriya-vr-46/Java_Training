package controller;
import view.View;
import model.Bank;
import model.User;
import java.util.*;

public class Controller implements Database {
	public void start() {
		View view = new View();
		boolean running = true;
		
		do {
			int c = view.showMenu();
			
			switch(c) {
				case 0:
					return;
					
				case 1:
					view.newBank();
					break;
					
				case 2:
				case 3:
				default:
			}
		}while(running);
	}
}
