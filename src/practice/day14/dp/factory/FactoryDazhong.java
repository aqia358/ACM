package practice.day14.dp.factory;

public class FactoryDazhong extends AbstractFactory{

	@Override
	public Car build() {
		return new CarDazhong();
	}

	@Override
	public CarAir buildAir() {
		return new CarAirDazhong();
	}

}
