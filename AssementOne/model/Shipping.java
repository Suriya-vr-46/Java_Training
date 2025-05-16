package model;

import database.Database;
import model.Address;
import model.Part;

public class Shipping implements Database {
	String tagNumber;
	Part part;
	Address address;

	public Shipping(String tagNumber, Part part, Address address) {
		super();
		this.tagNumber = tagNumber;
		this.part = part;
		this.address = address;
	}

	public String getTagNumber() {
		return tagNumber;
	}

	public Part getPart() {
		return part;
	}

	public Address getAddress() {
		return address;
	}

	public void getDetials() {
		System.out.println("Tag number : " + tagNumber);
		System.out.println("Part Detials :~");
		for (String id : parts.keySet()) {
			if (part.number.equals(id)) {
				parts.get(id).getDetials();
				break;
			}
		}
		System.out.println("Address Detials :~");
//		for (String id : parts.keySet()) {
//			if (part.equals(id)) {
				System.out.println("Door no : " +address.getDoorno());
				System.out.println("Street : " + address.getStreet());
				System.out.println("District : " + address.getDistrict());
				System.out.println("State : " + address.getState());
				System.out.println("Country : " + address.getCountry());
//			}
//		}
	}
}
