package practice.day1.dp.factory;

/**
 * 抽象工厂模式和工厂方法模式的区别就在于需要创建对象的复杂程度上。
 * 而且抽象工厂模式是三个里面最为抽象、最具一般性的。 
 * @author aqia358
 *
 */
public abstract class AbstractFactory {
	
	public abstract Car buildCar();
	public abstract CarAir buildCarAir();
}
