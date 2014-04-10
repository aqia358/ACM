package practice.day14.dp.factory;

public class CarAirDazhong extends CarAir{

	public void airOpen() {
		System.out.println("dazhong car air is open");
	}

	public void airClose() {
		System.out.println("dazhong car air is close");
	}

	@Override
	public void produce() {
		System.out.println("dazhong car air has been produced");
	}

	@Override
	public void consume() {
		System.out.println("dazhong car air has been consumed");
	}

}
