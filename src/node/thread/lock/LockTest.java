package node.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
	Lock lock = new ReentrantLock();
	double value = 0d;
	int addTimes = 0;

	public void addValue(double v) {
		lock.lock();
		System.out.println("LockTest to addValue: " + v + " "
				+ System.currentTimeMillis());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.value += v;
		this.addTimes++;
		lock.unlock();
	}

	public double getValue() {
		return this.value;
	}
}
