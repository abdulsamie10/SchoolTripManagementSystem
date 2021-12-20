package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class changeStatus implements Runnable{
	String AgencyID = null;
	public changeStatus(String ID) {
		this.AgencyID = ID;
	}
	
	public void getVector(Vector<String> main) throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Successfull!");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stms","root","tiger12345");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from travelagencies");
			while(rs.next()) {
				main.add(String.valueOf(rs.getInt(1)));
				main.add(rs.getString(2));
				main.add(rs.getString(3));
				main.add(String.valueOf(rs.getInt(4)));
				main.add(String.valueOf(rs.getInt(5)));
			}
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public boolean change() throws SQLException {
		boolean temp = false;
		try {
			Vector<String> smain = new Vector<String>();
			Vector<String> main = new Vector<String>();
			getVector(smain);
			for(int i = 0;i<smain.size();) {
				if(AgencyID.equals(smain.get(i))) {
					main.add(0, smain.get(i));
					main.add(1, smain.get(i+1));
					main.add(2, smain.get(i+2));
					main.add(3, smain.get(i+3));
					main.add(4, smain.get(i+4));
				}
				i = i+5;
			}
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Successfull!-----------------");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stms","root","tiger12345");
			String sql1 = "Update travelagencies Set id =?, name =?, password =?, ph =?, status =? WHERE id =";
			String sql2 = main.get(0);
			String sql = sql1.concat(sql2);
			PreparedStatement statement = con.prepareStatement(sql);
			if(main.get(4).equals("0")){
				System.out.println("Not Update--------------");
				temp = false;
				return temp;
			}else {
				statement.setInt(1, Integer.valueOf(main.get(0)));
				statement.setString(2,main.get(1));
				statement.setString(3,main.get(2));
				statement.setInt(4, Integer.valueOf(main.get(3)));
				statement.setInt(5, 0);
			}
			
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

	@Override
	public void run() {
		try {
			change();
		} catch (SQLException e) {
			System.out.println("Encountered a problem!");
			e.printStackTrace();
		}	
	}
}
