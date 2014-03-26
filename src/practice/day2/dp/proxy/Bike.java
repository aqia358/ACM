package practice.day2.dp.proxy;

public class Bike implements Move{

	public void run() {
		System.out.println("Bike is running");
	}

	public void stop() {
		System.out.println("Bike is stopped");
	}

}
