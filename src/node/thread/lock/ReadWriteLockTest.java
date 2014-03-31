package node.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {
	ReadWriteLock lock = new ReentrantReadWriteLock();
	double value = 0d;
	int addtimes = 0;

	public void addValue(double v) {
		Lock writeLock = lock.writeLock();
		writeLock.lock();
		System.out.println("ReadWriteLockTest to addValue: " + v
				+ System.currentTimeMillis());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			this.value += v;
			this.addtimes++;
		} finally {
			writeLock.unlock();
		}
	}

	public String getInfo() {
		Lock readLock = lock.readLock();
		readLock.lock();
		System.out.println("ReadWritezLockTest to getInfo "
				+ System.currentTimeMillis());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			return this.value + " : " + this.addtimes;
		} finally {
			readLock.unlock();
		}
	}

}
