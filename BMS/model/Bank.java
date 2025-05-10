package model;

public class Bank {
	String name;
	long branchId;
	
	public Bank(String name,long branchId) {
		this.name = name;
		this.branchId = branchId;
	}

	public String getName() {
		return name;
	}

	public long getBranchId() {
		return branchId;
	}
		
}