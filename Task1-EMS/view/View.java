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
			for (Integer managerId : managers.keySet()) {
				if (managerId == id && managers.get(managerId).getPassword().equals(password)) {
					managerMenu(managerId);
					break;
				}
			}

			for (Integer supervisorId : supervisors.keySet()) {
				if (supervisorId == id && supervisors.get(supervisorId).getPassword().equals(password)) {
					supervisorMenu(supervisorId);
					break;
				}
			}

			for (Integer technicianId : technicians.keySet()) {
				if (technicianId == id && technicians.get(technicianId).getPassword().equals(password)) {
					technicianMenu(technicianId);
					break;
				}
			}

			for (Integer internId : interns.keySet()) {
				if (internId == id && interns.get(internId).getPassword().equals(password)) {
					internMenu(internId);
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
					"1.Add New Employee.\n2.View Employees By Role.\n3.View All Employees.\n4.Assign Lead.\n5.Set Role Detials.\n6.Assign Role.\n7.Exit");
			c = sc.nextInt();
			switch (c) {
			case 1 -> newEmployee();
			case 2 -> showEmployeesWithRole();
			case 3 -> showAllEmployees();
			case 4 -> assignLead();
			case 5 -> setRoles();
			case 6 -> assignRole();
			case 7 -> System.out.println("Thank you!");
			default -> System.out.println("Invalid Choice!");
			}
		} while (c != 7);
	}

	public static void newEmployee() {
		System.err.println("New Employee Detials!");
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
		employees.put(userId,new Employee(name, gender, address, experience, salary, userId, password));
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
			for (Integer manager : managers.keySet()) {
				managers.get(manager).getDetials();
			}
		}

		System.out.println("Supervisor!");
		if (supervisors.size() == 0) {
			System.out.println("No  Supervisors");
		} else {
			for (Integer supervisorId : supervisors.keySet()) {
				supervisors.get(supervisorId).getDetials();
			}
		}

		System.out.println("Technician!");
		if (technicians.size() == 0) {
			System.out.println("No  Technicians");
		} else {
			for (Integer technicianId : technicians.keySet()) {
				technicians.get(technicianId).getDetials();
			}
		}

		System.out.println("Intern!");
		if (interns.size() == 0) {
			System.out.println("No  Interns");
		} else {
			for (Integer internId : interns.keySet()) {
				interns.get(internId).getDetials();
			}
		}

	}

	public static void showAllEmployees() {
		System.out.println();
		System.err.println("Employees!");
		if (employees.size() == 0) {
			System.out.println("No Employees!");
		} else {
			for (Integer employeeId : employees.keySet()) {
				employees.get(employeeId).getDetials();
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
		
		if(employees.get(empUser.getUserId()).getRole() < employees.get(emp.getUserId()).getRole()) {
			empUser.setLead(emp.getUserId());			
		}else {
			System.out.println("\nUnable to Set Lead!");
			System.err.println("Please try again!");
		}

	}

	public static Employee getEmployeeByUserId(int userId) {
		for (Integer employeeId : employees.keySet()) {
			if (employeeId == userId) {
				return employees.get(userId);
			}
		}
		return null;
	}

	public static void setRoles() {
		System.err.println("\nRole Detials!");
		
		boolean running = true;
		do {
		System.out.print("Role Id \t:\t");
		int roleId = sc.nextInt();
		sc.nextLine();
		System.out.print("\nRole Name \t:\t");
		String roleName = sc.nextLine();
		roles.put(roleId, roleName);
		System.out.println("Do you want to add another role (y/n) \t:\t");
		String c = sc.next();
		if(c.equalsIgnoreCase("y")) {
			continue;
		}else if (c.equalsIgnoreCase("n")) {
			running = false;
		}
		}while(running != false);
	}
	
	public static void assignRole() {
		System.err.println("\nAssign Role Detials!");
		
		System.out.print("Enter Employee UserID :\t");
		int empUserId = sc.nextInt();
		sc.nextLine();
		Employee empUser = getEmployeeByUserId(empUserId);
		if (empUser == null) {
			System.out.println("\nNo Employee Found!");
			System.err.println("Please try again!");
			return;
		}

		System.out.print("Enter Role Id :\t");
		int roleId = sc.nextInt();
		if(roles.containsKey(roleId)) {
			empUser.setRole(roleId);
		} else {
			System.out.println("\nNo Role Found!");
			System.err.println("Please try again!");
			return;
		}
		
		for(Integer roleid: roles.keySet()) {
			if (roles.get(roleid).equalsIgnoreCase("manager")){
				managers.put(roleid, empUser);
			} else if (roles.get(roleid).equalsIgnoreCase("supervisor")) {
				supervisors.put(roleId,empUser);
			} else if (roles.get(roleid).equalsIgnoreCase("technician")) {
				technicians.put(roleid,empUser);
			} else if (roles.get(roleid).equalsIgnoreCase("intern")) {
				interns.put(roleid,empUser);
			}
		}
	}

	public static void managerMenu(Integer managerId) {
		int c = 0;
		do {
			System.err.println("Welcome Manager!");
			System.out.println("1.View Employees By Lead.\n2Exit");
			c = sc.nextInt();
			switch (c) {
			case 1 -> viewEmployeesByLead(managerId);
			case 2 -> System.out.println("Thank you!");
			default -> System.out.println("Invalid Choice!");
			}
		} while (c != 2);
	}

	public static void viewEmployeesByLead(Integer empId) {
		for (Integer employeeId : employees.keySet()) {
			for(Integer leadId : employees.get(empId).getLeads()) {
				if(leadId == employeeId) {
					employees.get(employeeId).getDetials();
				}
			}
		}
	}

	public static void supervisorMenu(Integer supervisorId) {
		int c = 0;
		do {
			System.err.println("Welcome Supervisor!");
			System.out.println("1.View Employees By Lead.\n2Exit");
			c = sc.nextInt();
			switch (c) {
			case 1 -> viewEmployeesByLead(supervisorId);
			case 2 -> System.out.println("Thank you!");
			default -> System.out.println("Invalid Choice!");
			}
		} while (c != 2);
	}

	public static void technicianMenu(Integer technicianId) {
		int c = 0;
		do {
			System.err.println("Welcome Technician!");
			System.out.println("1.View Employees By Lead.\n2Exit");
			c = sc.nextInt();
			switch (c) {
			case 1 -> viewEmployeesByLead(technicianId);
			case 2 -> System.out.println("Thank you!");
			default -> System.out.println("Invalid Choice!");
			}
		} while (c != 2);
	}

	public static void internMenu(Integer internId) {
		int c = 0;
		do {
			System.err.println("Welcome Intern!");
			System.out.println("1.View Your Detials.\n2Exit");
			c = sc.nextInt();
			switch (c) {
			case 1 -> interns.get(internId).getDetials();
			case 2 -> System.out.println("Thank you!");
			default -> System.out.println("Invalid Choice!");
			}
		} while (c != 2);
	}

}