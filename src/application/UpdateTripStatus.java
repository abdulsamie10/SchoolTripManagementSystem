package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

public class UpdateTripStatus{
	
	Vector<String>main = new Vector<String>();
	public UpdateTripStatus(Vector<String> smain) {
		main = smain;
	}
	
	public boolean updating() throws SQLException {
		boolean temp = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Successfull!-----------------");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stms","root","tiger12345");
			//Statement stmt = con.createStatement();
			//ResultSet rs = stmt.executeQuery("select * from trips");    
			String sql1 = "Update trips Set id =?, origin =?, destination =?, date =?, activities =?, budget =?, checks =?, status=? WHERE id =";
			String sql2 = main.get(0);
			String sql = sql1.concat(sql2);
			for(int i=0;i<8;i++) {
				System.out.println(main.get(i));
			}
			PreparedStatement statement = con.prepareStatement(sql);
			if(Integer.valueOf(main.get(7)) == 1) {
				statement.setInt(1, Integer.valueOf(main.get(0)));
				statement.setString(2,main.get(1));
				statement.setString(3,main.get(2));
				statement.setString(4,main.get(3));
				statement.setString(5,main.get(4));
				statement.setInt(6, Integer.valueOf(main.get(5)));
				statement.setInt(7, Integer.valueOf(main.get(6)));
				statement.setInt(8, 0);
				int rowsInserted = statement.executeUpdate();
				if(rowsInserted>0) {
					System.out.println("---------------UPDATED------------------");
					temp = true;
				}else {
					System.out.println("Not Update--------------");
				}
			}else {
				System.out.println("Trip is already in use!");
				temp = false;
				return temp;
			}
			//statement.setInt(9, 0);
			
		} catch (ClassNotFoundException e) {
			System.out.println("Encountered a problem!");
			e.printStackTrace();
		}
		return temp;		
	}
}














