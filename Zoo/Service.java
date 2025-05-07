package Zoo;

import java.util.*;

public class Service {
	List<Entity> entities;
	static Scanner sc = new Scanner(System.in);

	public Service() {
		this.entities = new ArrayList<>();
	}

	public void addAnimal(String name, int age, int weight, String sound, String sepical) {

	}

	public void getInfo() {
		for (Entity e : entities) {
			e.info();
		}
	}

	public void setInfo() {
		String name = null, sound = null, sepical = null;
		int age = 0, weight = 0;
		boolean flag = true;

		System.out.println("Enter the number of Animals : ");
		int n = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < n; i++) {
			System.out.println("Enter the Animal Name : ");
			try {
				name = sc.nextLine();
				if (name.isEmpty()) {
					throw new InputMismatch("Invalid Input!");
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Please try again.");
				break;
			}

			System.out.println("Enter the Animal Age : ");
			try {
				age = sc.nextInt();
				if (age < 0) {
					throw new InputMismatch("Invalid Input!");
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Please try again.");
				break;
			}

			System.out.println("Enter the Animal Weight : ");
			try {
				weight = sc.nextInt();
				sc.nextLine();
				if (weight < 0 || weight > 100) {
					throw new InputMismatch("Invalid Input!");
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Please try again.");
				break;
			}

			System.out.println("Enter the Animal Sound : ");
			try {
				sound = sc.nextLine();
				if (sound.isEmpty()) {
					throw new InputMismatch("Invalid Input!");
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Please try again.");
				break;
			}

			System.out.println("Did the Animal have special behaviour (y/n): ");
			try {
				String yn = sc.next();
				if (yn.isEmpty()) {
					throw new InputMismatch("Invalid Input!");
				} else if (yn.equals("n")) {
					flag = false;
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Please try again.");
				break;
			}

			System.out.println("Enter the Animal special behaviour : ");
			try {
				sepical = sc.nextLine();
				if (sepical.isEmpty()) {
					throw new InputMismatch("Invalid Input!");
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Please try again.");
				break;
			}
		}

		Entity e = new Entity();
		if (flag) {
			e.addAnimal(name, age, weight, sound, sepical);
		} else {
			e.addAnimal(name, age, weight, sound);
		}
		entities.add(e);

	}
}
