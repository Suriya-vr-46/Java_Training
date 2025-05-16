package controller;
import java.sql.Connection;
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
			System.out.println("\n----------------------------------------------------------------------------------------------------------------------------\n");
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
}
