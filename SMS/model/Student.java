package model;

public class Student {
	int rollno;
	String name;
	String department;
	
	public Student(int rollno, String name, String department) {
		this.rollno = rollno;
		this.name = name;
		this.department = department;
	}

	public int getRollno() {
		return rollno;
	}

	public String getName() {
		return name;
	}

	public String getDepartment() {
		return department;
	}	
}
