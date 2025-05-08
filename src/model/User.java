package model;

public class User {
	int id;
	String name;
	long accountNo;
	
	public User(int id,String name) {
		this.id = id;
		this.name = name;
	}
	
	public void setAccountNo(long num) {
		accountNo = num;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public long getAccountNo() {
		return accountNo;
	}
	
}