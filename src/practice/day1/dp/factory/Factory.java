package practice.day1.dp.factory;

/**
 * 当产品种类非常多时，会出现大量的与之对应的工厂对象，这不是我们所希望的
 * 使用简单工厂模式与工厂方法模式相结合的方式来减少工厂类：即对于产品树上类似的种类
 * （一般是树的叶子中互为兄弟的）使用简单工厂模式来实 现
 * @author aqia358
 *
 */
public abstract class Factory {
	
	public abstract Car buildCar();
}
