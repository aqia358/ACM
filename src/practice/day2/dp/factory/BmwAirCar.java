package practice.day2.dp.factory;

public class BmwAirCar extends AirCar{

	public void airOpen() {
		System.out.println("bmw air open");
	}

	public void airClose() {
		System.out.println("bmw air close");
	}

	@Override
	void build() {
		System.out.println("bmw build");
	}

	@Override
	void sell() {
		System.out.println("bmw sell");
	}

}
