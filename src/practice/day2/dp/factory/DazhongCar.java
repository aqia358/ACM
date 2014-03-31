package practice.day2.dp.factory;

public class DazhongCar extends Car{

	@Override
	void build() {
		System.out.println("a dazhong has been built");
	}

	@Override
	void sell() {
		System.out.println("dazhong price is 8888");
	}

}
