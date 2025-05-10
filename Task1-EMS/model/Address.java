package model;

public class Address {
	String doorNo;
	String street;
	String district;
	int pincode;
	String state;
	
	public Address(String doorNo, String street, String district, int pincode, String state) {
		this.doorNo = doorNo;
		this.street = street;
		this.district = district;
		this.pincode = pincode;
		this.state = state;
	}

	public String getDoorNo() {
		return doorNo;
	}

	public String getStreet() {
		return street;
	}

	public String getDistrict() {
		return district;
	}

	public int getPincode() {
		return pincode;
	}

	public String getState() {
		return state;
	}
	
	public void getDetials() {
		System.out.print("\nDoor no : "+doorNo);
		System.out.print("\nStreet : "+street);
		System.out.print("\nDistrict : "+district);
		System.out.print("\nPincode : "+pincode);
		System.out.print("\nState : "+state);
		System.out.println();
	}
}
