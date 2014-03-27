package node.thread.synchronizedCP;

public class ConsumerAndProductorThread {

	public static void main(String[] args) {
		Storage storage = new Storage(40, 100);

		for (int i = 0; i < 5; i++) {
			Consumer c = new Consumer(60 + i, storage);
			c.start();
		}

		Producer p1 = new Producer(10, storage);
		Producer p2 = new Producer(20, storage);
		Producer p3 = new Producer(30, storage);
		Producer p4 = new Producer(40, storage);
		Producer p5 = new Producer(15, storage);
		Producer p6 = new Producer(25, storage);
		Producer p7 = new Producer(35, storage);
		Producer p8 = new Producer(45, storage);
		Producer p9 = new Producer(49, storage);
		Producer p10 = new Producer(51, storage);

		p1.start();
		p2.start();
		p3.start();
		p4.start();
		p5.start();
		p6.start();
		p7.start();
		p8.start();
		p9.start();
		p10.start();
	}

}
