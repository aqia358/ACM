package practice.day14.dp.factory;

public class FactoryBMW extends AbstractFactory{

	@Override
	public Car build() {
		return new CarBMW();
	}

	@Override
	public CarAir buildAir() {
		return new CarAirBMW();
	}

}
