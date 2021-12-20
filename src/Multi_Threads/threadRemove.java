package Multi_Threads;

import database.RemoveAgency;

public class threadRemove {

	public threadRemove() {
		// TODO Auto-generated constructor stub
	}
	public void remove(String ID) {
		RemoveAgency r = new RemoveAgency(ID);
		Thread th = new Thread(r);
		th.start();
	}

}
