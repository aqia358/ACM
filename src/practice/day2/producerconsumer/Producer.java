package practice.day2.producerconsumer;

public class Producer implements Runnable{

	private Storage storage;
	
	public Producer(Storage s){
		this.storage = s;
	}
	
	public void run() {
		for(int i = 0; i < 10; ++i){
			storage.produce();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
