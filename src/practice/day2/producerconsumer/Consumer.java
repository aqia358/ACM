package practice.day2.producerconsumer;

public class Consumer implements Runnable{

	private Storage storage;
	
	public Consumer(Storage s){
		this.storage = s;
	}
	
	public void run() {
		for(int i = 0; i < 10; ++i){
			storage.consumer();
		}
	}

}
