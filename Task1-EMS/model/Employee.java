package model;
import java.util.*;

public class Employee {
	int id;
	String name;
	String gender;
	Address address;
	int experience;
	int salary;
	String role;
	List<Employee> leads = new ArrayList<>();;
	int userId;
	String password;	
	
	public Employee(int id, String name, String gender, Address address, int experience, int salary,int userId, String password) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.experience = experience;
		this.salary = salary;
		this.userId = userId;
		this.password = password;
	}
	
	public void setLead(Employee emp) {
		this.leads.add(emp);
	}
	public void setRole(String role) {
		this.role = role;
	}	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getGender() {
		return gender;
	}
	public Address getAddress() {
		return address;
	}
	public int getExperience() {
		return experience;
	}
	public int getSalary() {
		return salary;
	}
	public String getRole() {
		return role;
	}
	public List<Employee> getLeads() {
		return leads;
	}
	public int getUserId() {
		return userId;
	}
	public String getPassword() {
		return password;
	}
	
	public void getDetials() {
		System.out.println("\nID\t:\t"+id);
		System.out.println("Name\t: \t"+name);
		System.out.println("Gender\t: \t"+gender);
		System.out.println("Address\t:\t");address.getDetials();
		System.out.println("Experience\t:\t"+experience);
		System.out.println("Salary\t:\t"+salary);
		System.out.println("User ID\t:\t"+userId);
		System.out.println("Password\t:\t"+password);
		System.out.print("Role\t:\t");
		if(role == null) {
			System.out.print("No Role!\n");
		}else {
			System.out.print(role+"\n");
		}
		System.out.print("Lead\t\t:~\n");
		if(leads == null) {
			System.out.print("No Leads!\n");
		}else {
			for(Employee lead: leads) {
				System.out.println("Name\t\t : "+lead.getName());
				System.out.println("Role\t\t : "+lead.getRole());
			}
		}
		System.out.println();
	}
	
}
