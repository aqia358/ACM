package practice.day2.dp.factory;

public class Client {

	public static void simpleFactoryTest(){
		Car c = SimpleFactory.build("BMW");
		c.build();
		c.sell();
	}
	
	public static void factoryTest(){
		Factory bmwFactory = new BmwFactory();
		Car bmw = bmwFactory.build();
		bmw.build();
		bmw.sell();
	}
	
	public static void abstractFactoryTest(){
		AbstractFactory factory = new BmwAFactory();
		factory.buildCar();
		factory.buildAirCar();
	}
	
	public static void main(String[] args) {
		simpleFactoryTest();
		factoryTest();
		abstractFactoryTest();
	}

}
