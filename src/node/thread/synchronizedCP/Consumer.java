package node.thread.synchronizedCP;

public class Consumer extends Thread{
	private int neednum;
	private Storage storage;
	
	public Consumer(int neednum, Storage storage){
		this.neednum = neednum;
		this.storage = storage;
	}
	
	public void run(){
		storage.consume(neednum);
	}
}
