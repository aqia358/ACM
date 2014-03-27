package node.thread.synchronizedCP;

public class Producer extends Thread {

	private int neednum;
	private Storage storage;
	
	public Producer(int neednum, Storage storage){
		this.neednum = neednum;
		this.storage = storage;
	}
	
	public void run(){
		storage.produce(neednum);
	}
}
