package practice.day1.dp.factory;

public class BMWCar extends Car{

	public BMWCar(){}
	
	@Override
	public void build() {
		System.out.println("a BMW has been build");
	}

	@Override
	public void sell() {
		System.out.println("BMW price is 999");
	}

}
