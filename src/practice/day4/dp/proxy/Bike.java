package practice.day4.dp.proxy;

public class Bike implements Move{

	public void run() {
		System.out.println("Bike is running");
	}

	public void stop() {
		System.out.println("Bike has stopped");
	}

}
