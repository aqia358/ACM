package node.thread;

public class Client {

	/**
	 * 第二个线程也是通过t1去访问run()方法，所以必须等第一个线程执行完才能获得对象锁
	 */
	public static void testThreadLock(){
		ThreadSynchronized t1 = new ThreadSynchronized();
		new Thread(t1, "t1").start();
		new Thread(t1, "t2").start();
	}
	/**
	 * 两个线程都是通过各自的对象去访问run()方法（t1,t2)，所以有两把对象锁，这两个对象锁毫不相干
	 * 所以各自执行各自的方法没有共享资源
	 * 在synchronized方法上加上static，它锁的是synchronized方法所在对象对应的Class对象
	 * 即：所以的线程都共享这个方法，而且同一时刻只有一个线程能够执行这个方法
	 */
	public static void testThreadLock2(){
		ThreadSynchronized t1 = new ThreadSynchronized();
		ThreadSynchronized t2 = new ThreadSynchronized();
		new Thread(t1, "t1").start();
		new Thread(t2, "t2").start();
	}
	
	public static void main(String[] args) {
//		testThreadLock();
		testThreadLock2();
//		MyThread t1 = new MyThread("thread 1");
//		MyThread t2 = new MyThread("thread 2");
//		t1.start();
//		t2.start();
//		MyThreadRunnable my = new MyThreadRunnable("thread runnable 1");
//		Thread tr0 = new Thread(my,"num 0");
//		Thread tr1 = new Thread(my,"num 1");
//		Thread tr2 = new Thread(new MyThreadRunnable("thread runnable 2"));
//		tr2.start();
//		tr0.start();
//		tr1.start();
	}

}
