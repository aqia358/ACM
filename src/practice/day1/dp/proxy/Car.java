package practice.day1.dp.proxy;

public class Car implements Moveable{
	
	public void move() {
		System.out.println("Car is moving");
	}

	public void stop() {
		System.out.println("Car has been stopped");
	}

}
