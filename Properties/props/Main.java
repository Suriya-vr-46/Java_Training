package props;
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		Properties prop = new Properties();
		
		try(InputStream input = new FileInputStream("AdminProperties.properties")){
			prop.load(input);
			
			String username = prop.getProperty("username");
			String password = prop.getProperty("password");
			
			System.err.println("User Detials!");
			System.out.println("Name : " + username);
			System.out.print("Password : ");
			for(int i=0;i<password.length();i++) {
				System.out.print("*");
			}
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
