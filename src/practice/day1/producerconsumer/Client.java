package practice.day1.producerconsumer;

public class Client {

	public static void CPTest(){
		Storage s = new Storage();
		Consumer c = new Consumer(s);
		Producer p = new Producer(s);
		new Thread(c).start();
		new Thread(p).start();
	}
	
	public static void main(String[] args) {
		CPTest();
	}

}
