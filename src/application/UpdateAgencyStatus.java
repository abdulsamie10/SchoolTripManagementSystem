package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class UpdateAgencyStatus {

	public UpdateAgencyStatus() {
		// TODO Auto-generated constructor stub
	}
	
	public void getVector(Vector<String> main) throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Successfull!");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stms","root","tiger12345");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from travelagencies");
			while(rs.next()) {
				if(rs.getInt(5) == 0) {
					main.add(String.valueOf(rs.getInt(1)));
					main.add(rs.getString(2)); 
					main.add(rs.getString(3));
					main.add(String.valueOf(rs.getInt(4)));
					main.add(String.valueOf(rs.getInt(5)));
				}
			}
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public boolean change(Vector<String> main ) throws SQLException {
		boolean temp = true;
		try {
			getVector(main);
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Successfull!-----------------");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stms","root","tiger12345");
			String sql1 = "Update travelagencies Set id =?, name =?, password =?, ph =?, status =? WHERE id =";
			String sql2 = main.get(0);
			String sql = sql1.concat(sql2);
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, Integer.valueOf(main.get(0)));
			statement.setString(2,main.get(1));
			statement.setString(3,main.get(2));
			statement.setInt(4, Integer.valueOf(main.get(3)));
			statement.setInt(5, 1);
			int rowsInserted = statement.executeUpdate();
			if(rowsInserted>0) {
				System.out.println("---------------UPDATED------------------");
				temp = true;
			}else {
				System.out.println("Not Update--------------");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Encountered a problem!");
			e.printStackTrace();
		}	
		return temp;
	}
	public boolean change2(Vector<String> main ) throws SQLException {
		boolean temp = true;
		try {
			getVector(main);
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Successfull!-----------------");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stms","root","tiger12345");
			String sql1 = "Update travelagencies Set id =?, name =?, password =?, ph =?, status =? WHERE id =";
			String sql2 = main.get(0);
			String sql = sql1.concat(sql2);
			if(main.get(4).equals("0")) {
				PreparedStatement statement = con.prepareStatement(sql);
				statement.setInt(1, Integer.valueOf(main.get(0)));
				statement.setString(2,main.get(1));
				statement.setString(3,main.get(2));
				statement.setInt(4, Integer.valueOf(main.get(3)));
				statement.setInt(5, 1);
				int rowsInserted = statement.executeUpdate();
				if(rowsInserted>0) {
					System.out.println("---------------UPDATED------------------");
					temp = true;
				}else {
					System.out.println("Not Update--------------");
				}
			}else {
				return false;
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("Encountered a problem!");
			return false;
			//e.printStackTrace();
		}	
		return temp;
	}

}
