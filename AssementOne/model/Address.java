package model;

public class Address {
	String doorno;
	String street;
	String district;
	String state;
	String country;

	public Address(String doorno, String street, String district, String state, String country) {
		this.doorno = doorno;
		this.street = street;
		this.district = district;
		this.state = state;
		this.country = country;
	}

	public String getDoorno() {
		return doorno;
	}

	public String getStreet() {
		return street;
	}

	public String getDistrict() {
		return district;
	}

	public String getState() {
		return state;
	}

	public String getCountry() {
		return country;
	}
}
