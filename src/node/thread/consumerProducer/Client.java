package node.thread.consumerProducer;

public class Client {

	public static void cpTest(){
		Storage storage = new Storage();
		Consumer consumer = new Consumer(storage);
		Producer producer = new Producer(storage);
		new Thread(consumer).start();
		new Thread(producer).start();
	}
	
	public static void main(String[] args) {
		cpTest();
	}

}
