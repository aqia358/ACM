package practice.day1.dp.factory;

public class DazhongFactory extends Factory{

	@Override
	public Car buildCar() {
		return new DazhongCar();
	}

}
