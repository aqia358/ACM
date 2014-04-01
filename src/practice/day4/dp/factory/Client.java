package practice.day4.dp.factory;

public class Client {

	public static void factoryTest(){
		Factory f = new FactoryBmw();
		Car c = f.build();
		c.build();
	}
	
	public static void simpleFactoryTest(){
		try {
			Car c = SimpleFactory.build("practice.day4.dp.factory.CarBMW");
			c.build();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		factoryTest();
		simpleFactoryTest();
	}

}
