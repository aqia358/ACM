package node.thread;

public class MyThreadRunnable implements Runnable{

	private int count = 100;
	private String name;
	
	public MyThreadRunnable(String name){
		this.name = name;
	}

	public void run() {
		test();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void count(){
		while(count > 0){
			count --;
			System.out.println(name+" "+Thread.currentThread().getName()+":"+count);
		}
	}
	
	public static synchronized void test(){
		for(int i = 0; i < 100; ++i){
			System.out.println(Thread.currentThread().getName()+" :"+i);
		}
	}

}
