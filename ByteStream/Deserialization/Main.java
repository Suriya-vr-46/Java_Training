package Deserialization;
import java.io.*;
import Model.User;

public class Main {
	public static void main(String[] args) {
		
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("Object.ser"))){
			User s = (User) in.readObject();
			System.out.println("User Id : "+s.getId());
			System.out.println("User Name : "+s.getName());
			System.out.println("User Password : "+s.getPassword());
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}