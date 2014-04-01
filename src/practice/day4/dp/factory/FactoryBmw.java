package practice.day4.dp.factory;

public class FactoryBmw extends Factory{

	@Override
	public Car build() {
		return new CarBMW();
	}

	@Override
	public void sell() {
		
	}

}
