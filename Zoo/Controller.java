
package Zoo;

import java.util.*;

public class Controller {
	static Scanner sc = new Scanner(System.in);
	static Service s = new Service();

	public static void main(String[] args) {
		zoo();
	}

	public static void zoo() {
		int c = 0;
		do {
			System.err.println("Welcome to Zoo Management System!");
			System.out.println("1.Enter Zoo Detials.\n2.View Zoo.\n3.Exit");
			System.out.println("Enter your Choice : ");
			try {
				c = sc.nextInt();
				if (c < 1 || c > 4) {
					throw new InputMismatch("Invalid Input!");
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Please try again.");
			}

			switch (c) {
			case 1:
				s.setInfo();
				break;

			case 2:
				s.getInfo();
				break;

			case 3:
				System.out.println("Thank you!");
				break;
			}
		} while (c != 3);
	}
}
