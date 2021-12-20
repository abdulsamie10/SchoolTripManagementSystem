package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class SigningUp extends persistantHandler implements Runnable{
	String sname = null, spass = null;
	int sphone = 0;
	boolean checkT = false;
	//Vector<Integer> ph = new Vector<Integer>();
	Scanner in = new Scanner(System.in);
	public SigningUp(String name, String pass, int phone) {
		sname = name;
		spass = pass;
		sphone = phone;
	}

	

	//@Override
	public boolean AgencyAdd(TravelAgencies t){
		boolean temp = false;
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Successfull!");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stms","root","tiger12345");
			Random random = new Random();
			int Uid = random.nextInt(100000000);       //Agency ID
			String sql = "INSERT INTO travelagencies (id, name, password, ph, status) VALUES(?,?,?,?,?)";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, Uid);
			statement.setString(2,sname);
			statement.setString(3,spass);
			statement.setInt(4, sphone);
			statement.setInt(5, 0);
			int rowsInserted = statement.executeUpdate();
			if(rowsInserted>0) {
				System.out.println("A new Travel Agency has been added!");
				temp = true;
			}else {
				System.out.println("User not found!");
				System.exit(0);
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

	boolean AgencyCheck(String name, String password, TravelAgencies t) {
		return checkT;
	}
	
	@Override
	public void run() {
		TravelAgencies t = new TravelAgencies();
		AgencyAdd(t);
	}
}
