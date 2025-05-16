package controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class JDBC{
	
	static Connection conn = null;
	static Statement statement =null;
	static Scanner sc = new Scanner(System.in);
	
	public int shownMenu() {
		System.out.println("JDBC Connection!");
		System.out.println("\n1.Connect to database.\n2.User table details.\n3.Add record.\n4.Update record.\n5.Exit.");
		return sc.nextInt();
	}
	
	public void jdbcConnection() {
		try {
			conn=DBConnection.getConnection();
			statement = conn.createStatement();
			System.out.println("\n----------------------------------------------------------------------------------------------------------------------------\n");
		}catch(SQLException s) {
			System.out.println(s.getMessage());
		}
	}
	
	public void getUserDetials() {
		try (ResultSet resultSet = statement.executeQuery("SELECT * FROM INV_USER");){
			conn=DBConnection.getConnection();
			statement=conn.createStatement();
			System.out.println("\nUser Detials!!");			
			if (!resultSet.isBeforeFirst()) {
				System.err.println("No Data!");
				System.out.println("\n----------------------------------------------------------------------------------------------------------------------------\n");
				return;
			}
			while(resultSet.next()) {
				int userId = resultSet.getInt("USER_ID");
				String name = resultSet.getString("NAME");
				String userPassword = resultSet.getString("PASSWORD");
				String createdTime = resultSet.getString("CREATE_AT");
				String updatedTime = resultSet.getString("UPDATED_AT");
				System.out.println("User ID\t:\t"+userId+"\nName\t:\t"+name+"\nPassword\t:\t"+userPassword+"\nCreated Time\t:\t"+createdTime+"\nUpdated Time\t:\t"+updatedTime);
			}
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
		System.out.println("\n----------------------------------------------------------------------------------------------------------------------------\n");
	}
	
	public void setRecord() {
		System.out.println("Enter the name : ");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.println("Enter the password : ");
		String password = sc.nextLine();
		String sql = "INSERT INTO INV_USER (NAME, PASSWORD) VALUES (?, ?)";
		try {
			conn=DBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			System.out.println("\nInsert Detials!!");
			pstmt.setString(1, name);
	        pstmt.setString(2, password);

	        int rows = pstmt.executeUpdate(); 

	        if (rows > 0) {
	            System.out.println("Record inserted successfully!");
	        } else {
	            System.err.println("Insert failed. No rows affected.");
	        }
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
		System.out.println("\n----------------------------------------------------------------------------------------------------------------------------\n");
	}
	
	public void updateRecord() {
		System.out.println("Enter the user id : ");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the name : ");
		String name = sc.nextLine();
		System.out.println("Enter the password : ");
		String password = sc.nextLine();
		String sql = "UPDATE INV_USER SET NAME = ?, PASSWORD = ?, UPDATED_AT = GETDATE() WHERE USER_ID = ?";
		try {
			conn=DBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			System.out.println("\nInsert Detials!!");
			pstmt.setString(1, name);
	        pstmt.setString(2, password);
	        pstmt.setInt(3, id);

	        int rows = pstmt.executeUpdate(); 

	        if (rows > 0) {
	            System.out.println("Record updated successfully!");
	        } else {
	            System.err.println("Insert failed. No rows affected.");
	        }
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
		System.out.println("\n----------------------------------------------------------------------------------------------------------------------------\n");
	}
	public void closeConnnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Thank you!");
	}
}