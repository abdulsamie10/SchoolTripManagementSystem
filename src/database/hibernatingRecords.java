package database;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class hibernatingRecords {

	public hibernatingRecords() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String [] args) {
		// loads configuration and creates a session factory
        Configuration con = new Configuration();
        con.configure();
        SessionFactory sf= con.buildSessionFactory();
        Session session= sf.openSession();
        Transaction trans= session.beginTransaction();
        
        records r = new records();
        String txt1 = "The time is: ";
        Date date = Calendar.getInstance().getTime();  
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
        String strDate = dateFormat.format(date);  
        txt1.concat(strDate);
        r.setId(0);
        r.setRec(strDate);
        session.save(r);
        
        trans.commit();
        
	}
}
