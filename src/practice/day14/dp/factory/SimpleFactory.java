package practice.day14.dp.factory;

public class SimpleFactory {

	public Car build(String type){
		if("CarBMW".equals(type)){
			return new CarBMW();
		}else{
			return new CarDazhong();
		}
	}
	
	public Car buildCar(String path){
		Car c = null;
		try {
			c =  (Car) Class.forName(path).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c; 
	}
}
