package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

public class TripAdd {

	public TripAdd() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean AddTrip(Vector<String> main) {
		boolean temp = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Successfull!");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stms","root","tiger12345");
			String sql = "INSERT INTO trips (id, origin, destination, date, activities, budget, checks, status) VALUES(?,?,?,?,?,?,?,?)";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, Integer.valueOf(main.get(0)));
			statement.setString(2,main.get(1));
			statement.setString(3,main.get(2));
			statement.setString(4,main.get(3));
			statement.setString(5,main.get(4));
			statement.setInt(6, Integer.valueOf(main.get(5)));
			statement.setInt(7, Integer.valueOf(main.get(6)));
			statement.setInt(8, Integer.valueOf(main.get(7)));
			int rowsInserted = statement.executeUpdate();
			if(rowsInserted>0) {
				temp = true;
				System.out.println("A new trip has been added!");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Encountered a problem!");
			return false;
			//e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Encountered a problem!");
			return false;
			//e.printStackTrace();
		}
		return temp;
	}

}
