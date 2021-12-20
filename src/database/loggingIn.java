package database;
import java.sql.*;
import java.util.*;


abstract class persistantHandler{
	public persistantHandler(){	
	}
	abstract boolean AgencyCheck(String name,String password,TravelAgencies t);
	abstract boolean AgencyAdd(TravelAgencies t) throws SQLException;
}

public class loggingIn extends persistantHandler implements Runnable{
	String lname = null,lpass = null;
	Vector<String> name = new Vector<String>();
	Vector<String> pass = new Vector<String>();
	boolean checkT = false;
	Scanner in = new Scanner(System.in);
	public loggingIn(String name, String pass) {
		lname = name;
		lpass = pass;
	}
	
	public boolean AgencyCheck(String sname,String spass,TravelAgencies t) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Successfull!");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stms","root","tiger12345");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from travelagencies");
	
				while(rs.next()) {
					name.add(rs.getString(2));
					pass.add(rs.getString(3));
				}
				con.close();
				
				int temp = 0;
				while(temp < name.size()) {
					if(sname.equals(name.get(temp)) &&  spass.equals(pass.get(temp))) {
						checkT = true;
					}
					temp++;
				}
				
				if(checkT == true) {
					System.out.println("User found!");
				}else {
					System.out.println("User not found!");
					//return false;
					System.exit(0);
				}
				
		} catch (ClassNotFoundException e) {
			return false;
//			e.printStackTrace();
		} catch (SQLException e) {
			return false;
			//			e.printStackTrace();
		}
		return checkT;
	}
	
	boolean AgencyAdd(TravelAgencies t) throws SQLException {
		return true;
	}
	
	
	@Override
	public void run() {
		TravelAgencies t = new TravelAgencies();
		//boolean check = false;
		AgencyCheck(lname,lpass,t);
		return;
	}
	
	public boolean getValue() {
		return checkT;
	}
}


