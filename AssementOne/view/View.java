package view;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

import database.DBMethods;
import database.Database;
import model.Address;
import model.Part;
import model.Shipping;

public class View implements Database {
	static Scanner sc = new Scanner(System.in);
	static DBMethods dbm = new DBMethods();
	static HashMap<Integer, Integer> intMap = new HashMap<>();
	static HashMap<Integer, String> stringMap = new HashMap<>();

	public int showMenu() {
		System.err.println("Inventory Management System!\n");
		int con = dbm.getConnection();
		if (con == 0) {
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

		String sqlId = "select id from USERS;";
		String sqlPass = "select password from USERS;";

		userid = dbm.getUserId(sqlId);
		password = dbm.getUserPass(sqlPass);
		

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
			System.err.println("\nUser Menu!");
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
		System.err.println("\nEnter New Part Detials!");
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
		String numberRegex = "^[0-9]{3}+\\.+[0-9]{3}+$";
		try {
			number = sc.nextLine();
			if (!number.matches(numberRegex)) {
				throw new InputMismatchExecption("Invalid Formate!");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
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

			String sqlPart = "insert into PART (name, number, quantity, description, created_by) values (?, ?, ?, ?, ?);";

			stringMap.put(1, name);
			stringMap.put(2, number);
			stringMap.put(4, description);
			stringMap.put(5, "user");

			intMap.put(3, quantity);

			int res = dbm.insert(sqlPart, stringMap, intMap);

			if (res > 0) {
				System.out.println("Record Inserted Sucessfully!");
			} else {
				System.out.println("Failed to Insert record!");
			}
			
			stringMap.clear();
			intMap.clear();

//			#Preapared Statement
//			try {
//				conn = db.getConnection();
//				PreparedStatement pstmt = conn.prepareStatement(sql_part);
//				
//				pstmt.setString(1, name);
//				pstmt.setString(2, number);
//				pstmt.setInt(3, quantity);
//				pstmt.setString(4, description);
//				pstmt.setString(5, "user");
//				
//
//				int rows = pstmt.executeUpdate();
//
//				if (rows > 0) {
//					System.out.println("Record Inserted Sucessfully!");
//				} else {
//					System.out.println("Failed to Insert record!");
//				}
//			} catch (Exception e) {
//				System.out.println(e.getMessage());
//			}
		} else {
//			#HashMap
//			Part part = new Part(name, number, quantity);
//			parts.put(number, part);

			String sqlPart = "insert into PART (name, number, quantity, created_by) values (?, ?, ?, ?);";

			stringMap.put(1, name);
			stringMap.put(2, number);
			stringMap.put(4, "user");

			intMap.put(3, quantity);

			int res = dbm.insert(sqlPart, stringMap, intMap);

			if (res > 0) {
				System.out.println("Record Inserted Sucessfully!");
			} else {
				System.out.println("Failed to Insert record!");
			}
			
			stringMap.clear();
			intMap.clear();

//			#Prepared Statement
//			try {
//				conn = db.getConnection();
//				PreparedStatement pstmt = conn.prepareStatement(sqlPart);
//
//				pstmt.setString(1, name);
//				pstmt.setString(2, number);
//				pstmt.setInt(3, quantity);
//				pstmt.setString(4, "user");
//
//				int rows = pstmt.executeUpdate();
//
//				if (rows > 0) {
//					System.out.println("Record Inserted Sucessfully!");
//				} else {
//					System.out.println("Failed to Insert record!");
//				}
//			} catch (Exception e) {
//				System.out.println(e.getMessage());
//			}
		}

		boolean quantityFlag = true;
		String sqlParts = "insert into PARTS(name, number, description, created_by) values (?, ?, ?, ?);";

		stringMap.put(1, name);
		stringMap.put(2, number);
		stringMap.put(3, description);
		stringMap.put(4, "user");
		for (int i = 1; i <= quantity; i++) {
			int res = dbm.insert(sqlParts, stringMap);

			if (res == 0) {
				quantityFlag = false;
			}
		}

		if (quantityFlag) {
			System.out.println("Records Inserted Sucessfully!");
		} else {
			System.out.println("Failed to Insert record!");
		}
		
		stringMap.clear();

//		#Prepares Statement
//		boolean quantityFlag = true;
//		for (int i = 1; i <= quantity; i++) {
//			try {
//				conn = db.getConnection();
//				PreparedStatement pstmt = conn.prepareStatement(sqlParts);
//
//				pstmt.setString(1, name);
//				pstmt.setString(2, number);
//				pstmt.setString(3, "user");
//
//				int rows = pstmt.executeUpdate();
//
//				if (rows > 0) {
//					quantityFlag = true;
//				} else {
//					quantityFlag = false;
//				}
//			} catch (Exception e) {
//				System.out.println(e.getMessage());
//			}
//		}
//		
//		if(quantityFlag) {
//			System.out.println("Records Inserted Sucessfully!");			
//		} else {			
//			System.out.println("Failed to Insert record!");
//		}
	}

	public static void removePart() {
		System.err.println("Remove Part Detials!");
			System.out.println("Enter the Tag number : ");
			int number = 0;
			try {
				number = sc.nextInt();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			String sqlFind = "select * from PARTS where id = ? and void_flag = 0;";
			String sqlDelete = "update PARTS set void_flag = 1 where id = ?;";
			
			if(dbm.findParts(number,sqlFind)) {
				dbm.softDelete(number,sqlDelete);
			} else {
				System.out.println("No Part Found!");
				System.err.println("Please try again!");
			}
			
			
//			#Hash Map
//			boolean found = false;
//			for (String part : parts.keySet()) {
//				for (String tag : parts.get(part).getTagNumbers())
//					if (tag.equals(number)) {
//						found = true;
//						parts.get(part).getTagNumbers().remove(tag);
//						System.out.println("Sucessfully Removed!");
//						break;
//					}
//			}
//			if (!found) {
//				System.out.println("No Part Found!");
//				System.out.println("Please try again!");
//			}
	}

	public static void viewAllPart() {
		System.err.println("Part Detials!");
		String sql = "select * from PART where void_flag = 0;";
		dbm.getAllPart(sql);
		
		System.err.println("Parts Detials!");
		String sqll = "select * from PARTS where void_flag = 0;";
		dbm.getAllParts(sqll);
		
//		#Hash Map
//		for (String number : parts.keySet()) {
//			parts.get(number).getDetials();
//		}
	}

	public static void updateQuantity() {
		System.out.println("Update Quantity!");
		System.out.println("Enter the part id : ");
		int id = 0;
		try {
			id = sc.nextInt();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Enter the quantity number : ");
		int quantity = 0;
		try {
			quantity = sc.nextInt();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		String sqlFind = "select * from PART where id = ? and void_flag = 0;";
		String sqlUpdate = "update PART set quantity = ? where id = ?;";
		
		if(dbm.findPart(id, sqlFind)) {
			dbm.setQuantity(id, quantity, sqlUpdate);
		} else {
			System.out.println("No Part Found!");
			System.err.println("Please try again!");
		}
		
//		#Hash Map
//		boolean found = false;
//		for (String part : parts.keySet()) {
//			if (part.equals(number)) {
//				found = true;
//				break;
//			}
//		}
//		if (!found) {
//			System.out.println("No Part Found!");
//			System.out.println("Please try again!");
//			return;
//		}
//		System.out.println("Enter the quantity number : ");
//		int quantity = 0;
//		try {
//			quantity = sc.nextInt();
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//
//		parts.get(number).setQuantity(quantity);
	}

	public static void shippingParts() {
		System.out.println("Shipping Parts Detials!");
//		HashMap<String, Part> shippingProducts = new HashMap<>();
		boolean flag = true;
		do {
			sc.nextLine();
			System.out.println("Enter the Part id : ");
			int id = 0;
			try {
				id = sc.nextInt();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			String sql = "select * from PART where id = ?;";
			if(!dbm.findPart(id, sql)) {
				System.out.println("No Part Found!");
				System.err.println("Please try again!");
				return;
			}
			
//			#Hash code
//			boolean found = false;
//			for (String part : parts.keySet()) {
//				if (part.equals(number)) {
//					found = true;
//					break;
//				}
//			}
//			if (!found) {
//				System.out.println("No Part Found!");
//				System.out.println("Please try again!");
//				return;
//			}

			System.out.println("Enter the Quantity to Ship : ");
			int squantity = 0;
			try {
				squantity = sc.nextInt();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			
			
//			#Hash code
//			for (String part : parts.keySet()) {
//				if (part.equals(number) && parts.get(part).getTagNumbers().size() >= quantity) {
//					for (int i = 1; i <= quantity; i++) {
//						String tag = null;
//						for (String tag2 : parts.get(part).getTagNumbers()) {
//							tag = tag2;
//						}
//						parts.get(part).getTagNumbers().remove(tag);
//						shippingProducts.put(tag, parts.get(part));
//					}
//				}
//			}

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
			
			
//			#Hash code
//			Address address = new Address(doorno, street, district, state, country);
//
//			for (String part : shippingProducts.keySet()) {
//				Shipping sp = new Shipping((String) part, shippingProducts.get(part), address);
//				shipings.add(sp);
//			}
			
//			address
			boolean addressFlag = true;
			String sqlAddress = "insert into ADDRESS(doorno, street, district, country, created_by) values (?, ?, ?, ?, ?)";

			stringMap.put(1, doorno);
			stringMap.put(2, street);
			stringMap.put(3, district);
			stringMap.put(4, country);
			stringMap.put(5, "user");
			
			int res = dbm.insert(sqlAddress, stringMap);
				
			if (res == 0) {
				addressFlag = false;
				break;
			}
			
			if (addressFlag) {
				System.out.println("Records Inserted Sucessfully!");
			} else {
				System.out.println("Failed to Insert record!");
			}
			stringMap.clear();
			
			String sqlAddressId = "select id from ADDRESS where doorno = ?";
			int addressId = dbm.getAddressId(doorno, sqlAddressId);
			
//			orders
			boolean quantityFlag = true;
			String sqlOrder = "insert into ORDERS(parts_id, address_id, quantity, created_by) values (?, ?, ?, ?)";
			stringMap.put(4, "user");
			intMap.put(1, id);
			intMap.put(2, addressId);
			intMap.put(3, squantity);
			int res1 = dbm.insert(sqlOrder, stringMap,intMap);
				
			if (res1 == 0) {
				quantityFlag = false;
				break;
			}
			
			
			if (quantityFlag) {
				System.out.println("Records Inserted Sucessfully!");
			} else {
				System.out.println("Failed to Insert record!");
			}
			intMap.clear();
			
			String sqlOrdersId = "select id from ORDERS where address_id = ?";
			int OrdersId = dbm.getOrdersId(addressId, sqlOrdersId);
			
			
//			shipment
			boolean shipFlag = true;
			String sqlShip = "insert into SHIPMENT(part_id, address_id, orders_id) values (?, ?, ?, ?)";

			intMap.put(1, id);
			intMap.put(2, addressId);
			intMap.put(3, OrdersId);
			
			int res2 = dbm.insert(sqlOrder, stringMap,intMap);
				
			if (res2 == 0) {
				shipFlag = false;
				break;
			}
			
			if (shipFlag) {
				System.out.println("Records Inserted Sucessfully!");
			} else {
				System.out.println("Failed to Insert record!");
			}
			
			stringMap.clear();
			intMap.clear();

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
