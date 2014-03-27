package practice.day1.dp.factory;

public class DazhongCar extends Car{

	@Override
	public void build() {
		System.out.println("a dazhong has been built");
	}

	@Override
	public void sell() {
		System.out.println("dazhong price is 8888");
	}

}
