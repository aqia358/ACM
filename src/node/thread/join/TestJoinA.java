package node.thread.join;

public class TestJoinA {
	public static void main(String[] args) {
		Thread t = new Thread(new TestRunnableImpl());
		t.start();
		try {
			t.join(10000); // 主线程只等1秒，不管子线程什么时候结束
			System.out.println("joinFinish");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class TestRunnableImpl implements Runnable {
	public void run() {
		try {
			System.out.println("Begin sleep");
			// 如果改成sleep(2000), 那么主线程就会先结束
			Thread.sleep(1000);
			System.out.println("End sleep");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}