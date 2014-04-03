package practice.day7.dp.factory;

public class FactoryBmw extends AbstractFactory{

	@Override
	public Car buildCar() {
		return new CarBmw();
	}

	@Override
	public CarWithAir buildCarAir() {
		return new CarBmwAir();
	}

}
