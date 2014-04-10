package practice.day14.dp.factory;

public class CarAirBMW extends CarAir{

	public void airOpen() {
		System.out.println(" bmw car air open");
	}

	public void airClose() {
		System.out.println(" bmw car air close");
	}

	@Override
	public void produce() {
		System.out.println(" bmw car has been produced");
	}

	@Override
	public void consume() {
		System.out.println(" bmw car has been consumed");
	}

}
