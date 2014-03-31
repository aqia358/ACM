package practice.day2.dp.factory;

public class BmwAFactory extends AbstractFactory{

	@Override
	public Car buildCar() {
		return new BmwCar();
	}

	@Override
	public AirCar buildAirCar() {
		return new BmwAirCar();
	}

}
