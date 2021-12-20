package Multi_Threads;
import database.SigningUp;
//package database;
import database.loggingIn;

public class TravelAgency {

	public void login(String name, String pass,boolean check) {
		loggingIn s = new loggingIn(name,pass);
		Thread th = new Thread(s);
		th.start();	
		check = s.getValue();
		return;
	}
	
	public void signup(String name, String pass,int phone) {
		SigningUp s = new SigningUp(name,pass,phone);
		Thread th = new Thread(s);
		th.start();	
	}
}
