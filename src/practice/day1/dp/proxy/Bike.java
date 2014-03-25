package practice.day1.dp.proxy;

public class Bike implements Moveable{

	public void move() {
		System.out.println("Bike is moving");
	}

	public void stop() {
		System.out.println("Bike has been stopped");
	}

}
