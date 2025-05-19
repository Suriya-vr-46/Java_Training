package view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

import database.DBConnection;
import database.Database;
import model.Address;
import model.Part;
import model.Shipping;

public class View implements Database {
	static Scanner sc = new Scanner(System.in);
	static DBConnection db = new DBConnection();
	static Connection conn = null;
	static Statement stmt = null;

	public int showMenu() {
		System.out.println("Inventory Management System!\n");
		conn = db.getConnection();
		if (conn == null) {
			System.out.println("Failed to Connect to Database!");
			return 2;
		}
		System.out.println("1.Login.\n2.Exit");
		System.out.println("Enter your choice : ");
		int c = 0;
		try {
			c = sc.nextInt();
		} catch (InputMismatchException e) {
			System.out.println(e.getMessage());
		}
		return c;
	}

	public int userLogin(int loginCount) {
		int userid = 0;
		String password = null;

		String sql = "select id, password from USER;";

		try {
			conn = db.getConnection();
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next()) {
				userid = rs.getInt("id");
				password = rs.getString("password");
			}
			rs.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

//		#Using Properties
//		try (FileInputStream in = new FileInputStream("AdminProperties.properties")) {
//			Properties prob = new Properties();
//			prob.load(in);
//			userid = prob.getProperty("username");
//			password = prob.getProperty("password");
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}

		sc.nextLine();
		System.out.println("Enter User Id : ");
		int currentUserId = sc.nextInt();

		sc.nextLine();
		System.out.println("Enter User Password : ");
		String currentUserPassword = sc.nextLine();

