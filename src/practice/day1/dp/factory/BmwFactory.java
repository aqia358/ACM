package practice.day1.dp.factory;

public class BmwFactory extends Factory{

	@Override
	public Car buildCar() {
		return new BMWCar();
	}

}
