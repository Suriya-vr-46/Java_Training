package view;
import model.Employee;
import model.Department;
import java.util.*;

public class View {
	static Scanner in = new Scanner(System.in);
	
	public int showMenu() {
		System.out.println("Employee Management System!");
		System.out.println("1.Enter Department detials.\n2.Enter Employee detials.\n3.Show Employees.\n4.Show Departments.\n5.Exit.");
		System.out.println("Enter your Choice : ");
		return in.nextInt();
	}
	
	public Department newDepartment() {
		System.out.println("Enter the Department ID : ");
		int id = in.nextInt();
		in.nextLine();
		System.out.println("Enter the Department Name : ");
		String name = in.nextLine();
		Department dep = new Department(id,name);
		return dep;
	}
	
	public Employee newEmployee() {
		System.out.println("Enter the Employee ID : ");
		int id = in.nextInt();
		in.nextLine();
		System.out.println("Enter the Employee Name : ");
		String name = in.nextLine();
		System.out.println("Enter the Department ID : ");
		int departmentId = in.nextInt();
		Employee emp = new Employee(id,name,departmentId);
		return emp;
	}
	
	public void showEmployees(ArrayList<Employee> emps,ArrayList<Department> deps) {
		System.out.println("Employee Detials!");
		for(Employee emp: emps) {
			System.out.println("ID\t\t: "+emp.getId());
			System.out.println("Name\t\t: "+emp.getName());
			System.out.print("Department\t: ");
			for(Department dep: deps) {
				if(dep.getId()==emp.getDepartmentId()) {
					System.out.println(dep.getName());
				}
			}
			System.out.println();
		}
	}
	
	public void showDepartments(ArrayList<Department> deps) {
		System.out.println("Department Detials!");
		for(Department dep: deps) {
			System.out.println("ID\t: "+dep.getId());
			System.out.println("Name\t: "+dep.getName());	
			System.out.println();
		}
	}
}
