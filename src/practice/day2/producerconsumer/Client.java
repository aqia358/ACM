package practice.day2.producerconsumer;

public class Client {

	public static void CPTest(){
		Storage s = new Storage();
		Consumer c = new Consumer(s);
		Producer p = new Producer(s);
		new Thread(p).start();
		new Thread(c).start();
	}
	
	public static void main(String[] args) {
		CPTest();
	}

}
