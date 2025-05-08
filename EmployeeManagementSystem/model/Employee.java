package model;

public class Employee {
	int id;
	String name;
	int departmentId;
	
	public Employee(int id,String name,int departmentId) {
		this.id = id;	
		this.name = name;
		this.departmentId = departmentId;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public int getDepartmentId() {
		return departmentId;
	}
}
