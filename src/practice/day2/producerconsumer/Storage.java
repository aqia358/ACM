package practice.day2.producerconsumer;

public class Storage {

	public boolean isFull;
	
	public synchronized void produce(){
		if(!isFull){
			isFull = true;
			System.out.println("the storage is full");
			System.out.println("wait for consumer");
			this.notify();
		}
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void consumer(){
		if(isFull){
			isFull = false;
			System.out.println("storage has been consumed");
			System.out.println("wait for produce");
			this.notify();
		}
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
