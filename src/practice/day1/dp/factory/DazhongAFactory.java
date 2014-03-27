package practice.day1.dp.factory;

public class DazhongAFactory extends AbstractFactory{

	@Override
	public Car buildCar() {
		return new DazhongCar();
	}

	@Override
	public CarAir buildCarAir() {
		return new DazhongCarAir();
	}

}
