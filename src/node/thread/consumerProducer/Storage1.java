package node.thread.consumerProducer;

public class Storage1 {

	public static Object signal = new Object();
	private boolean isFull;

	public void produce() {
		synchronized (signal) {
			if (!isFull) {
				isFull = true;
				System.out.println("produce and fill the storage");
				signal.notify();
			}
			try {
				System.out.println("wait for consume");
				signal.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void consume() {
		synchronized (signal) {
			if (!isFull) {
				System.out.println("wait for produce");
				try {
					signal.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("cosume from storage");
			isFull = false;
			signal.notify();
		}
	}

}
