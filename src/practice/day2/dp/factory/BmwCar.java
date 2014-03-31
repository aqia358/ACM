package practice.day2.dp.factory;

public class BmwCar extends Car{

	@Override
	void build() {
		System.out.println("a bmw have been built");
	}

	@Override
	void sell() {
		System.out.println("bmw price is 999");
	}

}
