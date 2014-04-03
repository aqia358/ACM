package practice.day7.dp.factory;

public class CarBmwAir extends CarWithAir{

	public void airOpen() {
		System.out.println("bmw car air is open");
	}

	public void airClose() {
		System.out.println("bmw car air is close");
	}

	@Override
	public void produce() {
		System.out.println("bmw car air is produced");
	}

	@Override
	public void consume() {
		System.out.println("bmw car air is consume");
	}

}
