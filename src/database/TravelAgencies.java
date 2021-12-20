package database;
import java.util.Scanner;

public class TravelAgencies {
	Scanner in = new Scanner(System.in);
	
	public TravelAgencies() {
		
	}
	
	public int TravelCheck() {
		System.out.println("1. Log in");
		System.out.println("2. Sign up");
		int check = 0; //This check is for Travel Agencies only
		check = in.nextInt();
		return check;
	}

}
