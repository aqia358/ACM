package practice.day1.producerconsumer;

public class Storage {

	private boolean isFull;
	
	public synchronized void produce(){
		if(!isFull){
			System.out.println("storage has been fill full");
			isFull = true;
			System.out.println("wait consumter");
			notify();
		}
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void consume(){
		if(isFull){
			System.out.println("storage has been consume");
			isFull = false;
			System.out.println("wait peoeucer");
			notify();
		}
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
