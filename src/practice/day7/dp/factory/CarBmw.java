package practice.day7.dp.factory;

public class CarBmw extends Car{

	@Override
	public void produce() {
		System.out.println("a bmw has been built");
	}

	@Override
	public void consume() {
		System.out.println("a bmw has been sell");
	}

}
