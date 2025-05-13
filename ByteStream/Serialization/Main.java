package Serialization;
import java.io.*;
import java.util.Scanner;
import Model.User;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter User Id : ");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter User Name : ");
		String name = sc.nextLine();
		System.out.println("Enter User Password : ");
		String password = sc.nextLine();
		
		User s = new User(id,name,password);
		
		try (ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream("Object.ser"))) {
			obj.writeObject(s);
			obj.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("File Created Sucessfully!");
		}
		sc.close();
	}
}
