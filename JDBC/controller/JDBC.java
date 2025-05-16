package controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC{
	
	static Connection conn = null;
	static Statement statement =null;
	
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
			while(resultSet.next()) {
				int userId = resultSet.getInt("USER_ID");
				String name = resultSet.getString("NAME");
				String userPassword = resultSet.getString("PASSWORD");
				String createdTime = resultSet.getString("CREATE_AT");
				String updatedTime = resultSet.getString("UPDATED_AT");
				System.out.println("User ID\t:\t"+userId+"\nName\t:\t"+name+"\nPassword\t:\t"+userPassword+"\nCreated Time\t:\t"+createdTime+"\nUpdated Time\t:\t"+updatedTime);
				System.out.println("\n----------------------------------------------------------------------------------------------------------------------------\n");
			}
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void setRecord(String name,String password) {
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
	
	public void updateRecord(int id, String name,String password) {
		String sql = "UPDATE INV_USER SET NAME = ?, PASSWORD = ? WHERE USER_ID = ?";
		try {
			conn=DBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			System.out.println("\nInsert Detials!!");
			pstmt.setString(1, name);
	        pstmt.setString(2, password);
	        pstmt.setInt(3, id);

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
}
