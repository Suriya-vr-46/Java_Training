package model;

import database.Database;
import java.util.*;

public class Employee implements Database{
	String name;
	String gender;
	Address address;
	int experience;
	int salary;
	int role;
	List<Integer> leads = new ArrayList<>();
	int userId;
	String password;

	public Employee( String name, String gender, Address address, int experience, int salary, int userId, String password) {
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.experience = experience;
		this.salary = salary;
		this.userId = userId;
		this.password = password;
	}

	public void setLead(Integer empid) {
		this.leads.add(empid);
	}

	public void setRole(int role) {
		this.role = role;
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

	public int getRole() {
		return role;
	}

	public List<Integer> getLeads() {
		return leads;
	}

	public int getUserId() {
		return userId;
	}

	public String getPassword() {
		return password;
	}

	public void getDetials() {
		System.out.println("Name\t: \t" + name);
		System.out.println("Gender\t: \t" + gender);
		System.out.println("Address\t:\t");
		address.getDetials();
		System.out.println("Experience\t:\t" + experience);
		System.out.println("Salary\t:\t" + salary);
		System.out.println("Password\t:\t" + password);
		System.out.print("Role\t:\t");
		if (role == 0) {
			System.out.print("No Role!\n");
		} else {
			System.out.print(roles.get(role) + "\n");
		}
		System.out.print("Lead\t\t:~\n");
		if (leads == null) {
			System.out.print("No Leads!\n");
		} else {
			for(Integer employeeId: employees.keySet()) {
				for (Integer lead : leads) {
					if(employeeId == lead) {
						System.out.println("Name\t\t : " + employees.get(employeeId).getName());
						System.out.print("Role\t\t : ");
						System.out.println(roles.get(employees.get(employeeId).getRole())); 
					}
				}
			}
		}
		System.out.println();
	}
}