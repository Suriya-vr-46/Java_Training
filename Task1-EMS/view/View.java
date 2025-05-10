package view;

import database.ViewMethods;
import model.Address;
import model.Employee;
import java.util.*;

public class View implements ViewMethods {
	static Scanner sc = new Scanner(System.in);

	public int showMenu() {
		System.err.println("Employee Management System!");
		System.out.println("1.User Login.\n2.Exit");
		return sc.nextInt();
	}

	public void userLogin() {
		System.err.println("User Login!");
		System.out.println("Enter User Id : ");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter your Password : ");
		String password = sc.nextLine();

		if (admin.getId() == id && admin.getPassword().equals(password)) {
			adminMenu();
		} else {
			for (Employee manager : managers) {
				if (manager.getUserId() == id && manager.getPassword().equals(password)) {
					managerMenu(manager);
					break;
				}
			}

			for (Employee supervisor : supervisors) {
				if (supervisor.getUserId() == id && supervisor.getPassword().equals(password)) {
					supervisorMenu(supervisor);
					break;
				}
			}

			for (Employee technician : technicians) {
				if (technician.getUserId() == id && technician.getPassword().equals(password)) {
					technicianMenu(technician);
					break;
				}
			}

			for (Employee intern : interns) {
				if (intern.getUserId() == id && intern.getPassword().equals(password)) {
					internMenu(intern);
					break;
				}
			}

		}
	}

	public static void adminMenu() {
		int c = 0;
		do {
			System.err.println("Welcome Admin!");
			System.out.println(
					"1.Add New Employee.\n2.View Employees By Role.\n3.View All Employees.\n4.Assign Lead.\n5.Assign Role.\n6.Exit");
			c = sc.nextInt();
			switch (c) {
			case 1 -> newEmployee();
			case 2 -> showEmployeesWithRole();
			case 3 -> showAllEmployees();
			case 4 -> assignLead();
			case 5 -> assignRole();
			case 6 -> System.out.println("Thank you!");
			default -> System.out.println("Invalid Choice!");
			}
		} while (c != 6);
	}

	public static void newEmployee() {
		System.err.println("New Employee Detials!");
		System.out.print("ID\t:\t");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.print("Name\t:\t");
		String name = sc.nextLine();
		System.out.print("Gender\t:\t");
		String gender = sc.nextLine();
		System.out.print("Address\t:~");
		Address address = addAddress();
		System.out.print("Experience\t:\t");
		int experience = sc.nextInt();
		System.out.print("Salary\t:\t");
		int salary = sc.nextInt();
		System.out.print("User ID\t:\t");
		int userId = sc.nextInt();
		sc.nextLine();
		System.out.print("Password\t:\t");
		String password = sc.nextLine();
		System.out.println();
		employees.add(new Employee(id, name, gender, address, experience, salary, userId, password));
	}

	public static Address addAddress() {
		System.out.print("\nDoor no\t:\t");
		String doorNo = sc.nextLine();
		System.out.print("Street\t:\t");
		String street = sc.nextLine();
		System.out.print("District\t:\t");
		String district = sc.nextLine();
		System.out.print("Pincode\t:\t");
		int pincode = sc.nextInt();
		sc.nextLine();
		System.out.print("State\t:\t");
		String state = sc.nextLine();
		return new Address(doorNo, street, district, pincode, state);
	}

	public static void showEmployeesWithRole() {
		System.err.println("Employees Detials!");

		System.out.println("Managers!");
		if (managers.size() == 0) {
			System.out.println("No  Managers");
		} else {
			for (Employee manager : managers) {
				manager.getDetials();
			}
		}

		System.out.println("Supervisor!");
		if (supervisors.size() == 0) {
			System.out.println("No  Supervisors");
		} else {
			for (Employee supervisor : supervisors) {
				supervisor.getDetials();
			}
		}

		System.out.println("Technician!");
		if (technicians.size() == 0) {
			System.out.println("No  Technicians");
		} else {
			for (Employee technician : technicians) {
				technician.getDetials();
			}
		}

		System.out.println("Intern!");
		if (interns.size() == 0) {
			System.out.println("No  Interns");
		} else {
			for (Employee intern : interns) {
				intern.getDetials();
			}
		}

	}

