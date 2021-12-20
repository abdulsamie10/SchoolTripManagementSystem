package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class SaveTripVector{
	public Vector<String> origin = new Vector<String>();
	public Vector<String> destination = new Vector<String>();
	public Vector<String> date = new Vector<String>();
	public Vector<String> activities = new Vector<String>();
	public Vector<Integer> budget = new Vector<Integer>();
	public Vector<Integer> id = new Vector<Integer>();
	public Vector<Integer> checks = new Vector<Integer>();
	public Vector<Integer> status = new Vector<Integer>();
	
	public void loadingData() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Successfull!");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stms","root","tiger12345");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from trips");
			
			
			while(rs.next()) {
				
				id.add(rs.getInt(1));
				origin.add(rs.getString(2));
				destination.add(rs.getString(3));
				activities.add(rs.getString(4));
				date.add(rs.getString(5));
				budget.add(rs.getInt(6));
				checks.add(rs.getInt(7));
				status.add(rs.getInt(8));
			}
			con.close();
			//System.out.println(budget.size());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
	}
	
	public void byBudget(Vector<String> val) throws SQLException {
		int temp = 0;
		loadingData();
		//System.out.println(status.get(1));
		while(temp<budget.size()) {
			if(status.get(temp)==1) {
				val.add(String.valueOf(id.get(temp)));
				val.add(origin.get(temp));
				val.add(destination.get(temp));
				val.add(date.get(temp));
				val.add(activities.get(temp));
				val.add(String.valueOf(budget.get(temp)));
				val.add(String.valueOf(checks.get(temp)));
				val.add(String.valueOf(status.get(temp)));
			}
			temp++;
		}
	}
//		static class check{
//		public static void main(String[] args) throws SQLException {
//			Vector<String> vec = new Vector<String>();
//			SaveTripVector s = new SaveTripVector();
//			s.byBudget(vec);
//			System.out.println(vec.size());
//		}
//	}
	
}


