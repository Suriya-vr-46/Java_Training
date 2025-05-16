package model;

import java.util.*;

public class Part {
	String name;
	String number;
	int quantity;
	boolean flag = true;
	String description;
	ArrayList<String> tagNumbers = new ArrayList<>();
	Address address;

	public Part(String name, String number, int quantity, String description) {
		super();
		this.name = name;
		this.number = number;
		this.quantity = quantity;
		this.description = description;

		int t = 101;
		for (int i = 1; i <= quantity; i++) {
			String temp = number + t++;
			tagNumbers.add(temp);
		}
	}

	public Part(String name, String number, int quantity) {
		super();
		this.name = name;
		this.number = number;
		this.quantity = quantity;
		flag = false;

		int t = 101;
		for (int i = 1; i <= quantity; i++) {
			String temp = number + t++;
			tagNumbers.add(temp);
		}
	}

	public String getName() {
		return name;
	}

	public String getNumber() {
		return number;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getDescription() {
		return description;
	}

	public ArrayList<String> getTagNumbers() {
		return tagNumbers;
	}

	public void setQuantity(int qua) {
		int t = 301;
		for (int i = 1; i <= qua; i++) {
			String temp = number + t++;
			tagNumbers.add(temp);
		}
	}

	public void getDetials() {
		if (flag) {
			System.out.println("Name\t:\t" + name);
			System.out.println("Number\t:\t" + number);
			System.out.println("Quantity\t:\t" + quantity);
			System.out.println("Description\t:\t" + description);
			System.out.println("Tag Numbers :~");
			for (String tagNumber : tagNumbers) {
				System.out.println(tagNumber);
			}
		} else {
			System.out.println("Name\t:\t" + name);
			System.out.println("Number\t:\t" + number);
			System.out.println("Quantity\t:\t" + quantity);
			System.out.println("Tag Numbers :~");
			for (String tagNumber : tagNumbers) {
				System.out.println(tagNumber);
			}
		}
	}

	public void setAddress(Address add) {
		this.address = add;
	}

	public Address getAddress() {
		return address;
	}
}
