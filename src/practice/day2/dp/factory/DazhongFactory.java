package practice.day2.dp.factory;

public class DazhongFactory extends Factory{

	@Override
	public Car build() {
		return new DazhongCar();
	}

}
