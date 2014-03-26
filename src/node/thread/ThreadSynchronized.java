package node.thread;

public class ThreadSynchronized implements Runnable{

	public static int a;
	public void run() {
		synchronized ("flag") {
			
		}
		while(a < 20){
			count();
		}
	}
	
	public static synchronized void count(){
		try {
			a++;
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName()+" :"+a);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
