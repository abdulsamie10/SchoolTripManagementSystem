package testcases;

import java.sql.SQLException;
import java.util.Vector;

import org.junit.jupiter.api.Test;

import application.UpdateAgencyStatus;
import application.UpdateTripStatus;
import database.AddTrip;
import database.RemoveAgency;
import database.SigningUp;
import database.TravelAgencies;
import database.TripAdd;
import database.loggingIn;
import database.sLogIn;
import database.schoolsignUp;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
class casesJUnit {
//	@Before

	@Test
	void test1() throws SQLException {
		AddTrip ad = new AddTrip(12345443,"Lahore","Islamabad","12-12-2021","Hiking + Sking + Bornfire", 150000,4,1);
		boolean temp = true;
		Assert.assertEquals(temp, ad.adding());
		//ad.adding();
		//fail("Not yet implemented");
	}
	
	@Test
	void test2() throws SQLException {
		AddTrip ad = new AddTrip(12345443,"Lahore","Islamabad","12-12-2021","Hiking + Sking + Bornfire", 150000,4,1);
		boolean temp = false;
		Assert.assertEquals(temp, ad.adding());
		//ad.adding();
		//fail("Not yet implemented");
	}
	
	@Test
	void test3() throws SQLException {
		Vector<String> main = new Vector<String>();
		main.add("13231");
		main.add("wqwqr");
		main.add("eqwewq");
		main.add("3435435");
		main.add("wqtefsdf");
		main.add("34435");
		main.add("4");
		main.add("1");
		UpdateTripStatus u = new UpdateTripStatus(main);
		//u.updating();
		Assert.assertEquals(true, u.updating());
	}
	
	@Test
	void test4() throws SQLException {
		Vector<String> main = new Vector<String>();
		main.add("13231");
		main.add("wqwqr");
		main.add("eqwewq");
		main.add("3435435");
		main.add("wqtefsdf");
		main.add("34435");
		main.add("4");
		main.add("0");
		UpdateTripStatus u = new UpdateTripStatus(main);
		//u.updating();
		Assert.assertEquals(false, u.updating());
	}
	
	@Test
	void test5() throws SQLException {
		UpdateAgencyStatus u = new UpdateAgencyStatus();
		Vector<String> main = new Vector<String>();
		//u.change(main);
		Assert.assertEquals(true, u.change(main));		
	}
	
	@Test
	void test6() throws SQLException {
		UpdateAgencyStatus u = new UpdateAgencyStatus();
		Vector<String> main = new Vector<String>();
		//u.change(main);
		main.add("1234");
		main.add("samie");
		main.add("samie");
		main.add("12344");
		main.add("0");
		Assert.assertEquals(true, u.change2(main));
	}
	
	@Test
	void test7() throws SQLException {
		UpdateAgencyStatus u = new UpdateAgencyStatus();
		Vector<String> main = new Vector<String>();
		//u.change(main);
		main.add("1234");
		main.add("samie");
		main.add("samie");
		main.add("12344");
		main.add("1");
		Assert.assertEquals(false, u.change2(main));
	}
	@Test
	void test8() throws SQLException, sLogIn {
		sLogIn s = new sLogIn("samie","samie",null);
		Assert.assertEquals(true, s.logIn());
	}
	
	
	@Test
	void test9() throws SQLException, sLogIn {
		sLogIn s = new sLogIn("samiesada","samasfasie",null);
		Assert.assertEquals(false, s.logIn());
	}
	
	@Test
	void test10() {
		SigningUp s = new SigningUp("hanz","hanz",132344255);
		TravelAgencies t = new TravelAgencies();
		Assert.assertEquals(true, s.AgencyAdd(t));
	}
	
	@Test
	void test11() {
		SigningUp s = new SigningUp("hanz","hanz",132344255);
		TravelAgencies t = new TravelAgencies();
		Assert.assertEquals(false, s.AgencyAdd(t));
	}
	
	
	@Test
	void test12() {
		loggingIn l = new loggingIn("samie","samie");
		Assert.assertEquals(true, l.AgencyCheck("samie", "samie", null));
	}
	
	@Test
	void test13() {
		loggingIn l = new loggingIn("sasdasmie","sasdasamie");
		Assert.assertEquals(true, l.AgencyCheck("sasdasamie", "sasdasamie", null));
	}
	
	@Test
	void test14() {
		schoolsignUp s = new schoolsignUp("aps","aps",033311122,"peshawer","@aps");
		Assert.assertEquals(true, s.SignUp());
	}
	
	@Test
	void test15() {
		schoolsignUp s = new schoolsignUp("aps","aps",033311122,"peshawer","@aps");
		Assert.assertEquals(false, s.SignUp());
	}
	
	@Test
	void test16() {
		RemoveAgency r = new RemoveAgency("1234");
		Assert.assertEquals(false, r.removing());
	}
	
	@Test
	void test17() {
		RemoveAgency r = new RemoveAgency("1423423");
		Assert.assertEquals(false, r.removing());
	}
	
	@Test
	void test18() {
		Vector<String> vec = new Vector<String>();
		vec.add("121234");
		vec.add("Peshawer");
		vec.add("Karachi");
		vec.add("12-12-2021");
		vec.add("Roaming");
		vec.add("112300");
		vec.add("5");
		vec.add("1");
		TripAdd t = new TripAdd();
		Assert.assertEquals(true, t.AddTrip(vec));
	}
	
	@Test
	void test19() {
		Vector<String> vec = new Vector<String>();
		vec.add("121234");
		vec.add("Peshawer");
		vec.add("Karachi");
		vec.add("12-12-2021");
		vec.add("Roaming");
		vec.add("112300");
		vec.add("5");
		vec.add("1");
		TripAdd t = new TripAdd();
		Assert.assertEquals(false, t.AddTrip(vec));
	}
}
