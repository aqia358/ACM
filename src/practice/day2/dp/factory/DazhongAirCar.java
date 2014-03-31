package practice.day2.dp.factory;

public class DazhongAirCar extends AirCar{

	public void airOpen() {
		System.out.println("dazhong air open");
	}

	public void airClose() {
		System.out.println("dazhong air close");
	}

	@Override
	void build() {
		System.out.println("dazhong air car build");
	}

	@Override
	void sell() {
		System.out.println("dazhong air car sell");
	}

}
