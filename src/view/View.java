package view;
import model.Bank;
import model.User;
import database.ViewDatabase;
import uitility.InvalidInput;
import java.util.*;

public class View implements ViewDatabase {
	static Scanner in = new Scanner(System.in);
	
	@Override
	public int showMenu() {
		System.err.println("Bank Management System!");
		System.out.println("1.Enter Bank Detials.\n2.Enter User Detials.\n3.Exit");
		System.out.println("Enter your Choice : ");
		int c = 0;
		try {
			c = validInput(in.nextInt(),1,3);
		}catch(InvalidInput e) {
			System.err.println(e.getMessage());
		}
		return c;
	}
	
	@Override
	public void newBank() {
		System.err.println("Bank Detials!");
		System.out.println("Enter Bank Name : ");
		String name = null;
		try {
			name = validInput(in.nextLine());
		}catch(InvalidInput e) {
			System.err.println(e.getMessage());
		}
		System.out.println("Enter Bank branch code : ");
		long bcode = in.nextLong();
		
		banks.add(new Bank(name,bcode));
	}
	
	public static int validInput(int n,int s,int e) throws  InvalidInput{
		if(n<s || n>e) {
			return n;
		}else {
			throw new InvalidInput(n+" is not a valid Input!");
		}
	}
	
	public static String validInput(String name) throws  InvalidInput{
		if(name.isBlank() || name.isEmpty()) {
			throw new InvalidInput(name+" is not a valid Input!");			
		}else {
			return name;
		}
	}
}