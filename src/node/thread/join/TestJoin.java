package node.thread.join;

public class TestJoin {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Thread ta = new Thread(new A());
		Thread tb = new Thread(new B(ta));
		ta.start();
		tb.start();
	}

}
class A implements Runnable{
	public void run() {
		for(int i = 0; i < 10; ++i){
			System.out.println("thread a is running");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class B implements Runnable{
	
	private Thread a;
	public B (Thread a){
		this.a = a;
	}
	public void run() {
		System.out.println("thread b is running");
		try {
			Thread.sleep(2000);
			a.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("thread b end");
	}
	
}
