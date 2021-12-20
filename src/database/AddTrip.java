package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddTrip implements Runnable {

	int id = 0, stat = 0, check = 0, budget = 0;
	String name = null, pass = null, date = null, act = null;
	
	public AddTrip(int tid, String tname, String tpass, String tdate, String tact, int tbudget, int tcheck, int tstat) {
		this.id = tid;
		this.name = tname;
		this.pass = tpass;
		this.act = tact;
		this.date = tdate;
		this.stat = tstat;
		this.check = tcheck;
		this.budget = tbudget;
	}
	
	public boolean adding()  {
		boolean tmp = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Successfull!");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stms","root","tiger12345");
//			Statement stmt = con.createStatement();
//			ResultSet rs = stmt.executeQuery("select * from trips");
			String sql = "INSERT INTO trips (id, origin, destination, activities, date, budget, checks, status) VALUES(?,?,?,?,?,?,?,?)";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, id);
			statement.setString(2,name);
			statement.setString(3,pass);
			statement.setString(4,act);
			statement.setString(5,date);
			statement.setInt(6, budget);
			statement.setInt(7, check);
			statement.setInt(8, stat);
			int rowsInserted = statement.executeUpdate();
			if(rowsInserted>0) {
				tmp = true;
				System.out.println("A new Travel Agency has been added!");
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Encountered a problem!");
			//e.printStackTrace();
		}
		return tmp;
		
	}

	@Override
	public void run() {
		adding();
	}

}
