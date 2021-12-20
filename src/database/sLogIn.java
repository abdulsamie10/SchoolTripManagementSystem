package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

//import org.hibernate.internal.build.AllowSysOut;

public class sLogIn extends Exception implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4249283022010292371L;
	Vector<String> Vname = new Vector<String>();
	Vector<String> Vpass = new Vector<String>();
	String name;
	String password;
	boolean checkS = false;
	public sLogIn(String sname, String spass, String msg) {
		super(msg);
		name = sname;
		password = spass;
		// TODO Auto-generated constructor stub
	}
	
	public boolean logIn() throws SQLException, sLogIn {
		if(name == null || password == null) {
			throw new sLogIn("Encountered a problem!", null, null);
		}
		boolean tmp = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Successfull!");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stms","root","tiger12345");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from schools");
			
			while(rs.next()) {
				Vname.add(rs.getString(2));
				Vpass.add(rs.getString(3));
			}
			con.close();
			
			int temp = 0;
			while(temp < Vname.size()) {
				if(name.equals(Vname.get(temp)) &&  password.equals(Vpass.get(temp))) {
					System.out.println("User found!");
					tmp = true;
				}
				temp++;
			}
			if(tmp == false) {
				System.out.println("User not found!");
				System.exit(0);
				
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return tmp;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			logIn();
			//check = getCheck();
			return;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (sLogIn e) {
			e.printStackTrace();
		}
	}
	
	

}
