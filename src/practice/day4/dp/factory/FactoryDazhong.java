package practice.day4.dp.factory;

public class FactoryDazhong extends Factory{

	@Override
	public Car build() {
		return new CarDazhong();
	}

	@Override
	public void sell() {
		
	}

}
