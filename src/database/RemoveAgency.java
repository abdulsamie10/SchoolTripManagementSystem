package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RemoveAgency implements Runnable{
	String AgencyID = null;
	
	public RemoveAgency(String ID) {
		AgencyID = ID;
	}
	
	public boolean removing()  {
		int value = Integer.valueOf(AgencyID);
		boolean temp = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Successfull!");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stms","root","tiger12345");
			String sql = "DELETE FROM travelagencies WHERE id=?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(0, value);
			int rowsInserted = statement.executeUpdate();
			if(rowsInserted>0) {
				temp = true;
				System.out.println("Agency Removed!");
			}
		} catch (ClassNotFoundException | SQLException e) {
			return false;
			//System.out.println("Encountered a problem!");
			//e.printStackTrace();
		}
		return temp;
	}

	@Override
	public void run() {
		removing();
	}
}

//class threadRemove{
//	threadRemove(){
//	}
//	
//	public void remove(String ID) {
//		RemoveAgency r = new RemoveAgency(ID);
//		Thread th = new Thread(r);
//		th.start();
//	}
//}
