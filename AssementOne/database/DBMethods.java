package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class DBMethods {
	static Connection conn = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	static PreparedStatement pstmt = null;
	static DBConnection db = new DBConnection();
	
	public int getConnection() {
		conn = db.getConnection();
		if(conn == null) {
			return 0;
		}
		return 1;
	}
	
	public int getUserId(String sql) {
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {				
				return rs.getInt("id");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}
	
	public String getUserPass(String sql) {
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				return rs.getString("password");				
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public boolean findParts(int id, String sql) {
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);			
			rs = pstmt.executeQuery();	
			if(rs.next()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public boolean findPart(int id, String sql) {
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);			
			rs = pstmt.executeQuery();	
			if(rs.next()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public void softDelete(int id, String sql) {
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			int rows = pstmt.executeUpdate();
			if(rows > 0) {
				System.out.println("Deleted record sucessfully!");
			} else {
				System.out.println("Failed to Delete a record!");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void setQuantity(int id,int quantity, String sql) {
		int qut = 0;
		String name = null;
		String number = null;
		String description = null;
		
		try {
			String sqll = "select name, number, quantity, description from PART where id = ?";
			pstmt = conn.prepareStatement(sqll);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				name = rs.getString("name");
				number = rs.getString("number");
				qut = rs.getInt("quantity");
				description = rs.getString("description");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, quantity+qut);
			pstmt.setInt(2, id);
			int rows = pstmt.executeUpdate();
			if(rows > 0) {
				System.out.println("Updated record sucessfully!");
			} else {
				System.out.println("Failed to Delete a record!");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		boolean quantityFlag = true;
		String sqlParts = "insert into PARTS(name, number, description, created_by) values (?, ?, ?, ?);";
		for (int i = 1; i <= quantity; i++) {

			HashMap<Integer, String> stringMap = new HashMap<>();
			stringMap.put(1, name);
			stringMap.put(2, number);
			stringMap.put(3, description);
			stringMap.put(4, "user");
			
			DBMethods t = new DBMethods(); 
			int res = t.insert(sqlParts, stringMap);			

			if (res == 0) {
				quantityFlag = false;
			}
		}
		
		if (quantityFlag) {
			System.out.println("Records Inserted Sucessfully!");
		} else {
			System.out.println("Failed to Insert record!");
		}
	}
	
	public int getAddressId(String doorno, String sql) {
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, doorno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt("id");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}
	
	public int getOrdersId(int addressId, String sql) {
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, addressId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt("id");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}
	
	public void getAllPart(String sql) {
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			boolean flag = false;
			while(rs.next()) {
				flag = true;
				System.out.println("ID\t\t:\t"+rs.getInt("id"));
				System.out.println("Name\t:\t"+rs.getString("name"));
				System.out.println("Number\t:\t"+rs.getString("number"));
				System.out.println("Quantity\t:\t"+rs.getInt("quantity"));
				System.out.println("Description\t:\t"+rs.getString("description"));
				System.out.println("Created At\t:\t"+rs.getString("created_at"));
				System.out.println("Created By\t:\t"+rs.getString("created_by"));
				System.out.println("Updated At\t:\t"+rs.getString("updated_at"));
				System.out.println("\n-------------------------------------------------------------------------------------------------------\n");
			}
			if(!flag) {
				System.out.println("No record found!");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void getAllParts(String sql) {
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			boolean flag = false;
			while(rs.next()) {
				flag = true;
				System.out.println("ID\t\t\t:\t"+rs.getInt("id"));
				System.out.println("Name\t\t:\t"+rs.getString("name"));
				System.out.println("Number\t\t:\t"+rs.getString("number"));
				System.out.println("Description\t:\t"+rs.getString("description"));
				System.out.println("Created At\t:\t"+rs.getString("created_at"));
				System.out.println("Created By\t:\t"+rs.getString("created_by"));
				System.out.println("Updated At\t:\t"+rs.getString("updated_at"));
				System.out.println("\n-------------------------------------------------------------------------------------------------------\n");
			}
			if(!flag) {
				System.out.println("No record found!");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public int insert(String stmt,HashMap<Integer,String> stringMap,HashMap<Integer,Integer> intMap) {
		try {
			pstmt = conn.prepareStatement(stmt);
			
			for(Integer id : stringMap.keySet()) {
				pstmt.setString(id, stringMap.get(id));
			}
			
			for(Integer id : intMap.keySet()) {
				pstmt.setInt(id, intMap.get(id));
			}			
			
			return pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}
	
	public int insert(String stmt,HashMap<Integer,String> stringMap) {
		try {
			pstmt = conn.prepareStatement(stmt);
			
			for(Integer id : stringMap.keySet()) {
				pstmt.setString(id, stringMap.get(id));
			}		
			
			return pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}
}
