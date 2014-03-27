package practice.day1.dp.factory;

/**
 * 因为每增加一种新型车，都要在工厂类中增加相应的创建业务逻辑（createBMW($type)方法需要新增case），
 * 这显然是违背开闭原则的(开放扩展，封闭修改）
 * @author aqia358
 *
 */
public class SimpleFactory{

	public Car buildCar(String name){
		if("dazhong".equals(name)){
			return new DazhongCar();
		}else if("BMW".equals(name)){
			return new BMWCar();
		}
		return new BMWCar();
	}
}
