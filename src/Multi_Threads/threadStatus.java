package Multi_Threads;

import database.changeStatus;

public class threadStatus {

	public threadStatus() {
		
	}
	
	public void changeStatus(String ID) {
		changeStatus u = new changeStatus(ID);
		Thread th = new Thread(u);
		th.start();
	}

}
