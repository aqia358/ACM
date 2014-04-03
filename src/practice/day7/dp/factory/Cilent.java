package practice.day7.dp.factory;

public class Cilent {

	public static void abstractFactoryTest(){
		AbstractFactory factory = new FactoryBmw();
		Car c = factory.buildCar();
		CarWithAir ca = factory.buildCarAir();
		c.produce();
		c.consume();
		ca.airOpen();
		ca.airClose();
	}
	
	public static void main(String[] args) {
		abstractFactoryTest();
	}

}
