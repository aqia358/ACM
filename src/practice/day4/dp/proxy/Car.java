package practice.day4.dp.proxy;

public class Car implements Move{

	public void run() {
		System.out.println("car is running");
	}

	public void stop() {
		System.out.println("car has stopped");
	}

}
