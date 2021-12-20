package Multi_Threads;

import database.sLogIn;
import database.schoolsignUp;

public class School_SetUp {

	public School_SetUp() {
		// TODO Auto-generated constructor stub
	}
	
	public void logIn(String name, String pass) {
		sLogIn sch = new sLogIn(name,pass,null);
		Thread th = new Thread(sch);
		th.start();
		return;
	}
	
	public void signUp(String name, String pass, int phone, String address, String email) {
		schoolsignUp s = new schoolsignUp(name,pass,phone,address,email);
		Thread th = new Thread(s);
		th.start();
	}

}