	public static void showAllEmployees() {
		System.out.println();
		System.err.println("Employees!");
		if (employees.size() == 0) {
			System.out.println("No Employees!");
		} else {
			for (Employee employee : employees) {
				employee.getDetials();
			}
		}
		System.out.println();
	}

	public static void assignLead() {
		System.err.println("\nAssign Lead Detials!");
		
		System.out.print("Enter Employee UserID :\t");
		int empUserId = sc.nextInt();
		Employee empUser = getEmployeeByUserId(empUserId);
		if (empUser == null) {
			System.out.println("\nNo Employee Found!");
			System.err.println("Please try again!");
			return;
		}
		
		System.out.print("\nEnter Lead UserID :\t");
		int userId = sc.nextInt();
		Employee emp = getEmployeeByUserId(userId);
		if (emp == null) {
			System.out.println("\nNo Lead Found!");
			System.err.println("Please try again!");
			return;
		}

		empUser.setLead(emp);
	}
	
	public static Employee getEmployeeByUserId(int userId) {
		for (Employee employee : employees) {
			if (employee.getUserId() == userId) {
				return employee;
			}
		}
		return null;
	}
	
	public static void assignRole() {
		System.err.println("\nLead and Role Detials!");
		
		System.out.print("Enter Employee UserID :\t");
		int empUserId = sc.nextInt();
		sc.nextLine();
		Employee empUser = getEmployeeByUserId(empUserId);
		if (empUser == null) {
			System.out.println("\nNo Employee Found!");
			System.err.println("Please try again!");
			return;
		}
		
		System.out.print("Enter Role :\t");
		String role = sc.nextLine();
		if(role.equalsIgnoreCase("manager") || role.equalsIgnoreCase("supervisor") || role.equalsIgnoreCase("technician") || role.equalsIgnoreCase("intern")) {
			empUser.setRole(role);			
		}else {
			System.out.println("\nNo Role Found!");
			System.err.println("Please try again!");
			return;
		}
		
		if(role.equalsIgnoreCase("manager")) {
			managers.add(empUser);
		} else if(role.equalsIgnoreCase("supervisor")) {
			supervisors.add(empUser);
		} else if(role.equalsIgnoreCase("technician")) {
			technicians.add(empUser);
		} else if(role.equalsIgnoreCase("intern")) {
			interns.add(empUser);
		}
	}
	

	public static void managerMenu(Employee manager) {
		int c = 0;
		do {
			System.err.println("Welcome Manager!");
			System.out.println("1.View Employees By Lead.\n2Exit");
			c = sc.nextInt();
			switch (c) {
			case 1 -> viewEmployeesByLead(manager);
			case 2 -> System.out.println("Thank you!");
			default -> System.out.println("Invalid Choice!");
			}
		} while (c != 2);
	}

	public static void viewEmployeesByLead(Employee currentLead) {
		for(Employee employee: employees) {
			for(Employee lead: employee.getLeads()) {
				if(lead.getName().equals(currentLead.getName())) {
					employee.getDetials();
				}
			}
		}
		
	}
	
	public static void supervisorMenu(Employee supervisor) {
		int c = 0;
		do {
			System.err.println("Welcome Supervisor!");
			System.out.println("1.View Employees By Lead.\n2Exit");
			c = sc.nextInt();
			switch (c) {
			case 1 -> viewEmployeesByLead(supervisor);
			case 2 -> System.out.println("Thank you!");
			default -> System.out.println("Invalid Choice!");
			}
		} while (c != 2);
	}
	
	public static void technicianMenu(Employee technician) {
		int c = 0;
		do {
			System.err.println("Welcome Technician!");
			System.out.println("1.View Employees By Lead.\n2Exit");
			c = sc.nextInt();
			switch (c) {
			case 1 -> viewEmployeesByLead(technician);
			case 2 -> System.out.println("Thank you!");
			default -> System.out.println("Invalid Choice!");
			}
		} while (c != 2);
	}
	
	public static void internMenu(Employee intern) {
		int c = 0;
		do {
			System.err.println("Welcome Intern!");
			System.out.println("1.View Your Detials.\n2Exit");
			c = sc.nextInt();
			switch (c) {
			case 1 -> intern.getDetials();
			case 2 -> System.out.println("Thank you!");
			default -> System.out.println("Invalid Choice!");
			}
		} while (c != 2);
	}

}
