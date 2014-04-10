package practice.day14.dp.factory;

public class CarBMW extends Car{

	@Override
	public void produce() {
		System.out.println("a bmw has been produced");
	}

	@Override
	public void consume() {
		System.out.println("a bmw has been sell");
	}

}
