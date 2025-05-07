package Employee;
import java.util.*;

public class Department {
	String name;
	List<Employee> Employees;
	
	class Employee{
		int id;
		String name;
		
		
		public Employee(int id,String name) {
			this.id = id;
			this.name = name;
		}
		
		public void display() {
			System.out.println("ID : "+id);
			System.out.println("Name : "+name);
		}
		
		public String getName() {
			return name;
		}
	}
	
	public Department(String name){
		this.name = name;
		this.Employees = new ArrayList <>();
	}
	
	public void addEmployee(int id, String name) {
		Employee emp = new Employee(id,name);
		Employees.add(emp);
	}
	
	public void display() {
		System.out.println("Department form : "+name);
		Employees.sort(Comparator.comparing(Employee::getName));
		for(Employee e: Employees) {
			e.display();
		}
	}
	
}
