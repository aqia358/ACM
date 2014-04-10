package practice.day14.dp.factory;

public class Client {

	public static void simpleFactoryTest(){
		SimpleFactory factory = new SimpleFactory();
		Car bmw = factory.build("CarBMW");
		bmw.produce();
		Car dazhong = factory.build("CarDazhong");
		dazhong.produce();
		Car b = factory.buildCar("practice.day14.dp.factory.CarBMW");
		System.out.println("-----------");
		b.consume();
		System.out.println("-----------");
	}
	
	public static void abstractFactoryTest(){
		AbstractFactory factory = new FactoryBMW();
		Car bmw = factory.build();
		CarAir bmwAir = factory.buildAir();
		bmw.consume();
		bmwAir.airClose();
		
	}
	public static void main(String[] args) {
		simpleFactoryTest();
		abstractFactoryTest();
	}

}
