package node.thread.consumerProducer;

public class Storage3 {

	private boolean isFull;

	public synchronized void produce() {
		if (!isFull) {
			isFull = true;
			System.out.println("produce and fill the storage");
			System.out.println("wait for consume");
			notify();
		}
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void consume() {
		if (!isFull) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("cosume from storage");
		System.out.println("wait for produce");
		isFull = false;
		notify();
	}

}
