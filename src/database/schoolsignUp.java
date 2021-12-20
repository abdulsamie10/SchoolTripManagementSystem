package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class schoolsignUp implements Runnable{
	public String name = null, pass = null, address = null, email = null;
	int phone = 0;
	public schoolsignUp(String sname, String spass, int sphone, String saddress, String semail){
		name = sname;
		pass = spass;
		phone= sphone;
		address = saddress;
		email = semail;
	}
	 public boolean SignUp() {
		 boolean tmp = false;
		 try { 
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Successfull!");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stms","root","tiger12345");
				Random random = new Random();
				int Uid = random.nextInt(100000000); 
				String sql = "INSERT INTO schools (id, name, password, ph, address, email) VALUES(?,?,?,?,?,?)";
				PreparedStatement statement = con.prepareStatement(sql);
				statement.setInt(1, Uid);
				statement.setString(2,name);
				statement.setString(3,pass);
				statement.setInt(4, phone);
				statement.setString(5,address);
				statement.setString(6,email);
				int rowsInserted = statement.executeUpdate();
				if(rowsInserted>0) {
					tmp = true;
					System.out.println("A new School has been added!");
				}else {
					System.out.println("Encountered a problem!");
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
		 return tmp;
	    }
	@Override
	public void run() {
		SignUp();
	}
}
