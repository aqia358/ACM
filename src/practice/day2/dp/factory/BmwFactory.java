package practice.day2.dp.factory;

public class BmwFactory extends Factory{

	@Override
	public Car build() {
		return new BmwCar();
	}

}
