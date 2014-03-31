package node.thread.consumerProducer;

public class Producer implements Runnable{

	private Storage storage;
	
	public Producer(Storage storage){
		this.storage = storage;
	}
	
	public void run() {
		for(int i = 0; i < 10; ++i){
			storage.produce();
		}
	}

}