		if (userid == currentUserId && password.equals(currentUserPassword)) {
			System.out.println("\n Login Sucessfully!");
			userMenu();
		} else {
			loginCount++;
			System.out.println("\nIncorrect Password or User Id!");
			System.out.println("Please try Again!");
		}
		return loginCount;
	}

	public static void userMenu() {
		int c = 0;
		do {
			System.out.println("\nUser Menu!");
			System.out.println(
					"1.Add new Part.\n2.Remove a Part.\n3.View All Part.\n4.Update Quantity of an Existing Part.\n5.Shipping Parts.\n6.Exit");
			System.out.println("Enter your Choice!");
			try {
				c = sc.nextInt();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			switch (c) {
			case 1 -> addPart();
			case 2 -> removePart();
			case 3 -> viewAllPart();
			case 4 -> updateQuantity();
			case 5 -> shippingParts();
			case 6 -> System.out.println("Thank you!");
			default -> System.out.println("Invalid Choice!");
			}
		} while (c != 6);
	}

	public static void addPart() {
		boolean flag = true;
		System.out.println("\nEnter New Part Detials!");
		sc.nextLine();
		System.out.println("Enter the Part Name : ");
		String name = null;
		try {
			name = sc.nextLine();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Enter the Part Number (xxx.xxx) : ");
		String number = null;
		String numberRegex = "^[0-9]{4}+(?<!\\.)+[0-9]{4}+$";
		try {
			number = sc.nextLine();
			if (number.matches(numberRegex)) {
				throw new InputMismatchExecption("Invalid Formate!");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Enter the Part Quantity : ");
		int quantity = 0;
		try {
			quantity = sc.nextInt();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Do you add a description (y/n) ?");
		String c = null;
		try {
			c = sc.next();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		sc.nextLine();
		String description = null;
		if (c.equalsIgnoreCase("y")) {
			System.out.println("Add the description : ");
			try {
				description = sc.nextLine();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else if (c.equalsIgnoreCase("n")) {
			flag = false;
		} else {
			System.out.println("Invalid Input!");
		}

		if (flag) {
//			#HashMap
//			Part part = new Part(name, number, quantity, description);
//			parts.put(number, part);

			String sql_part = "insert into PART (name, number, quantity, description) values (?, ?, ?, ?);";

			try {
				conn = db.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql_part);

				pstmt.setString(1, name);
				pstmt.setString(2, number);
				pstmt.setInt(3, quantity);
				pstmt.setString(4, description);

				int rows = pstmt.executeUpdate();

				if (rows > 0) {
					System.out.println("Record Inserted Sucessfully!");
				} else {
					System.out.println("Failed to Insert record!");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else {
//			#HashMap
//			Part part = new Part(name, number, quantity);
//			parts.put(number, part);

			String sql = "insert into PART (name, number, quantity) values (?, ?, ?);";

			try {
				conn = db.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);

				pstmt.setString(1, name);
				pstmt.setString(2, number);
				pstmt.setInt(3, quantity);

				int rows = pstmt.executeUpdate();

				if (rows > 0) {
					System.out.println("Record Inserted Sucessfully!");
				} else {
					System.out.println("Failed to Insert record!");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		String sql_parts = "insert into PARTS(name, number, available) values (?, ?, ?);";

		boolean quantityFlag = true;
		for (int i = 1; i <= quantity; i++) {
			try {
				conn = db.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql_parts);

				pstmt.setString(1, name);
				pstmt.setString(2, number);
				pstmt.setBoolean(3, true);

				int rows = pstmt.executeUpdate();

				if (rows > 0) {
					quantityFlag = true;
				} else {
					quantityFlag = false;
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		if(quantityFlag) {
			System.out.println("Record Inserted Sucessfully!");			
		} else {			
			System.out.println("Failed to Insert record!");
		}
	}

	public static void removePart() {
		System.out.println("Remove Part Detials!");
		{
			sc.nextLine();
			System.out.println("Enter the Tag number : ");
			String number = null;
			try {
				number = sc.nextLine();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			boolean found = false;
			for (String part : parts.keySet()) {
				for (String tag : parts.get(part).getTagNumbers())
					if (tag.equals(number)) {
						found = true;
						parts.get(part).getTagNumbers().remove(tag);
						System.out.println("Sucessfully Removed!");
						break;
					}
			}
			if (!found) {
				System.out.println("No Part Found!");
				System.out.println("Please try again!");
			}
		}
	}

	public static void viewAllPart() {
		for (String number : parts.keySet()) {
			parts.get(number).getDetials();
		}
	}

	public static void updateQuantity() {
		System.out.println("Update Quantity!");
		sc.nextLine();
		System.out.println("Enter the part number : ");
		String number = null;
		try {
			number = sc.nextLine();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		boolean found = false;
		for (String part : parts.keySet()) {
			if (part.equals(number)) {
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("No Part Found!");
			System.out.println("Please try again!");
			return;
		}
		System.out.println("Enter the quantity number : ");
		int quantity = 0;
		try {
			quantity = sc.nextInt();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		parts.get(number).setQuantity(quantity);
	}

	public static void shippingParts() {
		System.out.println("Shipping Parts Detials!");
		HashMap<String, Part> shippingProducts = new HashMap<>();
		boolean flag = true;
		do {
			sc.nextLine();
			System.out.println("Enter the Part number : ");
			String number = null;
			try {
				number = sc.nextLine();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			boolean found = false;
			for (String part : parts.keySet()) {
				if (part.equals(number)) {
					found = true;
					break;
				}
			}
			if (!found) {
				System.out.println("No Part Found!");
				System.out.println("Please try again!");
				return;
			}

			System.out.println("Enter the Quantity to Ship : ");
			int quantity = 0;
			try {
				quantity = sc.nextInt();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			for (String part : parts.keySet()) {
				if (part.equals(number) && parts.get(part).getTagNumbers().size() >= quantity) {
					for (int i = 1; i <= quantity; i++) {
						String tag = null;
						for (String tag2 : parts.get(part).getTagNumbers()) {
							tag = tag2;
						}
						parts.get(part).getTagNumbers().remove(tag);
						shippingProducts.put(tag, parts.get(part));
					}
				}
			}

			System.out.println("Enter Address Detials : ");
			sc.nextLine();
			System.out.println("Doorno : ");
			String doorno = null;
			try {
				doorno = sc.nextLine();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			System.out.println("Street : ");
			String street = null;
			try {
				street = sc.nextLine();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			System.out.println("District : ");
			String district = null;
			try {
				district = sc.nextLine();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			System.out.println("State : ");
			String state = null;
			try {
				state = sc.nextLine();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			System.out.println("Country : ");
			String country = null;
			try {
				country = sc.nextLine();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			Address address = new Address(doorno, street, district, state, country);

			for (String part : shippingProducts.keySet()) {
				Shipping sp = new Shipping((String) part, shippingProducts.get(part), address);
				shipings.add(sp);
			}

			System.out.println("Do you want to add another part (y/n) :");
			String c = null;
			try {
				c = sc.next();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			if (c.equalsIgnoreCase("y")) {
				continue;
			} else if (c.equalsIgnoreCase("n")) {
				flag = false;
			} else {
				System.out.println("Invalid Input!");
			}
		} while (flag);

		System.out.println("Shipping Detials : ");
		if (shipings == null) {
			System.out.println("No Shippings!");
		} else {
			for (Shipping sp : shipings) {
				sp.getDetials();
			}
		}

	}
}
