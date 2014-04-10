package practice.day14.dp.factory;

public class CarDazhong extends Car{

	@Override
	public void produce() {
		System.out.println("a dazhong has been produced");
	}

	@Override
	public void consume() {
		System.out.println("a dazhong has been sell");
	}

}
