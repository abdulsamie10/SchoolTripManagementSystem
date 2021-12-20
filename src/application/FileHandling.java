package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Vector;

public class FileHandling extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4138279696894233919L;
	Vector<String> main = new Vector<String>();
	
	public FileHandling(String msg) {
		//main = smain;
		super(msg);
	}
	public void storingdata(Vector<String> smain) {
		main = smain;
	}
	public void retData(Vector<String> smain) {
		smain = main;
	}
	
	public boolean savingTemp(Vector<String> smain) throws SQLException {
		boolean temp =false;
		try {
			Vector<String> tripStat = new Vector<String>();
			UpdateAgencyStatus u = new UpdateAgencyStatus();
			u.change(tripStat);
			BufferedWriter  btw = new BufferedWriter(new FileWriter("temp.txt"));
			for(int i=0;i<8;i++) {
				btw.write(smain.get(i) + "\n");
			}
			btw.write(tripStat.get(0)+"\n");
			btw.write(tripStat.get(1)+"\n");
			btw.write(tripStat.get(3)+"\n");
			btw.write("Time: "+new java.util.Date() + "\n");
			btw.close();
			temp = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}
	
	public boolean updateRecords(String str) throws FileHandling {
		boolean temp = false;
		if(str == null) {
			throw new FileHandling("Any box can't be empty!");
		}
		Vector<String> vec  = new Vector<String>();
		try {
			
			BufferedReader out = new BufferedReader(new FileReader("temp.txt"));
			for(int i=0;i<12;i++) {
				vec.add(out.readLine());
			}
			out.close();
			FileWriter fstream = new FileWriter(str,true);
			BufferedWriter br = new BufferedWriter(fstream);
		//	for(int i=0;i<9;i++) {
				br.write(vec.get(11) + "\n");
				for(int i =0 ;i<11;i++) {
					br.write(vec.get(i) + "\n");
				}
				//br.write(smain.get(i) + "\n");
			//}
			br.close();
			temp = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}
	
}
