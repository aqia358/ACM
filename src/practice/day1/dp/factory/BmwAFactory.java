package practice.day1.dp.factory;

public class BmwAFactory extends AbstractFactory{

	@Override
	public Car buildCar() {
		return new BMWCar();
	}

	@Override
	public CarAir buildCarAir() {
		return new BmwCarAir();
	}

}
