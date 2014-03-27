package practice.day1.dp.factory;

public class Client {

	public static void simpleFactoryTest(){
		SimpleFactory sf = new SimpleFactory();
		Car c = sf.buildCar("BMW");
		c.sell();
	}
	
	public static void factoryTest(){
		Factory dazhongFactory = new DazhongFactory();
		Car dazhong = dazhongFactory.buildCar();
		dazhong.sell();
		Factory bmwFactory = new BmwFactory();
		Car bmw = bmwFactory.buildCar();
		bmw.sell();
	}
	
	public static void abstractFactoryTest(){
		AbstractFactory dazhongFactory = new DazhongAFactory();
		Car dazhong  = dazhongFactory.buildCar();
		CarAir dazhongAir = dazhongFactory.buildCarAir();
		dazhong.sell();
		dazhongAir.conditionOpen();
		
		AbstractFactory bmwFactory = new BmwAFactory();
		Car bmw = bmwFactory.buildCar();
		CarAir bmwAir = bmwFactory.buildCarAir();
		bmw.sell();
		bmwAir.conditionClose();
	}
	
	public static void classForNameTest(){
		try {
			Car c = (Car)Class.forName("practice.day1.dp.factory.BMWCar").newInstance();
			c.build();
			c.sell();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		simpleFactoryTest();
		factoryTest();
		abstractFactoryTest();
		classForNameTest();
	}
}
