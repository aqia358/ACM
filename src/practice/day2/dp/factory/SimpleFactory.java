package practice.day2.dp.factory;

public class SimpleFactory {

	public static Car build(String name){
		if("BMW".equals(name)){
			return new BmwCar();
		}else{
			return new DazhongCar();
		}
	}
}
